package com.smartwasser.yunzhishui.fragment;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.smartwasser.yunzhishui.Activity.AddActivity;
import com.smartwasser.yunzhishui.Activity.DataMainActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.pager.BasePager;
import com.smartwasser.yunzhishui.pager.HelpPager;
import com.smartwasser.yunzhishui.pager.MinePager;
import com.smartwasser.yunzhishui.pager.ReportPager;
import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;
/**
 * Created by huangmengjie on 2016/5/5 0005.
 */
public class ReportFragment extends MainBaseFragment implements View.OnClickListener{
    private TextView tv_toolbar_report;
    private ImageButton button_fan,image_add;
    public  ImageButton image_serc;
    private ViewPager pager_datawork;
    private RadioGroup group_work;
    private List<BasePager> mListPager;
    private boolean mflag;
    private EventSearchResponse event;
    private   ReportPager pages;
    public Toolbar toolbar;

    @Override
    public View initView(LayoutInflater inflater) {
        view=inflater.inflate(R.layout.activity_workreport,null);
        pager_datawork= (ViewPager) view.findViewById(R.id.pager_datawork);
        group_work= (RadioGroup) view.findViewById(R.id.group_work);
        tv_toolbar_report= (TextView) view.findViewById(R.id.tv_toolbar_report);
        button_fan= (ImageButton) view.findViewById(R.id.button_fan);
        image_add= (ImageButton) view.findViewById(R.id.image_add);
        toolbar= (Toolbar) view.findViewById(R.id.toolbar);
        image_serc= (ImageButton) view.findViewById(R.id.image_serc);
        EventBus.getDefault().registerSticky(this);
        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }


    @Override
    public void initData() {
        if(mflag){
            image_add.setVisibility(View.VISIBLE);
        }else{
            image_add.setVisibility(View.GONE);
        }
        tv_toolbar_report.setText("水厂日报");
        /**得到数据*/
        group_work.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.home_button:
                        /**点击对应的button返回对应的对象*/
                        pager_datawork.setCurrentItem(0);
                        tv_toolbar_report.setText("水厂日报");
                        myInVisibility();
                        break;
                    case R.id.mine_button:
                        /**我的页面*/
                        pager_datawork.setCurrentItem(1);
                        tv_toolbar_report.setVisibility(View.VISIBLE);
                        tv_toolbar_report.setText("我的");
                        myVisibility();
                        break;
                    case R.id.help_button:
                        /**帮助页面*/
                        pager_datawork.setCurrentItem(2);
                        tv_toolbar_report.setVisibility(View.VISIBLE);
                        tv_toolbar_report.setText("帮助");
                        myVisibility();
                        break;
                }
            }
        });
        group_work.check(R.id.home_button);
        mListPager=new ArrayList<BasePager>();
        /**首页*/
        pages=new ReportPager(getActivity());
        mListPager.add(pages);
        /**个人中心*/
        mListPager.add(new HelpPager(getActivity()));
        /**设置*/
        mListPager.add(new MinePager(getActivity()));
        /**设置Viewpager适配器*/
        pager_datawork.setAdapter(new MyPagerAdapter());
        /**当页面改变时就要去填充数据*/
        pager_datawork.setOnPageChangeListener(new ViewPager.OnPageChangeListener(){
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
                        pager_datawork.setCurrentItem(0);
                        tv_toolbar_report.setText("水厂日报");
                        myInVisibility();
                        break;
                    case 1:
                        pager_datawork.setCurrentItem(1);
                        tv_toolbar_report.setVisibility(View.VISIBLE);
                        tv_toolbar_report.setText("我的");
                        myVisibility();
                        break;
                    case 2:
                        pager_datawork.setCurrentItem(2);
                        tv_toolbar_report.setVisibility(View.VISIBLE);
                        tv_toolbar_report.setText("帮助");
                        myVisibility();
                        break;
                }
                switchRadioButton(position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        image_serc.setOnClickListener(this);
        image_add.setOnClickListener(this);
        button_fan.setOnClickListener(this);
    }

    private void myInVisibility() {
        button_fan.setVisibility(View.VISIBLE);
        image_add.setVisibility(View.VISIBLE);
        image_serc.setVisibility(View.VISIBLE);
    }
    private void myVisibility() {
        button_fan.setVisibility(View.GONE);
        image_add.setVisibility(View.GONE);
        image_serc.setVisibility(View.GONE);
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.image_add:
                   /**跳到添加页面,传入值*/
                    pages.mlookdata.setTitleName(event.getTitleName());
                    EventBus.getDefault().postSticky(pages.mlookdata);
                    Intent intent = new Intent(getActivity(), AddActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getActivity().startActivity(intent);
                break;
            case R.id.image_serc:
                /**给他弹出pop*/
              /*  showMuchTrend();*/
                break;
            case R.id.button_fan:
                Intent intent3=new Intent(getActivity(),DataMainActivity.class);
                intent3.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getActivity().startActivity(intent3);
                break;
        }
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
                group_work.check(R.id.home_button);
                break;
            case 1:
                group_work.check(R.id.mine_button);
                break;
            case 2:
                group_work.check(R.id.help_button);
                break;
        }
    }
    public void onEvent(boolean flag){
           mflag=flag;
    }
    public void onEventMainThread(EventSearchResponse es){
             event=es;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
