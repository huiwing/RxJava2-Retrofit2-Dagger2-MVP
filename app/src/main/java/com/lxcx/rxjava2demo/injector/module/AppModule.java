package com.lxcx.rxjava2demo.injector.module;

import com.lxcx.rxjava2demo.app.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ArmyAntAndroid on 2017/11/17.
 */
@Module
public class AppModule {
    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    App provideApplicationContext() {
        return application;
    }
}
