package com.google.android.gms.internal.vision;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
public final class zzav implements zzaz {
    @GuardedBy("ConfigurationContentLoader.class")
    private static final Map<Uri, zzav> zzfr = new ArrayMap();
    private static final String[] zzfx = {"key", "value"};
    private final Uri uri;
    private final ContentResolver zzfs;
    private final ContentObserver zzft;
    private volatile Map<String, String> zzfv;
    private final Object zzfu = new Object();
    @GuardedBy("this")
    private final List<zzaw> zzfw = new ArrayList();

    private zzav(ContentResolver contentResolver, Uri uri) {
        zzax zzaxVar = new zzax(this, null);
        this.zzft = zzaxVar;
        this.zzfs = contentResolver;
        this.uri = uri;
        contentResolver.registerContentObserver(uri, false, zzaxVar);
    }

    public static zzav zza(ContentResolver contentResolver, Uri uri) {
        zzav zzavVar;
        synchronized (zzav.class) {
            Map<Uri, zzav> map = zzfr;
            zzavVar = map.get(uri);
            if (zzavVar == null) {
                try {
                    zzav zzavVar2 = new zzav(contentResolver, uri);
                    try {
                        map.put(uri, zzavVar2);
                    } catch (SecurityException unused) {
                    }
                    zzavVar = zzavVar2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return zzavVar;
    }

    private final Map<String, String> zzv() {
        Map<String, String> map = this.zzfv;
        if (map == null) {
            synchronized (this.zzfu) {
                map = this.zzfv;
                if (map == null) {
                    map = zzx();
                    this.zzfv = map;
                }
            }
        }
        return map != null ? map : Collections.emptyMap();
    }

    /* JADX WARN: Finally extract failed */
    private final Map<String, String> zzx() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                Map<String, String> map = (Map) zzay.zza(new zzbb(this) { // from class: com.google.android.gms.internal.vision.zzau
                    private final zzav zzfq;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzfq = this;
                    }

                    @Override // com.google.android.gms.internal.vision.zzbb
                    public final Object zzu() {
                        return this.zzfq.zzz();
                    }
                });
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return map;
            } catch (SQLiteException | IllegalStateException | SecurityException unused) {
                Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return null;
            }
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void zzy() {
        synchronized (zzav.class) {
            for (zzav zzavVar : zzfr.values()) {
                zzavVar.zzfs.unregisterContentObserver(zzavVar.zzft);
            }
            zzfr.clear();
        }
    }

    @Override // com.google.android.gms.internal.vision.zzaz
    public final /* synthetic */ Object zzb(String str) {
        return zzv().get(str);
    }

    public final void zzw() {
        synchronized (this.zzfu) {
            this.zzfv = null;
            zzbj.zzac();
        }
        synchronized (this) {
            for (zzaw zzawVar : this.zzfw) {
                zzawVar.zzaa();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Map zzz() {
        Map map;
        Cursor query = this.zzfs.query(this.uri, zzfx, null, null, null);
        if (query == null) {
            return Collections.emptyMap();
        }
        try {
            int count = query.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            if (count <= 256) {
                map = new ArrayMap(count);
            } else {
                map = new HashMap(count, 1.0f);
            }
            while (query.moveToNext()) {
                map.put(query.getString(0), query.getString(1));
            }
            return map;
        } finally {
            query.close();
        }
    }
}
