package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.j;
import kotlin.v.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Collections.kt */
/* loaded from: classes4.dex */
public class n extends m {
    public static <T> ArrayList<T> c(T... elements) {
        j.e(elements, "elements");
        return elements.length == 0 ? new ArrayList<>() : new ArrayList<>(new d(elements, true));
    }

    public static <T> List<T> d() {
        return EmptyList.INSTANCE;
    }

    public static d e(Collection<?> indices) {
        j.e(indices, "$this$indices");
        return new d(0, indices.size() - 1);
    }

    public static <T> int f(List<? extends T> lastIndex) {
        j.e(lastIndex, "$this$lastIndex");
        return lastIndex.size() - 1;
    }

    public static <T> List<T> g(T... elements) {
        List<T> d2;
        List<T> b2;
        j.e(elements, "elements");
        if (elements.length > 0) {
            b2 = h.b(elements);
            return b2;
        }
        d2 = d();
        return d2;
    }

    public static <T> List<T> h(T... elements) {
        j.e(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(new d(elements, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<T> i(List<? extends T> optimizeReadOnlyList) {
        List<T> d2;
        List<T> b2;
        j.e(optimizeReadOnlyList, "$this$optimizeReadOnlyList");
        int size = optimizeReadOnlyList.size();
        if (size == 0) {
            d2 = d();
            return d2;
        } else if (size != 1) {
            return optimizeReadOnlyList;
        } else {
            b2 = m.b(optimizeReadOnlyList.get(0));
            return b2;
        }
    }

    public static void j() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void k() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
