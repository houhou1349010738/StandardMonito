package com.smartwasser.yunzhishui.deviceactivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.LedgerSaveResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;

import org.seny.android.utils.MyToast;

import java.util.HashMap;

/**
 * Created by huangmengjie on 2016/7/7 0007.
 */
public class AddLedgerActivity extends BaseActivity implements HttpLoader.ResponseListener,View.OnClickListener{
    private TextView tv_toolbar;
    private Button but_bianji;
    private ImageButton button_menu;
    private EditText ed_ledger_shebeiname,ed_ledger_shebeicode,ed_ledger_shebeileibie
    ,ed_ledger_shebeizcbm,ed_ledger_shebeixh,ed_ledger_shebeigge,ed_ledger_sydw,ed_ledger_ssgjw,
            ed_ledger_cfwz,ed_ledger_syzk,ed_ledger_sbfzr,ed_ledger_jszk,ed_ledger_cgrq,
            ed_ledger_qyrq,ed_ledger_bxdq,ed_ledger_dxzq,ed_ledger_zcssdw,ed_ledger_rzrq
            ,ed_ledger_zcyz,ed_ledger_bfsj,ed_ledger_sccj,ed_ledger_scgj,ed_ledger_ccrq
            ,ed_ledger_gys,ed_ledger_ccbh,ed_ledger_sbxz,ed_ledger_bz;
    @Override
    protected int initContentView() {
        return R.layout.activity_ledgeredit;
    }
    @Override
    protected void initView() {
        tv_toolbar= (TextView) findViewById(R.id.tv_toolbar);
        button_menu= (ImageButton) findViewById(R.id.button_menu);
        but_bianji= (Button) findViewById(R.id.but_bianji);
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
        ed_ledger_zcssdw= (EditText) findViewById(R.id.ed_ledger_zcssdw);
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
    }

    @Override
    protected void initListener() {
        but_bianji.setOnClickListener(this);
    }
    @Override
    protected void initData() {
        tv_toolbar.setText("添加设备信息");
        button_menu.setBackgroundResource(R.drawable.fanhu);
        button_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {

    }

    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id. but_bianji:
                     /**发起网络请求*/
                HashMap<String, Object> prams = new HashMap<>();
                String sbName=ed_ledger_shebeiname.getText().toString();
                String sbCode=ed_ledger_shebeicode.getText().toString();
                prams.put("equipName",sbName);
                prams.put("equipCode",sbCode);
                HttpLoader.get(ConstantsYunZhiShui.URL_LEDGERSAVE, prams,
                        LedgerSaveResponse.class, ConstantsYunZhiShui.REQUEST_CODE_LEDGERSAVE, this, false).setTag(this);
                break;
        }
    }
}
