package com.smartwasser.yunzhishui.rmonactivity;

import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.fragment.DeviceFragment;
import com.smartwasser.yunzhishui.fragment.RmonFragment;

/**
 * Created by huangmengjie on 2016/7/29 0029.
 */
public class RmonActivity extends BaseActivity{
    private RmonFragment mFragment;
    @Override
    protected int initContentView() {
        return  R.layout.activity_main_fragment;
    }

    @Override
    protected void initView() {
        mFragment=new RmonFragment();
        getSupportFragmentManager().
                beginTransaction()
                .replace(R.id.frl, mFragment, "RMON")
                .commit();
    }
    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
