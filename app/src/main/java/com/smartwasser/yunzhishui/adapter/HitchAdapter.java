package com.smartwasser.yunzhishui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.HitchResponse;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/5 0005.
 */
public class HitchAdapter extends BaseAdapter{
        private Context mCotext;
        private List<HitchResponse.DataEntity.EqFailureEntity.RowsEntity> lists;
        public HitchAdapter(Context context,List<HitchResponse.DataEntity.EqFailureEntity.RowsEntity> lists){
            mCotext=context;
            this.lists=lists;
        }
        @Override
        public int getCount() {
            return lists.size();
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
            if(convertView==null){
                holder=new ViewHolder();
                convertView=View.inflate(mCotext, R.layout.item_hitch,null);
                holder.tv_hitch_sbmc= (TextView) convertView.findViewById(R.id.tv_hitch_sbmc);
                holder.tv_hitch_zhuangtai= (TextView)convertView.findViewById(R.id.tv_hitch_zhuangtai);
                holder.tv_hitch_gzlb= (TextView)convertView.findViewById(R.id.tv_hitch_gzlb);
                holder.tv_hitch_starttime= (TextView) convertView.findViewById(R.id. tv_hitch_starttime);
                holder.tv_hitch_endtime= (TextView) convertView.findViewById(R.id.tv_hitch_endtime);
                holder.tv_hitch_cfwz= (TextView)convertView.findViewById(R.id.tv_hitch_cfwz);
                convertView.setTag(holder);
            }else{
                holder=(ViewHolder)convertView.getTag();
            }
            holder.tv_hitch_sbmc.setText("设备名称:" + lists.get(position).getEquipName());
            if(Integer.valueOf(lists.get(position).getFailureState())==1){
                holder.tv_hitch_zhuangtai.setText("已确认");
                holder.tv_hitch_zhuangtai.setTextColor(Color.GREEN);
            }else if(Integer.valueOf(lists.get(position).getFailureState())==0){
                holder.tv_hitch_zhuangtai.setText("未确认");
                holder.tv_hitch_zhuangtai.setTextColor(Color.RED);
            }

            String startTime=lists.get(position).getFailureSdate();
            String endTime=lists.get(position).getFailureEdate();
            String ss=lists.get(position).getFailureTbType();
            if(ss==null||"".equals(ss)){
                ss="";
            }
            holder.tv_hitch_gzlb.setText("故障类别:"+ss);
            holder.tv_hitch_starttime.setText("故障发生时间:"+startTime.substring(0,10));
            holder.tv_hitch_endtime.setText("故障结束时间:"+endTime.substring(0,10));
            holder.tv_hitch_cfwz.setText("存放位置:"+lists.get(position).getEquipLocCodeName());
            return convertView;
        }
    static class ViewHolder{
        TextView tv_hitch_sbmc,tv_hitch_zhuangtai,tv_hitch_gzlb,
                tv_hitch_starttime,tv_hitch_endtime,tv_hitch_cfwz;
    }
}
