package com.lyecdevelopers.trackme.di.modules.main

import com.lyecdevelopers.trackme.ui.main.MainFragment
import com.lyecdevelopers.trackme.ui.main.discover.VegetablesFragment
import com.lyecdevelopers.trackme.ui.main.home.HomeFragment
import com.lyecdevelopers.trackme.ui.main.profile.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * created by jaba
 */
@Module
abstract class MainBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment?

    @ContributesAndroidInjector
    abstract fun contributeVegetablesFragment(): VegetablesFragment?

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment?

    @ContributesAndroidInjector
    abstract fun contributeProfileFragment(): ProfileFragment?


}