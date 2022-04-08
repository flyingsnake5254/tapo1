package com.google.common.collect;

import com.google.common.base.n;
import com.google.common.collect.r2;
import com.google.common.collect.u1;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes2.dex */
public final class ConcurrentHashMultiset<E> extends i<E> implements Serializable {
    private static final long serialVersionUID = 1;
    private final transient ConcurrentMap<E, AtomicInteger> countMap;

    /* loaded from: classes2.dex */
    class b extends c<u1.a<E>> {

        /* renamed from: f  reason: collision with root package name */
        private final Iterator<Map.Entry<E, AtomicInteger>> f4168f;

        b() {
            this.f4168f = ConcurrentHashMultiset.this.countMap.entrySet().iterator();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d */
        public u1.a<E> a() {
            while (this.f4168f.hasNext()) {
                Map.Entry<E, AtomicInteger> next = this.f4168f.next();
                int i = next.getValue().get();
                if (i != 0) {
                    return v1.g(next.getKey(), i);
                }
            }
            return b();
        }
    }

    /* loaded from: classes2.dex */
    class c extends o0<u1.a<E>> {
        @NullableDecl

        /* renamed from: c  reason: collision with root package name */
        private u1.a<E> f4169c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Iterator f4170d;

        c(Iterator it) {
            this.f4170d = it;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.o0
        /* renamed from: a */
        public Iterator<u1.a<E>> delegate() {
            return this.f4170d;
        }

        /* renamed from: b */
        public u1.a<E> next() {
            u1.a<E> aVar = (u1.a) super.next();
            this.f4169c = aVar;
            return aVar;
        }

        @Override // java.util.Iterator
        public void remove() {
            v.e(this.f4169c != null);
            ConcurrentHashMultiset.this.setCount(this.f4169c.a(), 0);
            this.f4169c = null;
        }
    }

    /* loaded from: classes2.dex */
    private class d extends i<E>.b {
        private d() {
            super();
        }

        private List<u1.a<E>> g() {
            ArrayList l = n1.l(size());
            k1.a(l, iterator());
            return l;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: e */
        public ConcurrentHashMultiset<E> c() {
            return ConcurrentHashMultiset.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return g().toArray();
        }

        /* synthetic */ d(ConcurrentHashMultiset concurrentHashMultiset, a aVar) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) g().toArray(tArr);
        }
    }

    /* loaded from: classes2.dex */
    private static class e {
        static final r2.b<ConcurrentHashMultiset> a = r2.a(ConcurrentHashMultiset.class, "countMap");
    }

    ConcurrentHashMultiset(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        n.j(concurrentMap.isEmpty(), "the backing map (%s) must be empty", concurrentMap);
        this.countMap = concurrentMap;
    }

