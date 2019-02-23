package com.smartwasser.yunzhishui.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.LoginResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.pager.BasePager;
import com.smartwasser.yunzhishui.pager.HelpPager;
import com.smartwasser.yunzhishui.pager.HomePager;
import com.smartwasser.yunzhishui.pager.MinePager;
import com.smartwasser.yunzhishui.utils.MD5;
import com.smartwasser.yunzhishui.utils.SharedUtils;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;
/**
 * Created by huangmengjie on 2016/4/18 0018.
 */
public class MainActivity extends BaseActivity implements HttpLoader.ResponseListener{
    private LoginResponse mloginResponse;
    private static List<String> Headers;
    private static String jsonID;
    private static String userID;
    private ViewPager pager_home;
    private RadioGroup group_home;
    public List<BasePager> mListPager;
    private Toolbar toolbar;
    private RelativeLayout re_home;
    private TextView tv_toolbar;
    @Override
    protected int initContentView() {
        return R.layout.activity_main;
    }
       /**ui初始化*/
    @Override
    protected void initView() {
        EventBus.getDefault().registerSticky(this);
        pager_home= (ViewPager)findViewById(R.id.pager_home);
        group_home= (RadioGroup) findViewById(R.id.group_home);
        tv_toolbar= (TextView)findViewById(R.id.tv_toolbar);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        re_home= (RelativeLayout)findViewById(R.id.re_home);
    }
      /**监听*/
    @Override
    protected void initListener() {
    }
      /**数据初始化*/
    @Override
    protected void initData() {
        if(mloginResponse!=null&&mloginResponse.getData()!=null) {
            jsonID =mloginResponse.getData().getJSESSIONID();
            userID = mloginResponse.getData().getUserid();
        }
        /**得到数据*/
        group_home.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.home_button:
                        /**点击对应的button返回对应的对象*/
                        pager_home.setCurrentItem(0);
                        re_home.setVisibility(View.VISIBLE);
                        tv_toolbar.setVisibility(View.GONE);
                        break;
                    case R.id.mine_button:
                        /**我的页面*/
                        pager_home.setCurrentItem(1);
                        re_home.setVisibility(View.GONE);
                        tv_toolbar.setVisibility(View.VISIBLE);
                        tv_toolbar.setText("我的");
                        break;
                    case R.id.help_button:
                        /**帮助页面*/
                        pager_home.setCurrentItem(2);
                        re_home.setVisibility(View.GONE);
                        tv_toolbar.setVisibility(View.VISIBLE);
                        tv_toolbar.setText("帮助");
                        break;
                }
            }
        });
        group_home.check(R.id.home_button);
        mListPager=new ArrayList<BasePager>();
        /**首页*/
        mListPager.add(new HomePager(this));
        /**个人中心*/
        mListPager.add(new HelpPager(this));
        /**设置*/
        mListPager.add(new MinePager(this));
        /**设置Viewpager适配器*/
        pager_home.setAdapter(new MyPagerAdapter());
        /**当页面改变时就要去填充数据*/
        pager_home.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                BasePager basePager = mListPager.get(position);
                try {
                    basePager.initDatas();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        pager_home.setCurrentItem(0);
                        re_home.setVisibility(View.VISIBLE);
                        tv_toolbar.setVisibility(View.GONE);
                        break;
                    case 1:
                        pager_home.setCurrentItem(1);
                        re_home.setVisibility(View.GONE);
                        tv_toolbar.setVisibility(View.VISIBLE);
                        tv_toolbar.setText("我的");
                        break;
                    case 2:
                        pager_home.setCurrentItem(2);
                        re_home.setVisibility(View.GONE);
                        tv_toolbar.setVisibility(View.VISIBLE);
                        tv_toolbar.setText("帮助");
                        break;
                }
                switchRadioButton(position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    class MyPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return mListPager.size();
        }
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view=mListPager.get(position).getRotorView();
            container.addView(view);
            return view;
        }
    }
    private void switchRadioButton(int position) {
        switch (position) {
            case 0:
                group_home.check(R.id.home_button);
                break;
            case 1:
                group_home.check(R.id.mine_button);
                break;
            case 2:
                group_home.check(R.id.help_button);
                break;
        }
    }
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {

    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    public void onEvent(LoginResponse loginResponse){
        mloginResponse=loginResponse;
    }
    public static List<String> mListHeader(){
        Headers=new ArrayList<String>();
        /**得到手机型号*/
        String mobilebrand = android.os.Build.MODEL;
        /**手机版本号*/
        String appversionno="1.0";
        /**接口调用平台的类型*/
        MD5 getMD5 = new MD5();
        String sign=getMD5.GetMD5Code("appversionno=1.0calltime=400mobilebrand="+mobilebrand+"platformtype=androidtokenid="+jsonID+"userid="+userID);
        /**将sign,jsonID,userID,mobilebrand*/
        Headers.add(jsonID);
        Headers.add(userID);
        Headers.add(mobilebrand);
        Headers.add(sign);
        return Headers;
    }
    @Override
    public void onStop() {
        super.onStop();
        HttpLoader.cancelRequest(this);
    }


}
