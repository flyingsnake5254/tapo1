package com.tplink.libtpgoogleassistant.bean.result;

import com.google.gson.q.c;

/* loaded from: classes3.dex */
public class AuthResult<T> {
    @c("error_code")
    private int errorCode;
    private String msg;
    private T result;

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getMsg() {
        return this.msg;
    }

    public T getResult() {
        return this.result;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setResult(T t) {
        this.result = t;
    }
}
