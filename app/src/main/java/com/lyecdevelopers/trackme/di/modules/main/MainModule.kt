package com.lyecdevelopers.trackme.di.modules.main

import com.lyecdevelopers.trackme.data.remote.endpoints.main.MainApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


/**
 * created by jaba
 */

@Module
class MainModule {
    @MainScope
    @Provides
    fun provideMainApi(retrofit: Retrofit): MainApi {
        return retrofit.create(MainApi::class.java)
    }

}