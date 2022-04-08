package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
final class zzhr<T> implements zzib<T> {
    private final zzhk zza;
    private final zzit<?, ?> zzb;
    private final boolean zzc;
    private final zzfr<?> zzd;

    private zzhr(zzit<?, ?> zzitVar, zzfr<?> zzfrVar, zzhk zzhkVar) {
        this.zzb = zzitVar;
        this.zzc = zzfrVar.zza(zzhkVar);
        this.zzd = zzfrVar;
        this.zza = zzhkVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> zzhr<T> zza(zzit<?, ?> zzitVar, zzfr<?> zzfrVar, zzhk zzhkVar) {
        return new zzhr<>(zzitVar, zzfrVar, zzhkVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzib
    public final void zzb(T t, T t2) {
        zzid.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzid.zza(this.zzd, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzib
    public final void zzc(T t) {
        this.zzb.zzb(t);
        this.zzd.zzc(t);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzib
    public final boolean zzd(T t) {
        return this.zzd.zza(t).zzf();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzib
    public final boolean zza(T t, T t2) {
        if (!this.zzb.zza(t).equals(this.zzb.zza(t2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza(t).equals(this.zzd.zza(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzib
    public final int zzb(T t) {
        zzit<?, ?> zzitVar = this.zzb;
        int zzc = zzitVar.zzc(zzitVar.zza(t)) + 0;
        return this.zzc ? zzc + this.zzd.zza(t).zzg() : zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzib
    public final int zza(T t) {
        int hashCode = this.zzb.zza(t).hashCode();
        return this.zzc ? (hashCode * 53) + this.zzd.zza(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzib
    public final void zza(T t, zzjn zzjnVar) throws IOException {
        Iterator<Map.Entry<?, Object>> zzd = this.zzd.zza(t).zzd();
        while (zzd.hasNext()) {
            Map.Entry<?, Object> next = zzd.next();
            zzfu zzfuVar = (zzfu) next.getKey();
            if (zzfuVar.zzc() != zzjk.MESSAGE || zzfuVar.zzd() || zzfuVar.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzgr) {
                zzjnVar.zza(zzfuVar.zza(), (Object) ((zzgr) next).zza().zzc());
            } else {
                zzjnVar.zza(zzfuVar.zza(), next.getValue());
            }
        }
        zzit<?, ?> zzitVar = this.zzb;
        zzitVar.zzb((zzit<?, ?>) zzitVar.zza(t), zzjnVar);
    }
}
