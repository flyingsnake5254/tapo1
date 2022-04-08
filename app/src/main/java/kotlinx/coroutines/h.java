package kotlinx.coroutines;

import kotlin.coroutines.c;
import kotlin.jvm.b.l;
import kotlin.p;

/* compiled from: CancellableContinuation.kt */
/* loaded from: classes4.dex */
public interface h<T> extends c<T> {

    /* compiled from: CancellableContinuation.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Object a(h hVar, Object obj, Object obj2, int i, Object obj3) {
            if (obj3 == null) {
                if ((i & 2) != 0) {
                    obj2 = null;
                }
                return hVar.b(obj, obj2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryResume");
        }
    }

    Object b(T t, Object obj);

    void f(l<? super Throwable, p> lVar);

    Object h(Throwable th);

    void p(Object obj);
}
