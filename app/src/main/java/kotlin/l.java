package kotlin;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: LazyJVM.kt */
/* loaded from: classes4.dex */
final class l<T> implements f<T>, Serializable {

    /* renamed from: f  reason: collision with root package name */
    private volatile kotlin.jvm.b.a<? extends T> f16353f;
    private volatile Object q;
    private final Object x;

    /* renamed from: d  reason: collision with root package name */
    public static final a f16352d = new a(null);

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater<l<?>, Object> f16351c = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "q");

    /* compiled from: LazyJVM.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public l(kotlin.jvm.b.a<? extends T> initializer) {
        j.e(initializer, "initializer");
        this.f16353f = initializer;
        o oVar = o.a;
        this.q = oVar;
        this.x = oVar;
    }

    public boolean a() {
        return this.q != o.a;
    }

    @Override // kotlin.f
    public T getValue() {
        T t = (T) this.q;
        o oVar = o.a;
        if (t != oVar) {
            return t;
        }
        kotlin.jvm.b.a<? extends T> aVar = this.f16353f;
        if (aVar != null) {
            T t2 = (T) aVar.invoke();
            if (f16351c.compareAndSet(this, oVar, t2)) {
                this.f16353f = null;
                return t2;
            }
        }
        return (T) this.q;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
