package com.lxcx.rxjava2demo.injector.component;

import android.app.Activity;

import com.lxcx.rxjava2demo.injector.module.FragmentModule;
import com.lxcx.rxjava2demo.injector.scope.FragmentScope;

import dagger.Component;

/**
 * FragmentComponent
 * Created by ArmyAntAndroid on 2017/11/17.
 */

@FragmentScope
@Component(dependencies = AppComponent.class,modules = FragmentModule.class)
public interface FragmentComponent {
    Activity getActivity();
}
