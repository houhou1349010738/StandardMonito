package com.smartwasser.yunzhishui.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by huangmengjie on 2016/5/19 0019.
 */
public class TimeUtils {
    /**本月,和上月*/
    private String month_begin,month_end,last_month_begin,last_month_end;
    /**本年,和上年*/
    private String year_begin,year_end,last_year_begin,last_year_end;
    /**本季度和上季度*/
    private String quarter_begin,quarter_end,last_quarter_begin,last_quarter_end;
    private List<String> mlist;
    /**
     * 显示时间的快捷方式
     */
   public List<String> showTimeShortcut() {
        Calendar c = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        Calendar c3 = Calendar.getInstance();
        Calendar c4 = Calendar.getInstance();
        Calendar c5 = Calendar.getInstance();
        mlist = new ArrayList<String>();
        //Calendar c6= Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //获得星期几
        // int dayOfWeek = c.get(Calendar.DAY_OF_WEEK)-1;
        /**如果点击本周按钮, dateAndTime2中显示df.format(c.getTime())
         * dateAndTimeLabel显示df.format(c2.getTime())*/
        c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        c2.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        //增加一个星期，才是我们中国人理解的本周日的日期
        c.add(Calendar.WEEK_OF_YEAR, 1);
       /*c2.add(Calendar.WEEK_OF_YEAR, 1);*/
        // Log.i(TAG, df.format(c.getTime()) + "-----" + df.format(c2.getTime()));
        /**如果点击上周按钮,dateAndTime2中显示df.format(c4.getTime())
         * dateAndTimeLabel显示df.format(c3.getTime())*/
        c4.set(Calendar.DAY_OF_WEEK, 1);
        c3.add(Calendar.WEEK_OF_MONTH, -1);
        c3.set(Calendar.DAY_OF_WEEK, 2);
        // Log.i(TAG, df.format(c3.getTime()) + "-----" + df.format(c4.getTime()));
        /**如果点击本月按钮,dateAndTime2中显示df.format(c4.getTime())
         * dateAndTimeLabel显示df.format(c3.getTime())*/
        /**获取当前年月*/
        int year = c5.get(Calendar.YEAR);//取得系统日期
        int month = c5.get(Calendar.MONTH) + 1;
        int newMonth = month - 1;
        int day = c5.get(Calendar.DAY_OF_MONTH);
        month_begin = year + "-" + month + "-01";
        /**当前月月初,当前月月末*/
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            if (month == 2) {
                month_end = year + "-" + month + "-29";
            } else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                month_end = year + "-" + month + "-31";
            } else {
                month_end = year + "-" + month + "-30";
            }
        } else if (month == 2) {
            month_end = year + "-" + month + "-28";
        } else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            month_end = year + "-" + month + "-31";
        } else {
            month_end = year + "-" + month + "-30";
        }
        /**上月月初,上月月末*/
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            if (newMonth == 0) {
                /**说明这是十二月*/
                last_month_end = year - 1 + "-12-31";
                last_month_begin = year - 1 + "-12-01";
            } else if (newMonth == 2) {
                last_month_begin = year + "-" + newMonth + "-01";
                last_month_end = year + "-" + newMonth + "-29";
            } else if (newMonth == 1 || newMonth == 3 || newMonth == 5 || newMonth == 7 || newMonth == 8 || newMonth == 10) {
                last_month_end = year + "-" + newMonth + "-31";
                last_month_begin = year + "-" + newMonth + "-01";
            } else {
                last_month_end = year + "-" + newMonth + "-30";
                last_month_begin = year + "-" + newMonth + "-01";
            }
        } else if (newMonth == 0) {
            /**说明这是十二月*/
            last_month_end = year - 1 + "-12-31";
            last_month_begin = year - 1 + "-12-01";
        } else if (newMonth == 2) {
            last_month_begin = year + "-" + newMonth + "-01";
            last_month_end = year + "-" + newMonth + "-28";
        } else if (newMonth == 1 || newMonth == 3 || newMonth == 5 || newMonth == 7 || newMonth == 8 || newMonth == 10) {
            last_month_end = year + "-" + newMonth + "-31";
            last_month_begin = year + "-" + newMonth + "-01";
        } else {
            last_month_end = year + "-" + newMonth + "-30";
            last_month_begin = year + "-" + newMonth + "-01";
        }
        /**本年年初,和本年年末*/
        year_begin =year + "-01-01";
        year_end = year + "-12-31";
        /**上年年初和上年年末*/
        last_year_begin = year - 1 + "-01-01";
        last_year_end = year - 1 + "-12-31";
        /**本季度*/
        if (month == 1 || month == 2 || month == 3) {
            //1-3第一个季度
            quarter_begin = year +"-01-01";
            quarter_end = year + "-03-31";
        } else if (month == 5 || month == 4 || month == 6) {
            quarter_begin = year + "-04-01";
            quarter_end = year + "-06-30";
        } else if (month == 7 || month == 8 || month == 9) {
            quarter_begin = year + "-07-01";
            quarter_end = year + "-9-30";
        } else {
            quarter_begin = year + "-10-01";
            quarter_end = year + "-12-12";
        }
        /**上季度*/
        if (month == 1 || month == 2 || month == 3) {
            //1-3第一个季度
            last_quarter_begin = year + "-10-01";
            last_quarter_end = year + "-12-12";

        } else if (month == 5 || month == 4 || month == 6) {
            last_quarter_begin = year + "-01-01";
            last_quarter_end = year + "-03-31";

        } else if (month == 7 || month == 8 || month == 9) {
            last_quarter_begin = year + "-04-01";
            last_quarter_end = year + "-06-30";

        } else {
            last_quarter_begin = year + "-07-01";
            last_quarter_end = year + "-09-30";
        }
        //Log.i(TAG,s+"----"+s1+"--"+s3+"--"+s4+"---"+s5+"---"+s6+
        //"--"+s7+"--"+s8+"---"+s9+"--"+s10+"-"+s11+"--"+s12);
        mlist.add(df.format(c2.getTime()));
        mlist.add(df.format(c.getTime()));
        mlist.add(df.format(c3.getTime()));
        mlist.add(df.format(c4.getTime()));
        mlist.add(month_begin);
        mlist.add(month_end);
        mlist.add(last_month_begin);
        mlist.add(last_month_end);
        mlist.add(year_begin);
        mlist.add(year_end);
        mlist.add(last_year_begin);
        mlist.add(last_year_end);
        mlist.add(quarter_begin);
        mlist.add(quarter_end);
        mlist.add(last_quarter_begin);
        mlist.add(last_quarter_end);
        return mlist;
    }
}
