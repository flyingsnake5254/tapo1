package io.reactivex.e0;

import io.reactivex.h0.a.b;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ReferenceDisposable.java */
/* loaded from: classes4.dex */
abstract class e<T> extends AtomicReference<T> implements c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public e(T t) {
        super(b.e(t, "value is null"));
    }

    protected abstract void a(T t);

    @Override // io.reactivex.e0.c
    public final void dispose() {
        T andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            a(andSet);
        }
    }

    @Override // io.reactivex.e0.c
    public final boolean isDisposed() {
        return get() == null;
    }
}
