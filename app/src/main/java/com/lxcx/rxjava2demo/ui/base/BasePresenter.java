package com.lxcx.rxjava2demo.ui.base;

import com.lxcx.rxjava2demo.app.MyCommon;
import com.lxcx.rxjava2demo.http.utils.Callback;
import com.lxcx.rxjava2demo.http.utils.HttpUtils;
import com.lxcx.rxjava2demo.http.utils.LifeDisposable;
import com.lxcx.rxjava2demo.http.utils.Stateful;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.List;

import io.reactivex.Observable;

/**
 * BasePresenter
 * Created by ArmyAntAndroid on 2017/11/17.
 */

public class BasePresenter<T extends BaseView> {
    private Reference<T> mReferenceView;
    protected T mView;
    private Callback callback;

    @SuppressWarnings("unchecked")
    public void attachView(LifeDisposable mLifeDisposable) {
        this.mReferenceView = new WeakReference<>((T) mLifeDisposable);
        mView = mReferenceView.get();
    }

    protected <E> void invoke(Observable<E> observable, Callback<E> callback) {
        this.callback = callback;
        HttpUtils.invoke((LifeDisposable) mView, observable, callback);
    }

    /**
     * 检查数据是否为空
     *
     * @param list
     */
    public void checkState(List list) {
        if (list.size() == 0) {
            if (mView instanceof Stateful) {
                ((Stateful) mView).setState(MyCommon.STATE_EMPTY);
            }
        }
    }

    /**
     * 回收资源
     */
    public void detachView() {
        if (mReferenceView != null) {
            mReferenceView.clear();
            mReferenceView = null;
        }
        if (mView != null) {
            mView = null;
        }
        if (callback != null) {
            callback.detachView();
        }
    }

}
