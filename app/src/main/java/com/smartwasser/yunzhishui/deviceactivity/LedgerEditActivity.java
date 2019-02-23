package com.smartwasser.yunzhishui.deviceactivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;

/**
 * Created by huangmengjie on 2016/6/18 0018.
 */
public class LedgerEditActivity extends BaseActivity implements View.OnClickListener{
    private TextView tv_toolbar;
    private ImageButton button_menu;
    private Button but_bianji,but_ledger_save,but_jiandang;
    private EditText ed_ledger_shebeiname,ed_ledger_shebeicode,ed_ledger_shebeileibie
            ,ed_ledger_shebeizcbm,ed_ledger_shebeixh,ed_ledger_shebeigge,ed_ledger_sydw,ed_ledger_ssgjw,
            ed_ledger_cfwz,ed_ledger_syzk,ed_ledger_sbfzr,ed_ledger_jszk,ed_ledger_cgrq,
            ed_ledger_qyrq,ed_ledger_bxdq,ed_ledger_dxzq,ed_ledger_zcssdw,ed_ledger_rzrq
            ,ed_ledger_zcyz,ed_ledger_bfsj,ed_ledger_sccj,ed_ledger_scgj,ed_ledger_ccrq
            ,ed_ledger_gys,ed_ledger_ccbh,ed_ledger_sbxz,ed_ledger_bz;
    private ImageButton image_hei,image_sydw,image_cfwz,image_syzk,
            image_jszk,button_cgrq,button_qyrq,button_bxdq,button_dxzq,
            image_zcssdw,button_rzrq,button_bfsj,image_sbxz;

    @Override
    protected int initContentView() {
        return R.layout.activity_ledgeredit;
    }
    @Override
    protected void initView() {
        tv_toolbar= (TextView) findViewById(R.id.tv_toolbar);
        button_menu= (ImageButton) findViewById(R.id.button_menu);
        button_menu.setBackgroundResource(R.drawable.fanhu);
        but_bianji= (Button) findViewById(R.id.but_bianji);
        but_ledger_save= (Button) findViewById(R.id.but_ledger_save);
        but_jiandang= (Button) findViewById(R.id.but_jiandang);

        ed_ledger_shebeiname= (EditText) findViewById(R.id.ed_ledger_shebeiname);
        ed_ledger_shebeicode= (EditText) findViewById(R.id.ed_ledger_shebeicode);
        ed_ledger_shebeileibie= (EditText) findViewById(R.id.ed_ledger_shebeileibie);
        ed_ledger_shebeizcbm= (EditText) findViewById(R.id.ed_ledger_shebeizcbm);
        ed_ledger_shebeixh= (EditText) findViewById(R.id.ed_ledger_shebeixh);
        ed_ledger_shebeigge= (EditText) findViewById(R.id.ed_ledger_shebeigge);
        ed_ledger_sydw= (EditText) findViewById(R.id.ed_ledger_sydw);
        ed_ledger_ssgjw= (EditText) findViewById(R.id.ed_ledger_ssgjw);
        ed_ledger_cfwz= (EditText) findViewById(R.id.ed_ledger_cfwz);
        ed_ledger_syzk= (EditText) findViewById(R.id.ed_ledger_syzk);
        ed_ledger_sbfzr= (EditText) findViewById(R.id.ed_ledger_sbfzr);
        ed_ledger_jszk= (EditText) findViewById(R.id.ed_ledger_jszk);
        ed_ledger_cgrq= (EditText) findViewById(R.id.ed_ledger_cgrq);
        ed_ledger_qyrq= (EditText) findViewById(R.id.ed_ledger_qyrq);
        ed_ledger_bxdq= (EditText) findViewById(R.id.ed_ledger_bxdq);
        ed_ledger_dxzq= (EditText) findViewById(R.id.ed_ledger_dxzq);
        ed_ledger_zcssdw=(EditText) findViewById(R.id.ed_ledger_zcssdw);
        ed_ledger_rzrq= (EditText) findViewById(R.id.ed_ledger_rzrq);
        ed_ledger_zcyz= (EditText) findViewById(R.id.ed_ledger_zcyz);
        ed_ledger_bfsj= (EditText) findViewById(R.id.ed_ledger_bfsj);
        ed_ledger_sccj= (EditText) findViewById(R.id.ed_ledger_sccj);
        ed_ledger_scgj= (EditText) findViewById(R.id.ed_ledger_scgj);
        ed_ledger_ccrq= (EditText) findViewById(R.id.ed_ledger_ccrq);
        ed_ledger_gys= (EditText) findViewById(R.id.ed_ledger_gys);
        ed_ledger_ccbh= (EditText) findViewById(R.id.ed_ledger_ccbh);
        ed_ledger_sbxz= (EditText) findViewById(R.id.ed_ledger_sbxz);
        ed_ledger_bz= (EditText) findViewById(R.id.ed_ledger_bz);
        image_hei= (ImageButton) findViewById(R.id.image_hei);
        image_sydw= (ImageButton) findViewById(R.id.image_sydw);
        image_cfwz= (ImageButton) findViewById(R.id.image_cfwz);
        image_syzk= (ImageButton) findViewById(R.id.image_syzk);
        image_jszk= (ImageButton) findViewById(R.id.image_jszk);
        button_cgrq= (ImageButton) findViewById(R.id.button_cgrq);
        button_qyrq= (ImageButton) findViewById(R.id.button_qyrq);
        button_bxdq= (ImageButton) findViewById(R.id.button_bxdq);
        button_dxzq= (ImageButton) findViewById(R.id.button_dxzq);
    }
    @Override
    protected void initListener() {
        button_menu.setOnClickListener(this);
        but_ledger_save.setOnClickListener(this);
        but_jiandang.setOnClickListener(this);
    }
    @Override
    protected void initData() {
        tv_toolbar.setText("设备信息修改");
        but_bianji.setVisibility(View.GONE);
        but_ledger_save.setVisibility(View.VISIBLE);
        but_jiandang.setVisibility(View.VISIBLE);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_menu:
                finish();
            break;
        }
    }
}
