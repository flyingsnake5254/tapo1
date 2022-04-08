package com.google.common.collect;

import com.google.common.base.h;
import com.google.common.base.n;
import com.google.common.base.t;
import com.google.common.collect.q1;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes2.dex */
public class TreeBasedTable<R, C, V> extends d3<R, C, V> {
    private static final long serialVersionUID = 0;
    private final Comparator<? super C> columnComparator;

    /* loaded from: classes2.dex */
    class a implements h<Map<C, V>, Iterator<C>> {
        a() {
        }

        /* renamed from: a */
        public Iterator<C> apply(Map<C, V> map) {
            return map.keySet().iterator();
        }
    }

    /* loaded from: classes2.dex */
    class b extends c<C> {
        @NullableDecl

        /* renamed from: f  reason: collision with root package name */
        C f4319f;
        final /* synthetic */ Iterator q;
        final /* synthetic */ Comparator x;

        b(Iterator it, Comparator comparator) {
            this.q = it;
            this.x = comparator;
        }

        @Override // com.google.common.collect.c
        protected C a() {
            boolean z;
            while (this.q.hasNext()) {
                C c2 = (C) this.q.next();
                C c3 = this.f4319f;
                if (c3 == null || this.x.compare(c2, c3) != 0) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (!z) {
                    this.f4319f = c2;
                    return c2;
                }
            }
            this.f4319f = null;
            return b();
        }
    }

    /* loaded from: classes2.dex */
    private static class c<C, V> implements t<TreeMap<C, V>>, Serializable {

        /* renamed from: c  reason: collision with root package name */
        final Comparator<? super C> f4320c;

        c(Comparator<? super C> comparator) {
            this.f4320c = comparator;
        }

