package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* compiled from: Executors.java */
/* loaded from: classes.dex */
public final class d {
    private static final Executor a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final Executor f1770b = new b();

    /* compiled from: Executors.java */
    /* loaded from: classes.dex */
    class a implements Executor {
        a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            j.v(runnable);
        }
    }

    /* compiled from: Executors.java */
    /* loaded from: classes.dex */
    class b implements Executor {
        b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            runnable.run();
        }
    }

    public static Executor a() {
        return f1770b;
    }

    public static Executor b() {
        return a;
    }
}
