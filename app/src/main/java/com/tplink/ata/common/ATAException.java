package com.tplink.ata.common;

/* loaded from: classes2.dex */
public class ATAException extends Exception {
    private int errorCode;

    public ATAException(int i) {
        this.errorCode = i;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }
}
