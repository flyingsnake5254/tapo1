package com.google.android.gms.internal.vision;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
public class zzaq {
    private static HashMap<String, String> zzff;
    private static Object zzfk;
    private static boolean zzfl;
    public static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
    private static final Uri zzfb = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern zzfc = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern zzfd = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static final AtomicBoolean zzfe = new AtomicBoolean();
    private static final HashMap<String, Boolean> zzfg = new HashMap<>();
    private static final HashMap<String, Integer> zzfh = new HashMap<>();
    private static final HashMap<String, Long> zzfi = new HashMap<>();
    private static final HashMap<String, Float> zzfj = new HashMap<>();
    private static String[] zzfm = new String[0];

    public static String zza(ContentResolver contentResolver, String str, String str2) {
        synchronized (zzaq.class) {
            String str3 = null;
            if (zzff == null) {
                zzfe.set(false);
                zzff = new HashMap<>();
                zzfk = new Object();
                zzfl = false;
                contentResolver.registerContentObserver(CONTENT_URI, true, new zzat(null));
            } else if (zzfe.getAndSet(false)) {
                zzff.clear();
                zzfg.clear();
                zzfh.clear();
                zzfi.clear();
                zzfj.clear();
                zzfk = new Object();
                zzfl = false;
            }
            Object obj = zzfk;
            if (zzff.containsKey(str)) {
                String str4 = zzff.get(str);
                if (str4 != null) {
                    str3 = str4;
                }
                return str3;
            }
            for (String str5 : zzfm) {
                if (str.startsWith(str5)) {
                    if (!zzfl || zzff.isEmpty()) {
                        zzff.putAll(zza(contentResolver, zzfm));
                        zzfl = true;
                        if (zzff.containsKey(str)) {
                            String str6 = zzff.get(str);
                            if (str6 != null) {
                                str3 = str6;
                            }
                            return str3;
                        }
                    }
                    return null;
                }
            }
            Cursor query = contentResolver.query(CONTENT_URI, null, null, new String[]{str}, null);
            if (query == null) {
                if (query != null) {
                }
                return null;
            }
            try {
                if (!query.moveToFirst()) {
                    zza(obj, str, (String) null);
                    return null;
                }
                String string = query.getString(1);
                if (string != null && string.equals(null)) {
                    string = null;
                }
                zza(obj, str, string);
                if (string != null) {
                    str3 = string;
                }
                return str3;
            } finally {
                query.close();
            }
        }
    }

    private static void zza(Object obj, String str, String str2) {
        synchronized (zzaq.class) {
            if (obj == zzfk) {
                zzff.put(str, str2);
            }
        }
    }

    private static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(zzfb, null, null, strArr, null);
        TreeMap treeMap = new TreeMap();
        if (query == null) {
            return treeMap;
        }
        while (query.moveToNext()) {
            try {
                treeMap.put(query.getString(0), query.getString(1));
            } finally {
                query.close();
            }
        }
        return treeMap;
    }
}
