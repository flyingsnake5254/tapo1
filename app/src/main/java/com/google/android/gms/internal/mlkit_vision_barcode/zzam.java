package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
final class zzam<K, V> extends zzu<K, V> implements Serializable {
    @NullableDecl
    private final K zza;
    @NullableDecl
    private final V zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzam(@NullableDecl K k, @NullableDecl V v) {
        this.zza = k;
        this.zzb = v;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzu, java.util.Map.Entry
    @NullableDecl
    public final K getKey() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzu, java.util.Map.Entry
    @NullableDecl
    public final V getValue() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzu, java.util.Map.Entry
    public final V setValue(V v) {
        throw new UnsupportedOperationException();
    }
}
