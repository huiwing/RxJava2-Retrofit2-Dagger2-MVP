package com.lxcx.rxjava2demo.ui.test;

import android.util.Log;

import com.lxcx.rxjava2demo.R;
import com.lxcx.rxjava2demo.bean.TestBean;
import com.lxcx.rxjava2demo.injector.module.http.TestHttpModule;
import com.lxcx.rxjava2demo.ui.base.BaseDefaultActivity;

/**
 * Created by ArmyAntAndroid on 2017/11/17.
 */

public class TestActivity extends BaseDefaultActivity<TestPresenter> implements TestContract.View{
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEvent() {
        DaggerTestComponent.builder()
                .testHttpModule(new TestHttpModule())
                .build().inject(this);
    }

    @Override
    protected void initData() {
        mPresenter.fetchData(1);
    }

    @Override
    public void hData(TestBean data) {
        Log.d("TAG","data--->"+data);
    }
}
