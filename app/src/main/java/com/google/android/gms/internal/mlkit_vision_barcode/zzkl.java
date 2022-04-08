package com.google.android.gms.internal.mlkit_vision_barcode;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
public enum zzkl implements zzgf {
    UNKNOWN_EVENT_TYPE(0),
    VALIDATION_TEST(1),
    CONTINUOUS_FEEDBACK(2);
    
    private static final zzge<zzkl> zzd = new zzge<zzkl>() { // from class: com.google.android.gms.internal.mlkit_vision_barcode.zzko
    };
    private final int zze;

    zzkl(int i) {
        this.zze = i;
    }

    public static zzgh zzb() {
        return zzkn.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + zzkl.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzgf
    public final int zza() {
        return this.zze;
    }
}
