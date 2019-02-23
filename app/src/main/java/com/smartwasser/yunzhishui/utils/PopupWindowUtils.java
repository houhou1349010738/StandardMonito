package com.smartwasser.yunzhishui.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.smartwasser.yunzhishui.R;

/**
 * Created by huangmengjie on 2016/6/14 0014.
 */
public class PopupWindowUtils{
    private static PopupWindow pw;
    public static void showPopupWindow(ListView view,EditText ed){
        // 弹出一个PopupWindow的窗体, 把ListView作为其内容部分显示.
        pw = new PopupWindow(view,ed.getWidth() - 4,800);
        /**键盘弹出时,不会挡住pop*/
        pw.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        pw.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);

        // 设置可以使用焦点
        pw.setFocusable(true);
        ColorDrawable dw3 = new ColorDrawable(0xb0000000);
        pw.setBackgroundDrawable(dw3);
        // 设置popupwindow点击外部可以被关闭
        pw.setOutsideTouchable(true);
        // 设置一个popupWindow的背景
        pw.setBackgroundDrawable(new BitmapDrawable());
        // 把popupwindow显示出来, 显示的位置是: 在输入框的下面, 和输入框是连着的.
        pw.showAsDropDown(ed, 2, -5);
    }
    public static void closePopupWindow(){
        if(pw!=null){
           pw.dismiss();
        }
    }
    public static void showPopupWindow2(ListView view,View ed,Activity activity){
        // 弹出一个PopupWindow的窗体, 把ListView作为其内容部分显示.
        pw = new PopupWindow(view,(int)(GetScreenParam.getScreenWidth(activity)*0.278),(int)(GetScreenParam.getScreenHeight(activity)*0.261));
        /**键盘弹出时,不会挡住pop*/
        pw.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        pw.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);

        // 设置可以使用焦点
        pw.setFocusable(true);
        ColorDrawable dw3 = new ColorDrawable(0xb0ffffff);
        pw.setBackgroundDrawable(dw3);
        // 设置popupwindow点击外部可以被关闭
        pw.setOutsideTouchable(true);
        // 设置一个popupWindow的背景
        pw.setBackgroundDrawable(new BitmapDrawable());
        // 把popupwindow显示出来, 显示的位置是: 在输入框的下面, 和输入框是连着的.
        pw.showAsDropDown(ed, -(int)(GetScreenParam.getScreenWidth(activity)*0.094),(int)(GetScreenParam.getScreenHeight(activity)*0.03125));
    }
    public static void showPopupWindow3(ListView view,View ed){
        // 弹出一个PopupWindow的窗体, 把ListView作为其内容部分显示.
        pw = new PopupWindow(view,ed.getWidth()-80,600);
        /**键盘弹出时,不会挡住pop*/
        pw.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        pw.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);

        // 设置可以使用焦点
        pw.setFocusable(true);
        ColorDrawable dw3 = new ColorDrawable(0xb0000000);
        pw.setBackgroundDrawable(dw3);
        // 设置popupwindow点击外部可以被关闭
        pw.setOutsideTouchable(true);
        // 设置一个popupWindow的背景
        pw.setBackgroundDrawable(new BitmapDrawable());
        // 把popupwindow显示出来, 显示的位置是: 在输入框的下面, 和输入框是连着的.
        pw.showAsDropDown(ed,60, -2);
    }
    public static void showPopupWindow4(ListView view,EditText ed){
        // 弹出一个PopupWindow的窗体, 把ListView作为其内容部分显示.
        pw = new PopupWindow(view,ed.getWidth() - 4,500);
        /**键盘弹出时,不会挡住pop*/
        pw.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        pw.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);

        // 设置可以使用焦点
        pw.setFocusable(true);
        ColorDrawable dw3 = new ColorDrawable(0xb0000000);
        pw.setBackgroundDrawable(dw3);
        // 设置popupwindow点击外部可以被关闭
        pw.setOutsideTouchable(true);
        // 设置一个popupWindow的背景
        pw.setBackgroundDrawable(new BitmapDrawable());
        // 把popupwindow显示出来, 显示的位置是: 在输入框的下面, 和输入框是连着的.
        pw.showAsDropDown(ed, 2, -5);
    }
}
