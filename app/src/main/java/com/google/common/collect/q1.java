package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.u2;
import com.google.j2objc.annotations.Weak;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Maps.java */
/* loaded from: classes2.dex */
public final class q1 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Maps.java */
    /* loaded from: classes2.dex */
    public static class a extends g<K, V2> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Map.Entry f4588c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ k f4589d;

        a(Map.Entry entry, k kVar) {
            this.f4588c = entry;
            this.f4589d = kVar;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, K] */
        @Override // com.google.common.collect.g, java.util.Map.Entry
        public K getKey() {
            return this.f4588c.getKey();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, V2] */
        @Override // com.google.common.collect.g, java.util.Map.Entry
        public V2 getValue() {
            return this.f4589d.a(this.f4588c.getKey(), this.f4588c.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Maps.java */
    /* loaded from: classes2.dex */
    public static class b implements com.google.common.base.h<Map.Entry<K, V1>, Map.Entry<K, V2>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ k f4590c;

        b(k kVar) {
            this.f4590c = kVar;
        }

        /* renamed from: a */
        public Map.Entry<K, V2> apply(Map.Entry<K, V1> entry) {
            return q1.z(this.f4590c, entry);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Maps.java */
    /* loaded from: classes2.dex */
    public static class c extends h3<Map.Entry<K, V>, K> {
        c(Iterator it) {
            super(it);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, K] */
        /* renamed from: b */
        public K a(Map.Entry<K, V> entry) {
            return entry.getKey();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Maps.java */
    /* loaded from: classes2.dex */
    public static class d extends h3<Map.Entry<K, V>, V> {
        d(Iterator it) {
            super(it);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Type inference failed for: r1v1, types: [V, java.lang.Object] */
        /* renamed from: b */
        public V a(Map.Entry<K, V> entry) {
            return entry.getValue();
        }
    }

    /* compiled from: Maps.java */
    /* loaded from: classes2.dex */
    static class e extends h3<K, Map.Entry<K, V>> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.google.common.base.h f4591d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(Iterator it, com.google.common.base.h hVar) {
            super(it);
            this.f4591d = hVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: b */
        public Map.Entry<K, V> a(K k) {
            return q1.i(k, this.f4591d.apply(k));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Maps.java */
    /* loaded from: classes2.dex */
    public static class f extends g<K, V> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Map.Entry f4592c;

        f(Map.Entry entry) {
            this.f4592c = entry;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, K] */
        @Override // com.google.common.collect.g, java.util.Map.Entry
        public K getKey() {
            return this.f4592c.getKey();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [V, java.lang.Object] */
        @Override // com.google.common.collect.g, java.util.Map.Entry
        public V getValue() {
            return this.f4592c.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Maps.java */
    /* loaded from: classes2.dex */
    public static class g implements k<K, V1, V2> {
        final /* synthetic */ com.google.common.base.h a;

        g(com.google.common.base.h hVar) {
            this.a = hVar;
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, V2] */
        @Override // com.google.common.collect.q1.k
        public V2 a(K k, V1 v1) {
            return this.a.apply(v1);
        }
    }

    /* compiled from: Maps.java */
    /* loaded from: classes2.dex */
    static abstract class h<K, V> extends p0<K, V> implements NavigableMap<K, V> {
        @MonotonicNonNullDecl

        /* renamed from: c  reason: collision with root package name */
        private transient Comparator<? super K> f4593c;
        @MonotonicNonNullDecl

        /* renamed from: d  reason: collision with root package name */
        private transient Set<Map.Entry<K, V>> f4594d;
        @MonotonicNonNullDecl

        /* renamed from: f  reason: collision with root package name */
        private transient NavigableSet<K> f4595f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Maps.java */
        /* loaded from: classes2.dex */
        public class a extends j<K, V> {
            a() {
            }

            @Override // com.google.common.collect.q1.j
            Map<K, V> c() {
                return h.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return h.this.b();
            }
        }

        private static <T> a2<T> f(Comparator<T> comparator) {
            return a2.a(comparator).j();
        }

        Set<Map.Entry<K, V>> a() {
            return new a();
        }

        abstract Iterator<Map.Entry<K, V>> b();

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K k) {
            return d().floorEntry(k);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k) {
            return d().floorKey(k);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator = this.f4593c;
            if (comparator != null) {
                return comparator;
            }
            Comparator<? super K> comparator2 = d().comparator();
            if (comparator2 == null) {
                comparator2 = a2.g();
            }
            a2 f2 = f(comparator2);
            this.f4593c = f2;
            return f2;
        }

        abstract NavigableMap<K, V> d();

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return d().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return d();
        }

        @Override // com.google.common.collect.p0, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.f4594d;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> a2 = a();
            this.f4594d = a2;
            return a2;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            return d().lastEntry();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return d().lastKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K k) {
            return d().ceilingEntry(k);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k) {
            return d().ceilingKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k, boolean z) {
            return d().tailMap(k, z).descendingMap();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K k) {
            return d().lowerEntry(k);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k) {
            return d().lowerKey(k);
        }

        @Override // com.google.common.collect.p0, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            return d().firstEntry();
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return d().firstKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K k) {
            return d().higherEntry(k);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k) {
            return d().higherKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            NavigableSet<K> navigableSet = this.f4595f;
            if (navigableSet != null) {
                return navigableSet;
            }
            n nVar = new n(this);
            this.f4595f = nVar;
            return nVar;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            return d().pollLastEntry();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            return d().pollFirstEntry();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
            return d().subMap(k2, z2, k, z).descendingMap();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k, boolean z) {
            return d().headMap(k, z).descendingMap();
        }

        @Override // com.google.common.collect.s0
        public String toString() {
            return standardToString();
        }

        @Override // com.google.common.collect.p0, java.util.Map
        public Collection<V> values() {
            return new q(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.p0, com.google.common.collect.s0
        public final Map<K, V> delegate() {
            return d();
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> headMap(K k) {
            return headMap(k, false);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> subMap(K k, K k2) {
            return subMap(k, true, k2, false);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> tailMap(K k) {
            return tailMap(k, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* compiled from: Maps.java */
    /* loaded from: classes2.dex */
    public static abstract class i extends Enum<i> implements com.google.common.base.h<Map.Entry<?, ?>, Object> {

        /* renamed from: c  reason: collision with root package name */
        public static final i f4597c;

        /* renamed from: d  reason: collision with root package name */
        public static final i f4598d;

        /* renamed from: f  reason: collision with root package name */
        private static final /* synthetic */ i[] f4599f;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: Maps.java */
        /* loaded from: classes2.dex */
        static class a extends i {
            a(String str, int i) {
                super(str, i, null);
            }

            @NullableDecl
            /* renamed from: a */
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: Maps.java */
        /* loaded from: classes2.dex */
        static class b extends i {
            b(String str, int i) {
                super(str, i, null);
            }

            @NullableDecl
            /* renamed from: a */
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        }

        static {
            a aVar = new a("KEY", 0);
            f4597c = aVar;
            b bVar = new b("VALUE", 1);
            f4598d = bVar;
            f4599f = new i[]{aVar, bVar};
        }

        private i(String str, int i) {
        }

        public static i valueOf(String str) {
            return (i) Enum.valueOf(i.class, str);
        }

        public static i[] values() {
            return (i[]) f4599f.clone();
        }

        /* synthetic */ i(String str, int i, c cVar) {
            this(str, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Maps.java */
    /* loaded from: classes2.dex */
    public static abstract class j<K, V> extends u2.b<Map.Entry<K, V>> {
        abstract Map<K, V> c();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            c().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object v = q1.v(c(), key);
            if (com.google.common.base.k.a(v, entry.getValue())) {
                return v != null || c().containsKey(key);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return c().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (contains(obj)) {
                return c().keySet().remove(((Map.Entry) obj).getKey());
            }
            return false;
        }

        @Override // com.google.common.collect.u2.b, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) com.google.common.base.n.o(collection));
            } catch (UnsupportedOperationException unused) {
                return u2.h(this, collection.iterator());
            }
        }

        @Override // com.google.common.collect.u2.b, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) com.google.common.base.n.o(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet e2 = u2.e(collection.size());
                for (Object obj : collection) {
                    if (contains(obj)) {
                        e2.add(((Map.Entry) obj).getKey());
                    }
                }
                return c().keySet().retainAll(e2);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return c().size();
        }
    }

    /* compiled from: Maps.java */
    /* loaded from: classes2.dex */
    public interface k<K, V1, V2> {
        V2 a(@NullableDecl K k, @NullableDecl V1 v1);
    }

    /* compiled from: Maps.java */
    /* loaded from: classes2.dex */
    static abstract class l<K, V> extends AbstractMap<K, V> {

        /* compiled from: Maps.java */
        /* loaded from: classes2.dex */
        class a extends j<K, V> {
            a() {
            }

            @Override // com.google.common.collect.q1.j
            Map<K, V> c() {
                return l.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return l.this.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Iterator<Map.Entry<K, V>> a();

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            k1.d(a());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Maps.java */
    /* loaded from: classes2.dex */
    public static class m<K, V> extends u2.b<K> {
        @Weak

        /* renamed from: c  reason: collision with root package name */
        final Map<K, V> f4601c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public m(Map<K, V> map) {
            this.f4601c = (Map) com.google.common.base.n.o(map);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Map<K, V> c() {
            return this.f4601c;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            c().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return c().containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return c().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return q1.l(c().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            c().remove(obj);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return c().size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Maps.java */
    /* loaded from: classes2.dex */
    public static class n<K, V> extends o<K, V> implements NavigableSet<K> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public n(NavigableMap<K, V> navigableMap) {
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
            return e().descendingKeySet();
        }

        @Override // java.util.NavigableSet
        public K floor(K k) {
            return e().floorKey(k);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: g */
        public NavigableMap<K, V> e() {
            return (NavigableMap) this.f4601c;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K k, boolean z) {
            return e().headMap(k, z).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public K higher(K k) {
            return e().higherKey(k);
        }

        @Override // java.util.NavigableSet
        public K lower(K k) {
            return e().lowerKey(k);
        }

        @Override // java.util.NavigableSet
        public K pollFirst() {
            return (K) q1.m(e().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            return (K) q1.m(e().pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K k, boolean z, K k2, boolean z2) {
            return e().subMap(k, z, k2, z2).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K k, boolean z) {
            return e().tailMap(k, z).navigableKeySet();
        }

        @Override // com.google.common.collect.q1.o, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> headSet(K k) {
            return headSet(k, false);
        }

        @Override // com.google.common.collect.q1.o, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> subSet(K k, K k2) {
            return subSet(k, true, k2, false);
        }

        @Override // com.google.common.collect.q1.o, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> tailSet(K k) {
            return tailSet(k, true);
        }
    }

    /* compiled from: Maps.java */
    /* loaded from: classes2.dex */
    static class o<K, V> extends m<K, V> implements SortedSet<K> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public o(SortedMap<K, V> sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return c().comparator();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: e */
        public SortedMap<K, V> c() {
            return (SortedMap) super.c();
        }

        @Override // java.util.SortedSet
        public K first() {
            return c().firstKey();
        }

        public SortedSet<K> headSet(K k) {
            return new o(c().headMap(k));
        }

        @Override // java.util.SortedSet
        public K last() {
            return c().lastKey();
        }

        public SortedSet<K> subSet(K k, K k2) {
            return new o(c().subMap(k, k2));
        }

        public SortedSet<K> tailSet(K k) {
            return new o(c().tailMap(k));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Maps.java */
    /* loaded from: classes2.dex */
    public static class p<K, V1, V2> extends l<K, V2> {

        /* renamed from: c  reason: collision with root package name */
        final Map<K, V1> f4602c;

        /* renamed from: d  reason: collision with root package name */
        final k<? super K, ? super V1, V2> f4603d;

        p(Map<K, V1> map, k<? super K, ? super V1, V2> kVar) {
            this.f4602c = (Map) com.google.common.base.n.o(map);
            this.f4603d = (k) com.google.common.base.n.o(kVar);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.q1.l
        public Iterator<Map.Entry<K, V2>> a() {
            return k1.x(this.f4602c.entrySet().iterator(), q1.a(this.f4603d));
        }

        @Override // com.google.common.collect.q1.l, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f4602c.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f4602c.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V2 get(Object obj) {
            V1 v1 = this.f4602c.get(obj);
            if (v1 != null || this.f4602c.containsKey(obj)) {
                return this.f4603d.a(obj, v1);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.f4602c.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V2 remove(Object obj) {
            if (this.f4602c.containsKey(obj)) {
                return this.f4603d.a(obj, (V1) this.f4602c.remove(obj));
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f4602c.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V2> values() {
            return new q(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Maps.java */
    /* loaded from: classes2.dex */
    public static class q<K, V> extends AbstractCollection<V> {
        @Weak

        /* renamed from: c  reason: collision with root package name */
        final Map<K, V> f4604c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public q(Map<K, V> map) {
            this.f4604c = (Map) com.google.common.base.n.o(map);
        }

        final Map<K, V> a() {
            return this.f4604c;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object obj) {
            return a().containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return q1.D(a().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException unused) {
                for (Map.Entry<K, V> entry : a().entrySet()) {
                    if (com.google.common.base.k.a(obj, entry.getValue())) {
                        a().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) com.google.common.base.n.o(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet d2 = u2.d();
                for (Map.Entry<K, V> entry : a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        d2.add(entry.getKey());
                    }
                }
                return a().keySet().removeAll(d2);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) com.google.common.base.n.o(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet d2 = u2.d();
                for (Map.Entry<K, V> entry : a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        d2.add(entry.getKey());
                    }
                }
                return a().keySet().retainAll(d2);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a().size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Maps.java */
    /* loaded from: classes2.dex */
    public static abstract class r<K, V> extends AbstractMap<K, V> {
        @MonotonicNonNullDecl

        /* renamed from: c  reason: collision with root package name */
        private transient Set<Map.Entry<K, V>> f4605c;
        @MonotonicNonNullDecl

        /* renamed from: d  reason: collision with root package name */
        private transient Set<K> f4606d;
        @MonotonicNonNullDecl

        /* renamed from: f  reason: collision with root package name */
        private transient Collection<V> f4607f;

        abstract Set<Map.Entry<K, V>> a();

        Set<K> b() {
            return new m(this);
        }

        Collection<V> c() {
            return new q(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.f4605c;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> a = a();
            this.f4605c = a;
            return a;
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Set<K> keySet() {
            Set<K> set = this.f4606d;
            if (set != null) {
                return set;
            }
            Set<K> b2 = b();
            this.f4606d = b2;
            return b2;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> values() {
            Collection<V> collection = this.f4607f;
            if (collection != null) {
                return collection;
            }
            Collection<V> c2 = c();
            this.f4607f = c2;
            return c2;
        }
    }

    public static <K, V1, V2> Map<K, V2> A(Map<K, V1> map, com.google.common.base.h<? super V1, V2> hVar) {
        return y(map, b(hVar));
    }

    static <K, V> Map.Entry<K, V> B(Map.Entry<? extends K, ? extends V> entry) {
        com.google.common.base.n.o(entry);
        return new f(entry);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> com.google.common.base.h<Map.Entry<?, V>, V> C() {
        return i.f4598d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Iterator<V> D(Iterator<Map.Entry<K, V>> it) {
        return new d(it);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NullableDecl
    public static <V> V E(@NullableDecl Map.Entry<?, V> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> com.google.common.base.o<Map.Entry<?, V>> F(com.google.common.base.o<? super V> oVar) {
        return com.google.common.base.p.b(oVar, C());
    }

    static <K, V1, V2> com.google.common.base.h<Map.Entry<K, V1>, Map.Entry<K, V2>> a(k<? super K, ? super V1, V2> kVar) {
        com.google.common.base.n.o(kVar);
        return new b(kVar);
    }

    static <K, V1, V2> k<K, V1, V2> b(com.google.common.base.h<? super V1, V2> hVar) {
        com.google.common.base.n.o(hVar);
        return new g(hVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Iterator<Map.Entry<K, V>> c(Set<K> set, com.google.common.base.h<? super K, V> hVar) {
        return new e(set.iterator(), hVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int i2) {
        if (i2 < 3) {
            v.b(i2, "expectedSize");
            return i2 + 1;
        } else if (i2 < 1073741824) {
            return (int) ((i2 / 0.75f) + 1.0f);
        } else {
            return Integer.MAX_VALUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> boolean e(Collection<Map.Entry<K, V>> collection, Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        return collection.contains(B((Map.Entry) obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(Map<?, ?> map, @NullableDecl Object obj) {
        return k1.f(l(map.entrySet().iterator()), obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean g(Map<?, ?> map, @NullableDecl Object obj) {
        return k1.f(D(map.entrySet().iterator()), obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean h(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static <K, V> Map.Entry<K, V> i(@NullableDecl K k2, @NullableDecl V v) {
        return new a1(k2, v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> ImmutableMap<E, Integer> j(Collection<E> collection) {
        ImmutableMap.b bVar = new ImmutableMap.b(collection.size());
        int i2 = 0;
        for (E e2 : collection) {
            i2++;
            bVar.c(e2, Integer.valueOf(i2));
        }
        return bVar.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K> com.google.common.base.h<Map.Entry<K, ?>, K> k() {
        return i.f4597c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Iterator<K> l(Iterator<Map.Entry<K, V>> it) {
        return new c(it);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NullableDecl
    public static <K> K m(@NullableDecl Map.Entry<K, ?> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K> com.google.common.base.o<Map.Entry<K, ?>> n(com.google.common.base.o<? super K> oVar) {
        return com.google.common.base.p.b(oVar, k());
    }

    public static <K, V> HashMap<K, V> o() {
        return new HashMap<>();
    }

    public static <K, V> HashMap<K, V> p(int i2) {
        return new HashMap<>(d(i2));
    }

    public static <K, V> IdentityHashMap<K, V> q() {
        return new IdentityHashMap<>();
    }

    public static <K, V> LinkedHashMap<K, V> r() {
        return new LinkedHashMap<>();
    }

    public static <K, V> LinkedHashMap<K, V> s(int i2) {
        return new LinkedHashMap<>(d(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> void t(Map<K, V> map, Map<? extends K, ? extends V> map2) {
        for (Map.Entry<? extends K, ? extends V> entry : map2.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean u(Map<?, ?> map, Object obj) {
        com.google.common.base.n.o(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> V v(Map<?, V> map, @NullableDecl Object obj) {
        com.google.common.base.n.o(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> V w(Map<?, V> map, Object obj) {
        com.google.common.base.n.o(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String x(Map<?, ?> map) {
        StringBuilder c2 = w.c(map.size());
        c2.append('{');
        boolean z = true;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (!z) {
                c2.append(", ");
            }
            z = false;
            c2.append(entry.getKey());
            c2.append('=');
            c2.append(entry.getValue());
        }
        c2.append('}');
        return c2.toString();
    }

    public static <K, V1, V2> Map<K, V2> y(Map<K, V1> map, k<? super K, ? super V1, V2> kVar) {
        return new p(map, kVar);
    }

    static <V2, K, V1> Map.Entry<K, V2> z(k<? super K, ? super V1, V2> kVar, Map.Entry<K, V1> entry) {
        com.google.common.base.n.o(kVar);
        com.google.common.base.n.o(entry);
        return new a(entry, kVar);
    }
}
