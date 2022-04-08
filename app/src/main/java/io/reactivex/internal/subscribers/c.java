package io.reactivex.internal.subscribers;

/* compiled from: InnerQueuedSubscriberSupport.java */
/* loaded from: classes4.dex */
public interface c<T> {
    void a();

    void b(InnerQueuedSubscriber<T> innerQueuedSubscriber, T t);

    void c(InnerQueuedSubscriber<T> innerQueuedSubscriber);

    void d(InnerQueuedSubscriber<T> innerQueuedSubscriber, Throwable th);
}
