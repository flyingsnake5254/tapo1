package io.reactivex.d0.a;

import io.reactivex.g0.j;
import io.reactivex.w;
import java.util.Objects;
import java.util.concurrent.Callable;

/* compiled from: RxAndroidPlugins.java */
/* loaded from: classes4.dex */
public final class a {
    private static volatile j<Callable<w>, w> a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile j<w, w> f15621b;

    static <T, R> R a(j<T, R> jVar, T t) {
        try {
            return jVar.apply(t);
        } catch (Throwable th) {
            throw io.reactivex.exceptions.a.a(th);
        }
    }

    static w b(j<Callable<w>, w> jVar, Callable<w> callable) {
        w wVar = (w) a(jVar, callable);
        Objects.requireNonNull(wVar, "Scheduler Callable returned null");
        return wVar;
    }

    static w c(Callable<w> callable) {
        try {
            w call = callable.call();
            if (call != null) {
                return call;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw io.reactivex.exceptions.a.a(th);
        }
    }

    public static w d(Callable<w> callable) {
        Objects.requireNonNull(callable, "scheduler == null");
        j<Callable<w>, w> jVar = a;
        if (jVar == null) {
            return c(callable);
        }
        return b(jVar, callable);
    }

    public static w e(w wVar) {
        Objects.requireNonNull(wVar, "scheduler == null");
        j<w, w> jVar = f15621b;
        return jVar == null ? wVar : (w) a(jVar, wVar);
    }
}
