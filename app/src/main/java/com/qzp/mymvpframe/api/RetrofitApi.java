package com.qzp.mymvpframe.api;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.qzp.mymvpframe.application.Content;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by qizepu on 2017/5/17.
 *
 * 将Retrofit封装起来，返回Api
 */

public class RetrofitApi {

    static class RetrofitInstance {
        private static Api api = new Retrofit.Builder()
                .baseUrl(Content.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Api.class);
    }

    //得到Server对象
    public static Api getServer() {
        return RetrofitInstance.api;
    }

}
