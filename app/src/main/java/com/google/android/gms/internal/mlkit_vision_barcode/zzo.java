package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
final class zzo implements Iterator<K> {
    @NullableDecl
    private Map.Entry<K, Collection<V>> zza;
    private final /* synthetic */ Iterator zzb;
    private final /* synthetic */ zzp zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(zzp zzpVar, Iterator it) {
        this.zzc = zzpVar;
        this.zzb = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb.hasNext();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, K] */
    @Override // java.util.Iterator
    public final K next() {
        Map.Entry<K, Collection<V>> entry = (Map.Entry) this.zzb.next();
        this.zza = entry;
        return entry.getKey();
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzh.zza(this.zza != null, "no calls to next() since the last call to remove()");
        Collection collection = (Collection) this.zza.getValue();
        this.zzb.remove();
        zzl.zzb(this.zzc.zza, collection.size());
        collection.clear();
        this.zza = null;
    }
}
