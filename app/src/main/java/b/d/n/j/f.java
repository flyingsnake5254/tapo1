package b.d.n.j;

import com.tplink.libtpinappmessaging.model.c;
import io.reactivex.m0.b;
import io.reactivex.m0.d;
import io.reactivex.m0.g;

/* compiled from: MessagePublisher.java */
/* loaded from: classes3.dex */
public class f {
    private static final g<c> a = b.n1().l1();

    /* renamed from: b  reason: collision with root package name */
    private static final g<c> f615b = d.n1().l1();

    public static g<c> a() {
        return f615b;
    }

    public static g<c> b() {
        return a;
    }

    public static void c(c cVar) {
        f615b.onNext(cVar);
    }

    public static void d(Throwable th) {
        a.onError(th);
    }

    public static void e(c cVar) {
        a.onNext(cVar);
    }
}
