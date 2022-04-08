package kotlin.q;

import java.util.Comparator;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Comparisons.kt */
/* loaded from: classes4.dex */
public class b {
    public static <T extends Comparable<?>> int a(T t, T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return -1;
        }
        if (t2 == null) {
            return 1;
        }
        return t.compareTo(t2);
    }

    public static <T extends Comparable<? super T>> Comparator<T> b() {
        f fVar = f.f16358c;
        Objects.requireNonNull(fVar, "null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
        return fVar;
    }
}
