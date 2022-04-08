package com.google.android.gms.internal.mlkit_vision_common;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes.dex */
public final class zzdr {
    private final zzdw zza;
    private final byte[] zzb;

    private zzdr(int i) {
        byte[] bArr = new byte[i];
        this.zzb = bArr;
        this.zza = zzdw.zza(bArr);
    }

    public final zzdj zza() {
        this.zza.zzb();
        return new zzdt(this.zzb);
    }

    public final zzdw zzb() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzdr(int i, zzdi zzdiVar) {
        this(i);
    }
}
