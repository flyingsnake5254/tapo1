package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
/* loaded from: classes.dex */
public final class zzkl implements zzkt {
    final /* synthetic */ zzkn zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkl(zzkn zzknVar) {
        this.zza = zzknVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzkt
    public final void zza(String str, String str2, Bundle bundle) {
        zzfu zzfuVar;
        zzfu zzfuVar2;
        if (TextUtils.isEmpty(str)) {
            zzfuVar = this.zza.zzm;
            if (zzfuVar != null) {
                zzfuVar2 = this.zza.zzm;
                zzfuVar2.zzau().zzb().zzb("AppId not known when logging event", "_err");
                return;
            }
            return;
        }
        this.zza.zzav().zzh(new zzkk(this, str, "_err", bundle));
    }
}
