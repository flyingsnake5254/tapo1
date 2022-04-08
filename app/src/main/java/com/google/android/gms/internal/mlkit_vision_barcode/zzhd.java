package com.google.android.gms.internal.mlkit_vision_barcode;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
final class zzhd implements zzhl {
    private zzhl[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhd(zzhl... zzhlVarArr) {
        this.zza = zzhlVarArr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzhl
    public final boolean zza(Class<?> cls) {
        for (zzhl zzhlVar : this.zza) {
            if (zzhlVar.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzhl
    public final zzhi zzb(Class<?> cls) {
        zzhl[] zzhlVarArr;
        for (zzhl zzhlVar : this.zza) {
            if (zzhlVar.zza(cls)) {
                return zzhlVar.zzb(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
