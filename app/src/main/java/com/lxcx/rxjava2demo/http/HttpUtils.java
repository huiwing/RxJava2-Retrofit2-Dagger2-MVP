package com.lxcx.rxjava2demo.http;


import com.blankj.utilcode.utils.NetworkUtils;
import com.blankj.utilcode.utils.ToastUtils;
import com.lxcx.rxjava2demo.app.MyCommon;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * HttpUtils
 * Created by ArmyAntAndroid on 2017/11/17.
 */

public class HttpUtils {
    public static <T> void invoke(LifeDisposable lifecycle, Observable<T> observable, Callback<T> callback){
        Stateful target = null;
        if (lifecycle instanceof Stateful){
            target = (Stateful) lifecycle;
            callback.setTarget(target);
        }
        if (!NetworkUtils.isConnected()) {
            ToastUtils.showShortToast("网络连接已断开");
            if (target != null) {
                target.setState(MyCommon.STATE_ERROR);
            }
            return;
        }

        Disposable disposable = observable.subscribeOn(Schedulers.io())//订阅者要在主线程执行
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(callback);
            lifecycle.bindDisposable(disposable);

    }
}
