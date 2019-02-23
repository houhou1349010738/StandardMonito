package com.smartwasser.yunzhishui.productionactivity;

import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.fragment.ProductionFragment;

/**
 * Created by huangmengjie on 2016/7/18 0018.
 */
public class ProductionActivity extends BaseActivity{
    private ProductionFragment  mFragment;
    @Override
    protected int initContentView() {
        return R.layout.activity_main_fragment;
    }

    @Override
    protected void initView() {
        mFragment=new ProductionFragment();
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
