package com.tplink.libtpanalytics.utils;

import android.content.Context;

/* compiled from: TPASharedPreferences.java */
/* loaded from: classes3.dex */
public class j extends k {

    /* renamed from: c  reason: collision with root package name */
    private static j f12010c;

    private j(Context context, String str) {
        super(context, str);
    }

    public static j g(Context context) {
        if (f12010c == null) {
            synchronized (j.class) {
                if (f12010c == null) {
                    f12010c = new j(context, "tpa_sp");
                }
            }
        }
        return f12010c;
    }

    public long e() {
        return a("aes_generate_time", -1L);
    }

    public String f() {
        return b("app_version", "");
    }

    public String h() {
        return b("os_version", "");
    }

    public String i() {
        return b("uuid", "");
    }

    public void j(long j) {
        c("aes_generate_time", j);
    }

    public void k(String str) {
        d("app_version", str);
    }

    public void l(String str) {
        d("os_version", str);
    }

    public void m(String str) {
        d("uuid", str);
    }
}
