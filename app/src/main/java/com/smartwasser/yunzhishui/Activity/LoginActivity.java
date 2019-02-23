package com.smartwasser.yunzhishui.Activity;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.LoginResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.SharedUtils;

import org.seny.android.utils.MyToast;

import de.greenrobot.event.EventBus;
/**
 * Created by huangmengjie on 2016/home_press/help_press 0005.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener,HttpLoader.ResponseListener{
    private Toolbar toolbar;
    private TextView tv_toolbar;
    private TextView but_register;
    private Button but_login;
    private TextView but_password;
    private CheckBox check_password;
    private EditText login_password,login_iphone;
    private ImageButton botton_menu;
    private String iphone;
    private String errorCode;
    private String password;
    private   String jsonID;
    private String errorMsg;
    private  String userID;
    private LoginResponse loginResponse;
    /**
     * 返回界面的布局
     */
    @Override
    protected int initContentView() {
        return R.layout.activity_login;
    }

    /**
     * 控件初始化
     */
    @Override
    protected void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        /**立即注册的按钮*/
        but_register = (TextView)findViewById(R.id.but_register);
        /**忘记密码的按钮**/
        but_password = (TextView) findViewById(R.id.but_password);
        botton_menu = (ImageButton) findViewById(R.id.button_menu);
        botton_menu.setVisibility(View.GONE);
        /**立即登录*/
        but_login = (Button) findViewById(R.id.but_login);
        check_password = (CheckBox) findViewById(R.id.check_password);
        tv_toolbar = (TextView) findViewById(R.id.tv_toolbar);
        login_password = (EditText) findViewById(R.id.login_password);
        login_iphone = (EditText) findViewById(R.id.login_iphone);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        if (SharedUtils.getBooleanData(this, "ISCHECK", false)) {
            check_password.setChecked(true);
            login_iphone.setText(SharedUtils.getStringData(this, "USER_NAME", ""));
            login_password.setText(SharedUtils.getStringData(this, "PASSWORD", ""));
        }
    }

    /**
     * 给控件设置监听,初始化监听
     */
    @Override
    protected void initListener() {
        but_register.setOnClickListener(this);
        but_password.setOnClickListener(this);
        but_login.setOnClickListener(this);
        check_password.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                /**说明已经勾选*/
                if (isChecked) {
                    SharedUtils.setBooleanDate(LoginActivity.this, "ISCHECK", true);
                } else {
                    SharedUtils.setBooleanDate(LoginActivity.this, "ISCHECK", false);
                }
            }
        });
    }
    /**
     * 数据初始化
     */
    @Override
    protected void initData() {
        tv_toolbar.setText("登录");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //立即登录
            case R.id.but_login:
                iphone = login_iphone.getText().toString().trim();
                password = login_password.getText().toString().trim();
                if (TextUtils.isEmpty(iphone)) {
                    Toast.makeText(LoginActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(LoginActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                HttpLoader.get(ConstantsYunZhiShui.URL_LOGIN + "bpkj_manager" + "/" + "8888", null, LoginResponse.class,
                        ConstantsYunZhiShui.REQUEST_CODE_LOGIN, this, false).setTag(this);
                showProgressDialog();
                break;
            //忘记密码
            case R.id.but_password:
                /**跳到忘记密码页面*/
                Intent intent2 = new Intent(LoginActivity.this, ForgetPasswordActivity.class);
                startActivity(intent2);
                break;
            //立即注册
            case R.id.but_register:
                /**跳转到注册页面*/
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }

    /**
     * 请求成功的方法
     */
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        //根据请求码判断响应结果是否是对应的请求，响应结果是否是期望的bean对象
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_LOGIN
                && response instanceof LoginResponse) {
            /**得到了想要的javabean*/
            loginResponse = (LoginResponse) response;
            /**得到用户名和密码*/
            if ("000000".equals(loginResponse.getErrorCode())) {
                /**判断用户名和密码是否存在,并且判断是否正确*/
                if (check_password.isChecked()) {
                    SharedUtils.setStringData(this, "USER_NAME", iphone);
                    SharedUtils.setStringData(this, "PASSWORD", password);
                }
                Intent intent3 = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent3);
            } else {
                Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
            }
            /**得到jsonID*/
            if (loginResponse.getData() == null) {
                jsonID = "";
                userID = "";
            }
            /**得到错误码*/
            errorCode = loginResponse.getErrorCode();
            /**得到登录成功的字符串*/
            errorMsg = loginResponse.getErrorMsg();
            /**将这个userID传到修改密码的界面*/
            EventBus.getDefault().postSticky(loginResponse);
        }
        dismissProgressDialog();
    }

    /**
     * 请求失败的方法
     */
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + errorCode);
        dismissProgressDialog();
    }
    @Override
    protected void onStop() {
        super.onStop();
        //当退出当前页面的时候，根据业务需求决定是否需要取消本次请求
        HttpLoader.cancelRequest(this);
        dismissProgressDialog();
    }
}
