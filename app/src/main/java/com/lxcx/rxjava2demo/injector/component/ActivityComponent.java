package com.lxcx.rxjava2demo.injector.component;

import android.app.Activity;

import com.lxcx.rxjava2demo.injector.module.ActivityModule;
import com.lxcx.rxjava2demo.injector.scope.ActivityScope;

import dagger.Component;

/**
 * ActivityComponent
 * Created by ArmyAntAndroid on 2017/11/17.
 */

@ActivityScope
@Component(dependencies = AppComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {
    Activity getActivity();
}
