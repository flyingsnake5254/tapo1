package com.airbnb.lottie.model;

/* compiled from: Marker.java */
/* loaded from: classes.dex */
public class g {
    private static String a = "\r";

    /* renamed from: b  reason: collision with root package name */
    private final String f1017b;

    /* renamed from: c  reason: collision with root package name */
    public final float f1018c;

    /* renamed from: d  reason: collision with root package name */
    public final float f1019d;

    public g(String str, float f2, float f3) {
        this.f1017b = str;
        this.f1019d = f3;
        this.f1018c = f2;
    }

    public boolean a(String str) {
        if (this.f1017b.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.f1017b.endsWith(a)) {
            String str2 = this.f1017b;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
