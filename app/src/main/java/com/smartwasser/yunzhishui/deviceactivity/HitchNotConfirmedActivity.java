package com.smartwasser.yunzhishui.deviceactivity;

/**
 * Created by huangmengjie on 2016/6/18 0018.
 */

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.HitchDeleteRespon;
import com.smartwasser.yunzhishui.bean.HtichQrRespon;
import com.smartwasser.yunzhishui.bean.HttchQueWeiResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;

import org.seny.android.utils.MyToast;

import java.util.HashMap;

import de.greenrobot.event.EventBus;

/**故障未确认*/
public class HitchNotConfirmedActivity extends BaseActivity implements View.OnClickListener,HttpLoader.ResponseListener{
    private ImageButton button_menu;
    private Button but_confirmed_queren;
    private Button but_deltele;
    private Button but_confirmed_delte;
    private TextView tv_toolbar;
    private EventNormSelect mNome;
    private ImageButton norm_ser;
    private HttchQueWeiResponse  mQueRen;
    private EventSearchResponse s=new EventSearchResponse();
    private TextView tv_notconfir_sbname,tv_state,tv_notconfir_zcbm,
            tv_notconfir_gzlb,tv_notconfir_gzbw,tv_notconfir_gzxx,
            tv_notconfir_lx,tv_notconfir_gzstarttime,tv_notconfir_gzendtime,
            tv_notconfir_sydw,tv_notconfir_gzyy,tv_notconfir_clff,tv_notconfir_cfwz;
    @Override
    protected int initContentView() {
        return R.layout.activity_hitchnotconfirmed;
    }
    @Override
    protected void initView() {
        but_confirmed_queren = (Button) findViewById(R.id.but_confirmed_queren);
        tv_notconfir_sbname= (TextView) findViewById(R.id.tv_notconfir_sbname);
        tv_notconfir_zcbm= (TextView) findViewById(R.id.tv_notconfir_zcbm);
        tv_notconfir_gzbw= (TextView) findViewById(R.id.tv_notconfir_gzbw);
        tv_notconfir_gzxx= (TextView) findViewById(R.id.tv_notconfir_gzxx);
        tv_notconfir_lx= (TextView) findViewById(R.id.tv_notconfir_lx);
        tv_notconfir_sydw= (TextView) findViewById(R.id.tv_notconfir_sydw);
        tv_notconfir_gzyy= (TextView) findViewById(R.id.tv_notconfir_gzyy);
        tv_notconfir_clff= (TextView) findViewById(R.id.tv_notconfir_clff);
        tv_notconfir_cfwz= (TextView) findViewById(R.id.tv_notconfir_cfwz);
        tv_notconfir_gzstarttime= (TextView) findViewById(R.id.tv_notconfir_gzstarttime);
        tv_notconfir_gzendtime= (TextView) findViewById(R.id.tv_notconfir_gzendtime);
        tv_state= (TextView)findViewById(R.id.tv_state);
        but_deltele = (Button) findViewById(R.id.but_deltele);
        tv_notconfir_gzlb= (TextView) findViewById(R.id. tv_notconfir_gzlb);
        but_confirmed_delte = (Button) findViewById(R.id.but_confirmed_delte);
        button_menu = (ImageButton) findViewById(R.id.button_menu);
        tv_toolbar = (TextView) findViewById(R.id.tv_toolbar);
        norm_ser= (ImageButton)findViewById(R.id.norm_ser);
        EventBus.getDefault().registerSticky(this);
    }

