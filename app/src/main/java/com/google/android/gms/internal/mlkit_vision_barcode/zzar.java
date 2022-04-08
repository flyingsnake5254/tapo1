package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
public final class zzar extends zzap<E> {
    private final transient int zza;
    private final transient int zzb;
    private final /* synthetic */ zzap zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzar(zzap zzapVar, int i, int i2) {
        this.zzc = zzapVar;
        this.zza = i;
        this.zzb = i2;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzh.zza(i, this.zzb);
        return this.zzc.get(i + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzap, java.util.List
    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzap
    public final zzap<E> zza(int i, int i2) {
        zzh.zza(i, i2, this.zzb);
        zzap zzapVar = this.zzc;
        int i3 = this.zza;
        return (zzap) zzapVar.subList(i + i3, i2 + i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzan
    public final Object[] zzb() {
        return this.zzc.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzan
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzan
    final int zzd() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }
}
