package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;
import kotlin.sequences.f;
import kotlinx.coroutines.m1;

/* compiled from: MainDispatchers.kt */
/* loaded from: classes4.dex */
public final class l {
    private static final boolean a = u.e("kotlinx.coroutines.fast.service.loader", true);

    /* renamed from: b  reason: collision with root package name */
    public static final m1 f16490b;

    /* renamed from: c  reason: collision with root package name */
    public static final l f16491c;

    static {
        l lVar = new l();
        f16491c = lVar;
        f16490b = lVar.a();
    }

    private l() {
    }

    private final m1 a() {
        List list;
        Object obj;
        m1 a2;
        f a3;
        try {
            if (a) {
                f fVar = f.a;
                ClassLoader classLoader = MainDispatcherFactory.class.getClassLoader();
                j.b(classLoader, "clz.classLoader");
                list = fVar.b(MainDispatcherFactory.class, classLoader);
            } else {
                Iterator b2 = a.b();
                j.b(b2, "ServiceLoader.load(\n    …             ).iterator()");
                a3 = kotlin.sequences.j.a(b2);
                list = kotlin.sequences.l.i(a3);
            }
            Iterator it = list.iterator();
            if (!it.hasNext()) {
                obj = null;
            } else {
                obj = it.next();
                if (it.hasNext()) {
                    int c2 = ((MainDispatcherFactory) obj).c();
                    do {
                        Object next = it.next();
                        int c3 = ((MainDispatcherFactory) next).c();
                        if (c2 < c3) {
                            obj = next;
                            c2 = c3;
                        }
                    } while (it.hasNext());
                }
            }
            MainDispatcherFactory mainDispatcherFactory = (MainDispatcherFactory) obj;
            return (mainDispatcherFactory == null || (a2 = m.a(mainDispatcherFactory, list)) == null) ? new n(null, null, 2, null) : a2;
        } catch (Throwable th) {
            return new n(th, null, 2, null);
        }
    }
}
