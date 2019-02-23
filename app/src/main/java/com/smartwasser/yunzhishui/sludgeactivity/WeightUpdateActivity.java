package com.smartwasser.yunzhishui.sludgeactivity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.SaveResponse;
import com.smartwasser.yunzhishui.bean.WeightUpdateResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;

import org.seny.android.utils.MyToast;

import java.util.HashMap;

import de.greenrobot.event.EventBus;
/**
 * Created by huangmengjie on 2016/7/11 0011.
 */
public class WeightUpdateActivity extends BaseActivity implements View.OnClickListener,HttpLoader.ResponseListener{
    private TextView tv_toolbar;
    private ImageButton button_menu;
    private TextView tv_weight_xzcl,tv_weight_czd,tv_weight_pzsj,tv_weight_pz
            ,tv_weight_mzsj,tv_weight_mz,tv_weight_jz,tv_weight_wnzl,tv_weight_szly;
    private EditText ed_weight_xzjz,ed_weight_bz;
    private Button but_tijiao;
    private EventNormSelect mEns;
    private WeightUpdateResponse mWeightUpdate;
    private RadioGroup group;
    private boolean flag=false;
    @Override
    protected int initContentView() {
        return R.layout.activity_weightupdate;
    }

    @Override
    protected void initView() {
        tv_toolbar= (TextView) findViewById(R.id.tv_toolbar);
        button_menu= (ImageButton) findViewById(R.id.button_menu);
        button_menu.setBackgroundResource(R.drawable.fanhu);
        tv_weight_xzcl= (TextView) findViewById(R.id.tv_weight_xzcl);
        tv_weight_czd= (TextView) findViewById(R.id.tv_weight_czd);
        tv_weight_pzsj= (TextView) findViewById(R.id.tv_weight_pzsj);
        tv_weight_pz= (TextView) findViewById(R.id.tv_weight_pz);
        tv_weight_mzsj= (TextView) findViewById(R.id.tv_weight_mzsj);
        tv_weight_mz= (TextView) findViewById(R.id.tv_weight_mz);
        tv_weight_jz= (TextView) findViewById(R.id.tv_weight_jz);
        ed_weight_xzjz= (EditText) findViewById(R.id.ed_weight_xzjz);
        tv_weight_wnzl= (TextView) findViewById(R.id.tv_weight_wnzl);
        ed_weight_bz= (EditText) findViewById(R.id.ed_weight_bz);
        tv_weight_szly= (TextView) findViewById(R.id.tv_weight_szly);
        but_tijiao= (Button) findViewById(R.id.but_tijiao);
        group= (RadioGroup) findViewById(R.id.group);
        EventBus.getDefault().registerSticky(this);
    }

    @Override
    protected void initListener() {
        but_tijiao.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        tv_toolbar.setText("称重数据监控");
        button_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  finish();
            }
        });
        HashMap<String, Object> params = new HashMap<>();
        params.put("id",mEns.getWeightId());
        HttpLoader.get(ConstantsYunZhiShui.URL_TRANPORTTOUPDATE, params, WeightUpdateResponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_TRANPORTTOUPDATE, this, false).setTag(this);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.shi:
                        flag=true;
                        break;
                    case R.id.fou:
                        flag=false;
                        break;
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_tijiao:
                 /**提交*/
                HashMap<String, Object> params = new HashMap<>();
                String weight= ed_weight_xzjz.getText().toString();
                String bz=ed_weight_bz.getText().toString();
                if("".equals(weight)||"null".equals(weight)||weight==null){
                    Toast.makeText(WeightUpdateActivity.this, "净重不能为空,可填0", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!"".equals(bz)&&!"null".equals(bz)&&bz!=null){
                    params.put("remark", bz);
                }
                int a2=0;
                if(flag){
                    a2=1;
                }else{
                    a2=0;
                }
                params.put("repeatFlag",a2);
                params.put("id",mEns.getWeightId());
                params.put("updateNetWeight",weight);
                //Log.i("33333333333", bz + "----" + mEns.getWeightId() + "------" + weight + "----" + s2);
                HttpLoader.get(ConstantsYunZhiShui.URL_TRANPORTUPDATE, params, SaveResponse.class,
                        ConstantsYunZhiShui.REQUEST_CODE_TRANPORTUPDATE, this, false).setTag(this);
                break;
        }
    }
    public void onEvent(EventNormSelect ens){
            mEns=ens;
    }

    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TRANPORTTOUPDATE
                && response instanceof WeightUpdateResponse) {
            mWeightUpdate=(WeightUpdateResponse)response;

            if("00000".equals(mWeightUpdate.getErrorCode())&&mWeightUpdate.getData().getCarWeigh()!=null) {
                tv_weight_xzcl.setText("选择车辆:" + "   " + mWeightUpdate.getData().getCarWeigh().getCarNo());
                tv_weight_czd.setText("称重点:" + "   " + mEns.getWeightWnkind());
                tv_weight_pzsj.setText("皮重时间:" + "   " + mWeightUpdate.getData().getCarWeigh().getTareWeightTime());
                tv_weight_pz.setText("皮重:" + "   " + mWeightUpdate.getData().getCarWeigh().getTareWeight());
                tv_weight_mzsj.setText("毛重时间:" + "   " + mWeightUpdate.getData().getCarWeigh().getGrossWeightTime());
                tv_weight_mz.setText("毛重:" + "   " + mWeightUpdate.getData().getCarWeigh().getGrossWeight());
                tv_weight_jz.setText("净重:" + "   " + mWeightUpdate.getData().getCarWeigh().getNetWeight());
                tv_weight_wnzl.setText("污泥种类:" + "   " + mWeightUpdate.getData().getCarWeigh().getWnKind());
                String s = mWeightUpdate.getData().getCarWeigh().getDataSource();
                if ("1".equals(s)) {
                    s = "人工";
                } else {
                    s = "系统";
                }
                tv_weight_szly.setText("数据来源:" + "   " + s);
            }
          }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TRANPORTUPDATE
                && response instanceof SaveResponse) {
            SaveResponse mSave=(SaveResponse)response;
            Log.i("22222222222",mSave.getErrorCode());
            if("00000".equals(mSave.getErrorCode())){
                Toast.makeText(WeightUpdateActivity.this, "修改完成", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(WeightUpdateActivity.this,WeightActivity.class);
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
