package com.lxcx.rxjava2demo.ui.test;

import com.lxcx.rxjava2demo.app.MyCommon;
import com.lxcx.rxjava2demo.bean.RespBean;
import com.lxcx.rxjava2demo.bean.TestBean;
import com.lxcx.rxjava2demo.http.utils.Callback;
import com.lxcx.rxjava2demo.http.test.TestService;
import com.lxcx.rxjava2demo.ui.base.BasePresenter;

import java.net.ConnectException;

import javax.inject.Inject;

/**
 * TestPresenter
 * Created by ArmyAntAndroid on 2017/11/17.
 */

public class TestPresenter extends BasePresenter<TestContract.View> implements TestContract.Presenter {

    private TestService service;

    @Inject
    public TestPresenter(TestService service) {
        this.service = service;
    }

    @Override
    public void fetchData(int page) {
        invoke(service.getData(page, 15), new Callback<TestBean>() {
            @Override
            public void onResponse(TestBean data) {
                mView.hData(data);
            }
        });
    }

    @Override
    public void getPhoneInfo(String phone) {
        try {
            throw new ConnectException();
        } catch (ConnectException e) {
           // e.printStackTrace();
        }
        invoke(service.getPhoneInfo(phone, MyCommon.API_KEY), new Callback<RespBean>() {
            @Override
            public void onResponse(RespBean data) {
                mView.phoneInfo(data.getResult());
            }
        });
    }


}
