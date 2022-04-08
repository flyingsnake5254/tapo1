package com.google.common.collect;

import com.google.common.base.k;
import com.google.common.base.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CompactHashMap.java */
/* loaded from: classes2.dex */
public class x<K, V> extends AbstractMap<K, V> implements Serializable {
    @MonotonicNonNullDecl

    /* renamed from: c  reason: collision with root package name */
    private transient int[] f4640c;
    @MonotonicNonNullDecl

    /* renamed from: d  reason: collision with root package name */
    transient long[] f4641d;
    @MonotonicNonNullDecl

    /* renamed from: f  reason: collision with root package name */
    transient Object[] f4642f;
    private transient int p0;
    @MonotonicNonNullDecl
    private transient Set<K> p1;
    @MonotonicNonNullDecl
    private transient Set<Map.Entry<K, V>> p2;
    @MonotonicNonNullDecl
    private transient Collection<V> p3;
    @MonotonicNonNullDecl
    transient Object[] q;
    transient float x;
    transient int y;
    private transient int z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CompactHashMap.java */
    /* loaded from: classes2.dex */
    public class a extends x<K, V>.e<K> {
        a() {
            super(x.this, null);
        }

        @Override // com.google.common.collect.x.e
        K b(int i) {
            return (K) x.this.f4642f[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CompactHashMap.java */
    /* loaded from: classes2.dex */
    public class b extends x<K, V>.e<Map.Entry<K, V>> {
        b() {
            super(x.this, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: c */
        public Map.Entry<K, V> b(int i) {
            return new g(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CompactHashMap.java */
    /* loaded from: classes2.dex */
    public class c extends x<K, V>.e<V> {
        c() {
            super(x.this, null);
        }

        @Override // com.google.common.collect.x.e
        V b(int i) {
            return (V) x.this.q[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CompactHashMap.java */
    /* loaded from: classes2.dex */
    public class d extends AbstractSet<Map.Entry<K, V>> {
        d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            x.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int s = x.this.s(entry.getKey());
            return s != -1 && k.a(x.this.q[s], entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return x.this.m();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int s = x.this.s(entry.getKey());
            if (s == -1 || !k.a(x.this.q[s], entry.getValue())) {
                return false;
            }
            x.this.A(s);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return x.this.p0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CompactHashMap.java */
    /* loaded from: classes2.dex */
    public class f extends AbstractSet<K> {
        f() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            x.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return x.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return x.this.v();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object obj) {
            int s = x.this.s(obj);
            if (s == -1) {
                return false;
            }
            x.this.A(s);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return x.this.p0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CompactHashMap.java */
    /* loaded from: classes2.dex */
    public final class g extends g<K, V> {
        @NullableDecl

        /* renamed from: c  reason: collision with root package name */
        private final K f4648c;

        /* renamed from: d  reason: collision with root package name */
        private int f4649d;

        g(int i) {
            this.f4648c = (K) x.this.f4642f[i];
            this.f4649d = i;
        }

        private void g() {
            int i = this.f4649d;
            if (i == -1 || i >= x.this.size() || !k.a(this.f4648c, x.this.f4642f[this.f4649d])) {
                this.f4649d = x.this.s(this.f4648c);
            }
        }

        @Override // com.google.common.collect.g, java.util.Map.Entry
        public K getKey() {
            return this.f4648c;
        }

        @Override // com.google.common.collect.g, java.util.Map.Entry
        public V getValue() {
            g();
            int i = this.f4649d;
            if (i == -1) {
                return null;
            }
            return (V) x.this.q[i];
        }

        @Override // com.google.common.collect.g, java.util.Map.Entry
        public V setValue(V v) {
            g();
            int i = this.f4649d;
            if (i == -1) {
                x.this.put(this.f4648c, v);
                return null;
            }
            Object[] objArr = x.this.q;
            V v2 = (V) objArr[i];
            objArr[i] = v;
            return v2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CompactHashMap.java */
    /* loaded from: classes2.dex */
    public class h extends AbstractCollection<V> {
        h() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            x.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return x.this.F();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return x.this.p0;
        }
    }

    x() {
        t(3, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CanIgnoreReturnValue
    public V A(int i) {
        return z(this.f4642f[i], o(this.f4641d[i]));
    }

    private void C(int i) {
        int length = this.f4641d.length;
        if (i > length) {
            int max = Math.max(1, length >>> 1) + length;
            if (max < 0) {
                max = Integer.MAX_VALUE;
            }
            if (max != length) {
                B(max);
            }
        }
    }

    private void D(int i) {
        if (this.f4640c.length >= 1073741824) {
            this.z = Integer.MAX_VALUE;
            return;
        }
        int i2 = ((int) (i * this.x)) + 1;
        int[] y = y(i);
        long[] jArr = this.f4641d;
        int length = y.length - 1;
        for (int i3 = 0; i3 < this.p0; i3++) {
            int o = o(jArr[i3]);
            int i4 = o & length;
            int i5 = y[i4];
            y[i4] = i3;
            jArr[i3] = (o << 32) | (i5 & 4294967295L);
        }
        this.z = i2;
        this.f4640c = y;
    }

    private static long E(long j, int i) {
        return (j & (-4294967296L)) | (i & 4294967295L);
    }

    public static <K, V> x<K, V> h() {
        return new x<>();
    }

    public static <K, V> x<K, V> l(int i) {
        return new x<>(i);
    }

    private static int o(long j) {
        return (int) (j >>> 32);
    }

    private static int p(long j) {
        return (int) j;
    }

    private int r() {
        return this.f4640c.length - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int s(@NullableDecl Object obj) {
        int d2 = y0.d(obj);
        int i = this.f4640c[r() & d2];
        while (i != -1) {
            long j = this.f4641d[i];
            if (o(j) == d2 && k.a(obj, this.f4642f[i])) {
                return i;
            }
            i = p(j);
        }
        return -1;
    }

    private static long[] x(int i) {
        long[] jArr = new long[i];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    private static int[] y(int i) {
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    @NullableDecl
    private V z(@NullableDecl Object obj, int i) {
        int r = r() & i;
        int i2 = this.f4640c[r];
        if (i2 == -1) {
            return null;
        }
        int i3 = -1;
        while (true) {
            if (o(this.f4641d[i2]) != i || !k.a(obj, this.f4642f[i2])) {
                int p = p(this.f4641d[i2]);
                if (p == -1) {
                    return null;
                }
                i3 = i2;
                i2 = p;
            } else {
                V v = (V) this.q[i2];
                if (i3 == -1) {
                    this.f4640c[r] = p(this.f4641d[i2]);
                } else {
                    long[] jArr = this.f4641d;
                    jArr[i3] = E(jArr[i3], p(jArr[i2]));
                }
                w(i2);
                this.p0--;
                this.y++;
                return v;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(int i) {
        this.f4642f = Arrays.copyOf(this.f4642f, i);
        this.q = Arrays.copyOf(this.q, i);
        long[] jArr = this.f4641d;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i);
        if (i > length) {
            Arrays.fill(copyOf, length, i, -1L);
        }
        this.f4641d = copyOf;
    }

    Iterator<V> F() {
        return new c();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.y++;
        Arrays.fill(this.f4642f, 0, this.p0, (Object) null);
        Arrays.fill(this.q, 0, this.p0, (Object) null);
        Arrays.fill(this.f4640c, -1);
        Arrays.fill(this.f4641d, -1L);
        this.p0 = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        return s(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        for (int i = 0; i < this.p0; i++) {
            if (k.a(obj, this.q[i])) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.p2;
        if (set != null) {
            return set;
        }
        Set<Map.Entry<K, V>> i = i();
        this.p2 = i;
        return i;
    }

    void f(int i) {
    }

    int g(int i, int i2) {
        return i - 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(@NullableDecl Object obj) {
        int s = s(obj);
        f(s);
        if (s == -1) {
            return null;
        }
        return (V) this.q[s];
    }

    Set<Map.Entry<K, V>> i() {
        return new d();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this.p0 == 0;
    }

    Set<K> j() {
        return new f();
    }

    Collection<V> k() {
        return new h();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.p1;
        if (set != null) {
            return set;
        }
        Set<K> j = j();
        this.p1 = j;
        return j;
    }

    Iterator<Map.Entry<K, V>> m() {
        return new b();
    }

    int n() {
        return isEmpty() ? -1 : 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @NullableDecl
    public V put(@NullableDecl K k, @NullableDecl V v) {
        long[] jArr = this.f4641d;
        Object[] objArr = this.f4642f;
        Object[] objArr2 = this.q;
        int d2 = y0.d(k);
        int r = r() & d2;
        int i = this.p0;
        int[] iArr = this.f4640c;
        int i2 = iArr[r];
        if (i2 == -1) {
            iArr[r] = i;
        } else {
            while (true) {
                long j = jArr[i2];
                if (o(j) != d2 || !k.a(k, objArr[i2])) {
                    int p = p(j);
                    if (p == -1) {
                        jArr[i2] = E(j, i);
                        break;
                    }
                    i2 = p;
                } else {
                    V v2 = (V) objArr2[i2];
                    objArr2[i2] = v;
                    f(i2);
                    return v2;
                }
            }
        }
        if (i != Integer.MAX_VALUE) {
            int i3 = i + 1;
            C(i3);
            u(i, k, v, d2);
            this.p0 = i3;
            if (i >= this.z) {
                D(this.f4640c.length * 2);
            }
            this.y++;
            return null;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    }

    int q(int i) {
        int i2 = i + 1;
        if (i2 < this.p0) {
            return i2;
        }
        return -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @NullableDecl
    public V remove(@NullableDecl Object obj) {
        return z(obj, y0.d(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.p0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(int i, float f2) {
        boolean z = false;
        n.e(i >= 0, "Initial capacity must be non-negative");
        if (f2 > 0.0f) {
            z = true;
        }
        n.e(z, "Illegal load factor");
        int a2 = y0.a(i, f2);
        this.f4640c = y(a2);
        this.x = f2;
        this.f4642f = new Object[i];
        this.q = new Object[i];
        this.f4641d = x(i);
        this.z = Math.max(1, (int) (a2 * f2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(int i, @NullableDecl K k, @NullableDecl V v, int i2) {
        this.f4641d[i] = (i2 << 32) | 4294967295L;
        this.f4642f[i] = k;
        this.q[i] = v;
    }

    Iterator<K> v() {
        return new a();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.p3;
        if (collection != null) {
            return collection;
        }
        Collection<V> k = k();
        this.p3 = k;
        return k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(int i) {
        int size = size() - 1;
        if (i < size) {
            Object[] objArr = this.f4642f;
            objArr[i] = objArr[size];
            Object[] objArr2 = this.q;
            objArr2[i] = objArr2[size];
            objArr[size] = null;
            objArr2[size] = null;
            long[] jArr = this.f4641d;
            long j = jArr[size];
            jArr[i] = j;
            jArr[size] = -1;
            int o = o(j) & r();
            int[] iArr = this.f4640c;
            int i2 = iArr[o];
            if (i2 == size) {
                iArr[o] = i;
                return;
            }
            while (true) {
                long j2 = this.f4641d[i2];
                int p = p(j2);
                if (p == size) {
                    this.f4641d[i2] = E(j2, i);
                    return;
                }
                i2 = p;
            }
        } else {
            this.f4642f[i] = null;
            this.q[i] = null;
            this.f4641d[i] = -1;
        }
    }

    x(int i) {
        this(i, 1.0f);
    }

    /* compiled from: CompactHashMap.java */
    /* loaded from: classes2.dex */
    private abstract class e<T> implements Iterator<T> {

        /* renamed from: c  reason: collision with root package name */
        int f4644c;

        /* renamed from: d  reason: collision with root package name */
        int f4645d;

        /* renamed from: f  reason: collision with root package name */
        int f4646f;

        private e() {
            this.f4644c = x.this.y;
            this.f4645d = x.this.n();
            this.f4646f = -1;
        }

        private void a() {
            if (x.this.y != this.f4644c) {
                throw new ConcurrentModificationException();
            }
        }

        abstract T b(int i);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4645d >= 0;
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            if (hasNext()) {
                int i = this.f4645d;
                this.f4646f = i;
                T b2 = b(i);
                this.f4645d = x.this.q(this.f4645d);
                return b2;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            v.e(this.f4646f >= 0);
            this.f4644c++;
            x.this.A(this.f4646f);
            this.f4645d = x.this.g(this.f4645d, this.f4646f);
            this.f4646f = -1;
        }

        /* synthetic */ e(x xVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(int i, float f2) {
        t(i, f2);
    }
}
