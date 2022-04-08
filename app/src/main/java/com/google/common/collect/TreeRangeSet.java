package com.google.common.collect;

import com.google.common.base.j;
import com.google.common.base.n;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes2.dex */
public class TreeRangeSet<C extends Comparable<?>> extends k<C> implements Serializable {
    @MonotonicNonNullDecl
    private transient Set<Range<C>> asDescendingSetOfRanges;
    @MonotonicNonNullDecl
    private transient Set<Range<C>> asRanges;
    @MonotonicNonNullDecl
    private transient f2<C> complement;
    final NavigableMap<d0<C>, Range<C>> rangesByLowerBound;

    /* loaded from: classes2.dex */
    final class b extends n0<Range<C>> implements Set<Range<C>> {

        /* renamed from: c  reason: collision with root package name */
        final Collection<Range<C>> f4337c;

        b(Collection<Range<C>> collection) {
            this.f4337c = collection;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@NullableDecl Object obj) {
            return u2.a(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return u2.b(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.n0, com.google.common.collect.s0
        public Collection<Range<C>> delegate() {
            return this.f4337c;
        }
    }

    /* loaded from: classes2.dex */
    private final class c extends TreeRangeSet<C> {
        c() {
            super(new d(TreeRangeSet.this.rangesByLowerBound));
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.k
        public void add(Range<C> range) {
            TreeRangeSet.this.remove(range);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f2
        public f2<C> complement() {
            return TreeRangeSet.this;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.k
        public boolean contains(C c2) {
            return !TreeRangeSet.this.contains(c2);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.k
        public void remove(Range<C> range) {
            TreeRangeSet.this.add(range);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class d<C extends Comparable<?>> extends j<d0<C>, Range<C>> {

        /* renamed from: c  reason: collision with root package name */
        private final NavigableMap<d0<C>, Range<C>> f4340c;

        /* renamed from: d  reason: collision with root package name */
        private final NavigableMap<d0<C>, Range<C>> f4341d;

        /* renamed from: f  reason: collision with root package name */
        private final Range<d0<C>> f4342f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class a extends c<Map.Entry<d0<C>, Range<C>>> {

            /* renamed from: f  reason: collision with root package name */
            d0<C> f4343f;
            final /* synthetic */ d0 q;
            final /* synthetic */ b2 x;

            a(d0 d0Var, b2 b2Var) {
                this.q = d0Var;
                this.x = b2Var;
                this.f4343f = d0Var;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: d */
            public Map.Entry<d0<C>, Range<C>> a() {
                Range range;
                if (d.this.f4342f.upperBound.m(this.f4343f) || this.f4343f == d0.a()) {
                    return (Map.Entry) b();
                }
                if (this.x.hasNext()) {
                    Range range2 = (Range) this.x.next();
                    range = Range.create(this.f4343f, range2.lowerBound);
                    this.f4343f = range2.upperBound;
                } else {
                    range = Range.create(this.f4343f, d0.a());
                    this.f4343f = d0.a();
                }
                return q1.i(range.lowerBound, range);
            }
        }

        /* loaded from: classes2.dex */
        class b extends c<Map.Entry<d0<C>, Range<C>>> {

            /* renamed from: f  reason: collision with root package name */
            d0<C> f4344f;
            final /* synthetic */ d0 q;
            final /* synthetic */ b2 x;

            b(d0 d0Var, b2 b2Var) {
                this.q = d0Var;
                this.x = b2Var;
                this.f4344f = d0Var;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: d */
            public Map.Entry<d0<C>, Range<C>> a() {
                if (this.f4344f == d0.d()) {
                    return (Map.Entry) b();
                }
                if (this.x.hasNext()) {
                    Range range = (Range) this.x.next();
                    Range create = Range.create(range.upperBound, this.f4344f);
                    this.f4344f = range.lowerBound;
                    if (d.this.f4342f.lowerBound.m(create.lowerBound)) {
                        return q1.i(create.lowerBound, create);
                    }
                } else if (d.this.f4342f.lowerBound.m(d0.d())) {
                    Range create2 = Range.create(d0.d(), this.f4344f);
                    this.f4344f = d0.d();
                    return q1.i(d0.d(), create2);
                }
                return (Map.Entry) b();
            }
        }

        d(NavigableMap<d0<C>, Range<C>> navigableMap) {
            this(navigableMap, Range.all());
        }

        private NavigableMap<d0<C>, Range<C>> g(Range<d0<C>> range) {
            if (!this.f4342f.isConnected(range)) {
                return ImmutableSortedMap.of();
            }
            return new d(this.f4340c, range.intersection(this.f4342f));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.q1.l
        public Iterator<Map.Entry<d0<C>, Range<C>>> a() {
            Collection<Range<C>> collection;
            d0 d0Var;
            if (this.f4342f.hasLowerBound()) {
                collection = this.f4341d.tailMap(this.f4342f.lowerEndpoint(), this.f4342f.lowerBoundType() == BoundType.CLOSED).values();
            } else {
                collection = this.f4341d.values();
            }
            b2 q = k1.q(collection.iterator());
            if (this.f4342f.contains(d0.d()) && (!q.hasNext() || ((Range) q.peek()).lowerBound != d0.d())) {
                d0Var = d0.d();
            } else if (!q.hasNext()) {
                return k1.h();
            } else {
                d0Var = ((Range) q.next()).upperBound;
            }
            return new a(d0Var, q);
        }

        @Override // com.google.common.collect.j
        Iterator<Map.Entry<d0<C>, Range<C>>> b() {
            d0<C> d0Var;
            d0<C> d0Var2;
            if (this.f4342f.hasUpperBound()) {
                d0Var = this.f4342f.upperEndpoint();
            } else {
                d0Var = d0.a();
            }
            b2 q = k1.q(this.f4341d.headMap(d0Var, this.f4342f.hasUpperBound() && this.f4342f.upperBoundType() == BoundType.CLOSED).descendingMap().values().iterator());
            if (q.hasNext()) {
                if (((Range) q.peek()).upperBound == d0.a()) {
                    d0Var2 = ((Range) q.next()).lowerBound;
                } else {
                    d0Var2 = this.f4340c.higherKey(((Range) q.peek()).upperBound);
                }
            } else if (!this.f4342f.contains(d0.d()) || this.f4340c.containsKey(d0.d())) {
                return k1.h();
            } else {
                d0Var2 = this.f4340c.higherKey(d0.d());
            }
            return new b((d0) j.a(d0Var2, d0.a()), q);
        }

        @Override // java.util.SortedMap
        public Comparator<? super d0<C>> comparator() {
            return a2.g();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        @NullableDecl
        /* renamed from: d */
        public Range<C> get(Object obj) {
            if (obj instanceof d0) {
                try {
                    d0<C> d0Var = (d0) obj;
                    Map.Entry<d0<C>, Range<C>> firstEntry = tailMap(d0Var, true).firstEntry();
                    if (firstEntry != null && firstEntry.getKey().equals(d0Var)) {
                        return firstEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        /* renamed from: e */
        public NavigableMap<d0<C>, Range<C>> headMap(d0<C> d0Var, boolean z) {
            return g(Range.upTo(d0Var, BoundType.forBoolean(z)));
        }

        /* renamed from: f */
        public NavigableMap<d0<C>, Range<C>> subMap(d0<C> d0Var, boolean z, d0<C> d0Var2, boolean z2) {
            return g(Range.range(d0Var, BoundType.forBoolean(z), d0Var2, BoundType.forBoolean(z2)));
        }

        /* renamed from: h */
        public NavigableMap<d0<C>, Range<C>> tailMap(d0<C> d0Var, boolean z) {
            return g(Range.downTo(d0Var, BoundType.forBoolean(z)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return k1.v(a());
        }

        private d(NavigableMap<d0<C>, Range<C>> navigableMap, Range<d0<C>> range) {
            this.f4340c = navigableMap;
            this.f4341d = new e(navigableMap);
            this.f4342f = range;
        }
    }

    /* loaded from: classes2.dex */
    private final class f extends TreeRangeSet<C> {

        /* renamed from: c  reason: collision with root package name */
        private final Range<C> f4349c;

        f(Range<C> range) {
            super(new g(Range.all(), range, TreeRangeSet.this.rangesByLowerBound));
            this.f4349c = range;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.k
        public void add(Range<C> range) {
            n.k(this.f4349c.encloses(range), "Cannot add range %s to subRangeSet(%s)", range, this.f4349c);
            TreeRangeSet.super.add(range);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.k
        public void clear() {
            TreeRangeSet.this.remove(this.f4349c);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.k
        public boolean contains(C c2) {
            return this.f4349c.contains(c2) && TreeRangeSet.this.contains(c2);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.k, com.google.common.collect.f2
        public boolean encloses(Range<C> range) {
            Range rangeEnclosing;
            return !this.f4349c.isEmpty() && this.f4349c.encloses(range) && (rangeEnclosing = TreeRangeSet.this.rangeEnclosing(range)) != null && !rangeEnclosing.intersection(this.f4349c).isEmpty();
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.k
        @NullableDecl
        public Range<C> rangeContaining(C c2) {
            Range<C> rangeContaining;
            if (this.f4349c.contains(c2) && (rangeContaining = TreeRangeSet.this.rangeContaining(c2)) != null) {
                return rangeContaining.intersection(this.f4349c);
            }
            return null;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.k
        public void remove(Range<C> range) {
            if (range.isConnected(this.f4349c)) {
                TreeRangeSet.this.remove(range.intersection(this.f4349c));
            }
        }

        @Override // com.google.common.collect.TreeRangeSet
        public f2<C> subRangeSet(Range<C> range) {
            if (range.encloses(this.f4349c)) {
                return this;
            }
            if (range.isConnected(this.f4349c)) {
                return new f(this.f4349c.intersection(range));
            }
            return ImmutableRangeSet.of();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class g<C extends Comparable<?>> extends j<d0<C>, Range<C>> {

        /* renamed from: c  reason: collision with root package name */
        private final Range<d0<C>> f4351c;

        /* renamed from: d  reason: collision with root package name */
        private final Range<C> f4352d;

        /* renamed from: f  reason: collision with root package name */
        private final NavigableMap<d0<C>, Range<C>> f4353f;
        private final NavigableMap<d0<C>, Range<C>> q;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class a extends c<Map.Entry<d0<C>, Range<C>>> {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ Iterator f4354f;
            final /* synthetic */ d0 q;

            a(Iterator it, d0 d0Var) {
                this.f4354f = it;
                this.q = d0Var;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: d */
            public Map.Entry<d0<C>, Range<C>> a() {
                if (!this.f4354f.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.f4354f.next();
                if (this.q.m(range.lowerBound)) {
                    return (Map.Entry) b();
                }
                Range intersection = range.intersection(g.this.f4352d);
                return q1.i(intersection.lowerBound, intersection);
            }
        }

        /* loaded from: classes2.dex */
        class b extends c<Map.Entry<d0<C>, Range<C>>> {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ Iterator f4355f;

            b(Iterator it) {
                this.f4355f = it;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: d */
            public Map.Entry<d0<C>, Range<C>> a() {
                if (!this.f4355f.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.f4355f.next();
                if (g.this.f4352d.lowerBound.compareTo(range.upperBound) >= 0) {
                    return (Map.Entry) b();
                }
                Range intersection = range.intersection(g.this.f4352d);
                if (g.this.f4351c.contains(intersection.lowerBound)) {
                    return q1.i(intersection.lowerBound, intersection);
                }
                return (Map.Entry) b();
            }
        }

        private NavigableMap<d0<C>, Range<C>> h(Range<d0<C>> range) {
            if (!range.isConnected(this.f4351c)) {
                return ImmutableSortedMap.of();
            }
            return new g(this.f4351c.intersection(range), this.f4352d, this.f4353f);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.q1.l
        public Iterator<Map.Entry<d0<C>, Range<C>>> a() {
            Iterator<Range<C>> it;
            if (this.f4352d.isEmpty()) {
                return k1.h();
            }
            if (this.f4351c.upperBound.m(this.f4352d.lowerBound)) {
                return k1.h();
            }
            boolean z = false;
            if (this.f4351c.lowerBound.m(this.f4352d.lowerBound)) {
                it = this.q.tailMap(this.f4352d.lowerBound, false).values().iterator();
            } else {
                NavigableMap<d0<C>, Range<C>> navigableMap = this.f4353f;
                d0<C> k = this.f4351c.lowerBound.k();
                if (this.f4351c.lowerBoundType() == BoundType.CLOSED) {
                    z = true;
                }
                it = navigableMap.tailMap(k, z).values().iterator();
            }
            return new a(it, (d0) a2.g().f(this.f4351c.upperBound, d0.f(this.f4352d.upperBound)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.j
        Iterator<Map.Entry<d0<C>, Range<C>>> b() {
            if (this.f4352d.isEmpty()) {
                return k1.h();
            }
            d0 d0Var = (d0) a2.g().f(this.f4351c.upperBound, d0.f(this.f4352d.upperBound));
            return new b(this.f4353f.headMap(d0Var.k(), d0Var.p() == BoundType.CLOSED).descendingMap().values().iterator());
        }

        @Override // java.util.SortedMap
        public Comparator<? super d0<C>> comparator() {
            return a2.g();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@NullableDecl Object obj) {
            return get(obj) != null;
        }

        @NullableDecl
        /* renamed from: e */
        public Range<C> get(@NullableDecl Object obj) {
            if (obj instanceof d0) {
                try {
                    d0<C> d0Var = (d0) obj;
                    if (this.f4351c.contains(d0Var) && d0Var.compareTo(this.f4352d.lowerBound) >= 0 && d0Var.compareTo(this.f4352d.upperBound) < 0) {
                        if (d0Var.equals(this.f4352d.lowerBound)) {
                            Range range = (Range) q1.E(this.f4353f.floorEntry(d0Var));
                            if (range != null && range.upperBound.compareTo(this.f4352d.lowerBound) > 0) {
                                return range.intersection(this.f4352d);
                            }
                        } else {
                            Range range2 = (Range) this.f4353f.get(d0Var);
                            if (range2 != null) {
                                return range2.intersection(this.f4352d);
                            }
                        }
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        /* renamed from: f */
        public NavigableMap<d0<C>, Range<C>> headMap(d0<C> d0Var, boolean z) {
            return h(Range.upTo(d0Var, BoundType.forBoolean(z)));
        }

        /* renamed from: g */
        public NavigableMap<d0<C>, Range<C>> subMap(d0<C> d0Var, boolean z, d0<C> d0Var2, boolean z2) {
            return h(Range.range(d0Var, BoundType.forBoolean(z), d0Var2, BoundType.forBoolean(z2)));
        }

        /* renamed from: i */
        public NavigableMap<d0<C>, Range<C>> tailMap(d0<C> d0Var, boolean z) {
            return h(Range.downTo(d0Var, BoundType.forBoolean(z)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return k1.v(a());
        }

        private g(Range<d0<C>> range, Range<C> range2, NavigableMap<d0<C>, Range<C>> navigableMap) {
            this.f4351c = (Range) n.o(range);
            this.f4352d = (Range) n.o(range2);
            this.f4353f = (NavigableMap) n.o(navigableMap);
            this.q = new e(navigableMap);
        }
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create() {
        return new TreeRangeSet<>(new TreeMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NullableDecl
    public Range<C> rangeEnclosing(Range<C> range) {
        n.o(range);
        Map.Entry<d0<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        if (floorEntry == null || !floorEntry.getValue().encloses(range)) {
            return null;
        }
        return floorEntry.getValue();
    }

    private void replaceRangeWithSameLowerBound(Range<C> range) {
        if (range.isEmpty()) {
            this.rangesByLowerBound.remove(range.lowerBound);
        } else {
            this.rangesByLowerBound.put(range.lowerBound, range);
        }
    }

    @Override // com.google.common.collect.k
    public void add(Range<C> range) {
        n.o(range);
        if (!range.isEmpty()) {
            d0<C> d0Var = range.lowerBound;
            d0<C> d0Var2 = range.upperBound;
            Map.Entry<d0<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(d0Var);
            if (lowerEntry != null) {
                Range<C> value = lowerEntry.getValue();
                if (value.upperBound.compareTo(d0Var) >= 0) {
                    if (value.upperBound.compareTo(d0Var2) >= 0) {
                        d0Var2 = value.upperBound;
                    }
                    d0Var = value.lowerBound;
                }
            }
            Map.Entry<d0<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(d0Var2);
            if (floorEntry != null) {
                Range<C> value2 = floorEntry.getValue();
                if (value2.upperBound.compareTo(d0Var2) >= 0) {
                    d0Var2 = value2.upperBound;
                }
            }
            this.rangesByLowerBound.subMap(d0Var, d0Var2).clear();
            replaceRangeWithSameLowerBound(Range.create(d0Var, d0Var2));
        }
    }

    @Override // com.google.common.collect.k
    public /* bridge */ /* synthetic */ void addAll(f2 f2Var) {
        super.addAll(f2Var);
    }

    public Set<Range<C>> asDescendingSetOfRanges() {
        Set<Range<C>> set = this.asDescendingSetOfRanges;
        if (set != null) {
            return set;
        }
        b bVar = new b(this.rangesByLowerBound.descendingMap().values());
        this.asDescendingSetOfRanges = bVar;
        return bVar;
    }

    @Override // com.google.common.collect.f2
    public Set<Range<C>> asRanges() {
        Set<Range<C>> set = this.asRanges;
        if (set != null) {
            return set;
        }
        b bVar = new b(this.rangesByLowerBound.values());
        this.asRanges = bVar;
        return bVar;
    }

    @Override // com.google.common.collect.k
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.f2
    public f2<C> complement() {
        f2<C> f2Var = this.complement;
        if (f2Var != null) {
            return f2Var;
        }
        c cVar = new c();
        this.complement = cVar;
        return cVar;
    }

    @Override // com.google.common.collect.k
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return super.contains(comparable);
    }

    @Override // com.google.common.collect.k, com.google.common.collect.f2
    public boolean encloses(Range<C> range) {
        n.o(range);
        Map.Entry<d0<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        return floorEntry != null && floorEntry.getValue().encloses(range);
    }

    @Override // com.google.common.collect.k
    public /* bridge */ /* synthetic */ boolean enclosesAll(f2 f2Var) {
        return super.enclosesAll(f2Var);
    }

    @Override // com.google.common.collect.k
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.k
    public boolean intersects(Range<C> range) {
        n.o(range);
        Map.Entry<d0<C>, Range<C>> ceilingEntry = this.rangesByLowerBound.ceilingEntry(range.lowerBound);
        if (ceilingEntry != null && ceilingEntry.getValue().isConnected(range) && !ceilingEntry.getValue().intersection(range).isEmpty()) {
            return true;
        }
        Map.Entry<d0<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
        return lowerEntry != null && lowerEntry.getValue().isConnected(range) && !lowerEntry.getValue().intersection(range).isEmpty();
    }

    @Override // com.google.common.collect.k, com.google.common.collect.f2
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.k
    @NullableDecl
    public Range<C> rangeContaining(C c2) {
        n.o(c2);
        Map.Entry<d0<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(d0.f(c2));
        if (floorEntry == null || !floorEntry.getValue().contains(c2)) {
            return null;
        }
        return floorEntry.getValue();
    }

    @Override // com.google.common.collect.k
    public void remove(Range<C> range) {
        n.o(range);
        if (!range.isEmpty()) {
            Map.Entry<d0<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
            if (lowerEntry != null) {
                Range<C> value = lowerEntry.getValue();
                if (value.upperBound.compareTo(range.lowerBound) >= 0) {
                    if (range.hasUpperBound() && value.upperBound.compareTo(range.upperBound) >= 0) {
                        replaceRangeWithSameLowerBound(Range.create(range.upperBound, value.upperBound));
                    }
                    replaceRangeWithSameLowerBound(Range.create(value.lowerBound, range.lowerBound));
                }
            }
            Map.Entry<d0<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.upperBound);
            if (floorEntry != null) {
                Range<C> value2 = floorEntry.getValue();
                if (range.hasUpperBound() && value2.upperBound.compareTo(range.upperBound) >= 0) {
                    replaceRangeWithSameLowerBound(Range.create(range.upperBound, value2.upperBound));
                }
            }
            this.rangesByLowerBound.subMap(range.lowerBound, range.upperBound).clear();
        }
    }

    @Override // com.google.common.collect.k, com.google.common.collect.f2
    public /* bridge */ /* synthetic */ void removeAll(f2 f2Var) {
        super.removeAll(f2Var);
    }

    public Range<C> span() {
        Map.Entry<d0<C>, Range<C>> firstEntry = this.rangesByLowerBound.firstEntry();
        Map.Entry<d0<C>, Range<C>> lastEntry = this.rangesByLowerBound.lastEntry();
        if (firstEntry != null) {
            return Range.create(firstEntry.getValue().lowerBound, lastEntry.getValue().upperBound);
        }
        throw new NoSuchElementException();
    }

    public f2<C> subRangeSet(Range<C> range) {
        return range.equals(Range.all()) ? this : new f(range);
    }

    private TreeRangeSet(NavigableMap<d0<C>, Range<C>> navigableMap) {
        this.rangesByLowerBound = navigableMap;
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(f2<C> f2Var) {
        TreeRangeSet<C> create = create();
        create.addAll(f2Var);
        return create;
    }

    @Override // com.google.common.collect.k
    public /* bridge */ /* synthetic */ void addAll(Iterable iterable) {
        super.addAll(iterable);
    }

    @Override // com.google.common.collect.k
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable iterable) {
        return super.enclosesAll(iterable);
    }

    @Override // com.google.common.collect.k
    public /* bridge */ /* synthetic */ void removeAll(Iterable iterable) {
        super.removeAll(iterable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class e<C extends Comparable<?>> extends j<d0<C>, Range<C>> {

        /* renamed from: c  reason: collision with root package name */
        private final NavigableMap<d0<C>, Range<C>> f4345c;

        /* renamed from: d  reason: collision with root package name */
        private final Range<d0<C>> f4346d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class a extends c<Map.Entry<d0<C>, Range<C>>> {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ Iterator f4347f;

            a(Iterator it) {
                this.f4347f = it;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: d */
            public Map.Entry<d0<C>, Range<C>> a() {
                if (!this.f4347f.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.f4347f.next();
                if (e.this.f4346d.upperBound.m(range.upperBound)) {
                    return (Map.Entry) b();
                }
                return q1.i(range.upperBound, range);
            }
        }

        /* loaded from: classes2.dex */
        class b extends c<Map.Entry<d0<C>, Range<C>>> {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ b2 f4348f;

            b(b2 b2Var) {
                this.f4348f = b2Var;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: d */
            public Map.Entry<d0<C>, Range<C>> a() {
                if (!this.f4348f.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.f4348f.next();
                if (e.this.f4346d.lowerBound.m(range.upperBound)) {
                    return q1.i(range.upperBound, range);
                }
                return (Map.Entry) b();
            }
        }

        e(NavigableMap<d0<C>, Range<C>> navigableMap) {
            this.f4345c = navigableMap;
            this.f4346d = Range.all();
        }

        private NavigableMap<d0<C>, Range<C>> g(Range<d0<C>> range) {
            if (range.isConnected(this.f4346d)) {
                return new e(this.f4345c, range.intersection(this.f4346d));
            }
            return ImmutableSortedMap.of();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.q1.l
        public Iterator<Map.Entry<d0<C>, Range<C>>> a() {
            Iterator<Range<C>> it;
            if (!this.f4346d.hasLowerBound()) {
                it = this.f4345c.values().iterator();
            } else {
                Map.Entry<d0<C>, Range<C>> lowerEntry = this.f4345c.lowerEntry(this.f4346d.lowerEndpoint());
                if (lowerEntry == null) {
                    it = this.f4345c.values().iterator();
                } else if (this.f4346d.lowerBound.m(lowerEntry.getValue().upperBound)) {
                    it = this.f4345c.tailMap(lowerEntry.getKey(), true).values().iterator();
                } else {
                    it = this.f4345c.tailMap(this.f4346d.lowerEndpoint(), true).values().iterator();
                }
            }
            return new a(it);
        }

        @Override // com.google.common.collect.j
        Iterator<Map.Entry<d0<C>, Range<C>>> b() {
            Collection<Range<C>> collection;
            if (this.f4346d.hasUpperBound()) {
                collection = this.f4345c.headMap(this.f4346d.upperEndpoint(), false).descendingMap().values();
            } else {
                collection = this.f4345c.descendingMap().values();
            }
            b2 q = k1.q(collection.iterator());
            if (q.hasNext() && this.f4346d.upperBound.m(((Range) q.peek()).upperBound)) {
                q.next();
            }
            return new b(q);
        }

        @Override // java.util.SortedMap
        public Comparator<? super d0<C>> comparator() {
            return a2.g();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@NullableDecl Object obj) {
            return get(obj) != null;
        }

        /* renamed from: d */
        public Range<C> get(@NullableDecl Object obj) {
            Map.Entry<d0<C>, Range<C>> lowerEntry;
            if (obj instanceof d0) {
                try {
                    d0<C> d0Var = (d0) obj;
                    if (this.f4346d.contains(d0Var) && (lowerEntry = this.f4345c.lowerEntry(d0Var)) != null && lowerEntry.getValue().upperBound.equals(d0Var)) {
                        return lowerEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        /* renamed from: e */
        public NavigableMap<d0<C>, Range<C>> headMap(d0<C> d0Var, boolean z) {
            return g(Range.upTo(d0Var, BoundType.forBoolean(z)));
        }

        /* renamed from: f */
        public NavigableMap<d0<C>, Range<C>> subMap(d0<C> d0Var, boolean z, d0<C> d0Var2, boolean z2) {
            return g(Range.range(d0Var, BoundType.forBoolean(z), d0Var2, BoundType.forBoolean(z2)));
        }

        /* renamed from: h */
        public NavigableMap<d0<C>, Range<C>> tailMap(d0<C> d0Var, boolean z) {
            return g(Range.downTo(d0Var, BoundType.forBoolean(z)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            if (this.f4346d.equals(Range.all())) {
                return this.f4345c.isEmpty();
            }
            return !a().hasNext();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            if (this.f4346d.equals(Range.all())) {
                return this.f4345c.size();
            }
            return k1.v(a());
        }

        private e(NavigableMap<d0<C>, Range<C>> navigableMap, Range<d0<C>> range) {
            this.f4345c = navigableMap;
            this.f4346d = range;
        }
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(Iterable<Range<C>> iterable) {
        TreeRangeSet<C> create = create();
        create.addAll(iterable);
        return create;
    }
}
