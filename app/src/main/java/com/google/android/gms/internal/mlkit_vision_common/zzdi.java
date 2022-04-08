package com.google.android.gms.internal.mlkit_vision_common;

import java.util.NoSuchElementException;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes.dex */
final class zzdi extends zzdk {
    private int zza = 0;
    private final int zzb;
    private final /* synthetic */ zzdj zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdi(zzdj zzdjVar) {
        this.zzc = zzdjVar;
        this.zzb = zzdjVar.zza();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza < this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzdo
    public final byte zza() {
        int i = this.zza;
        if (i < this.zzb) {
            this.zza = i + 1;
            return this.zzc.zzb(i);
        }
        throw new NoSuchElementException();
    }
}
