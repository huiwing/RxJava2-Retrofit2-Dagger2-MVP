package com.lxcx.rxjava2demo.http;

import android.util.Log;

import io.reactivex.observers.DisposableObserver;


/**
 * Callback
 * Created by ArmyAntAndroid on 2017/11/17.
 */

public class Callback<T> extends DisposableObserver<T> {
    private static final String TAG = "Callback";
    private Stateful target;
    public void setTarget(Stateful target){
        this.target = target;
    }

    public void detachView(){
        if(target!=null){
            target = null;
        }
    }

    @Override
    public void onNext(T t) {
        onResponse(t);
        Log.i(TAG,"-----onNext-----");
    }

    @Override
    public void onError(Throwable e) {
        Log.i(TAG,"-----onError-----");
        e.printStackTrace();
    }

    @Override
    public void onComplete() {
        Log.i(TAG,"-----onCompleted-----");
    }

    public void onResponse(T data){
    }

}
