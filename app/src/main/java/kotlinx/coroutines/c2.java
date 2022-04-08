package kotlinx.coroutines;

import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: Yield.kt */
/* loaded from: classes4.dex */
public final class c2 {
    public static final void a(f checkCompletion) {
        j.f(checkCompletion, "$this$checkCompletion");
        d1 d1Var = (d1) checkCompletion.get(d1.h);
        if (d1Var != null && !d1Var.isActive()) {
            throw d1Var.i();
        }
    }

    public static final Object b(c<? super p> cVar) {
        c c2;
        Object obj;
        Object d2;
        f context = cVar.getContext();
        a(context);
        c2 = IntrinsicsKt__IntrinsicsJvmKt.c(cVar);
        if (!(c2 instanceof j0)) {
            c2 = null;
        }
        j0 j0Var = (j0) c2;
        if (j0Var == null) {
            obj = p.a;
        } else if (!j0Var.z.isDispatchNeeded(context)) {
            obj = l0.i(j0Var) ? b.d() : p.a;
        } else {
            j0Var.k(p.a);
            obj = b.d();
        }
        d2 = b.d();
        if (obj == d2) {
            kotlin.coroutines.jvm.internal.f.c(cVar);
        }
        return obj;
    }
}
