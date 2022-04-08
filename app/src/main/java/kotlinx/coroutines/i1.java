package kotlinx.coroutines;

import kotlin.TypeCastException;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.d1;

/* compiled from: JobSupport.kt */
/* loaded from: classes4.dex */
public abstract class i1<J extends d1> extends v implements o0, y0 {
    public final J q;

    public i1(J job) {
        j.f(job, "job");
        this.q = job;
    }

    @Override // kotlinx.coroutines.y0
    public n1 d() {
        return null;
    }

    @Override // kotlinx.coroutines.o0
    public void dispose() {
        J j = this.q;
        if (j != null) {
            ((j1) j).d0(this);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.JobSupport");
    }

    @Override // kotlinx.coroutines.y0
    public boolean isActive() {
        return true;
    }
}
