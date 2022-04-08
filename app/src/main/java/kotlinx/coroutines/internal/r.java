package kotlinx.coroutines.internal;

import kotlin.coroutines.c;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.a;

/* compiled from: Scopes.kt */
/* loaded from: classes4.dex */
public final class r {
    public static final Throwable a(a<?> tryRecover, Throwable exception) {
        c<T> cVar;
        j.f(tryRecover, "$this$tryRecover");
        j.f(exception, "exception");
        if (!(tryRecover instanceof q)) {
            tryRecover = null;
        }
        q qVar = (q) tryRecover;
        return (qVar == null || (cVar = qVar.q) == 0) ? exception : s.k(exception, cVar);
    }
}
