package com.tplink.libmediakit.jniinterface;

/* loaded from: classes3.dex */
public class GenKey {
    static {
        System.loadLibrary("tpgenkey");
    }

    public static String a() {
        return generateDefaultPsw();
    }

    public static String b() {
        return generateDefaultUsername();
    }

    private static native String generateDefaultPsw();

    private static native String generateDefaultUsername();
}
