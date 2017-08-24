package com.qzp.mymvpframe.api;

import com.qzp.mymvpframe.application.Content;
import com.qzp.mymvpframe.model.bean.MainBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by qizepu on 2017/5/17.
 *
 * 接口
 */

public interface Api {


    //分类页面一级列表请求方法
    @GET(Content.CART_LIST)
    Observable<MainBean> getData();

}
