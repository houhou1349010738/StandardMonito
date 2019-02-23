package com.smartwasser.yunzhishui.deviceactivity;
import android.content.Intent;
import android.graphics.Color;
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
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.SaveResponse;
import com.smartwasser.yunzhishui.bean.WorkDanMxBybwResponse;
import com.smartwasser.yunzhishui.bean.WorkDanMxBylbResponse;
import com.smartwasser.yunzhishui.bean.WorkDanUpdateResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.DialogTimeUtils;
import com.smartwasser.yunzhishui.utils.PopupWindowUtils;

import org.seny.android.utils.MyToast;

import java.util.HashMap;

import de.greenrobot.event.EventBus;

/**
 * Created by huangmengjie on 2016/7/8 0008.
 */
public class WorkDanMxUpdateActivity extends BaseActivity implements View.OnClickListener,HttpLoader.ResponseListener{
    private TextView tv_toolbar;
    private ImageButton button_menu;
    private String  bwCode="";
    private String lbCode="";
    private  WorkDanMxBybwResponse mMxbybw;
    private  WorkDanUpdateResponse    mWorkDanUpdate;
    private  WorkDanMxBylbResponse  mMxBylb;
    private EditText ed_workdan_name,ed_workdan_zcbm,ed_workdan_sydw,ed_workdan_ssdw
            ,ed_workdan_bylb,ed_workdan_bybw,ed_workdan_zyrq,ed_workdan_bynr,ed_workdan_bz;
    private ImageButton but_workdan_name;
    private EventSearchResponse norm;
    private EventNormSelect s=new  EventNormSelect();
    private ListView minlistView,minlistView2;
    private Button but_bianji;
    private  String id;
    private  String MaintainId;
    private DialogTimeUtils dialog=new DialogTimeUtils(this);
    @Override
    protected int initContentView() {
        return R.layout.activity_add_workdanmx;
    }
    @Override
    protected void initView() {
        tv_toolbar= (TextView) findViewById(R.id.tv_toolbar);
        button_menu= (ImageButton) findViewById(R.id.button_menu);
        button_menu.setBackgroundResource(R.drawable.fanhu);
        ed_workdan_name= (EditText) findViewById(R.id.ed_workdan_name);
        ed_workdan_zcbm= (EditText) findViewById(R.id.ed_workdan_zcbm);
        ed_workdan_sydw= (EditText) findViewById(R.id.ed_workdan_sydw);
        ed_workdan_ssdw= (EditText) findViewById(R.id.ed_workdan_ssdw);
        ed_workdan_bylb= (EditText) findViewById(R.id.ed_workdan_bylb);
        ed_workdan_bybw= (EditText) findViewById(R.id.ed_workdan_bybw);
        ed_workdan_zyrq= (EditText) findViewById(R.id.ed_workdan_zyrq);
        ed_workdan_bynr= (EditText) findViewById(R.id.ed_workdan_bynr);
        ed_workdan_bz= (EditText) findViewById(R.id.ed_workdan_bz);
        but_workdan_name= (ImageButton) findViewById(R.id.but_workdan_name);
        but_bianji= (Button) findViewById(R.id.but_bianji);
        EventBus.getDefault().registerSticky(this);
    }

