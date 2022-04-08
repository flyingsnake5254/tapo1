package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
abstract class zzi<K, V> extends zzl<K, V> implements zzat<K, V> {
    /* JADX INFO: Access modifiers changed from: protected */
    public zzi(Map<K, Collection<V>> map) {
        super(map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzl
    public final Collection<V> zza(K k, Collection<V> collection) {
        return zza(k, (List) collection, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: zza */
    public abstract List<V> zzb();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzl, com.google.android.gms.internal.mlkit_vision_barcode.zzbb
    public /* synthetic */ Collection zzb(@NullableDecl Object obj) {
        return zza((zzi<K, V>) obj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzat
    public List<V> zza(@NullableDecl K k) {
        return (List) super.zzb((zzi<K, V>) k);
    }
}
