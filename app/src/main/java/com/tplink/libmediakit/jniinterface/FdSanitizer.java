package com.tplink.libmediakit.jniinterface;

import android.os.Build;
import android.util.Log;

/* loaded from: classes3.dex */
public class FdSanitizer {
    private static final String a = "FdSanitizer";

    /* renamed from: b  reason: collision with root package name */
    private static boolean f11912b = true;

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            System.loadLibrary("fdsan-lib");
        }
    }

    private static void a(String str, String str2) {
        if (f11912b) {
            Log.d(str, str2);
        }
    }

    public static void b(int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            int fdSanErrorLevelNative = getFdSanErrorLevelNative();
            String str = a;
            a(str, "fdSan error l1 " + fdSanErrorLevelNative);
            int fdSanErrorLevelNative2 = setFdSanErrorLevelNative(i);
            a(str, "fdSan error l2 " + fdSanErrorLevelNative2);
            int fdSanErrorLevelNative3 = getFdSanErrorLevelNative();
            a(str, "fdSan error l3 " + fdSanErrorLevelNative3);
        }
    }

    private static native int getFdSanErrorLevelNative();

    private static native int setFdSanErrorLevelNative(int i);
}
