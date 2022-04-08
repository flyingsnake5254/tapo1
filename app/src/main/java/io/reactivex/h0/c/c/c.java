package io.reactivex.h0.c.c;

import io.reactivex.exceptions.a;
import io.reactivex.h0.a.b;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.x;
import io.reactivex.z;
import java.util.concurrent.Callable;

/* compiled from: SingleError.java */
/* loaded from: classes4.dex */
public final class c<T> extends x<T> {

    /* renamed from: c  reason: collision with root package name */
    final Callable<? extends Throwable> f15733c;

    public c(Callable<? extends Throwable> callable) {
        this.f15733c = callable;
    }

    @Override // io.reactivex.x
    protected void l(z<? super T> zVar) {
        Throwable th;
        try {
            th = (Throwable) b.e(this.f15733c.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th2) {
            th = th2;
            a.b(th);
        }
        EmptyDisposable.error(th, zVar);
    }
}
