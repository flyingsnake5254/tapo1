package com.tplink.libtpnetwork.Utils;

/* compiled from: ValueUtils.java */
/* loaded from: classes3.dex */
public class d0 {
    public static <T> boolean a(T t, T t2) {
        if (t == null && t2 == null) {
            return true;
        }
        if (t == null || t2 == null) {
            return false;
        }
        return t.equals(t2);
    }

    public static <T> T b(T t, T t2) {
        return t == null ? t2 : t;
    }
}
