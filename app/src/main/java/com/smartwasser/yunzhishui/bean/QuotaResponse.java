package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/29 0029.
 */
public class QuotaResponse extends RBResponse {

    private DataEntity data;
    /**
     * data : {"comboboxList":[{"id":"","selected":true,"text":"请选择"},{"id":"D0035","selected":false,"text":"1#V型滤池1#出水阀关闭状态"},{"desc":"%","id":"A0022","selected":false,"text":"1#V型滤池1#出水阀开度"},{"desc":"%","id":"A7049","selected":false,"text":"1#V型滤池1#出水阀开度峰值"},{"desc":"%","id":"A5385","selected":false,"text":"1#V型滤池1#出水阀开度平均值"},{"desc":"%","id":"A15406","selected":false,"text":"1#V型滤池1#出水阀开度瞬时值"},{"desc":"%","id":"A10389","selected":false,"text":"1#V型滤池1#出水阀开度谷值"},{"id":"D0036","selected":false,"text":"1#V型滤池1#出水阀运行状态"},{"id":"D7941","selected":false,"text":"1#V型滤池1#出水阀运行状态运行时间"},{"id":"A0024","selected":false,"text":"1#V型滤池1#压差"},{"id":"A7047","selected":false,"text":"1#V型滤池1#压差峰值"},{"id":"A5387","selected":false,"text":"1#V型滤池1#压差平均值"},{"id":"A15408","selected":false,"text":"1#V型滤池1#压差瞬时值"},{"id":"A10387","selected":false,"text":"1#V型滤池1#压差谷值"},{"id":"D0038","selected":false,"text":"1#V型滤池1#排气阀运行状态"},{"id":"D7943","selected":false,"text":"1#V型滤池1#排气阀运行状态运行时间"},{"id":"D0039","selected":false,"text":"1#V型滤池1#气冲阀运行状态"},{"id":"D7944","selected":false,"text":"1#V型滤池1#气冲阀运行状态运行时间"},{"id":"D0040","selected":false,"text":"1#V型滤池1#水冲阀运行状态"},{"id":"D7945","selected":false,"text":"1#V型滤池1#水冲阀运行状态运行时间"},{"desc":"m","id":"A0025","selected":false,"text":"1#V型滤池1#液位"},{"desc":"m","id":"A7048","selected":false,"text":"1#V型滤池1#液位峰值"},{"desc":"m","id":"A5388","selected":false,"text":"1#V型滤池1#液位平均值"},{"desc":"m","id":"A15409","selected":false,"text":"1#V型滤池1#液位瞬时值"},{"desc":"m","id":"A10388","selected":false,"text":"1#V型滤池1#液位谷值"},{"desc":"%","id":"A0023","selected":false,"text":"1#V型滤池1#进水阀开度"},{"desc":"%","id":"A7050","selected":false,"text":"1#V型滤池1#进水阀开度峰值"},{"desc":"%","id":"A5386","selected":false,"text":"1#V型滤池1#进水阀开度平均值"},{"desc":"%","id":"A15407","selected":false,"text":"1#V型滤池1#进水阀开度瞬时值"},{"desc":"%","id":"A10390","selected":false,"text":"1#V型滤池1#进水阀开度谷值"},{"id":"D0037","selected":false,"text":"1#V型滤池1#进水阀运行状态"},{"id":"D7942","selected":false,"text":"1#V型滤池1#进水阀运行状态运行时间"},{"id":"D0041","selected":false,"text":"1#V型滤池2#出水阀关闭状态"},{"desc":"%","id":"A0026","selected":false,"text":"1#V型滤池2#出水阀开度"},{"desc":"%","id":"A6997","selected":false,"text":"1#V型滤池2#出水阀开度峰值"},{"desc":"%","id":"A5389","selected":false,"text":"1#V型滤池2#出水阀开度平均值"},{"desc":"%","id":"A15410","selected":false,"text":"1#V型滤池2#出水阀开度瞬时值"},{"desc":"%","id":"A10337","selected":false,"text":"1#V型滤池2#出水阀开度谷值"},{"id":"D0042","selected":false,"text":"1#V型滤池2#出水阀运行状态"},{"id":"D7946","selected":false,"text":"1#V型滤池2#出水阀运行状态运行时间"},{"id":"A0028","selected":false,"text":"1#V型滤池2#压差"},{"id":"A6995","selected":false,"text":"1#V型滤池2#压差峰值"},{"id":"A5391","selected":false,"text":"1#V型滤池2#压差平均值"},{"id":"A15412","selected":false,"text":"1#V型滤池2#压差瞬时值"},{"id":"A10335","selected":false,"text":"1#V型滤池2#压差谷值"},{"id":"D0044","selected":false,"text":"1#V型滤池2#排气阀运行状态"},{"id":"D7948","selected":false,"text":"1#V型滤池2#排气阀运行状态运行时间"},{"id":"D0045","selected":false,"text":"1#V型滤池2#气冲阀运行状态"},{"id":"D7949","selected":false,"text":"1#V型滤池2#气冲阀运行状态运行时间"},{"id":"D0046","selected":false,"text":"1#V型滤池2#水冲阀运行状态"},{"id":"D7950","selected":false,"text":"1#V型滤池2#水冲阀运行状态运行时间"},{"desc":"m","id":"A0029","selected":false,"text":"1#V型滤池2#液位"},{"desc":"m","id":"A6996","selected":false,"text":"1#V型滤池2#液位峰值"},{"desc":"m","id":"A5392","selected":false,"text":"1#V型滤池2#液位平均值"},{"desc":"m","id":"A15413","selected":false,"text":"1#V型滤池2#液位瞬时值"},{"desc":"m","id":"A10336","selected":false,"text":"1#V型滤池2#液位谷值"},{"desc":"%","id":"A0027","selected":false,"text":"1#V型滤池2#进水阀开度"},{"desc":"%","id":"A6998","selected":false,"text":"1#V型滤池2#进水阀开度峰值"},{"desc":"%","id":"A5390","selected":false,"text":"1#V型滤池2#进水阀开度平均值"},{"desc":"%","id":"A15411","selected":false,"text":"1#V型滤池2#进水阀开度瞬时值"},{"desc":"%","id":"A10338","selected":false,"text":"1#V型滤池2#进水阀开度谷值"},{"id":"D0043","selected":false,"text":"1#V型滤池2#进水阀运行状态"},{"id":"D7947","selected":false,"text":"1#V型滤池2#进水阀运行状态运行时间"},{"id":"D0047","selected":false,"text":"1#V型滤池3#出水阀关闭状态"},{"desc":"%","id":"A0030","selected":false,"text":"1#V型滤池3#出水阀开度"},{"desc":"%","id":"A6999","selected":false,"text":"1#V型滤池3#出水阀开度峰值"},{"desc":"%","id":"A5393","selected":false,"text":"1#V型滤池3#出水阀开度平均值"},{"desc":"%","id":"A15414","selected":false,"text":"1#V型滤池3#出水阀开度瞬时值"},{"desc":"%","id":"A10339","selected":false,"text":"1#V型滤池3#出水阀开度谷值"},{"id":"D0048","selected":false,"text":"1#V型滤池3#出水阀运行状态"},{"id":"D7951","selected":false,"text":"1#V型滤池3#出水阀运行状态运行时间"},{"id":"A0032","selected":false,"text":"1#V型滤池3#压差"},{"id":"A7003","selected":false,"text":"1#V型滤池3#压差峰值"},{"id":"A5395","selected":false,"text":"1#V型滤池3#压差平均值"},{"id":"A15416","selected":false,"text":"1#V型滤池3#压差瞬时值"},{"id":"A10343","selected":false,"text":"1#V型滤池3#压差谷值"},{"id":"D0050","selected":false,"text":"1#V型滤池3#排气阀运行状态"},{"id":"D7953","selected":false,"text":"1#V型滤池3#排气阀运行状态运行时间"},{"id":"D0051","selected":false,"text":"1#V型滤池3#气冲阀运行状态"},{"id":"D7954","selected":false,"text":"1#V型滤池3#气冲阀运行状态运行时间"},{"id":"D0052","selected":false,"text":"1#V型滤池3#水冲阀运行状态"},{"id":"D7955","selected":false,"text":"1#V型滤池3#水冲阀运行状态运行时间"},{"desc":"m","id":"A0033","selected":false,"text":"1#V型滤池3#液位"},{"desc":"m","id":"A7000","selected":false,"text":"1#V型滤池3#液位峰值"},{"desc":"m","id":"A5396","selected":false,"text":"1#V型滤池3#液位平均值"},{"desc":"m","id":"A15417","selected":false,"text":"1#V型滤池3#液位瞬时值"},{"desc":"m","id":"A10340","selected":false,"text":"1#V型滤池3#液位谷值"},{"desc":"%","id":"A0031","selected":false,"text":"1#V型滤池3#进水阀开度"},{"desc":"%","id":"A7002","selected":false,"text":"1#V型滤池3#进水阀开度峰值"},{"desc":"%","id":"A5394","selected":false,"text":"1#V型滤池3#进水阀开度平均值"},{"desc":"%","id":"A15415","selected":false,"text":"1#V型滤池3#进水阀开度瞬时值"},{"desc":"%","id":"A10342","selected":false,"text":"1#V型滤池3#进水阀开度谷值"},{"id":"D0049","selected":false,"text":"1#V型滤池3#进水阀运行状态"},{"id":"D7952","selected":false,"text":"1#V型滤池3#进水阀运行状态运行时间"},{"id":"D0053","selected":false,"text":"1#V型滤池4#出水阀关闭状态"},{"desc":"%","id":"A0034","selected":false,"text":"1#V型滤池4#出水阀开度"},{"desc":"%","id":"A7001","selected":false,"text":"1#V型滤池4#出水阀开度峰值"},{"desc":"%","id":"A5397","selected":false,"text":"1#V型滤池4#出水阀开度平均值"},{"desc":"%","id":"A15418","selected":false,"text":"1#V型滤池4#出水阀开度瞬时值"},{"desc":"%","id":"A10341","selected":false,"text":"1#V型滤池4#出水阀开度谷值"},{"id":"D0054","selected":false,"text":"1#V型滤池4#出水阀运行状态"},{"id":"D7956","selected":false,"text":"1#V型滤池4#出水阀运行状态运行时间"},{"id":"A0036","selected":false,"text":"1#V型滤池4#压差"},{"id":"A6989","selected":false,"text":"1#V型滤池4#压差峰值"},{"id":"A5399","selected":false,"text":"1#V型滤池4#压差平均值"},{"id":"A15420","selected":false,"text":"1#V型滤池4#压差瞬时值"},{"id":"A10329","selected":false,"text":"1#V型滤池4#压差谷值"},{"id":"D0056","selected":false,"text":"1#V型滤池4#排气阀运行状态"},{"id":"D7958","selected":false,"text":"1#V型滤池4#排气阀运行状态运行时间"},{"id":"D0057","selected":false,"text":"1#V型滤池4#气冲阀运行状态"},{"id":"D7959","selected":false,"text":"1#V型滤池4#气冲阀运行状态运行时间"},{"id":"D0058","selected":false,"text":"1#V型滤池4#水冲阀运行状态"},{"id":"D7960","selected":false,"text":"1#V型滤池4#水冲阀运行状态运行时间"},{"desc":"m","id":"A0037","selected":false,"text":"1#V型滤池4#液位"},{"desc":"m","id":"A6986","selected":false,"text":"1#V型滤池4#液位峰值"},{"desc":"m","id":"A5400","selected":false,"text":"1#V型滤池4#液位平均值"},{"desc":"m","id":"A15421","selected":false,"text":"1#V型滤池4#液位瞬时值"},{"desc":"m","id":"A10326","selected":false,"text":"1#V型滤池4#液位谷值"},{"desc":"%","id":"A0035","selected":false,"text":"1#V型滤池4#进水阀开度"},{"desc":"%","id":"A6988","selected":false,"text":"1#V型滤池4#进水阀开度峰值"},{"desc":"%","id":"A5398","selected":false,"text":"1#V型滤池4#进水阀开度平均值"},{"desc":"%","id":"A15419","selected":false,"text":"1#V型滤池4#进水阀开度瞬时值"},{"desc":"%","id":"A10328","selected":false,"text":"1#V型滤池4#进水阀开度谷值"},{"id":"D0055","selected":false,"text":"1#V型滤池4#进水阀运行状态"},{"id":"D7957","selected":false,"text":"1#V型滤池4#进水阀运行状态运行时间"},{"id":"A0038","selected":false,"text":"1#V型滤池V型滤池反冲洗池号"},{"id":"A6987","selected":false,"text":"1#V型滤池V型滤池反冲洗池号峰值"},{"id":"A5401","selected":false,"text":"1#V型滤池V型滤池反冲洗池号平均值"},{"id":"A15422","selected":false,"text":"1#V型滤池V型滤池反冲洗池号瞬时值"},{"id":"A10327","selected":false,"text":"1#V型滤池V型滤池反冲洗池号谷值"},{"id":"A0039","selected":false,"text":"1#V型滤池出水CL"},{"id":"A6990","selected":false,"text":"1#V型滤池出水CL峰值"},{"id":"A5402","selected":false,"text":"1#V型滤池出水CL平均值"},{"id":"A15423","selected":false,"text":"1#V型滤池出水CL瞬时值"},{"id":"A10330","selected":false,"text":"1#V型滤池出水CL谷值"},{"desc":"NTU","id":"A0040","selected":false,"text":"1#V型滤池出水浊度"},{"desc":"NTU","id":"A6993","selected":false,"text":"1#V型滤池出水浊度峰值"},{"desc":"NTU","id":"A5403","selected":false,"text":"1#V型滤池出水浊度平均值"},{"desc":"NTU","id":"A15424","selected":false,"text":"1#V型滤池出水浊度瞬时值"},{"desc":"NTU","id":"A10333","selected":false,"text":"1#V型滤池出水浊度谷值"},{"id":"D0059","selected":false,"text":"1#V型滤池出水超越阀报警状态"},{"id":"D0060","selected":false,"text":"1#V型滤池出水超越阀运行状态"},{"id":"D7961","selected":false,"text":"1#V型滤池出水超越阀运行状态运行时间"},{"desc":"NTU","id":"A0041","selected":false,"text":"1#V型滤池进水浊度"},{"desc":"NTU","id":"A6994","selected":false,"text":"1#V型滤池进水浊度峰值"},{"desc":"NTU","id":"A5404","selected":false,"text":"1#V型滤池进水浊度平均值"},{"desc":"NTU","id":"A15425","selected":false,"text":"1#V型滤池进水浊度瞬时值"},{"desc":"NTU","id":"A10334","selected":false,"text":"1#V型滤池进水浊度谷值"},{"id":"D0061","selected":false,"text":"1#V型滤池进水超越阀报警状态"},{"id":"D0062","selected":false,"text":"1#V型滤池进水超越阀运行状态"},{"id":"D7962","selected":false,"text":"1#V型滤池进水超越阀运行状态运行时间"},{"id":"D0063","selected":false,"text":"1#V型滤池进水闸门报警状态"},{"id":"D0064","selected":false,"text":"1#V型滤池进水闸门运行状态"},{"id":"D7963","selected":false,"text":"1#V型滤池进水闸门运行状态运行时间"}]}
     * errorCode : 00000
     * errorMsg : success
     */

    private String errorCode;
    private String errorMsg;

    public void setData(DataEntity data) {
        this.data = data;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public DataEntity getData() {
        return data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public static class DataEntity {
        /**
         * id :
         * selected : true
         * text : 请选择
         */

        private List<ComboboxListEntity> comboboxList;

        public void setComboboxList(List<ComboboxListEntity> comboboxList) {
            this.comboboxList = comboboxList;
        }

        public List<ComboboxListEntity> getComboboxList() {
            return comboboxList;
        }

        public static class ComboboxListEntity {
            private String id;
            private boolean selected;
            private String text;

            public void setId(String id) {
                this.id = id;
            }

            public void setSelected(boolean selected) {
                this.selected = selected;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getId() {
                return id;
            }

            public boolean isSelected() {
                return selected;
            }

            public String getText() {
                return text;
            }
        }
    }
}
