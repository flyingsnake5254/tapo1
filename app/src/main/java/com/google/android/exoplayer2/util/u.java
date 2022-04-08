package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import java.net.UnknownHostException;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: Log.java */
/* loaded from: classes.dex */
public final class u {
    private static int a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f3951b = true;

    @Pure
    private static String a(String str, @Nullable Throwable th) {
        String e2 = e(th);
        if (TextUtils.isEmpty(e2)) {
            return str;
        }
        String valueOf = String.valueOf(str);
        String replace = e2.replace("\n", "\n  ");
        StringBuilder sb = new StringBuilder(valueOf.length() + 4 + String.valueOf(replace).length());
        sb.append(valueOf);
        sb.append("\n  ");
        sb.append(replace);
        sb.append('\n');
        return sb.toString();
    }

    @Pure
    public static void b(String str, String str2) {
        if (a == 0) {
            Log.d(str, str2);
        }
    }

    @Pure
    public static void c(String str, String str2) {
        if (a <= 3) {
            Log.e(str, str2);
        }
    }

    @Pure
    public static void d(String str, String str2, @Nullable Throwable th) {
        c(str, a(str2, th));
    }

    @Nullable
    @Pure
    public static String e(@Nullable Throwable th) {
        if (th == null) {
            return null;
        }
        if (g(th)) {
            return "UnknownHostException (no network)";
        }
        if (!f3951b) {
            return th.getMessage();
        }
        return Log.getStackTraceString(th).trim().replace("\t", "    ");
    }

    @Pure
    public static void f(String str, String str2) {
        if (a <= 1) {
            Log.i(str, str2);
        }
    }

    @Pure
    private static boolean g(@Nullable Throwable th) {
        while (th != null) {
            if (th instanceof UnknownHostException) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    @Pure
    public static void h(String str, String str2) {
        if (a <= 2) {
            Log.w(str, str2);
        }
    }

    @Pure
    public static void i(String str, String str2, @Nullable Throwable th) {
        h(str, a(str2, th));
    }
}
