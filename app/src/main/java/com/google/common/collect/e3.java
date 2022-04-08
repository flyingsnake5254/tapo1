package com.google.common.collect;

import com.google.common.base.n;
import com.google.common.base.o;
import com.google.common.base.p;
import com.google.common.base.t;
import com.google.common.collect.f3;
import com.google.common.collect.q1;
import com.google.common.collect.u2;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StandardTable.java */
/* loaded from: classes2.dex */
public class e3<R, C, V> extends q<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final Map<R, Map<C, V>> backingMap;
    @MonotonicNonNullDecl
    private transient Set<C> columnKeySet;
    @MonotonicNonNullDecl
    private transient e3<R, C, V>.f columnMap;
    final t<? extends Map<C, V>> factory;
    @MonotonicNonNullDecl
    private transient Map<R, Map<C, V>> rowMap;

    /* compiled from: StandardTable.java */
    /* loaded from: classes2.dex */
    private class b implements Iterator<f3.a<R, C, V>> {

        /* renamed from: c  reason: collision with root package name */
        final Iterator<Map.Entry<R, Map<C, V>>> f4424c;
        @NullableDecl

        /* renamed from: d  reason: collision with root package name */
        Map.Entry<R, Map<C, V>> f4425d;

        /* renamed from: f  reason: collision with root package name */
        Iterator<Map.Entry<C, V>> f4426f;

        private b() {
            this.f4424c = e3.this.backingMap.entrySet().iterator();
            this.f4426f = k1.j();
        }

        /* renamed from: a */
        public f3.a<R, C, V> next() {
            if (!this.f4426f.hasNext()) {
                Map.Entry<R, Map<C, V>> next = this.f4424c.next();
                this.f4425d = next;
                this.f4426f = next.getValue().entrySet().iterator();
            }
            Map.Entry<C, V> next2 = this.f4426f.next();
            return g3.b(this.f4425d.getKey(), next2.getKey(), next2.getValue());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4424c.hasNext() || this.f4426f.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f4426f.remove();
            if (this.f4425d.getValue().isEmpty()) {
                this.f4424c.remove();
                this.f4425d = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StandardTable.java */
    /* loaded from: classes2.dex */
    public class c extends q1.r<R, V> {
        final C q;

        /* compiled from: StandardTable.java */
        /* loaded from: classes2.dex */
        private class a extends u2.b<Map.Entry<R, V>> {
            private a() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                c.this.d(p.a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return e3.this.containsMapping(entry.getKey(), c.this.q, entry.getValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                c cVar = c.this;
                return !e3.this.containsColumn(cVar.q);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, V>> iterator() {
                return new b();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return e3.this.removeMapping(entry.getKey(), c.this.q, entry.getValue());
            }

            @Override // com.google.common.collect.u2.b, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return c.this.d(p.f(p.d(collection)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                int i = 0;
                for (Map<C, V> map : e3.this.backingMap.values()) {
                    if (map.containsKey(c.this.q)) {
                        i++;
                    }
                }
                return i;
            }
        }

        /* compiled from: StandardTable.java */
        /* loaded from: classes2.dex */
        private class b extends c<Map.Entry<R, V>> {

            /* renamed from: f  reason: collision with root package name */
            final Iterator<Map.Entry<R, Map<C, V>>> f4428f;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: StandardTable.java */
            /* loaded from: classes2.dex */
            public class a extends g<R, V> {

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ Map.Entry f4429c;

                a(Map.Entry entry) {
                    this.f4429c = entry;
                }

                @Override // com.google.common.collect.g, java.util.Map.Entry
                public R getKey() {
                    return (R) this.f4429c.getKey();
                }

                @Override // com.google.common.collect.g, java.util.Map.Entry
                public V getValue() {
                    return (V) ((Map) this.f4429c.getValue()).get(c.this.q);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.collect.g, java.util.Map.Entry
                public V setValue(V v) {
                    return (V) ((Map) this.f4429c.getValue()).put(c.this.q, n.o(v));
                }
            }

            private b() {
                this.f4428f = e3.this.backingMap.entrySet().iterator();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: d */
            public Map.Entry<R, V> a() {
                while (this.f4428f.hasNext()) {
                    Map.Entry<R, Map<C, V>> next = this.f4428f.next();
                    if (next.getValue().containsKey(c.this.q)) {
                        return new a(next);
                    }
                }
                return b();
            }
        }

        /* compiled from: StandardTable.java */
        /* renamed from: com.google.common.collect.e3$c$c  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private class C0157c extends q1.m<R, V> {
            C0157c() {
                super(c.this);
            }

            @Override // com.google.common.collect.q1.m, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                c cVar = c.this;
                return e3.this.contains(obj, cVar.q);
            }

            @Override // com.google.common.collect.q1.m, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                c cVar = c.this;
                return e3.this.remove(obj, cVar.q) != null;
            }

            @Override // com.google.common.collect.u2.b, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return c.this.d(q1.n(p.f(p.d(collection))));
            }
        }

        /* compiled from: StandardTable.java */
        /* loaded from: classes2.dex */
        private class d extends q1.q<R, V> {
            d() {
                super(c.this);
            }

            @Override // com.google.common.collect.q1.q, java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                return obj != null && c.this.d(q1.F(p.c(obj)));
            }

            @Override // com.google.common.collect.q1.q, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                return c.this.d(q1.F(p.d(collection)));
            }

            @Override // com.google.common.collect.q1.q, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                return c.this.d(q1.F(p.f(p.d(collection))));
            }
        }

        c(C c2) {
            this.q = (C) n.o(c2);
        }

        @Override // com.google.common.collect.q1.r
        Set<Map.Entry<R, V>> a() {
            return new a();
        }

        @Override // com.google.common.collect.q1.r
        Set<R> b() {
            return new C0157c();
        }

        @Override // com.google.common.collect.q1.r
        Collection<V> c() {
            return new d();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return e3.this.contains(obj, this.q);
        }

        @CanIgnoreReturnValue
        boolean d(o<? super Map.Entry<R, V>> oVar) {
            Iterator<Map.Entry<R, Map<C, V>>> it = e3.this.backingMap.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map.Entry<R, Map<C, V>> next = it.next();
                Map<C, V> value = next.getValue();
                V v = value.get(this.q);
                if (v != null && oVar.apply(q1.i(next.getKey(), v))) {
                    value.remove(this.q);
                    z = true;
                    if (value.isEmpty()) {
                        it.remove();
                    }
                }
            }
            return z;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            return (V) e3.this.get(obj, this.q);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(R r, V v) {
            return (V) e3.this.put(r, this.q, v);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            return (V) e3.this.remove(obj, this.q);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StandardTable.java */
    /* loaded from: classes2.dex */
    public class d extends c<C> {

        /* renamed from: f  reason: collision with root package name */
        final Map<C, V> f4433f;
        final Iterator<Map<C, V>> q;
        Iterator<Map.Entry<C, V>> x;

        private d() {
            this.f4433f = (Map) e3.this.factory.get();
            this.q = e3.this.backingMap.values().iterator();
            this.x = k1.h();
        }

        @Override // com.google.common.collect.c
        protected C a() {
            while (true) {
                if (this.x.hasNext()) {
                    Map.Entry<C, V> next = this.x.next();
                    if (!this.f4433f.containsKey(next.getKey())) {
                        this.f4433f.put(next.getKey(), next.getValue());
                        return next.getKey();
                    }
                } else if (!this.q.hasNext()) {
                    return b();
                } else {
                    this.x = this.q.next().entrySet().iterator();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StandardTable.java */
    /* loaded from: classes2.dex */
    public class e extends e3<R, C, V>.i<C> {
        private e() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return e3.this.containsColumn(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<C> iterator() {
            return e3.this.createColumnKeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            boolean z = false;
            if (obj == null) {
                return false;
            }
            Iterator<Map<C, V>> it = e3.this.backingMap.values().iterator();
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (next.keySet().remove(obj)) {
                    z = true;
                    if (next.isEmpty()) {
                        it.remove();
                    }
                }
            }
            return z;
        }

        @Override // com.google.common.collect.u2.b, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            n.o(collection);
            Iterator<Map<C, V>> it = e3.this.backingMap.values().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (k1.s(next.keySet().iterator(), collection)) {
                    z = true;
                    if (next.isEmpty()) {
                        it.remove();
                    }
                }
            }
            return z;
        }

        @Override // com.google.common.collect.u2.b, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            n.o(collection);
            Iterator<Map<C, V>> it = e3.this.backingMap.values().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (next.keySet().retainAll(collection)) {
                    z = true;
                    if (next.isEmpty()) {
                        it.remove();
                    }
                }
            }
            return z;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return k1.v(iterator());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StandardTable.java */
    /* loaded from: classes2.dex */
    public class f extends q1.r<C, Map<R, V>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: StandardTable.java */
        /* loaded from: classes2.dex */
        public class a extends e3<R, C, V>.i<Map.Entry<C, Map<R, V>>> {

            /* compiled from: StandardTable.java */
            /* renamed from: com.google.common.collect.e3$f$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            class C0158a implements com.google.common.base.h<C, Map<R, V>> {
                C0158a() {
                }

                /* renamed from: a */
                public Map<R, V> apply(C c2) {
                    return e3.this.column(c2);
                }
            }

            a() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                if (!e3.this.containsColumn(entry.getKey())) {
                    return false;
                }
                return f.this.get(entry.getKey()).equals(entry.getValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<C, Map<R, V>>> iterator() {
                return q1.c(e3.this.columnKeySet(), new C0158a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                e3.this.removeColumn(((Map.Entry) obj).getKey());
                return true;
            }

            @Override // com.google.common.collect.u2.b, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                n.o(collection);
                return u2.h(this, collection.iterator());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.u2.b, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                n.o(collection);
                Iterator it = n1.j(e3.this.columnKeySet().iterator()).iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Object next = it.next();
                    if (!collection.contains(q1.i(next, e3.this.column(next)))) {
                        e3.this.removeColumn(next);
                        z = true;
                    }
                }
                return z;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return e3.this.columnKeySet().size();
            }
        }

        /* compiled from: StandardTable.java */
        /* loaded from: classes2.dex */
        private class b extends q1.q<C, Map<R, V>> {
            b() {
                super(f.this);
            }

            @Override // com.google.common.collect.q1.q, java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                for (Map.Entry<C, Map<R, V>> entry : f.this.entrySet()) {
                    if (entry.getValue().equals(obj)) {
                        e3.this.removeColumn(entry.getKey());
                        return true;
                    }
                }
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.q1.q, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                n.o(collection);
                Iterator it = n1.j(e3.this.columnKeySet().iterator()).iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Object next = it.next();
                    if (collection.contains(e3.this.column(next))) {
                        e3.this.removeColumn(next);
                        z = true;
                    }
                }
                return z;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.q1.q, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                n.o(collection);
                Iterator it = n1.j(e3.this.columnKeySet().iterator()).iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Object next = it.next();
                    if (!collection.contains(e3.this.column(next))) {
                        e3.this.removeColumn(next);
                        z = true;
                    }
                }
                return z;
            }
        }

        private f() {
        }

        @Override // com.google.common.collect.q1.r
        public Set<Map.Entry<C, Map<R, V>>> a() {
            return new a();
        }

        @Override // com.google.common.collect.q1.r
        Collection<Map<R, V>> c() {
            return new b();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return e3.this.containsColumn(obj);
        }

        /* renamed from: d */
        public Map<R, V> get(Object obj) {
            if (e3.this.containsColumn(obj)) {
                return e3.this.column(obj);
            }
            return null;
        }

        /* renamed from: e */
        public Map<R, V> remove(Object obj) {
            if (e3.this.containsColumn(obj)) {
                return e3.this.removeColumn(obj);
            }
            return null;
        }

        @Override // com.google.common.collect.q1.r, java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Set<C> keySet() {
            return e3.this.columnKeySet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StandardTable.java */
    /* loaded from: classes2.dex */
    public class g extends q1.l<C, V> {

        /* renamed from: c  reason: collision with root package name */
        final R f4438c;
        @NullableDecl

        /* renamed from: d  reason: collision with root package name */
        Map<C, V> f4439d;

        /* compiled from: StandardTable.java */
        /* loaded from: classes2.dex */
        class a implements Iterator<Map.Entry<C, V>> {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Iterator f4441c;

            a(Iterator it) {
                this.f4441c = it;
            }

            /* renamed from: a */
            public Map.Entry<C, V> next() {
                return g.this.e((Map.Entry) this.f4441c.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f4441c.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f4441c.remove();
                g.this.d();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: StandardTable.java */
        /* loaded from: classes2.dex */
        public class b extends q0<C, V> {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Map.Entry f4443c;

            b(Map.Entry entry) {
                this.f4443c = entry;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.q0
            /* renamed from: a */
            public Map.Entry<C, V> delegate() {
                return this.f4443c;
            }

            @Override // com.google.common.collect.q0, java.util.Map.Entry
            public boolean equals(Object obj) {
                return standardEquals(obj);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.q0, java.util.Map.Entry
            public V setValue(V v) {
                return (V) super.setValue(n.o(v));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public g(R r) {
            this.f4438c = (R) n.o(r);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.q1.l
        public Iterator<Map.Entry<C, V>> a() {
            Map<C, V> b2 = b();
            if (b2 == null) {
                return k1.j();
            }
            return new a(b2.entrySet().iterator());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Map<C, V> b() {
            Map<C, V> map = this.f4439d;
            if (map != null && (!map.isEmpty() || !e3.this.backingMap.containsKey(this.f4438c))) {
                return this.f4439d;
            }
            Map<C, V> c2 = c();
            this.f4439d = c2;
            return c2;
        }

        Map<C, V> c() {
            return e3.this.backingMap.get(this.f4438c);
        }

        @Override // com.google.common.collect.q1.l, java.util.AbstractMap, java.util.Map
        public void clear() {
            Map<C, V> b2 = b();
            if (b2 != null) {
                b2.clear();
            }
            d();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            Map<C, V> b2 = b();
            return (obj == null || b2 == null || !q1.u(b2, obj)) ? false : true;
        }

        void d() {
            if (b() != null && this.f4439d.isEmpty()) {
                e3.this.backingMap.remove(this.f4438c);
                this.f4439d = null;
            }
        }

        Map.Entry<C, V> e(Map.Entry<C, V> entry) {
            return new b(entry);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            Map<C, V> b2 = b();
            if (obj == null || b2 == null) {
                return null;
            }
            return (V) q1.v(b2, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(C c2, V v) {
            n.o(c2);
            n.o(v);
            Map<C, V> map = this.f4439d;
            if (map == null || map.isEmpty()) {
                return (V) e3.this.put(this.f4438c, c2, v);
            }
            return this.f4439d.put(c2, v);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            Map<C, V> b2 = b();
            if (b2 == null) {
                return null;
            }
            V v = (V) q1.w(b2, obj);
            d();
            return v;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            Map<C, V> b2 = b();
            if (b2 == null) {
                return 0;
            }
            return b2.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StandardTable.java */
    /* loaded from: classes2.dex */
    public class h extends q1.r<R, Map<C, V>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: StandardTable.java */
        /* loaded from: classes2.dex */
        public class a extends e3<R, C, V>.i<Map.Entry<R, Map<C, V>>> {

            /* compiled from: StandardTable.java */
            /* renamed from: com.google.common.collect.e3$h$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            class C0159a implements com.google.common.base.h<R, Map<C, V>> {
                C0159a() {
                }

                /* renamed from: a */
                public Map<C, V> apply(R r) {
                    return e3.this.row(r);
                }
            }

            a() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return entry.getKey() != null && (entry.getValue() instanceof Map) && w.d(e3.this.backingMap.entrySet(), entry);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, Map<C, V>>> iterator() {
                return q1.c(e3.this.backingMap.keySet(), new C0159a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return entry.getKey() != null && (entry.getValue() instanceof Map) && e3.this.backingMap.entrySet().remove(entry);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return e3.this.backingMap.size();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public h() {
        }

        @Override // com.google.common.collect.q1.r
        protected Set<Map.Entry<R, Map<C, V>>> a() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return e3.this.containsRow(obj);
        }

        /* renamed from: d */
        public Map<C, V> get(Object obj) {
            if (e3.this.containsRow(obj)) {
                return e3.this.row(obj);
            }
            return null;
        }

        /* renamed from: e */
        public Map<C, V> remove(Object obj) {
            if (obj == null) {
                return null;
            }
            return e3.this.backingMap.remove(obj);
        }
    }

    /* compiled from: StandardTable.java */
    /* loaded from: classes2.dex */
    private abstract class i<T> extends u2.b<T> {
        private i() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            e3.this.backingMap.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return e3.this.backingMap.isEmpty();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e3(Map<R, Map<C, V>> map, t<? extends Map<C, V>> tVar) {
        this.backingMap = map;
        this.factory = tVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean containsMapping(Object obj, Object obj2, Object obj3) {
        return obj3 != null && obj3.equals(get(obj, obj2));
    }

    private Map<C, V> getOrCreate(R r) {
        Map<C, V> map = this.backingMap.get(r);
        if (map != null) {
            return map;
        }
        Map<C, V> map2 = (Map) this.factory.get();
        this.backingMap.put(r, map2);
        return map2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CanIgnoreReturnValue
    public Map<R, V> removeColumn(Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<R, Map<C, V>>> it = this.backingMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<R, Map<C, V>> next = it.next();
            V remove = next.getValue().remove(obj);
            if (remove != null) {
                linkedHashMap.put(next.getKey(), remove);
                if (next.getValue().isEmpty()) {
                    it.remove();
                }
            }
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean removeMapping(Object obj, Object obj2, Object obj3) {
        if (!containsMapping(obj, obj2, obj3)) {
            return false;
        }
        remove(obj, obj2);
        return true;
    }

    @Override // com.google.common.collect.q
    Iterator<f3.a<R, C, V>> cellIterator() {
        return new b();
    }

    @Override // com.google.common.collect.q, com.google.common.collect.f3
    public Set<f3.a<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.q
    public void clear() {
        this.backingMap.clear();
    }

    public Map<R, V> column(C c2) {
        return new c(c2);
    }

    @Override // com.google.common.collect.q, com.google.common.collect.f3
    public Set<C> columnKeySet() {
        Set<C> set = this.columnKeySet;
        if (set != null) {
            return set;
        }
        e eVar = new e();
        this.columnKeySet = eVar;
        return eVar;
    }

    @Override // com.google.common.collect.f3
    public Map<C, Map<R, V>> columnMap() {
        e3<R, C, V>.f fVar = this.columnMap;
        if (fVar != null) {
            return fVar;
        }
        e3<R, C, V>.f fVar2 = new f();
        this.columnMap = fVar2;
        return fVar2;
    }

    @Override // com.google.common.collect.q
    public boolean contains(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return (obj == null || obj2 == null || !super.contains(obj, obj2)) ? false : true;
    }

    @Override // com.google.common.collect.q
    public boolean containsColumn(@NullableDecl Object obj) {
        if (obj == null) {
            return false;
        }
        for (Map<C, V> map : this.backingMap.values()) {
            if (q1.u(map, obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.collect.q
    public boolean containsRow(@NullableDecl Object obj) {
        return obj != null && q1.u(this.backingMap, obj);
    }

    @Override // com.google.common.collect.q
    public boolean containsValue(@NullableDecl Object obj) {
        return obj != null && super.containsValue(obj);
    }

    Iterator<C> createColumnKeyIterator() {
        return new d();
    }

    Map<R, Map<C, V>> createRowMap() {
        return new h();
    }

    @Override // com.google.common.collect.q
    public V get(@NullableDecl Object obj, @NullableDecl Object obj2) {
        if (obj == null || obj2 == null) {
            return null;
        }
        return (V) super.get(obj, obj2);
    }

    @Override // com.google.common.collect.q
    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    @Override // com.google.common.collect.q
    @CanIgnoreReturnValue
    public V put(R r, C c2, V v) {
        n.o(r);
        n.o(c2);
        n.o(v);
        return getOrCreate(r).put(c2, v);
    }

    @Override // com.google.common.collect.q
    @CanIgnoreReturnValue
    public V remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        Map map;
        if (obj == null || obj2 == null || (map = (Map) q1.v(this.backingMap, obj)) == null) {
            return null;
        }
        V v = (V) map.remove(obj2);
        if (map.isEmpty()) {
            this.backingMap.remove(obj);
        }
        return v;
    }

    public Map<C, V> row(R r) {
        return new g(r);
    }

    @Override // com.google.common.collect.q, com.google.common.collect.f3
    public Set<R> rowKeySet() {
        return rowMap().keySet();
    }

    @Override // com.google.common.collect.f3
    public Map<R, Map<C, V>> rowMap() {
        Map<R, Map<C, V>> map = this.rowMap;
        if (map != null) {
            return map;
        }
        Map<R, Map<C, V>> createRowMap = createRowMap();
        this.rowMap = createRowMap;
        return createRowMap;
    }

    @Override // com.google.common.collect.f3
    public int size() {
        int i2 = 0;
        for (Map<C, V> map : this.backingMap.values()) {
            i2 += map.size();
        }
        return i2;
    }

    @Override // com.google.common.collect.q
    public Collection<V> values() {
        return super.values();
    }
}
