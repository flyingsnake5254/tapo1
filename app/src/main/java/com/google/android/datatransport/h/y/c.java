package com.google.android.datatransport.h.y;

import com.google.android.datatransport.h.u.a.b;
import com.google.android.datatransport.h.u.a.d;

/* compiled from: TimeModule_EventClockFactory.java */
/* loaded from: classes.dex */
public final class c implements b<a> {

    /* compiled from: TimeModule_EventClockFactory.java */
    /* loaded from: classes.dex */
    private static final class a {
        private static final c a = new c();
    }

    public static c a() {
        return a.a;
    }

    public static a b() {
        return (a) d.c(b.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: c */
    public a get() {
        return b();
    }
}
