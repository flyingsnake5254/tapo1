package com.tplink.libtpinappmessaging.model;

/* loaded from: classes3.dex */
public class IAMException extends Exception {
    private int errorCode;

    public IAMException(int i, String str) {
        super(str);
        this.errorCode = i;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }
}
