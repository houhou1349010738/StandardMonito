package com.smartwasser.yunzhishui.sludgeactivity;

import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.fragment.TrafficFragment;

/**
 * Created by huangmengjie on 2016/6/15 0015.
 */
public class TrafficMainActivity extends BaseActivity {
    private TrafficFragment mTraffic;
    @Override
    protected int initContentView() {
        return R.layout.activity_main_fragment;
    }
    @Override
    protected void initView() {
        mTraffic=new TrafficFragment();
        getSupportFragmentManager().
                beginTransaction()
                .replace(R.id.frl, mTraffic, "TRAFFIC")
                .commit();
    }
    @Override
    protected void initListener() {

    }
    @Override
    protected void initData() {
    }
}
