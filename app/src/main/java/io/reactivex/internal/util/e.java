package io.reactivex.internal.util;

import com.tplink.libtpmediastatistics.SSLClient;
import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ExceptionHelper.java */
/* loaded from: classes4.dex */
public final class e {
    public static final Throwable a = new a();

    /* compiled from: ExceptionHelper.java */
    /* loaded from: classes4.dex */
    static final class a extends Throwable {
        a() {
            super("No further exceptions");
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    public static <T> boolean a(AtomicReference<Throwable> atomicReference, Throwable th) {
        Throwable th2;
        do {
            th2 = atomicReference.get();
            if (th2 == a) {
                return false;
            }
        } while (!atomicReference.compareAndSet(th2, th2 == null ? th : new CompositeException(th2, th)));
        return true;
    }

    public static <T> Throwable b(AtomicReference<Throwable> atomicReference) {
        Throwable th = atomicReference.get();
        Throwable th2 = a;
        return th != th2 ? atomicReference.getAndSet(th2) : th;
    }

    public static <E extends Throwable> Exception c(Throwable th) throws Throwable {
        if (th instanceof Exception) {
            return (Exception) th;
        }
        throw th;
    }

    public static String d(long j, TimeUnit timeUnit) {
        return "The source did not signal an event for " + j + SSLClient.WHITE_SPACE + timeUnit.toString().toLowerCase() + " and has been terminated.";
    }

    public static RuntimeException e(Throwable th) {
        if (th instanceof Error) {
            throw ((Error) th);
        } else if (th instanceof RuntimeException) {
            return (RuntimeException) th;
        } else {
            return new RuntimeException(th);
        }
    }
}
