package kotlinx.coroutines;

import kotlin.TypeCastException;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.internal.g;
import kotlinx.coroutines.internal.i;

/* compiled from: JobSupport.kt */
/* loaded from: classes4.dex */
public final class n1 extends g implements y0 {
    public final String L(String state) {
        j.f(state, "state");
        StringBuilder sb = new StringBuilder();
        sb.append("List{");
        sb.append(state);
        sb.append("}[");
        Object A = A();
        if (A != null) {
            boolean z = true;
            for (i iVar = (i) A; !j.a(iVar, this); iVar = iVar.B()) {
                if (iVar instanceof i1) {
                    i1 i1Var = (i1) iVar;
                    if (z) {
                        z = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(i1Var);
                }
            }
            sb.append("]");
            String sb2 = sb.toString();
            j.b(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    @Override // kotlinx.coroutines.y0
    public n1 d() {
        return this;
    }

    @Override // kotlinx.coroutines.y0
    public boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.internal.i
    public String toString() {
        return g0.c() ? L("Active") : super.toString();
    }
}
