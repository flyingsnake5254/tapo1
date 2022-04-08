package com.google.android.datatransport.h;

import com.google.android.datatransport.h.u.a.b;
import com.google.android.datatransport.h.u.a.d;
import java.util.concurrent.Executor;

/* compiled from: ExecutionModule_ExecutorFactory.java */
/* loaded from: classes.dex */
public final class k implements b<Executor> {

    /* compiled from: ExecutionModule_ExecutorFactory.java */
    /* loaded from: classes.dex */
    private static final class a {
        private static final k a = new k();
    }

    public static k a() {
        return a.a;
    }

    public static Executor b() {
        return (Executor) d.c(j.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: c */
    public Executor get() {
        return b();
    }
}
