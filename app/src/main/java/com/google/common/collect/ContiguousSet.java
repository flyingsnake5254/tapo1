package com.google.common.collect;

import com.google.common.base.n;
import com.google.common.collect.ImmutableSortedSet;
import java.lang.Comparable;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public abstract class ContiguousSet<C extends Comparable> extends ImmutableSortedSet<C> {
    final i0<C> domain;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ContiguousSet(i0<C> i0Var) {
        super(a2.g());
        this.domain = i0Var;
    }

    @Deprecated
    public static <E> ImmutableSortedSet.a<E> builder() {
        throw new UnsupportedOperationException();
    }

    public static ContiguousSet<Integer> closed(int i, int i2) {
        return create(Range.closed(Integer.valueOf(i), Integer.valueOf(i2)), i0.b());
    }

    public static ContiguousSet<Integer> closedOpen(int i, int i2) {
        return create(Range.closedOpen(Integer.valueOf(i), Integer.valueOf(i2)), i0.b());
    }

    public static <C extends Comparable> ContiguousSet<C> create(Range<C> range, i0<C> i0Var) {
        n.o(range);
        n.o(i0Var);
        try {
            Range<C> intersection = !range.hasLowerBound() ? range.intersection(Range.atLeast(i0Var.g())) : range;
            if (!range.hasUpperBound()) {
                intersection = intersection.intersection(Range.atMost(i0Var.f()));
            }
            return intersection.isEmpty() || Range.compareOrThrow(range.lowerBound.n(i0Var), range.upperBound.l(i0Var)) > 0 ? new j0(i0Var) : new g2(intersection, i0Var);
        } catch (NoSuchElementException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<C> createDescendingSet() {
        return new g0(this);
    }

    abstract ContiguousSet<C> headSetImpl(C c2, boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet headSetImpl(Object obj, boolean z) {
        return headSetImpl((ContiguousSet<C>) ((Comparable) obj), z);
    }

    public abstract ContiguousSet<C> intersection(ContiguousSet<C> contiguousSet);

    public abstract Range<C> range();

    public abstract Range<C> range(BoundType boundType, BoundType boundType2);

    abstract ContiguousSet<C> subSetImpl(C c2, boolean z, C c3, boolean z2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet
    /* bridge */ /* synthetic */ ImmutableSortedSet subSetImpl(Object obj, boolean z, Object obj2, boolean z2) {
        return subSetImpl((boolean) ((Comparable) obj), z, (boolean) ((Comparable) obj2), z2);
    }

    abstract ContiguousSet<C> tailSetImpl(C c2, boolean z);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet
    /* bridge */ /* synthetic */ ImmutableSortedSet tailSetImpl(Object obj, boolean z) {
        return tailSetImpl((ContiguousSet<C>) ((Comparable) obj), z);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return range().toString();
    }

    public static ContiguousSet<Long> closed(long j, long j2) {
        return create(Range.closed(Long.valueOf(j), Long.valueOf(j2)), i0.d());
    }

    public static ContiguousSet<Long> closedOpen(long j, long j2) {
        return create(Range.closedOpen(Long.valueOf(j), Long.valueOf(j2)), i0.d());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContiguousSet<C> headSet(C c2) {
        return headSetImpl((ContiguousSet<C>) ((Comparable) n.o(c2)), false);
    }

    public ContiguousSet<C> subSet(C c2, C c3) {
        n.o(c2);
        n.o(c3);
        n.d(comparator().compare(c2, c3) <= 0);
        return subSetImpl((boolean) c2, true, (boolean) c3, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContiguousSet<C> tailSet(C c2) {
        return tailSetImpl((ContiguousSet<C>) ((Comparable) n.o(c2)), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContiguousSet<C> headSet(C c2, boolean z) {
        return headSetImpl((ContiguousSet<C>) ((Comparable) n.o(c2)), z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContiguousSet<C> tailSet(C c2, boolean z) {
        return tailSetImpl((ContiguousSet<C>) ((Comparable) n.o(c2)), z);
    }

    public ContiguousSet<C> subSet(C c2, boolean z, C c3, boolean z2) {
        n.o(c2);
        n.o(c3);
        n.d(comparator().compare(c2, c3) <= 0);
        return subSetImpl((boolean) c2, z, (boolean) c3, z2);
    }
}
