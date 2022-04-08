package com.airbnb.lottie;

import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;

/* compiled from: L.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class c {
    public static boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f886b = false;

    /* renamed from: c  reason: collision with root package name */
    private static String[] f887c;

    /* renamed from: d  reason: collision with root package name */
    private static long[] f888d;

    /* renamed from: e  reason: collision with root package name */
    private static int f889e;

    /* renamed from: f  reason: collision with root package name */
    private static int f890f;

    public static void a(String str) {
        if (f886b) {
            int i = f889e;
            if (i == 20) {
                f890f++;
                return;
            }
            f887c[i] = str;
            f888d[i] = System.nanoTime();
            TraceCompat.beginSection(str);
            f889e++;
        }
    }

    public static float b(String str) {
        int i = f890f;
        if (i > 0) {
            f890f = i - 1;
            return 0.0f;
        } else if (!f886b) {
            return 0.0f;
        } else {
            int i2 = f889e - 1;
            f889e = i2;
            if (i2 == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            } else if (str.equals(f887c[i2])) {
                TraceCompat.endSection();
                return ((float) (System.nanoTime() - f888d[f889e])) / 1000000.0f;
            } else {
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f887c[f889e] + ".");
            }
        }
    }
}
