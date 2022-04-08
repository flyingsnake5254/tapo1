package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
final class zzez extends zzfb {
    private int zza = 0;
    private final int zzb;
    private final /* synthetic */ zzew zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzez(zzew zzewVar) {
        this.zzc = zzewVar;
        this.zzb = zzewVar.zza();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza < this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzff
    public final byte zza() {
        int i = this.zza;
        if (i < this.zzb) {
            this.zza = i + 1;
            return this.zzc.zzb(i);
        }
        throw new NoSuchElementException();
    }
}
