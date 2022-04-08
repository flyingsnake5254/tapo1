package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@19.0.0 */
/* loaded from: classes.dex */
final class zzjf extends zzjg {
    private final byte[] zza;
    private int zzc;
    private int zzd = Integer.MAX_VALUE;
    private int zzb = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzjf(byte[] bArr, int i, int i2, boolean z, zzje zzjeVar) {
        super(null);
        this.zza = bArr;
    }

    public final int zza(int i) throws zzkn {
        int i2 = this.zzd;
        this.zzd = 0;
        int i3 = this.zzb + this.zzc;
        this.zzb = i3;
        if (i3 > 0) {
            this.zzc = i3;
            this.zzb = 0;
        } else {
            this.zzc = 0;
        }
        return i2;
    }
}
