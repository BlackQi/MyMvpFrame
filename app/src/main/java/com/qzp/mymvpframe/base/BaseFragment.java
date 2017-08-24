package com.qzp.mymvpframe.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by qizepu on 2017/5/18.
 */

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView {

    protected View mView;
    protected Context mContext;
    protected T mPresenter;
    protected Activity mActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mView = inflater.inflate(getLayoutId(),null);
        return mView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init() {
        mActivity = getActivity();
        mContext = getActivity();
        createPresenter();
        mPresenter.attachView(this);
    }

    protected abstract void createPresenter();
    protected abstract int getLayoutId();


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null){
            mPresenter.detachView();
        }
    }
}
