package com.lxcx.rxjava2demo.rx;

import io.reactivex.Flowable;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.PublishProcessor;
import io.reactivex.subscribers.SerializedSubscriber;

/**
 * RxBus
 * Created by ArmyAntAndroid on 2017/11/24.
 */

public class RxBus {
    private final FlowableProcessor<Object> mBus;
    private static volatile RxBus instance = null;

    private RxBus() {
        mBus = PublishProcessor.create().toSerialized();
    }

    public static synchronized RxBus getDefault() {
        if (instance == null) {
            synchronized (RxBus.class) {
                if (instance == null) {
                    instance = new RxBus();
                }
            }
        }
        return instance;
    }

    /**
     * 发送
     *
     * @param obj
     */
    public void post(Object obj) {
        new SerializedSubscriber<>(mBus).onNext(obj);
    }

    /**
     * 接收
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> Flowable<T> register(Class<T> clazz) {
        return mBus.ofType(clazz);
    }

    public Flowable<Object> register() {
        return mBus;
    }

    /**
     * 终止所有
     */
    public void unRegisterAll() {
        mBus.onComplete();
    }

    /**
     * 判断是否有订阅者
     *
     * @return
     */
    public boolean hasSubscribers() {
        return mBus.hasSubscribers();
    }
}
