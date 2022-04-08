package io.reactivex;

/* compiled from: Emitter.java */
/* loaded from: classes4.dex */
public interface g<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);
}
