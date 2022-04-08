package com.google.android.gms.internal.measurement;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@19.0.0 */
/* loaded from: classes.dex */
public final class zzla implements zzlu {
    private static final zzlg zzb = new zzky();
    private final zzlg zza;

    public zzla() {
        zzlg zzlgVar;
        zzlg[] zzlgVarArr = new zzlg[2];
        zzlgVarArr[0] = zzjy.zza();
        try {
            zzlgVar = (zzlg) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            zzlgVar = zzb;
        }
        zzlgVarArr[1] = zzlgVar;
        zzkz zzkzVar = new zzkz(zzlgVarArr);
        zzkl.zzb(zzkzVar, "messageInfoFactory");
        this.zza = zzkzVar;
    }

    private static boolean zzb(zzlf zzlfVar) {
        return zzlfVar.zzc() == 1;
    }

    @Override // com.google.android.gms.internal.measurement.zzlu
    public final <T> zzlt<T> zza(Class<T> cls) {
        zzlv.zza(cls);
        zzlf zzc = this.zza.zzc(cls);
        if (zzc.zza()) {
            if (zzkd.class.isAssignableFrom(cls)) {
                return zzlm.zzf(zzlv.zzC(), zzjs.zza(), zzc.zzb());
            }
            return zzlm.zzf(zzlv.zzA(), zzjs.zzb(), zzc.zzb());
        } else if (zzkd.class.isAssignableFrom(cls)) {
            if (zzb(zzc)) {
                return zzll.zzk(cls, zzc, zzlo.zzb(), zzkw.zzd(), zzlv.zzC(), zzjs.zza(), zzle.zzb());
            }
            return zzll.zzk(cls, zzc, zzlo.zzb(), zzkw.zzd(), zzlv.zzC(), null, zzle.zzb());
        } else if (zzb(zzc)) {
            return zzll.zzk(cls, zzc, zzlo.zza(), zzkw.zzc(), zzlv.zzA(), zzjs.zzb(), zzle.zza());
        } else {
            return zzll.zzk(cls, zzc, zzlo.zza(), zzkw.zzc(), zzlv.zzB(), null, zzle.zza());
        }
    }
}
