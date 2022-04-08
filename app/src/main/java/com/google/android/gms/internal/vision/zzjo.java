package com.google.android.gms.internal.vision;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
abstract class zzjo<T, B> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zza(B b2, int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zza(B b2, int i, zzfm zzfmVar);

    abstract void zza(B b2, int i, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zza(T t, zzkl zzklVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean zza(zzix zzixVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza(B b2, zzix zzixVar) throws IOException {
        int tag = zzixVar.getTag();
        int i = tag >>> 3;
        int i2 = tag & 7;
        if (i2 == 0) {
            zza((zzjo<T, B>) b2, i, zzixVar.zzdy());
            return true;
        } else if (i2 == 1) {
            zzb(b2, i, zzixVar.zzea());
            return true;
        } else if (i2 == 2) {
            zza((zzjo<T, B>) b2, i, zzixVar.zzee());
            return true;
        } else if (i2 == 3) {
            B zzig = zzig();
            int i3 = 4 | (i << 3);
            while (zzixVar.zzdv() != Integer.MAX_VALUE && zza((zzjo<T, B>) zzig, zzixVar)) {
            }
            if (i3 == zzixVar.getTag()) {
                zza((zzjo<T, B>) b2, i, (int) zzo(zzig));
                return true;
            }
            throw zzhh.zzgr();
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzc(b2, i, zzixVar.zzeb());
                return true;
            }
            throw zzhh.zzgs();
        }
    }

    abstract void zzb(B b2, int i, long j);

    abstract void zzc(B b2, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzc(T t, zzkl zzklVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzf(Object obj, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzg(Object obj, B b2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T zzh(T t, T t2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzh(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B zzig();

    abstract T zzo(B b2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zzs(T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T zzw(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B zzx(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zzy(T t);
}
