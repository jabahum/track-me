package com.lyecdevelopers.trackme.di.modules.account

import androidx.lifecycle.ViewModel
import com.lyecdevelopers.trackme.ui.account.login.LoginViewModel
import com.lyecdevelopers.trackme.ui.account.register.RegisterViewModel
import com.lyecdevelopers.trackme.di.Key.ViewModelKey

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


/**
 * created by jaba
 */
@Module
abstract class AccountViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(viewModel: LoginViewModel?): ViewModel?

    @Binds
    @IntoMap
    @ViewModelKey(RegisterViewModel::class)
    abstract fun bindRegisterViewModel(viewModel: RegisterViewModel?): ViewModel?
}