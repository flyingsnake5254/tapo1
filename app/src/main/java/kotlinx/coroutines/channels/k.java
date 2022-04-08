package kotlinx.coroutines.channels;

import kotlin.jvm.internal.j;
import kotlinx.coroutines.g0;

/* compiled from: AbstractChannel.kt */
/* loaded from: classes4.dex */
public final class k<E> extends u implements s<E> {
    public final Throwable q;

    public k(Throwable th) {
        this.q = th;
    }

    @Override // kotlinx.coroutines.channels.u
    public void L(Object token) {
        j.f(token, "token");
        if (g0.a()) {
            if (!(token == b.g)) {
                throw new AssertionError();
            }
        }
    }

    @Override // kotlinx.coroutines.channels.u
    public void N(k<?> closed) {
        j.f(closed, "closed");
        if (g0.a()) {
            throw new AssertionError();
        }
    }

    @Override // kotlinx.coroutines.channels.u
    public Object O(Object obj) {
        return b.g;
    }

    /* renamed from: P */
    public k<E> a() {
        return this;
    }

    /* renamed from: Q */
    public k<E> M() {
        return this;
    }

    public final Throwable R() {
        Throwable th = this.q;
        return th != null ? th : new ClosedReceiveChannelException("Channel was closed");
    }

    public final Throwable S() {
        Throwable th = this.q;
        return th != null ? th : new ClosedSendChannelException("Channel was closed");
    }

    @Override // kotlinx.coroutines.channels.s
    public void j(Object token) {
        j.f(token, "token");
        if (g0.a()) {
            if (!(token == b.g)) {
                throw new AssertionError();
            }
        }
    }

    @Override // kotlinx.coroutines.channels.s
    public Object m(E e2, Object obj) {
        return b.g;
    }

    @Override // kotlinx.coroutines.internal.i
    public String toString() {
        return "Closed[" + this.q + ']';
    }
}
