package com.google.android.datatransport.h.x.j;

import com.google.android.datatransport.h.u.a.b;
import com.google.android.datatransport.h.u.a.d;

/* compiled from: EventStoreModule_StoreConfigFactory.java */
/* loaded from: classes.dex */
public final class d0 implements b<z> {

    /* compiled from: EventStoreModule_StoreConfigFactory.java */
    /* loaded from: classes.dex */
    private static final class a {
        private static final d0 a = new d0();
    }

    public static d0 a() {
        return a.a;
    }

    public static z c() {
        return (z) d.c(a0.c(), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: b */
    public z get() {
        return c();
    }
}
