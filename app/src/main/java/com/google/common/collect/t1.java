package com.google.common.collect;

import com.google.common.base.h;
import com.google.common.base.n;
import com.google.common.base.t;
import com.google.common.collect.q1;
import com.google.common.collect.u1;
import com.google.common.collect.v1;
import com.google.j2objc.annotations.Weak;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Multimaps.java */
/* loaded from: classes2.dex */
public final class t1 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Multimaps.java */
    /* loaded from: classes2.dex */
    public static final class a<K, V> extends q1.r<K, Collection<V>> {
        @Weak
        private final r1<K, V> q;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Multimaps.java */
        /* renamed from: com.google.common.collect.t1$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0162a extends q1.j<K, Collection<V>> {

            /* compiled from: Multimaps.java */
            /* renamed from: com.google.common.collect.t1$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            class C0163a implements h<K, Collection<V>> {
                C0163a() {
                }

                /* renamed from: a */
                public Collection<V> apply(K k) {
                    return a.this.q.get(k);
                }
            }

            C0162a() {
            }

            @Override // com.google.common.collect.q1.j
            Map<K, Collection<V>> c() {
                return a.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return q1.c(a.this.q.keySet(), new C0163a());
            }

            @Override // com.google.common.collect.q1.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                a.this.g(((Map.Entry) obj).getKey());
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(r1<K, V> r1Var) {
            this.q = (r1) n.o(r1Var);
        }

        @Override // com.google.common.collect.q1.r
        protected Set<Map.Entry<K, Collection<V>>> a() {
            return new C0162a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.q.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.q.containsKey(obj);
        }

        /* renamed from: e */
        public Collection<V> get(Object obj) {
            if (containsKey(obj)) {
                return this.q.get(obj);
            }
            return null;
        }

        /* renamed from: f */
        public Collection<V> remove(Object obj) {
            if (containsKey(obj)) {
                return this.q.removeAll(obj);
            }
            return null;
        }

        void g(Object obj) {
            this.q.keySet().remove(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.q.isEmpty();
        }

        @Override // com.google.common.collect.q1.r, java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Set<K> keySet() {
            return this.q.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.q.keySet().size();
        }
    }

    /* compiled from: Multimaps.java */
    /* loaded from: classes2.dex */
    private static class b<K, V> extends d<K, V> {

        /* renamed from: c  reason: collision with root package name */
        transient t<? extends List<V>> f4613c;

        b(Map<K, Collection<V>> map, t<? extends List<V>> tVar) {
            super(map);
            this.f4613c = (t) n.o(tVar);
        }

        @Override // com.google.common.collect.e, com.google.common.collect.h
        Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.e, com.google.common.collect.h
        Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.d, com.google.common.collect.e
        public List<V> createCollection() {
            return (List) this.f4613c.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Multimaps.java */
    /* loaded from: classes2.dex */
    public static abstract class c<K, V> extends AbstractCollection<Map.Entry<K, V>> {
        abstract r1<K, V> a();

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return a().containsEntry(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return a().remove(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a().size();
        }
    }

    /* compiled from: Multimaps.java */
    /* loaded from: classes2.dex */
    static class d<K, V> extends i<K> {
        @Weak

        /* renamed from: c  reason: collision with root package name */
        final r1<K, V> f4614c;

        /* compiled from: Multimaps.java */
        /* loaded from: classes2.dex */
        class a extends h3<Map.Entry<K, Collection<V>>, u1.a<K>> {

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: Multimaps.java */
            /* renamed from: com.google.common.collect.t1$d$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class C0164a extends v1.b<K> {

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ Map.Entry f4616c;

                C0164a(Map.Entry entry) {
                    this.f4616c = entry;
                }

                @Override // com.google.common.collect.u1.a
                public K a() {
                    return (K) this.f4616c.getKey();
                }

                @Override // com.google.common.collect.u1.a
                public int getCount() {
                    return ((Collection) this.f4616c.getValue()).size();
                }
            }

            a(Iterator it) {
                super(it);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: b */
            public u1.a<K> a(Map.Entry<K, Collection<V>> entry) {
                return new C0164a(entry);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public d(r1<K, V> r1Var) {
            this.f4614c = r1Var;
        }

        @Override // com.google.common.collect.i, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.f4614c.clear();
        }

        @Override // com.google.common.collect.i, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.u1
        public boolean contains(@NullableDecl Object obj) {
            return this.f4614c.containsKey(obj);
        }

        @Override // com.google.common.collect.u1
        public int count(@NullableDecl Object obj) {
            Collection collection = (Collection) q1.v(this.f4614c.asMap(), obj);
            if (collection == null) {
                return 0;
            }
            return collection.size();
        }

        @Override // com.google.common.collect.i
        int distinctElements() {
            return this.f4614c.asMap().size();
        }

        @Override // com.google.common.collect.i
        Iterator<K> elementIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.i, com.google.common.collect.u1
        public Set<K> elementSet() {
            return this.f4614c.keySet();
        }

        @Override // com.google.common.collect.i
        Iterator<u1.a<K>> entryIterator() {
            return new a(this.f4614c.asMap().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return q1.l(this.f4614c.entries().iterator());
        }

        @Override // com.google.common.collect.i, com.google.common.collect.u1
        public int remove(@NullableDecl Object obj, int i) {
            v.b(i, "occurrences");
            if (i == 0) {
                return count(obj);
            }
            Collection collection = (Collection) q1.v(this.f4614c.asMap(), obj);
            if (collection == null) {
                return 0;
            }
            int size = collection.size();
            if (i >= size) {
                collection.clear();
            } else {
                Iterator it = collection.iterator();
                for (int i2 = 0; i2 < i; i2++) {
                    it.next();
                    it.remove();
                }
            }
            return size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.u1
        public int size() {
            return this.f4614c.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(r1<?, ?> r1Var, @NullableDecl Object obj) {
        if (obj == r1Var) {
            return true;
        }
        if (obj instanceof r1) {
            return r1Var.asMap().equals(((r1) obj).asMap());
        }
        return false;
    }

    public static <K, V> m1<K, V> b(Map<K, Collection<V>> map, t<? extends List<V>> tVar) {
        return new b(map, tVar);
    }
}
