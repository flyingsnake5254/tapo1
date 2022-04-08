package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes.dex */
final class zzga implements zzgi {
    private zzgi[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzga(zzgi... zzgiVarArr) {
        this.zza = zzgiVarArr;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgi
    public final boolean zza(Class<?> cls) {
        for (zzgi zzgiVar : this.zza) {
            if (zzgiVar.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgi
    public final zzgf zzb(Class<?> cls) {
        zzgi[] zzgiVarArr;
        for (zzgi zzgiVar : this.zza) {
            if (zzgiVar.zza(cls)) {
                return zzgiVar.zzb(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
