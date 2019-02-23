package com.smartwasser.yunzhishui.utils;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.smartwasser.yunzhishui.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangmengjie on 2016/6/16 0016.
 */
public class ListViewUtils {
    private Context mContext;
    private List<String> mListView;
    private MyAdapters myAdapters;
    public ListViewUtils(Context context){
        mContext=context;
    }
    public ListView initListView(List<String> mListView) {
        this.mListView=mListView;
        ListView mListViews = new ListView(mContext);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        // 模拟数据
        mListView.add("01");
        mListView.add("02");
        mListView.add("03");
        mListView.add("04");
        mListView.add("05");
        mListView.add("06");
        mListView.add("07");
        mListView.add("08");
        mListView.add("09");
        mListView.add("10");
        mListView.add("11");
        mListView.add("12");
        myAdapters = new MyAdapters();
        mListViews.setAdapter(myAdapters);
        return mListViews;
    }


    class MyAdapters extends BaseAdapter {
        @Override
        public int getCount() {
            return  mListView.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = View.inflate(mContext, R.layout.item_search, null);
                holder.v_listview_item_number = (TextView) convertView.findViewById(R.id.tv_listview_item_number);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (position == 0) {
                holder.v_listview_item_number.setTextColor(Color.GRAY);
            }
            holder.v_listview_item_number.setText(mListView.get(position));
            return convertView;
        }
    }
   class ViewHolder{
       TextView v_listview_item_number;
   }
}
