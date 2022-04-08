package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.google.android.gms.internal.mlkit_vision_common.zzr;
import com.google.android.gms.tasks.Task;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.sdkinternal.c;
import com.google.mlkit.common.sdkinternal.f;
import com.google.mlkit.common.sdkinternal.h;
import com.google.mlkit.common.sdkinternal.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes.dex */
public final class zzcq {
    public static final Component<?> zza = Component.builder(zzcq.class).add(Dependency.required(Context.class)).add(Dependency.required(m.class)).add(Dependency.required(zza.class)).factory(zzcu.zza).build();
    @Nullable
    private static List<String> zzb = null;
    private static boolean zzk = true;
    private static boolean zzl = true;
    private final String zzc;
    private final String zzd;
    private final zza zze;
    private final m zzf;
    private final Task<String> zzh;
    private final Map<zzag, Long> zzi = new HashMap();
    private final Map<zzag, Object> zzj = new HashMap();
    private final Task<String> zzg = h.a().b(zzct.zza);

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public interface zza {
        void zza(zzr.zzad zzadVar);
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public interface zzb {
        zzr.zzad.zza zza();
    }

    private zzcq(Context context, m mVar, zza zzaVar) {
        this.zzc = context.getPackageName();
        this.zzd = c.a(context);
        this.zzf = mVar;
        this.zze = zzaVar;
        h a = h.a();
        mVar.getClass();
        this.zzh = a.b(zzcs.zza(mVar));
    }

    @NonNull
    private static synchronized List<String> zzb() {
        synchronized (zzcq.class) {
            List<String> list = zzb;
            if (list != null) {
                return list;
            }
            LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
            zzb = new ArrayList(locales.size());
            for (int i = 0; i < locales.size(); i++) {
                zzb.add(c.b(locales.get(i)));
            }
            return zzb;
        }
    }

    @WorkerThread
    public final void zza(@NonNull zzb zzbVar, @NonNull final zzag zzagVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean z = true;
        if (this.zzi.get(zzagVar) != null && elapsedRealtime - this.zzi.get(zzagVar).longValue() <= TimeUnit.SECONDS.toMillis(30L)) {
            z = false;
        }
        if (z) {
            this.zzi.put(zzagVar, Long.valueOf(elapsedRealtime));
            final zzr.zzad.zza zza2 = zzbVar.zza();
            h.d().execute(new Runnable(this, zza2, zzagVar) { // from class: com.google.android.gms.internal.mlkit_vision_common.zzcv
                private final zzcq zza;
                private final zzr.zzad.zza zzb;
                private final zzag zzc;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zza = this;
                    this.zzb = zza2;
                    this.zzc = zzagVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zza(this.zzb, this.zzc);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzr.zzad.zza zzaVar, zzag zzagVar) {
        String str;
        String str2;
        String zza2 = zzaVar.zza().zza();
        if ("NA".equals(zza2) || "".equals(zza2)) {
            zza2 = "NA";
        }
        zzr.zzbg.zza zzb2 = zzr.zzbg.zzb().zza(this.zzc).zzb(this.zzd).zzd(zza2).zza(zzb()).zzb(true);
        if (this.zzg.isSuccessful()) {
            str = this.zzg.getResult();
        } else {
            str = f.a().b("vision-common");
        }
        zzr.zzbg.zza zzc = zzb2.zzc(str);
        if (zzl) {
            if (this.zzh.isSuccessful()) {
                str2 = this.zzh.getResult();
            } else {
                str2 = this.zzf.a();
            }
            zzc.zze(str2);
        }
        zzaVar.zza(zzagVar).zza(zzc);
        this.zze.zza((zzr.zzad) ((zzek) zzaVar.zzg()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ zzcq zza(ComponentContainer componentContainer) {
        return new zzcq((Context) componentContainer.get(Context.class), (m) componentContainer.get(m.class), (zza) componentContainer.get(zza.class));
    }
}
