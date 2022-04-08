package kotlinx.coroutines.d2;

import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.k;
import kotlin.p;
import kotlinx.coroutines.l0;

/* compiled from: Cancellable.kt */
/* loaded from: classes4.dex */
public final class a {
    public static final <T> void a(l<? super c<? super T>, ? extends Object> startCoroutineCancellable, c<? super T> completion) {
        j.f(startCoroutineCancellable, "$this$startCoroutineCancellable");
        j.f(completion, "completion");
        try {
            l0.d(kotlin.coroutines.intrinsics.a.c(kotlin.coroutines.intrinsics.a.a(startCoroutineCancellable, completion)), p.a);
        } catch (Throwable th) {
            Result.a aVar = Result.Companion;
            completion.resumeWith(Result.m1constructorimpl(k.a(th)));
        }
    }

    public static final <R, T> void b(kotlin.jvm.b.p<? super R, ? super c<? super T>, ? extends Object> startCoroutineCancellable, R r, c<? super T> completion) {
        j.f(startCoroutineCancellable, "$this$startCoroutineCancellable");
        j.f(completion, "completion");
        try {
            l0.d(kotlin.coroutines.intrinsics.a.c(kotlin.coroutines.intrinsics.a.b(startCoroutineCancellable, r, completion)), p.a);
        } catch (Throwable th) {
            Result.a aVar = Result.Companion;
            completion.resumeWith(Result.m1constructorimpl(k.a(th)));
        }
    }
}
