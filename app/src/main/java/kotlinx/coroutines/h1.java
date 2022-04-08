package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.f;
import kotlin.jvm.internal.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Job.kt */
/* loaded from: classes4.dex */
public final /* synthetic */ class h1 {
    public static final void a(f cancel, CancellationException cancellationException) {
        j.f(cancel, "$this$cancel");
        d1 d1Var = (d1) cancel.get(d1.h);
        if (d1Var != null) {
            d1Var.a(cancellationException);
        }
    }

    public static /* synthetic */ void b(f fVar, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        g1.a(fVar, cancellationException);
    }
}