    @Override
    protected void initListener() {
        but_confirmed_queren.setOnClickListener(this);
        but_deltele.setOnClickListener(this);
        but_confirmed_delte.setOnClickListener(this);
        button_menu.setOnClickListener(this);
        norm_ser.setOnClickListener(this);
    }
    @Override
    protected void initData() {
        button_menu.setBackgroundResource(R.drawable.fanhu);
        tv_toolbar.setText("故障管理");
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", mNome.getFailureId());
        HttpLoader.get(ConstantsYunZhiShui.URL_SBGZQRW, params,HttchQueWeiResponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_SBGZQRW, this, false).setTag(this);
        if(mNome.getState().equals("1")){
              /**已确认*/
            but_confirmed_delte.setVisibility(View.VISIBLE);
            but_confirmed_queren.setVisibility(View.GONE);
            but_deltele.setVisibility(View.GONE);
        }else if(mNome.getState().equals("0")){
            but_confirmed_queren.setVisibility(View.VISIBLE);
            but_deltele.setVisibility(View.VISIBLE);
            but_confirmed_delte.setVisibility(View.GONE);
            norm_ser.setVisibility(View.VISIBLE);
            norm_ser.setBackgroundResource(R.drawable.write2);
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            /**点击确认按钮*/
            case R.id.but_confirmed_queren:
                but_confirmed_delte.setVisibility(View.VISIBLE);
                but_deltele.setVisibility(View.GONE);
                but_confirmed_queren.setVisibility(View.GONE);
                /**调确认接口*/
                HashMap<String, Object> params3 = new HashMap<>();
                params3.put("id", mNome.getFailureId());
                HttpLoader.get(ConstantsYunZhiShui.URL_SBGZQR, params3, HtichQrRespon.class,
                        ConstantsYunZhiShui.REQUEST_CODE_SBGZQR, this, false).setTag(this);
                break;
            /**点击删除*/
            case R.id.but_deltele:
                /**删除完跳到主页*/
                HashMap<String, Object> params2 = new HashMap<>();
                params2.put("id", mNome.getFailureId());
                HttpLoader.get(ConstantsYunZhiShui.URL_SBGZDELETE, params2, HitchDeleteRespon.class,
                        ConstantsYunZhiShui.REQUEST_CODE_SBGZDELETE, this, false).setTag(this);
                break;
            case R.id.but_confirmed_delte:
                /**删除完跳到主页
                 */
                HashMap<String, Object> params = new HashMap<>();
                params.put("id", mNome.getFailureId());
                HttpLoader.get(ConstantsYunZhiShui.URL_SBGZDELETE, params, HitchDeleteRespon.class,
                        ConstantsYunZhiShui.REQUEST_CODE_SBGZDELETE, this, false).setTag(this);
                break;
            case R.id.button_menu:
                Intent intent2=new Intent(HitchNotConfirmedActivity.this,HitchActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.norm_ser:
                /**跳到修改页*/
                s.setUpdateId(mNome.getFailureId());
                s.setLeibei(mNome.getLeibie());
                s.setBuwei(mNome.getBuwei());
                int x=1;
                s.setX(x);
                EventBus.getDefault().postSticky(s);
                Intent intent=new Intent(HitchNotConfirmedActivity.this,HitchUpdateActivity.class);
                startActivity(intent);
                break;
        }
    }
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_SBGZQRW
                && response instanceof HttchQueWeiResponse) {
             mQueRen= (HttchQueWeiResponse) response;
             if("00000".equals(mQueRen.getErrorCode())){
                         /**赋值*/
                 tv_notconfir_sbname.setText("设备名称:"+mQueRen.getData().getEqFailure().getEquipName());
                 if(Integer.valueOf(mQueRen.getData().getEqFailure().getFailureState())==1){
                     tv_state.setText("已确认");
                     tv_state.setTextColor(Color.GREEN);
                 }else if(Integer.valueOf(mQueRen.getData().getEqFailure().getFailureState())==0){
                     tv_state.setText("未确认");
                     tv_state.setTextColor(Color.RED);
                 }
                 tv_notconfir_zcbm.setText("资产编码:"+mQueRen.getData().getEqFailure().getEquipAscode());
                 tv_notconfir_gzlb.setText("故障类别:"+mNome.getLeibie());
                 tv_notconfir_gzbw.setText("故障部位:"+mNome.getBuwei());
                 String gzxx=mQueRen.getData().getEqFailure().getFailureAppear();
                 if("".equals(gzxx)||"null".equals(gzxx)||gzxx==null){
                     gzxx="";
                 }
                 tv_notconfir_gzxx.setText("故障现象:"+gzxx);
                 String startTime=mQueRen.getData().getEqFailure().getFailureSdate();
                 String endTime=mQueRen.getData().getEqFailure().getFailureEdate();
                 tv_notconfir_gzstarttime.setText("故障发生时间:"+startTime.substring(0,10));
                 tv_notconfir_gzendtime.setText("故障结束时间:"+endTime.substring(0, 10));
                 tv_notconfir_sydw.setText("使用单位:" + mQueRen.getData().getEqFailure().getEquipOwnDept());
                 String yuanying3= mQueRen.getData().getEqFailure().getFailureReason();
                 String jcff3=mQueRen.getData().getEqFailure().getEquipLocCodeName();
                 if("".equals(jcff3)||"null".equals(jcff3)||jcff3==null){
                     jcff3="";
                 }

                 String  clf3=mQueRen.getData().getEqFailure().getFailureDeal();
                 if("".equals(clf3)||"null".equals(clf3)||clf3==null){
                     clf3="";
                 }
                 if("".equals(yuanying3)||"null".equals(yuanying3)||yuanying3==null){
                     yuanying3="";
                 }
                 tv_notconfir_gzyy.setText("故障原因:"+yuanying3);
                 tv_notconfir_clff.setText("处理方法:"+ clf3);
                 tv_notconfir_cfwz.setText("存放位置:"+jcff3);
             }

        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_SBGZDELETE
                && response instanceof HitchDeleteRespon) {
            HitchDeleteRespon mQueRen = (HitchDeleteRespon) response;
            if("00000".equals(mQueRen.getErrorCode())){
                  /**删除成功*/
                Toast.makeText(HitchNotConfirmedActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(HitchNotConfirmedActivity.this,HitchActivity.class);
                startActivity(intent);
            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_SBGZQR
                && response instanceof HtichQrRespon) {
            HtichQrRespon mQue = (HtichQrRespon) response;
            if("00000".equals(mQue.getErrorCode())){
                HashMap<String, Object> params = new HashMap<>();
                params.put("id", mNome.getFailureId());
                HttpLoader.get(ConstantsYunZhiShui.URL_SBGZQRW, params,HttchQueWeiResponse.class,
                        ConstantsYunZhiShui.REQUEST_CODE_SBGZQRW, this, false).setTag(this);
            }
        }

    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }
    public void onEvent(EventNormSelect nome) {
            mNome=nome;
    }
}
