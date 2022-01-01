package com.lyecdevelopers.trackme.di.modules.walkthrough

import com.lyecdevelopers.trackme.ui.walkthrough.WalkThroughFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * created by jaba
 */
@Module
abstract class WalkThroughBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeWalkThroughFragment(): WalkThroughFragment?
}