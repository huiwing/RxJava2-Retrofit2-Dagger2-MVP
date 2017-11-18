package com.lxcx.rxjava2demo.injector.module;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.lxcx.rxjava2demo.injector.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * FragmentModule
 * Created by ArmyAntAndroid on 2017/11/17.
 */

@Module
public class FragmentModule {
    private Fragment fragment;

    public FragmentModule(Fragment fragment){
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    public Activity provideActivity(){
        return fragment.getActivity();
    }

}
