package io.reactivex.internal.observers;

/* compiled from: InnerQueuedObserverSupport.java */
/* loaded from: classes4.dex */
public interface e<T> {
    void a();

    void b(InnerQueuedObserver<T> innerQueuedObserver, Throwable th);

    void c(InnerQueuedObserver<T> innerQueuedObserver);

    void d(InnerQueuedObserver<T> innerQueuedObserver, T t);
}
