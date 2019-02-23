package com.smartwasser.yunzhishui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.LxindeGropResponse;

/**
 * Created by huangmengjie on 2016/6/24 0024.
 */
public class GropLxindeAdapter extends BaseAdapter{
    private LxindeGropResponse mGropLxinde;
    private Context mContext;
    public GropLxindeAdapter(LxindeGropResponse mGropLxinde,Context mContext){
        this.mContext=mContext;
        this.mGropLxinde=mGropLxinde;
    }
    @Override
    public int getCount() {
        if(mGropLxinde.getData()==null){
            return 0;
        }
        return mGropLxinde.getData().getIndeList().size();
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
        holder.v_listview_item_number.setText(mGropLxinde.getData().getIndeList().get(position).getIndegrpName());
        return convertView;
    }
    class ViewHolder {
        TextView v_listview_item_number;
    }
}
