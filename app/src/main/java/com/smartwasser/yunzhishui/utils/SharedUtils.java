package com.smartwasser.yunzhishui.utils;
/**
 * Created by huangmengjie on 2015/12/mine_press 0006.
 */
import android.content.Context;
import android.content.SharedPreferences;
/**
 * 存取一些数据的工具类
 */
public class SharedUtils {
    private final static String CONFIG="config";
    private static SharedPreferences sp;
    public static boolean getBooleanData(Context context,String key,boolean defulat){
           if(sp==null) {
              sp = context.getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
           }
              boolean nu=sp.getBoolean(key,defulat);
              return nu;
    }
    public static void setBooleanDate(Context context, String key, boolean jilu) {
        if (sp == null) {
            sp = context.getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
        }
        SharedPreferences.Editor ed = sp.edit();
        ed.putBoolean(key, jilu);
        ed.commit();
    }

    public static String getStringData(Context context, String key, String defulat) {
        if (sp == null) {
            sp = context.getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
        }
        String str = sp.getString(key, defulat);
        return str;
    }

    public static void setStringData(Context context, String key, String nihao) {
        if (sp == null) {
            sp = context.getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
        }
        SharedPreferences.Editor ed = sp.edit();
        ed.putString(key, nihao);
        ed.commit();
    }
}
