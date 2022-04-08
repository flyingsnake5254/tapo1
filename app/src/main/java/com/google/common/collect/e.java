package com.google.common.collect;

import com.google.common.collect.h;
import com.google.common.collect.q1;
import com.google.common.collect.t1;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractMapBasedMultimap.java */
/* loaded from: classes2.dex */
public abstract class e<K, V> extends h<K, V> implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;
    private transient Map<K, Collection<V>> map;
    private transient int totalSize;

    /* compiled from: AbstractMapBasedMultimap.java */
    /* loaded from: classes2.dex */
    class a extends e<K, V>.d<V> {
        a() {
            super();
        }

        @Override // com.google.common.collect.e.d
        V a(K k, V v) {
            return v;
        }
    }

    /* compiled from: AbstractMapBasedMultimap.java */
    /* loaded from: classes2.dex */
    class b extends e<K, V>.d<Map.Entry<K, V>> {
        b() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: b */
        public Map.Entry<K, V> a(K k, V v) {
            return q1.i(k, v);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractMapBasedMultimap.java */
    /* loaded from: classes2.dex */
    public class c extends q1.r<K, Collection<V>> {
        final transient Map<K, Collection<V>> q;

        /* compiled from: AbstractMapBasedMultimap.java */
        /* loaded from: classes2.dex */
        class a extends q1.j<K, Collection<V>> {
            a() {
            }

            @Override // com.google.common.collect.q1.j
            Map<K, Collection<V>> c() {
                return c.this;
            }

            @Override // com.google.common.collect.q1.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return w.d(c.this.q.entrySet(), obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return new b();
            }

            @Override // com.google.common.collect.q1.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                e.this.removeValuesForKey(((Map.Entry) obj).getKey());
                return true;
            }
        }

        /* compiled from: AbstractMapBasedMultimap.java */
        /* loaded from: classes2.dex */
        class b implements Iterator<Map.Entry<K, Collection<V>>> {

            /* renamed from: c  reason: collision with root package name */
            final Iterator<Map.Entry<K, Collection<V>>> f4396c;
            @NullableDecl

            /* renamed from: d  reason: collision with root package name */
            Collection<V> f4397d;

            b() {
                this.f4396c = c.this.q.entrySet().iterator();
            }

            /* renamed from: a */
            public Map.Entry<K, Collection<V>> next() {
                Map.Entry<K, Collection<V>> next = this.f4396c.next();
                this.f4397d = next.getValue();
                return c.this.f(next);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f4396c.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                v.e(this.f4397d != null);
                this.f4396c.remove();
                e.this.totalSize -= this.f4397d.size();
                this.f4397d.clear();
                this.f4397d = null;
            }
        }

        c(Map<K, Collection<V>> map) {
            this.q = map;
        }

        @Override // com.google.common.collect.q1.r
        protected Set<Map.Entry<K, Collection<V>>> a() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            if (this.q == e.this.map) {
                e.this.clear();
            } else {
                k1.d(new b());
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return q1.u(this.q, obj);
        }

        /* renamed from: d */
        public Collection<V> get(Object obj) {
            Collection<V> collection = (Collection) q1.v(this.q, obj);
            if (collection == null) {
                return null;
            }
            return e.this.wrapCollection(obj, collection);
        }

        /* renamed from: e */
        public Collection<V> remove(Object obj) {
            Collection<V> remove = this.q.remove(obj);
            if (remove == null) {
                return null;
            }
            Collection<V> createCollection = e.this.createCollection();
            createCollection.addAll(remove);
            e.this.totalSize -= remove.size();
            remove.clear();
            return createCollection;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(@NullableDecl Object obj) {
            return this == obj || this.q.equals(obj);
        }

        Map.Entry<K, Collection<V>> f(Map.Entry<K, Collection<V>> entry) {
            K key = entry.getKey();
            return q1.i(key, e.this.wrapCollection(key, entry.getValue()));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.q.hashCode();
        }

        @Override // com.google.common.collect.q1.r, java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Set<K> keySet() {
            return e.this.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.q.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.q.toString();
        }
    }

    /* compiled from: AbstractMapBasedMultimap.java */
    /* loaded from: classes2.dex */
    private abstract class d<T> implements Iterator<T> {

        /* renamed from: c  reason: collision with root package name */
        final Iterator<Map.Entry<K, Collection<V>>> f4399c;
        @NullableDecl

        /* renamed from: d  reason: collision with root package name */
        K f4400d = null;
        @MonotonicNonNullDecl

        /* renamed from: f  reason: collision with root package name */
        Collection<V> f4401f = null;
        Iterator<V> q = k1.j();

        d() {
            this.f4399c = (Iterator<Map.Entry<K, V>>) e.this.map.entrySet().iterator();
        }

        abstract T a(K k, V v);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4399c.hasNext() || this.q.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.q.hasNext()) {
                Map.Entry<K, Collection<V>> next = this.f4399c.next();
                this.f4400d = next.getKey();
                Collection<V> value = next.getValue();
                this.f4401f = value;
                this.q = value.iterator();
            }
            return a(this.f4400d, this.q.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.q.remove();
            if (this.f4401f.isEmpty()) {
                this.f4399c.remove();
            }
            e.access$210(e.this);
        }
    }

    /* compiled from: AbstractMapBasedMultimap.java */
    /* renamed from: com.google.common.collect.e$e  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0156e extends q1.m<K, Collection<V>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AbstractMapBasedMultimap.java */
        /* renamed from: com.google.common.collect.e$e$a */
        /* loaded from: classes2.dex */
        public class a implements Iterator<K> {
            @NullableDecl

            /* renamed from: c  reason: collision with root package name */
            Map.Entry<K, Collection<V>> f4403c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ Iterator f4404d;

            a(Iterator it) {
                this.f4404d = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f4404d.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                Map.Entry<K, Collection<V>> entry = (Map.Entry) this.f4404d.next();
                this.f4403c = entry;
                return entry.getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                v.e(this.f4403c != null);
                Collection<V> value = this.f4403c.getValue();
                this.f4404d.remove();
                e.this.totalSize -= value.size();
                value.clear();
                this.f4403c = null;
            }
        }

        C0156e(Map<K, Collection<V>> map) {
            super(map);
        }

        @Override // com.google.common.collect.q1.m, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            k1.d(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return c().keySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(@NullableDecl Object obj) {
            return this == obj || c().keySet().equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return c().keySet().hashCode();
        }

        @Override // com.google.common.collect.q1.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a(c().entrySet().iterator());
        }

        @Override // com.google.common.collect.q1.m, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int i;
            Collection<V> remove = c().remove(obj);
            if (remove != null) {
                i = remove.size();
                remove.clear();
                e.this.totalSize -= i;
            } else {
                i = 0;
            }
            return i > 0;
        }
    }

    /* compiled from: AbstractMapBasedMultimap.java */
    /* loaded from: classes2.dex */
    class f extends e<K, V>.i implements NavigableMap<K, Collection<V>> {
        f(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> ceilingEntry(K k) {
            Map.Entry<K, Collection<V>> ceilingEntry = i().ceilingEntry(k);
            if (ceilingEntry == null) {
                return null;
            }
            return f(ceilingEntry);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k) {
            return i().ceilingKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> descendingMap() {
            return new f(i().descendingMap());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> firstEntry() {
            Map.Entry<K, Collection<V>> firstEntry = i().firstEntry();
            if (firstEntry == null) {
                return null;
            }
            return f(firstEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> floorEntry(K k) {
            Map.Entry<K, Collection<V>> floorEntry = i().floorEntry(k);
            if (floorEntry == null) {
                return null;
            }
            return f(floorEntry);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k) {
            return i().floorKey(k);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> higherEntry(K k) {
            Map.Entry<K, Collection<V>> higherEntry = i().higherEntry(k);
            if (higherEntry == null) {
                return null;
            }
            return f(higherEntry);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k) {
            return i().higherKey(k);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: j */
        public NavigableSet<K> g() {
            return new g(i());
        }

        /* renamed from: k */
        public NavigableMap<K, Collection<V>> headMap(K k) {
            return headMap(k, false);
        }

        /* renamed from: l */
        public NavigableSet<K> keySet() {
            return (NavigableSet) super.keySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lastEntry() {
            Map.Entry<K, Collection<V>> lastEntry = i().lastEntry();
            if (lastEntry == null) {
                return null;
            }
            return f(lastEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lowerEntry(K k) {
            Map.Entry<K, Collection<V>> lowerEntry = i().lowerEntry(k);
            if (lowerEntry == null) {
                return null;
            }
            return f(lowerEntry);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k) {
            return i().lowerKey(k);
        }

        Map.Entry<K, Collection<V>> m(Iterator<Map.Entry<K, Collection<V>>> it) {
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry<K, Collection<V>> next = it.next();
            Collection<V> createCollection = e.this.createCollection();
            createCollection.addAll(next.getValue());
            it.remove();
            return q1.i(next.getKey(), e.this.unmodifiableCollectionSubclass(createCollection));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: n */
        public NavigableMap<K, Collection<V>> i() {
            return (NavigableMap) super.i();
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return keySet();
        }

        /* renamed from: o */
        public NavigableMap<K, Collection<V>> subMap(K k, K k2) {
            return subMap(k, true, k2, false);
        }

        /* renamed from: p */
        public NavigableMap<K, Collection<V>> tailMap(K k) {
            return tailMap(k, true);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollFirstEntry() {
            return m(entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollLastEntry() {
            return m(descendingMap().entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> headMap(K k, boolean z) {
            return new f(i().headMap(k, z));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> subMap(K k, boolean z, K k2, boolean z2) {
            return new f(i().subMap(k, z, k2, z2));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> tailMap(K k, boolean z) {
            return new f(i().tailMap(k, z));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractMapBasedMultimap.java */
    /* loaded from: classes2.dex */
    public class g extends e<K, V>.j implements NavigableSet<K> {
        g(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableSet
        public K ceiling(K k) {
            return e().ceilingKey(k);
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return new g(e().descendingMap());
        }

        @Override // java.util.NavigableSet
        public K floor(K k) {
            return e().floorKey(k);
        }

        /* renamed from: g */
        public NavigableSet<K> headSet(K k) {
            return headSet(k, false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: h */
        public NavigableMap<K, Collection<V>> e() {
            return (NavigableMap) super.e();
        }

        @Override // java.util.NavigableSet
        public K higher(K k) {
            return e().higherKey(k);
        }

        /* renamed from: i */
        public NavigableSet<K> subSet(K k, K k2) {
            return subSet(k, true, k2, false);
        }

        /* renamed from: j */
        public NavigableSet<K> tailSet(K k) {
            return tailSet(k, true);
        }

        @Override // java.util.NavigableSet
        public K lower(K k) {
            return e().lowerKey(k);
        }

        @Override // java.util.NavigableSet
        public K pollFirst() {
            return (K) k1.r(iterator());
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            return (K) k1.r(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K k, boolean z) {
            return new g(e().headMap(k, z));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K k, boolean z, K k2, boolean z2) {
            return new g(e().subMap(k, z, k2, z2));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K k, boolean z) {
            return new g(e().tailMap(k, z));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractMapBasedMultimap.java */
    /* loaded from: classes2.dex */
    public class h extends e<K, V>.l implements RandomAccess {
        h(@NullableDecl K k, List<V> list, @NullableDecl e<K, V>.k kVar) {
            super(k, list, kVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractMapBasedMultimap.java */
    /* loaded from: classes2.dex */
    public class i extends e<K, V>.c implements SortedMap<K, Collection<V>> {
        @MonotonicNonNullDecl
        SortedSet<K> y;

        i(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return i().comparator();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return i().firstKey();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: g */
        public SortedSet<K> b() {
            return new j(i());
        }

        /* renamed from: h */
        public SortedSet<K> keySet() {
            SortedSet<K> sortedSet = this.y;
            if (sortedSet != null) {
                return sortedSet;
            }
            SortedSet<K> g = b();
            this.y = g;
            return g;
        }

        public SortedMap<K, Collection<V>> headMap(K k) {
            return new i(i().headMap(k));
        }

        SortedMap<K, Collection<V>> i() {
            return (SortedMap) this.q;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return i().lastKey();
        }

        public SortedMap<K, Collection<V>> subMap(K k, K k2) {
            return new i(i().subMap(k, k2));
        }

        public SortedMap<K, Collection<V>> tailMap(K k) {
            return new i(i().tailMap(k));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractMapBasedMultimap.java */
    /* loaded from: classes2.dex */
    public class j extends e<K, V>.C0156e implements SortedSet<K> {
        j(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return e().comparator();
        }

        SortedMap<K, Collection<V>> e() {
            return (SortedMap) super.c();
        }

        @Override // java.util.SortedSet
        public K first() {
            return e().firstKey();
        }

        public SortedSet<K> headSet(K k) {
            return new j(e().headMap(k));
        }

        @Override // java.util.SortedSet
        public K last() {
            return e().lastKey();
        }

        public SortedSet<K> subSet(K k, K k2) {
            return new j(e().subMap(k, k2));
        }

        public SortedSet<K> tailSet(K k) {
            return new j(e().tailMap(k));
        }
    }

    /* compiled from: AbstractMapBasedMultimap.java */
    /* loaded from: classes2.dex */
    class m extends e<K, V>.o implements NavigableSet<V> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public m(@NullableDecl K k, NavigableSet<V> navigableSet, @NullableDecl e<K, V>.k kVar) {
            super(k, navigableSet, kVar);
        }

        private NavigableSet<V> i(NavigableSet<V> navigableSet) {
            return new m(this.f4407c, navigableSet, b() == null ? this : b());
        }

        @Override // java.util.NavigableSet
        public V ceiling(V v) {
            return g().ceiling(v);
        }

        @Override // java.util.NavigableSet
        public Iterator<V> descendingIterator() {
            return new k.a(g().descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> descendingSet() {
            return i(g().descendingSet());
        }

        @Override // java.util.NavigableSet
        public V floor(V v) {
            return g().floor(v);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: h */
        public NavigableSet<V> g() {
            return (NavigableSet) super.g();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> headSet(V v, boolean z) {
            return i(g().headSet(v, z));
        }

        @Override // java.util.NavigableSet
        public V higher(V v) {
            return g().higher(v);
        }

        @Override // java.util.NavigableSet
        public V lower(V v) {
            return g().lower(v);
        }

        @Override // java.util.NavigableSet
        public V pollFirst() {
            return (V) k1.r(iterator());
        }

        @Override // java.util.NavigableSet
        public V pollLast() {
            return (V) k1.r(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> subSet(V v, boolean z, V v2, boolean z2) {
            return i(g().subSet(v, z, v2, z2));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> tailSet(V v, boolean z) {
            return i(g().tailSet(v, z));
        }
    }

    /* compiled from: AbstractMapBasedMultimap.java */
    /* loaded from: classes2.dex */
    class n extends e<K, V>.k implements Set<V> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public n(@NullableDecl K k, Set<V> set) {
            super(k, set, null);
        }

        @Override // com.google.common.collect.e.k, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean g = u2.g((Set) this.f4408d, collection);
            if (g) {
                int size2 = this.f4408d.size();
                e.this.totalSize += size2 - size;
                f();
            }
            return g;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractMapBasedMultimap.java */
    /* loaded from: classes2.dex */
    public class o extends e<K, V>.k implements SortedSet<V> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public o(@NullableDecl K k, SortedSet<V> sortedSet, @NullableDecl e<K, V>.k kVar) {
            super(k, sortedSet, kVar);
        }

        @Override // java.util.SortedSet
        public Comparator<? super V> comparator() {
            return g().comparator();
        }

        @Override // java.util.SortedSet
        public V first() {
            e();
            return g().first();
        }

        SortedSet<V> g() {
            return (SortedSet) c();
        }

        @Override // java.util.SortedSet
        public SortedSet<V> headSet(V v) {
            e();
            return new o(d(), g().headSet(v), b() == null ? this : b());
        }

        @Override // java.util.SortedSet
        public V last() {
            e();
            return g().last();
        }

        @Override // java.util.SortedSet
        public SortedSet<V> subSet(V v, V v2) {
            e();
            return new o(d(), g().subSet(v, v2), b() == null ? this : b());
        }

        @Override // java.util.SortedSet
        public SortedSet<V> tailSet(V v) {
            e();
            return new o(d(), g().tailSet(v), b() == null ? this : b());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(Map<K, Collection<V>> map) {
        com.google.common.base.n.d(map.isEmpty());
        this.map = map;
    }

    static /* synthetic */ int access$208(e eVar) {
        int i2 = eVar.totalSize;
        eVar.totalSize = i2 + 1;
        return i2;
    }

    static /* synthetic */ int access$210(e eVar) {
        int i2 = eVar.totalSize;
        eVar.totalSize = i2 - 1;
        return i2;
    }

    private Collection<V> getOrCreateCollection(@NullableDecl K k2) {
        Collection<V> collection = this.map.get(k2);
        if (collection != null) {
            return collection;
        }
        Collection<V> createCollection = createCollection(k2);
        this.map.put(k2, createCollection);
        return createCollection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> Iterator<E> iteratorOrListIterator(Collection<E> collection) {
        if (collection instanceof List) {
            return ((List) collection).listIterator();
        }
        return collection.iterator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeValuesForKey(Object obj) {
        Collection collection = (Collection) q1.w(this.map, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.totalSize -= size;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<K, Collection<V>> backingMap() {
        return this.map;
    }

    @Override // com.google.common.collect.r1
    public void clear() {
        for (Collection<V> collection : this.map.values()) {
            collection.clear();
        }
        this.map.clear();
        this.totalSize = 0;
    }

    @Override // com.google.common.collect.r1
    public boolean containsKey(@NullableDecl Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // com.google.common.collect.h
    Map<K, Collection<V>> createAsMap() {
        return new c(this.map);
    }

    abstract Collection<V> createCollection();

    /* JADX INFO: Access modifiers changed from: package-private */
    public Collection<V> createCollection(@NullableDecl K k2) {
        return createCollection();
    }

    @Override // com.google.common.collect.h
    Collection<Map.Entry<K, V>> createEntries() {
        if (this instanceof s2) {
            return new h.b();
        }
        return new h.a();
    }

    @Override // com.google.common.collect.h
    Set<K> createKeySet() {
        return new C0156e(this.map);
    }

    @Override // com.google.common.collect.h
    u1<K> createKeys() {
        return new t1.d(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<K, Collection<V>> createMaybeNavigableAsMap() {
        Map<K, Collection<V>> map = this.map;
        if (map instanceof NavigableMap) {
            return new f((NavigableMap) this.map);
        }
        if (map instanceof SortedMap) {
            return new i((SortedMap) this.map);
        }
        return new c(this.map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<K> createMaybeNavigableKeySet() {
        Map<K, Collection<V>> map = this.map;
        if (map instanceof NavigableMap) {
            return new g((NavigableMap) this.map);
        }
        if (map instanceof SortedMap) {
            return new j((SortedMap) this.map);
        }
        return new C0156e(this.map);
    }

    abstract Collection<V> createUnmodifiableEmptyCollection();

    @Override // com.google.common.collect.h
    Collection<V> createValues() {
        return new h.c();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.r1
    public Collection<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    @Override // com.google.common.collect.h
    Iterator<Map.Entry<K, V>> entryIterator() {
        return new b();
    }

    @Override // com.google.common.collect.r1
    public Collection<V> get(@NullableDecl K k2) {
        Collection<V> collection = this.map.get(k2);
        if (collection == null) {
            collection = createCollection(k2);
        }
        return wrapCollection(k2, collection);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.r1
    public boolean put(@NullableDecl K k2, @NullableDecl V v) {
        Collection<V> collection = this.map.get(k2);
        if (collection == null) {
            Collection<V> createCollection = createCollection(k2);
            if (createCollection.add(v)) {
                this.totalSize++;
                this.map.put(k2, createCollection);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        } else if (!collection.add(v)) {
            return false;
        } else {
            this.totalSize++;
            return true;
        }
    }

    @Override // com.google.common.collect.r1
    public Collection<V> removeAll(@NullableDecl Object obj) {
        Collection<V> remove = this.map.remove(obj);
        if (remove == null) {
            return createUnmodifiableEmptyCollection();
        }
        Collection createCollection = createCollection();
        createCollection.addAll(remove);
        this.totalSize -= remove.size();
        remove.clear();
        return (Collection<V>) unmodifiableCollectionSubclass(createCollection);
    }

    @Override // com.google.common.collect.h
    public Collection<V> replaceValues(@NullableDecl K k2, Iterable<? extends V> iterable) {
        Iterator<? extends V> it = iterable.iterator();
        if (!it.hasNext()) {
            return removeAll(k2);
        }
        Collection<V> orCreateCollection = getOrCreateCollection(k2);
        Collection createCollection = createCollection();
        createCollection.addAll(orCreateCollection);
        this.totalSize -= orCreateCollection.size();
        orCreateCollection.clear();
        while (it.hasNext()) {
            if (orCreateCollection.add((V) it.next())) {
                this.totalSize++;
            }
        }
        return (Collection<V>) unmodifiableCollectionSubclass(createCollection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setMap(Map<K, Collection<V>> map) {
        this.map = map;
        this.totalSize = 0;
        for (Collection<V> collection : map.values()) {
            com.google.common.base.n.d(!collection.isEmpty());
            this.totalSize += collection.size();
        }
    }

    @Override // com.google.common.collect.r1
    public int size() {
        return this.totalSize;
    }

    abstract <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection);

    @Override // com.google.common.collect.h
    Iterator<V> valueIterator() {
        return new a();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.r1
    public Collection<V> values() {
        return super.values();
    }

    abstract Collection<V> wrapCollection(@NullableDecl K k2, Collection<V> collection);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<V> wrapList(@NullableDecl K k2, List<V> list, @NullableDecl e<K, V>.k kVar) {
        return list instanceof RandomAccess ? new h(k2, list, kVar) : new l(k2, list, kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractMapBasedMultimap.java */
    /* loaded from: classes2.dex */
    public class k extends AbstractCollection<V> {
        @NullableDecl

        /* renamed from: c  reason: collision with root package name */
        final K f4407c;

        /* renamed from: d  reason: collision with root package name */
        Collection<V> f4408d;
        @NullableDecl

        /* renamed from: f  reason: collision with root package name */
        final e<K, V>.k f4409f;
        @NullableDecl
        final Collection<V> q;

        k(@NullableDecl K k, Collection<V> collection, @NullableDecl e<K, V>.k kVar) {
            this.f4407c = k;
            this.f4408d = collection;
            this.f4409f = kVar;
            this.q = kVar == null ? null : kVar.c();
        }

        void a() {
            e<K, V>.k kVar = this.f4409f;
            if (kVar != null) {
                kVar.a();
            } else {
                e.this.map.put(this.f4407c, this.f4408d);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(V v) {
            e();
            boolean isEmpty = this.f4408d.isEmpty();
            boolean add = this.f4408d.add(v);
            if (add) {
                e.access$208(e.this);
                if (isEmpty) {
                    a();
                }
            }
            return add;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = this.f4408d.addAll(collection);
            if (addAll) {
                int size2 = this.f4408d.size();
                e.this.totalSize += size2 - size;
                if (size == 0) {
                    a();
                }
            }
            return addAll;
        }

        e<K, V>.k b() {
            return this.f4409f;
        }

        Collection<V> c() {
            return this.f4408d;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int size = size();
            if (size != 0) {
                this.f4408d.clear();
                e.this.totalSize -= size;
                f();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            e();
            return this.f4408d.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            e();
            return this.f4408d.containsAll(collection);
        }

        K d() {
            return this.f4407c;
        }

        void e() {
            Collection<V> collection;
            e<K, V>.k kVar = this.f4409f;
            if (kVar != null) {
                kVar.e();
                if (this.f4409f.c() != this.q) {
                    throw new ConcurrentModificationException();
                }
            } else if (this.f4408d.isEmpty() && (collection = (Collection) e.this.map.get(this.f4407c)) != null) {
                this.f4408d = collection;
            }
        }

        @Override // java.util.Collection
        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            e();
            return this.f4408d.equals(obj);
        }

        void f() {
            e<K, V>.k kVar = this.f4409f;
            if (kVar != null) {
                kVar.f();
            } else if (this.f4408d.isEmpty()) {
                e.this.map.remove(this.f4407c);
            }
        }

        @Override // java.util.Collection
        public int hashCode() {
            e();
            return this.f4408d.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            e();
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            e();
            boolean remove = this.f4408d.remove(obj);
            if (remove) {
                e.access$210(e.this);
                f();
            }
            return remove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean removeAll = this.f4408d.removeAll(collection);
            if (removeAll) {
                int size2 = this.f4408d.size();
                e.this.totalSize += size2 - size;
                f();
            }
            return removeAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            com.google.common.base.n.o(collection);
            int size = size();
            boolean retainAll = this.f4408d.retainAll(collection);
            if (retainAll) {
                int size2 = this.f4408d.size();
                e.this.totalSize += size2 - size;
                f();
            }
            return retainAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            e();
            return this.f4408d.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            e();
            return this.f4408d.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AbstractMapBasedMultimap.java */
        /* loaded from: classes2.dex */
        public class a implements Iterator<V> {

            /* renamed from: c  reason: collision with root package name */
            final Iterator<V> f4410c;

            /* renamed from: d  reason: collision with root package name */
            final Collection<V> f4411d;

            a() {
                Collection<V> collection = k.this.f4408d;
                this.f4411d = collection;
                this.f4410c = e.iteratorOrListIterator(collection);
            }

            Iterator<V> a() {
                b();
                return this.f4410c;
            }

            void b() {
                k.this.e();
                if (k.this.f4408d != this.f4411d) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                b();
                return this.f4410c.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                b();
                return this.f4410c.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f4410c.remove();
                e.access$210(e.this);
                k.this.f();
            }

            a(Iterator<V> it) {
                this.f4411d = k.this.f4408d;
                this.f4410c = it;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractMapBasedMultimap.java */
    /* loaded from: classes2.dex */
    public class l extends e<K, V>.k implements List<V> {

        /* compiled from: AbstractMapBasedMultimap.java */
        /* loaded from: classes2.dex */
        private class a extends e<K, V>.k.a implements ListIterator<V> {
            a() {
                super();
            }

            private ListIterator<V> c() {
                return (ListIterator) a();
            }

            @Override // java.util.ListIterator
            public void add(V v) {
                boolean isEmpty = l.this.isEmpty();
                c().add(v);
                e.access$208(e.this);
                if (isEmpty) {
                    l.this.a();
                }
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return c().hasPrevious();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return c().nextIndex();
            }

            @Override // java.util.ListIterator
            public V previous() {
                return c().previous();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return c().previousIndex();
            }

            @Override // java.util.ListIterator
            public void set(V v) {
                c().set(v);
            }

            public a(int i) {
                super(l.this.g().listIterator(i));
            }
        }

        l(@NullableDecl K k, List<V> list, @NullableDecl e<K, V>.k kVar) {
            super(k, list, kVar);
        }

        @Override // java.util.List
        public void add(int i, V v) {
            e();
            boolean isEmpty = c().isEmpty();
            g().add(i, v);
            e.access$208(e.this);
            if (isEmpty) {
                a();
            }
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = g().addAll(i, collection);
            if (addAll) {
                int size2 = c().size();
                e.this.totalSize += size2 - size;
                if (size == 0) {
                    a();
                }
            }
            return addAll;
        }

        List<V> g() {
            return (List) c();
        }

        @Override // java.util.List
        public V get(int i) {
            e();
            return g().get(i);
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            e();
            return g().indexOf(obj);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            e();
            return g().lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator() {
            e();
            return new a();
        }

        @Override // java.util.List
        public V remove(int i) {
            e();
            V remove = g().remove(i);
            e.access$210(e.this);
            f();
            return remove;
        }

        @Override // java.util.List
        public V set(int i, V v) {
            e();
            return g().set(i, v);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public List<V> subList(int i, int i2) {
            e();
            return e.this.wrapList(d(), g().subList(i, i2), b() == null ? this : b());
        }

        @Override // java.util.List
        public ListIterator<V> listIterator(int i) {
            e();
            return new a(i);
        }
    }
}
