package com.tplink.libmediakit.media.audioprocess;

import android.text.TextUtils;
import b.d.p.d;
import java.util.HashMap;
import java.util.Map;

/* compiled from: AudioProcessLog.java */
/* loaded from: classes3.dex */
public class e {
    private static boolean a = true;

    /* renamed from: b  reason: collision with root package name */
    private static Map<String, String> f11941b = new HashMap();

    public static void a(String str, String str2) {
        if (a) {
            d.a("AudioProcess-" + str, str2);
        }
    }

    public static void b(String str, String str2, String str3) {
        String str4 = str + str2;
        if (!TextUtils.equals(f11941b.get(str4), str3)) {
            f11941b.put(str4, str3);
            if (a) {
                d.a("AudioProcess-" + str, str3);
            }
        }
    }

    public static void c(String str, String str2, String str3) {
        String str4 = str + str2;
        if (!TextUtils.equals(f11941b.get(str4), str3)) {
            f11941b.put(str4, str3);
            if (a) {
                d.c("AudioProcess-" + str, str3);
            }
        }
    }
}
