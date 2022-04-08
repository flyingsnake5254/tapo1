package kotlinx.coroutines;

import kotlin.coroutines.f;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.internal.j;
import kotlin.p;
import kotlinx.coroutines.internal.x;

/* compiled from: Dispatched.kt */
/* loaded from: classes4.dex */
public final class j0<T> extends m0<T> implements c, kotlin.coroutines.c<T> {
    public final kotlin.coroutines.c<T> p0;
    public Object q = l0.a();
    private final c x;
    public final Object y;
    public final y z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public j0(y dispatcher, kotlin.coroutines.c<? super T> continuation) {
        super(0);
        j.f(dispatcher, "dispatcher");
        j.f(continuation, "continuation");
        this.z = dispatcher;
        this.p0 = continuation;
        this.x = (c) (!(continuation instanceof c) ? (kotlin.coroutines.c<? super T>) false : continuation);
        this.y = x.b(getContext());
    }

    @Override // kotlinx.coroutines.m0
    public kotlin.coroutines.c<T> d() {
        return this;
    }

    @Override // kotlin.coroutines.jvm.internal.c
    public c getCallerFrame() {
        return this.x;
    }

    @Override // kotlin.coroutines.c
    public f getContext() {
        return this.p0.getContext();
    }

    @Override // kotlin.coroutines.jvm.internal.c
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.m0
    public Object j() {
        Object obj = this.q;
        if (g0.a()) {
            if (!(obj != l0.a())) {
                throw new AssertionError();
            }
        }
        this.q = l0.a();
        return obj;
    }

    public final void k(T t) {
        f context = this.p0.getContext();
        this.q = t;
        this.f16512f = 1;
        this.z.dispatchYield(context, this);
    }

    @Override // kotlin.coroutines.c
    public void resumeWith(Object obj) {
        f context = this.p0.getContext();
        Object a = s.a(obj);
        if (this.z.isDispatchNeeded(context)) {
            this.q = a;
            this.f16512f = 0;
            this.z.dispatch(context, this);
            return;
        }
        q0 a2 = x1.f16573b.a();
        if (a2.A()) {
            this.q = a;
            this.f16512f = 0;
            a2.w(this);
            return;
        }
        a2.y(true);
        try {
            f context2 = getContext();
            Object c2 = x.c(context2, this.y);
            this.p0.resumeWith(obj);
            p pVar = p.a;
            x.a(context2, c2);
            do {
            } while (a2.C());
        } finally {
            try {
            } finally {
            }
        }
    }

    public String toString() {
        return "DispatchedContinuation[" + this.z + ", " + h0.c(this.p0) + ']';
    }
}
