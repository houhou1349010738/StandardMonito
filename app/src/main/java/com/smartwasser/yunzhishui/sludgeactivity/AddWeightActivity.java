package com.smartwasser.yunzhishui.sludgeactivity;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.SaveResponse;
import com.smartwasser.yunzhishui.bean.WeightCzdResponse;
import com.smartwasser.yunzhishui.bean.WnTypeComResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.DialogSludgeTimeUtils;
import com.smartwasser.yunzhishui.utils.DialogTimeUtils;
import com.smartwasser.yunzhishui.utils.PopupWindowUtils;

import org.seny.android.utils.MyToast;

import java.util.HashMap;

import de.greenrobot.event.EventBus;

/**
 * Created by huangmengjie on 2016/7/13 0013.
 */
public class AddWeightActivity extends BaseActivity implements View.OnClickListener,HttpLoader.ResponseListener {
    private ImageButton but_image;
    private TextView tv_toolbar;
    private EditText ed_weight_cp, ed_weight_czdss, ed_weight_add_pzsj, ed_weight_add_pz, ed_weight_add_mzsj, ed_weight_add_mz, ed_weight_jz, ed_weight_add_xzjz,
            ed_weight_add_wnzl, ed_weight_add_bz, ed_weight_add_sjly;
    private ImageButton but_weight_cp, but_weight_add_czds,
            but_weight_add_pzsj, but_weight_add_mzsj,
            but_weight_add_wnzl;
    private ListView minlistView, minlistView2;
    private Button but_baocun;
    private MyAdapter myAdapters;
    private WnTypeComResponse mWnType;
    private WnTypeAdapter mWnMyAdapter;
    private WeightCzdResponse mWeighTCzd;
    private DialogSludgeTimeUtils dialog = new DialogSludgeTimeUtils(this);
    private EventSearchResponse serc;

    @Override
    protected int initContentView() {
        return R.layout.activity_add_weight;
    }
    @Override
    protected void initView() {
        ed_weight_cp = (EditText) findViewById(R.id.ed_weight_cp);
        but_image = (ImageButton) findViewById(R.id.button_menu);
        tv_toolbar = (TextView) findViewById(R.id.tv_toolbar);
        ed_weight_czdss = (EditText) findViewById(R.id.ed_weight_czdss);
        ed_weight_add_pzsj = (EditText) findViewById(R.id.ed_weight_add_pzsj);
        ed_weight_add_pz = (EditText) findViewById(R.id.ed_weight_add_pz);
        ed_weight_add_mzsj = (EditText) findViewById(R.id.ed_weight_add_mzsj);
        ed_weight_add_mz = (EditText) findViewById(R.id.ed_weight_add_mz);
        ed_weight_jz = (EditText) findViewById(R.id.ed_weight_jz);
        ed_weight_add_sjly = (EditText) findViewById(R.id.ed_weight_add_sjly);
        ed_weight_add_xzjz = (EditText) findViewById(R.id.ed_weight_add_xzjz);
        ed_weight_add_wnzl = (EditText) findViewById(R.id.ed_weight_add_wnzl);
        ed_weight_add_bz = (EditText) findViewById(R.id.ed_weight_add_bz);
        but_weight_cp = (ImageButton) findViewById(R.id.but_weight_cp);
        but_weight_add_czds = (ImageButton) findViewById(R.id.but_weight_add_czds);
        but_weight_add_pzsj = (ImageButton) findViewById(R.id.but_weight_add_pzsj);
        but_weight_add_mzsj = (ImageButton) findViewById(R.id.but_weight_add_mzsj);
        but_weight_add_wnzl = (ImageButton) findViewById(R.id.but_weight_add_wnzl);
        but_baocun = (Button) findViewById(R.id.but_baocun);
        EventBus.getDefault().registerSticky(this);
    }

