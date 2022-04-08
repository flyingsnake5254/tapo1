package io.reactivex.internal.observers;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ResumeSingleObserver.java */
/* loaded from: classes4.dex */
public final class j<T> implements z<T> {

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<c> f15761c;

    /* renamed from: d  reason: collision with root package name */
    final z<? super T> f15762d;

    public j(AtomicReference<c> atomicReference, z<? super T> zVar) {
        this.f15761c = atomicReference;
        this.f15762d = zVar;
    }

    @Override // io.reactivex.z
    public void onError(Throwable th) {
        this.f15762d.onError(th);
    }

    @Override // io.reactivex.z
    public void onSubscribe(c cVar) {
        DisposableHelper.replace(this.f15761c, cVar);
    }

    @Override // io.reactivex.z
    public void onSuccess(T t) {
        this.f15762d.onSuccess(t);
    }
}
