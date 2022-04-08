package com.google.android.gms.internal.mlkit_vision_barcode;

/* compiled from: com.google.mlkit:barcode-scanning@@16.0.1 */
/* loaded from: classes.dex */
public enum zzkb implements zzgf {
    NNAPI_EXECUTION_PREFERENCE_UNDEFINED(0),
    NNAPI_EXECUTION_PREFERENCE_LOW_POWER(1),
    NNAPI_EXECUTION_PREFERENCE_FAST_SINGLE_ANSWER(2),
    NNAPI_EXECUTION_PREFERENCE_SUSTAINED_SPEED(3);
    
    private static final zzge<zzkb> zze = new zzge<zzkb>() { // from class: com.google.android.gms.internal.mlkit_vision_barcode.zzkd
    };
    private final int zzf;

    zzkb(int i) {
        this.zzf = i;
    }

    public static zzgh zzb() {
        return zzkc.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + zzkb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + '>';
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzgf
    public final int zza() {
        return this.zzf;
    }
}
