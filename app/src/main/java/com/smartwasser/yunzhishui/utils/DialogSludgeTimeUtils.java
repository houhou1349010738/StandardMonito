package com.smartwasser.yunzhishui.utils;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by huangmengjie on 2016/6/20 0020.
 */
public class DialogSludgeTimeUtils {
    private DateFormat fmtDateAndTime=DateFormat.getDateTimeInstance();;
    private Date b;
    private Calendar dateAndTime;
    private Context mContext;
    private  TimePickerDialog.OnTimeSetListener t;
    private  DatePickerDialog.OnDateSetListener d;
    public DialogSludgeTimeUtils(Context context){
        mContext=context;
    }
    /**
     * 更新页面TextView的方法
     */
    private void updateLabel(EditText ed){
        SimpleDateFormat  SDF1= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String a=SDF1.format(dateAndTime.getTime()).substring(0, 16);
        ed.setText(a);
    }
    public void show(final EditText ed) {
        /**获取一个日历对象*/
        dateAndTime = Calendar.getInstance(Locale.CHINA);
        /**当点击DatePickerDialog控件的设置按钮时，调用该方法*/
        d = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year,
                                  int monthOfYear, int dayOfMonth) {
                /**修改日历控件的年，月，日*/
                /**这里的year,monthOfYear,dayOfMonth的值与DatePickerDialog控件设置的最新值一致*/
                dateAndTime.set(Calendar.YEAR, year);
                dateAndTime.set(Calendar.MONTH, monthOfYear);
                dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                /**将页面TextView的显示更新为最新时间*/
                    updateLabel(ed);
            }
        };
        t = new TimePickerDialog.OnTimeSetListener() {

            //同DatePickerDialog控件
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
                dateAndTime.set(Calendar.MINUTE, minute);
                updateLabel(ed);

            }
        };

    }
    /**
     * 生成一个DatePickerDialog对象，并显示。显示的DatePickerDialog控件可以选择年月日，并设置
     */
    public void showTime() {
        new DatePickerDialog(mContext, d, dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH)).show();
        new TimePickerDialog(mContext,
                t,
                dateAndTime.get(Calendar.HOUR_OF_DAY),
                dateAndTime.get(Calendar.MINUTE),
                true).show();
    }
    public void show2(final EditText ed) {
        /**获取一个日历对象*/
        dateAndTime = Calendar.getInstance(Locale.CHINA);
        /**当点击DatePickerDialog控件的设置按钮时，调用该方法*/
        d = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year,
                                  int monthOfYear, int dayOfMonth) {
                /**修改日历控件的年，月，日*/
                /**这里的year,monthOfYear,dayOfMonth的值与DatePickerDialog控件设置的最新值一致*/
                dateAndTime.set(Calendar.YEAR, year);
                dateAndTime.set(Calendar.MONTH, monthOfYear);
                dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                /**将页面TextView的显示更新为最新时间*/
                updateLabel2(ed);
            }
        };
        t = new TimePickerDialog.OnTimeSetListener() {

            //同DatePickerDialog控件
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
                dateAndTime.set(Calendar.MINUTE, minute);
                updateLabel2(ed);

            }
        };

    }
    /**
     * 生成一个DatePickerDialog对象，并显示。显示的DatePickerDialog控件可以选择年月日，并设置
     */
    public void showTime2() {
        new DatePickerDialog(mContext, d, dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH)).show();
        new TimePickerDialog(mContext,
                t,
                dateAndTime.get(Calendar.HOUR_OF_DAY),
                dateAndTime.get(Calendar.MINUTE),
                true).show();
    }
    /**
     * 更新页面TextView的方法
     */
    private void updateLabel2(EditText ed){
        SimpleDateFormat  SDF1= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String a=SDF1.format(dateAndTime.getTime());
        ed.setText(a);
    }
}
