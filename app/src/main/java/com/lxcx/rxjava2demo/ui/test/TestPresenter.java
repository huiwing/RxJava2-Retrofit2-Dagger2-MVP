package com.lxcx.rxjava2demo.ui.test;

import com.lxcx.rxjava2demo.bean.TestBean;
import com.lxcx.rxjava2demo.http.Callback;
import com.lxcx.rxjava2demo.http.test.TestService;
import com.lxcx.rxjava2demo.ui.base.BasePresenter;

import javax.inject.Inject;

/**
 * TestPresenter
 * Created by ArmyAntAndroid on 2017/11/17.
 */

public class TestPresenter extends BasePresenter<TestContract.View> implements TestContract.Presenter {

    private TestService service;

    @Inject
    public TestPresenter(TestService service){
        this.service = service;
    }

    @Override
    public void fetchData(int page) {
        invoke(service.getData(page,15),new Callback<TestBean>(){
            @Override
            public void onResponse(TestBean data) {
                mView.hData(data);
            }
        });
    }
}
