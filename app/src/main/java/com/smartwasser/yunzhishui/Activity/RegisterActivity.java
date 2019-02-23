package com.smartwasser.yunzhishui.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.net.HttpLoader;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
/**
 * Created by huangmengjie on 2016/4/18 0018.
 */
public class RegisterActivity extends BaseActivity implements View.OnClickListener{
    private TextView tv_toolbar;
    private Toolbar toolbar;
    private EditText register_iphone,ed_register_code,register_password,register_password2;
    private Button but_register_code,but_register;
    private TextView tv_register_protocol;
    private ImageButton botton_menu;
    private TextView tv_now;
    private boolean flag = true;
    private int time = 60;
    private  String iPhone;
    private String iCord;
    @Override
    protected int initContentView() {
        return R.layout.activity_register;
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
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        tv_toolbar= (TextView) findViewById(R.id.tv_toolbar);
        register_iphone= (EditText) findViewById(R.id.register_iphone);
        ed_register_code= (EditText) findViewById(R.id.ed_register_code);
        register_password= (EditText) findViewById(R.id.register_password);
        register_password2= (EditText) findViewById(R.id.register_password2);
        botton_menu= (ImageButton) findViewById(R.id.button_menu);
        botton_menu.setVisibility(View.GONE);
        tv_now= (TextView) findViewById(R.id.now);
        but_register_code= (Button) findViewById(R.id.but_register_code);
        but_register= (Button) findViewById(R.id.but_register);
        tv_register_protocol= (TextView) findViewById(R.id.tv_register_protocol);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
    }
    @Override
    protected void initListener() {
        but_register_code.setOnClickListener(this);
        but_register.setOnClickListener(this);
    }
    @Override
    protected void initData() {
        tv_toolbar.setText("注册");
        toolbar.setNavigationIcon(R.drawable.fanhui);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* *//**返回到登录界面*//*
                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);*/
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
               /**立即注册*/
            case R.id.but_register:
                /**判断验证码*/
                if (!TextUtils.isEmpty(ed_register_code.getText().toString().trim())) {
                    if (ed_register_code.getText().toString().trim().length() == 4) {
                        iCord = ed_register_code.getText().toString().trim();
                        SMSSDK.submitVerificationCode("86", iPhone, iCord);
                        flag = false;
                    } else {
                        Toast.makeText(RegisterActivity.this, "请输入完整验证码", Toast.LENGTH_LONG).show();
                        ed_register_code.requestFocus();
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "请输入验证码", Toast.LENGTH_LONG).show();
                    ed_register_code.requestFocus();
                }
               break;
            case R.id.but_register_code:
                if (!TextUtils.isEmpty(register_iphone.getText().toString().trim())) {
                    if (register_iphone.getText().toString().trim().length() == 11) {
                        iPhone = register_iphone.getText().toString().trim();
                        SMSSDK.getVerificationCode("86", iPhone);
                        ed_register_code.requestFocus();
                        but_register_code.setVisibility(View.GONE);
                    } else {
                        Toast.makeText(RegisterActivity.this, "请输入完整电话号码", Toast.LENGTH_LONG).show();
                        register_iphone.requestFocus();
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "请输入您的电话号码", Toast.LENGTH_LONG).show();
                    register_iphone.requestFocus();
                }
                break;
        }
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
                    Toast.makeText(RegisterActivity.this, "验证码校验成功", Toast.LENGTH_SHORT).show();
                    handlerText.sendEmptyMessage(2);
                } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                    //服务器验证码发送成功
                    reminderText();
                    Toast.makeText(RegisterActivity.this, "验证码已经发送", Toast.LENGTH_SHORT).show();
                }

            } else if (event == SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES) {
                Toast.makeText(RegisterActivity.this, "获取国家列表成功", Toast.LENGTH_SHORT).show();
            } else {
                if (flag) {
                    but_register_code.setVisibility(View.VISIBLE);
                    Toast.makeText(RegisterActivity.this, "验证码获取失败，请重新获取", Toast.LENGTH_SHORT).show();
                    register_iphone.requestFocus();
                } else {
                    ((Throwable) data).printStackTrace();
                    //int resId =getStringRes(MainActivity.this, "smssdk_network_error");
                    Toast.makeText(RegisterActivity.this, "验证码错误", Toast.LENGTH_SHORT).show();
                    ed_register_code.selectAll();
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
                    but_register_code.setVisibility(View.VISIBLE);
                }
            } else {
                ed_register_code.setText("");
                tv_now.setText("提示信息");
                time = 60;
                tv_now.setVisibility(View.GONE);
                but_register_code.setVisibility(View.VISIBLE);
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
    }

    @Override
    protected void onStop() {
        super.onStop();
        HttpLoader.cancelRequest(this);
    }
}
