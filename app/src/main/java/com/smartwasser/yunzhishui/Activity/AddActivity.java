package com.smartwasser.yunzhishui.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.AddUnitResponse;
import com.smartwasser.yunzhishui.bean.EventLookData;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.MasterListResponse;
import com.smartwasser.yunzhishui.bean.SaveResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.DialogTimeUtils;
import com.smartwasser.yunzhishui.utils.PopupWindowUtils;

import org.seny.android.utils.MyToast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import de.greenrobot.event.EventBus;
/**
 * Created by huangmengjie on 2016/5/5 0005.
 */
public class AddActivity extends BaseActivity implements View.OnClickListener,HttpLoader.ResponseListener {
    private ImageButton button_menu;
    private ImageButton norm_ser;
    private TextView tv_toolbar;
    private EditText ed_addtime, ed_danwei;
    private ListView list_adddata;
    private MasterListResponse mToadd;
    private DialogTimeUtils dialog=new DialogTimeUtils(this);
    private MyAdapter myAdapter;
    private Toolbar toolbar;
    private ToaddAdapter mToaddAdapter;
    private String id;
    private AddUnitResponse maddUtil;
    private ListView mListViews;
    private String assuUnit;
    private String addTime;
    private SaveResponse mSave;
    private EventLookData mLookData;
    private  String pageCode;
    private  String defaultStartDate;
    private String indeCode="";
    private String pid="";
    private String indeValue="";
    private   ListView minitListView;
    private Map<Integer, String> mMapContent;
    private int i=1;
    private int index=-1;

