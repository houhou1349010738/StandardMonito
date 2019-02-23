package com.smartwasser.yunzhishui.deviceactivity;

import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.fragment.DeviceFragment;

/**
 * Created by huangmengjie on 2016/6/15 0015.
 */
public class DeviceActivity extends BaseActivity{
    private DeviceFragment mFragment;
    @Override
    protected int initContentView() {
        return  R.layout.activity_main_fragment;
    }
    @Override
    protected void initView() {
        mFragment=new DeviceFragment();
        getSupportFragmentManager().
                beginTransaction()
                .replace(R.id.frl, mFragment, "DEVICE")
                .commit();
    }
    @Override
    protected void initListener() {

    }
    @Override
    protected void initData() {

    }
}
