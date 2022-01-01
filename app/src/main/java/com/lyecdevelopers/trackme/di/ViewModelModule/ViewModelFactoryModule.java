package com.lyecdevelopers.trackme.di.ViewModelModule;

import androidx.lifecycle.ViewModelProvider;


import com.lyecdevelopers.trackme.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

/**
 * created by jaba
 */
@Module
public abstract class ViewModelFactoryModule {
    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelProviderFactory);
}
