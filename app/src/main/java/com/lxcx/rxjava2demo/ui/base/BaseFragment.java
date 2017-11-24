package com.lxcx.rxjava2demo.ui.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * BaseFragment
 * Created by ArmyAntAndroid on 2017/11/23.
 */

public abstract class BaseFragment extends Fragment {

    private Unbinder unbinder;
    protected View contentView;

    protected boolean mIsVisible = false;     // fragment是否显示了

    protected boolean isPrepared = false;

    protected boolean isFirst = true; //只加载一次界面

    @LayoutRes
    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initEvent();

    protected abstract void initData();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (contentView == null) {
            contentView = inflater.inflate(getLayoutId(), container, false);
            unbinder = ButterKnife.bind(this, contentView);
            initView();
            initEvent();
            initData();
            isFirst = false;
        }
        isPrepared = true;
        return contentView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {//fragment可见
            mIsVisible = true;
            onVisible();
        } else {//不可见
            mIsVisible = false;
            onInvisible();
        }
    }

    protected void onVisible() {
        if(!isFirst){
            initData();
        }
    }

    protected void onInvisible() {
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
