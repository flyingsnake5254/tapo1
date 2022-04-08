package com.tplink.iot.k.c;

import android.util.Log;

/* compiled from: AESEncryptUtil.java */
/* loaded from: classes2.dex */
public class a {
    private static final String a = a.class.getSimpleName() + " --> ";

    /* renamed from: b  reason: collision with root package name */
    private static com.tplink.libtputility.security.a f8016b;

    public a(String str, String str2) {
        f8016b = new com.tplink.libtputility.security.a(str, str2);
    }

    private void c(Exception exc) {
        exc.printStackTrace();
        String str = a;
        Log.e(str, str + exc);
    }

    public String a(String str) {
        try {
            return f8016b.a(str);
        } catch (Exception e2) {
            c(e2);
            return null;
        }
    }

    public String b(String str) {
        try {
            return f8016b.c(str);
        } catch (Exception e2) {
            c(e2);
            return null;
        }
    }
}
