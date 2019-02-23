package com.smartwasser.yunzhishui.utils;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.smartwasser.yunzhishui.Activity.WaterworksDayActivity;
import com.smartwasser.yunzhishui.R;
/**
 * Created by huangmengjie on 2016/6/21 0021.
 */
public class PopupSearchUtils {
    private Activity mContext;
    public PopupWindow pw;

    public PopupSearchUtils(Activity context) {
        mContext = context;
    }

    public void showPopupSearch(View view, View toolbar) {
        /**弹出搜索按钮*/
        // 弹出一个PopupWindow的窗体, 把ListView作为其内容部分显示
        pw = new PopupWindow(view,mContext.getWindowManager().getDefaultDisplay().getWidth(), mContext.getWindowManager().getDefaultDisplay().getHeight());
        /**键盘弹出时,不会挡住pop*/
        pw.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        pw.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        pw.setAnimationStyle(R.style.mypopwindow_anim_style);

        // 设置可以使用焦点
        pw.setFocusable(true);
        // 设置popupwindow点击外部可以被关闭
        pw.setOutsideTouchable(true);
        ColorDrawable dw = new ColorDrawable();
        // 设置一个popupWindow的背景
        pw.setBackgroundDrawable(dw);
        // 把popupwindow显示出来, 显示的位置是: 在输入框的下面, 和输入框是连着的.
        pw.showAsDropDown(toolbar, 2, -5);
    }
    public void colsePopupWindow() {
        pw.dismiss();
    }
    public void showPopupSearch2(View view, View toolbar) {
        /**弹出搜索按钮*/
        // 弹出一个PopupWindow的窗体, 把ListView作为其内容部分显示.
        pw = new PopupWindow(view, mContext.getWindowManager().getDefaultDisplay().getWidth(),mContext.getWindowManager().getDefaultDisplay().getHeight()/2);
        /**键盘弹出时,不会挡住pop*/
        pw.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        pw.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        pw.setAnimationStyle(R.style.mypopwindow_anim_style);

        // 设置可以使用焦点
        pw.setFocusable(true);
        // 设置popupwindow点击外部可以被关闭
        pw.setOutsideTouchable(true);
        ColorDrawable dw = new ColorDrawable();
        // 设置一个popupWindow的背景
        pw.setBackgroundDrawable(dw);
        // 把popupwindow显示出来, 显示的位置是: 在输入框的下面, 和输入框是连着的.
        pw.showAsDropDown(toolbar,2,300);
    }
    public void showPopupSearch3(View view, View toolbar) {
        /**弹出搜索按钮*/
        // 弹出一个PopupWindow的窗体, 把ListView作为其内容部分显示.
        pw = new PopupWindow(view, mContext.getWindowManager().getDefaultDisplay().getWidth(),mContext.getWindowManager().getDefaultDisplay().getHeight());
        /**键盘弹出时,不会挡住pop*/
        pw.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        pw.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        pw.setAnimationStyle(R.style.mypopwindow_anim_style);

        // 设置可以使用焦点
        pw.setFocusable(true);
        // 设置popupwindow点击外部可以被关闭
        pw.setOutsideTouchable(true);
        ColorDrawable dw = new ColorDrawable();
        // 设置一个popupWindow的背景
        pw.setBackgroundDrawable(dw);
        // 把popupwindow显示出来, 显示的位置是: 在输入框的下面, 和输入框是连着的.
        pw.showAsDropDown(toolbar,2,28);
    }
    public void showPopupSearch4(View view, View toolbar) {
        /**弹出搜索按钮*/
        // 弹出一个PopupWindow的窗体, 把ListView作为其内容部分显示.
        pw = new PopupWindow(view,R.dimen.base1080dp,R.dimen.base1920dp);
        /**键盘弹出时,不会挡住pop*/
        pw.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        pw.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        pw.setAnimationStyle(R.style.mypopwindow_anim_style);

        // 设置可以使用焦点
        pw.setFocusable(true);
        // 设置popupwindow点击外部可以被关闭
        pw.setOutsideTouchable(true);
        ColorDrawable dw = new ColorDrawable();
        // 设置一个popupWindow的背景
        pw.setBackgroundDrawable(dw);
        // 把popupwindow显示出来, 显示的位置是: 在输入框的下面, 和输入框是连着的.
        pw.showAsDropDown(toolbar, 2, -5);
    }
    public void showPopupSearch5(View view, View toolbar) {
        /**弹出搜索按钮*/
        // 弹出一个PopupWindow的窗体, 把ListView作为其内容部分显示.
        pw = new PopupWindow(view, mContext.getWindowManager().getDefaultDisplay().getWidth(),(int)(mContext.getWindowManager().getDefaultDisplay().getHeight()*0.5));
        /**键盘弹出时,不会挡住pop*/
        pw.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        pw.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        pw.setAnimationStyle(R.style.mypopwindow_anim_style);

        // 设置可以使用焦点
        pw.setFocusable(true);
        // 设置popupwindow点击外部可以被关闭
        pw.setOutsideTouchable(true);
        ColorDrawable dw = new ColorDrawable();
        // 设置一个popupWindow的背景
        pw.setBackgroundDrawable(dw);
        // 把popupwindow显示出来, 显示的位置是: 在输入框的下面, 和输入框是连着的.
        pw.showAsDropDown(toolbar,2,(int)(mContext.getWindowManager().getDefaultDisplay().getHeight()*0.2));
    }
}
