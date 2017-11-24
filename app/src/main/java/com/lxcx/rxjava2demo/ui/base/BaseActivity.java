package com.lxcx.rxjava2demo.ui.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lxcx.rxjava2demo.http.LifeDisposable;


import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * BaseActivity
 * Created by ArmyAntAndroid on 2017/11/17.
 */

public abstract class BaseActivity extends AppCompatActivity implements LifeDisposable {
    public static BaseActivity activity;
    private Unbinder unbinder;
    private CompositeDisposable composite;

    @LayoutRes
    protected abstract int getLayoutId();

    /**
     * 初始化View
     */
    protected abstract void initView();

    /**
     * 初始化事件
     */
    protected abstract void initEvent();

    /**
     * 初始化数据(加载初始数据)
     */
    protected abstract void initData();

    @Override
    protected void onResume() {
        super.onResume();
        activity = this;
    }

    @Override
    protected void onPause() {
        super.onPause();
        activity = null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
        if (composite != null && composite.size() > 0) {
            composite.clear();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        initView();
        initEvent();
        initData();
    }

    @Override
    public void bindDisposable(Disposable disposable) {
        if (composite == null) {
            composite = new CompositeDisposable();
        }
        composite.add(disposable);
    }

}
