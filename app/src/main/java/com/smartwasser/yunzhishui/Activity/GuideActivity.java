package com.smartwasser.yunzhishui.Activity;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.smartwasser.yunzhishui.R;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by huangmengjie on 2016/home_press/help_press 0005.
 */
public class GuideActivity extends BaseActivity{
    private ViewPager pager_guide;
    private List<ImageView> mlistImager;
    private int icon[];
    private Button button;
    @Override
    protected int initContentView() {
        return R.layout.activity_guide;
    }
      /**初始化控件*/
    @Override
    protected void initView() {
        pager_guide= (ViewPager)findViewById(R.id.pager_guide);
        button= (Button) findViewById(R.id.button);
    }
        @Override
       protected void initListener() {

        }

      /**初始化数据*/
       protected void initData(){
           icon=new int[]{R.drawable.guide_1,R.drawable.guide_2,R.drawable.guide_3};
          /**得到数据源*/
        mlistImager=new ArrayList<ImageView>();
        ImageView image;
        for(int i=0;i<icon.length;i++){
            image=new ImageView(getApplicationContext());
            image.setBackgroundResource(icon[i]);
            mlistImager.add(image);
        }
        /**设置适配器*/
        pager_guide.setAdapter(new MyAdapter());
        pager_guide.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                     /**如果滑动到最后一张图片*/
                if(mlistImager.size()-1==position){
                     button.setVisibility(View.VISIBLE);
                     button.setOnClickListener(new View.OnClickListener() {
                         @Override
                         public void onClick(View v) {
                             Intent intent=new Intent(GuideActivity.this,SplashActivity.class);
                             startActivity(intent);
                             finish();
                         }
                     });
                }
            }
            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    class MyAdapter extends PagerAdapter{
        @Override
        public int getCount() {
            return mlistImager.size();
        }
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ((ViewPager)container).addView(mlistImager.get(position));
            return mlistImager.get(position);
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager)container).removeView((View) object);
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mlistImager.clear();
        mlistImager=null;
    }
}
