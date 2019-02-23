package com.smartwasser.yunzhishui.bean;

/**
 * Created by huangmengjie on 2016/8/29 0029.
 */
public class ItemBean {
     /**业务科目*/
    private String textKemu;
     /**对应金额*/
    private String textJe;
     /**计划值*/
    private String textJhz;
    /**剩余值*/
    private String textSyz;

    public String getTextKemu() {
        return textKemu;
    }

    public String getTextSyz() {
        return textSyz;
    }

    public String getTextJhz() {
        return textJhz;
    }

    public String getTextJe() {
        return textJe;
    }
    public void setTextKemu(String textKemu) {
        this.textKemu = textKemu;
    }
    public void setTextJhz(String textJhz) {
        this.textJhz = textJhz;
    }
    public void setTextJe(String textJe) {
        this.textJe = textJe;
    }
    public void setTextSyz(String textSyz) {
        this.textSyz = textSyz;
    }
}
