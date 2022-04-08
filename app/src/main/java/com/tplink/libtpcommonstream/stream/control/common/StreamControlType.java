package com.tplink.libtpcommonstream.stream.control.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface StreamControlType {
    public static final String NOTIFICATION = "notification";
    public static final String REQUEST = "request";
    public static final String RESPONSE = "response";
}
