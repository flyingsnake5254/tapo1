package com.tplink.cloud.bean.common;

/* loaded from: classes2.dex */
public class CloudParams<T> {
    private String method;
    private T params;

    public CloudParams() {
    }

    public String getMethod() {
        return this.method;
    }

    public T getParams() {
        return this.params;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setParams(T t) {
        this.params = t;
    }

    public CloudParams(String str, T t) {
        this.method = str;
        this.params = t;
    }
}
