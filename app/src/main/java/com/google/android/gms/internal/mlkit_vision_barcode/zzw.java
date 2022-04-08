package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
public final class zzw<K, V> extends zzz<K, V> {
    private transient int zza;

    private zzw() {
        this(12, 3);
    }

    public static <K, V> zzw<K, V> zzf() {
        return new zzw<>();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzx
    public final /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzx
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzx
    public final /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzi
    public final List<V> zza() {
        return new ArrayList(this.zza);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzi, com.google.android.gms.internal.mlkit_vision_barcode.zzl
    public final /* synthetic */ Collection zzb() {
        return zzb();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzl
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzx, com.google.android.gms.internal.mlkit_vision_barcode.zzbb
    public final /* bridge */ /* synthetic */ Map zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzx, com.google.android.gms.internal.mlkit_vision_barcode.zzbb
    public final /* bridge */ /* synthetic */ Set zzh() {
        return super.zzh();
    }

    private zzw(int i, int i2) {
        super(new zzaa(12));
        zzy.zza(3, "expectedValuesPerKey");
        this.zza = 3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzl, com.google.android.gms.internal.mlkit_vision_barcode.zzx, com.google.android.gms.internal.mlkit_vision_barcode.zzbb
    public final /* bridge */ /* synthetic */ boolean zza(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.zza((zzw<K, V>) obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzi, com.google.android.gms.internal.mlkit_vision_barcode.zzat
    public final /* bridge */ /* synthetic */ List zza(@NullableDecl Object obj) {
        return super.zza((zzw<K, V>) obj);
    }
}
