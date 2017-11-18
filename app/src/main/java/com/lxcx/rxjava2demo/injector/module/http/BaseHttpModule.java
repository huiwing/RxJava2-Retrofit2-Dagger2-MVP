package com.lxcx.rxjava2demo.injector.module.http;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.lxcx.rxjava2demo.app.MyCommon;
import com.lxcx.rxjava2demo.injector.qualifier.TestUrl;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ArmyAntAndroid on 2017/11/17.
 */

@Module
public class BaseHttpModule {

    @Singleton
    @Provides
    @TestUrl
    Retrofit provideRetrofit(Retrofit.Builder builder, OkHttpClient client){
        return createRetrofit(builder,client, MyCommon.BASE_URL);
    }

    @Singleton
    @Provides
    Retrofit.Builder provideRetrofitBuilder(){
        return new Retrofit.Builder();
    }

    @Singleton
    @Provides
    OkHttpClient.Builder provideOkHttpBuilder(){
        return new OkHttpClient.Builder();
    }

    @Singleton
    @Provides
    OkHttpClient provideClient(OkHttpClient.Builder builder){
        //设置超时
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);
        return builder.build();
    }

    Retrofit createRetrofit(Retrofit.Builder builder,OkHttpClient client,String url){
        return builder
                .baseUrl(url)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
