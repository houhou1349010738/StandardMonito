package com.smartwasser.yunzhishui.deviceactivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.LedgerConfirmResponse;
import com.smartwasser.yunzhishui.bean.LedgerDeleteResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;

import org.seny.android.utils.MyToast;

import java.util.HashMap;

import de.greenrobot.event.EventBus;

/**
 * Created by huangmengjie on 2016/6/18 0018.
 */
public class LedgerDetailActivity extends BaseActivity implements View.OnClickListener,HttpLoader.ResponseListener{
    private ImageButton button_menu;
    private TextView tv_toolbar;
          /**如果状态是运行,就显示这2个按钮*/
    private Button but_bianji,but_delte;
        /**当转态是淘汰时就是显示该按钮*/
    private Button button_yijiandang;
    private EventNormSelect mEnom;
    private  LedgerConfirmResponse  mCOnfim;

    /**找到控件*/
    private TextView tv_ledger_zcbianhao,tv_detail_start,tv_ledgerdetail_name,tv_ledgerdetail_xinghao
            ,tv_ledgerdetail_zcbh,tv_ledgerdetail_sydw,tv_ledgerdetail_sbguize
            ,tv_ledgerdetail_goujianwu,tv_ledgerdetail_cfweizhi,tv_ledgerdetail_sbfzr
            ,tv_ledgerdetail_jszk,tv_ledgerdetail_cgdate,tv_ledgerdetail_qydate,tv_ledgerdetail_bxdate
            ,tv_ledgerdetail_dxzhouqi,tv_ledgerdetail_zcssdw,tv_ledgerdetail_rzrq,tv_ledgerdetail_zcyz
            ,tv_ledgerdetail_bftime,tv_ledgerdetail_sccj,tv_ledgerdetail_china,tv_ledgerdetail_gxs
            ,tv_ledgerdetail_ccbianh,tv_ledgerdetail_ccrq,tv_ledgerdetail_sbxz,tv_ledgerdetail_bz;
    @Override
    protected int initContentView() {
        return R.layout.activity_ledgerdetail;
    }
    @Override
    protected void initView() {
        button_menu= (ImageButton) findViewById(R.id.button_menu);
        tv_toolbar=(TextView) findViewById(R.id.tv_toolbar);
        but_bianji= (Button) findViewById(R.id.but_bianji);
        but_delte= (Button) findViewById(R.id.but_delte);
        button_yijiandang= (Button) findViewById(R.id.button_yijandang);
        tv_ledger_zcbianhao= (TextView) findViewById(R.id.tv_ledger_zcbianhao);
        tv_detail_start= (TextView) findViewById(R.id.tv_detail_start);
        tv_ledgerdetail_name= (TextView) findViewById(R.id.tv_ledgerdetail_name);
        tv_ledgerdetail_xinghao= (TextView) findViewById(R.id.tv_ledgerdetail_xinghao);
        tv_ledgerdetail_zcbh= (TextView) findViewById(R.id.tv_ledgerdetail_zcbh);
        tv_ledgerdetail_sydw=(TextView) findViewById(R.id.tv_ledgerdetail_sydw);
        tv_ledgerdetail_sbguize=(TextView) findViewById(R.id.tv_ledgerdetail_sbguize);
        tv_ledgerdetail_goujianwu=(TextView) findViewById(R.id.tv_ledgerdetail_goujianwu);
        tv_ledgerdetail_cfweizhi=(TextView) findViewById(R.id.tv_ledgerdetail_cfweizhi);
        tv_ledgerdetail_sbfzr=(TextView) findViewById(R.id.tv_ledgerdetail_sbfzr);
        tv_ledgerdetail_jszk=(TextView) findViewById(R.id.tv_ledgerdetail_jszk);
        tv_ledgerdetail_cgdate=(TextView) findViewById(R.id.tv_ledgerdetail_cgdate);
        tv_ledgerdetail_qydate=(TextView) findViewById(R.id.tv_ledgerdetail_qydate);
        tv_ledgerdetail_bxdate=(TextView) findViewById(R.id.tv_ledgerdetail_bxdate);
        tv_ledgerdetail_zcssdw=(TextView) findViewById(R.id.tv_ledgerdetail_zcssdw);
        tv_ledgerdetail_dxzhouqi=(TextView) findViewById(R.id.tv_ledgerdetail_dxzhouqi);
        tv_ledgerdetail_rzrq=(TextView) findViewById(R.id.tv_ledgerdetail_rzrq);
        tv_ledgerdetail_zcyz=(TextView) findViewById(R.id.tv_ledgerdetail_zcyz);
        tv_ledgerdetail_bftime=(TextView) findViewById(R.id.tv_ledgerdetail_bftime);
        tv_ledgerdetail_sccj=(TextView) findViewById(R.id.tv_ledgerdetail_sccj);
        tv_ledgerdetail_china=(TextView) findViewById(R.id.tv_ledgerdetail_china);
        tv_ledgerdetail_gxs=(TextView) findViewById(R.id.tv_ledgerdetail_gxs);
        tv_ledgerdetail_ccbianh=(TextView) findViewById(R.id.tv_ledgerdetail_ccbianh);
        tv_ledgerdetail_ccrq=(TextView) findViewById(R.id.tv_ledgerdetail_ccrq);
        tv_ledgerdetail_sbxz=(TextView) findViewById(R.id.tv_ledgerdetail_sbxz);
        tv_ledgerdetail_bz=(TextView) findViewById(R.id.tv_ledgerdetail_bz);
        EventBus.getDefault().registerSticky(this);
    }
    @Override
    protected void initListener() {
        button_menu.setOnClickListener(this);
        but_bianji.setOnClickListener(this);
        but_delte.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        button_menu.setBackgroundResource(R.drawable.fanhu);
        tv_toolbar.setText("设备台账管理");
              /**请求网络*/
        /**发起网络请求*/
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("id", mEnom.getLedgerId());
        HttpLoader.get(ConstantsYunZhiShui.URL_LEDGERINFO, prams,
               LedgerConfirmResponse.class, ConstantsYunZhiShui.REQUEST_CODE_LEDGERINFO, this, false).setTag(this);
        if("1".equals(mEnom.getFiling())){
             /**说明已经建档*/
            button_yijiandang.setVisibility(View.VISIBLE);
            but_bianji.setVisibility(View.GONE);
            but_delte.setVisibility(View.GONE);
        }else{
            button_yijiandang.setVisibility(View.GONE);
            but_bianji.setVisibility(View.VISIBLE);
            but_delte.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_menu:
                finish();
                break;
            case R.id.but_bianji:
                  /**跳转到编辑界面*/
                Intent intent=new Intent(LedgerDetailActivity.this,LedgerEditActivity.class);
                startActivity(intent);
                break;
            case R.id.but_delte:
                /**删除*/
                HashMap<String, Object> prams = new HashMap<>();
                prams.put("id", mEnom.getLedgerId());
                HttpLoader.get(ConstantsYunZhiShui.URL_LEDGERDELETE, prams,
                        LedgerDeleteResponse.class, ConstantsYunZhiShui.REQUEST_CODE_LEDGERDELETE, this, false).setTag(this);
                break;
        }
    }
    public void onEvent(EventNormSelect nemo){
          mEnom=nemo;
    }

    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_LEDGERINFO
                && response instanceof LedgerConfirmResponse) {
             mCOnfim= (LedgerConfirmResponse) response;
            if("00000".equals(mCOnfim.getErrorCode())){
                  /**赋值*/
                tv_ledger_zcbianhao.setText("编号:"+mCOnfim.getData().getEqEquipInfo().getEquipCode());
                tv_detail_start.setText(mEnom.getStatusName());
                tv_ledgerdetail_name.setText("设备名称:"+mCOnfim.getData().getEqEquipInfo().getEquipName());
                tv_ledgerdetail_xinghao.setText("型号:"+mCOnfim.getData().getEqEquipInfo().getEquipModel());
                tv_ledgerdetail_zcbh.setText("资产编号:"+mCOnfim.getData().getEqEquipInfo().getAsCode());
                tv_ledgerdetail_sydw.setText("使用单位:"+mCOnfim.getData().getEqEquipInfo().getEquipOwnDept());
                tv_ledgerdetail_sbguize.setText("设备规格:"+mCOnfim.getData().getEqEquipInfo().getEquipStandard());
                tv_ledgerdetail_goujianwu.setText("构建物:"+mCOnfim.getData().getEqEquipInfo().getEquipOwnStructName());
                tv_ledgerdetail_cfweizhi.setText("存放位置:"+mEnom.getLocCodeName());
                tv_ledgerdetail_sbfzr.setText("设备负责人:"+mCOnfim.getData().getEqEquipInfo().getEquipCharge());
                tv_ledgerdetail_jszk.setText("技术状况:"+mCOnfim.getData().getEqEquipInfo().getEquipTecStatus());
                String ssss=mCOnfim.getData().getEqEquipInfo().getCgDate();
                String cgrq="";
                if(ssss!=null||"".equals(ssss)||"null".equals(ssss)){
                    cgrq=ssss.substring(0,10);
                }
                tv_ledgerdetail_cgdate.setText("采购日期:"+cgrq);
                String s=mCOnfim.getData().getEqEquipInfo().getEquipEnabledDate();
                String qyrq="";
                if(s!=null||"".equals(s)||"null".equals(s)){
                    qyrq=s.substring(0,10);
                }
                tv_ledgerdetail_qydate.setText("启用日期:"+qyrq);
                String s1=mCOnfim.getData().getEqEquipInfo().getBxDate();
                String bxdq="";
                if(s1!=null||"".equals(s1)||"null".equals(s1)){
                    bxdq=s1.substring(0,10);
                }
                tv_ledgerdetail_bxdate.setText("保修到期:"+bxdq);
                tv_ledgerdetail_dxzhouqi.setText("大修周期:"+mCOnfim.getData().getEqEquipInfo().getOverhaulCycle());
                tv_ledgerdetail_zcssdw.setText("资产所属单位:"+mCOnfim.getData().getEqEquipInfo().getAsDept());
                String ss=mCOnfim.getData().getEqEquipInfo().getEquipEntryDate();
                String rzrq="";
                if(ss!=null||"".equals(ss)||"null".equals(ss)){
                    rzrq=ss.substring(0,10);
                }
                tv_ledgerdetail_rzrq.setText("入账日期:"+rzrq);
                tv_ledgerdetail_zcyz.setText("资产原值:"+mCOnfim.getData().getEqEquipInfo().getAsValue());
                String s2=mCOnfim.getData().getEqEquipInfo().getEquipScrapDate();
                String bfsj="";
                if(s2!=null||"".equals(s2)||"null".equals(s2)){
                    bfsj=s2.substring(0,10);
                }
                tv_ledgerdetail_bftime.setText("报废时间:"+bfsj);
                tv_ledgerdetail_sccj.setText("生产厂家:"+mCOnfim.getData().getEqEquipInfo().getEquipMaker());
                tv_ledgerdetail_china.setText("生产国家:"+mCOnfim.getData().getEqEquipInfo().getEquipMakeCountry());
                tv_ledgerdetail_gxs.setText("供应商:"+mCOnfim.getData().getEqEquipInfo().getPdCode());
                tv_ledgerdetail_ccbianh.setText("出厂编号:"+mCOnfim.getData().getEqEquipInfo().getEquipMakeCode());
                String sss=mCOnfim.getData().getEqEquipInfo().getEquipMakedate();
                String ccrq="";
                if(sss!=null||"".equals(sss)||"null".equals(sss)){
                    ccrq=sss.substring(0,10);
                }
                tv_ledgerdetail_ccrq.setText("出厂日期:"+ccrq);
                tv_ledgerdetail_sbxz.setText("设备现状:"+mCOnfim.getData().getEqEquipInfo().getSbxzCode());
                tv_ledgerdetail_bz.setText("备注:"+mCOnfim.getData().getEqEquipInfo().getRemark());
            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_LEDGERDELETE
                && response instanceof LedgerDeleteResponse) {
            LedgerDeleteResponse mDelete= (LedgerDeleteResponse) response;
            if("00000".equals(mDelete.getErrorCode())){
                Toast.makeText(LedgerDetailActivity.this, "已删除", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(LedgerDetailActivity.this,LedgerActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }

    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }
}
