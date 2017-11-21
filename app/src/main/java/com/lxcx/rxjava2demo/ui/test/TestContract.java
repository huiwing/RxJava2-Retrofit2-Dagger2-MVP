package com.lxcx.rxjava2demo.ui.test;

import com.lxcx.rxjava2demo.bean.PhoneBean;
import com.lxcx.rxjava2demo.bean.TestBean;
import com.lxcx.rxjava2demo.ui.base.BaseView;

/**
 * TestContract
 * Created by ArmyAntAndroid on 2017/11/17.
 */

public interface TestContract {
    interface View extends BaseView{
        void hData(TestBean data);
        void phoneInfo(PhoneBean data);
    }
    interface Presenter{
        void fetchData(int page);
        void getPhoneInfo(String phone);
    }
}
