package io.reactivex.internal.disposables;

import io.reactivex.c;
import io.reactivex.h0.b.d;
import io.reactivex.n;
import io.reactivex.v;
import io.reactivex.z;

/* loaded from: classes4.dex */
public enum EmptyDisposable implements d<Object> {
    INSTANCE,
    NEVER;

    public static void complete(v<?> vVar) {
        vVar.onSubscribe(INSTANCE);
        vVar.onComplete();
    }

    public static void error(Throwable th, v<?> vVar) {
        vVar.onSubscribe(INSTANCE);
        vVar.onError(th);
    }

    @Override // io.reactivex.h0.b.i
    public void clear() {
    }

    @Override // io.reactivex.e0.c
    public void dispose() {
    }

    @Override // io.reactivex.e0.c
    public boolean isDisposed() {
        return this == INSTANCE;
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
    public Object poll() throws Exception {
        return null;
    }

    @Override // io.reactivex.h0.b.e
    public int requestFusion(int i) {
        return i & 2;
    }

    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public static void complete(n<?> nVar) {
        nVar.onSubscribe(INSTANCE);
        nVar.onComplete();
    }

    public static void error(Throwable th, c cVar) {
        cVar.onSubscribe(INSTANCE);
        cVar.onError(th);
    }

    public static void complete(c cVar) {
        cVar.onSubscribe(INSTANCE);
        cVar.onComplete();
    }

    public static void error(Throwable th, z<?> zVar) {
        zVar.onSubscribe(INSTANCE);
        zVar.onError(th);
    }

    public static void error(Throwable th, n<?> nVar) {
        nVar.onSubscribe(INSTANCE);
        nVar.onError(th);
    }
}
