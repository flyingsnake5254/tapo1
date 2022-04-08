package kotlinx.coroutines.channels;

import kotlin.coroutines.c;
import kotlin.p;

/* compiled from: Channel.kt */
/* loaded from: classes4.dex */
public interface v<E> {

    /* compiled from: Channel.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ boolean a(v vVar, Throwable th, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    th = null;
                }
                return vVar.m(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
        }
    }

    boolean m(Throwable th);

    Object n(E e2, c<? super p> cVar);
}
