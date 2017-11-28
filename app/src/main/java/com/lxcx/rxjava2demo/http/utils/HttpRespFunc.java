package com.lxcx.rxjava2demo.http.utils;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * HttpRespFunc
 * Created by ArmyAntAndroid on 2017/11/27.
 */

public class HttpRespFunc<T> implements Function<Throwable, Observable<T>> {
    @Override
    public Observable<T> apply(Throwable throwable) throws Exception {
        //Log.e("HttpRespFunc", "throwable-------->" + throwable);
        return Observable.error(FactoryException.analysisException(throwable));
    }
}
