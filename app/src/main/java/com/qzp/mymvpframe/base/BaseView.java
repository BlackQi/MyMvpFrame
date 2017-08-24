package com.qzp.mymvpframe.base;

/**
 * Created by qizepu on 2017/5/17.
 *
 * 所有的接口都继承这个接口
 */

public interface BaseView<T> {

    void onsuccess(T t);
    void onError(T t);
}
