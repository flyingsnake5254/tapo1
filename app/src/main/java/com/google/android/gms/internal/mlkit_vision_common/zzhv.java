package com.google.android.gms.internal.mlkit_vision_common;

import com.github.mikephil.charting.utils.Utils;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes.dex */
public enum zzhv {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf((double) Utils.DOUBLE_EPSILON)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(zzdj.zza),
    ENUM(null),
    MESSAGE(null);
    
    private final Object zzj;

    zzhv(Object obj) {
        this.zzj = obj;
    }
}
