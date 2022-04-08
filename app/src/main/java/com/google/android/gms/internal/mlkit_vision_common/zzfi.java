package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzek;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes.dex */
public final class zzfi implements zzgl {
    private static final zzfs zzb = new zzfl();
    private final zzfs zza;

    public zzfi() {
        this(new zzfk(zzel.zza(), zza()));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzgl
    public final <T> zzgi<T> zza(Class<T> cls) {
        zzgk.zza((Class<?>) cls);
        zzft zzb2 = this.zza.zzb(cls);
        if (zzb2.zzb()) {
            if (zzek.class.isAssignableFrom(cls)) {
                return zzfy.zza(zzgk.zzc(), zzec.zza(), zzb2.zzc());
            }
            return zzfy.zza(zzgk.zza(), zzec.zzb(), zzb2.zzc());
        } else if (zzek.class.isAssignableFrom(cls)) {
            if (zza(zzb2)) {
                return zzfz.zza(cls, zzb2, zzgc.zzb(), zzff.zzb(), zzgk.zzc(), zzec.zza(), zzfq.zzb());
            }
            return zzfz.zza(cls, zzb2, zzgc.zzb(), zzff.zzb(), zzgk.zzc(), null, zzfq.zzb());
        } else if (zza(zzb2)) {
            return zzfz.zza(cls, zzb2, zzgc.zza(), zzff.zza(), zzgk.zza(), zzec.zzb(), zzfq.zza());
        } else {
            return zzfz.zza(cls, zzb2, zzgc.zza(), zzff.zza(), zzgk.zzb(), null, zzfq.zza());
        }
    }

    private zzfi(zzfs zzfsVar) {
        this.zza = (zzfs) zzem.zza(zzfsVar, "messageInfoFactory");
    }

    private static boolean zza(zzft zzftVar) {
        return zzftVar.zza() == zzek.zze.zzh;
    }

    private static zzfs zza() {
        try {
            return (zzfs) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return zzb;
        }
    }
}
