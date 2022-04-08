package com.tplink.libtpnetwork.exception;

/* loaded from: classes3.dex */
public class IoTException extends Exception {
    private int errCode;
    private String msg;

    public IoTException(int i, String str) {
        this.errCode = i;
        this.msg = str;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setErrCode(int i) {
        this.errCode = i;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
