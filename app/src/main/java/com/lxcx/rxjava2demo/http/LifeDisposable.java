package com.lxcx.rxjava2demo.http;



import io.reactivex.disposables.Disposable;

/**
 * LifeDisposable
 * Created by ArmyAntAndroid on 2017/11/17.
 */

public interface LifeDisposable {
    void bindDisposable(Disposable disposable);
}
