package com.google.android.gms.internal.mlkit_vision_barcode;

/* compiled from: com.google.mlkit:barcode-scanning@@16.0.1 */
/* loaded from: classes.dex */
public enum zzjt implements zzgf {
    ANY_EXECUTION_PREFERENCE(0),
    LOW_LATENCY(1),
    LOW_POWER(2),
    FORCE_CPU(3);
    
    private final int zzg;
    private static final zzjt zze = ANY_EXECUTION_PREFERENCE;
    private static final zzge<zzjt> zzf = new zzge<zzjt>() { // from class: com.google.android.gms.internal.mlkit_vision_barcode.zzjs
    };

    zzjt(int i) {
        this.zzg = i;
    }

    public static zzgh zzb() {
        return zzju.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + zzjt.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + '>';
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzgf
    public final int zza() {
        return this.zzg;
    }
}
