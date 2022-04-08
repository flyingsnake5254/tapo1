package io.reactivex.internal.disposables;

import io.reactivex.e0.c;
import io.reactivex.exceptions.a;
import io.reactivex.g0.f;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class CancellableDisposable extends AtomicReference<f> implements c {
    private static final long serialVersionUID = 5718521705281392066L;

    public CancellableDisposable(f fVar) {
        super(fVar);
    }

    @Override // io.reactivex.e0.c
    public void dispose() {
        f andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            try {
                andSet.cancel();
            } catch (Exception e2) {
                a.b(e2);
                io.reactivex.j0.a.r(e2);
            }
        }
    }

    @Override // io.reactivex.e0.c
    public boolean isDisposed() {
        return get() == null;
    }
}
