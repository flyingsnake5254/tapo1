package kotlinx.coroutines.internal;

import kotlin.coroutines.f;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.a;
import kotlinx.coroutines.r;
import kotlinx.coroutines.s1;

/* compiled from: Scopes.kt */
/* loaded from: classes4.dex */
public class q<T> extends a<T> implements c {
    public final kotlin.coroutines.c<T> q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public q(f context, kotlin.coroutines.c<? super T> uCont) {
        super(context, true);
        j.f(context, "context");
        j.f(uCont, "uCont");
        this.q = uCont;
    }

    @Override // kotlinx.coroutines.j1
    protected final boolean Q() {
        return true;
    }

    @Override // kotlin.coroutines.jvm.internal.c
    public final c getCallerFrame() {
        return (c) this.q;
    }

    @Override // kotlin.coroutines.jvm.internal.c
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.a
    public int p0() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.j1
    public void u(Object obj, int i) {
        if (obj instanceof r) {
            Throwable th = ((r) obj).f16526b;
            if (i != 4) {
                th = s.k(th, this.q);
            }
            s1.e(this.q, th, i);
            return;
        }
        s1.d(this.q, obj, i);
    }
}
