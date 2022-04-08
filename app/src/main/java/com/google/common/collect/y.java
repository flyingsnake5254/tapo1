package com.google.common.collect;

import com.google.common.base.k;
import com.google.common.base.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CompactHashSet.java */
/* loaded from: classes2.dex */
public class y<E> extends AbstractSet<E> implements Serializable {
    @MonotonicNonNullDecl

    /* renamed from: c  reason: collision with root package name */
    private transient int[] f4652c;
    @MonotonicNonNullDecl

    /* renamed from: d  reason: collision with root package name */
    private transient long[] f4653d;
    @MonotonicNonNullDecl

    /* renamed from: f  reason: collision with root package name */
    transient Object[] f4654f;
    transient float q;
    transient int x;
    private transient int y;
    private transient int z;

    /* compiled from: CompactHashSet.java */
    /* loaded from: classes2.dex */
    class a implements Iterator<E> {

        /* renamed from: c  reason: collision with root package name */
        int f4655c;

        /* renamed from: d  reason: collision with root package name */
        int f4656d;

        /* renamed from: f  reason: collision with root package name */
        int f4657f = -1;

        a() {
            this.f4655c = y.this.x;
            this.f4656d = y.this.i();
        }

        private void a() {
            if (y.this.x != this.f4655c) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4656d >= 0;
        }

        @Override // java.util.Iterator
        public E next() {
            a();
            if (hasNext()) {
                int i = this.f4656d;
                this.f4657f = i;
                y yVar = y.this;
                E e2 = (E) yVar.f4654f[i];
                this.f4656d = yVar.l(i);
                return e2;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            v.e(this.f4657f >= 0);
            this.f4655c++;
            y yVar = y.this;
            yVar.s(yVar.f4654f[this.f4657f], y.j(yVar.f4653d[this.f4657f]));
            this.f4656d = y.this.f(this.f4656d, this.f4657f);
            this.f4657f = -1;
        }
    }

    y() {
        n(3, 1.0f);
    }

    public static <E> y<E> g() {
        return new y<>();
    }

