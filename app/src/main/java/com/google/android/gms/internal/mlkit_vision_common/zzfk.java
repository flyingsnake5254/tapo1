package com.google.android.gms.internal.mlkit_vision_common;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes.dex */
final class zzfk implements zzfs {
    private zzfs[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfk(zzfs... zzfsVarArr) {
        this.zza = zzfsVarArr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfs
    public final boolean zza(Class<?> cls) {
        for (zzfs zzfsVar : this.zza) {
            if (zzfsVar.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfs
    public final zzft zzb(Class<?> cls) {
        zzfs[] zzfsVarArr;
        for (zzfs zzfsVar : this.zza) {
            if (zzfsVar.zza(cls)) {
                return zzfsVar.zzb(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
