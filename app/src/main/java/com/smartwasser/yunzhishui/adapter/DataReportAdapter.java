package com.smartwasser.yunzhishui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.DataReportResponse;

import java.util.List;
/**
 * Created by huangmengjie on 2016/5/5 0005.
 */
public class DataReportAdapter extends BaseAdapter{
    private Context mcontext;
    /*private DataReportResponse mDataReport;*/
    private List<DataReportResponse.DataEntity.RundataUpDailyListEntity.RowsEntity> mList;
    public DataReportAdapter(Context context,List<DataReportResponse.DataEntity.RundataUpDailyListEntity.RowsEntity> mList){
        this.mcontext=context;
       /* this.mDataReport=DataReport;*/
        this.mList=mList;
    }
    @Override
    public int getCount() {
        /**内容*/
        return mList.size();
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
            convertView=View.inflate(mcontext,R.layout.item_workreport,null);
            holder.tv_tianbao= (TextView) convertView.findViewById(R.id.tv_tianbao);
            holder.tv_tianbao_time= (TextView) convertView.findViewById(R.id.tv_tianbao_time);
            holder.tv_tianbao_center= (TextView) convertView.findViewById(R.id.tv_tianbao_center);
            holder.tv_tianbao_uptime= (TextView) convertView.findViewById(R.id.tv_tianbao_uptime);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
                String upstat =mList.get(position).getUpStat();
                holder.tv_tianbao.setText(upstat);
                /**截取后面2个字*/
                if (upstat.indexOf("退回") != -1) {
                    holder.tv_tianbao.setBackgroundResource(R.drawable.red);
                } else if (upstat.indexOf("填报") != -1) {
                    holder.tv_tianbao.setBackgroundResource(R.drawable.gread);
                } else if (upstat.indexOf("审核") != -1) {
                    holder.tv_tianbao.setBackgroundResource(R.drawable.blank);
                } else if (upstat.indexOf("复核") != -1) {
                    holder.tv_tianbao.setBackgroundResource(R.drawable.yellow);
                }
                holder.tv_tianbao_center.setText(mList.get(position).getReviewManName());
                holder.tv_tianbao_time.setText(mList.get(position).getDataDate());
                holder.tv_tianbao_uptime.setText("更新时间:" +mList.get(position).getRecordTime());
        return convertView;
    }
    static class ViewHolder{
        TextView tv_tianbao,tv_tianbao_time,tv_tianbao_center,tv_tianbao_uptime;
    }
}
