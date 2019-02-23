package com.smartwasser.yunzhishui.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.fragment.MenuFragment;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.pager.BasePager;
import com.smartwasser.yunzhishui.pager.HomeDataPager;
import com.smartwasser.yunzhishui.pager.HelpPager;
import com.smartwasser.yunzhishui.pager.MinePager;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by huangmengjie on 2016/home/28 0028.
 */
public class DataMainActivity extends SlidingFragmentActivity {
    private static SlidingMenu sliding;
    private MenuFragment mfragment;
    private ViewPager pager_home;
    private RadioGroup group_home;
    private List<BasePager> mlistPager;
    private Toolbar toolbar;
    private TextView tv_toolbar;
    private ImageButton button_menu;
    @Override
    public  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datamain);
        /**
         *设置布局
         * */
        setBehindContentView(R.layout.left_menu);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        tv_toolbar= (TextView) findViewById(R.id.tv_toolbar);
        button_menu= (ImageButton) findViewById(R.id.button_menu);
        button_menu.setImageResource(R.drawable.menu);
        toolbar.setTitle("");
        /**
         * 获取侧拉对象
         * */
        sliding=getSlidingMenu();
        /**
         * 设置侧拉模式
         * sliding.TOUCHMODE_FULLSCREEN  全屏有效
         * sliding.TOUCHMODE_MARGIN    边缘有效
         * sliding.TOUCHMODE_NONE      拉不出来
         * */
        sliding.setTouchModeAbove(sliding.TOUCHMODE_FULLSCREEN);
        /**
         *左侧栏目的宽度
         * */
        sliding.setBehindWidth(1000);
        /**
         *设置拉出的模式
         * */
        sliding.setMode(sliding.LEFT);
        /**
         * 画出左边的线
         * */
        sliding.setShadowDrawable(R.drawable.shapd);
        /**线的宽度*/
        sliding.setShadowWidthRes(R.dimen.base3dp);
        /**fragment替换左侧菜单*/
        mfragment=new MenuFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fr,mfragment).commit();
        button_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sliding.toggle();
            }
        });
        /**替换主菜单*/
        initView();
    }
      /**布局初始化*/
    private void initView() {
        pager_home= (ViewPager) findViewById(R.id.pager_datahome);
        group_home= (RadioGroup) findViewById(R.id.group_home);
        initData();
    }
    private void initData() {
        group_home.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.home_button:
                        /**点击对应的button返回对应的对象*/
                        pager_home.setCurrentItem(0);
                        tv_toolbar.setText("生产数据管理");
                        button_menu.setVisibility(View.VISIBLE);
                        sliding.setTouchModeAbove(sliding.TOUCHMODE_FULLSCREEN);
                        break;
                    case R.id.mine_button:
                        pager_home.setCurrentItem(1);
                        tv_toolbar.setText("我的");
                        button_menu.setVisibility(View.GONE);
                        sliding.setTouchModeAbove(sliding.TOUCHMODE_NONE);
                        break;
                    case R.id.help_button:
                        pager_home.setCurrentItem(2);
                        tv_toolbar.setText("帮助");
                        button_menu.setVisibility(View.GONE);
                        sliding.setTouchModeAbove(sliding.TOUCHMODE_NONE);
                        break;
                }
            }
        });
        group_home.check(R.id.home_button);
        mlistPager=new ArrayList<BasePager>();
          /**首页*/
        mlistPager.add(new HomeDataPager(this));
           /**个人中心*/
        mlistPager.add(new HelpPager(this));
          /**设置*/
        mlistPager.add(new MinePager(this));
        /**设置Viewpager适配器*/
        pager_home.setAdapter(new MyPagerAdapter());
        /**当页面改变时就要去填充数据*/
        pager_home.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                BasePager basePager = mlistPager.get(position);
                try {
                    basePager.initDatas();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        pager_home.setCurrentItem(0);
                        tv_toolbar.setText("生产数据管理");
                        button_menu.setVisibility(View.VISIBLE);
                        sliding.setTouchModeAbove(sliding.TOUCHMODE_FULLSCREEN);
                        break;
                    case 1:
                        pager_home.setCurrentItem(1);
                        tv_toolbar.setText("我的");
                        button_menu.setVisibility(View.GONE);
                        sliding.setTouchModeAbove(sliding.TOUCHMODE_NONE);
                        break;
                    case 2:
                        pager_home.setCurrentItem(2);
                        tv_toolbar.setText("帮助");
                        button_menu.setVisibility(View.GONE);
                        sliding.setTouchModeAbove(sliding.TOUCHMODE_NONE);
                        break;
                }
                switchRadioButton(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
    public static SlidingMenu getSliding(){
        return sliding;
    }
    class MyPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return mlistPager.size();
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
            View view= mlistPager.get(position).getRotorView();
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
    protected void onStop() {
        super.onStop();
        HttpLoader.cancelRequest(this);
    }
}

