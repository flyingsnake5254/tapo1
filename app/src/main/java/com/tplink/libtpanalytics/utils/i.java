package com.tplink.libtpanalytics.utils;

import b.d.w.c.a;
import com.tplink.libtpanalytics.database.d.b;

/* compiled from: TPALog.java */
/* loaded from: classes3.dex */
public class i {
    public static boolean a = true;

    public static void a(String str) {
        if (a) {
            a.c("TPA", str);
        }
    }

    public static void b(String str) {
        if (a) {
            a.e("TPA", str);
        }
    }

    public static void c(String str) {
        if (a) {
            a.i("TPA", str);
        }
    }

    public static void d(b bVar) {
        c(bVar.f() + " : " + bVar.d());
    }
}
