package com.tplink.libtpstreamconnectionsocket;

/* loaded from: classes3.dex */
public class UserEncryptException extends Exception {
    public static final String EMPTY_EXCEPTION = "psw is error";

    public UserEncryptException(String str) {
        super(str);
    }

    public UserEncryptException(String str, Throwable th) {
        super(str, th);
    }

    public UserEncryptException(Throwable th) {
        super(th);
    }
}
