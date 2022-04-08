package com.google.android.gms.internal.mlkit_vision_barcode;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
public abstract class zzfi {
    private int zza;
    private int zzb;
    private boolean zzc;

    private zzfi() {
        this.zza = 100;
        this.zzb = Integer.MAX_VALUE;
        this.zzc = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfi zza(byte[] bArr, int i, int i2, boolean z) {
        zzfk zzfkVar = new zzfk(bArr, 0, i2, false);
        try {
            zzfkVar.zza(i2);
            return zzfkVar;
        } catch (zzgk e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public abstract int zza();

    public abstract int zza(int i) throws zzgk;
}
