package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.internal.mlkit_vision_barcode.zzga;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
public final class zzhb implements zzia {
    private static final zzhl zzb = new zzha();
    private final zzhl zza;

    public zzhb() {
        this(new zzhd(zzgb.zza(), zza()));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzia
    public final <T> zzib<T> zza(Class<T> cls) {
        zzid.zza((Class<?>) cls);
        zzhi zzb2 = this.zza.zzb(cls);
        if (zzb2.zzb()) {
            if (zzga.class.isAssignableFrom(cls)) {
                return zzhr.zza(zzid.zzc(), zzft.zza(), zzb2.zzc());
            }
            return zzhr.zza(zzid.zza(), zzft.zzb(), zzb2.zzc());
        } else if (zzga.class.isAssignableFrom(cls)) {
            if (zza(zzb2)) {
                return zzho.zza(cls, zzb2, zzhv.zzb(), zzgu.zzb(), zzid.zzc(), zzft.zza(), zzhj.zzb());
            }
            return zzho.zza(cls, zzb2, zzhv.zzb(), zzgu.zzb(), zzid.zzc(), null, zzhj.zzb());
        } else if (zza(zzb2)) {
            return zzho.zza(cls, zzb2, zzhv.zza(), zzgu.zza(), zzid.zza(), zzft.zzb(), zzhj.zza());
        } else {
            return zzho.zza(cls, zzb2, zzhv.zza(), zzgu.zza(), zzid.zzb(), null, zzhj.zza());
        }
    }

    private zzhb(zzhl zzhlVar) {
        this.zza = (zzhl) zzgc.zza(zzhlVar, "messageInfoFactory");
    }

    private static boolean zza(zzhi zzhiVar) {
        return zzhiVar.zza() == zzga.zze.zzh;
    }

    private static zzhl zza() {
        try {
            return (zzhl) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return zzb;
        }
    }
}
