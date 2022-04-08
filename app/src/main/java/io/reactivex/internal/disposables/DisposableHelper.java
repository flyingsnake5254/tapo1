package io.reactivex.internal.disposables;

import io.reactivex.e0.c;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.h0.a.b;
import io.reactivex.j0.a;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public enum DisposableHelper implements c {
    DISPOSED;

    public static boolean dispose(AtomicReference<c> atomicReference) {
        c andSet;
        c cVar = atomicReference.get();
        DisposableHelper disposableHelper = DISPOSED;
        if (cVar == disposableHelper || (andSet = atomicReference.getAndSet(disposableHelper)) == disposableHelper) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.dispose();
        return true;
    }

    public static boolean isDisposed(c cVar) {
        return cVar == DISPOSED;
    }

    public static boolean replace(AtomicReference<c> atomicReference, c cVar) {
        c cVar2;
        do {
            cVar2 = atomicReference.get();
            if (cVar2 == DISPOSED) {
                if (cVar == null) {
                    return false;
                }
                cVar.dispose();
                return false;
            }
        } while (!atomicReference.compareAndSet(cVar2, cVar));
        return true;
    }

    public static void reportDisposableSet() {
        a.r(new ProtocolViolationException("Disposable already set!"));
    }

    public static boolean set(AtomicReference<c> atomicReference, c cVar) {
        c cVar2;
        do {
            cVar2 = atomicReference.get();
            if (cVar2 == DISPOSED) {
                if (cVar == null) {
                    return false;
                }
                cVar.dispose();
                return false;
            }
        } while (!atomicReference.compareAndSet(cVar2, cVar));
        if (cVar2 == null) {
            return true;
        }
        cVar2.dispose();
        return true;
    }

    public static boolean setOnce(AtomicReference<c> atomicReference, c cVar) {
        b.e(cVar, "d is null");
        if (atomicReference.compareAndSet(null, cVar)) {
            return true;
        }
        cVar.dispose();
        if (atomicReference.get() == DISPOSED) {
            return false;
        }
        reportDisposableSet();
        return false;
    }

    public static boolean trySet(AtomicReference<c> atomicReference, c cVar) {
        if (atomicReference.compareAndSet(null, cVar)) {
            return true;
        }
        if (atomicReference.get() != DISPOSED) {
            return false;
        }
        cVar.dispose();
        return false;
    }

    public static boolean validate(c cVar, c cVar2) {
        if (cVar2 == null) {
            a.r(new NullPointerException("next is null"));
            return false;
        } else if (cVar == null) {
            return true;
        } else {
            cVar2.dispose();
            reportDisposableSet();
            return false;
        }
    }

    @Override // io.reactivex.e0.c
    public void dispose() {
    }

    @Override // io.reactivex.e0.c
    public boolean isDisposed() {
        return true;
    }
}
