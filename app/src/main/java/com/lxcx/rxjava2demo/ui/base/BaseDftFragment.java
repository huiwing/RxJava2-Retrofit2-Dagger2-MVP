package com.lxcx.rxjava2demo.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lxcx.rxjava2demo.http.LifeDisposable;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * BaseDftFragment
 * Created by ArmyAntAndroid on 2017/11/24.
 */

public abstract class BaseDftFragment<T extends BasePresenter> extends BaseFragment
        implements LifeDisposable {
    @Inject
    T mPresenter;

    private CompositeDisposable compositeDisposable;

    protected abstract void initInject();

    protected abstract void loadData();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void onVisible() {
        if (isFirst) {
            initInject();
            if (mPresenter != null) {
                mPresenter.attachView(this);
            }
        }
        initData();
    }

    @Override
    protected void initData() {
        if (!mIsVisible || !isPrepared || !isFirst) {
            return;
        }
        loadData();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @Override
    public void bindDisposable(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }
}
