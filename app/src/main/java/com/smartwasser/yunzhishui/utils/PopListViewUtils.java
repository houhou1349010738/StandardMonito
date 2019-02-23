package com.smartwasser.yunzhishui.utils;

import android.content.Context;
import android.graphics.Color;
import android.widget.ListView;

import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.adapter.PopupAdapter;
import com.smartwasser.yunzhishui.adapter.PopupAdapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangmengjie on 2016/6/24 0024.
 */
public class PopListViewUtils {
    private PopupAdapter  myAdapter, myAdapter2,myAdapter3,myAdapter4,myAdapter5,myAdapter7
    ,myAdapter8,myAdapter9;
    private PopupAdapter2 myAdapter6;
    private Context mContext;
    public List<String> mListView;
    public List<String> mListView2;
    public List<String> mListView3;
    public List<String> mListView4;
    public List<String> mListView5;
    public List<String>  mListView6;
    public List<String> mListView7;
    public List<String> mListView8;
    public List<String> mListView9;
    public PopListViewUtils(Context mContext){
        this.mContext=mContext;
    }
   public ListView initListView() {
        ListView mListViews = new ListView(mContext);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);

        mListView = new ArrayList<String>();
        // 模拟数据
        mListView.add("快速查找");
        mListView.add("本周");
        mListView.add("上周");
        mListView.add("本月");
        mListView.add("上月");
        mListView.add("本年");
        mListView.add("上年");
        mListView.add("本季度");
        mListView.add("上季度");
        myAdapter = new PopupAdapter(mListView,mContext);
        mListViews.setAdapter(myAdapter);
        return mListViews;
    }
   public ListView initListView2() {
        ListView mListViews = new ListView(mContext);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        mListView2 = new ArrayList<String>();
        // 模拟数据
        mListView2.add("默认");
        mListView2.add("合计");
        mListView2.add("平均");
        myAdapter2 = new PopupAdapter(mListView2,mContext);
        mListViews.setAdapter(myAdapter2);
        return mListViews;
    }
   public ListView initListView3(){
        ListView mListViews = new ListView(mContext);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);

        mListView3 = new ArrayList<String>();
        // 模拟数据
        mListView3.add("请选择");
        mListView3.add("日");
        mListView3.add("月");
        mListView3.add("年");
        myAdapter3= new PopupAdapter(mListView3,mContext);
        mListViews.setAdapter(myAdapter3);
        return mListViews;
    }
    public ListView initListView4() {
        ListView mListViews = new ListView(mContext);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);

        mListView4 = new ArrayList<String>();
        // 模拟数据
        mListView4.add("前一天");
        mListView4.add("前二天");
        mListView4.add("前三天");
        mListView4.add("前四天");
        mListView4.add("前五天");
        mListView4.add("前六天");
        mListView4.add("前七天");
        myAdapter4= new PopupAdapter(mListView4,mContext);
        mListViews.setAdapter(myAdapter4);
        return mListViews;
    }
    public ListView initListView5(){
        ListView mListViews = new ListView(mContext);
        mListView5=new ArrayList<>();
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        // 模拟数据
        mListView5.add("增值税专用发票");
        mListView5.add("增值税普通发票");
        mListView5.add("其他");
        myAdapter5 = new PopupAdapter(mListView5,mContext);
        mListViews.setAdapter(myAdapter5);
        return mListViews;
    }
    public ListView initListView6(){
        ListView mListViews = new ListView(mContext);
        mListView6=new ArrayList<>();
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundColor(Color.parseColor("#12b7f5"));
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        // 模拟数据
        mListView6.add("降雨排行");
        mListView6.add("场雨排行");
        myAdapter6 = new PopupAdapter2(mListView6,mContext);
        mListViews.setAdapter(myAdapter6);
        return mListViews;
    }
    public ListView initListView7(){
        ListView mListViews = new ListView(mContext);
        mListView7=new ArrayList<>();
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        // 模拟数据
        mListView7.add("是");
        mListView7.add("否");
        myAdapter7 = new PopupAdapter(mListView7,mContext);
        mListViews.setAdapter(myAdapter7);
        return mListViews;
    }
    public ListView initListView8(){
        ListView mListViews = new ListView(mContext);
        mListView8=new ArrayList<>();
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        // 模拟数据
        mListView8.add("小时查询");
        mListView8.add("精细查询");
        myAdapter8 = new PopupAdapter(mListView8,mContext);
        mListViews.setAdapter(myAdapter8);
        return mListViews;
    }
    public ListView initListView9(){
        ListView mListViews = new ListView(mContext);
        mListView9=new ArrayList<>();
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        // 模拟数据
        mListView9.add("瞬时值");
        mListView9.add("峰值");
        mListView9.add("谷值");
        mListView9.add("平均值");
        myAdapter9 = new PopupAdapter(mListView9,mContext);
        mListViews.setAdapter(myAdapter9);
        return mListViews;
    }
}
