package com.smartwasser.yunzhishui.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.AmendResponse;
import com.smartwasser.yunzhishui.bean.AmendSaveResponse;
import com.smartwasser.yunzhishui.bean.AmendSubmitResponse;
import com.smartwasser.yunzhishui.bean.EventLookData;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.ListViewHeightUtils;
import com.smartwasser.yunzhishui.view.FocusedTextview;

import org.seny.android.utils.MyToast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import de.greenrobot.event.EventBus;
/**
 * Created by huangmengjie on 2016/5/9 0009.
 */
public class AmendActivity extends BaseActivity implements HttpLoader.ResponseListener,View.OnClickListener{
    private  ImageButton button_menu;
    private  TextView tv_toolbar,tv_amendtime;
    private FocusedTextview tv_amenddanwei;
    private  ListView list_amenddata;
    private  Button but_amend_save,but_tijiao;
    private  AmendAdapter amendAdapter;
    private  AmendResponse mAmendResponse;
    private  EventLookData mlookData;
    private  Toolbar toolbar;
    private  String indeCode="";
    private int index=-1;
    private Map<Integer,String> mMapContent;
    private EventSearchResponse event=new EventSearchResponse();
    @Override
    protected int initContentView() {
        return R.layout.activity_amend;
    }
    @Override
    protected void initView() {
        button_menu= (ImageButton) findViewById(R.id.button_menu);
        tv_toolbar= (TextView) findViewById(R.id.tv_toolbar);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        list_amenddata= (ListView)findViewById(R.id.list_amenddata);
        but_amend_save= (Button) findViewById(R.id.but_amend_save);
        tv_amendtime= (TextView) findViewById(R.id.tv_amendtime);
        tv_amenddanwei= (FocusedTextview) findViewById(R.id.tv_amenddanwei);
        but_tijiao= (Button) findViewById(R.id.but_tijiao);
        button_menu.setVisibility(View.GONE);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        EventBus.getDefault().registerSticky(this);
    }
    @Override
    protected void initListener() {
        but_tijiao.setOnClickListener(this);
        but_amend_save.setOnClickListener(this);
    }
    @Override
    protected void initData(){
        tv_toolbar.setText("数据上报(修改)");
        toolbar.setNavigationIcon(R.drawable.fanhu);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tv_amendtime.setText(mlookData.getAddTime());
        tv_amenddanwei.setText(mlookData.getName());
        showProgressDialog();
        HashMap<String,Object> map=new HashMap<>();
        map.put("flowCode", mlookData.getWork_flowCode());
        map.put("assuUnit", mlookData.getAddName());
        map.put("dataDate", mlookData.getAddTime());
        map.put("pageCode", mlookData.getNextPageCode());
        HttpLoader.get(ConstantsYunZhiShui.URL_AMEND, map, AmendResponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_AMEND,this,false).setTag(this);
        showProgressDialog();
    }
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_AMEND
                && response instanceof AmendResponse) {
            mAmendResponse = (AmendResponse) response;
            mMapContent = new HashMap<Integer, String>();
            for (int i = 0; i < mAmendResponse.getData().getMasters().size(); i++) {
                mMapContent.put(i,mAmendResponse.getData().getMasters().get(i).getIndeValue());
            }
                amendAdapter=new AmendAdapter(this,mAmendResponse.getData().getMasters().size());
                list_amenddata.setAdapter(amendAdapter);
                ListViewHeightUtils.setListViewHeight(list_amenddata);
            dismissProgressDialog();
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_UPDATA_SUBMIT
                && response instanceof AmendSubmitResponse) {
            AmendSubmitResponse mAmendSubmit = (AmendSubmitResponse) response;
            if ("00000".equals(mAmendSubmit.getErrorCode())) {
                Toast.makeText(AmendActivity.this, "已提交", Toast.LENGTH_SHORT).show();
                event.setFlowCode(mlookData.getFolwCodes());
                event.setTableName(mlookData.getTableName());
                event.setTitleName(mlookData.getTitleName());
                EventBus.getDefault().postSticky(event);
                Intent intent = new Intent(AmendActivity.this, WaterworksDayActivity.class);
                startActivity(intent);
                finish();
            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_UPDATA_SAVE
                && response instanceof AmendSaveResponse) {
            AmendSaveResponse mAmendSave = (AmendSaveResponse) response;
            if ("00000".equals(mAmendSave.getErrorCode())) {
                Toast.makeText(AmendActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
                event.setFlowCode(mlookData.getFolwCodes());
                event.setTableName(mlookData.getTableName());
                event.setTitleName(mlookData.getTitleName());
                EventBus.getDefault().postSticky(event);
                Intent intent = new Intent(AmendActivity.this, WaterworksDayActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }
    public void onEvent(EventLookData lookData) {
        mlookData = lookData;
    }

    @Override
    public void onClick(View v) {
        for (int i = 0; i < mAmendResponse.getData().getMasters().size(); i++) {
            if (i == mAmendResponse.getData().getMasters().size() - 1) {
                indeCode += mAmendResponse.getData().getMasters().get(i).getIndeCode();
            } else {
                indeCode += mAmendResponse.getData().getMasters().get(i).getIndeCode() + ",";
            }
        }
        switch (v.getId()) {
            /**保存*/
            case R.id.but_amend_save:
                HashMap<String, Object> map3 = new HashMap<>();
                String indeValue = "";
                for (int j = 0; j < mMapContent.size();j++) {
                    if (j == mMapContent.size()) {
                        indeValue += mMapContent.get(j);
                    } else {
                        indeValue += mMapContent.get(j)+ ",";
                    }
                }
                indeValue=indeValue+","+"566";
                map3.put("flowCode", mlookData.getAddNode_flowCode());
                String ss = mlookData.getAddNode_upstat();
                try {
                    URLEncoder.encode(ss, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                try {
                    URLEncoder.encode(indeValue, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                map3.put("upStat", ss);
                map3.put("flowNodeCode", mlookData.getAddNode_flowNodeCode());
                map3.put("nodeInex", mlookData.getAddNode_nodeInex());
                map3.put("assuUnit", mlookData.getAddName());
                map3.put("dataDate", mlookData.getAddTime());
                map3.put("id", mlookData.getEid());
                map3.put("extId", mlookData.getExtId());
                map3.put("indeValue", indeValue);
                map3.put("indeCode", indeCode);
                HttpLoader.get(ConstantsYunZhiShui.URL_UPDATA_SAVE, map3, AmendSaveResponse.class,
                        ConstantsYunZhiShui.REQUEST_CODE_UPDATA_SAVE, this,false).setTag(this);
                break;
            case R.id.but_tijiao:
                /**调用提交接口*/
                HashMap<String, Object> map2 = new HashMap<>();
                String indeValues = "";
                for (int n = 0;n <mMapContent.size(); n++) {
                    if (n == mMapContent.size()){
                        indeValues += mMapContent.get(n);
                    } else {
                        indeValues +=mMapContent.get(n)+ ",";
                    }
                }
                try {
                    indeValues=indeValues+","+"566";
                    URLEncoder.encode(indeValues, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                map2.put("flowCode", mlookData.getAddNode_flowCode());
                String sss = mlookData.getAddNode_upstat();
                try {
                    URLEncoder.encode(sss, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                map2.put("upStat", sss);
                map2.put("flowNodeCode", mlookData.getAddNode_flowNodeCode());
                map2.put("nodeIndex", mlookData.getAddNode_nodeInex());
                map2.put("assuUnit", mlookData.getAddName());
                map2.put("dataDate", mlookData.getAddTime());
                map2.put("id", mlookData.getEid());
                map2.put("extId", mlookData.getExtId());
                map2.put("indeValue", indeValues);
                map2.put("indeCode", indeCode);
                HttpLoader.get(ConstantsYunZhiShui.URL_UPDATA_SUBMIT, map2, AmendSubmitResponse.class,
                        ConstantsYunZhiShui.REQUEST_CODE_UPDATA_SUBMIT, this,false).setTag(this);
                break;
        }
    }
    @Override
    protected void onStop() {
        HttpLoader.cancelRequest(this);
        super.onStop();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    public class AmendAdapter extends BaseAdapter {
        int mCount;
        Context mContext;
        public AmendAdapter(Context context, int count)
        {
            mCount = count;
            mContext = context;
        }
        @Override
        public int getCount() {
            return mCount;
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
            final ViewHolder holder;
            if(convertView==null){
                convertView=View.inflate(mContext,R.layout.item_amend,null);
                holder=new ViewHolder(convertView);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolder) convertView.getTag();
            }
            holder.position =position;
            String stat=mAmendResponse.getData().getMasters().get(position).getIndeStat();
            holder.tv_stat.setText(stat);
            if(stat.indexOf("通过")!=-1){
                holder.tv_stat.setTextColor(Color.GREEN);
                holder.ed_to_amend.setVisibility(View.GONE);
                holder.tv_yingcong.setVisibility(View.VISIBLE);
                holder.tv_yingcong.setText(mAmendResponse.getData().getMasters().get(position).getIndeValue());
                holder.tv_amend_danwei.setTextColor(Color.GREEN);
            }else if(stat.indexOf("退回")!=-1){
                holder.tv_stat.setTextColor(Color.RED);
                holder.ed_to_amend.setVisibility(View.VISIBLE);
                holder.tv_yingcong.setVisibility(View.GONE);
            }else{
                holder.tv_stat.setTextColor(Color.GREEN);
                holder.ed_to_amend.setVisibility(View.VISIBLE);
                holder.tv_yingcong.setVisibility(View.GONE);
            }
            holder.tv_amend_danwei.setText(mAmendResponse.getData().getMasters().get(position).getDataUnit());
            holder.tv_toadd_amend.setText(mAmendResponse.getData().getMasters().get(position).getIndeName());
            holder.ed_to_amend.setText(mMapContent.get(position));
            holder.ed_to_amend.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        index = holder.position;
                    }
                    return false;
                }
            });
         /*并且在getView方法结束前为EditText添加焦点：*/
            holder.ed_to_amend.clearFocus();
            if (index != -1 && index == position) {
                // 如果当前的行下标和点击事件中保存的index一致，手动为EditText设置焦点。
                holder.ed_to_amend.requestFocus();
                holder.ed_to_amend.setSelection(holder.ed_to_amend.getText().length());
            }
            return convertView;
        }

        class ViewHolder{
            TextView tv_toadd_amend,tv_amend_danwei,tv_stat,tv_yingcong;
            EditText ed_to_amend;
            int position;
            public ViewHolder(View v)
            {
                tv_amend_danwei= (TextView) v.findViewById(R.id.tv_amend_danwei);
                tv_toadd_amend= (TextView) v.findViewById(R.id.tv_toadd_amend);
                tv_stat= (TextView) v.findViewById(R.id.tv_stat);
                ed_to_amend= (EditText) v.findViewById(R.id.ed_to_amend);
                tv_yingcong= (TextView) v.findViewById(R.id.tv_yingcong);
                ed_to_amend.addTextChangedListener(new TextWatcher()
                {
                    public void onTextChanged(CharSequence s, int start, int before, int count)
                    {

                    }
                    public void beforeTextChanged(CharSequence s, int start, int count, int after)
                    {

                    }
                    public void afterTextChanged(Editable s)
                    {
                        mMapContent.put(position,s.toString());
                    }
                });
            }
        }
    }

}

