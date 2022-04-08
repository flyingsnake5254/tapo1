package com.google.android.gms.internal.mlkit_vision_barcode;

/* compiled from: com.google.mlkit:barcode-scanning@@16.0.1 */
/* loaded from: classes.dex */
public enum zzjv implements zzgf {
    GPU_BACKEND_UNSET(0),
    GPU_BACKEND_OPENCL(1),
    GPU_BACKEND_OPENGL(2);
    
    private static final zzge<zzjv> zzd = new zzge<zzjv>() { // from class: com.google.android.gms.internal.mlkit_vision_barcode.zzjx
    };
    private final int zze;

    zzjv(int i) {
        this.zze = i;
    }

    public static zzgh zzb() {
        return zzjw.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + zzjv.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzgf
    public final int zza() {
        return this.zze;
    }
}
