package com.google.android.gms.internal.mlkit_common;

import com.github.mikephil.charting.utils.Utils;

/* JADX WARN: Init of enum zzb can be incorrect */
/* JADX WARN: Init of enum zzi can be incorrect */
/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes.dex */
public enum zzfj {
    VOID(Void.class, Void.class, null),
    INT(r1, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf((double) Utils.DOUBLE_EPSILON)),
    BOOLEAN(Boolean.TYPE, Boolean.class, Boolean.FALSE),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzdv.class, zzdv.class, zzdv.zza),
    ENUM(r1, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);
    
    private final Class<?> zzk;
    private final Class<?> zzl;
    private final Object zzm;

    static {
        Class cls = Integer.TYPE;
    }

    zzfj(Class cls, Class cls2, Object obj) {
        this.zzk = cls;
        this.zzl = cls2;
        this.zzm = obj;
    }

    public final Class<?> zza() {
        return this.zzl;
    }
}