    @Override
    protected void initListener() {
        ed_weight_czdss.setOnClickListener(this);
        but_weight_cp.setOnClickListener(this);
        ed_weight_add_pzsj.setOnClickListener(this);
        ed_weight_add_mzsj.setOnClickListener(this);
        ed_weight_add_wnzl.setOnClickListener(this);
        but_baocun.setOnClickListener(this);
        but_image.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        but_image.setBackgroundResource(R.drawable.fanhu);
        tv_toolbar.setText("数据称重添加");
        if(serc!=null){
            ed_weight_cp.setText(serc.getCph());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_menu:
                finish();
                break;
            case R.id.ed_weight_czdss:
                /**称重点*/
                minlistView = initListView();
                PopupWindowUtils.showPopupWindow(minlistView, ed_weight_czdss);
                break;
            case R.id.but_weight_cp:
                /**跳到选择车辆页面*/
                Intent intent = new Intent(AddWeightActivity.this, CarActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id. ed_weight_add_pzsj:
                /**皮重时间*/
                dialog.show2(ed_weight_add_pzsj);
                dialog.showTime2();
                break;
            case R.id.ed_weight_add_mzsj:
                /**毛重时间*/
                dialog.show2(ed_weight_add_mzsj);
                dialog.showTime2();
                break;
            case R.id. ed_weight_add_wnzl:
                /**污泥种类*/
                minlistView2 = initListView2();
                PopupWindowUtils.showPopupWindow(minlistView2,ed_weight_add_wnzl);
                break;
            case R.id.but_baocun:
                /**保存*/
                /**发起网络请求*/
                HashMap<String, Object> prams = new HashMap<>();
                String s=ed_weight_cp.getText().toString();
                String czd=ed_weight_czdss.getText().toString();
                String pzsj=ed_weight_add_pzsj.getText().toString();
                String pz=ed_weight_add_pz.getText().toString();
                String mzsj=ed_weight_add_mzsj.getText().toString();
                String mz=ed_weight_add_mz.getText().toString();
                String jz=ed_weight_jz.getText().toString();
                String xzjz=ed_weight_add_xzjz.getText().toString();
                String wnzl=ed_weight_add_wnzl.getText().toString();
                String bz=ed_weight_add_bz.getText().toString();
                if("".equals(bz)||"null".equals(bz)||bz==null){
                    Toast.makeText(AddWeightActivity.this, "备注为必填项", Toast.LENGTH_SHORT).show();
                    return;
                }
                if("".equals(pz)||"null".equals(pz)||pz==null){
                    Toast.makeText(AddWeightActivity.this, "请填写皮重", Toast.LENGTH_SHORT).show();
                    return;
                }
                String czdIds="";
                if(!"".equals(czd)||!"null".equals(czd)||czd!=null) {
                    for (int j=0;j< mWeighTCzd .getData().getWeightPointManagement().size();j++) {
                          if(czd.equals(mWeighTCzd .getData().getWeightPointManagement().get(j).getText())){
                              czdIds=mWeighTCzd .getData().getWeightPointManagement().get(j).getId();
                          }
                    }
                }
                /*String wnzlId="";
                if(!"".equals(wnzl)||!"null".equals(wnzl)||wnzl!=null) {
                    for (int i=0;i<mWnType.getData().getWnType().size();i++) {
                          if(wnzl.equals(mWnType.getData().getWnType().get(i).getText())){
                              wnzlId=mWnType.getData().getWnType().get(i).getId();
                          }
                    }
                }*/
                /**从car两选择传过来*/
                prams.put("carNoName",s);
                prams.put("busiUnit",czdIds);
                prams.put("tareTime",pzsj);
                prams.put("tareWeight",pz);
                prams.put("grossTime",mzsj);
                prams.put("grossWeight",mz);
                prams.put("netWeight",jz);
                prams.put("updateNetWeight", xzjz);
                prams.put("wnKind",wnzl);
                prams.put("remark",bz);
                prams.put("dataSource","1");
                HttpLoader.get(ConstantsYunZhiShui.URL_TRANPORTTOSAVE, prams,
                        SaveResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TRANPORTTOSAVE, this, false).setTag(this);
                break;
        }
    }
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TRANPORTPOINT
                && response instanceof WeightCzdResponse) {
            mWeighTCzd = (WeightCzdResponse) response;
            myAdapters = new MyAdapter();
            minlistView.setAdapter(myAdapters);
            minlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    ed_weight_czdss.setText(mWeighTCzd.getData().getWeightPointManagement().get(position).getText());
                    PopupWindowUtils.closePopupWindow();
                }
            });
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TRANPORTTYPECOM
                && response instanceof WnTypeComResponse) {
            mWnType = (WnTypeComResponse) response;
            mWnMyAdapter = new WnTypeAdapter();
            minlistView2.setAdapter(mWnMyAdapter);
            minlistView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    ed_weight_add_wnzl.setText(mWnType.getData().getWnType().get(position).getText());
                    PopupWindowUtils.closePopupWindow();
                }
            });
        }
        if(requestCode == ConstantsYunZhiShui.REQUEST_CODE_TRANPORTTOSAVE
                && response instanceof SaveResponse){
            SaveResponse mSave=(SaveResponse)response;
             if("00000".equals(mSave.getErrorCode())){
                 Toast.makeText(AddWeightActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
                 Intent intent=new Intent(AddWeightActivity.this,WeightActivity.class);
                 startActivity(intent);
                 finish();
             }
        }
    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }

    class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return mWeighTCzd.getData().getWeightPointManagement().size();
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
                convertView = View.inflate(AddWeightActivity.this, R.layout.item_search, null);
                holder.v_listview_item_number = (TextView) convertView.findViewById(R.id.tv_listview_item_number);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (position == 0) {
                holder.v_listview_item_number.setTextColor(Color.GRAY);
            }
            holder.v_listview_item_number.setText(mWeighTCzd.getData().getWeightPointManagement().get(position).getText());
            return convertView;
        }
    }

    class ViewHolder {
        TextView v_listview_item_number;
    }

    class WnTypeAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return mWnType.getData().getWnType().size();
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
                convertView = View.inflate(AddWeightActivity.this, R.layout.item_search, null);
                holder.v_listview_item_number = (TextView) convertView.findViewById(R.id.tv_listview_item_number);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (position == 0) {
                holder.v_listview_item_number.setTextColor(Color.GRAY);
            }
            holder.v_listview_item_number.setText(mWnType.getData().getWnType().get(position).getText());
            return convertView;
        }
    }
    private ListView initListView() {
        ListView mListViews = new ListView(this);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        /**发起网络请求*/
        HashMap<String, Object> prams = new HashMap<>();
        HttpLoader.get(ConstantsYunZhiShui.URL_TRANPORTPOINT, prams,
                WeightCzdResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TRANPORTPOINT, this, false).setTag(this);
        return mListViews;
    }
    private ListView initListView2() {
        ListView mListViews = new ListView(this);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        /**发起网络请求*/
        HashMap<String, Object> prams = new HashMap<>();
        HttpLoader.get(ConstantsYunZhiShui.URL_TRANPORTTYPECOM, prams,
                WnTypeComResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TRANPORTTYPECOM, this, false).setTag(this);
        return mListViews;
    }
    public void onEvent(EventSearchResponse ser){
            serc=ser;
    }
}
