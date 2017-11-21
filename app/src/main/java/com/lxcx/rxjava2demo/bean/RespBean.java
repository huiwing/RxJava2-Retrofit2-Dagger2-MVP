package com.lxcx.rxjava2demo.bean;

/**
 * RespBean
 * Created by ArmyAntAndroid on 2017/11/20.
 */

public class RespBean {
    private String resultcode;
    private String reason;
    private PhoneBean result;
    private int error_code;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public PhoneBean getResult() {
        return result;
    }

    public void setResult(PhoneBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    @Override
    public String toString() {
        return "RespBean{" +
                "resultcode='" + resultcode + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                ", error_code=" + error_code +
                '}';
    }
}
