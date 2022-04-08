package kotlinx.coroutines.channels;

import kotlin.coroutines.f;
import kotlin.jvm.internal.j;
import kotlin.p;
import kotlinx.coroutines.a0;
import kotlinx.coroutines.channels.v;

/* compiled from: Produce.kt */
/* loaded from: classes4.dex */
public class o<E> extends g<E> implements p<E> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(f parentContext, f<E> channel) {
        super(parentContext, channel, true);
        j.f(parentContext, "parentContext");
        j.f(channel, "channel");
    }

    @Override // kotlinx.coroutines.channels.p
    public /* bridge */ /* synthetic */ v c() {
        return v0();
    }

    @Override // kotlinx.coroutines.a, kotlinx.coroutines.j1, kotlinx.coroutines.d1
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlinx.coroutines.a
    protected void r0(Throwable cause, boolean z) {
        j.f(cause, "cause");
        if (!w0().m(cause) && !z) {
            a0.a(getContext(), cause);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: z0 */
    public void s0(p value) {
        j.f(value, "value");
        v.a.a(w0(), null, 1, null);
    }
}
