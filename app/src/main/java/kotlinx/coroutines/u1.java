package kotlinx.coroutines;

import kotlin.jvm.internal.j;

/* compiled from: Supervisor.kt */
/* loaded from: classes4.dex */
final class u1 extends f1 {
    public u1(d1 d1Var) {
        super(d1Var);
    }

    @Override // kotlinx.coroutines.j1
    public boolean A(Throwable cause) {
        j.f(cause, "cause");
        return false;
    }
}