    public static <E> ConcurrentHashMultiset<E> create() {
        return new ConcurrentHashMultiset<>(new ConcurrentHashMap());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        e.a.b(this, (ConcurrentMap) objectInputStream.readObject());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private List<E> snapshot() {
        ArrayList l = n1.l(size());
        for (u1.a aVar : entrySet()) {
            Object a2 = aVar.a();
            for (int count = aVar.getCount(); count > 0; count--) {
                l.add(a2);
            }
        }
        return l;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.countMap);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x005a, code lost:
        r2 = new java.util.concurrent.atomic.AtomicInteger(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0065, code lost:
        if (r4.countMap.putIfAbsent(r5, r2) == null) goto L_0x006f;
     */
    @Override // com.google.common.collect.i, com.google.common.collect.u1
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int add(E r5, int r6) {
        /*
            r4 = this;
            com.google.common.base.n.o(r5)
            if (r6 != 0) goto L_0x000a
            int r5 = r4.count(r5)
            return r5
        L_0x000a:
            java.lang.String r0 = "occurences"
            com.google.common.collect.v.d(r6, r0)
        L_0x000f:
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r0 = r4.countMap
            java.lang.Object r0 = com.google.common.collect.q1.v(r0, r5)
            java.util.concurrent.atomic.AtomicInteger r0 = (java.util.concurrent.atomic.AtomicInteger) r0
            r1 = 0
            if (r0 != 0) goto L_0x002a
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r0 = r4.countMap
            java.util.concurrent.atomic.AtomicInteger r2 = new java.util.concurrent.atomic.AtomicInteger
            r2.<init>(r6)
            java.lang.Object r0 = r0.putIfAbsent(r5, r2)
            java.util.concurrent.atomic.AtomicInteger r0 = (java.util.concurrent.atomic.AtomicInteger) r0
            if (r0 != 0) goto L_0x002a
            return r1
        L_0x002a:
            int r2 = r0.get()
            if (r2 == 0) goto L_0x005a
            int r3 = com.google.common.math.c.a(r2, r6)     // Catch: ArithmeticException -> 0x003b
            boolean r3 = r0.compareAndSet(r2, r3)     // Catch: ArithmeticException -> 0x003b
            if (r3 == 0) goto L_0x002a
            return r2
        L_0x003b:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Overflow adding "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r6 = " occurrences to a count of "
            r0.append(r6)
            r0.append(r2)
            java.lang.String r6 = r0.toString()
            r5.<init>(r6)
            throw r5
        L_0x005a:
            java.util.concurrent.atomic.AtomicInteger r2 = new java.util.concurrent.atomic.AtomicInteger
            r2.<init>(r6)
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r3 = r4.countMap
            java.lang.Object r3 = r3.putIfAbsent(r5, r2)
            if (r3 == 0) goto L_0x006f
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r3 = r4.countMap
            boolean r0 = r3.replace(r5, r0, r2)
            if (r0 == 0) goto L_0x000f
        L_0x006f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ConcurrentHashMultiset.add(java.lang.Object, int):int");
    }

    @Override // com.google.common.collect.i, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.countMap.clear();
    }

    @Override // com.google.common.collect.i, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.u1
    public /* bridge */ /* synthetic */ boolean contains(@NullableDecl Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.u1
    public int count(@NullableDecl Object obj) {
        AtomicInteger atomicInteger = (AtomicInteger) q1.v(this.countMap, obj);
        if (atomicInteger == null) {
            return 0;
        }
        return atomicInteger.get();
    }

    @Override // com.google.common.collect.i
    Set<E> createElementSet() {
        return new a(this.countMap.keySet());
    }

    @Override // com.google.common.collect.i
    @Deprecated
    public Set<u1.a<E>> createEntrySet() {
        return new d(this, null);
    }

    @Override // com.google.common.collect.i
    int distinctElements() {
        return this.countMap.size();
    }

    @Override // com.google.common.collect.i
    Iterator<E> elementIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.i, com.google.common.collect.u1
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.i
    public Iterator<u1.a<E>> entryIterator() {
        return new c(new b());
    }

    @Override // com.google.common.collect.i, com.google.common.collect.u1
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.i, java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.countMap.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return v1.i(this);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.u1
    @CanIgnoreReturnValue
    public int remove(@NullableDecl Object obj, int i) {
        int i2;
        int max;
        if (i == 0) {
            return count(obj);
        }
        v.d(i, "occurences");
        AtomicInteger atomicInteger = (AtomicInteger) q1.v(this.countMap, obj);
        if (atomicInteger == null) {
            return 0;
        }
        do {
            i2 = atomicInteger.get();
            if (i2 == 0) {
                return 0;
            }
            max = Math.max(0, i2 - i);
        } while (!atomicInteger.compareAndSet(i2, max));
        if (max == 0) {
            this.countMap.remove(obj, atomicInteger);
        }
        return i2;
    }

    @CanIgnoreReturnValue
    public boolean removeExactly(@NullableDecl Object obj, int i) {
        int i2;
        int i3;
        if (i == 0) {
            return true;
        }
        v.d(i, "occurences");
        AtomicInteger atomicInteger = (AtomicInteger) q1.v(this.countMap, obj);
        if (atomicInteger == null) {
            return false;
        }
        do {
            i2 = atomicInteger.get();
            if (i2 < i) {
                return false;
            }
            i3 = i2 - i;
        } while (!atomicInteger.compareAndSet(i2, i3));
        if (i3 == 0) {
            this.countMap.remove(obj, atomicInteger);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002c, code lost:
        if (r6 != 0) goto L_0x002f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002e, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
        r2 = new java.util.concurrent.atomic.AtomicInteger(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
        if (r4.countMap.putIfAbsent(r5, r2) == null) goto L_0x0044;
     */
    @Override // com.google.common.collect.i, com.google.common.collect.u1
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int setCount(E r5, int r6) {
        /*
            r4 = this;
            com.google.common.base.n.o(r5)
            java.lang.String r0 = "count"
            com.google.common.collect.v.b(r6, r0)
        L_0x0008:
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r0 = r4.countMap
            java.lang.Object r0 = com.google.common.collect.q1.v(r0, r5)
            java.util.concurrent.atomic.AtomicInteger r0 = (java.util.concurrent.atomic.AtomicInteger) r0
            r1 = 0
            if (r0 != 0) goto L_0x0026
            if (r6 != 0) goto L_0x0016
            return r1
        L_0x0016:
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r0 = r4.countMap
            java.util.concurrent.atomic.AtomicInteger r2 = new java.util.concurrent.atomic.AtomicInteger
            r2.<init>(r6)
            java.lang.Object r0 = r0.putIfAbsent(r5, r2)
            java.util.concurrent.atomic.AtomicInteger r0 = (java.util.concurrent.atomic.AtomicInteger) r0
            if (r0 != 0) goto L_0x0026
            return r1
        L_0x0026:
            int r2 = r0.get()
            if (r2 != 0) goto L_0x0045
            if (r6 != 0) goto L_0x002f
            return r1
        L_0x002f:
            java.util.concurrent.atomic.AtomicInteger r2 = new java.util.concurrent.atomic.AtomicInteger
            r2.<init>(r6)
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r3 = r4.countMap
            java.lang.Object r3 = r3.putIfAbsent(r5, r2)
            if (r3 == 0) goto L_0x0044
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r3 = r4.countMap
            boolean r0 = r3.replace(r5, r0, r2)
            if (r0 == 0) goto L_0x0008
        L_0x0044:
            return r1
        L_0x0045:
            boolean r3 = r0.compareAndSet(r2, r6)
            if (r3 == 0) goto L_0x0026
            if (r6 != 0) goto L_0x0052
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r6 = r4.countMap
            r6.remove(r5, r0)
        L_0x0052:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ConcurrentHashMultiset.setCount(java.lang.Object, int):int");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.u1
    public int size() {
        long j = 0;
        for (AtomicInteger atomicInteger : this.countMap.values()) {
            j += atomicInteger.get();
        }
        return com.google.common.primitives.d.i(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return snapshot().toArray();
    }

    /* loaded from: classes2.dex */
    class a extends u0<E> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Set f4166c;

        a(Set set) {
            this.f4166c = set;
        }

        @Override // com.google.common.collect.n0, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            return obj != null && w.d(this.f4166c, obj);
        }

        @Override // com.google.common.collect.n0, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return standardContainsAll(collection);
        }

        @Override // com.google.common.collect.n0, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return obj != null && w.e(this.f4166c, obj);
        }

        @Override // com.google.common.collect.n0, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.u0, com.google.common.collect.n0, com.google.common.collect.s0
        public Set<E> delegate() {
            return this.f4166c;
        }
    }

    public static <E> ConcurrentHashMultiset<E> create(Iterable<? extends E> iterable) {
        ConcurrentHashMultiset<E> create = create();
        j1.a(create, iterable);
        return create;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) snapshot().toArray(tArr);
    }

    public static <E> ConcurrentHashMultiset<E> create(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        return new ConcurrentHashMultiset<>(concurrentMap);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.u1
    @CanIgnoreReturnValue
    public boolean setCount(E e2, int i, int i2) {
        n.o(e2);
        v.b(i, "oldCount");
        v.b(i2, "newCount");
        AtomicInteger atomicInteger = (AtomicInteger) q1.v(this.countMap, e2);
        if (atomicInteger != null) {
            int i3 = atomicInteger.get();
            if (i3 == i) {
                if (i3 == 0) {
                    if (i2 == 0) {
                        this.countMap.remove(e2, atomicInteger);
                        return true;
                    }
                    AtomicInteger atomicInteger2 = new AtomicInteger(i2);
                    return this.countMap.putIfAbsent(e2, atomicInteger2) == null || this.countMap.replace(e2, atomicInteger, atomicInteger2);
                } else if (atomicInteger.compareAndSet(i3, i2)) {
                    if (i2 == 0) {
                        this.countMap.remove(e2, atomicInteger);
                    }
                    return true;
                }
            }
            return false;
        } else if (i != 0) {
            return false;
        } else {
            return i2 == 0 || this.countMap.putIfAbsent(e2, new AtomicInteger(i2)) == null;
        }
    }
}
