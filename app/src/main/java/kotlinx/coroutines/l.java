package kotlinx.coroutines;

import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: JobSupport.kt */
/* loaded from: classes4.dex */
public final class l extends e1<d1> {
    public final i<?> x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(d1 parent, i<?> child) {
        super(parent);
        j.f(parent, "parent");
        j.f(child, "child");
        this.x = child;
    }

    @Override // kotlinx.coroutines.v
    public void L(Throwable th) {
        i<?> iVar = this.x;
        iVar.l(iVar.o(this.q));
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ p invoke(Throwable th) {
        L(th);
        return p.a;
    }

    @Override // kotlinx.coroutines.internal.i
    public String toString() {
        return "ChildContinuation[" + this.x + ']';
    }
}
