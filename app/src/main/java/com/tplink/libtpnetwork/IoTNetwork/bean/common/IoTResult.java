package com.tplink.libtpnetwork.IoTNetwork.bean.common;

import com.google.gson.q.c;

/* loaded from: classes3.dex */
public class IoTResult<T> {
    @c("error_code")
    private int errCode;
    private String msg;
    private T result;

    public IoTResult() {
    }

    public int getErrCode() {
        return this.errCode;
    }

    public String getMsg() {
        return this.msg;
    }

    public T getResult() {
        return this.result;
    }

    public void setErrCode(int i) {
        this.errCode = i;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setResult(T t) {
        this.result = t;
    }

    public IoTResult(int i) {
        this.errCode = i;
    }

    public IoTResult(int i, T t) {
        this.errCode = i;
        this.result = t;
    }
}
