package com.smartwasser.yunzhishui.fragment;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.pager.BasePager;
import com.smartwasser.yunzhishui.pager.FloodcontrolPager;
import com.smartwasser.yunzhishui.pager.HelpPager;
import com.smartwasser.yunzhishui.pager.MinePager;
import com.smartwasser.yunzhishui.pager.ProductionPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangmengjie on 2016/7/22 0022.
 */
public class FloodcontrolFragment extends MainBaseFragment{
    private TextView tv_toolbar_report;
    private ImageButton button_fan,image_serc;
    private ViewPager pager_traffic;
    private RadioGroup group_traffic;
    private List<BasePager> mListPager;
    @Override
    public View initView(LayoutInflater inflater) {
        view=inflater.inflate(R.layout.activity_traffic,null);
        pager_traffic= (ViewPager) view.findViewById(R.id.pager_traffic);
        group_traffic= (RadioGroup) view.findViewById(R.id.group_traffic);
        tv_toolbar_report= (TextView) view.findViewById(R.id.tv_toolbar_report);
        button_fan= (ImageButton) view.findViewById(R.id.button_fan);
        image_serc= (ImageButton) view.findViewById(R.id.image_serc);
        image_serc.setVisibility(View.GONE);
        tv_toolbar_report.setText("城市防汛");
        return view;
    }

    @Override
    public void initData() {
        /**得到数据*/
        group_traffic.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.home_button:
                        /**点击对应的button返回对应的对象*/
                        pager_traffic.setCurrentItem(0);
                        tv_toolbar_report.setText("城市防汛");
                        break;
                    case R.id.mine_button:
                        /**我的页面*/
                        pager_traffic.setCurrentItem(1);
                        tv_toolbar_report.setVisibility(View.VISIBLE);
                        tv_toolbar_report.setText("我的");
                        break;
                    case R.id.help_button:
                        /**帮助页面*/
                        pager_traffic.setCurrentItem(2);
                        tv_toolbar_report.setVisibility(View.VISIBLE);
                        tv_toolbar_report.setText("帮助");
                        break;
                }
            }
        });
        group_traffic.check(R.id.home_button);
        mListPager=new ArrayList<BasePager>();
        /**首页*/
        mListPager.add(new FloodcontrolPager(getActivity()));
        /**个人中心*/
        mListPager.add(new HelpPager(getActivity()));
        /**设置*/
        mListPager.add(new MinePager(getActivity()));
        /**设置Viewpager适配器*/
        pager_traffic.setAdapter(new MyPagerAdapter());
        /**当页面改变时就要去填充数据*/
        pager_traffic.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
                switch (position) {
                    case 0:
                        pager_traffic.setCurrentItem(0);
                        tv_toolbar_report.setText("城市防汛");
                        break;
                    case 1:
                        pager_traffic.setCurrentItem(1);
                        tv_toolbar_report.setVisibility(View.VISIBLE);
                        tv_toolbar_report.setText("我的");
                        break;
                    case 2:
                        pager_traffic.setCurrentItem(2);
                        tv_toolbar_report.setVisibility(View.VISIBLE);
                        tv_toolbar_report.setText("帮助");
                        break;
                }
                switchRadioButton(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        button_fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
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
            container.removeView((View) object);
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
                group_traffic.check(R.id.home_button);
                break;
            case 1:
                group_traffic.check(R.id.mine_button);
                break;
            case 2:
                group_traffic.check(R.id.help_button);
                break;
        }
    }
}
