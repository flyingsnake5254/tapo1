package com.google.android.gms.internal.mlkit_vision_barcode;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
public final class zzfe {
    private final zzfn zza;
    private final byte[] zzb;

    private zzfe(int i) {
        byte[] bArr = new byte[i];
        this.zzb = bArr;
        this.zza = zzfn.zza(bArr);
    }

    public final zzew zza() {
        this.zza.zzb();
        return new zzfg(this.zzb);
    }

    public final zzfn zzb() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfe(int i, zzez zzezVar) {
        this(i);
    }
}
