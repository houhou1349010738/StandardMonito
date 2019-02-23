package com.smartwasser.yunzhishui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.TransportResponse;

/**
 * Created by huangmengjie on 2016/7/14 0014.
 */
public class TransportationAdapter extends BaseAdapter{
    private Context mContext;
    private TransportResponse mTransport;
    public TransportationAdapter(Context context,TransportResponse transport){
        mContext=context;
        mTransport=transport;
    }
    @Override
    public int getCount() {
        if(mTransport.getData()==null){
            return 0;
        }
        return mTransport.getData().getTransportTask().getRows().size();
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
            convertView=View.inflate(mContext, R.layout.item_transporta,null);
            holder=new ViewHolder();
            holder.tv_transporta_cph= (TextView) convertView.findViewById(R.id.tv_transporta_cph);
            holder.tv_transporta_state= (TextView) convertView.findViewById(R.id.tv_transporta_state);
            holder.tv_transporta_startTime= (TextView) convertView.findViewById(R.id.tv_transporta_startTime);
            holder.tv_transporta_yj= (TextView) convertView.findViewById(R.id.tv_transporta_yj);
            holder.tv_transporta_endTiem= (TextView) convertView.findViewById(R.id.tv_transporta_endTiem);
            holder.tv_transporta_yxsj= (TextView) convertView.findViewById(R.id.tv_transporta_yxsj);
            holder.tv_transporta_czd= (TextView) convertView.findViewById(R.id.tv_transporta_czd);
            holder.tv_transporta_lxcd= (TextView) convertView.findViewById(R.id.tv_transporta_lxcd);
            holder.tv_transporta_chuzd= (TextView) convertView.findViewById(R.id.tv_transporta_chuzd);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.tv_transporta_cph.setText("    "+mTransport.getData().getTransportTask().getRows().get(position).getVehicleNo());
        String state=mTransport.getData().getTransportTask().getRows().get(position).getStatusName();
        if("正常".equals(state)){
            holder.tv_transporta_state.setTextColor(Color.parseColor("#4cd964"));
        }else if("完成".equals(state)){
            holder.tv_transporta_state.setTextColor(Color.parseColor("#12b7f5"));
        }else if("无定位信号".equals(state)){
            holder.tv_transporta_state.setTextColor(Color.parseColor("#fc3b3c"));
        }else if("异常结束".equals(state)||"无终点".equals(state)){
            holder.tv_transporta_state.setTextColor(Color.parseColor("#ff9800"));
        }else{
            holder.tv_transporta_state.setTextColor(Color.parseColor("#0000ff"));
        }
        holder.tv_transporta_state.setText(state);
        String startTime=mTransport.getData().getTransportTask().getRows().get(position).getStartTime();
        if(startTime==null||"null".equals(startTime)){
            startTime="";
        }
        holder.tv_transporta_startTime.setText("开始时间:"+"       "+startTime);
        if(mTransport.getData().getTransportTask().getRows().get(position).getReviseDistance()==null){
            holder.tv_transporta_yj.setText("运距:"+"      "+"");
        }
        String endTime=mTransport.getData().getTransportTask().getRows().get(position).getEndTime();
        if(endTime==null||"null".equals(endTime)){
            endTime="";
        }
        holder.tv_transporta_endTiem.setText("结束时间:"+"       "+endTime);
        String yxsj=mTransport.getData().getTransportTask().getRows().get(position).getRunTime();
        if("null".equals(yxsj)||yxsj==null){
            yxsj="";
        }
        holder.tv_transporta_yxsj.setText("运行时间:"+"      "+ yxsj);
        holder.tv_transporta_czd.setText("称重点:" + "     " + mTransport.getData().getTransportTask().getRows().get(position).getBusiUnitName());
        String s= mTransport.getData().getTransportTask().getRows().get(position).getSetTransportDistance();
        if(s!=null&&s.length()>=6){
            s=s.substring(0,5);
        }
        if(s==null){
            s="";
        }
        holder.tv_transporta_lxcd.setText("路线长度:"+"    "+s);
        String czd=mTransport.getData().getTransportTask().getRows().get(position).getMudName();
        if(czd==null||"null".equals(czd)){
           czd="";
        }
        holder.tv_transporta_chuzd.setText("处置点:"+"      "+czd);
        return convertView;
    }
    class ViewHolder{
        TextView tv_transporta_cph,tv_transporta_state,tv_transporta_startTime
                ,tv_transporta_yj,tv_transporta_endTiem,tv_transporta_yxsj,
                tv_transporta_czd,tv_transporta_lxcd,tv_transporta_chuzd;
    }
}
