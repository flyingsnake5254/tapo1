package com.google.android.gms.internal.clearcut;

import com.github.mikephil.charting.utils.Utils;

/* loaded from: classes.dex */
public enum zzfq {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf((double) Utils.DOUBLE_EPSILON)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(zzbb.zzfi),
    ENUM(null),
    MESSAGE(null);
    
    private final Object zzlj;

    zzfq(Object obj) {
        this.zzlj = obj;
    }
}
