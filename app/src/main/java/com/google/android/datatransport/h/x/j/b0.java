package com.google.android.datatransport.h.x.j;

import com.google.android.datatransport.h.u.a.b;
import com.google.android.datatransport.h.u.a.d;

/* compiled from: EventStoreModule_DbNameFactory.java */
/* loaded from: classes.dex */
public final class b0 implements b<String> {

    /* compiled from: EventStoreModule_DbNameFactory.java */
    /* loaded from: classes.dex */
    private static final class a {
        private static final b0 a = new b0();
    }

    public static b0 a() {
        return a.a;
    }

    public static String b() {
        return (String) d.c(a0.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: c */
    public String get() {
        return b();
    }
}
