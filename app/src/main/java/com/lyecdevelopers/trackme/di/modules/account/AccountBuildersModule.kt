package com.lyecdevelopers.trackme.di.modules.account

import com.lyecdevelopers.trackme.ui.account.login.LoginFragment
import com.lyecdevelopers.trackme.ui.account.register.RegisterFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * created by jaba
 */
@Module
abstract class AccountBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeLoginFragment(): LoginFragment?

    @ContributesAndroidInjector
    abstract fun contributeRegisterFragment(): RegisterFragment?
}