package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.core.content.PermissionChecker;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
/* loaded from: classes.dex */
public final class zzhh implements zzhe {
    @GuardedBy("GservicesLoader.class")
    private static zzhh zza;
    @Nullable
    private final Context zzb;
    @Nullable
    private final ContentObserver zzc;

    private zzhh() {
        this.zzb = null;
        this.zzc = null;
    }

    private zzhh(Context context) {
        this.zzb = context;
        zzhg zzhgVar = new zzhg(this, null);
        this.zzc = zzhgVar;
        context.getContentResolver().registerContentObserver(zzgv.zza, true, zzhgVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhh zza(Context context) {
        zzhh zzhhVar;
        zzhh zzhhVar2;
        synchronized (zzhh.class) {
            if (zza == null) {
                if (PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
                    zzhhVar2 = new zzhh(context);
                } else {
                    zzhhVar2 = new zzhh();
                }
                zza = zzhhVar2;
            }
            zzhhVar = zza;
        }
        return zzhhVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void zzc() {
        Context context;
        synchronized (zzhh.class) {
            zzhh zzhhVar = zza;
            if (!(zzhhVar == null || (context = zzhhVar.zzb) == null || zzhhVar.zzc == null)) {
                context.getContentResolver().unregisterContentObserver(zza.zzc);
            }
            zza = null;
        }
    }

    /* renamed from: zzb */
    public final String zze(final String str) {
        if (this.zzb == null) {
            return null;
        }
        try {
            return (String) zzhc.zza(new zzhd(this, str) { // from class: com.google.android.gms.internal.measurement.zzhf
                private final zzhh zza;
                private final String zzb;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zza = this;
                    this.zzb = str;
                }

                @Override // com.google.android.gms.internal.measurement.zzhd
                public final Object zza() {
                    return this.zza.zzd(this.zzb);
                }
            });
        } catch (IllegalStateException | SecurityException e2) {
            String valueOf = String.valueOf(str);
            Log.e("GservicesLoader", valueOf.length() != 0 ? "Unable to read GServices for: ".concat(valueOf) : new String("Unable to read GServices for: "), e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String zzd(String str) {
        return zzgv.zza(this.zzb.getContentResolver(), str, null);
    }
}
