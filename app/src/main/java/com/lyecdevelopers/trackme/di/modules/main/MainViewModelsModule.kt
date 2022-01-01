package com.lyecdevelopers.trackme.di.modules.main

import androidx.lifecycle.ViewModel
import com.lyecdevelopers.trackme.di.Key.ViewModelKey
import com.lyecdevelopers.trackme.ui.main.MainViewModel
import com.lyecdevelopers.trackme.ui.main.discover.VegetablesViewModel
import com.lyecdevelopers.trackme.ui.main.home.HomeViewModel
import com.lyecdevelopers.trackme.ui.main.profile.ProfileViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


/**
 * created by jaba
 */
@Module
abstract class MainViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel?): ViewModel?


    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel?): ViewModel?

    @Binds
    @IntoMap
    @ViewModelKey(VegetablesViewModel::class)
    abstract fun bindVegetablesViewModel(viewModel: VegetablesViewModel?): ViewModel?

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    abstract fun bindProfileViewModel(viewModel: ProfileViewModel?): ViewModel?

}