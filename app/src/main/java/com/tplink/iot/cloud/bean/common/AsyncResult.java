package com.tplink.iot.cloud.bean.common;

import com.google.gson.i;

/* loaded from: classes2.dex */
public class AsyncResult {
    private int code;
    private i data;
    private String message;
    private String requestId;

    public int getCode() {
        return this.code;
    }

    public i getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(i iVar) {
        this.data = iVar;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }
}
