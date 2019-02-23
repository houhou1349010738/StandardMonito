package com.smartwasser.yunzhishui.bean;

/**
 * Created by xiongmc on 2015/12/23.
 */
public class ErrorResponse extends RBResponse {

    /**
     * text : 用户名不存在
     */

    private ErrorEntity error;

    public void setError(ErrorEntity error) {
        this.error = error;
    }

    public ErrorEntity getError() {
        return error;
    }

    public static class ErrorEntity {
        private String text;

        public void setText(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }
}
