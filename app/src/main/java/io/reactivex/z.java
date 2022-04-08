package io.reactivex;

import io.reactivex.e0.c;

/* compiled from: SingleObserver.java */
/* loaded from: classes4.dex */
public interface z<T> {
    void onError(Throwable th);

    void onSubscribe(c cVar);

    void onSuccess(T t);
}
