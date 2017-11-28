package com.lxcx.rxjava2demo.http.utils;


import com.blankj.utilcode.utils.NetworkUtils;
import com.blankj.utilcode.utils.ToastUtils;
import com.lxcx.rxjava2demo.app.MyCommon;
import com.lxcx.rxjava2demo.bean.PhoneBean;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * HttpUtils
 * Created by ArmyAntAndroid on 2017/11/17.
 */

public class HttpUtils {
    public static <T> void invoke(LifeDisposable lifecycle, Observable<T> observable, Callback<T> callback) {
        Stateful target = null;
        if (lifecycle instanceof Stateful) {
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

        observable.subscribeOn(Schedulers.io())//订阅者要在主线程执行
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new HttpRespFunc<>())
                .subscribe(callback);
        lifecycle.bindDisposable(callback);

    }
}
