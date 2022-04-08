package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
/* loaded from: classes.dex */
public final class zzhu implements zzhe {
    @GuardedBy("SharedPreferencesLoader.class")
    private static final Map<String, zzhu> zza = new ArrayMap();
    private final SharedPreferences zzb;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhu zza(Context context, String str) {
        zzhu zzhuVar;
        if (!zzgw.zza()) {
            synchronized (zzhu.class) {
                zzhuVar = zza.get(null);
                if (zzhuVar == null) {
                    StrictMode.allowThreadDiskReads();
                    throw null;
                }
            }
            return zzhuVar;
        }
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void zzb() {
        synchronized (zzhu.class) {
            Map<String, zzhu> map = zza;
            Iterator<zzhu> it = map.values().iterator();
            if (!it.hasNext()) {
                map.clear();
            } else {
                SharedPreferences sharedPreferences = it.next().zzb;
                throw null;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzhe
    public final Object zze(String str) {
        throw null;
    }
}
