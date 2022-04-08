package kotlinx.coroutines;

import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.d2.a;

/* compiled from: Builders.common.kt */
/* loaded from: classes4.dex */
final class l1 extends t1 {
    private p<? super d0, ? super c<? super kotlin.p>, ? extends Object> q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l1(f parentContext, p<? super d0, ? super c<? super kotlin.p>, ? extends Object> block) {
        super(parentContext, false);
        j.f(parentContext, "parentContext");
        j.f(block, "block");
        this.q = block;
    }

    @Override // kotlinx.coroutines.a
    protected void t0() {
        p<? super d0, ? super c<? super kotlin.p>, ? extends Object> pVar = this.q;
        if (pVar != null) {
            this.q = null;
            a.b(pVar, this, this);
            return;
        }
        throw new IllegalStateException("Already started".toString());
    }
}
