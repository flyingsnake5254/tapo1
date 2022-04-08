package com.google.common.collect;

import com.google.common.base.n;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.z2;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes2.dex */
public final class ImmutableRangeSet<C extends Comparable> extends k<C> implements Serializable {
    @LazyInit
    private transient ImmutableRangeSet<C> complement;
    private final transient ImmutableList<Range<C>> ranges;
    private static final ImmutableRangeSet<Comparable<?>> EMPTY = new ImmutableRangeSet<>(ImmutableList.of());
    private static final ImmutableRangeSet<Comparable<?>> ALL = new ImmutableRangeSet<>(ImmutableList.of(Range.all()));

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends ImmutableList<Range<C>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f4242c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f4243d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Range f4244f;

        a(int i, int i2, Range range) {
            this.f4242c = i;
            this.f4243d = i2;
            this.f4244f = range;
        }

        /* renamed from: a */
        public Range<C> get(int i) {
            n.m(i, this.f4242c);
            return (i == 0 || i == this.f4242c + (-1)) ? ((Range) ImmutableRangeSet.this.ranges.get(i + this.f4243d)).intersection(this.f4244f) : (Range) ImmutableRangeSet.this.ranges.get(i + this.f4243d);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f4242c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class b extends ImmutableSortedSet<C> {

        /* renamed from: c  reason: collision with root package name */
        private final i0<C> f4245c;
        @MonotonicNonNullDecl

        /* renamed from: d  reason: collision with root package name */
        private transient Integer f4246d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class a extends c<C> {

            /* renamed from: f  reason: collision with root package name */
            final Iterator<Range<C>> f4248f;
            Iterator<C> q = k1.h();

            a() {
                this.f4248f = ImmutableRangeSet.this.ranges.iterator();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: d */
            public C a() {
                while (!this.q.hasNext()) {
                    if (!this.f4248f.hasNext()) {
                        return (C) ((Comparable) b());
                    }
                    this.q = ContiguousSet.create(this.f4248f.next(), b.this.f4245c).iterator();
                }
                return this.q.next();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.google.common.collect.ImmutableRangeSet$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0154b extends c<C> {

            /* renamed from: f  reason: collision with root package name */
            final Iterator<Range<C>> f4249f;
            Iterator<C> q = k1.h();

            C0154b() {
                this.f4249f = ImmutableRangeSet.this.ranges.reverse().iterator();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: d */
            public C a() {
                while (!this.q.hasNext()) {
                    if (!this.f4249f.hasNext()) {
                        return (C) ((Comparable) b());
                    }
                    this.q = ContiguousSet.create(this.f4249f.next(), b.this.f4245c).descendingIterator();
                }
                return this.q.next();
            }
        }

        b(i0<C> i0Var) {
            super(a2.g());
            this.f4245c = i0Var;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: b */
        public ImmutableSortedSet<C> headSetImpl(C c2, boolean z) {
            return d(Range.upTo(c2, BoundType.forBoolean(z)));
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                return ImmutableRangeSet.this.contains((Comparable) obj);
            } catch (ClassCastException unused) {
                return false;
            }
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        ImmutableSortedSet<C> createDescendingSet() {
            return new g0(this);
        }

        ImmutableSortedSet<C> d(Range<C> range) {
            return ImmutableRangeSet.this.subRangeSet((Range) range).asSet(this.f4245c);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: f */
        public ImmutableSortedSet<C> subSetImpl(C c2, boolean z, C c3, boolean z2) {
            if (z || z2 || Range.compareOrThrow(c2, c3) != 0) {
                return d(Range.range(c2, BoundType.forBoolean(z), c3, BoundType.forBoolean(z2)));
            }
            return ImmutableSortedSet.of();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: g */
        public ImmutableSortedSet<C> tailSetImpl(C c2, boolean z) {
            return d(Range.downTo(c2, BoundType.forBoolean(z)));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        public int indexOf(Object obj) {
            if (!contains(obj)) {
                return -1;
            }
            Comparable comparable = (Comparable) obj;
            long j = 0;
            j3 it = ImmutableRangeSet.this.ranges.iterator();
            while (it.hasNext()) {
                Range range = (Range) it.next();
                if (range.contains(comparable)) {
                    return com.google.common.primitives.d.i(j + ContiguousSet.create(range, this.f4245c).indexOf(comparable));
                }
                j += ContiguousSet.create(range, this.f4245c).size();
            }
            throw new AssertionError("impossible");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return ImmutableRangeSet.this.ranges.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Integer num = this.f4246d;
            if (num == null) {
                long j = 0;
                j3 it = ImmutableRangeSet.this.ranges.iterator();
                while (it.hasNext()) {
                    j += ContiguousSet.create((Range) it.next(), this.f4245c).size();
                    if (j >= 2147483647L) {
                        break;
                    }
                }
                num = Integer.valueOf(com.google.common.primitives.d.i(j));
                this.f4246d = num;
            }
            return num.intValue();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return ImmutableRangeSet.this.ranges.toString();
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        Object writeReplace() {
            return new c(ImmutableRangeSet.this.ranges, this.f4245c);
        }

        @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
        public j3<C> descendingIterator() {
            return new C0154b();
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public j3<C> iterator() {
            return new a();
        }
    }

    /* loaded from: classes2.dex */
    private static class c<C extends Comparable> implements Serializable {

        /* renamed from: c  reason: collision with root package name */
        private final ImmutableList<Range<C>> f4250c;

        /* renamed from: d  reason: collision with root package name */
        private final i0<C> f4251d;

        c(ImmutableList<Range<C>> immutableList, i0<C> i0Var) {
            this.f4250c = immutableList;
            this.f4251d = i0Var;
        }
    }

    /* loaded from: classes2.dex */
    public static class d<C extends Comparable<?>> {
        private final List<Range<C>> a = n1.h();

        @CanIgnoreReturnValue
        public d<C> a(Range<C> range) {
            n.j(!range.isEmpty(), "range must not be empty, but was %s", range);
            this.a.add(range);
            return this;
        }

        @CanIgnoreReturnValue
        public d<C> b(Iterable<Range<C>> iterable) {
            for (Range<C> range : iterable) {
                a(range);
            }
            return this;
        }

        public ImmutableRangeSet<C> c() {
            ImmutableList.a aVar = new ImmutableList.a(this.a.size());
            Collections.sort(this.a, Range.rangeLexOrdering());
            b2 q = k1.q(this.a.iterator());
            while (q.hasNext()) {
                Range range = (Range) q.next();
                while (q.hasNext()) {
                    Range<C> range2 = (Range) q.peek();
                    if (range.isConnected(range2)) {
                        n.k(range.intersection(range2).isEmpty(), "Overlapping ranges not permitted but found %s overlapping %s", range, range2);
                        range = range.span((Range) q.next());
                    }
                }
                aVar.a(range);
            }
            ImmutableList j = aVar.j();
            if (j.isEmpty()) {
                return ImmutableRangeSet.of();
            }
            if (j.size() != 1 || !((Range) j1.i(j)).equals(Range.all())) {
                return new ImmutableRangeSet<>(j);
            }
            return ImmutableRangeSet.all();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class e extends ImmutableList<Range<C>> {

        /* renamed from: c  reason: collision with root package name */
        private final boolean f4252c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f4253d;

        /* renamed from: f  reason: collision with root package name */
        private final int f4254f;

        e() {
            boolean hasLowerBound = ((Range) ImmutableRangeSet.this.ranges.get(0)).hasLowerBound();
            this.f4252c = hasLowerBound;
            boolean hasUpperBound = ((Range) j1.f(ImmutableRangeSet.this.ranges)).hasUpperBound();
            this.f4253d = hasUpperBound;
            int size = ImmutableRangeSet.this.ranges.size() - 1;
            size = hasLowerBound ? size + 1 : size;
            this.f4254f = hasUpperBound ? size + 1 : size;
        }

        /* renamed from: a */
        public Range<C> get(int i) {
            d0<C> d0Var;
            d0<C> d0Var2;
            n.m(i, this.f4254f);
            if (this.f4252c) {
                d0Var = i == 0 ? d0.d() : ((Range) ImmutableRangeSet.this.ranges.get(i - 1)).upperBound;
            } else {
                d0Var = ((Range) ImmutableRangeSet.this.ranges.get(i)).upperBound;
            }
            if (!this.f4253d || i != this.f4254f - 1) {
                d0Var2 = ((Range) ImmutableRangeSet.this.ranges.get(i + (!this.f4252c ? 1 : 0))).lowerBound;
            } else {
                d0Var2 = d0.a();
            }
            return Range.create(d0Var, d0Var2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f4254f;
        }
    }

    /* loaded from: classes2.dex */
    private static final class f<C extends Comparable> implements Serializable {

        /* renamed from: c  reason: collision with root package name */
        private final ImmutableList<Range<C>> f4255c;

        f(ImmutableList<Range<C>> immutableList) {
            this.f4255c = immutableList;
        }
    }

    ImmutableRangeSet(ImmutableList<Range<C>> immutableList) {
        this.ranges = immutableList;
    }

    static <C extends Comparable> ImmutableRangeSet<C> all() {
        return ALL;
    }

    public static <C extends Comparable<?>> d<C> builder() {
        return new d<>();
    }

    public static <C extends Comparable> ImmutableRangeSet<C> copyOf(f2<C> f2Var) {
        n.o(f2Var);
        if (f2Var.isEmpty()) {
            return of();
        }
        if (f2Var.encloses(Range.all())) {
            return all();
        }
        if (f2Var instanceof ImmutableRangeSet) {
            ImmutableRangeSet<C> immutableRangeSet = (ImmutableRangeSet) f2Var;
            if (!immutableRangeSet.isPartialView()) {
                return immutableRangeSet;
            }
        }
        return new ImmutableRangeSet<>(ImmutableList.copyOf((Collection) f2Var.asRanges()));
    }

    private ImmutableList<Range<C>> intersectRanges(Range<C> range) {
        int i;
        if (this.ranges.isEmpty() || range.isEmpty()) {
            return ImmutableList.of();
        }
        if (range.encloses(span())) {
            return this.ranges;
        }
        int a2 = range.hasLowerBound() ? z2.a(this.ranges, Range.upperBoundFn(), range.lowerBound, z2.c.q, z2.b.f4668d) : 0;
        if (range.hasUpperBound()) {
            i = z2.a(this.ranges, Range.lowerBoundFn(), range.upperBound, z2.c.f4672f, z2.b.f4668d);
        } else {
            i = this.ranges.size();
        }
        int i2 = i - a2;
        if (i2 == 0) {
            return ImmutableList.of();
        }
        return new a(i2, a2, range);
    }

    public static <C extends Comparable> ImmutableRangeSet<C> of() {
        return EMPTY;
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> unionOf(Iterable<Range<C>> iterable) {
        return copyOf(TreeRangeSet.create(iterable));
    }

    @Override // com.google.common.collect.k
    @Deprecated
    public void add(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.k
    @Deprecated
    public void addAll(f2<C> f2Var) {
        throw new UnsupportedOperationException();
    }

    public ImmutableSortedSet<C> asSet(i0<C> i0Var) {
        n.o(i0Var);
        if (isEmpty()) {
            return ImmutableSortedSet.of();
        }
        Range<C> canonical = span().canonical(i0Var);
        if (canonical.hasLowerBound()) {
            if (!canonical.hasUpperBound()) {
                try {
                    i0Var.f();
                } catch (NoSuchElementException unused) {
                    throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded above");
                }
            }
            return new b(i0Var);
        }
        throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded below");
    }

    @Override // com.google.common.collect.k
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.k
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return super.contains(comparable);
    }

    public ImmutableRangeSet<C> difference(f2<C> f2Var) {
        TreeRangeSet create = TreeRangeSet.create(this);
        create.removeAll(f2Var);
        return copyOf(create);
    }

    @Override // com.google.common.collect.k, com.google.common.collect.f2
    public boolean encloses(Range<C> range) {
        int b2 = z2.b(this.ranges, Range.lowerBoundFn(), range.lowerBound, a2.g(), z2.c.f4670c, z2.b.f4667c);
        return b2 != -1 && this.ranges.get(b2).encloses(range);
    }

    @Override // com.google.common.collect.k
    public /* bridge */ /* synthetic */ boolean enclosesAll(f2 f2Var) {
        return super.enclosesAll(f2Var);
    }

    @Override // com.google.common.collect.k
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    public ImmutableRangeSet<C> intersection(f2<C> f2Var) {
        TreeRangeSet create = TreeRangeSet.create(this);
        create.removeAll(f2Var.complement());
        return copyOf(create);
    }

    @Override // com.google.common.collect.k
    public boolean intersects(Range<C> range) {
        int b2 = z2.b(this.ranges, Range.lowerBoundFn(), range.lowerBound, a2.g(), z2.c.f4670c, z2.b.f4668d);
        if (b2 < this.ranges.size() && this.ranges.get(b2).isConnected(range) && !this.ranges.get(b2).intersection(range).isEmpty()) {
            return true;
        }
        if (b2 > 0) {
            int i = b2 - 1;
            if (this.ranges.get(i).isConnected(range) && !this.ranges.get(i).intersection(range).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.collect.k, com.google.common.collect.f2
    public boolean isEmpty() {
        return this.ranges.isEmpty();
    }

    boolean isPartialView() {
        return this.ranges.isPartialView();
    }

    @Override // com.google.common.collect.k
    public Range<C> rangeContaining(C c2) {
        int b2 = z2.b(this.ranges, Range.lowerBoundFn(), d0.f(c2), a2.g(), z2.c.f4670c, z2.b.f4667c);
        if (b2 == -1) {
            return null;
        }
        Range<C> range = this.ranges.get(b2);
        if (range.contains(c2)) {
            return range;
        }
        return null;
    }

    @Override // com.google.common.collect.k
    @Deprecated
    public void remove(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.k, com.google.common.collect.f2
    @Deprecated
    public void removeAll(f2<C> f2Var) {
        throw new UnsupportedOperationException();
    }

    public Range<C> span() {
        if (!this.ranges.isEmpty()) {
            d0<C> d0Var = this.ranges.get(0).lowerBound;
            ImmutableList<Range<C>> immutableList = this.ranges;
            return Range.create(d0Var, immutableList.get(immutableList.size() - 1).upperBound);
        }
        throw new NoSuchElementException();
    }

    public ImmutableRangeSet<C> union(f2<C> f2Var) {
        return unionOf(j1.c(asRanges(), f2Var.asRanges()));
    }

    Object writeReplace() {
        return new f(this.ranges);
    }

    public static <C extends Comparable> ImmutableRangeSet<C> of(Range<C> range) {
        n.o(range);
        if (range.isEmpty()) {
            return of();
        }
        if (range.equals(Range.all())) {
            return all();
        }
        return new ImmutableRangeSet<>(ImmutableList.of(range));
    }

    @Override // com.google.common.collect.k
    @Deprecated
    public void addAll(Iterable<Range<C>> iterable) {
        throw new UnsupportedOperationException();
    }

    public ImmutableSet<Range<C>> asDescendingSetOfRanges() {
        if (this.ranges.isEmpty()) {
            return ImmutableSet.of();
        }
        return new n2(this.ranges.reverse(), Range.rangeLexOrdering().j());
    }

    @Override // com.google.common.collect.f2
    public ImmutableSet<Range<C>> asRanges() {
        if (this.ranges.isEmpty()) {
            return ImmutableSet.of();
        }
        return new n2(this.ranges, Range.rangeLexOrdering());
    }

    @Override // com.google.common.collect.f2
    public ImmutableRangeSet<C> complement() {
        ImmutableRangeSet<C> immutableRangeSet = this.complement;
        if (immutableRangeSet != null) {
            return immutableRangeSet;
        }
        if (this.ranges.isEmpty()) {
            ImmutableRangeSet<C> all = all();
            this.complement = all;
            return all;
        } else if (this.ranges.size() != 1 || !this.ranges.get(0).equals(Range.all())) {
            ImmutableRangeSet<C> immutableRangeSet2 = new ImmutableRangeSet<>(new e(), this);
            this.complement = immutableRangeSet2;
            return immutableRangeSet2;
        } else {
            ImmutableRangeSet<C> of = of();
            this.complement = of;
            return of;
        }
    }

    @Override // com.google.common.collect.k
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable iterable) {
        return super.enclosesAll(iterable);
    }

    @Override // com.google.common.collect.k
    @Deprecated
    public void removeAll(Iterable<Range<C>> iterable) {
        throw new UnsupportedOperationException();
    }

    public ImmutableRangeSet<C> subRangeSet(Range<C> range) {
        if (!isEmpty()) {
            Range<C> span = span();
            if (range.encloses(span)) {
                return this;
            }
            if (range.isConnected(span)) {
                return new ImmutableRangeSet<>(intersectRanges(range));
            }
        }
        return of();
    }

    private ImmutableRangeSet(ImmutableList<Range<C>> immutableList, ImmutableRangeSet<C> immutableRangeSet) {
        this.ranges = immutableList;
        this.complement = immutableRangeSet;
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> copyOf(Iterable<Range<C>> iterable) {
        return new d().b(iterable).c();
    }
}
