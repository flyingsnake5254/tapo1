package com.google.common.collect;

import com.google.common.base.n;
import java.util.Comparator;
import java.util.SortedSet;

/* compiled from: SortedIterables.java */
/* loaded from: classes2.dex */
final class y2 {
    public static <E> Comparator<? super E> a(SortedSet<E> sortedSet) {
        Comparator<? super E> comparator = sortedSet.comparator();
        return comparator == null ? a2.g() : comparator;
    }

    public static boolean b(Comparator<?> comparator, Iterable<?> iterable) {
        Comparator comparator2;
        n.o(comparator);
        n.o(iterable);
        if (iterable instanceof SortedSet) {
            comparator2 = a((SortedSet) iterable);
        } else if (!(iterable instanceof x2)) {
            return false;
        } else {
            comparator2 = ((x2) iterable).comparator();
        }
        return comparator.equals(comparator2);
    }
}
