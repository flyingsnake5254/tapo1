package com.google.android.gms.measurement.internal;

import androidx.annotation.GuardedBy;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
@VisibleForTesting
/* loaded from: classes.dex */
public final class zzdz<V> {
    private static final Object zzf = new Object();
    private final String zza;
    private final zzdx<V> zzb;
    private final V zzc;
    private final V zzd;
    private final Object zze = new Object();
    @GuardedBy("overrideLock")
    private volatile V zzg = null;
    @GuardedBy("cachingLock")
    private volatile V zzh = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ zzdz(String str, Object obj, Object obj2, zzdx zzdxVar, zzdw zzdwVar) {
        this.zza = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zzb = zzdxVar;
    }

    public final String zza() {
        return this.zza;
    }

    public final V zzb(V v) {
        synchronized (this.zze) {
        }
        if (v != null) {
            return v;
        }
        if (zzdy.zza == null) {
            return this.zzc;
        }
        synchronized (zzf) {
            if (zzz.zza()) {
                return this.zzh == null ? this.zzc : this.zzh;
            }
            try {
                for (zzdz zzdzVar : zzea.zzc()) {
                    if (!zzz.zza()) {
                        V v2 = null;
                        try {
                            zzdx<V> zzdxVar = zzdzVar.zzb;
                            if (zzdxVar != null) {
                                v2 = zzdxVar.zza();
                            }
                        } catch (IllegalStateException unused) {
                        }
                        synchronized (zzf) {
                            zzdzVar.zzh = v2;
                        }
                    } else {
                        throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                    }
                }
            } catch (SecurityException unused2) {
            }
            zzdx<V> zzdxVar2 = this.zzb;
            if (zzdxVar2 == null) {
                return this.zzc;
            }
            try {
                return zzdxVar2.zza();
            } catch (IllegalStateException unused3) {
                return this.zzc;
            } catch (SecurityException unused4) {
                return this.zzc;
            }
        }
    }
}
