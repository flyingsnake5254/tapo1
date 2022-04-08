package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
final class zziw implements Iterator<String> {
    private Iterator<String> zza;
    private final /* synthetic */ zziu zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zziw(zziu zziuVar) {
        zzgv zzgvVar;
        this.zzb = zziuVar;
        zzgvVar = zziuVar.zza;
        this.zza = zzgvVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
