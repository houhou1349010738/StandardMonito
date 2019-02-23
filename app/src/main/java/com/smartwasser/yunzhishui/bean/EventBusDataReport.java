package com.smartwasser.yunzhishui.bean;

/**
 * Created by huangmengjie on 2016/5/3 0003.
 */
public class EventBusDataReport{
    private String text;


    public EventBusDataReport(String text) {
        this.text = text;
    }
    public String getText(){
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
}
