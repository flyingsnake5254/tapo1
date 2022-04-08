package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.f;
import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* compiled from: Job.kt */
/* loaded from: classes4.dex */
public interface d1 extends f.b {
    public static final b h = b.a;

    /* compiled from: Job.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ void a(d1 d1Var, CancellationException cancellationException, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    cancellationException = null;
                }
                d1Var.a(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static <R> R b(d1 d1Var, R r, p<? super R, ? super f.b, ? extends R> operation) {
            j.f(operation, "operation");
            return (R) f.b.a.a(d1Var, r, operation);
        }

        public static <E extends f.b> E c(d1 d1Var, f.c<E> key) {
            j.f(key, "key");
            return (E) f.b.a.b(d1Var, key);
        }

        public static /* synthetic */ o0 d(d1 d1Var, boolean z, boolean z2, l lVar, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                if ((i & 2) != 0) {
                    z2 = true;
                }
                return d1Var.g(z, z2, lVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }

        public static f e(d1 d1Var, f.c<?> key) {
            j.f(key, "key");
            return f.b.a.c(d1Var, key);
        }

        public static f f(d1 d1Var, f context) {
            j.f(context, "context");
            return f.b.a.d(d1Var, context);
        }
    }

    /* compiled from: Job.kt */
    /* loaded from: classes4.dex */
    public static final class b implements f.c<d1> {
        static final /* synthetic */ b a = new b();

        static {
            CoroutineExceptionHandler.a aVar = CoroutineExceptionHandler.g;
        }

        private b() {
        }
    }

    void a(CancellationException cancellationException);

    o0 g(boolean z, boolean z2, l<? super Throwable, kotlin.p> lVar);

    CancellationException i();

    boolean isActive();

    boolean start();

    m t(o oVar);
}
