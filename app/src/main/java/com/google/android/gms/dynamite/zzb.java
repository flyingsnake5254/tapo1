package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* loaded from: classes.dex */
final class zzb implements DynamiteModule.VersionPolicy {
    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final DynamiteModule.VersionPolicy.zzb zza(Context context, String str, DynamiteModule.VersionPolicy.zza zzaVar) throws DynamiteModule.LoadingException {
        DynamiteModule.VersionPolicy.zzb zzbVar = new DynamiteModule.VersionPolicy.zzb();
        int zza = zzaVar.zza(context, str, true);
        zzbVar.zzis = zza;
        if (zza != 0) {
            zzbVar.zzit = 1;
        } else {
            int localVersion = zzaVar.getLocalVersion(context, str);
            zzbVar.zzir = localVersion;
            if (localVersion != 0) {
                zzbVar.zzit = -1;
            }
        }
        return zzbVar;
    }
}
