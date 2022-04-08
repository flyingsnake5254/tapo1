package io.reactivex.internal.disposables;

import io.reactivex.e0.c;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes4.dex */
public final class ArrayCompositeDisposable extends AtomicReferenceArray<c> implements c {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeDisposable(int i) {
        super(i);
    }

    @Override // io.reactivex.e0.c
    public void dispose() {
        c andSet;
        if (get(0) != DisposableHelper.DISPOSED) {
            int length = length();
            for (int i = 0; i < length; i++) {
                c cVar = get(i);
                DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                if (!(cVar == disposableHelper || (andSet = getAndSet(i, disposableHelper)) == disposableHelper || andSet == null)) {
                    andSet.dispose();
                }
            }
        }
    }

    @Override // io.reactivex.e0.c
    public boolean isDisposed() {
        return get(0) == DisposableHelper.DISPOSED;
    }

    public c replaceResource(int i, c cVar) {
        c cVar2;
        do {
            cVar2 = get(i);
            if (cVar2 == DisposableHelper.DISPOSED) {
                cVar.dispose();
                return null;
            }
        } while (!compareAndSet(i, cVar2, cVar));
        return cVar2;
    }

    public boolean setResource(int i, c cVar) {
        c cVar2;
        do {
            cVar2 = get(i);
            if (cVar2 == DisposableHelper.DISPOSED) {
                cVar.dispose();
                return false;
            }
        } while (!compareAndSet(i, cVar2, cVar));
        if (cVar2 == null) {
            return true;
        }
        cVar2.dispose();
        return true;
    }
}
