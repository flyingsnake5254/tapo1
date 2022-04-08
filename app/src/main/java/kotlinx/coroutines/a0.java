package kotlinx.coroutines;

import kotlin.b;
import kotlin.coroutines.f;
import kotlin.jvm.internal.j;

/* compiled from: CoroutineExceptionHandler.kt */
/* loaded from: classes4.dex */
public final class a0 {
    public static final void a(f context, Throwable exception) {
        j.f(context, "context");
        j.f(exception, "exception");
        try {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) context.get(CoroutineExceptionHandler.g);
            if (coroutineExceptionHandler != null) {
                coroutineExceptionHandler.handleException(context, exception);
            } else {
                z.a(context, exception);
            }
        } catch (Throwable th) {
            z.a(context, b(exception, th));
        }
    }

    public static final Throwable b(Throwable originalException, Throwable thrownException) {
        j.f(originalException, "originalException");
        j.f(thrownException, "thrownException");
        if (originalException == thrownException) {
            return originalException;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", thrownException);
        b.a(runtimeException, originalException);
        return runtimeException;
    }
}
