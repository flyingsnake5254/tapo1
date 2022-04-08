package com.google.android.gms.internal.mlkit_vision_barcode;

/* compiled from: com.google.mlkit:barcode-scanning@@16.0.1 */
/* loaded from: classes.dex */
public enum zzjp implements zzgf {
    DELEGATE_NONE(0),
    NNAPI(1),
    GPU(2),
    HEXAGON(3),
    EDGETPU(4);
    
    private static final zzge<zzjp> zzf = new zzge<zzjp>() { // from class: com.google.android.gms.internal.mlkit_vision_barcode.zzjr
    };
    private final int zzg;

    zzjp(int i) {
        this.zzg = i;
    }

    public static zzgh zzb() {
        return zzjq.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + zzjp.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + '>';
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzgf
    public final int zza() {
        return this.zzg;
    }
}
