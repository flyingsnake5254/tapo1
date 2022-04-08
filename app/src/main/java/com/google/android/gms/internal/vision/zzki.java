package com.google.android.gms.internal.vision;

import com.github.mikephil.charting.utils.Utils;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
public enum zzki {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf((double) Utils.DOUBLE_EPSILON)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(zzfm.zzsm),
    ENUM(null),
    MESSAGE(null);
    
    private final Object zzyj;

    zzki(Object obj) {
        this.zzyj = obj;
    }
}
