package com.google.common.collect;

import com.google.common.base.k;
import com.google.common.base.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractBiMap.java */
/* loaded from: classes2.dex */
public abstract class a<K, V> extends p0<K, V> implements t<K, V>, Serializable {
    private static final long serialVersionUID = 0;
    @MonotonicNonNullDecl
    private transient Map<K, V> delegate;
    @MonotonicNonNullDecl
    private transient Set<Map.Entry<K, V>> entrySet;
    @RetainedWith
    @MonotonicNonNullDecl
    transient a<V, K> inverse;
    @MonotonicNonNullDecl
    private transient Set<K> keySet;
    @MonotonicNonNullDecl
    private transient Set<V> valueSet;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractBiMap.java */
    /* renamed from: com.google.common.collect.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0155a implements Iterator<Map.Entry<K, V>> {
        @NullableDecl

        /* renamed from: c  reason: collision with root package name */
        Map.Entry<K, V> f4356c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Iterator f4357d;

        C0155a(Iterator it) {
            this.f4357d = it;
        }

        /* renamed from: a */
        public Map.Entry<K, V> next() {
            Map.Entry<K, V> entry = (Map.Entry) this.f4357d.next();
            this.f4356c = entry;
            return new b(entry);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4357d.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            v.e(this.f4356c != null);
            V value = this.f4356c.getValue();
            this.f4357d.remove();
            a.this.removeFromInverseMap(value);
            this.f4356c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractBiMap.java */
    /* loaded from: classes2.dex */
    public class b extends q0<K, V> {

        /* renamed from: c  reason: collision with root package name */
        private final Map.Entry<K, V> f4359c;

        b(Map.Entry<K, V> entry) {
            this.f4359c = entry;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.q0
        /* renamed from: a */
        public Map.Entry<K, V> delegate() {
            return this.f4359c;
        }

        @Override // com.google.common.collect.q0, java.util.Map.Entry
        public V setValue(V v) {
            a.this.checkValue(v);
            n.v(a.this.entrySet().contains(this), "entry no longer in map");
            if (k.a(v, getValue())) {
                return v;
            }
            n.j(!a.this.containsValue(v), "value already present: %s", v);
            V value = this.f4359c.setValue(v);
            n.v(k.a(v, a.this.get(getKey())), "entry no longer in map");
            a.this.updateInverseMap(getKey(), true, value, v);
            return value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractBiMap.java */
    /* loaded from: classes2.dex */
    public class c extends u0<Map.Entry<K, V>> {

        /* renamed from: c  reason: collision with root package name */
        final Set<Map.Entry<K, V>> f4361c;

        private c() {
            this.f4361c = a.this.delegate.entrySet();
        }

        @Override // com.google.common.collect.n0, java.util.Collection, java.util.Set
        public void clear() {
            a.this.clear();
        }

        @Override // com.google.common.collect.n0, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return q1.e(delegate(), obj);
        }

        @Override // com.google.common.collect.n0, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return standardContainsAll(collection);
        }

        @Override // com.google.common.collect.n0, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return a.this.entrySetIterator();
        }

        @Override // com.google.common.collect.n0, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!this.f4361c.contains(obj)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            ((a) a.this.inverse).delegate.remove(entry.getValue());
            this.f4361c.remove(entry);
            return true;
        }

        @Override // com.google.common.collect.n0, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        @Override // com.google.common.collect.n0, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return standardRetainAll(collection);
        }

        @Override // com.google.common.collect.n0, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.n0, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }

        /* synthetic */ c(a aVar, C0155a aVar2) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.u0, com.google.common.collect.n0, com.google.common.collect.s0
        public Set<Map.Entry<K, V>> delegate() {
            return this.f4361c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractBiMap.java */
    /* loaded from: classes2.dex */
    public static class d<K, V> extends a<K, V> {
        d(Map<K, V> map, a<V, K> aVar) {
            super(map, aVar, null);
        }

        @Override // com.google.common.collect.a
        K checkKey(K k) {
            return this.inverse.checkValue(k);
        }

        @Override // com.google.common.collect.a
        V checkValue(V v) {
            return this.inverse.checkKey(v);
        }

        @Override // com.google.common.collect.a, com.google.common.collect.p0, com.google.common.collect.s0
        protected /* bridge */ /* synthetic */ Object delegate() {
            return a.super.delegate();
        }

        @Override // com.google.common.collect.a, com.google.common.collect.p0, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return a.super.values();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractBiMap.java */
    /* loaded from: classes2.dex */
    public class e extends u0<K> {
        private e() {
        }

        @Override // com.google.common.collect.n0, java.util.Collection, java.util.Set
        public void clear() {
            a.this.clear();
        }

        @Override // com.google.common.collect.n0, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return q1.l(a.this.entrySet().iterator());
        }

        @Override // com.google.common.collect.n0, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            a.this.removeFromBothMaps(obj);
            return true;
        }

        @Override // com.google.common.collect.n0, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        @Override // com.google.common.collect.n0, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return standardRetainAll(collection);
        }

