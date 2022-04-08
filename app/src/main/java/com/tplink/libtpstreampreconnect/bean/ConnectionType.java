package com.tplink.libtpstreampreconnect.bean;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface ConnectionType {
    public static final int CONNECTION_INVALID = -1;
    public static final int CONNECTION_LOCAL = 256;
    public static final int CONNECTION_P2P = 16;
    public static final int CONNECTION_RELAY = 0;
    public static final int CONNECTION_UPNP = 17;
}
