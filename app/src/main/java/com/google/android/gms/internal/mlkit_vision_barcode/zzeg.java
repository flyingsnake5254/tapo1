package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.gms.internal.mlkit_vision_barcode.zzbl;
import com.google.android.gms.tasks.Task;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.sdkinternal.c;
import com.google.mlkit.common.sdkinternal.f;
import com.google.mlkit.common.sdkinternal.h;
import com.google.mlkit.common.sdkinternal.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
public final class zzeg {
    public static final Component<?> zza = Component.builder(zzeg.class).add(Dependency.required(Context.class)).add(Dependency.required(m.class)).add(Dependency.required(zzc.class)).factory(zzek.zza).build();
    @Nullable
    private static List<String> zzb = null;
    private static boolean zzk = true;
    private static boolean zzl = true;
    private final String zzc;
    private final String zzd;
    private final zzc zze;
    private final m zzf;
    private final Task<String> zzh;
    private final Map<zzbw, Long> zzi = new HashMap();
    private final Map<zzbw, zzat<Object, Long>> zzj = new HashMap();
    private final Task<String> zzg = h.a().b(zzej.zza);

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
    /* loaded from: classes.dex */
    public interface zza {
        zzbl.zzad.zza zza();
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
    /* loaded from: classes.dex */
    public interface zzb<K> {
        zzbl.zzad.zza zza(K k, int i, zzbl.zzab zzabVar);
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
    /* loaded from: classes.dex */
    public interface zzc {
        void zza(zzbl.zzad zzadVar);
    }

    private zzeg(Context context, m mVar, zzc zzcVar) {
        this.zzc = context.getPackageName();
        this.zzd = c.a(context);
        this.zzf = mVar;
        this.zze = zzcVar;
        h a = h.a();
        mVar.getClass();
        this.zzh = a.b(zzei.zza(mVar));
    }

    @NonNull
    private static synchronized List<String> zzb() {
        synchronized (zzeg.class) {
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

    public final void zza(@NonNull final zzbl.zzad.zza zzaVar, @NonNull final zzbw zzbwVar) {
        h.d().execute(new Runnable(this, zzaVar, zzbwVar) { // from class: com.google.android.gms.internal.mlkit_vision_barcode.zzel
            private final zzeg zza;
            private final zzbl.zzad.zza zzb;
            private final zzbw zzc;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
                this.zzb = zzaVar;
                this.zzc = zzbwVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzb(this.zzb, this.zzc);
            }
        });
    }

    @WorkerThread
    public final void zza(@NonNull zza zzaVar, @NonNull zzbw zzbwVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (zza(zzbwVar, elapsedRealtime, 30L)) {
            this.zzi.put(zzbwVar, Long.valueOf(elapsedRealtime));
            zza(zzaVar.zza(), zzbwVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @WorkerThread
    public final <K> void zza(@NonNull K k, long j, @NonNull zzbw zzbwVar, @NonNull zzb<K> zzbVar) {
        if (zzk) {
            if (!this.zzj.containsKey(zzbwVar)) {
                this.zzj.put(zzbwVar, zzw.zzf());
            }
            zzat<Object, Long> zzatVar = this.zzj.get(zzbwVar);
            zzatVar.zza(k, Long.valueOf(j));
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (zza(zzbwVar, elapsedRealtime, 30L)) {
                this.zzi.put(zzbwVar, Long.valueOf(elapsedRealtime));
                for (Object obj : zzatVar.zzh()) {
                    List<Long> zza2 = zzatVar.zza(obj);
                    Collections.sort(zza2);
                    zzbl.zzab.zza zza3 = zzbl.zzab.zza();
                    long j2 = 0;
                    for (Long l : zza2) {
                        j2 += l.longValue();
                    }
                    zza(zzbVar.zza(obj, zzatVar.zza(obj).size(), (zzbl.zzab) ((zzga) zza3.zzc(j2 / zza2.size()).zza(zza(zza2, 100.0d)).zzf(zza(zza2, 75.0d)).zze(zza(zza2, 50.0d)).zzd(zza(zza2, 25.0d)).zzb(zza(zza2, (double) Utils.DOUBLE_EPSILON)).zzg())), zzbwVar);
                }
                this.zzj.remove(zzbwVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzbl.zzad.zza zzaVar, zzbw zzbwVar) {
        String str;
        String str2;
        String zza2 = zzaVar.zza().zza();
        if ("NA".equals(zza2) || "".equals(zza2)) {
            zza2 = "NA";
        }
        zzbl.zzbh.zza zzb2 = zzbl.zzbh.zzb().zza(this.zzc).zzb(this.zzd).zzd(zza2).zza(zzb()).zzb(true);
        if (this.zzg.isSuccessful()) {
            str = this.zzg.getResult();
        } else {
            str = f.a().b("barcode-scanning-internal");
        }
        zzbl.zzbh.zza zzc2 = zzb2.zzc(str);
        if (zzl) {
            if (this.zzh.isSuccessful()) {
                str2 = this.zzh.getResult();
            } else {
                str2 = this.zzf.a();
            }
            zzc2.zze(str2);
        }
        zzaVar.zza(zzbwVar).zza(zzc2);
        this.zze.zza((zzbl.zzad) ((zzga) zzaVar.zzg()));
    }

    @VisibleForTesting
    private static long zza(List<Long> list, double d2) {
        return list.get(Math.max(((int) Math.ceil((d2 / 100.0d) * list.size())) - 1, 0)).longValue();
    }

    @WorkerThread
    private final boolean zza(@NonNull zzbw zzbwVar, long j, long j2) {
        return this.zzi.get(zzbwVar) == null || j - this.zzi.get(zzbwVar).longValue() > TimeUnit.SECONDS.toMillis(30L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ zzeg zza(ComponentContainer componentContainer) {
        return new zzeg((Context) componentContainer.get(Context.class), (m) componentContainer.get(m.class), (zzc) componentContainer.get(zzc.class));
    }
}
