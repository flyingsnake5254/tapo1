package com.hannesdorfmann.mosby3.mvi;

import io.reactivex.m0.g;
import io.reactivex.observers.b;

/* compiled from: DisposableIntentObserver.java */
/* loaded from: classes2.dex */
class a<I> extends b<I> {

    /* renamed from: d  reason: collision with root package name */
    private final g<I> f5072d;

    public a(g<I> gVar) {
        this.f5072d = gVar;
    }

    @Override // io.reactivex.v
    public void onComplete() {
        this.f5072d.onComplete();
    }

    @Override // io.reactivex.v
    public void onError(Throwable th) {
        throw new IllegalStateException("View intents must not throw errors", th);
    }

    @Override // io.reactivex.v
    public void onNext(I i) {
        this.f5072d.onNext(i);
    }
}
