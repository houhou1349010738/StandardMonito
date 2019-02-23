package com.smartwasser.yunzhishui.adapter;
import android.content.Context;
import android.nfc.Tag;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.DataMainResponse;
import com.smartwasser.yunzhishui.bean.EventLookData;
import com.smartwasser.yunzhishui.utils.SharedUtils;

import java.util.List;

import de.greenrobot.event.EventBus;
/**
 * Created by huangmengjie on 2016/4/29 0029.
 */
public class DataMainAdapter extends BaseAdapter{
    private Context mcontext;
    private DataMainResponse mDataMain;
    private List<DataMainResponse.DataEntity.BcCmsInfoEntity> list;
    private EventLookData look;
    public DataMainAdapter(Context mcontext,DataMainResponse mDataMain,List<DataMainResponse.DataEntity.BcCmsInfoEntity> lists) {
        this.mcontext = mcontext;
        this.mDataMain=mDataMain;
        this.list=lists;
    }
    public void setDataMain(DataMainResponse DataMain){
        this.mDataMain=DataMain;
    }
    public DataMainResponse getmDataMain(){
        return mDataMain;
    }
    @Override
    public int getCount(){
        if(mDataMain==null&&mDataMain.getData().getBcCmsInfo().size()==0){
              return 0;
        }
        if("00014".equals(mDataMain.getErrorCode())){
                return 0;
        }
        return list.size();
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
        final ViewHolder  holder;
        if(convertView==null){
            holder=new ViewHolder();
            convertView=View.inflate(mcontext, R.layout.item_datahome,null);
            holder.tv_username= (TextView) convertView.findViewById(R.id.tv_username);
            holder.tv_time=(TextView) convertView.findViewById(R.id.tv_time);
            holder.tv_center=(TextView) convertView.findViewById(R.id.tv_center);
            holder.iv_cue= (ImageView) convertView.findViewById(R.id.iv_cue);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        if(SharedUtils.getBooleanData(mcontext,position+"",false)){
            holder.iv_cue.setVisibility(View.GONE);
        }
        holder.tv_username.setText(list.get(position).getAuthor());
        holder.tv_time.setText(list.get(position).getWritetime());
        holder.tv_center.setText(list.get(position).getTitle());
        return convertView;
    }
   class ViewHolder{
        /**管理员的姓名*/
        TextView tv_username;
        /**获取时间*/
        TextView tv_time;
        /**当该条目被点击时,图片隐藏*/
        ImageView iv_cue;
        /**获取通告的内容*/
        TextView tv_center;
    }
    public void addItem(DataMainResponse.DataEntity.BcCmsInfoEntity respon){
         list.add(respon);
    }
}
