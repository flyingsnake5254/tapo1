package io.reactivex.internal.util;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class AtomicThrowable extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    public boolean addThrowable(Throwable th) {
        return e.a(this, th);
    }

    public boolean isTerminated() {
        return get() == e.a;
    }

    public Throwable terminate() {
        return e.b(this);
    }
}
