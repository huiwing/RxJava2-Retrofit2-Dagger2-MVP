package com.lxcx.rxjava2demo.http.utils;

/**
 * ApiException
 * Created by ArmyAntAndroid on 2017/11/27.
 */

public class ApiException extends Exception {
    /*错误码*/
    private int code;
    /*显示的信息*/
    private String message;

    public ApiException(Throwable e) {
        super(e);
    }

    public ApiException(Throwable e, int code) {
        super(e);
        this.code = code;
    }

    public ApiException(Throwable cause, int code, String showMsg) {
        super(showMsg, cause);
        setCode(code);
        setMessage(showMsg);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
