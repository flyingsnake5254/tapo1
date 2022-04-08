package com.tplink.libtpanalytics.utils;

import com.tplink.libtpanalytics.core.define.e;
import com.tplink.libtpanalytics.database.d.b;
import java.util.Date;

/* compiled from: CommonUtils.java */
/* loaded from: classes3.dex */
public class c {
    public static String a(long j) {
        return "p" + ((int) (((Math.random() * 9.0d) + 1.0d) * 10000.0d)) + j;
    }

    public static void b(b bVar, e eVar) {
        bVar.x(eVar.e().k());
        long time = new Date().getTime();
        bVar.y(time);
        bVar.r(a(time));
        bVar.z(eVar.e().f() == null ? "" : com.tplink.libtpanalytics.utils.l.c.d(eVar.e().f().toLowerCase()));
        bVar.v(eVar.e().j());
        bVar.t(eVar.e().g());
        bVar.n(eVar.e().d());
        bVar.o(2);
    }
}
