package kotlinx.coroutines;

import kotlin.Result;
import kotlin.jvm.internal.j;
import kotlin.k;

/* compiled from: CompletedExceptionally.kt */
/* loaded from: classes4.dex */
public final class s {
    public static final <T> Object a(Object obj) {
        if (Result.m8isSuccessimpl(obj)) {
            k.b(obj);
            return obj;
        }
        Throwable th = Result.m4exceptionOrNullimpl(obj);
        if (th == null) {
            j.n();
        }
        return new r(th, false, 2, null);
    }
}
