package com.smartwasser.yunzhishui.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.ForgetPasswordResponse;
import com.smartwasser.yunzhishui.bean.LoginResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;

import java.util.HashMap;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import de.greenrobot.event.EventBus;
/**
 * Created by huangmengjie on 2016/4/19 0019.
 */
public class ForgetPasswordActivity extends BaseActivity implements View.OnClickListener,HttpLoader.ResponseListener{
    private Toolbar toolbar;
    private TextView tv_toolbar,tv_xieyi,tv_now;
    private EditText forget_password_iphone,forget_password_code,forget_password,forget_password2;
    private Button but_forget_code,but_forget_password;
    private ImageButton botton_menu;
    private boolean flag = true;
    private int time = 60;
    private  String errorCode;
    private String errorMsg;
    private String userID;
    @Override
    protected int initContentView() {
        return R.layout.activity_forget_password;
    }
    @Override
    protected void initView() {
        SMSSDK.initSDK(this, "11d497bca2e57", "a5ba304e23306fcb6104560fcfe1b7ce");
        EventHandler eh=new EventHandler(){
            /**在操作结束的时候被触发 */
            @Override
            public void afterEvent(int event, int result, Object data) {
                Message msg = new Message();
                msg.arg1 = event;
                msg.arg2 = result;
                msg.obj = data;
                handler.sendMessage(msg);
            }
        };
        /**注册*/
        SMSSDK.registerEventHandler(eh);
        toolbar= (Toolbar)findViewById(R.id.toolbar);
        tv_toolbar= (TextView) findViewById(R.id.tv_toolbar);
        botton_menu= (ImageButton) findViewById(R.id.button_menu);
        botton_menu.setVisibility(View.GONE);
        tv_xieyi= (TextView) findViewById(R.id.tv_xieyi);
        forget_password_iphone= (EditText) findViewById(R.id.forget_password_iphone);
        forget_password_code= (EditText) findViewById(R.id.forget_password_code);
        forget_password= (EditText) findViewById(R.id.forget_password);
        forget_password2= (EditText) findViewById(R.id.forget_password2);
        but_forget_code= (Button) findViewById(R.id.but_forget_code);
        but_forget_password= (Button) findViewById(R.id.but_forget_password);
        tv_now= (TextView) findViewById(R.id.now);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
         /* *//**注册一个EventBus*//*
        EventBus.getDefault().registerSticky(this);*/
    }
    @Override
    protected void initListener() {
        but_forget_code.setOnClickListener(this);
        but_forget_password.setOnClickListener(this);
    }
    @Override
    protected void initData() {
        String password=forget_password.getText().toString().trim();
        tv_toolbar.setText("忘记密码");
        toolbar.setNavigationIcon(R.drawable.fanhui);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgetPasswordActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //准备请求参数
        HashMap<String, Object> params = new HashMap<>();
        params.put("password", password);
        params.put("id", userID);
        HttpLoader.get(ConstantsYunZhiShui.URL_FORGETPASSWORD, params, LoginResponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_FORGETPASSWORD,this).setTag(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
              //单击验证码的按钮
            case R.id.but_forget_code:
                break;
              //立即修改
            case R.id.but_forget_password:
                if("00000".equals(errorCode)){
                    Toast.makeText(ForgetPasswordActivity.this, "修改完成", Toast.LENGTH_SHORT).show();
                    /**跳转到登录界面*/
                    Intent intent=new Intent(ForgetPasswordActivity.this,LoginActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(ForgetPasswordActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
     public void onEvent(String s){
          userID=s;
     }
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int event = msg.arg1;
            int result = msg.arg2;
            Object data = msg.obj;
            // Log.e("event", "event=" + event);
            if (result == SMSSDK.RESULT_COMPLETE) {
                //短信注册成功后，返回MainActivity,然后提示新好友
                if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                    //提交验证码成功,验证通过
                    Toast.makeText(ForgetPasswordActivity.this, "验证码校验成功", Toast.LENGTH_SHORT).show();
                    handlerText.sendEmptyMessage(2);
                } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                    //服务器验证码发送成功
                    reminderText();
                    Toast.makeText(ForgetPasswordActivity.this, "验证码已经发送", Toast.LENGTH_SHORT).show();
                }

            } else if (event == SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES) {
                Toast.makeText(ForgetPasswordActivity.this, "获取国家列表成功", Toast.LENGTH_SHORT).show();
            } else {
                if (flag) {
                    but_forget_code.setVisibility(View.VISIBLE);
                    Toast.makeText(ForgetPasswordActivity.this, "验证码获取失败，请重新获取", Toast.LENGTH_SHORT).show();
                    forget_password_iphone.requestFocus();
                } else {
                    ((Throwable) data).printStackTrace();
                    //int resId =getStringRes(MainActivity.this, "smssdk_network_error");
                    Toast.makeText(ForgetPasswordActivity.this, "验证码错误", Toast.LENGTH_SHORT).show();
                    forget_password_code.selectAll();
                    /*if (resId > 0) {
                        Toast.makeText(MainActivity.this, resId, Toast.LENGTH_SHORT).show();
                    }*/
                }
            }
        }
    };
    Handler handlerText = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                if (time > 0) {
                    tv_now.setText("验证码已发送" + time + "秒");
                    time--;
                    handlerText.sendEmptyMessageDelayed(1, 1000);
                } else {
                    tv_now.setText("提示信息");
                    time = 60;
                    tv_now.setVisibility(View.GONE);
                    but_forget_code.setVisibility(View.VISIBLE);
                }
            } else {
                forget_password_code.setText("");
                tv_now.setText("提示信息");
                time = 60;
                tv_now.setVisibility(View.GONE);
                but_forget_code.setVisibility(View.VISIBLE);
            }
        }
    };
    private void reminderText() {
        tv_now.setVisibility(View.VISIBLE);
        handlerText.sendEmptyMessageDelayed(1, 1000);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        SMSSDK.unregisterAllEventHandler();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if(requestCode ==ConstantsYunZhiShui.REQUEST_CODE_FORGETPASSWORD
                && response instanceof ForgetPasswordResponse){
            ForgetPasswordResponse ForgetResponse= (ForgetPasswordResponse) response;
               /**修改正确的正确码*/
            errorCode=ForgetResponse.getErrorCode();
            errorMsg=ForgetResponse.getErrorMsg();
        }
    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
    }
    @Override
    protected void onStop() {
        super.onStop();
        HttpLoader.cancelRequest(this);
    }
}
