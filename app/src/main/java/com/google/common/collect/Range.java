package com.google.common.collect;

import com.google.common.base.h;
import com.google.common.base.n;
import com.google.common.base.o;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes2.dex */
public final class Range<C extends Comparable> extends d2 implements o<C>, Serializable {
    private static final Range<Comparable> ALL = new Range<>(d0.d(), d0.a());
    private static final long serialVersionUID = 0;
    final d0<C> lowerBound;
    final d0<C> upperBound;

    /* loaded from: classes2.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[BoundType.values().length];
            a = iArr;
            try {
                iArr[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes2.dex */
    static class b implements h<Range, d0> {

        /* renamed from: c  reason: collision with root package name */
        static final b f4315c = new b();

        b() {
        }

        /* renamed from: a */
        public d0 apply(Range range) {
            return range.lowerBound;
        }
    }

    /* loaded from: classes2.dex */
    private static class c extends a2<Range<?>> implements Serializable {

        /* renamed from: c  reason: collision with root package name */
        static final a2<Range<?>> f4316c = new c();

        private c() {
        }

        /* renamed from: k */
        public int compare(Range<?> range, Range<?> range2) {
            return c0.k().f(range.lowerBound, range2.lowerBound).f(range.upperBound, range2.upperBound).j();
        }
    }

    /* loaded from: classes2.dex */
    static class d implements h<Range, d0> {

        /* renamed from: c  reason: collision with root package name */
        static final d f4317c = new d();

        d() {
        }

        /* renamed from: a */
        public d0 apply(Range range) {
            return range.upperBound;
        }
    }

    private Range(d0<C> d0Var, d0<C> d0Var2) {
        this.lowerBound = (d0) n.o(d0Var);
        this.upperBound = (d0) n.o(d0Var2);
        if (d0Var.compareTo(d0Var2) > 0 || d0Var == d0.a() || d0Var2 == d0.d()) {
            throw new IllegalArgumentException("Invalid range: " + toString(d0Var, d0Var2));
        }
    }

    public static <C extends Comparable<?>> Range<C> all() {
        return (Range<C>) ALL;
    }

    public static <C extends Comparable<?>> Range<C> atLeast(C c2) {
        return create(d0.f(c2), d0.a());
    }

    public static <C extends Comparable<?>> Range<C> atMost(C c2) {
        return create(d0.d(), d0.b(c2));
    }

    private static <T> SortedSet<T> cast(Iterable<T> iterable) {
        return (SortedSet) iterable;
    }

    public static <C extends Comparable<?>> Range<C> closed(C c2, C c3) {
        return create(d0.f(c2), d0.b(c3));
    }

