package kotlin.coroutines;

import kotlin.Result;
import kotlin.coroutines.intrinsics.a;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: Continuation.kt */
/* loaded from: classes4.dex */
public final class e {
    public static final <T> void a(l<? super c<? super T>, ? extends Object> startCoroutine, c<? super T> completion) {
        j.e(startCoroutine, "$this$startCoroutine");
        j.e(completion, "completion");
        c c2 = a.c(a.a(startCoroutine, completion));
        p pVar = p.a;
        Result.a aVar = Result.Companion;
        c2.resumeWith(Result.m1constructorimpl(pVar));
    }

    public static final <R, T> void b(kotlin.jvm.b.p<? super R, ? super c<? super T>, ? extends Object> startCoroutine, R r, c<? super T> completion) {
        j.e(startCoroutine, "$this$startCoroutine");
        j.e(completion, "completion");
        c c2 = a.c(a.b(startCoroutine, r, completion));
        p pVar = p.a;
        Result.a aVar = Result.Companion;
        c2.resumeWith(Result.m1constructorimpl(pVar));
    }
}
