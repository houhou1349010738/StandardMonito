package com.smartwasser.yunzhishui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by huangmengjie on 2015/12/8 0008.
 */
public abstract class MainBaseFragment extends Fragment {
    public View view;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    /**
     * 将view转化成java中的对象
     * 加载布局
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=initView(inflater);
        return view;
    }

    /**
     * 数据填充
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
             initData();
        super.onActivityCreated(savedInstanceState);
    }
    public abstract View initView(LayoutInflater inflater);
    public abstract void initData();
}