        /* renamed from: a */
        public TreeMap<C, V> get() {
            return new TreeMap<>(this.f4320c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d extends e3<R, C, V>.g implements SortedMap<C, V> {
        @NullableDecl
        final C q;
        @NullableDecl
        final C x;
        @NullableDecl
        transient SortedMap<C, V> y;

        d(TreeBasedTable treeBasedTable, R r) {
            this(r, null, null);
        }

        @Override // java.util.SortedMap
        public Comparator<? super C> comparator() {
            return TreeBasedTable.this.columnComparator();
        }

        @Override // com.google.common.collect.e3.g, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return j(obj) && super.containsKey(obj);
        }

        @Override // com.google.common.collect.e3.g
        void d() {
            if (k() != null && this.y.isEmpty()) {
                TreeBasedTable.this.backingMap.remove(this.f4438c);
                this.y = null;
                this.f4439d = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: f */
        public SortedMap<C, V> b() {
            return (SortedMap) super.b();
        }

        @Override // java.util.SortedMap
        public C firstKey() {
            if (b() != null) {
                return b().firstKey();
            }
            throw new NoSuchElementException();
        }

        int g(Object obj, Object obj2) {
            return comparator().compare(obj, obj2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: h */
        public SortedMap<C, V> c() {
            SortedMap<C, V> k = k();
            if (k == null) {
                return null;
            }
            C c2 = this.q;
            if (c2 != null) {
                k = k.tailMap(c2);
            }
            C c3 = this.x;
            return c3 != null ? k.headMap(c3) : k;
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> headMap(C c2) {
            n.d(j(n.o(c2)));
            return new d(this.f4438c, this.q, c2);
        }

        /* renamed from: i */
        public SortedSet<C> keySet() {
            return new q1.o(this);
        }

        boolean j(@NullableDecl Object obj) {
            C c2;
            C c3;
            return obj != null && ((c2 = this.q) == null || g(c2, obj) <= 0) && ((c3 = this.x) == null || g(c3, obj) > 0);
        }

        SortedMap<C, V> k() {
            SortedMap<C, V> sortedMap = this.y;
            if (sortedMap == null || (sortedMap.isEmpty() && TreeBasedTable.this.backingMap.containsKey(this.f4438c))) {
                this.y = (SortedMap) TreeBasedTable.this.backingMap.get(this.f4438c);
            }
            return this.y;
        }

        @Override // java.util.SortedMap
        public C lastKey() {
            if (b() != null) {
                return b().lastKey();
            }
            throw new NoSuchElementException();
        }

        @Override // com.google.common.collect.e3.g, java.util.AbstractMap, java.util.Map
        public V put(C c2, V v) {
            n.d(j(n.o(c2)));
            return (V) super.put(c2, v);
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> subMap(C c2, C c3) {
            n.d(j(n.o(c2)) && j(n.o(c3)));
            return new d(this.f4438c, c2, c3);
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> tailMap(C c2) {
            n.d(j(n.o(c2)));
            return new d(this.f4438c, c2, this.x);
        }

        d(R r, @NullableDecl C c2, @NullableDecl C c3) {
            super(r);
            this.q = c2;
            this.x = c3;
            n.d(c2 == null || c3 == null || g(c2, c3) <= 0);
        }
    }

    TreeBasedTable(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        super(new TreeMap(comparator), new c(comparator2));
        this.columnComparator = comparator2;
    }

    public static <R extends Comparable, C extends Comparable, V> TreeBasedTable<R, C, V> create() {
        return new TreeBasedTable<>(a2.g(), a2.g());
    }

    @Override // com.google.common.collect.e3, com.google.common.collect.q, com.google.common.collect.f3
    public /* bridge */ /* synthetic */ Set cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.e3, com.google.common.collect.q
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.e3
    public /* bridge */ /* synthetic */ Map column(Object obj) {
        return super.column(obj);
    }

    @Deprecated
    public Comparator<? super C> columnComparator() {
        return this.columnComparator;
    }

    @Override // com.google.common.collect.e3, com.google.common.collect.q, com.google.common.collect.f3
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return super.columnKeySet();
    }

    @Override // com.google.common.collect.e3, com.google.common.collect.f3
    public /* bridge */ /* synthetic */ Map columnMap() {
        return super.columnMap();
    }

    @Override // com.google.common.collect.e3, com.google.common.collect.q
    public /* bridge */ /* synthetic */ boolean contains(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.contains(obj, obj2);
    }

    @Override // com.google.common.collect.e3, com.google.common.collect.q
    public /* bridge */ /* synthetic */ boolean containsColumn(@NullableDecl Object obj) {
        return super.containsColumn(obj);
    }

    @Override // com.google.common.collect.e3, com.google.common.collect.q
    public /* bridge */ /* synthetic */ boolean containsRow(@NullableDecl Object obj) {
        return super.containsRow(obj);
    }

    @Override // com.google.common.collect.e3, com.google.common.collect.q
    public /* bridge */ /* synthetic */ boolean containsValue(@NullableDecl Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.e3
    Iterator<C> createColumnKeyIterator() {
        Comparator<? super C> columnComparator = columnComparator();
        return new b(k1.p(j1.o(this.backingMap.values(), new a()), columnComparator), columnComparator);
    }

    @Override // com.google.common.collect.q
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.e3, com.google.common.collect.q
    public /* bridge */ /* synthetic */ Object get(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.get(obj, obj2);
    }

    @Override // com.google.common.collect.q
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.e3, com.google.common.collect.q
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.e3, com.google.common.collect.q
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2, Object obj3) {
        return super.put(obj, obj2, obj3);
    }

    @Override // com.google.common.collect.q
    public /* bridge */ /* synthetic */ void putAll(f3 f3Var) {
        super.putAll(f3Var);
    }

    @Override // com.google.common.collect.e3, com.google.common.collect.q
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Object remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.remove(obj, obj2);
    }

    @Deprecated
    public Comparator<? super R> rowComparator() {
        return rowKeySet().comparator();
    }

    @Override // com.google.common.collect.e3, com.google.common.collect.f3
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.q
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.e3, com.google.common.collect.q
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        n.o(comparator);
        n.o(comparator2);
        return new TreeBasedTable<>(comparator, comparator2);
    }

    @Override // com.google.common.collect.e3
    public SortedMap<C, V> row(R r) {
        return new d(this, r);
    }

    @Override // com.google.common.collect.d3, com.google.common.collect.e3, com.google.common.collect.q, com.google.common.collect.f3
    public SortedSet<R> rowKeySet() {
        return super.rowKeySet();
    }

    @Override // com.google.common.collect.d3, com.google.common.collect.e3, com.google.common.collect.f3
    public SortedMap<R, Map<C, V>> rowMap() {
        return super.rowMap();
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(TreeBasedTable<R, C, ? extends V> treeBasedTable) {
        TreeBasedTable<R, C, V> treeBasedTable2 = new TreeBasedTable<>(treeBasedTable.rowComparator(), treeBasedTable.columnComparator());
        treeBasedTable2.putAll(treeBasedTable);
        return treeBasedTable2;
    }
}
