package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.g0.a;
import io.reactivex.g0.g;
import io.reactivex.internal.observers.d;
import io.reactivex.q;
import io.reactivex.v;

/* compiled from: ObservableDoOnLifecycle.java */
/* loaded from: classes4.dex */
public final class l<T> extends a<T, T> {

    /* renamed from: d  reason: collision with root package name */
    private final g<? super c> f16026d;

    /* renamed from: f  reason: collision with root package name */
    private final a f16027f;

    public l(q<T> qVar, g<? super c> gVar, a aVar) {
        super(qVar);
        this.f16026d = gVar;
        this.f16027f = aVar;
    }

    @Override // io.reactivex.q
    protected void K0(v<? super T> vVar) {
        this.f15892c.a(new d(vVar, this.f16026d, this.f16027f));
    }
}
