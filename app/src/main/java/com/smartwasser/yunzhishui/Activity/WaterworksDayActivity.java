package com.smartwasser.yunzhishui.Activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;

import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.fragment.ReportFragment;
import com.smartwasser.yunzhishui.net.HttpLoader;
/**
 * Created by huangmengjie on 2016/5/5 0005.
 */
public class WaterworksDayActivity extends FragmentActivity {
    public ReportFragment mreport;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment);
        initView();
    }
    private void initView() {
        mreport=new ReportFragment();
        getSupportFragmentManager().
                beginTransaction()
                .replace(R.id.frl,mreport, "REPORT")
                .commit();
    }
    @Override
    protected void onStop() {
        super.onStop();
        HttpLoader.cancelRequest(this);
    }
}
