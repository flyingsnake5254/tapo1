package kotlinx.coroutines;

import kotlin.jvm.internal.j;

/* compiled from: Exceptions.common.kt */
/* loaded from: classes4.dex */
public final class CoroutinesInternalError extends Error {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutinesInternalError(String message, Throwable cause) {
        super(message, cause);
        j.f(message, "message");
        j.f(cause, "cause");
    }
}
