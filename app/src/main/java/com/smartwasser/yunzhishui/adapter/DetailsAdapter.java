package com.smartwasser.yunzhishui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.LookDataResponse;

/**
 * Created by huangmengjie on 2016/5/9 0009.
 */
public class DetailsAdapter extends BaseAdapter{
    private Context mContext;
    private LookDataResponse mLookResponse;
    public DetailsAdapter(Context context,LookDataResponse LookResponse){
        mContext=context;
        mLookResponse=LookResponse;
    }
    public void SetLookData( LookDataResponse LookResponse){
        mLookResponse=LookResponse;
    }
    @Override
    public int getCount() {
        if("00014".equals(mLookResponse.getErrorCode())){
            return 0;
        }
        return mLookResponse.getData().getMasters().size();
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
            convertView=View.inflate(mContext, R.layout.item_lookdata,null);
            holder.iv_look_zhibiao= (TextView) convertView.findViewById(R.id.iv_look_zhibiao);
            holder.iv_look_shuju= (TextView) convertView.findViewById(R.id.iv_look_shuju);
            holder.iv_look_panduan= (TextView) convertView.findViewById(R.id.iv_look_panduan);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        String danwei=mLookResponse.getData().getMasters().get(position).getDataUnit();
        if("".equals(danwei)||danwei==null){
            danwei="";
        }
        holder.iv_look_shuju.setText(mLookResponse.getData().getMasters().get(position).getIndeValue()+ danwei);
        holder.iv_look_zhibiao.setText(mLookResponse.getData().getMasters().get(position).getIndeName());
        String s=mLookResponse.getData().getMasters().get(position).getIndeStat();
        holder.iv_look_panduan.setText(s);
        if(s.indexOf("退回")!=-1){
            holder.iv_look_panduan.setTextColor(Color.RED);
        }else{
            holder.iv_look_panduan.setTextColor(Color.GREEN);
        }
        return convertView;
    }
     class ViewHolder{
        TextView iv_look_zhibiao,iv_look_shuju,iv_look_panduan;
    }
}
