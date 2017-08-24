package com.qzp.mymvpframe.api;

/**
 * Created by qizepu on 2017/5/17.
 * 异常类
 */

public class ExceptionApi extends RuntimeException {

    private String mMessage;

    public ExceptionApi(String reason) {
        super(reason);
        this.mMessage = reason;
    }
    public String getmMessage() {
        return mMessage;
    }
}
