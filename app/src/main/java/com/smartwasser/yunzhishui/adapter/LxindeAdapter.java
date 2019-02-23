package com.smartwasser.yunzhishui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.LxIndeResponse;
/**
 * Created by huangmengjie on 2016/6/24 0024.
 */
public class LxindeAdapter extends BaseAdapter{
    private LxIndeResponse mLxinde;
    private Context mContext;
    public LxindeAdapter( LxIndeResponse lxinde,Context context){
        mLxinde=lxinde;
        mContext=context;
    }
    @Override
    public int getCount() {
        if("00014".equals(mLxinde.getErrorCode())){
            return 0;
        }
        return  mLxinde.getData().getIndeList().size();
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
        holder.v_listview_item_number.setText(mLxinde.getData().getIndeList().get(position).getIndeName());
        return convertView;
    }
    class ViewHolder {
        TextView v_listview_item_number;
    }
}
