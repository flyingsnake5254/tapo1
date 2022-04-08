package com.tplink.tdp.common;

import com.google.gson.q.c;

/* loaded from: classes3.dex */
public class TDPResult<T> {
    @c("error_code")
    private int errorCode;
    private T result;

    public TDPResult() {
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public T getResult() {
        return this.result;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setResult(T t) {
        this.result = t;
    }

    public TDPResult(T t) {
        this.result = t;
    }
}
