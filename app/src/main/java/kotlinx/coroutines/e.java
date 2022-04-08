package kotlinx.coroutines;

import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.coroutines.f;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.d2.a;
import kotlinx.coroutines.d2.b;
import kotlinx.coroutines.internal.q;
import kotlinx.coroutines.internal.x;

/* compiled from: Builders.common.kt */
/* loaded from: classes4.dex */
public final /* synthetic */ class e {
    public static final d1 a(d0 launch, f context, CoroutineStart start, p<? super d0, ? super c<? super kotlin.p>, ? extends Object> block) {
        a aVar;
        j.f(launch, "$this$launch");
        j.f(context, "context");
        j.f(start, "start");
        j.f(block, "block");
        f c2 = x.c(launch, context);
        if (start.isLazy()) {
            aVar = new l1(c2, block);
        } else {
            aVar = new t1(c2, true);
        }
        aVar.u0(start, aVar, block);
        return aVar;
    }

    public static /* synthetic */ d1 b(d0 d0Var, f fVar, CoroutineStart coroutineStart, p pVar, int i, Object obj) {
        if ((i & 1) != 0) {
            fVar = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return d.a(d0Var, fVar, coroutineStart, pVar);
    }

    /* JADX WARN: Finally extract failed */
    public static final <T> Object c(f fVar, p<? super d0, ? super c<? super T>, ? extends Object> pVar, c<? super T> cVar) {
        Object obj;
        Object d2;
        f context = cVar.getContext();
        f plus = context.plus(fVar);
        c2.a(plus);
        if (plus == context) {
            q qVar = new q(plus, cVar);
            obj = b.d(qVar, qVar, pVar);
        } else {
            d.b bVar = d.f16330e;
            if (j.a((d) plus.get(bVar), (d) context.get(bVar))) {
                b2 b2Var = new b2(plus, cVar);
                Object c2 = x.c(plus, null);
                try {
                    Object d3 = b.d(b2Var, b2Var, pVar);
                    x.a(plus, c2);
                    obj = d3;
                } catch (Throwable th) {
                    x.a(plus, c2);
                    throw th;
                }
            } else {
                k0 k0Var = new k0(plus, cVar);
                k0Var.q0();
                a.b(pVar, k0Var, k0Var);
                obj = k0Var.v0();
            }
        }
        d2 = kotlin.coroutines.intrinsics.b.d();
        if (obj == d2) {
            kotlin.coroutines.jvm.internal.f.c(cVar);
        }
        return obj;
    }
}
