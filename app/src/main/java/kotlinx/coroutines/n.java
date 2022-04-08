package kotlinx.coroutines;

import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: JobSupport.kt */
/* loaded from: classes4.dex */
public final class n extends e1<j1> implements m {
    public final o x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(j1 parent, o childJob) {
        super(parent);
        j.f(parent, "parent");
        j.f(childJob, "childJob");
        this.x = childJob;
    }

    @Override // kotlinx.coroutines.v
    public void L(Throwable th) {
        this.x.j((q1) this.q);
    }

    @Override // kotlinx.coroutines.m
    public boolean c(Throwable cause) {
        j.f(cause, "cause");
        return ((j1) this.q).A(cause);
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ p invoke(Throwable th) {
        L(th);
        return p.a;
    }

    @Override // kotlinx.coroutines.internal.i
    public String toString() {
        return "ChildHandle[" + this.x + ']';
    }
}
