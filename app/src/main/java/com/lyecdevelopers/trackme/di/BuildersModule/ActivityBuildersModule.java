package com.lyecdevelopers.trackme.di.BuildersModule;

import com.lyecdevelopers.trackme.di.modules.account.AccountBuildersModule;
import com.lyecdevelopers.trackme.di.modules.account.AccountModule;
import com.lyecdevelopers.trackme.di.modules.account.AccountViewModelsModule;
import com.lyecdevelopers.trackme.di.modules.main.MainBuildersModule;
import com.lyecdevelopers.trackme.di.modules.main.MainModule;
import com.lyecdevelopers.trackme.di.modules.main.MainViewModelsModule;
import com.lyecdevelopers.trackme.di.modules.splash.SplashBuildersModule;
import com.lyecdevelopers.trackme.di.modules.splash.SplashModule;
import com.lyecdevelopers.trackme.di.modules.splash.SplashViewModelsModule;
import com.lyecdevelopers.trackme.di.modules.walkthrough.WalkThroughBuildersModule;
import com.lyecdevelopers.trackme.di.modules.walkthrough.WalkThroughModule;
import com.lyecdevelopers.trackme.di.modules.walkthrough.WalkThroughViewModelsModule;
import com.lyecdevelopers.trackme.ui.account.AccountActivity;
import com.lyecdevelopers.trackme.ui.main.MainActivity;
import com.lyecdevelopers.trackme.ui.splash.SplashActivity;
import com.lyecdevelopers.trackme.ui.walkthrough.WalkThroughActivity;
import com.lyecdevelopers.trackme.di.modules.account.AccountScope;
import com.lyecdevelopers.trackme.di.modules.main.MainScope;
import com.lyecdevelopers.trackme.di.modules.splash.SplashScope;
import com.lyecdevelopers.trackme.di.modules.walkthrough.WalkThroughScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * created by jaba
 */
@Module
public abstract class ActivityBuildersModule {

    @MainScope
    @ContributesAndroidInjector(modules = {
            MainBuildersModule.class,
            MainModule.class,
            MainViewModelsModule.class,
    })
    abstract MainActivity contributeMainActivity();


    @AccountScope
    @ContributesAndroidInjector(modules = {
            AccountBuildersModule.class,
            AccountModule.class,
            AccountViewModelsModule.class,

    })

    abstract AccountActivity contributeAccountActivity();

    @SplashScope
    @ContributesAndroidInjector(modules = {

            SplashBuildersModule.class,
            SplashModule.class,
            SplashViewModelsModule.class,

    })

    abstract SplashActivity contributeSplashActivity();

    @WalkThroughScope
    @ContributesAndroidInjector(modules = {
            WalkThroughBuildersModule.class,
            WalkThroughModule.class,
            WalkThroughViewModelsModule.class,
    })

    abstract WalkThroughActivity contributeWalkThroughActivity();
}