    public static <E> y<E> h(int i) {
        return new y<>(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int j(long j) {
        return (int) (j >>> 32);
    }

    private static int k(long j) {
        return (int) j;
    }

    private int m() {
        return this.f4652c.length - 1;
    }

    private static long[] q(int i) {
        long[] jArr = new long[i];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    private static int[] r(int i) {
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CanIgnoreReturnValue
    public boolean s(Object obj, int i) {
        int m = m() & i;
        int i2 = this.f4652c[m];
        if (i2 == -1) {
            return false;
        }
        int i3 = -1;
        while (true) {
            if (j(this.f4653d[i2]) != i || !k.a(obj, this.f4654f[i2])) {
                int k = k(this.f4653d[i2]);
                if (k == -1) {
                    return false;
                }
                i3 = i2;
                i2 = k;
            } else {
                if (i3 == -1) {
                    this.f4652c[m] = k(this.f4653d[i2]);
                } else {
                    long[] jArr = this.f4653d;
                    jArr[i3] = w(jArr[i3], k(jArr[i2]));
                }
                p(i2);
                this.z--;
                this.x++;
                return true;
            }
        }
    }

    private void u(int i) {
        int length = this.f4653d.length;
        if (i > length) {
            int max = Math.max(1, length >>> 1) + length;
            if (max < 0) {
                max = Integer.MAX_VALUE;
            }
            if (max != length) {
                t(max);
            }
        }
    }

    private void v(int i) {
        if (this.f4652c.length >= 1073741824) {
            this.y = Integer.MAX_VALUE;
            return;
        }
        int i2 = ((int) (i * this.q)) + 1;
        int[] r = r(i);
        long[] jArr = this.f4653d;
        int length = r.length - 1;
        for (int i3 = 0; i3 < this.z; i3++) {
            int j = j(jArr[i3]);
            int i4 = j & length;
            int i5 = r[i4];
            r[i4] = i3;
            jArr[i3] = (j << 32) | (i5 & 4294967295L);
        }
        this.y = i2;
        this.f4652c = r;
    }

    private static long w(long j, int i) {
        return (j & (-4294967296L)) | (i & 4294967295L);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public boolean add(@NullableDecl E e2) {
        long[] jArr = this.f4653d;
        Object[] objArr = this.f4654f;
        int d2 = y0.d(e2);
        int m = m() & d2;
        int i = this.z;
        int[] iArr = this.f4652c;
        int i2 = iArr[m];
        if (i2 == -1) {
            iArr[m] = i;
        } else {
            while (true) {
                long j = jArr[i2];
                if (j(j) == d2 && k.a(e2, objArr[i2])) {
                    return false;
                }
                int k = k(j);
                if (k == -1) {
                    jArr[i2] = w(j, i);
                    break;
                }
                i2 = k;
            }
        }
        if (i != Integer.MAX_VALUE) {
            int i3 = i + 1;
            u(i3);
            o(i, e2, d2);
            this.z = i3;
            if (i >= this.y) {
                v(this.f4652c.length * 2);
            }
            this.x++;
            return true;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.x++;
        Arrays.fill(this.f4654f, 0, this.z, (Object) null);
        Arrays.fill(this.f4652c, -1);
        Arrays.fill(this.f4653d, -1L);
        this.z = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        int d2 = y0.d(obj);
        int i = this.f4652c[m() & d2];
        while (i != -1) {
            long j = this.f4653d[i];
            if (j(j) == d2 && k.a(obj, this.f4654f[i])) {
                return true;
            }
            i = k(j);
        }
        return false;
    }

    int f(int i, int i2) {
        return i - 1;
    }

    int i() {
        return isEmpty() ? -1 : 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.z == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return new a();
    }

    int l(int i) {
        int i2 = i + 1;
        if (i2 < this.z) {
            return i2;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(int i, float f2) {
        boolean z = false;
        n.e(i >= 0, "Initial capacity must be non-negative");
        if (f2 > 0.0f) {
            z = true;
        }
        n.e(z, "Illegal load factor");
        int a2 = y0.a(i, f2);
        this.f4652c = r(a2);
        this.q = f2;
        this.f4654f = new Object[i];
        this.f4653d = q(i);
        this.y = Math.max(1, (int) (a2 * f2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(int i, E e2, int i2) {
        this.f4653d[i] = (i2 << 32) | 4294967295L;
        this.f4654f[i] = e2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(int i) {
        int size = size() - 1;
        if (i < size) {
            Object[] objArr = this.f4654f;
            objArr[i] = objArr[size];
            objArr[size] = null;
            long[] jArr = this.f4653d;
            long j = jArr[size];
            jArr[i] = j;
            jArr[size] = -1;
            int j2 = j(j) & m();
            int[] iArr = this.f4652c;
            int i2 = iArr[j2];
            if (i2 == size) {
                iArr[j2] = i;
                return;
            }
            while (true) {
                long j3 = this.f4653d[i2];
                int k = k(j3);
                if (k == size) {
                    this.f4653d[i2] = w(j3, i);
                    return;
                }
                i2 = k;
            }
        } else {
            this.f4654f[i] = null;
            this.f4653d[i] = -1;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public boolean remove(@NullableDecl Object obj) {
        return s(obj, y0.d(obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(int i) {
        this.f4654f = Arrays.copyOf(this.f4654f, i);
        long[] jArr = this.f4653d;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i);
        if (i > length) {
            Arrays.fill(copyOf, length, i, -1L);
        }
        this.f4653d = copyOf;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return Arrays.copyOf(this.f4654f, this.z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public <T> T[] toArray(T[] tArr) {
        return (T[]) x1.h(this.f4654f, 0, this.z, tArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(int i) {
        n(i, 1.0f);
    }
}
