package com.smartwasser.yunzhishui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.smartwasser.yunzhishui.R;

import java.util.List;

/**
 * Created by huangmengjie on 2016/6/24 0024.
 */
public class PopupAdapter2 extends BaseAdapter{
          private List<String> mListView;
          private Context mContext;
          public PopupAdapter2(List<String> mListView, Context context){
             this.mListView=mListView;
             mContext=context;
         }
        @Override
        public int getCount() {
            return mListView.size();
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
            holder.v_listview_item_number.setTextColor(Color.parseColor("#ffffff"));
            holder.v_listview_item_number.setText(mListView.get(position));
            return convertView;
        }
    class ViewHolder {
        TextView v_listview_item_number;
    }
}
