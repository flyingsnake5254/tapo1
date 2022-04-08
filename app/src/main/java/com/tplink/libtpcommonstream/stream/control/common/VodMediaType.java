package com.tplink.libtpcommonstream.stream.control.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface VodMediaType {
    public static final int NORMAL_IMAGE = 2;
    public static final int PUSH_IMAGE = 1;
    public static final int THUMBNAIL = 3;
    public static final int VIDEO = 0;
}
