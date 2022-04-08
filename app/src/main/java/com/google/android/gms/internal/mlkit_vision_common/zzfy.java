package com.google.android.gms.internal.mlkit_vision_common;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes.dex */
final class zzfy<T> implements zzgi<T> {
    private final zzfv zza;
    private final zzha<?, ?> zzb;
    private final boolean zzc;
    private final zzea<?> zzd;

    private zzfy(zzha<?, ?> zzhaVar, zzea<?> zzeaVar, zzfv zzfvVar) {
        this.zzb = zzhaVar;
        this.zzc = zzeaVar.zza(zzfvVar);
        this.zzd = zzeaVar;
        this.zza = zzfvVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> zzfy<T> zza(zzha<?, ?> zzhaVar, zzea<?> zzeaVar, zzfv zzfvVar) {
        return new zzfy<>(zzhaVar, zzeaVar, zzfvVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzgi
    public final void zzb(T t, T t2) {
        zzgk.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzgk.zza(this.zzd, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzgi
    public final boolean zzc(T t) {
        return this.zzd.zza(t).zzf();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzgi
    public final int zzd(T t) {
        zzha<?, ?> zzhaVar = this.zzb;
        int zzc = zzhaVar.zzc(zzhaVar.zza(t)) + 0;
        return this.zzc ? zzc + this.zzd.zza(t).zzg() : zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzgi
    public final boolean zza(T t, T t2) {
        if (!this.zzb.zza(t).equals(this.zzb.zza(t2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza(t).equals(this.zzd.zza(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzgi
    public final void zzb(T t) {
        this.zzb.zzb(t);
        this.zzd.zzc(t);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzgi
    public final int zza(T t) {
        int hashCode = this.zzb.zza(t).hashCode();
        return this.zzc ? (hashCode * 53) + this.zzd.zza(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzgi
    public final void zza(T t, zzhu zzhuVar) throws IOException {
        Iterator<Map.Entry<?, Object>> zzd = this.zzd.zza(t).zzd();
        while (zzd.hasNext()) {
            Map.Entry<?, Object> next = zzd.next();
            zzeh zzehVar = (zzeh) next.getKey();
            if (zzehVar.zzc() != zzhv.MESSAGE || zzehVar.zzd() || zzehVar.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzey) {
                zzhuVar.zza(zzehVar.zza(), (Object) ((zzey) next).zza().zzc());
            } else {
                zzhuVar.zza(zzehVar.zza(), next.getValue());
            }
        }
        zzha<?, ?> zzhaVar = this.zzb;
        zzhaVar.zzb((zzha<?, ?>) zzhaVar.zza(t), zzhuVar);
    }
}
