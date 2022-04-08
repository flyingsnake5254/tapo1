package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* loaded from: classes.dex */
final class zzg implements DynamiteModule.VersionPolicy {
    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final DynamiteModule.VersionPolicy.zzb zza(Context context, String str, DynamiteModule.VersionPolicy.zza zzaVar) throws DynamiteModule.LoadingException {
        DynamiteModule.VersionPolicy.zzb zzbVar = new DynamiteModule.VersionPolicy.zzb();
        int localVersion = zzaVar.getLocalVersion(context, str);
        zzbVar.zzir = localVersion;
        if (localVersion != 0) {
            zzbVar.zzis = zzaVar.zza(context, str, false);
        } else {
            zzbVar.zzis = zzaVar.zza(context, str, true);
        }
        int i = zzbVar.zzir;
        if (i == 0 && zzbVar.zzis == 0) {
            zzbVar.zzit = 0;
        } else if (zzbVar.zzis >= i) {
            zzbVar.zzit = 1;
        } else {
            zzbVar.zzit = -1;
        }
        return zzbVar;
    }
}