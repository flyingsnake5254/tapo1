package io.reactivex;

import io.reactivex.e0.c;

/* compiled from: Observer.java */
/* loaded from: classes4.dex */
public interface v<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(c cVar);
}
