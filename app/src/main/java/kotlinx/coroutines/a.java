package kotlinx.coroutines;

import io.netty.util.internal.StringUtil;
import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.j;

/* compiled from: AbstractCoroutine.kt */
/* loaded from: classes4.dex */
public abstract class a<T> extends j1 implements d1, c<T>, d0 {

    /* renamed from: d  reason: collision with root package name */
    private final f f16416d;

    /* renamed from: f  reason: collision with root package name */
    protected final f f16417f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(f parentContext, boolean z) {
        super(z);
        j.f(parentContext, "parentContext");
        this.f16417f = parentContext;
        this.f16416d = parentContext.plus(this);
    }

    @Override // kotlinx.coroutines.j1
    public final void N(Throwable exception) {
        j.f(exception, "exception");
        a0.a(this.f16416d, exception);
    }

    @Override // kotlinx.coroutines.j1
    public String U() {
        String b2 = x.b(this.f16416d);
        if (b2 == null) {
            return super.U();
        }
        return StringUtil.DOUBLE_QUOTE + b2 + "\":" + super.U();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.j1
    protected final void Z(Object obj) {
        if (obj instanceof r) {
            r rVar = (r) obj;
            r0(rVar.f16526b, rVar.a());
            return;
        }
        s0(obj);
    }

    @Override // kotlinx.coroutines.j1
    public final void a0() {
        t0();
    }

    @Override // kotlin.coroutines.c
    public final f getContext() {
        return this.f16416d;
    }

    @Override // kotlinx.coroutines.d0
    public f getCoroutineContext() {
        return this.f16416d;
    }

    @Override // kotlinx.coroutines.j1, kotlinx.coroutines.d1
    public boolean isActive() {
        return super.isActive();
    }

    public int p0() {
        return 0;
    }

    public final void q0() {
        O((d1) this.f16417f.get(d1.h));
    }

    protected void r0(Throwable cause, boolean z) {
        j.f(cause, "cause");
    }

    @Override // kotlin.coroutines.c
    public final void resumeWith(Object obj) {
        S(s.a(obj), p0());
    }

    protected void s0(T t) {
    }

    protected void t0() {
    }

    public final <R> void u0(CoroutineStart start, R r, p<? super R, ? super c<? super T>, ? extends Object> block) {
        j.f(start, "start");
        j.f(block, "block");
        q0();
        start.invoke(block, r, this);
    }
}
