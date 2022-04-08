package kotlin;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: Standard.kt */
/* loaded from: classes4.dex */
public final class NotImplementedError extends Error {
    public NotImplementedError() {
        this(null, 1, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotImplementedError(String message) {
        super(message);
        j.e(message, "message");
    }

    public /* synthetic */ NotImplementedError(String str, int i, f fVar) {
        this((i & 1) != 0 ? "An operation is not implemented." : str);
    }
}
