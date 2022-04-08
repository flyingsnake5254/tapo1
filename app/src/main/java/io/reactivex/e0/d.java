package io.reactivex.e0;

import io.reactivex.h0.a.a;
import io.reactivex.h0.a.b;
import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: Disposables.java */
/* loaded from: classes4.dex */
public final class d {
    public static c a() {
        return EmptyDisposable.INSTANCE;
    }

    public static c b() {
        return d(a.f15634b);
    }

    public static c c(io.reactivex.g0.a aVar) {
        b.e(aVar, "run is null");
        return new a(aVar);
    }

    public static c d(Runnable runnable) {
        b.e(runnable, "run is null");
        return new f(runnable);
    }
}
