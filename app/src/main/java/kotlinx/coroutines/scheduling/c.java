package kotlinx.coroutines.scheduling;

import java.util.concurrent.RejectedExecutionException;
import kotlin.coroutines.f;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.w0;
import kotlinx.coroutines.y;

/* compiled from: Dispatcher.kt */
/* loaded from: classes4.dex */
public class c extends w0 {

    /* renamed from: c  reason: collision with root package name */
    private CoroutineScheduler f16538c;

    /* renamed from: d  reason: collision with root package name */
    private final int f16539d;

    /* renamed from: f  reason: collision with root package name */
    private final int f16540f;
    private final long q;
    private final String x;

    public c(int i, int i2, long j, String schedulerName) {
        j.f(schedulerName, "schedulerName");
        this.f16539d = i;
        this.f16540f = i2;
        this.q = j;
        this.x = schedulerName;
        this.f16538c = v();
    }

    private final CoroutineScheduler v() {
        return new CoroutineScheduler(this.f16539d, this.f16540f, this.q, this.x);
    }

    @Override // kotlinx.coroutines.y
    public void dispatch(f context, Runnable block) {
        j.f(context, "context");
        j.f(block, "block");
        try {
            CoroutineScheduler.G(this.f16538c, block, null, false, 6, null);
        } catch (RejectedExecutionException unused) {
            i0.z.dispatch(context, block);
        }
    }

    @Override // kotlinx.coroutines.y
    public void dispatchYield(f context, Runnable block) {
        j.f(context, "context");
        j.f(block, "block");
        try {
            CoroutineScheduler.G(this.f16538c, block, null, true, 2, null);
        } catch (RejectedExecutionException unused) {
            i0.z.dispatchYield(context, block);
        }
    }

    public final y u(int i) {
        if (i > 0) {
            return new e(this, i, TaskMode.PROBABLY_BLOCKING);
        }
        throw new IllegalArgumentException(("Expected positive parallelism level, but have " + i).toString());
    }

    public final void w(Runnable block, i context, boolean z) {
        j.f(block, "block");
        j.f(context, "context");
        try {
            this.f16538c.F(block, context, z);
        } catch (RejectedExecutionException unused) {
            i0.z.J(this.f16538c.D(block, context));
        }
    }

    public /* synthetic */ c(int i, int i2, String str, int i3, kotlin.jvm.internal.f fVar) {
        this((i3 & 1) != 0 ? k.f16551d : i, (i3 & 2) != 0 ? k.f16552e : i2, (i3 & 4) != 0 ? "DefaultDispatcher" : str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(int i, int i2, String schedulerName) {
        this(i, i2, k.f16553f, schedulerName);
        j.f(schedulerName, "schedulerName");
    }
}
