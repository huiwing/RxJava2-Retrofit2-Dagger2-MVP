package com.lxcx.rxjava2demo.ui.test;

import android.util.Log;
import android.widget.Toast;

import com.lxcx.rxjava2demo.R;
import com.lxcx.rxjava2demo.bean.PhoneBean;
import com.lxcx.rxjava2demo.bean.TestBean;
import com.lxcx.rxjava2demo.injector.module.http.TestHttpModule;
import com.lxcx.rxjava2demo.rx.RxBus;
import com.lxcx.rxjava2demo.rx.RxMsgBean;
import com.lxcx.rxjava2demo.ui.base.BaseDefaultActivity;

import butterknife.OnClick;

/**
 * TestActivity
 * Created by ArmyAntAndroid on 2017/11/17.
 */

public class TestActivity extends BaseDefaultActivity<TestPresenter> implements TestContract.View {

    @OnClick(R.id.text)
    void click() {
        RxBus.getDefault().post(new RxMsgBean("msg", 1, 1));
    }

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
        RxBus.getDefault().register(RxMsgBean.class).subscribe(s -> {
            Log.d("text", "------------>" + s);
            if (s.getCode() == 1) {
                Toast.makeText(TestActivity.this, s.getMsg(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void initData() {
    }

    @Override
    public void hData(TestBean data) {
        Log.d("TAG", "data--->" + data);
    }

    @Override
    public void phoneInfo(PhoneBean data) {
        Log.d("TAG", "data--->" + data);
    }

    @Override
    protected void loadData() {
        mPresenter.getPhoneInfo("15949581550");
    }
}
