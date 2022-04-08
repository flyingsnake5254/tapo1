package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
public interface zzbb<K, V> {
    boolean zza(@NullableDecl K k, @NullableDecl V v);

    Collection<V> zzb(@NullableDecl K k);

    Map<K, Collection<V>> zzg();

    Set<K> zzh();
}
