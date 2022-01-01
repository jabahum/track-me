package com.lyecdevelopers.trackme.di.modules.splash

import com.lyecdevelopers.trackme.ui.splash.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * created by jaba
 */

@Module
abstract class SplashBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeSplashFragment(): SplashFragment?
}