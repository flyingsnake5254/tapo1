package com.google.android.gms.internal.mlkit_vision_common;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes.dex */
public abstract class zzdv {
    private int zza;
    private int zzb;
    private boolean zzc;

    private zzdv() {
        this.zza = 100;
        this.zzb = Integer.MAX_VALUE;
        this.zzc = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdv zza(byte[] bArr, int i, int i2, boolean z) {
        zzdx zzdxVar = new zzdx(bArr, 0, i2, false);
        try {
            zzdxVar.zza(i2);
            return zzdxVar;
        } catch (zzev e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public abstract int zza();

    public abstract int zza(int i) throws zzev;
}
