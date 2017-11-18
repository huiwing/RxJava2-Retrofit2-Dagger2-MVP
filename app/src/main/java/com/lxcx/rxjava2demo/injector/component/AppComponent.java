package com.lxcx.rxjava2demo.injector.component;

import com.lxcx.rxjava2demo.app.App;
import com.lxcx.rxjava2demo.injector.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ArmyAntAndroid on 2017/11/17.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    App getContext();
}
