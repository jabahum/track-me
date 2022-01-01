package com.lyecdevelopers.trackme.di.modules.walkthrough

import androidx.lifecycle.ViewModel
import com.lyecdevelopers.trackme.ui.walkthrough.WalkThroughViewModel
import com.lyecdevelopers.trackme.di.Key.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


/**
 * created by jaba
 */
@Module
abstract class WalkThroughViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(WalkThroughViewModel::class)
    abstract fun bindWalkThroughViewModel(viewModel: WalkThroughViewModel?): ViewModel?
}