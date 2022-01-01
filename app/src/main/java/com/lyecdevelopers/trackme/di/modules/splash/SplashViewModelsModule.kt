package com.lyecdevelopers.trackme.di.modules.splash

import androidx.lifecycle.ViewModel
import com.lyecdevelopers.trackme.ui.splash.SplashViewModel
import com.lyecdevelopers.trackme.di.Key.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


/**
 * created by jaba
 */
@Module
abstract class SplashViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(viewModel: SplashViewModel?): ViewModel?
}