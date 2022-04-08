package io.reactivex.internal.operators.observable;

import io.reactivex.h0.b.g;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.q;
import io.reactivex.v;

/* compiled from: ObservableJust.java */
/* loaded from: classes4.dex */
public final class h0<T> extends q<T> implements g<T> {

    /* renamed from: c  reason: collision with root package name */
    private final T f15994c;

    public h0(T t) {
        this.f15994c = t;
    }

    @Override // io.reactivex.q
    protected void K0(v<? super T> vVar) {
        ObservableScalarXMap.ScalarDisposable scalarDisposable = new ObservableScalarXMap.ScalarDisposable(vVar, this.f15994c);
        vVar.onSubscribe(scalarDisposable);
        scalarDisposable.run();
    }

    @Override // io.reactivex.h0.b.g, java.util.concurrent.Callable
    public T call() {
        return this.f15994c;
    }
}
