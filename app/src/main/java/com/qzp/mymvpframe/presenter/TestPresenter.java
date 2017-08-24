package com.qzp.mymvpframe.presenter;

import android.content.Context;

import com.qzp.mymvpframe.api.ObserverApi;
import com.qzp.mymvpframe.api.RetrofitApi;
import com.qzp.mymvpframe.base.BasePresenter;
import com.qzp.mymvpframe.model.bean.MainBean;
import com.qzp.mymvpframe.model.httputils.HttpUtils;
import com.qzp.mymvpframe.view.iview.ITestView;

/**
 * Created by qizepu on 2017/5/17.
 */

public class TestPresenter extends BasePresenter<ITestView>{

    //请求数据
    public void getMainData(Context context){
        HttpUtils.getData(RetrofitApi.getServer().getData(),new ObserverApi<MainBean>(context) {
            @Override
            public void onSuccess(MainBean o) {
                getView().onsuccess(o);
            }
        });
    }

}
