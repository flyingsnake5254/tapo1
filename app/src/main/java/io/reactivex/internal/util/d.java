package io.reactivex.internal.util;

import io.reactivex.e0.c;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.h0.a.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.j0.a;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: EndConsumerHelper.java */
/* loaded from: classes4.dex */
public final class d {
    public static String a(String str) {
        return "It is not allowed to subscribe with a(n) " + str + " multiple times. Please create a fresh instance of " + str + " and subscribe that to the target source instead.";
    }

    public static void b(Class<?> cls) {
        a.r(new ProtocolViolationException(a(cls.getName())));
    }

    public static boolean c(AtomicReference<c> atomicReference, c cVar, Class<?> cls) {
        b.e(cVar, "next is null");
        if (atomicReference.compareAndSet(null, cVar)) {
            return true;
        }
        cVar.dispose();
        if (atomicReference.get() == DisposableHelper.DISPOSED) {
            return false;
        }
        b(cls);
        return false;
    }
}
