package com.lxcx.rxjava2demo.app;

import android.app.Application;

import com.blankj.utilcode.utils.Utils;


/**
 * App
 * Created by ArmyAntAndroid on 2017/11/17.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
