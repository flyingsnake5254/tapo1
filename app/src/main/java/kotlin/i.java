package kotlin;

import kotlin.jvm.b.a;
import kotlin.jvm.internal.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJVM.kt */
/* loaded from: classes4.dex */
public class i {
    public static <T> f<T> a(LazyThreadSafetyMode mode, a<? extends T> initializer) {
        j.e(mode, "mode");
        j.e(initializer, "initializer");
        int i = g.a[mode.ordinal()];
        if (i == 1) {
            return new m(initializer, null, 2, null);
        }
        if (i == 2) {
            return new l(initializer);
        }
        if (i == 3) {
            return new UnsafeLazyImpl(initializer);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static <T> f<T> b(a<? extends T> initializer) {
        j.e(initializer, "initializer");
        return new m(initializer, null, 2, null);
    }
}
