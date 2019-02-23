package com.smartwasser.yunzhishui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.IndeGropReaponse;

import java.util.List;

/**
 * Created by huangmengjie on 2016/5/19 0019.
 */
public class GropNormAdapter extends BaseAdapter{
    private Context mContext;
    private List<IndeGropReaponse.DataEntity.DailyIndeGrpListEntity> mList;
    public GropNormAdapter(Context context,List<IndeGropReaponse.DataEntity.DailyIndeGrpListEntity> mList){
        mContext=context;
        this.mList= mList;
    }
    @Override
    public int getCount(){

        return  mList.size();
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
            convertView=View.inflate(mContext, R.layout.item_norm,null);
            holder.tv_zhibiao_stat= (TextView) convertView.findViewById(R.id.tv_zhibiao_stat);
            holder.tv_zhibiao_time= (TextView) convertView.findViewById(R.id.tv_zhibiao_time);
            holder.tv_tianbao_chushui= (TextView) convertView.findViewById(R.id.tv_tianbao_chushui);
            holder.tv_zhibiao_norm= (TextView) convertView.findViewById(R.id.tv_zhibiao_norm);
            holder.tv_tianbao_danwei= (TextView) convertView.findViewById(R.id.tv_tianbao_danwei);
            holder.tv_tianbao_shuzhi= (TextView) convertView.findViewById(R.id.tv_tianbao_shuzhi);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        String upstat=mList.get(position).getUp_stat();
        holder.tv_zhibiao_stat.setText(upstat);
         /**截取后面2个字*/
        if(upstat!=null&&!"".equals(upstat)&&!"null".equals(upstat)) {
            if (upstat.indexOf("退回") != -1) {
                holder.tv_zhibiao_stat.setBackgroundResource(R.drawable.red);
            } else if (upstat.indexOf("填报") != -1) {
                holder.tv_zhibiao_stat.setBackgroundResource(R.drawable.gread);
            } else if (upstat.indexOf("审核") != -1) {
                holder.tv_zhibiao_stat.setBackgroundResource(R.drawable.blank);
            } else if (upstat.indexOf("复核") != -1) {
                holder.tv_zhibiao_stat.setBackgroundResource(R.drawable.yellow);
            }
        }
        holder.tv_zhibiao_time.setText(mList.get(position).getData_date());
        holder.tv_tianbao_chushui.setText(mList.get(position).getInde_name()+":");
        holder.tv_tianbao_danwei.setText("("+mList.get(position).getData_unit()+")");
        holder.tv_tianbao_shuzhi.setText(mList.get(position).getInde_value());
        holder.tv_zhibiao_norm.setText("所属单位-"+mList.get(position).getBusiness_unit_name());
        return convertView;
    }
    class ViewHolder{
        TextView tv_zhibiao_stat,tv_zhibiao_time,tv_tianbao_chushui,tv_zhibiao_norm,tv_tianbao_danwei,tv_tianbao_shuzhi;
    }
}
