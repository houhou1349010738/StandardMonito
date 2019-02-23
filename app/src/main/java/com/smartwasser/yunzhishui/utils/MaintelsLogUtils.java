package com.smartwasser.yunzhishui.utils;

import android.util.Log;

/**
 * 作者：陈杰宇
 * 时间： 2016/1/5 14:05
 */
public class MaintelsLogUtils {


    public static void outLog(String msg) {

        boolean isShow = true;
        if (isShow) {
            Log.i("maintel", msg);
        }
    }


}
