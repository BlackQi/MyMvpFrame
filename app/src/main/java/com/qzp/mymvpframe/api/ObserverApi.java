package com.qzp.mymvpframe.api;

import android.content.Context;
import android.widget.Toast;

import com.google.gson.JsonSyntaxException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by qizepu on 2017/5/17.
 */

public abstract class ObserverApi<T> implements Observer<T> {

    private Context mContext;
    private boolean flag = true;//是否显示进度条

    public ObserverApi(Context context) {
        this.mContext = context;
    }

    public ObserverApi(Context context, boolean flag) {
        this.flag = flag;
        this.mContext = context;
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onSubscribe(Disposable d) {
        if (flag) {
        }
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    //将错误集中处理，或者将错误返回  单独处理
    @Override
    public void onError(Throwable e) {
        if (e instanceof ExceptionApi) {
            Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();
        } else if ((e instanceof UnknownHostException)) {
            Toast.makeText(mContext, "网络异常", Toast.LENGTH_SHORT).show();
        } else if (e instanceof JsonSyntaxException) {
            Toast.makeText(mContext, "数据异常", Toast.LENGTH_SHORT).show();
        } else if (e instanceof SocketTimeoutException) {
            Toast.makeText(mContext, "连接超时", Toast.LENGTH_SHORT).show();
        } else if (e instanceof ConnectException) {
            Toast.makeText(mContext, "连接服务器失败", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mContext, "未知错误", Toast.LENGTH_SHORT).show();
        }

    }

    public abstract void onSuccess(T t);
}