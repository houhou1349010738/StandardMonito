package com.smartwasser.yunzhishui.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.WorkDanList;
import com.smartwasser.yunzhishui.deviceactivity.FeedbackMxActivity;

import java.util.List;

import de.greenrobot.event.EventBus;
/**
 * Created by huangmengjie on 2016/7/5 0005.
 */
public class WorkDanFeedAdapter extends BaseAdapter{
        private Context mContext;
        private EventSearchResponse event=new EventSearchResponse();
        private List<WorkDanList.DataEntity.EqMaintainEntity.RowsEntity> lists;
        public WorkDanFeedAdapter(Context context,List<WorkDanList.DataEntity.EqMaintainEntity.RowsEntity> lists){
            mContext=context;
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
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if(convertView==null){
                holder=new ViewHolder();
                convertView=View.inflate(mContext,R.layout.item_feedback,null);
                holder.tv_shebei_name= (TextView) convertView.findViewById(R.id.tv_shebei_name);
                holder.tv_weixiu_month= (TextView) convertView.findViewById(R.id.tv_weixiu_month);
                holder.button_weixiu_state= (TextView) convertView.findViewById(R.id.button_weixiu_state);
                holder.tv_workdan_fuzeren= (TextView) convertView.findViewById(R.id.tv_workdan_fuzeren);
                holder.tv_jihua_starttime_endtime= (TextView) convertView.findViewById(R.id.tv_jihua_starttime_endtime);
                holder.tv_shishi_danwei= (TextView) convertView.findViewById(R.id.tv_shishi_danwei);
                holder.but_fankui= (ImageButton) convertView.findViewById(R.id.but_fankui);
                holder.tv_jihua_starttime= (TextView) convertView.findViewById(R.id.tv_jihua_starttime);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolder) convertView.getTag();
            }
            holder.tv_shebei_name.setText(lists.get(position).getMaintainName());
            holder.tv_weixiu_month.setText(lists.get(position).getMaintainMonth());
            holder.tv_workdan_fuzeren.setText("工单负责人:" + lists.get(position).getMaintainCharge());
            String s=lists.get(position).getMaintainSdate();
            String s1=lists.get(position).getMaintainEdate();
            holder.tv_jihua_starttime.setText("计划开始时间:"+s);
            holder.tv_jihua_starttime_endtime.setText("计划结束时间:" +s1);
            holder.tv_shishi_danwei.setText("实施单位:" + lists.get(position).getMaintainImpDept());
            String ss=lists.get(position).getMaintainStatus();
            if("1".equals(ss)){
                   /**未派发*/
                holder.button_weixiu_state.setTextColor(Color.RED);
                holder.button_weixiu_state.setText("未派发");
                holder.but_fankui.setVisibility(View.GONE);
            }else if("2".equals(ss)){
                  /**派发*/
                holder.button_weixiu_state.setTextColor(Color.BLUE);
                holder.button_weixiu_state.setText("派发");
                holder.but_fankui.setVisibility(View.VISIBLE);
            }else if("3".equals(ss)){
                  /**部分完成*/
                holder.button_weixiu_state.setTextColor(Color.parseColor("#77b92b"));
                holder.button_weixiu_state.setText("部分完成");
                holder.but_fankui.setVisibility(View.VISIBLE);
            }else if("4".equals(ss)){
                /**未完成*/
                holder.button_weixiu_state.setTextColor(Color.parseColor("#77b92b"));
                holder.button_weixiu_state.setText("完成");
                holder.but_fankui.setVisibility(View.VISIBLE);
            }
            holder.but_fankui.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                      /**点击反馈按钮*/
                    String feedId=lists.get(position).getMaintainId();
                    String feedState=lists.get(position).getMaintainStatus();
                    event.setFeedId(feedId);
                    event.setFeedState(feedState);
                    EventBus.getDefault().postSticky(event);
                    Intent intent=new Intent(mContext,FeedbackMxActivity.class);
                    mContext.startActivity(intent);
                }
            });
            return convertView;
        }
    class ViewHolder{

        TextView tv_shebei_name,tv_weixiu_month,button_weixiu_state,tv_jihua_starttime,
                tv_workdan_fuzeren,tv_jihua_starttime_endtime,tv_shishi_danwei;
        ImageButton but_fankui;
    }

}
