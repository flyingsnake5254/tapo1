package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JobSupport.kt */
/* loaded from: classes4.dex */
public final class b1 extends e1<d1> {
    private static final AtomicIntegerFieldUpdater x = AtomicIntegerFieldUpdater.newUpdater(b1.class, "_invoked");
    private volatile int _invoked = 0;
    private final l<Throwable, p> y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public b1(d1 job, l<? super Throwable, p> handler) {
        super(job);
        j.f(job, "job");
        j.f(handler, "handler");
        this.y = handler;
    }

    @Override // kotlinx.coroutines.v
    public void L(Throwable th) {
        if (x.compareAndSet(this, 0, 1)) {
            this.y.invoke(th);
        }
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ p invoke(Throwable th) {
        L(th);
        return p.a;
    }

    @Override // kotlinx.coroutines.internal.i
    public String toString() {
        return "InvokeOnCancelling[" + h0.a(this) + '@' + h0.b(this) + ']';
    }
}
