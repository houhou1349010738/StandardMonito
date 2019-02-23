package com.smartwasser.yunzhishui.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by huangmengjie on 2016/7/17 0017.
 */
public class TimeUtils2 {
    private  String defaultStartDate;
    public String getTimeDate(int i){
        Date dBefore = new Date();
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.add(Calendar.DAY_OF_MONTH, -i);//设置为前一天
        dBefore = calendar.getTime();   //得到前一天的时间
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置时间格式
        defaultStartDate = sdf.format(dBefore);//格式化前一天
        String s=defaultStartDate.substring(0,16);
        return s;
    }
}
