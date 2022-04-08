package io.reactivex.internal.operators.flowable;

import e.b.b;
import io.reactivex.f0.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FlowableGroupBy.java */
/* loaded from: classes4.dex */
public final class n<K, T> extends a<K, T> {

    /* renamed from: f  reason: collision with root package name */
    final o<T, K> f15815f;

    protected n(K k, o<T, K> oVar) {
        super(k);
        this.f15815f = oVar;
    }

    public static <T, K> n<K, T> M(K k, int i, FlowableGroupBy$GroupBySubscriber<?, K, T> flowableGroupBy$GroupBySubscriber, boolean z) {
        return new n<>(k, new o(i, flowableGroupBy$GroupBySubscriber, k, z));
    }

    @Override // io.reactivex.h
    protected void H(b<? super T> bVar) {
        this.f15815f.a(bVar);
    }

    public void onComplete() {
        this.f15815f.onComplete();
    }

    public void onError(Throwable th) {
        this.f15815f.onError(th);
    }

    public void onNext(T t) {
        this.f15815f.onNext(t);
    }
}
