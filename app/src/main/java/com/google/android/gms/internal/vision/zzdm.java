package com.google.android.gms.internal.vision;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
public final class zzdm extends zzdk<E> {
    private final transient int length;
    private final transient int offset;
    private final /* synthetic */ zzdk zzmf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdm(zzdk zzdkVar, int i, int i2) {
        this.zzmf = zzdkVar;
        this.offset = i;
        this.length = i2;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzcy.zzd(i, this.length);
        return this.zzmf.get(i + this.offset);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.length;
    }

    @Override // com.google.android.gms.internal.vision.zzdk, java.util.List
    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzdh
    public final Object[] zzca() {
        return this.zzmf.zzca();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzdh
    public final int zzcb() {
        return this.zzmf.zzcb() + this.offset;
    }

    @Override // com.google.android.gms.internal.vision.zzdh
    final int zzcc() {
        return this.zzmf.zzcb() + this.offset + this.length;
    }

    @Override // com.google.android.gms.internal.vision.zzdk
    public final zzdk<E> zzf(int i, int i2) {
        zzcy.zza(i, i2, this.length);
        zzdk zzdkVar = this.zzmf;
        int i3 = this.offset;
        return (zzdk) zzdkVar.subList(i + i3, i2 + i3);
    }
}
