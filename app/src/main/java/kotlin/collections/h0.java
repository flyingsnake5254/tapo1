package kotlin.collections;

import java.util.Set;
import kotlin.jvm.internal.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Sets.kt */
/* loaded from: classes4.dex */
public class h0 extends g0 {
    public static final <T> Set<T> b() {
        return EmptySet.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Set<T> c(Set<? extends T> optimizeReadOnlySet) {
        j.e(optimizeReadOnlySet, "$this$optimizeReadOnlySet");
        int size = optimizeReadOnlySet.size();
        if (size != 0) {
            return size != 1 ? optimizeReadOnlySet : g0.a(optimizeReadOnlySet.iterator().next());
        }
        return b();
    }
}
