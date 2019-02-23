package com.smartwasser.yunzhishui.fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.Activity.DataMainActivity;
/**
 * Created by huangmengjie on 2016/home/28 0028.
 */
public abstract class BaseFragment extends Fragment {
    private View view;
    public Context context;
    public SlidingMenu sliding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=(DataMainActivity)getActivity();
        sliding= DataMainActivity.getSliding();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=initView();
        return view;
    }
    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDate();
    }
    public abstract View initView();
    public abstract  void initDate();
}

