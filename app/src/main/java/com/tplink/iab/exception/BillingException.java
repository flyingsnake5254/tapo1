package com.tplink.iab.exception;

/* loaded from: classes2.dex */
public class BillingException extends Exception {
    private static final long serialVersionUID = 3335837619990195688L;
    public int errorCode;
    public String msg;

    public BillingException(String str) {
        this.msg = str;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public BillingException(String str, int i) {
        this.msg = str;
        this.errorCode = i;
    }
}
