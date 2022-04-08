package com.google.android.gms.internal.vision;

import com.github.mikephil.charting.utils.Utils;

/* JADX WARN: Init of enum zzxy can be incorrect */
/* JADX WARN: Init of enum zzyf can be incorrect */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
public enum zzhj {
    VOID(Void.class, Void.class, null),
    INT(r1, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf((double) Utils.DOUBLE_EPSILON)),
    BOOLEAN(Boolean.TYPE, Boolean.class, Boolean.FALSE),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzfm.class, zzfm.class, zzfm.zzsm),
    ENUM(r1, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);
    
    private final Class<?> zzyh;
    private final Class<?> zzyi;
    private final Object zzyj;

    static {
        Class cls = Integer.TYPE;
    }

    zzhj(Class cls, Class cls2, Object obj) {
        this.zzyh = cls;
        this.zzyi = cls2;
        this.zzyj = obj;
    }

    public final Class<?> zzgw() {
        return this.zzyi;
    }
}
