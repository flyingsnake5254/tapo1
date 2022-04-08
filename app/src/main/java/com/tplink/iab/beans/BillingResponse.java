package com.tplink.iab.beans;

/* loaded from: classes2.dex */
public class BillingResponse {
    private int responseCode;
    private Object result;
    private int sn;

    public BillingResponse(int i) {
        this.sn = i;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public Object getResult() {
        return this.result;
    }

    public int getSn() {
        return this.sn;
    }

    public void setResponseCode(int i) {
        this.responseCode = i;
    }

    public void setResult(Object obj) {
        this.result = obj;
    }

    public void setSn(int i) {
        this.sn = i;
    }

    public BillingResponse(int i, int i2) {
        this.sn = i;
        this.responseCode = i2;
    }

    public BillingResponse(int i, Object obj) {
        this.responseCode = 0;
        this.sn = i;
        this.result = obj;
    }

    public BillingResponse(int i, int i2, Object obj) {
        this.sn = i;
        this.responseCode = i2;
        this.result = obj;
    }
}
