package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
/* loaded from: classes.dex */
public final class zzhl implements zzkt {
    final /* synthetic */ zzhw zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhl(zzhw zzhwVar) {
        this.zza = zzhwVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzkt
    public final void zza(String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            zzhw zzhwVar = this.zza;
            zzfu.zzP();
            zzhwVar.zzx(ThingModelDefine.Property.PROPERTY_AUTO, "_err", zzhwVar.zzs.zzay().currentTimeMillis(), bundle, false, true, false, str);
            return;
        }
        this.zza.zzs(ThingModelDefine.Property.PROPERTY_AUTO, "_err", bundle);
    }
}
