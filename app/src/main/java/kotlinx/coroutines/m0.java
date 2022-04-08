package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.TypeCastException;
import kotlin.b;
import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.jvm.internal.j;
import kotlin.k;
import kotlin.p;
import kotlinx.coroutines.internal.s;
import kotlinx.coroutines.internal.x;
import kotlinx.coroutines.scheduling.h;
import kotlinx.coroutines.scheduling.i;

/* compiled from: Dispatched.kt */
/* loaded from: classes4.dex */
public abstract class m0<T> extends h {

    /* renamed from: f  reason: collision with root package name */
    public int f16512f;

    public m0(int i) {
        this.f16512f = i;
    }

    public void c(Object obj, Throwable cause) {
        j.f(cause, "cause");
    }

    public abstract c<T> d();

    public final Throwable e(Object obj) {
        if (!(obj instanceof r)) {
            obj = null;
        }
        r rVar = (r) obj;
        if (rVar != null) {
            return rVar.f16526b;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T g(Object obj) {
        return obj;
    }

    public final void i(Throwable th, Throwable th2) {
        if (th != null || th2 != null) {
            if (!(th == null || th2 == null)) {
                b.a(th, th2);
            }
            if (th == null) {
                th = th2;
            }
            String str = "Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers";
            if (th == null) {
                j.n();
            }
            a0.a(d().getContext(), new CoroutinesInternalError(str, th));
        }
    }

    public abstract Object j();

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        Object obj2;
        i iVar = this.f16547d;
        try {
            c<T> d2 = d();
            if (d2 != null) {
                j0 j0Var = (j0) d2;
                c<T> cVar = j0Var.p0;
                f context = cVar.getContext();
                Object j = j();
                Object c2 = x.c(context, j0Var.y);
                Throwable e2 = e(j);
                d1 d1Var = s1.a(this.f16512f) ? (d1) context.get(d1.h) : null;
                if (e2 == null && d1Var != null && !d1Var.isActive()) {
                    CancellationException i = d1Var.i();
                    c(j, i);
                    Result.a aVar = Result.Companion;
                    cVar.resumeWith(Result.m1constructorimpl(k.a(s.k(i, cVar))));
                } else if (e2 != null) {
                    Result.a aVar2 = Result.Companion;
                    cVar.resumeWith(Result.m1constructorimpl(k.a(s.k(e2, cVar))));
                } else {
                    T g = g(j);
                    Result.a aVar3 = Result.Companion;
                    cVar.resumeWith(Result.m1constructorimpl(g));
                }
                p pVar = p.a;
                x.a(context, c2);
                try {
                    Result.a aVar4 = Result.Companion;
                    iVar.c();
                    obj2 = Result.m1constructorimpl(pVar);
                } catch (Throwable th) {
                    Result.a aVar5 = Result.Companion;
                    obj2 = Result.m1constructorimpl(k.a(th));
                }
                i(null, Result.m4exceptionOrNullimpl(obj2));
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<T>");
        } catch (Throwable th2) {
            try {
                Result.a aVar6 = Result.Companion;
                iVar.c();
                obj = Result.m1constructorimpl(p.a);
            } catch (Throwable th3) {
                Result.a aVar7 = Result.Companion;
                obj = Result.m1constructorimpl(k.a(th3));
            }
            i(th2, Result.m4exceptionOrNullimpl(obj));
        }
    }
}
