package com.tplink.libtpstreamconnectionsocket;

/* loaded from: classes3.dex */
public class EncryptException extends Exception {
    public static final String EMPTY_EXCEPTION = "psw is error";

    public EncryptException(String str) {
        super(str);
    }

    public EncryptException(String str, Throwable th) {
        super(str, th);
    }

    public EncryptException(Throwable th) {
        super(th);
    }
}
