package com.lxcx.rxjava2demo.ui.test;

import com.lxcx.rxjava2demo.injector.module.http.TestHttpModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * TestComponent
 * Created by ArmyAntAndroid on 2017/11/17.
 */

@Singleton
@Component(modules = TestHttpModule.class)
public interface TestComponent {
    void inject(TestActivity activity);
}
