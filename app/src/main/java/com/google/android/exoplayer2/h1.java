package com.google.android.exoplayer2;

import android.os.Build;
import java.util.HashSet;

/* compiled from: ExoPlayerLibraryInfo.java */
/* loaded from: classes.dex */
public final class h1 {
    @Deprecated
    public static final String a;

    /* renamed from: b  reason: collision with root package name */
    private static final HashSet<String> f2305b = new HashSet<>();

    /* renamed from: c  reason: collision with root package name */
    private static String f2306c = "goog.exo.core";

    static {
        String str = Build.VERSION.RELEASE;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 57);
        sb.append("ExoPlayerLib/2.15.0 (Linux; Android ");
        sb.append(str);
        sb.append(") ");
        sb.append("ExoPlayerLib/2.15.0");
        a = sb.toString();
    }

    public static synchronized void a(String str) {
        synchronized (h1.class) {
            if (f2305b.add(str)) {
                String str2 = f2306c;
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 2 + String.valueOf(str).length());
                sb.append(str2);
                sb.append(", ");
                sb.append(str);
                f2306c = sb.toString();
            }
        }
    }

    public static synchronized String b() {
        String str;
        synchronized (h1.class) {
            str = f2306c;
        }
        return str;
    }
}
