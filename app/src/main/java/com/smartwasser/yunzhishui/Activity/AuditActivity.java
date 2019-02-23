package com.smartwasser.yunzhishui.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.AuditResponse;
import com.smartwasser.yunzhishui.bean.AuditSubmitResponse;
import com.smartwasser.yunzhishui.bean.EventLookData;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.view.FocusedTextview;
import com.smartwasser.yunzhishui.view.SwitchImageView;
import org.seny.android.utils.MyToast;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import de.greenrobot.event.EventBus;
/**
 * Created by huangmengjie on 2016/5/9 0009.
 */
public class AuditActivity extends BaseActivity implements HttpLoader.ResponseListener{
    private ImageButton button_menu;
    private TextView tv_toolbar;
    private Toolbar toolbar;
    private EventLookData mLookData;
    private TextView tv_audittime;
    private FocusedTextview tv_auditdanwei;
    private ListView list_auditdata;
    private Button but_audit_submit;
    private AuditResponse mAudit;
    private AuditAdapter mAuditAdapter;
    private  SwitchImageView switch_audit;
    private  HashMap<String, Object> map2 = new HashMap<>();
    private HashMap<Integer,Boolean> mData;
    private HashMap<Integer,String>  TextData;
    private HashMap<Integer,Integer> ColorData;
    private FocusedTextview zhibiao;
    private Map<Integer,Object> map=new HashMap<>();
    private EventSearchResponse event=new EventSearchResponse();
    @Override
    protected int initContentView() {
        return R.layout.activity_audit;
    }
    @Override
    protected void initView() {
        button_menu= (ImageButton) findViewById(R.id.button_menu);
        tv_toolbar= (TextView) findViewById(R.id.tv_toolbar);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        button_menu.setVisibility(TextView.GONE);
        tv_audittime= (TextView) findViewById(R.id.tv_audittime);
        tv_auditdanwei= (FocusedTextview)findViewById(R.id.tv_auditdanwei);
        list_auditdata= (ListView) findViewById(R.id.list_auditdata);
        but_audit_submit= (Button) findViewById(R.id.but_audit_submit);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        EventBus.getDefault().registerSticky(this);
    }
    @Override
    protected void initListener() {
    }
    @Override
    protected void initData() {
        tv_toolbar.setText("数据上报(审核)");
        tv_audittime.setText(mLookData.getAddTime());
        tv_auditdanwei.setText(mLookData.getName());
        toolbar.setNavigationIcon(R.drawable.fanhu);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        HashMap<String,Object> map=new HashMap<>();
        map.put("pageCode", mLookData.getNextPageCode());
        map.put("flowCode",mLookData.getFolwCode());
        map.put("assuUnit", mLookData.getAddName());
        map.put("dataDate", mLookData.getAddTime());
        HttpLoader.get(ConstantsYunZhiShui.URL_AUDIT,map, AuditResponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_AUDIT, this).setTag(this);
    }
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        /**成功网络请求*/
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_AUDIT
                && response instanceof AuditResponse) {
            mAudit = (AuditResponse) response;
            mData = new HashMap<>();
            TextData = new HashMap<>();
            ColorData = new HashMap<>();
            if ("00000".equals(mAudit.getErrorCode())) {
                for (int i = 0; i < mAudit.getData().getMasters().size(); i++) {
                    String panduan = mAudit.getData().getMasters().get(i).getIndeStat();
                    if (panduan.indexOf("通过") != -1) {
                        mData.put(i, true);
                        TextData.put(i, "通过");
                        ColorData.put(i, Color.GREEN);
                    } else {
                        mData.put(i, false);
                        TextData.put(i, "退回");
                        ColorData.put(i, Color.RED);
                    }
                }
                /**判断适配器是否为空*/
                if (mAuditAdapter == null) {
                    mAuditAdapter = new AuditAdapter(this, mAudit.getData().getMasters().size());
                    list_auditdata.setAdapter(mAuditAdapter);
                } else {
                    mAuditAdapter.notifyDataSetChanged();
                }
                but_audit_submit.setOnClickListener(new View.OnClickListener() {
                    /**
                     * 当点击提交按钮时,掉用审核提交接口
                     */
                    @Override
                    public void onClick(View v) {
                        String indeCode = "";
                        for (int i = 0; i < mAudit.getData().getMasters().size(); i++) {
                            if (i == mAudit.getData().getMasters().size() - 1) {
                                indeCode += mAudit.getData().getMasters().get(i).getIndeCode();
                            } else {
                                indeCode += mAudit.getData().getMasters().get(i).getIndeCode() + ",";
                            }
                        }
                        for (int i = 0; i < mData.size(); i++) {
                            if (mData.get(i)) {
                                String sss = mLookData.getNode_name() + "通过";
                                try {
                                    URLEncoder.encode(sss, "UTF-8");
                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                }
                                map2.put("chkResult_" + mAudit.getData().getMasters().get(i).getIndeCode(), sss);
                            } else {
                                String sss = mLookData.getNode_name() + "退回";
                                try {
                                    URLEncoder.encode(sss, "UTF-8");
                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                }
                                map2.put("chkResult_" + mAudit.getData().getMasters().get(i).getIndeCode(), sss);
                            }
                        }
                        map2.put("flowCode", mLookData.getFolwCode());
                        map2.put("assuUnit", mLookData.getAddName());
                        map2.put("dataDate", mLookData.getAddTime());
                        map2.put("id", mLookData.getEid());
                        map2.put("extId", mLookData.getExtId());
                        String ss = mLookData.getUpStat();
                        try {
                            URLEncoder.encode(ss, "UTF-8");
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        map2.put("upStat", ss);
                        map2.put("flowNodeCode", mLookData.getFlowNodeCode());
                        map2.put("nodeIndex", mLookData.getNodeInex());
                        map2.put("indeCode", indeCode);
                        HttpLoader.get(ConstantsYunZhiShui.URL_AUDIT_SUBMIT, map2, AuditSubmitResponse.class,
                                ConstantsYunZhiShui.REQUEST_CODE_AUDIT_SUBMIT, AuditActivity.this, false).setTag(this);
                    }
                });
            }
        }
        if(requestCode == ConstantsYunZhiShui.REQUEST_CODE_AUDIT_SUBMIT
                && response instanceof AuditSubmitResponse){
            AuditSubmitResponse  mAuditSubmit =(AuditSubmitResponse) response;
            if("00000".equals(mAuditSubmit.getErrorCode())){
                           /**跳转到*/
                Toast.makeText(AuditActivity.this, "已提交", Toast.LENGTH_SHORT).show();
                event.setFlowCode(mLookData.getFolwCodes());
                event.setTableName(mLookData.getTableName());
                event.setTitleName(mLookData.getTitleName());
                EventBus.getDefault().postSticky(event);
                Intent intent=new Intent(AuditActivity.this,WaterworksDayActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }
    public void onEvent(EventLookData lookdata){
        mLookData=lookdata;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        HttpLoader.cancelRequest(this);
    }


    public class AuditAdapter extends BaseAdapter{
        private Context mContext;
        int mCount;
        public AuditAdapter(Context context,int count){
            mContext=context;
            mCount=count;
        }
        @Override
        public int getCount() {
            return  mCount;
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
                convertView = View.inflate(mContext, R.layout.item_audit, null);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.iv_audit_zhibiao.setText(mAudit.getData().getMasters().get(position).getIndeName());

            String ss = mAudit.getData().getMasters().get(position).getIndeValue();
            String s = mAudit.getData().getMasters().get(position).getDataUnit();
            if (s == null) {
                s = "";
            }
            if (ss!=null){
                if (ss.length() >= 7) {
                    ss.substring(0,6);
                 }
              }else{
                ss="";
            }
            holder.iv_audit_shuju.setText(ss+s);
            /**通过滑动开关的状态改变值*/
            String panduan=mAudit.getData().getMasters().get(position).getIndeStat();
            if(panduan.indexOf("通过")!=-1){
                holder.iv_audit_panduan.setTextColor(Color.GREEN);
            }else{
                holder.iv_audit_panduan.setTextColor(Color.RED);
            }
            holder.position=position;
            holder.switch_audit.setSwitchstatus(mData.get(position));
            holder.iv_audit_panduan.setText(TextData.get(position));
            holder.iv_audit_panduan.setTextColor(ColorData.get(position));
            return convertView;
        }
    }
    class ViewHolder{
         TextView iv_audit_zhibiao,iv_audit_shuju,iv_audit_panduan;
         SwitchImageView switch_audit;
         int position;
        public ViewHolder(View v) {
            iv_audit_shuju = (TextView) v.findViewById(R.id.iv_audit_shuju);
            iv_audit_zhibiao = (TextView) v.findViewById(R.id.iv_audit_zhibiao);
            iv_audit_panduan = (TextView) v.findViewById(R.id.iv_audit_panduan);
            switch_audit = (SwitchImageView) v.findViewById(R.id.switch_audit);
            switch_audit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ((iv_audit_panduan.getText().toString()).indexOf("通过") != -1) {
                        switch_audit.changeSwitchstatus();
                        mData.put(position, false);
                        iv_audit_panduan.setText("退回");
                        TextData.put(position, "退回");
                        ColorData.put(position,Color.RED);
                        iv_audit_panduan.setTextColor(Color.RED);
                    }else if ((iv_audit_panduan.getText() + "").indexOf("退回") != -1) {
                        switch_audit.changeSwitchstatus();
                        iv_audit_panduan.setText("通过");
                        iv_audit_panduan.setTextColor(Color.GREEN);
                        mData.put(position, true);
                        TextData.put(position, "通过");
                        ColorData.put(position,Color.GREEN);
                    }
            }
            });
        }
    }
}
