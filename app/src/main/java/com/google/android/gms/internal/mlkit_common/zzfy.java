package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzez;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes.dex */
public final class zzfy implements zzgx {
    private static final zzgi zzb = new zzfx();
    private final zzgi zza;

    public zzfy() {
        this(new zzga(zzex.zza(), zza()));
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgx
    public final <T> zzgy<T> zza(Class<T> cls) {
        zzha.zza((Class<?>) cls);
        zzgf zzb2 = this.zza.zzb(cls);
        if (zzb2.zzb()) {
            if (zzez.class.isAssignableFrom(cls)) {
                return zzgo.zza(zzha.zzc(), zzes.zza(), zzb2.zzc());
            }
            return zzgo.zza(zzha.zza(), zzes.zzb(), zzb2.zzc());
        } else if (zzez.class.isAssignableFrom(cls)) {
            if (zza(zzb2)) {
                return zzgl.zza(cls, zzb2, zzgs.zzb(), zzfr.zzb(), zzha.zzc(), zzes.zza(), zzgg.zzb());
            }
            return zzgl.zza(cls, zzb2, zzgs.zzb(), zzfr.zzb(), zzha.zzc(), null, zzgg.zzb());
        } else if (zza(zzb2)) {
            return zzgl.zza(cls, zzb2, zzgs.zza(), zzfr.zza(), zzha.zza(), zzes.zzb(), zzgg.zza());
        } else {
            return zzgl.zza(cls, zzb2, zzgs.zza(), zzfr.zza(), zzha.zzb(), null, zzgg.zza());
        }
    }

    private zzfy(zzgi zzgiVar) {
        this.zza = (zzgi) zzfc.zza(zzgiVar, "messageInfoFactory");
    }

    private static boolean zza(zzgf zzgfVar) {
        return zzgfVar.zza() == zzez.zzf.zzh;
    }

    private static zzgi zza() {
        try {
            return (zzgi) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return zzb;
        }
    }
}