    public static <C extends Comparable<?>> Range<C> closedOpen(C c2, C c3) {
        return create(d0.f(c2), d0.f(c3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int compareOrThrow(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable<?>> Range<C> create(d0<C> d0Var, d0<C> d0Var2) {
        return new Range<>(d0Var, d0Var2);
    }

    public static <C extends Comparable<?>> Range<C> downTo(C c2, BoundType boundType) {
        int i = a.a[boundType.ordinal()];
        if (i == 1) {
            return greaterThan(c2);
        }
        if (i == 2) {
            return atLeast(c2);
        }
        throw new AssertionError();
    }

    public static <C extends Comparable<?>> Range<C> encloseAll(Iterable<C> iterable) {
        n.o(iterable);
        if (iterable instanceof SortedSet) {
            SortedSet cast = cast(iterable);
            Comparator comparator = cast.comparator();
            if (a2.g().equals(comparator) || comparator == null) {
                return closed((Comparable) cast.first(), (Comparable) cast.last());
            }
        }
        Iterator<C> it = iterable.iterator();
        Comparable comparable = (Comparable) n.o(it.next());
        Comparable comparable2 = comparable;
        while (it.hasNext()) {
            Comparable comparable3 = (Comparable) n.o(it.next());
            comparable = (Comparable) a2.g().f(comparable, comparable3);
            comparable2 = (Comparable) a2.g().d(comparable2, comparable3);
        }
        return closed(comparable, comparable2);
    }

    public static <C extends Comparable<?>> Range<C> greaterThan(C c2) {
        return create(d0.b(c2), d0.a());
    }

    public static <C extends Comparable<?>> Range<C> lessThan(C c2) {
        return create(d0.d(), d0.f(c2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable<?>> h<Range<C>, d0<C>> lowerBoundFn() {
        return b.f4315c;
    }

    public static <C extends Comparable<?>> Range<C> open(C c2, C c3) {
        return create(d0.b(c2), d0.f(c3));
    }

    public static <C extends Comparable<?>> Range<C> openClosed(C c2, C c3) {
        return create(d0.b(c2), d0.b(c3));
    }

    public static <C extends Comparable<?>> Range<C> range(C c2, BoundType boundType, C c3, BoundType boundType2) {
        n.o(boundType);
        n.o(boundType2);
        BoundType boundType3 = BoundType.OPEN;
        return create(boundType == boundType3 ? d0.b(c2) : d0.f(c2), boundType2 == boundType3 ? d0.f(c3) : d0.b(c3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable<?>> a2<Range<C>> rangeLexOrdering() {
        return (a2<Range<C>>) c.f4316c;
    }

    public static <C extends Comparable<?>> Range<C> singleton(C c2) {
        return closed(c2, c2);
    }

    public static <C extends Comparable<?>> Range<C> upTo(C c2, BoundType boundType) {
        int i = a.a[boundType.ordinal()];
        if (i == 1) {
            return lessThan(c2);
        }
        if (i == 2) {
            return atMost(c2);
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable<?>> h<Range<C>, d0<C>> upperBoundFn() {
        return d.f4317c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.base.o
    @Deprecated
    public /* bridge */ /* synthetic */ boolean apply(Object obj) {
        return apply((Range<C>) ((Comparable) obj));
    }

    public Range<C> canonical(i0<C> i0Var) {
        n.o(i0Var);
        d0<C> g = this.lowerBound.g(i0Var);
        d0<C> g2 = this.upperBound.g(i0Var);
        return (g == this.lowerBound && g2 == this.upperBound) ? this : create(g, g2);
    }

    public boolean contains(C c2) {
        n.o(c2);
        return this.lowerBound.m(c2) && !this.upperBound.m(c2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean containsAll(Iterable<? extends C> iterable) {
        if (j1.j(iterable)) {
            return true;
        }
        if (iterable instanceof SortedSet) {
            SortedSet cast = cast(iterable);
            Comparator comparator = cast.comparator();
            if (a2.g().equals(comparator) || comparator == null) {
                return contains((Comparable) cast.first()) && contains((Comparable) cast.last());
            }
        }
        Iterator<? extends C> it = iterable.iterator();
        while (it.hasNext()) {
            if (!contains((Comparable) it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean encloses(Range<C> range) {
        return this.lowerBound.compareTo(range.lowerBound) <= 0 && this.upperBound.compareTo(range.upperBound) >= 0;
    }

    @Override // com.google.common.base.o
    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof Range)) {
            return false;
        }
        Range range = (Range) obj;
        return this.lowerBound.equals(range.lowerBound) && this.upperBound.equals(range.upperBound);
    }

    public Range<C> gap(Range<C> range) {
        boolean z = this.lowerBound.compareTo(range.lowerBound) < 0;
        Range<C> range2 = z ? this : range;
        if (!z) {
            range = this;
        }
        return create(range2.upperBound, range.lowerBound);
    }

    public boolean hasLowerBound() {
        return this.lowerBound != d0.d();
    }

    public boolean hasUpperBound() {
        return this.upperBound != d0.a();
    }

    public int hashCode() {
        return (this.lowerBound.hashCode() * 31) + this.upperBound.hashCode();
    }

    public Range<C> intersection(Range<C> range) {
        int h = this.lowerBound.compareTo(range.lowerBound);
        int h2 = this.upperBound.compareTo(range.upperBound);
        if (h >= 0 && h2 <= 0) {
            return this;
        }
        if (h <= 0 && h2 >= 0) {
            return range;
        }
        return create(h >= 0 ? this.lowerBound : range.lowerBound, h2 <= 0 ? this.upperBound : range.upperBound);
    }

    public boolean isConnected(Range<C> range) {
        return this.lowerBound.compareTo(range.upperBound) <= 0 && range.lowerBound.compareTo(this.upperBound) <= 0;
    }

    public boolean isEmpty() {
        return this.lowerBound.equals(this.upperBound);
    }

    public BoundType lowerBoundType() {
        return this.lowerBound.o();
    }

    public C lowerEndpoint() {
        return this.lowerBound.k();
    }

    Object readResolve() {
        return equals(ALL) ? all() : this;
    }

    public Range<C> span(Range<C> range) {
        int h = this.lowerBound.compareTo(range.lowerBound);
        int h2 = this.upperBound.compareTo(range.upperBound);
        if (h <= 0 && h2 >= 0) {
            return this;
        }
        if (h >= 0 && h2 <= 0) {
            return range;
        }
        return create(h <= 0 ? this.lowerBound : range.lowerBound, h2 >= 0 ? this.upperBound : range.upperBound);
    }

    public String toString() {
        return toString(this.lowerBound, this.upperBound);
    }

    public BoundType upperBoundType() {
        return this.upperBound.p();
    }

    public C upperEndpoint() {
        return this.upperBound.k();
    }

    private static String toString(d0<?> d0Var, d0<?> d0Var2) {
        StringBuilder sb = new StringBuilder(16);
        d0Var.i(sb);
        sb.append("..");
        d0Var2.j(sb);
        return sb.toString();
    }

    @Deprecated
    public boolean apply(C c2) {
        return contains(c2);
    }
}
