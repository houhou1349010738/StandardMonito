package com.smartwasser.yunzhishui.deviceactivity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.SaveResponse;
import com.smartwasser.yunzhishui.bean.WorkDanUpdateHxResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.DialogTimeUtils;
import com.smartwasser.yunzhishui.utils.ListViewUtils;
import com.smartwasser.yunzhishui.utils.PopupWindowUtils;

import org.seny.android.utils.MyToast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by huangmengjie on 2016/7/10 0010.
 */
public class WorkDanUpdateActivity extends BaseActivity  implements View.OnClickListener,HttpLoader.ResponseListener{
    private ImageButton button_menu;
    private TextView tv_toolbar;
    private List<String> mlist;
    private ListView minitListView;
    private Button but_baocun;
    private EventNormSelect mNorm;
    private DialogTimeUtils dialog=new DialogTimeUtils(this);
    private   WorkDanUpdateHxResponse updateHx;
    private EditText ed_addworkdan_name,ed_addwork_yue,ed_start_date
            ,ed_end_date,ed_addwork_fuze,ed_addwork_danwei;
    private ImageButton button_addwork_yue,but_addworkdan_starttime,but_addworkdan_endtime;
    @Override
    protected int initContentView() {
        return R.layout.activity_addworkdan;
    }
    @Override
    protected void initView() {
        button_menu= (ImageButton) findViewById(R.id.button_menu);
        tv_toolbar= (TextView) findViewById(R.id.tv_toolbar);
        ed_addworkdan_name= (EditText) findViewById(R.id.ed_addworkdan_name);
        ed_addwork_yue= (EditText) findViewById(R.id.ed_addwork_yue);
        button_addwork_yue= (ImageButton) findViewById(R.id.button_addwork_yue);
        ed_start_date= (EditText) findViewById(R.id.ed_start_date);
        but_addworkdan_starttime= (ImageButton) findViewById(R.id.but_addworkdan_starttime);
        but_addworkdan_endtime= (ImageButton) findViewById(R.id.but_addworkdan_endtime);
        ed_end_date= (EditText) findViewById(R.id.ed_end_date);
        ed_addwork_fuze= (EditText) findViewById(R.id.ed_addwork_fuze);
        ed_addwork_danwei= (EditText) findViewById(R.id.ed_addwork_danwei);
        but_baocun= (Button) findViewById(R.id.but_baocun);
        EventBus.getDefault().registerSticky(this);
    }
    @Override
    protected void initListener() {
        button_menu.setOnClickListener(this);
        button_addwork_yue.setOnClickListener(this);
        but_addworkdan_starttime.setOnClickListener(this);
        but_addworkdan_endtime.setOnClickListener(this);
        but_baocun.setOnClickListener(this);
    }
    @Override
    protected void initData() {
        button_menu.setBackgroundResource(R.drawable.fanhu);
        tv_toolbar.setText("工单修改");
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", mNorm.getTianId());
        HttpLoader.get(ConstantsYunZhiShui.URL_GDUPDATAHX, params, WorkDanUpdateHxResponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_GDUPDATAHX, this, false).setTag(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_menu:
                finish();
                break;
            case R.id.button_addwork_yue:
                mlist=new ArrayList<>();
                ListViewUtils utils=new ListViewUtils(this);
                minitListView=utils.initListView(mlist);
                PopupWindowUtils.showPopupWindow(minitListView, ed_addwork_yue);
                minitListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ed_addwork_yue.setText(mlist.get(position));
                        PopupWindowUtils.closePopupWindow();
                    }
                });
                break;
            case R.id.but_addworkdan_starttime:
                dialog.show(ed_start_date);
                dialog.showTime();
                break;
            case R.id.but_addworkdan_endtime:
                dialog.show(ed_end_date);
                dialog.showTime();
                break;
            case R.id.but_baocun:
                String name=ed_addworkdan_name.getText().toString();
                String yue=ed_addwork_yue.getText().toString();
                String sDate= ed_start_date.getText().toString();
                String eDate=ed_end_date.getText().toString();
                String fuze=ed_addwork_fuze.getText().toString();
                String danwei=ed_addwork_danwei.getText().toString();
                if("".equals(name)||"".equals(yue)||"".equals(sDate)
                        ||"".equals(eDate)||"".equals(fuze)||"".equals(danwei)){
                    Toast.makeText(WorkDanUpdateActivity.this, "请将信息填写完整", Toast.LENGTH_SHORT).show();
                    return;
                }
                HashMap<String, Object> params = new HashMap<>();
                params.put("maintainId",updateHx.getData().getEqMaintain().getMaintainId());
                params.put("maintainName",name);
                params.put("maintainMonth",yue);
                params.put("Sdate",sDate);
                params.put("Edate",eDate);
                params.put("maintainCharge",fuze);
                params.put("maintainImpDept",danwei);
                HttpLoader.get(ConstantsYunZhiShui.URL_GDUPDATABC, params, SaveResponse.class,
                        ConstantsYunZhiShui.REQUEST_CODE_GDUPDATABC, this, false).setTag(this);
                break;
        }
    }

    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_GDUPDATABC
                && response instanceof SaveResponse) {
            SaveResponse mSave =(SaveResponse) response;
            Log.i("212121323",mSave.getErrorCode());
            /**保存成功*/
            if("00000".equals(mSave.getErrorCode())){
                /**跳转到另一个页面*/
                Toast.makeText(WorkDanUpdateActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                Intent intent3=new Intent(WorkDanUpdateActivity.this,WorkDanDistributeActivity.class);
                startActivity(intent3);
                finish();
            }
        }
        if(requestCode == ConstantsYunZhiShui.REQUEST_CODE_GDUPDATAHX
                && response instanceof WorkDanUpdateHxResponse){
             updateHx =(WorkDanUpdateHxResponse) response;
                         /**赋值*/
            ed_addworkdan_name.setText(updateHx.getData().getEqMaintain().getMaintainName());
            ed_addwork_yue.setText(updateHx.getData().getEqMaintain().getMaintainMonth());
            String s=updateHx.getData().getEqMaintain().getMaintainSdate();
            String s1=updateHx.getData().getEqMaintain().getMaintainEdate();
            if(s!=null||"".equals(s)||"null".equals(s)){
                 s= s.substring(0,10);
            }
            ed_start_date.setText(s);
            if(s1!=null||"".equals(s1)||"null".equals(s1)){
                s1= s1.substring(0,10);
            }
            ed_end_date.setText(s1);
            ed_addwork_fuze.setText(updateHx.getData().getEqMaintain().getMaintainCharge());
            ed_addwork_danwei.setText(updateHx.getData().getEqMaintain().getMaintainImpDept());
        }
    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }
    public void onEvent(EventNormSelect norm){
            mNorm=norm;
    }
}
