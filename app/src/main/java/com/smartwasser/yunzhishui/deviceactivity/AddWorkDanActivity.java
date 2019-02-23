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
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.WorkDanAddResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.DialogTimeUtils;
import com.smartwasser.yunzhishui.utils.ListViewUtils;
import com.smartwasser.yunzhishui.utils.PopupWindowUtils;

import org.seny.android.utils.MyToast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by huangmengjie on 2016/6/17 0017.
 */
public class AddWorkDanActivity extends BaseActivity implements View.OnClickListener,HttpLoader.ResponseListener{
    private ImageButton button_menu;
    private TextView tv_toolbar;
    private List<String> mlist;
    private ListView minitListView;
    private Button but_baocun;
    private WorkDanAddResponse workAdd;
    private DialogTimeUtils dialog=new DialogTimeUtils(this);
    private EditText ed_addworkdan_name,ed_addwork_yue,ed_start_date
    ,ed_end_date,ed_addwork_fuze,ed_addwork_danwei;
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
        ed_start_date= (EditText) findViewById(R.id.ed_start_date);
        ed_end_date= (EditText) findViewById(R.id.ed_end_date);
        ed_addwork_fuze= (EditText) findViewById(R.id.ed_addwork_fuze);
        ed_addwork_danwei= (EditText) findViewById(R.id.ed_addwork_danwei);
        but_baocun= (Button) findViewById(R.id.but_baocun);
    }

    @Override
    protected void initListener() {
        button_menu.setOnClickListener(this);
        ed_addwork_yue.setOnClickListener(this);
        ed_start_date.setOnClickListener(this);
        ed_end_date.setOnClickListener(this);
        but_baocun.setOnClickListener(this);
    }
    @Override
    protected void initData() {
        button_menu.setBackgroundResource(R.drawable.fanhu);
        tv_toolbar.setText("新建工单");

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_menu:
                finish();
                break;
            case R.id.ed_addwork_yue:
                mlist=new ArrayList<>();
                ListViewUtils utils=new ListViewUtils(this);
                minitListView=utils.initListView(mlist);
                PopupWindowUtils.showPopupWindow(minitListView,ed_addwork_yue);
                minitListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ed_addwork_yue.setText(mlist.get(position));
                        PopupWindowUtils.closePopupWindow();
                    }
                });
                break;
            case R.id.ed_start_date:
                dialog.show(ed_start_date);
                dialog.showTime();
                break;
            case R.id.ed_end_date:
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
                      Toast.makeText(AddWorkDanActivity.this, "请将信息填写完整", Toast.LENGTH_SHORT).show();
                      return;
                  }
                HashMap<String, Object> params = new HashMap<>();
                params.put("maintainName",name);
                params.put("maintainMonth",yue);
                Log.i("11111111",sDate+"----"+eDate);
                params.put("Sdate",sDate);
                params.put("Edate",eDate);
                params.put("maintainCharge",fuze);
                params.put("maintainImpDept",danwei);
                HttpLoader.get(ConstantsYunZhiShui.URL_GDADD, params, WorkDanAddResponse.class,
                        ConstantsYunZhiShui.REQUEST_CODE_GDADD, this, false).setTag(this);
                break;
        }
    }

    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_GDADD
                && response instanceof WorkDanAddResponse) {
            workAdd =(WorkDanAddResponse) response;
                   /**保存成功*/
            if("00000".equals( workAdd.getErrorCode())){
                /**跳转到另一个页面*/
                Toast.makeText(AddWorkDanActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
                Intent intent3=new Intent(AddWorkDanActivity.this,WorkDanDistributeActivity.class);
                startActivity(intent3);
                finish();
            }
        }
    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }
}
