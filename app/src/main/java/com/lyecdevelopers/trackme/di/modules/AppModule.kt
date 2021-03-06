package com.lyecdevelopers.trackme.di.modules

import android.app.Application
import com.lyecdevelopers.trackme.BuildConfig
import com.lyecdevelopers.trackme.data.local.db.PureGrowDatabase
import com.lyecdevelopers.trackme.data.local.db.user.LocalUserDataSource
import com.lyecdevelopers.trackme.data.local.db.user.UserDataSource
import com.lyecdevelopers.trackme.data.local.pref.PreferenceManager
import com.lyecdevelopers.trackme.data.local.rx.AppSchedulerProvider
import dagger.Module
import dagger.Provides
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


/**
 * created by jaba
 */
@Module
class AppModule {


    @Singleton
    @Provides
    fun provideRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(setLogging())
            .build()
    }

    @Provides
    @Singleton
    fun setLogging(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .readTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(120, TimeUnit.SECONDS)
            .connectTimeout(120, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .cookieJar(object : CookieJar {
                private val cookieStore = HashMap<HttpUrl, List<Cookie>>()
                override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
                    cookieStore[url] = cookies
                }

                override fun loadForRequest(url: HttpUrl): List<Cookie> {
                    val cookies = cookieStore[url]
                    return cookies ?: ArrayList()
                }
            })
            .build()
    }

    @Singleton
    @Provides
    fun providerAppSchedulerProvider(): AppSchedulerProvider {
        return AppSchedulerProvider()
    }


    @Singleton
    @Provides
    fun provideUserDataSource(database: PureGrowDatabase): UserDataSource? {
        return database.userDao()?.let { LocalUserDataSource(it) }
    }


    @Singleton
    @Provides
    fun database(context: Application?): PureGrowDatabase? {
        return context?.let { PureGrowDatabase.getInstance(it) }
    }

    @Singleton
    @Provides
    fun providerPreferenceManger(application: Application): PreferenceManager {
        return PreferenceManager(application)
    }
}