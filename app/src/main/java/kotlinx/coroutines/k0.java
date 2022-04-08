package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.internal.q;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Builders.common.kt */
/* loaded from: classes4.dex */
public final class k0<T> extends q<T> {
    private static final AtomicIntegerFieldUpdater x = AtomicIntegerFieldUpdater.newUpdater(k0.class, "_decision");
    private volatile int _decision = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(f context, c<? super T> uCont) {
        super(context, uCont);
        j.f(context, "context");
        j.f(uCont, "uCont");
    }

    private final boolean w0() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!x.compareAndSet(this, 0, 2));
        return true;
    }

    private final boolean x0() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!x.compareAndSet(this, 0, 1));
        return true;
    }

    @Override // kotlinx.coroutines.internal.q, kotlinx.coroutines.a
    public int p0() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.internal.q, kotlinx.coroutines.j1
    public void u(Object obj, int i) {
        if (!w0()) {
            super.u(obj, i);
        }
    }

    public final Object v0() {
        Object d2;
        if (x0()) {
            d2 = b.d();
            return d2;
        }
        Object e2 = k1.e(L());
        if (!(e2 instanceof r)) {
            return e2;
        }
        throw ((r) e2).f16526b;
    }
}
