package com.ejjx.library.bean;

import org.json.JSONObject;

/**
 * author :Created by wangchao {wangchao@ejiajx.com}
 * date : 2017/5/16.
 */

public class ErrorBean {

    private boolean status;
    //局部错误码
    private int code;
    //全局错误码
    private int errorcode;
    //错误提示语
    private String msg;

    public ErrorBean(JSONObject error) {
        setStatus(error.optBoolean("status", false));
        setMsg(error.optString("message"));
        setErrorcode(error.optInt("code"));
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(int errorcode) {
        this.errorcode = errorcode;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
