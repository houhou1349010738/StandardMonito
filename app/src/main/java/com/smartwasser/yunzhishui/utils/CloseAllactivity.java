package com.smartwasser.yunzhishui.utils;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;
import java.util.List;
     /**
       * 退出程序,关闭所有activity
       */
public class CloseAllactivity extends Application{
    private List<Activity> mListactivity=new ArrayList<Activity>();
    private static CloseAllactivity instance;
    private CloseAllactivity(){

    }
   /**单列模式中唯一一个获取closeAllactivity的实例*/
    public static CloseAllactivity getInstance(){
        if(null==instance){
            instance=new CloseAllactivity();
        }
        return instance;
    }
    public void addActivity(Activity activity){
        mListactivity.add(activity);
    }
    public void exit(){
       /**遍历集合finish*/
        for(Activity activity:mListactivity) {
            activity.finish();
        }
        System.exit(0);
    }
}
