package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
@WorkerThread
/* loaded from: classes.dex */
final class zzeq implements Runnable {
    private final zzep zza;
    private final int zzb;
    private final Throwable zzc;
    private final byte[] zzd;
    private final String zze;
    private final Map<String, List<String>> zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzeq(String str, zzep zzepVar, int i, Throwable th, byte[] bArr, Map map, zzeo zzeoVar) {
        Preconditions.checkNotNull(zzepVar);
        this.zza = zzepVar;
        this.zzb = i;
        this.zzc = th;
        this.zzd = bArr;
        this.zze = str;
        this.zzf = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zza(this.zze, this.zzb, this.zzc, this.zzd, this.zzf);
    }
}
