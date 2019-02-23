package com.smartwasser.yunzhishui.alarm;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.adapter.alarm.Tadapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 15810 on 2019/2/22.
 */

public class StatisticsActivity extends BaseActivity {
    private ListView mListView;
    private List<String> mlist;
    private Toolbar toolbar;
    private ImageButton button_menu;
    private TextView tv_toolbar;
    @Override
    protected int initContentView() {
        return R.layout.avtivity_alarm;
    }

    @Override
    protected void initView() {
        button_menu= (ImageButton) findViewById(R.id.button_menu);
        tv_toolbar= (TextView) findViewById(R.id.tv_toolbar);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        mListView   =    findViewById(R.id.wraing_list);
        button_menu.setVisibility(View.GONE);
        toolbar.setTitle("");
        tv_toolbar.setText("汇总统计");
        setSupportActionBar(toolbar);
    }



    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        mlist = new ArrayList<>();
        mlist.add("厂进水量指标统计");
        mlist.add("厂设备利用率统计");
        mlist.add("厂用电量年统计");
        mlist.add("厂用电量月统计");
        mlist.add("构筑物用电量月统计");
        Tadapter tadapter = new Tadapter(this,mlist);
        mListView.setAdapter(tadapter);
    }
}
