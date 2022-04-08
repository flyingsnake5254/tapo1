package com.google.android.gms.internal.mlkit_common;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes.dex */
public final class zzed {
    private final zzem zza;
    private final byte[] zzb;

    private zzed(int i) {
        byte[] bArr = new byte[i];
        this.zzb = bArr;
        this.zza = zzem.zza(bArr);
    }

    public final zzdv zza() {
        this.zza.zzb();
        return new zzef(this.zzb);
    }

    public final zzem zzb() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzed(int i, zzdy zzdyVar) {
        this(i);
    }
}
