package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.g0;

/* compiled from: Atomic.kt */
/* loaded from: classes4.dex */
public abstract class d<T> extends o {
    private static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "_consensus");
    private volatile Object _consensus;

    public d() {
        Object obj;
        obj = c.a;
        this._consensus = obj;
    }

    private final Object c(Object obj) {
        return f(obj) ? obj : this._consensus;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.o
    public final Object a(Object obj) {
        Object obj2;
        Object obj3 = this._consensus;
        obj2 = c.a;
        if (obj3 == obj2) {
            obj3 = c(e(obj));
        }
        b(obj, obj3);
        return obj3;
    }

    public abstract void b(T t, Object obj);

    public final boolean d() {
        Object obj;
        Object obj2 = this._consensus;
        obj = c.a;
        return obj2 != obj;
    }

    public abstract Object e(T t);

    public final boolean f(Object obj) {
        Object obj2;
        Object obj3;
        if (g0.a()) {
            obj3 = c.a;
            if (!(obj != obj3)) {
                throw new AssertionError();
            }
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        obj2 = c.a;
        return atomicReferenceFieldUpdater.compareAndSet(this, obj2, obj);
    }
}
