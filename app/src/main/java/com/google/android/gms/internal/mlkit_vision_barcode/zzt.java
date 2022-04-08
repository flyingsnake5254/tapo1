package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
class zzt implements Iterator<V> {
    final Iterator<V> zza;
    private final Collection<V> zzb;
    private final /* synthetic */ zzq zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzt(zzq zzqVar) {
        Iterator<V> zzb;
        this.zzc = zzqVar;
        Collection<V> collection = zzqVar.zzb;
        this.zzb = collection;
        zzb = zzl.zzb((Collection) collection);
        this.zza = zzb;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        zza();
        return this.zza.hasNext();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [V, java.lang.Object] */
    @Override // java.util.Iterator
    public V next() {
        zza();
        return this.zza.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.zza.remove();
        zzl.zzb(this.zzc.zzd);
        this.zzc.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza() {
        this.zzc.zza();
        if (this.zzc.zzb != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzt(zzq zzqVar, Iterator<V> it) {
        this.zzc = zzqVar;
        this.zzb = zzqVar.zzb;
        this.zza = it;
    }
}
