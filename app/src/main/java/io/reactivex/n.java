package io.reactivex;

import io.reactivex.e0.c;

/* compiled from: MaybeObserver.java */
/* loaded from: classes4.dex */
public interface n<T> {
    void onComplete();

    void onError(Throwable th);

    void onSubscribe(c cVar);

    void onSuccess(T t);
}
