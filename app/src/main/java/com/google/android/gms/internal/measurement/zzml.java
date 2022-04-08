package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@19.0.0 */
/* loaded from: classes.dex */
final class zzml implements Iterator<String> {
    final Iterator<String> zza;
    final /* synthetic */ zzmm zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzml(zzmm zzmmVar) {
        zzks zzksVar;
        this.zzb = zzmmVar;
        zzksVar = zzmmVar.zza;
        this.zza = zzksVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ String next() {
        return this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
