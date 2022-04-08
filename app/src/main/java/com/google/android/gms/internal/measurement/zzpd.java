package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
/* loaded from: classes.dex */
public final class zzpd implements zzpc {
    public static final zzht<Long> zza;
    public static final zzht<Boolean> zzb;
    public static final zzht<Boolean> zzc;
    public static final zzht<Boolean> zzd;
    public static final zzht<Long> zze;

    static {
        zzhr zzhrVar = new zzhr(zzhk.zza("com.google.android.gms.measurement"));
        zza = zzhrVar.zza("measurement.id.lifecycle.app_in_background_parameter", 0L);
        zzb = zzhrVar.zzb("measurement.lifecycle.app_backgrounded_engagement", false);
        zzc = zzhrVar.zzb("measurement.lifecycle.app_backgrounded_tracking", true);
        zzd = zzhrVar.zzb("measurement.lifecycle.app_in_background_parameter", false);
        zze = zzhrVar.zza("measurement.id.lifecycle.app_backgrounded_tracking", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final boolean zza() {
        return zzb.zze().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final boolean zzb() {
        return zzd.zze().booleanValue();
    }
}