    private EventSearchResponse event=new EventSearchResponse();
    @Override
    protected int initContentView() {
        return R.layout.activity_adddata;
    }
    @Override
    protected void initView() {
        button_menu = (ImageButton) findViewById(R.id.button_menu);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        button_menu.setVisibility(View.GONE);
        tv_toolbar = (TextView) findViewById(R.id.tv_toolbar);
        ed_addtime = (EditText) findViewById(R.id.ed_addtime);
        ed_danwei = (EditText) findViewById(R.id.ed_adddanwei);
        list_adddata = (ListView) findViewById(R.id.list_adddata);
        norm_ser= (ImageButton) findViewById(R.id.norm_ser);
        norm_ser.setVisibility(View.VISIBLE);
        norm_ser.setBackgroundResource(R.drawable.save_selector);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        EventBus.getDefault().registerSticky(this);
    }
    @Override
    protected void initListener() {
        ed_addtime.setOnClickListener(this);
        ed_danwei.setOnClickListener(this);
        norm_ser.setOnClickListener(this);
    }
    @Override
    protected void initData() {
        mMapContent = new HashMap<Integer, String>();
        tv_toolbar.setText("数据上报(填报)");
        toolbar.setNavigationIcon(R.drawable.fanhu);
        Date dNow = new Date();   //当前时间
        Date dBefore = new Date();
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.add(Calendar.DAY_OF_MONTH, -1);//设置为前一天
        dBefore = calendar.getTime();   //得到前一天的时间
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式
        defaultStartDate = sdf.format(dBefore);    //格式化前一天
        ed_addtime.setText(defaultStartDate);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
              /**发起网络请求*/
        addTime=ed_addtime.getText().toString().trim();
        if(TextUtils.isEmpty(addTime)){
            Toast.makeText(AddActivity.this, "请输入时间", Toast.LENGTH_SHORT).show();
        }else{
            //发起网络请求
            HashMap<String, Object> params = new HashMap<>();
            id=mLookData.getWork_id();
            params.put("id",id);
            params.put("dataDate", addTime);
            HttpLoader.get(ConstantsYunZhiShui.URL_ADDUNit, params, AddUnitResponse.class,
                    ConstantsYunZhiShui.REQUEST_CODE_ADDUNit, this,false).setTag(this);
        }
    }
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if(requestCode == ConstantsYunZhiShui.REQUEST_CODE_ADDUNit
                && response instanceof AddUnitResponse){
               maddUtil = (AddUnitResponse) response;

            if("00014".equals(  maddUtil.getErrorCode())){
                Toast.makeText(AddActivity.this, "今天填报完成", Toast.LENGTH_SHORT).show();
            }
            if(i==1) {
                if (ed_addtime.getText().toString().equals(defaultStartDate)) {
                    if (maddUtil.getData() != null) {
                        if (maddUtil.getData().getPageBuList().get(0) != null) {
                            ed_danwei.setText(maddUtil.getData().getPageBuList().get(0).getBusinessUnitName());
                            assuUnit = maddUtil.getData().getPageBuList().get(0).getBusinessUnitCode();
                        }
                        if (ed_danwei.getText().toString() != null) {
                            pageCode = mLookData.getWork_pageCode();
                            showProgressDialog();
                            HashMap<String, Object> params2 = new HashMap<>();
                            params2.put("pageCode", pageCode);
                            params2.put("assuUnit", assuUnit);
                            HttpLoader.get(ConstantsYunZhiShui.URL_MASTERlIST, params2, MasterListResponse.class,
                                    ConstantsYunZhiShui.REQUEST_CODE_MASTERlIST, AddActivity.this, false).setTag(this);
                            showProgressDialog();
                        }

                    }
                }
            }
            if(i!=1) {
                myAdapter = new MyAdapter();
                minitListView.setAdapter(myAdapter);
                minitListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        /**再发起一次网络请求*/
                        assuUnit = maddUtil.getData().getPageBuList().get(position).getBusinessUnitCode();
                        pageCode = mLookData.getWork_pageCode();
                        showProgressDialog();
                        HashMap<String, Object> params2 = new HashMap<>();
                        params2.put("pageCode", pageCode);
                        params2.put("assuUnit", assuUnit);
                        HttpLoader.get(ConstantsYunZhiShui.URL_MASTERlIST, params2, MasterListResponse.class,
                                ConstantsYunZhiShui.REQUEST_CODE_MASTERlIST, AddActivity.this, false).setTag(this);
                        showProgressDialog();
                        ed_danwei.setText(maddUtil.getData().getPageBuList().get(position).getBusinessUnitName());
                        // pw.dismiss();
                        PopupWindowUtils.closePopupWindow();

                    }
                });
            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_MASTERlIST
                && response instanceof MasterListResponse) {
                mToadd = (MasterListResponse) response;
                if(mToadd.getData()!=null) {
                    mToaddAdapter = new ToaddAdapter(this,mToadd.getData().getMasters().size());
                    list_adddata.setAdapter(mToaddAdapter);
                }
            dismissProgressDialog();
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_SAVE
                && response instanceof SaveResponse) {
               mSave = (SaveResponse) response;
            if("00000".equals(mSave .getErrorCode())){
                        /**保存成功,跳转*/
                 event.setFlowCode(mLookData.getFolwCodes());
                 event.setTableName(mLookData.getTableName());
                 event.setTitleName(mLookData.getTitleName());
                 EventBus.getDefault().postSticky(event);
                 Toast.makeText(AddActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
                 Intent intent3=new Intent(AddActivity.this,WaterworksDayActivity.class);
                 startActivity(intent3);
                 finish();
            }
        }
        dismissProgressDialog();
    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
        dismissProgressDialog();
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.ed_addtime:
                dialog.show(ed_addtime);
                dialog.showTime();
                break;
            case R.id.ed_adddanwei:
                //初始化ListView控件和里边的数据
                minitListView = initListView();
                ++i;
                PopupWindowUtils.showPopupWindow(minitListView,ed_danwei);
                break;
            case R.id.norm_ser:
                       /**点击保存*/
                String flowCode=mLookData.getWork_flowCode();
                String nodeIndex=mLookData.getWork_nodeIndex();
                String upStat=mLookData.getWork_upStat();
                if(mToadd==null){
                    Toast.makeText(AddActivity.this, "请选择单位名", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    for (int i = 0; i < mToadd.getData().getMasters().size(); i++) {
                        if (i == mToadd.getData().getMasters().size() - 1) {
                            indeCode += mToadd.getData().getMasters().get(i).getIndeCode();
                            pid += mToadd.getData().getMasters().get(i).getPid();
                        } else {
                            indeCode += mToadd.getData().getMasters().get(i).getIndeCode() + ",";
                            pid += mToadd.getData().getMasters().get(i).getPid() + ",";
                        }
                    }
                }
                try {
                    URLEncoder.encode(upStat,"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                String flowNodeCode=mLookData.getWork_flowNodeCode();
                for(int j=0;j<mMapContent.size();j++){
                    if(j==mMapContent.size()) {
                        indeValue += mMapContent.get(j);
                    }else{
                        indeValue += mMapContent.get(j)+",";
                    }
                }

                try {
                    indeValue=indeValue+","+"234";
                    URLEncoder.encode(indeValue,"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                showProgressDialog();
                HashMap<String, Object> params3 = new HashMap<>();
                params3.put("flowCode", flowCode);
                params3.put("nodeIndex",nodeIndex);
                params3.put("upStat",upStat);
                params3.put("flowNodeCode",flowNodeCode);
                params3.put("indeCode",indeCode);
                params3.put("pid",pid);
                params3.put("indeValue",indeValue);
                params3.put("assuUnit",assuUnit);
                params3.put("dataDate",addTime);
                HttpLoader.get(ConstantsYunZhiShui.URL_SAVE, params3, SaveResponse.class,
                        ConstantsYunZhiShui.REQUEST_CODE_SAVE, this,false).setTag(this);
                showProgressDialog();
                break;
        }
    }

    private ListView initListView() {
        mListViews = new ListView(this);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        /**发起网络请求*/
        addTime=ed_addtime.getText().toString().trim();
        if(TextUtils.isEmpty(addTime)){
            Toast.makeText(AddActivity.this, "请输入时间", Toast.LENGTH_SHORT).show();
        }else{
            /**发起网络请求*/
            HashMap<String, Object> params = new HashMap<>();
            params.put("id", id);
            params.put("dataDate",addTime);
            HttpLoader.get(ConstantsYunZhiShui.URL_ADDUNit, params, AddUnitResponse.class,
                    ConstantsYunZhiShui.REQUEST_CODE_ADDUNit, this,false).setTag(this);
        }
        return mListViews;
    }
    class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            if("00014".equals(maddUtil.getErrorCode())){
                return 0;
            }
            return maddUtil.getData().getPageBuList().size();
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
                convertView = View.inflate(AddActivity.this, R.layout.item_popup, null);
                holder.v_listview_item_number = (TextView) convertView.findViewById(R.id.tv_listview_item_number);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.v_listview_item_number.setText(maddUtil.getData().getPageBuList().get(position).getBusinessUnitName());
            return convertView;
        }
    }
    class ViewHolder {
        TextView v_listview_item_number;
    }
    public void onEvent(EventLookData lookData){
        mLookData=lookData;
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
        dismissProgressDialog();
    }
    public class ToaddAdapter extends BaseAdapter {
        int mCount;
        Context mContext;
        public ToaddAdapter(Context context, int count)
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
                convertView=View.inflate(mContext, R.layout.item_toadd,null);
                holder=new ViewHolder(convertView);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolder) convertView.getTag();
            }
            holder.position =position;
            if(mCount>mMapContent.size()){
                for(int i=position;mMapContent.size()<mCount;i++){
                    mMapContent.put(i,"");
                }
            }
            holder.tv_toadd_center.setText(mToadd.getData().getMasters().get(position).getIndeName());
            holder.danwei.setText(mToadd.getData().getMasters().get(position).getDataUnit());
            holder.ed_to_adddata.setText(mMapContent.get(position));
            holder.ed_to_adddata.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        index =holder.position;
                    }
                    return false;
                }
            });
         /*并且在getView方法结束前为EditText添加焦点：*/
            holder.ed_to_adddata.clearFocus();
            if (index != -1 && index == position) {
                // 如果当前的行下标和点击事件中保存的index一致，手动为EditText设置焦点。
                holder.ed_to_adddata.requestFocus();
                 holder.ed_to_adddata.setSelection(holder.ed_to_adddata.getText().length());
            }

            return convertView;
        }
        class ViewHolder{
            TextView tv_toadd_center,danwei;
            EditText ed_to_adddata;
            int position;
            public ViewHolder(View v)
            {
                tv_toadd_center = (TextView)v.findViewById(R.id.tv_toadd_center);
                ed_to_adddata= (EditText)v.findViewById(R.id.ed_to_adddata);
                danwei= (TextView)v.findViewById(R.id.danwei);
                ed_to_adddata.addTextChangedListener(new TextWatcher()
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
