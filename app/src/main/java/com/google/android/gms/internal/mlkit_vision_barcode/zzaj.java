package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
final class zzaj extends zzu<K, V> {
    @NullableDecl
    private final K zza;
    private int zzb;
    private final /* synthetic */ zzaa zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public zzaj(zzaa zzaaVar, int i) {
        this.zzc = zzaaVar;
        this.zza = zzaaVar.zzb[i];
        this.zzb = i;
    }

    private final void zza() {
        int zza;
        int i = this.zzb;
        if (i == -1 || i >= this.zzc.size() || !zze.zza(this.zza, this.zzc.zzb[this.zzb])) {
            zza = this.zzc.zza(this.zza);
            this.zzb = zza;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzu, java.util.Map.Entry
    @NullableDecl
    public final K getKey() {
        return this.zza;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [V, java.lang.Object] */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzu, java.util.Map.Entry
    @NullableDecl
    public final V getValue() {
        Map zzb = this.zzc.zzb();
        if (zzb != null) {
            return zzb.get(this.zza);
        }
        zza();
        int i = this.zzb;
        if (i == -1) {
            return null;
        }
        return this.zzc.zzc[i];
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [V, java.lang.Object] */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzu, java.util.Map.Entry
    public final V setValue(V v) {
        Map zzb = this.zzc.zzb();
        if (zzb != null) {
            return zzb.put(this.zza, v);
        }
        zza();
        int i = this.zzb;
        if (i == -1) {
            this.zzc.put(this.zza, v);
            return null;
        }
        Object[] objArr = this.zzc.zzc;
        V v2 = objArr[i];
        objArr[i] = v;
        return v2;
    }
}
