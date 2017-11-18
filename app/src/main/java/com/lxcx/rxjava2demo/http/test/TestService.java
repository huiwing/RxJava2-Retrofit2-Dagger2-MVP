package com.lxcx.rxjava2demo.http.test;

import com.lxcx.rxjava2demo.bean.TestBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ArmyAntAndroid on 2017/11/17.
 */

public interface TestService {
    @GET("article/article/{page}/{count}")
    Observable<TestBean> getData(@Path("page")int page,@Path("count")int count);
}
