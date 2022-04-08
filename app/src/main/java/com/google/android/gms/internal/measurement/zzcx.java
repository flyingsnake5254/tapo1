package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.internal.zzfm;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@19.0.0 */
/* loaded from: classes.dex */
public final class zzcx extends zzdt {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Context zzc;
    final /* synthetic */ Bundle zzd;
    final /* synthetic */ zzee zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcx(zzee zzeeVar, String str, String str2, Context context, Bundle bundle) {
        super(zzeeVar, true);
        this.zze = zzeeVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = context;
        this.zzd = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.zzdt
    public final void zza() {
        boolean zzV;
        String str;
        String str2;
        zzcc zzccVar;
        int remoteVersion;
        zzcc zzccVar2;
        String str3;
        try {
            zzee zzeeVar = this.zze;
            zzV = zzee.zzV(this.zza, this.zzb);
            String str4 = null;
            if (zzV) {
                str = this.zzb;
                str2 = this.zza;
                str4 = this.zze.zzd;
            } else {
                str2 = null;
                str = null;
            }
            Preconditions.checkNotNull(this.zzc);
            zzee zzeeVar2 = this.zze;
            zzeeVar2.zzj = zzeeVar2.zzc(this.zzc, true);
            zzccVar = this.zze.zzj;
            if (zzccVar == null) {
                str3 = this.zze.zzd;
                Log.w(str3, "Failed to connect to measurement client.");
                return;
            }
            int localVersion = DynamiteModule.getLocalVersion(this.zzc, ModuleDescriptor.MODULE_ID);
            zzcl zzclVar = new zzcl(42004L, Math.max(localVersion, remoteVersion), DynamiteModule.getRemoteVersion(this.zzc, ModuleDescriptor.MODULE_ID) < localVersion, str4, str2, str, this.zzd, zzfm.zza(this.zzc));
            zzccVar2 = this.zze.zzj;
            ((zzcc) Preconditions.checkNotNull(zzccVar2)).initialize(ObjectWrapper.wrap(this.zzc), zzclVar, this.zzh);
        } catch (Exception e2) {
            this.zze.zzT(e2, true, false);
        }
    }
}
