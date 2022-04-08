package com.tplink.libtpstreampreconnect.bean;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface ConnectionStatus {
    public static final int CONNECTION_STATUS_FAILURE = 2;
    public static final int CONNECTION_STATUS_START = 0;
    public static final int CONNECTION_STATUS_SUCCESS = 1;
}
