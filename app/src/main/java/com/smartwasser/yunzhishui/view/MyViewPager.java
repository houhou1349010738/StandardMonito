package com.smartwasser.yunzhishui.view;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by huangmengjie on 2015/12/9 0009.
 */
public class MyViewPager extends LazyViewPager{
    public MyViewPager(Context context) {
       this(context, null);
    }
    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }
}
