package io.reactivex.internal.operators.observable;

import io.reactivex.h0.b.g;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.q;
import io.reactivex.v;

/* compiled from: ObservableEmpty.java */
/* loaded from: classes4.dex */
public final class o extends q<Object> implements g<Object> {

    /* renamed from: c  reason: collision with root package name */
    public static final q<Object> f16051c = new o();

    private o() {
    }

    @Override // io.reactivex.q
    protected void K0(v<? super Object> vVar) {
        EmptyDisposable.complete(vVar);
    }

    @Override // io.reactivex.h0.b.g, java.util.concurrent.Callable
    public Object call() {
        return null;
    }
}
