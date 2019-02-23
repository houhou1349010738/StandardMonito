package com.smartwasser.yunzhishui.purchaseactivity;

import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.fragment.DeviceFragment;
import com.smartwasser.yunzhishui.fragment.PurchaseFragment;

/**
 * Created by huangmengjie on 2016/8/4 0004.
 */
public class PurchaseActivity extends BaseActivity{
    private PurchaseFragment mFragment;
    @Override
    protected int initContentView() {
        return R.layout.activity_main_fragment;
    }
    @Override
    protected void initView() {
        mFragment=new PurchaseFragment();
        getSupportFragmentManager().
                beginTransaction()
                .replace(R.id.frl,mFragment, "DEVICE")
                .commit();
    }
    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
