package kotlinx.coroutines;

import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.j;
import kotlin.k;
import kotlin.p;
import kotlinx.coroutines.internal.s;
import kotlinx.coroutines.internal.x;

/* compiled from: ResumeMode.kt */
/* loaded from: classes4.dex */
public final class s1 {
    public static final boolean a(int i) {
        return i == 1;
    }

    public static final boolean b(int i) {
        return i == 0 || i == 1;
    }

    public static final <T> void c(c<? super T> resumeMode, T t, int i) {
        j.f(resumeMode, "$this$resumeMode");
        if (i == 0) {
            Result.a aVar = Result.Companion;
            resumeMode.resumeWith(Result.m1constructorimpl(t));
        } else if (i == 1) {
            l0.d(resumeMode, t);
        } else if (i == 2) {
            l0.f(resumeMode, t);
        } else if (i == 3) {
            j0 j0Var = (j0) resumeMode;
            f context = j0Var.getContext();
            Object c2 = x.c(context, j0Var.y);
            try {
                c<T> cVar = j0Var.p0;
                Result.a aVar2 = Result.Companion;
                cVar.resumeWith(Result.m1constructorimpl(t));
                p pVar = p.a;
            } finally {
                x.a(context, c2);
            }
        } else if (i != 4) {
            throw new IllegalStateException(("Invalid mode " + i).toString());
        }
    }

    public static final <T> void d(c<? super T> resumeUninterceptedMode, T t, int i) {
        c c2;
        c c3;
        j.f(resumeUninterceptedMode, "$this$resumeUninterceptedMode");
        if (i == 0) {
            c2 = IntrinsicsKt__IntrinsicsJvmKt.c(resumeUninterceptedMode);
            Result.a aVar = Result.Companion;
            c2.resumeWith(Result.m1constructorimpl(t));
        } else if (i == 1) {
            c3 = IntrinsicsKt__IntrinsicsJvmKt.c(resumeUninterceptedMode);
            l0.d(c3, t);
        } else if (i == 2) {
            Result.a aVar2 = Result.Companion;
            resumeUninterceptedMode.resumeWith(Result.m1constructorimpl(t));
        } else if (i == 3) {
            f context = resumeUninterceptedMode.getContext();
            Object c4 = x.c(context, null);
            try {
                Result.a aVar3 = Result.Companion;
                resumeUninterceptedMode.resumeWith(Result.m1constructorimpl(t));
                p pVar = p.a;
            } finally {
                x.a(context, c4);
            }
        } else if (i != 4) {
            throw new IllegalStateException(("Invalid mode " + i).toString());
        }
    }

    public static final <T> void e(c<? super T> resumeUninterceptedWithExceptionMode, Throwable exception, int i) {
        c c2;
        c c3;
        j.f(resumeUninterceptedWithExceptionMode, "$this$resumeUninterceptedWithExceptionMode");
        j.f(exception, "exception");
        if (i == 0) {
            c2 = IntrinsicsKt__IntrinsicsJvmKt.c(resumeUninterceptedWithExceptionMode);
            Result.a aVar = Result.Companion;
            c2.resumeWith(Result.m1constructorimpl(k.a(exception)));
        } else if (i == 1) {
            c3 = IntrinsicsKt__IntrinsicsJvmKt.c(resumeUninterceptedWithExceptionMode);
            l0.e(c3, exception);
        } else if (i == 2) {
            Result.a aVar2 = Result.Companion;
            resumeUninterceptedWithExceptionMode.resumeWith(Result.m1constructorimpl(k.a(exception)));
        } else if (i == 3) {
            f context = resumeUninterceptedWithExceptionMode.getContext();
            Object c4 = x.c(context, null);
            try {
                Result.a aVar3 = Result.Companion;
                resumeUninterceptedWithExceptionMode.resumeWith(Result.m1constructorimpl(k.a(exception)));
                p pVar = p.a;
            } finally {
                x.a(context, c4);
            }
        } else if (i != 4) {
            throw new IllegalStateException(("Invalid mode " + i).toString());
        }
    }

    public static final <T> void f(c<? super T> resumeWithExceptionMode, Throwable exception, int i) {
        j.f(resumeWithExceptionMode, "$this$resumeWithExceptionMode");
        j.f(exception, "exception");
        if (i == 0) {
            Result.a aVar = Result.Companion;
            resumeWithExceptionMode.resumeWith(Result.m1constructorimpl(k.a(exception)));
        } else if (i == 1) {
            l0.e(resumeWithExceptionMode, exception);
        } else if (i == 2) {
            l0.g(resumeWithExceptionMode, exception);
        } else if (i == 3) {
            j0 j0Var = (j0) resumeWithExceptionMode;
            f context = j0Var.getContext();
            Object c2 = x.c(context, j0Var.y);
            try {
                c<T> cVar = j0Var.p0;
                Result.a aVar2 = Result.Companion;
                cVar.resumeWith(Result.m1constructorimpl(k.a(s.k(exception, cVar))));
                p pVar = p.a;
            } finally {
                x.a(context, c2);
            }
        } else if (i != 4) {
            throw new IllegalStateException(("Invalid mode " + i).toString());
        }
    }
}
