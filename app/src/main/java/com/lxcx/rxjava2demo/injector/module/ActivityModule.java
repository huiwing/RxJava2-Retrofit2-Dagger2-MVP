package com.lxcx.rxjava2demo.injector.module;

import android.app.Activity;

import com.lxcx.rxjava2demo.injector.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ArmyAntAndroid on 2017/11/17.
 */

@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity){
        this.mActivity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity(){
        return mActivity;
    }

}
