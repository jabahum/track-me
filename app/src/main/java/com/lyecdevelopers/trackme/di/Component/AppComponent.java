package com.lyecdevelopers.trackme.di.Component;


import android.app.Application;


import com.lyecdevelopers.trackme.di.modules.AppModule;
import com.lyecdevelopers.trackme.TrackMe;
import com.lyecdevelopers.trackme.di.BuildersModule.ActivityBuildersModule;
import com.lyecdevelopers.trackme.di.ViewModelModule.ViewModelFactoryModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * created by jaba
 */
@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBuildersModule.class,
        AppModule.class,
        ViewModelFactoryModule.class,
})
public interface AppComponent extends AndroidInjector<TrackMe> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
