package com.lxcx.rxjava2demo.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

/**
 * BaseDefaultActivity
 * Created by ArmyAntAndroid on 2017/11/17.
 */

public abstract class BaseDefaultActivity<T extends BasePresenter> extends BaseActivity {

    @Inject
    protected T mPresenter;

    protected abstract void initData();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.attachView(this);
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter!=null){
            mPresenter.detachView();
        }
    }
}