    @Override
    protected void initListener() {
        button_menu.setOnClickListener(this);
        but_workdan_name.setOnClickListener(this);
        ed_workdan_bylb.setOnClickListener(this);
        ed_workdan_bybw.setOnClickListener(this);
        ed_workdan_zyrq.setOnClickListener(this);
        but_bianji.setOnClickListener(this);
    }
    @Override
    protected void initData() {
        tv_toolbar.setText("工单明细修改");
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", norm.getMaintainId());
        HttpLoader.get(ConstantsYunZhiShui.URL_GDMXUPSATEHX, params, WorkDanUpdateResponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_GDMXUPSATEHX, this, false).setTag(this);
        if(norm.getSbName()!=null){
            ed_workdan_name.setText(norm.getSbName());
            ed_workdan_zcbm.setText(norm.getAsCode());
            ed_workdan_sydw.setText(norm.getSbDanwei());
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_menu:
                finish();
                break;
            case R.id.but_workdan_name:
                /**跳到指定的页面选择*/
                int temp=3;
                s.setTemp(temp);
                s.setMainId(mWorkDanUpdate.getData().getEqMaintain().getId());
                EventBus.getDefault().postSticky(s);
                Intent intent=new Intent(WorkDanMxUpdateActivity.this,EquipSelectActivity.class);
                startActivity(intent);
                break;
            case R.id.ed_workdan_bylb:
                /**保养lb*/
                minlistView=initListView();
                PopupWindowUtils.showPopupWindow(minlistView, ed_workdan_bylb);
                break;
            case R.id.ed_workdan_bybw:
                /**保养部位*/
                minlistView2= initListView2();
                PopupWindowUtils.showPopupWindow(minlistView2,ed_workdan_bybw);
                break;
            case R.id. ed_workdan_zyrq:
                /**执行日期*/
                dialog.show( ed_workdan_zyrq);
                dialog.showTime();
                break;
            case R.id.but_bianji:
                /**保存*/
                String s=ed_workdan_name.getText().toString();
                String s2=ed_workdan_zcbm.getText().toString();
                String s3=ed_workdan_sydw.getText().toString();
                String s4=ed_workdan_ssdw.getText().toString();
                String s5=ed_workdan_bylb.getText().toString();
                String s6=ed_workdan_bybw.getText().toString();
                String s7=ed_workdan_zyrq.getText().toString();
                String s8=ed_workdan_bynr.getText().toString();
                String s9=ed_workdan_bz.getText().toString();
                if("".equals(s)||"".equals(s2)||"".equals(s3)||"".equals(s4)
                        ||"".equals(s5)||"".equals(s6)||"".equals(s7)){
                    Toast.makeText(WorkDanMxUpdateActivity.this, "请将信息填写完整", Toast.LENGTH_SHORT).show();
                    return;
                }
                HashMap<String, Object> params = new HashMap<>();
                params.put("equipName",s);
                params.put("id",id);
                params.put("maintainId",MaintainId);
                params.put("equipOwnDept",norm.getSbDanweiCode());
                if( norm!=null) {
                    params.put("equipCode", norm.getSbNameCode());
                }else{
                    params.put("equipCode", mWorkDanUpdate.getData().getEqMaintain().getEquipCode());
                }
                params.put("equipAscode",s2);
                params.put("equipDeptName",s3);
                params.put("maintainUnitName",s4);
                if("".equals(s5)){
                    lbCode="";
                }
                params.put("maintainType",lbCode);
                if("".equals(s6)){
                    bwCode="";
                }
                params.put("maintainPart",bwCode);
                params.put("Sdate",s7);
                if("".equals(s8)||"null".equals(s8)||s8==null){
                    s8="";
                }
                params.put("maintainComment",s8);
                if("".equals(s9)||"null".equals(s9)||s9==null){
                    s9="";
                }
                params.put("maintainRemark",s9);
                HttpLoader.get(ConstantsYunZhiShui.URL_GDMXUPDATE, params, SaveResponse.class,
                        ConstantsYunZhiShui.REQUEST_CODE_GDMXUPDATE, this, false).setTag(this);
                break;

           }
    }
    private ListView initListView() {
        ListView mListViews = new ListView(this);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        /**发起网络请求*/
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("typeCode", "EQ_MAINTAIN_TYPE_CODE");
        HttpLoader.get(ConstantsYunZhiShui.URL_SBBUWEI, prams,
                WorkDanMxBylbResponse.class, ConstantsYunZhiShui.REQUEST_CODE_SBBUWEI, this, false).setTag(this);
        return mListViews;
    }
    private ListView initListView2() {
        ListView mListViews = new ListView(this);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        /**发起网络请求*/
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("typeCode","EQ_PART_CODE");
        HttpLoader.get(ConstantsYunZhiShui.URL_SBBUWEI, prams,
                WorkDanMxBybwResponse.class, ConstantsYunZhiShui.REQUEST_CODE_SBBUWEI, this, false).setTag(this);
        return mListViews;
    }

    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if(requestCode == ConstantsYunZhiShui.REQUEST_CODE_GDMXUPDATE
                && response instanceof SaveResponse){
            SaveResponse save=(SaveResponse)response;
            if("00000".equals(save.getErrorCode())){
                Toast.makeText(WorkDanMxUpdateActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(WorkDanMxUpdateActivity.this,WorkDanNotCompletActivity.class);
                startActivity(intent);
                finish();
            }

        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_GDMXUPSATEHX
                && response instanceof WorkDanUpdateResponse) {
              mWorkDanUpdate = (WorkDanUpdateResponse) response;
            id=mWorkDanUpdate.getData().getEqMaintain().getId();
            MaintainId=mWorkDanUpdate.getData().getEqMaintain().getMaintainId();
            if(norm.getSbName()==null||"".equals(norm.getSbName())){
                ed_workdan_name.setText(mWorkDanUpdate.getData().getEqMaintain().getEquipName());
                ed_workdan_zcbm.setText(mWorkDanUpdate.getData().getEqMaintain().getEquipAscode());
                ed_workdan_sydw.setText(mWorkDanUpdate.getData().getEqMaintain().getEquipDeptName());
            }
            ed_workdan_ssdw.setText(mWorkDanUpdate.getData().getEqMaintain().getMaintainUnitName());
            ed_workdan_bylb.setText(mWorkDanUpdate.getData().getEqMaintain().getMaintainName());
            ed_workdan_bybw.setText(mWorkDanUpdate.getData().getEqMaintain().getMaintainPartName());
            ed_workdan_zyrq.setText(mWorkDanUpdate.getData().getEqMaintain().getMaintainDate().substring(0,10));
            ed_workdan_bynr.setText(mWorkDanUpdate.getData().getEqMaintain().getMaintainComment());
            ed_workdan_bz.setText(mWorkDanUpdate.getData().getEqMaintain().getMaintainRemark());
        }
        if(requestCode == ConstantsYunZhiShui.REQUEST_CODE_SBBUWEI
                && response instanceof WorkDanMxBylbResponse) {
            mMxBylb =(WorkDanMxBylbResponse) response;
            MyAdapter adapter=new MyAdapter();
            minlistView.setAdapter(adapter);
            minlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    ed_workdan_bylb.setText(mMxBylb.getData().getComboboxList().get(position).getText());
                    lbCode=mMxBylb.getData().getComboboxList().get(position).getId();
                    PopupWindowUtils.closePopupWindow();
                }
            });
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_SBBUWEI
                && response instanceof WorkDanMxBybwResponse) {
            mMxbybw =(WorkDanMxBybwResponse) response;
            MyAdapter2 adapter2=new MyAdapter2();
            minlistView2.setAdapter(adapter2);
            minlistView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    ed_workdan_bybw.setText(mMxbybw .getData().getComboboxList().get(position).getText());
                    bwCode=mMxbybw.getData().getComboboxList().get(position).getId();
                    PopupWindowUtils.closePopupWindow();
                }
            });

        }

    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }
    class MyAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return  mMxBylb.getData().getComboboxList().size();
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
            convertView = View.inflate(WorkDanMxUpdateActivity.this, R.layout.item_search, null);
            holder.v_listview_item_number = (TextView) convertView.findViewById(R.id.tv_listview_item_number);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (position == 0) {
            holder.v_listview_item_number.setTextColor(Color.GRAY);
        }
        holder.v_listview_item_number.setText(mMxBylb.getData().getComboboxList().get(position).getText());
        return convertView;
    }
}
class ViewHolder{
    TextView v_listview_item_number;
}
class MyAdapter2 extends BaseAdapter{
    @Override
    public int getCount() {
        return  mMxbybw.getData().getComboboxList().size();
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
            convertView = View.inflate(WorkDanMxUpdateActivity.this, R.layout.item_search, null);
            holder.v_listview_item_number = (TextView) convertView.findViewById(R.id.tv_listview_item_number);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (position == 0) {
            holder.v_listview_item_number.setTextColor(Color.GRAY);
        }
        holder.v_listview_item_number.setText(mMxbybw.getData().getComboboxList().get(position).getText());
        return convertView;
    }
  }
    public void onEvent(EventSearchResponse ens){norm=ens;
    }
}
