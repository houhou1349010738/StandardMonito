package com.smartwasser.yunzhishui.utils;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by huangmengjie on 2016/6/20 0020.
 */
public class DialogTimeUtils{
    private DateFormat fmtDateAndTime;
    private Date b;
    private Calendar dateAndTime;
    private Context mContext;
    private  DatePickerDialog.OnDateSetListener d;
    public DialogTimeUtils(Context context){
        mContext=context;
    }
    /**
     * 更新页面TextView的方法
     */
    private void updateLabel(EditText ed){
        SimpleDateFormat  SDF1= new SimpleDateFormat("yyyy-MM-dd");
        String a=SDF1.format(dateAndTime.getTime()).substring(0, 10);
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
    }
    /**
     * 生成一个DatePickerDialog对象，并显示。显示的DatePickerDialog控件可以选择年月日，并设置
     */
    public void showTime() {
        new DatePickerDialog(mContext,d, dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH)).show();
    }
}
