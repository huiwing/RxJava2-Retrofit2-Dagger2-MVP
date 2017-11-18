package com.lxcx.rxjava2demo.injector.module.http;

import com.lxcx.rxjava2demo.http.test.TestService;
import com.lxcx.rxjava2demo.injector.qualifier.TestUrl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * TestHttpModule
 * Created by ArmyAntAndroid on 2017/11/17.
 */
@Module
public class TestHttpModule extends BaseHttpModule {
    @Singleton
    @Provides
    TestService provideTestService(@TestUrl Retrofit retrofit){
        return retrofit.create(TestService.class);
    }
}
