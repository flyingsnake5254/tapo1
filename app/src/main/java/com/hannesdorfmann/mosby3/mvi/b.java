package com.hannesdorfmann.mosby3.mvi;

/* compiled from: DisposableViewStateObserver.java */
/* loaded from: classes2.dex */
class b<VS> extends io.reactivex.observers.b<VS> {

    /* renamed from: d  reason: collision with root package name */
    private final io.reactivex.m0.b<VS> f5073d;

    public b(io.reactivex.m0.b<VS> bVar) {
        this.f5073d = bVar;
    }

    @Override // io.reactivex.v
    public void onComplete() {
    }

    @Override // io.reactivex.v
    public void onError(Throwable th) {
        throw new IllegalStateException("ViewState observable must not reach error state - onError()", th);
    }

    @Override // io.reactivex.v
    public void onNext(VS vs) {
        this.f5073d.onNext(vs);
    }
}
