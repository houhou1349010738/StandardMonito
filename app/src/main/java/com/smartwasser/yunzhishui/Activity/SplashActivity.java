package com.smartwasser.yunzhishui.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.utils.SharedUtils;
/**
 * Created by huangmengjie on 2016/home_press/help_press 0005.
 */
public class SplashActivity extends BaseActivity{
    Handler handler=new Handler();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    protected int initContentView() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
    }
    @Override
    protected void initListener() {

    }
    @Override
    protected void initData() {
        initFrist();
    }
    /**判断是否是第一次进入,如果是,则进入引导页,否则进入登录页*/
    private void initFrist() {
        boolean fristJoin= SharedUtils.getBooleanData(SplashActivity.this,"frist",true);
        if(fristJoin){
            /**进入引导页*/
            SharedUtils.setBooleanDate(SplashActivity.this, "frist", false);
            Intent intent=new Intent(SplashActivity.this,GuideActivity.class);
            startActivity(intent);
            finish();
        }else{
            /**2秒内进入登陆页面*/
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent2 = new Intent(SplashActivity.this,LoginActivity.class);
                    startActivity(intent2);
                    finish();
                }
            }, 2000);

        }
    }
}
