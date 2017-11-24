package com.lxcx.rxjava2demo.rx;

/**
 * RxMsgBean
 * Created by ArmyAntAndroid on 2017/11/24.
 */

public class RxMsgBean<T> {
    private T data;
    private String msg;
    private int code;

    public RxMsgBean() {
    }

    /**
     * @param msg
     * @param code
     */
    public RxMsgBean(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    /**
     * @param data
     * @param msg
     * @param code
     */
    public RxMsgBean(T data, String msg, int code) {
        this.data = data;
        this.msg = msg;
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "RxMsgBean{" +
                "data=" + data +
                ", msg='" + msg + '\'' +
                ", code=" + code +
                '}';
    }
}