        /* synthetic */ e(a aVar, C0155a aVar2) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.u0, com.google.common.collect.n0, com.google.common.collect.s0
        public Set<K> delegate() {
            return a.this.delegate.keySet();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractBiMap.java */
    /* loaded from: classes2.dex */
    public class f extends u0<V> {

        /* renamed from: c  reason: collision with root package name */
        final Set<V> f4364c;

        private f() {
            this.f4364c = a.this.inverse.keySet();
        }

        @Override // com.google.common.collect.n0, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return q1.D(a.this.entrySet().iterator());
        }

        @Override // com.google.common.collect.n0, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.s0
        public String toString() {
            return standardToString();
        }

        @Override // com.google.common.collect.n0, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }

        /* synthetic */ f(a aVar, C0155a aVar2) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.u0, com.google.common.collect.n0, com.google.common.collect.s0
        public Set<V> delegate() {
            return this.f4364c;
        }
    }

    /* synthetic */ a(Map map, a aVar, C0155a aVar2) {
        this(map, aVar);
    }

    private V putInBothMaps(@NullableDecl K k, @NullableDecl V v, boolean z) {
        checkKey(k);
        checkValue(v);
        boolean containsKey = containsKey(k);
        if (containsKey && k.a(v, get(k))) {
            return v;
        }
        if (z) {
            inverse().remove(v);
        } else {
            n.j(!containsValue(v), "value already present: %s", v);
        }
        V put = this.delegate.put(k, v);
        updateInverseMap(k, containsKey, put, v);
        return put;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CanIgnoreReturnValue
    public V removeFromBothMaps(Object obj) {
        V remove = this.delegate.remove(obj);
        removeFromInverseMap(remove);
        return remove;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFromInverseMap(V v) {
        this.inverse.delegate.remove(v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInverseMap(K k, boolean z, V v, V v2) {
        if (z) {
            removeFromInverseMap(v);
        }
        this.inverse.delegate.put(v2, k);
    }

    @CanIgnoreReturnValue
    abstract K checkKey(@NullableDecl K k);

    @CanIgnoreReturnValue
    V checkValue(@NullableDecl V v) {
        return v;
    }

    @Override // com.google.common.collect.p0, java.util.Map
    public void clear() {
        this.delegate.clear();
        this.inverse.delegate.clear();
    }

    @Override // com.google.common.collect.p0, java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        return this.inverse.containsKey(obj);
    }

    @Override // com.google.common.collect.p0, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        c cVar = new c(this, null);
        this.entrySet = cVar;
        return cVar;
    }

    Iterator<Map.Entry<K, V>> entrySetIterator() {
        return new C0155a(this.delegate.entrySet().iterator());
    }

    @CanIgnoreReturnValue
    public V forcePut(@NullableDecl K k, @NullableDecl V v) {
        return putInBothMaps(k, v, true);
    }

    public t<V, K> inverse() {
        return this.inverse;
    }

    @Override // com.google.common.collect.p0, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        e eVar = new e(this, null);
        this.keySet = eVar;
        return eVar;
    }

    a<V, K> makeInverse(Map<V, K> map) {
        return new d(map, this);
    }

    @Override // com.google.common.collect.p0, java.util.Map
    @CanIgnoreReturnValue
    public V put(@NullableDecl K k, @NullableDecl V v) {
        return putInBothMaps(k, v, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.p0, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.common.collect.p0, java.util.Map
    @CanIgnoreReturnValue
    public V remove(@NullableDecl Object obj) {
        if (containsKey(obj)) {
            return removeFromBothMaps(obj);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDelegates(Map<K, V> map, Map<V, K> map2) {
        boolean z = true;
        n.u(this.delegate == null);
        n.u(this.inverse == null);
        n.d(map.isEmpty());
        n.d(map2.isEmpty());
        if (map == map2) {
            z = false;
        }
        n.d(z);
        this.delegate = map;
        this.inverse = makeInverse(map2);
    }

    void setInverse(a<V, K> aVar) {
        this.inverse = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Map<K, V> map, Map<V, K> map2) {
        setDelegates(map, map2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.p0, com.google.common.collect.s0
    public Map<K, V> delegate() {
        return this.delegate;
    }

    @Override // com.google.common.collect.p0, java.util.Map
    public Set<V> values() {
        Set<V> set = this.valueSet;
        if (set != null) {
            return set;
        }
        f fVar = new f(this, null);
        this.valueSet = fVar;
        return fVar;
    }

    private a(Map<K, V> map, a<V, K> aVar) {
        this.delegate = map;
        this.inverse = aVar;
    }
}
