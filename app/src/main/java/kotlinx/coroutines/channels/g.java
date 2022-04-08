package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.TypeCastException;
import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.jvm.internal.j;
import kotlin.p;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.a;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.j1;

/* compiled from: ChannelCoroutine.kt */
/* loaded from: classes4.dex */
public class g<E> extends a<p> implements f<E> {
    private final f<E> q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f parentContext, f<E> _channel, boolean z) {
        super(parentContext, z);
        j.f(parentContext, "parentContext");
        j.f(_channel, "_channel");
        this.q = _channel;
    }

    static /* synthetic */ Object x0(g gVar, Object obj, c cVar) {
        return gVar.q.n(obj, cVar);
    }

    @Override // kotlinx.coroutines.j1, kotlinx.coroutines.d1, kotlinx.coroutines.channels.r
    public final void a(CancellationException cancellationException) {
        x(cancellationException);
    }

    @Override // kotlinx.coroutines.channels.r
    public kotlinx.coroutines.selects.c<E> e() {
        return this.q.e();
    }

    @Override // kotlinx.coroutines.channels.r
    public h<E> iterator() {
        return this.q.iterator();
    }

    @Override // kotlinx.coroutines.channels.v
    public boolean m(Throwable th) {
        return this.q.m(th);
    }

    @Override // kotlinx.coroutines.channels.v
    public Object n(E e2, c<? super p> cVar) {
        return x0(this, e2, cVar);
    }

    public final f<E> v0() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final f<E> w0() {
        return this.q;
    }

    @Override // kotlinx.coroutines.j1
    public boolean x(Throwable th) {
        CancellationException cancellationException;
        if (th == null || (cancellationException = j1.h0(this, th, null, 1, null)) == null) {
            cancellationException = new JobCancellationException(h0.a(this) + " was cancelled", null, this);
        }
        this.q.a(cancellationException);
        v(cancellationException);
        return true;
    }

    public final Object y0(E e2, c<? super p> cVar) {
        f<E> fVar = this.q;
        if (fVar != null) {
            return ((c) fVar).y(e2, cVar);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.AbstractSendChannel<E>");
    }
}
