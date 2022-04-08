package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@19.0.0 */
/* loaded from: classes.dex */
final class zzkz implements zzlg {
    private final zzlg[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkz(zzlg... zzlgVarArr) {
        this.zza = zzlgVarArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public final boolean zzb(Class<?> cls) {
        zzlg[] zzlgVarArr = this.zza;
        for (int i = 0; i < 2; i++) {
            if (zzlgVarArr[i].zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public final zzlf zzc(Class<?> cls) {
        zzlg[] zzlgVarArr = this.zza;
        for (int i = 0; i < 2; i++) {
            zzlg zzlgVar = zzlgVarArr[i];
            if (zzlgVar.zzb(cls)) {
                return zzlgVar.zzc(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
