package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.g0;

/* compiled from: FlowExceptions.kt */
/* loaded from: classes4.dex */
public final class ChildCancelledException extends CancellationException {
    public ChildCancelledException() {
        super("Child of the scoped flow was cancelled");
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        if (g0.c()) {
            super.fillInStackTrace();
        }
        return this;
    }
}
