package io.reactivex.internal.subscriptions;

import e.b.b;
import io.reactivex.h0.b.f;

/* loaded from: classes4.dex */
public enum EmptySubscription implements f<Object> {
    INSTANCE;

    public static void complete(b<?> bVar) {
        bVar.onSubscribe(INSTANCE);
        bVar.onComplete();
    }

    public static void error(Throwable th, b<?> bVar) {
        bVar.onSubscribe(INSTANCE);
        bVar.onError(th);
    }

    @Override // e.b.c
    public void cancel() {
    }

    @Override // io.reactivex.h0.b.i
    public void clear() {
    }

    @Override // io.reactivex.h0.b.i
    public boolean isEmpty() {
        return true;
    }

    @Override // io.reactivex.h0.b.i
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.h0.b.i
    public Object poll() {
        return null;
    }

    @Override // e.b.c
    public void request(long j) {
        SubscriptionHelper.validate(j);
    }

    @Override // io.reactivex.h0.b.e
    public int requestFusion(int i) {
        return i & 2;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EmptySubscription";
    }

    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
