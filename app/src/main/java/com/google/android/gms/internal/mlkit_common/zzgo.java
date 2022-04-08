package com.google.android.gms.internal.mlkit_common;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes.dex */
final class zzgo<T> implements zzgy<T> {
    private final zzgh zza;
    private final zzhq<?, ?> zzb;
    private final boolean zzc;
    private final zzeq<?> zzd;

    private zzgo(zzhq<?, ?> zzhqVar, zzeq<?> zzeqVar, zzgh zzghVar) {
        this.zzb = zzhqVar;
        this.zzc = zzeqVar.zza(zzghVar);
        this.zzd = zzeqVar;
        this.zza = zzghVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> zzgo<T> zza(zzhq<?, ?> zzhqVar, zzeq<?> zzeqVar, zzgh zzghVar) {
        return new zzgo<>(zzhqVar, zzeqVar, zzghVar);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgy
    public final void zzb(T t, T t2) {
        zzha.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzha.zza(this.zzd, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgy
    public final void zzc(T t) {
        this.zzb.zzb(t);
        this.zzd.zzc(t);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgy
    public final boolean zzd(T t) {
        return this.zzd.zza(t).zzf();
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgy
    public final boolean zza(T t, T t2) {
        if (!this.zzb.zza(t).equals(this.zzb.zza(t2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza(t).equals(this.zzd.zza(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgy
    public final int zzb(T t) {
        zzhq<?, ?> zzhqVar = this.zzb;
        int zzc = zzhqVar.zzc(zzhqVar.zza(t)) + 0;
        return this.zzc ? zzc + this.zzd.zza(t).zzg() : zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgy
    public final int zza(T t) {
        int hashCode = this.zzb.zza(t).hashCode();
        return this.zzc ? (hashCode * 53) + this.zzd.zza(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgy
    public final void zza(T t, zzik zzikVar) throws IOException {
        Iterator<Map.Entry<?, Object>> zzd = this.zzd.zza(t).zzd();
        while (zzd.hasNext()) {
            Map.Entry<?, Object> next = zzd.next();
            zzet zzetVar = (zzet) next.getKey();
            if (zzetVar.zzc() != zzih.MESSAGE || zzetVar.zzd() || zzetVar.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzfo) {
                zzikVar.zza(zzetVar.zza(), (Object) ((zzfo) next).zza().zzc());
            } else {
                zzikVar.zza(zzetVar.zza(), next.getValue());
            }
        }
        zzhq<?, ?> zzhqVar = this.zzb;
        zzhqVar.zzb((zzhq<?, ?>) zzhqVar.zza(t), zzikVar);
    }
}
