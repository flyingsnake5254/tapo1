package com.tplink.libtpanalytics.core.define;

/* compiled from: TASessionManager.java */
/* loaded from: classes3.dex */
public class f {
    private static f a;

    /* renamed from: b  reason: collision with root package name */
    private int f11962b = 0;

    private f() {
    }

    public static f a() {
        if (a == null) {
            synchronized (f.class) {
                if (a == null) {
                    a = new f();
                }
            }
        }
        return a;
    }

    public int b() {
        return this.f11962b;
    }

    public void c() {
        this.f11962b = (int) (System.currentTimeMillis() / 1000);
    }
}
