package com.smartwasser.yunzhishui.pager;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

/**
 * Created by huangmengjie on 2016/home/29 0029.
 */
public class MinePager extends BasePager {
    private TextView view;
    public MinePager(Context context) {
        super(context);
    }
    @Override
    public View initViews() {
        view=new TextView(context);
        return view;
    }
    @Override
    public void initDatas() {
        view.setText("我是资料查询");
    }
}
