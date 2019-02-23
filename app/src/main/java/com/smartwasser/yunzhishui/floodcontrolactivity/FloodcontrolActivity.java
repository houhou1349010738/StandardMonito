package com.smartwasser.yunzhishui.floodcontrolactivity;

import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.fragment.FloodcontrolFragment;
import com.smartwasser.yunzhishui.fragment.ProductionFragment;

/**
 * Created by huangmengjie on 2016/7/22 0022.
 */
public class FloodcontrolActivity extends BaseActivity {
    private FloodcontrolFragment mFragment;

    @Override
    protected int initContentView() {
        return R.layout.activity_main_fragment;
    }

    @Override
    protected void initView() {
        mFragment = new FloodcontrolFragment();
        getSupportFragmentManager().
                beginTransaction()
                .replace(R.id.frl, mFragment, "PRODUCT")
                .commit();
    }
    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}