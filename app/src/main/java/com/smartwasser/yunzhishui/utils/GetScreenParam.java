package com.smartwasser.yunzhishui.utils;

import android.app.Activity;

/**
 * Created by huangmengjie on 2016/7/5 0005.
 */

public class GetScreenParam  {
        public static int getScreenWidth(Activity activity) {
            return activity.getWindowManager().getDefaultDisplay().getWidth();
        }
        public static int getScreenHeight(Activity activity) {
            return activity.getWindowManager().getDefaultDisplay().getHeight();
        }
}
