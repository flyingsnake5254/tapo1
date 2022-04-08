package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzcl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
@VisibleForTesting
/* loaded from: classes.dex */
public final class zzgw {
    final Context zza;
    @Nullable
    String zzb;
    @Nullable
    String zzc;
    @Nullable
    String zzd;
    @Nullable
    Boolean zze;
    long zzf;
    @Nullable
    zzcl zzg;
    boolean zzh;
    @Nullable
    final Long zzi;
    @Nullable
    String zzj;

    @VisibleForTesting
    public zzgw(Context context, @Nullable zzcl zzclVar, @Nullable Long l) {
        this.zzh = true;
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zza = applicationContext;
        this.zzi = l;
        if (zzclVar != null) {
            this.zzg = zzclVar;
            this.zzb = zzclVar.zzf;
            this.zzc = zzclVar.zze;
            this.zzd = zzclVar.zzd;
            this.zzh = zzclVar.zzc;
            this.zzf = zzclVar.zzb;
            this.zzj = zzclVar.zzh;
            Bundle bundle = zzclVar.zzg;
            if (bundle != null) {
                this.zze = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
