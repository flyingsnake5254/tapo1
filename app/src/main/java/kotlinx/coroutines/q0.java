package kotlinx.coroutines;

import kotlin.jvm.internal.j;
import kotlinx.coroutines.internal.a;

/* compiled from: EventLoop.common.kt */
/* loaded from: classes4.dex */
public abstract class q0 extends y {

    /* renamed from: c  reason: collision with root package name */
    private long f16523c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f16524d;

    /* renamed from: f  reason: collision with root package name */
    private a<m0<?>> f16525f;

    private final long v(boolean z) {
        return z ? 4294967296L : 1L;
    }

    public static /* synthetic */ void z(q0 q0Var, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            q0Var.y(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    public final boolean A() {
        return this.f16523c >= v(true);
    }

    public final boolean B() {
        a<m0<?>> aVar = this.f16525f;
        if (aVar != null) {
            return aVar.c();
        }
        return true;
    }

    public final boolean C() {
        m0<?> d2;
        a<m0<?>> aVar = this.f16525f;
        if (aVar == null || (d2 = aVar.d()) == null) {
            return false;
        }
        d2.run();
        return true;
    }

    protected void shutdown() {
    }

    public final void u(boolean z) {
        long v = this.f16523c - v(z);
        this.f16523c = v;
        if (v <= 0) {
            if (g0.a()) {
                if (!(this.f16523c == 0)) {
                    throw new AssertionError();
                }
            }
            if (this.f16524d) {
                shutdown();
            }
        }
    }

    public final void w(m0<?> task) {
        j.f(task, "task");
        a<m0<?>> aVar = this.f16525f;
        if (aVar == null) {
            aVar = new a<>();
            this.f16525f = aVar;
        }
        aVar.a(task);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long x() {
        a<m0<?>> aVar = this.f16525f;
        return (aVar == null || aVar.c()) ? Long.MAX_VALUE : 0L;
    }

    public final void y(boolean z) {
        this.f16523c += v(z);
        if (!z) {
            this.f16524d = true;
        }
    }
}
