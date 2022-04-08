package com.google.android.gms.internal.measurement;

import com.github.mikephil.charting.utils.Utils;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
/* loaded from: classes.dex */
public final class zzfs extends zzkd<zzfs, zzfr> implements zzlj {
    private static final zzfs zzk;
    private int zza;
    private long zzg;
    private float zzh;
    private double zzi;
    private String zze = "";
    private String zzf = "";
    private zzkk<zzfs> zzj = zzkd.zzbE();

    static {
        zzfs zzfsVar = new zzfs();
        zzk = zzfsVar;
        zzkd.zzby(zzfs.class, zzfsVar);
    }

    private zzfs() {
    }

    public static zzfr zzn() {
        return zzk.zzbt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzp(zzfs zzfsVar, String str) {
        str.getClass();
        zzfsVar.zza |= 1;
        zzfsVar.zze = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzq(zzfs zzfsVar, String str) {
        str.getClass();
        zzfsVar.zza |= 2;
        zzfsVar.zzf = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzr(zzfs zzfsVar) {
        zzfsVar.zza &= -3;
        zzfsVar.zzf = zzk.zzf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzs(zzfs zzfsVar, long j) {
        zzfsVar.zza |= 4;
        zzfsVar.zzg = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzt(zzfs zzfsVar) {
        zzfsVar.zza &= -5;
        zzfsVar.zzg = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzu(zzfs zzfsVar, double d2) {
        zzfsVar.zza |= 16;
        zzfsVar.zzi = d2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzv(zzfs zzfsVar) {
        zzfsVar.zza &= -17;
        zzfsVar.zzi = Utils.DOUBLE_EPSILON;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzw(zzfs zzfsVar, zzfs zzfsVar2) {
        zzfsVar2.getClass();
        zzfsVar.zzz();
        zzfsVar.zzj.add(zzfsVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzx(zzfs zzfsVar, Iterable iterable) {
        zzfsVar.zzz();
        zzio.zzbs(iterable, zzfsVar.zzj);
    }

    private final void zzz() {
        zzkk<zzfs> zzkkVar = this.zzj;
        if (!zzkkVar.zza()) {
            this.zzj = zzkd.zzbF(zzkkVar);
        }
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final String zzb() {
        return this.zze;
    }

    public final boolean zzc() {
        return (this.zza & 2) != 0;
    }

    public final String zzd() {
        return this.zzf;
    }

    public final boolean zze() {
        return (this.zza & 4) != 0;
    }

    public final long zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        return (this.zza & 8) != 0;
    }

    public final float zzh() {
        return this.zzh;
    }

    public final boolean zzi() {
        return (this.zza & 16) != 0;
    }

    public final double zzj() {
        return this.zzi;
    }

    public final List<zzfs> zzk() {
        return this.zzj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkd
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzkd.zzbz(zzk, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zza", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzfs.class});
        }
        if (i2 == 3) {
            return new zzfs();
        }
        if (i2 == 4) {
            return new zzfr(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzk;
    }

    public final int zzm() {
        return this.zzj.size();
    }
}
