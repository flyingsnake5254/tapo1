package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.jvm.internal.j;
import kotlin.k;
import kotlin.p;
import kotlinx.coroutines.internal.s;
import kotlinx.coroutines.internal.t;
import kotlinx.coroutines.internal.x;

/* compiled from: Dispatched.kt */
/* loaded from: classes4.dex */
public final class l0 {
    private static final t a = new t("UNDEFINED");

    public static final /* synthetic */ t a() {
        return a;
    }

    public static final <T> void b(m0<? super T> dispatch, int i) {
        j.f(dispatch, "$this$dispatch");
        c<? super T> d2 = dispatch.d();
        if (!s1.b(i) || !(d2 instanceof j0) || s1.a(i) != s1.a(dispatch.f16512f)) {
            c(dispatch, d2, i);
            return;
        }
        y yVar = ((j0) d2).z;
        f context = d2.getContext();
        if (yVar.isDispatchNeeded(context)) {
            yVar.dispatch(context, dispatch);
        } else {
            h(dispatch);
        }
    }

    public static final <T> void c(m0<? super T> resume, c<? super T> delegate, int i) {
        j.f(resume, "$this$resume");
        j.f(delegate, "delegate");
        Object j = resume.j();
        Throwable e2 = resume.e(j);
        if (e2 != null) {
            if (!(delegate instanceof m0)) {
                e2 = s.k(e2, delegate);
            }
            s1.f(delegate, e2, i);
            return;
        }
        s1.c(delegate, resume.g(j), i);
    }

    public static final <T> void d(c<? super T> resumeCancellable, T t) {
        boolean z;
        j.f(resumeCancellable, "$this$resumeCancellable");
        if (resumeCancellable instanceof j0) {
            j0 j0Var = (j0) resumeCancellable;
            if (j0Var.z.isDispatchNeeded(j0Var.getContext())) {
                j0Var.q = t;
                j0Var.f16512f = 1;
                j0Var.z.dispatch(j0Var.getContext(), j0Var);
                return;
            }
            q0 a2 = x1.f16573b.a();
            if (a2.A()) {
                j0Var.q = t;
                j0Var.f16512f = 1;
                a2.w(j0Var);
                return;
            }
            a2.y(true);
            try {
                d1 d1Var = (d1) j0Var.getContext().get(d1.h);
                if (d1Var == null || d1Var.isActive()) {
                    z = false;
                } else {
                    CancellationException i = d1Var.i();
                    Result.a aVar = Result.Companion;
                    j0Var.resumeWith(Result.m1constructorimpl(k.a(i)));
                    z = true;
                }
                if (!z) {
                    f context = j0Var.getContext();
                    Object c2 = x.c(context, j0Var.y);
                    c<T> cVar = j0Var.p0;
                    Result.a aVar2 = Result.Companion;
                    cVar.resumeWith(Result.m1constructorimpl(t));
                    p pVar = p.a;
                    x.a(context, c2);
                }
                do {
                } while (a2.C());
            } finally {
                try {
                    return;
                } finally {
                }
            }
            return;
        }
        Result.a aVar3 = Result.Companion;
        resumeCancellable.resumeWith(Result.m1constructorimpl(t));
    }

    public static final <T> void e(c<? super T> resumeCancellableWithException, Throwable exception) {
        j.f(resumeCancellableWithException, "$this$resumeCancellableWithException");
        j.f(exception, "exception");
        if (resumeCancellableWithException instanceof j0) {
            j0 j0Var = (j0) resumeCancellableWithException;
            f context = j0Var.p0.getContext();
            boolean z = false;
            r rVar = new r(exception, false, 2, null);
            if (j0Var.z.isDispatchNeeded(context)) {
                j0Var.q = new r(exception, false, 2, null);
                j0Var.f16512f = 1;
                j0Var.z.dispatch(context, j0Var);
                return;
            }
            q0 a2 = x1.f16573b.a();
            if (a2.A()) {
                j0Var.q = rVar;
                j0Var.f16512f = 1;
                a2.w(j0Var);
                return;
            }
            a2.y(true);
            try {
                d1 d1Var = (d1) j0Var.getContext().get(d1.h);
                if (d1Var != null && !d1Var.isActive()) {
                    CancellationException i = d1Var.i();
                    Result.a aVar = Result.Companion;
                    j0Var.resumeWith(Result.m1constructorimpl(k.a(i)));
                    z = true;
                }
                if (!z) {
                    f context2 = j0Var.getContext();
                    Object c2 = x.c(context2, j0Var.y);
                    c<T> cVar = j0Var.p0;
                    Result.a aVar2 = Result.Companion;
                    cVar.resumeWith(Result.m1constructorimpl(k.a(s.k(exception, cVar))));
                    p pVar = p.a;
                    x.a(context2, c2);
                }
                do {
                } while (a2.C());
            } finally {
                try {
                    return;
                } finally {
                }
            }
            return;
        }
        Result.a aVar3 = Result.Companion;
        resumeCancellableWithException.resumeWith(Result.m1constructorimpl(k.a(s.k(exception, resumeCancellableWithException))));
    }

    public static final <T> void f(c<? super T> resumeDirect, T t) {
        j.f(resumeDirect, "$this$resumeDirect");
        if (resumeDirect instanceof j0) {
            c<T> cVar = ((j0) resumeDirect).p0;
            Result.a aVar = Result.Companion;
            cVar.resumeWith(Result.m1constructorimpl(t));
            return;
        }
        Result.a aVar2 = Result.Companion;
        resumeDirect.resumeWith(Result.m1constructorimpl(t));
    }

    public static final <T> void g(c<? super T> resumeDirectWithException, Throwable exception) {
        j.f(resumeDirectWithException, "$this$resumeDirectWithException");
        j.f(exception, "exception");
        if (resumeDirectWithException instanceof j0) {
            c<T> cVar = ((j0) resumeDirectWithException).p0;
            Result.a aVar = Result.Companion;
            cVar.resumeWith(Result.m1constructorimpl(k.a(s.k(exception, cVar))));
            return;
        }
        Result.a aVar2 = Result.Companion;
        resumeDirectWithException.resumeWith(Result.m1constructorimpl(k.a(s.k(exception, resumeDirectWithException))));
    }

    private static final void h(m0<?> m0Var) {
        q0 a2 = x1.f16573b.a();
        if (a2.A()) {
            a2.w(m0Var);
            return;
        }
        a2.y(true);
        try {
            c(m0Var, m0Var.d(), 3);
            do {
            } while (a2.C());
        } finally {
            try {
            } finally {
            }
        }
    }

    public static final boolean i(j0<? super p> yieldUndispatched) {
        j.f(yieldUndispatched, "$this$yieldUndispatched");
        p pVar = p.a;
        q0 a2 = x1.f16573b.a();
        if (a2.B()) {
            return false;
        }
        if (a2.A()) {
            yieldUndispatched.q = pVar;
            yieldUndispatched.f16512f = 1;
            a2.w(yieldUndispatched);
            return true;
        }
        a2.y(true);
        try {
            yieldUndispatched.run();
            do {
            } while (a2.C());
        } finally {
            try {
                return false;
            } finally {
            }
        }
        return false;
    }
}
