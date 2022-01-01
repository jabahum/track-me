package com.lyecdevelopers.trackme.di.modules.account

import com.lyecdevelopers.trackme.data.remote.login.LoginApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


/**
 * created by jaba
 */
@Module
class AccountModule {
    @AccountScope
    @Provides
    fun provideLoginApi(retrofit: Retrofit): LoginApi {
        return retrofit.create(LoginApi::class.java)
    }


}