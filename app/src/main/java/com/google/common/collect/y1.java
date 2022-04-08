package com.google.common.collect;

import com.google.common.base.k;
import com.google.common.base.n;
import com.google.common.collect.u1;
import com.google.common.collect.v1;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ObjectCountHashMap.java */
/* loaded from: classes2.dex */
public class y1<K> {
    transient Object[] a;

    /* renamed from: b  reason: collision with root package name */
    transient int[] f4658b;

    /* renamed from: c  reason: collision with root package name */
    transient int f4659c;

    /* renamed from: d  reason: collision with root package name */
    transient int f4660d;

    /* renamed from: e  reason: collision with root package name */
    private transient int[] f4661e;

    /* renamed from: f  reason: collision with root package name */
    transient long[] f4662f;
    private transient float g;
    private transient int h;

    /* compiled from: ObjectCountHashMap.java */
    /* loaded from: classes2.dex */
    class a extends v1.b<K> {
        @NullableDecl

        /* renamed from: c  reason: collision with root package name */
        final K f4663c;

        /* renamed from: d  reason: collision with root package name */
        int f4664d;

        a(int i) {
            this.f4663c = (K) y1.this.a[i];
            this.f4664d = i;
        }

        @Override // com.google.common.collect.u1.a
        public K a() {
            return this.f4663c;
        }

        void b() {
            int i = this.f4664d;
            if (i == -1 || i >= y1.this.C() || !k.a(this.f4663c, y1.this.a[this.f4664d])) {
                this.f4664d = y1.this.m(this.f4663c);
            }
        }

        @Override // com.google.common.collect.u1.a
        public int getCount() {
            b();
            int i = this.f4664d;
            if (i == -1) {
                return 0;
            }
            return y1.this.f4658b[i];
        }
    }

    y1() {
        n(3, 1.0f);
    }

    private void A(int i) {
        if (this.f4661e.length >= 1073741824) {
            this.h = Integer.MAX_VALUE;
            return;
        }
        int i2 = ((int) (i * this.g)) + 1;
        int[] r = r(i);
        long[] jArr = this.f4662f;
        int length = r.length - 1;
        for (int i3 = 0; i3 < this.f4659c; i3++) {
            int h = h(jArr[i3]);
            int i4 = h & length;
            int i5 = r[i4];
            r[i4] = i3;
            jArr[i3] = (h << 32) | (i5 & 4294967295L);
        }
        this.h = i2;
        this.f4661e = r;
    }

    private static long D(long j, int i) {
        return (j & (-4294967296L)) | (i & 4294967295L);
    }

    public static <K> y1<K> b() {
        return new y1<>();
    }

    public static <K> y1<K> c(int i) {
        return new y1<>(i);
    }

    private static int h(long j) {
        return (int) (j >>> 32);
    }

    private static int j(long j) {
        return (int) j;
    }

    private int l() {
        return this.f4661e.length - 1;
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

    private int w(@NullableDecl Object obj, int i) {
        int l = l() & i;
        int i2 = this.f4661e[l];
        if (i2 == -1) {
            return 0;
        }
        int i3 = -1;
        while (true) {
            if (h(this.f4662f[i2]) != i || !k.a(obj, this.a[i2])) {
                int j = j(this.f4662f[i2]);
                if (j == -1) {
                    return 0;
                }
                i3 = i2;
                i2 = j;
            } else {
                int i4 = this.f4658b[i2];
                if (i3 == -1) {
                    this.f4661e[l] = j(this.f4662f[i2]);
                } else {
                    long[] jArr = this.f4662f;
                    jArr[i3] = D(jArr[i3], j(jArr[i2]));
                }
                p(i2);
                this.f4659c--;
                this.f4660d++;
                return i4;
            }
        }
    }

    private void z(int i) {
        int length = this.f4662f.length;
        if (i > length) {
            int max = Math.max(1, length >>> 1) + length;
            if (max < 0) {
                max = Integer.MAX_VALUE;
            }
            if (max != length) {
                y(max);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(int i, int i2) {
        n.m(i, this.f4659c);
        this.f4658b[i] = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int C() {
        return this.f4659c;
    }

    public void a() {
        this.f4660d++;
        Arrays.fill(this.a, 0, this.f4659c, (Object) null);
        Arrays.fill(this.f4658b, 0, this.f4659c, 0);
        Arrays.fill(this.f4661e, -1);
        Arrays.fill(this.f4662f, -1L);
        this.f4659c = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i) {
        if (i > this.f4662f.length) {
            y(i);
        }
        if (i >= this.h) {
            A(Math.max(2, Integer.highestOneBit(i - 1) << 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f4659c == 0 ? -1 : 0;
    }

    public int f(@NullableDecl Object obj) {
        int m = m(obj);
        if (m == -1) {
            return 0;
        }
        return this.f4658b[m];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u1.a<K> g(int i) {
        n.m(i, this.f4659c);
        return new a(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public K i(int i) {
        n.m(i, this.f4659c);
        return (K) this.a[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k(int i) {
        n.m(i, this.f4659c);
        return this.f4658b[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m(@NullableDecl Object obj) {
        int d2 = y0.d(obj);
        int i = this.f4661e[l() & d2];
        while (i != -1) {
            long j = this.f4662f[i];
            if (h(j) == d2 && k.a(obj, this.a[i])) {
                return i;
            }
            i = j(j);
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
        this.f4661e = r(a2);
        this.g = f2;
        this.a = new Object[i];
        this.f4658b = new int[i];
        this.f4662f = q(i);
        this.h = Math.max(1, (int) (a2 * f2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(int i, @NullableDecl K k, int i2, int i3) {
        this.f4662f[i] = (i3 << 32) | 4294967295L;
        this.a[i] = k;
        this.f4658b[i] = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(int i) {
        int C = C() - 1;
        if (i < C) {
            Object[] objArr = this.a;
            objArr[i] = objArr[C];
            int[] iArr = this.f4658b;
            iArr[i] = iArr[C];
            objArr[C] = null;
            iArr[C] = 0;
            long[] jArr = this.f4662f;
            long j = jArr[C];
            jArr[i] = j;
            jArr[C] = -1;
            int h = h(j) & l();
            int[] iArr2 = this.f4661e;
            int i2 = iArr2[h];
            if (i2 == C) {
                iArr2[h] = i;
                return;
            }
            while (true) {
                long j2 = this.f4662f[i2];
                int j3 = j(j2);
                if (j3 == C) {
                    this.f4662f[i2] = D(j2, i);
                    return;
                }
                i2 = j3;
            }
        } else {
            this.a[i] = null;
            this.f4658b[i] = 0;
            this.f4662f[i] = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int s(int i) {
        int i2 = i + 1;
        if (i2 < this.f4659c) {
            return i2;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int t(int i, int i2) {
        return i - 1;
    }

    @CanIgnoreReturnValue
    public int u(@NullableDecl K k, int i) {
        v.d(i, "count");
        long[] jArr = this.f4662f;
        Object[] objArr = this.a;
        int[] iArr = this.f4658b;
        int d2 = y0.d(k);
        int l = l() & d2;
        int i2 = this.f4659c;
        int[] iArr2 = this.f4661e;
        int i3 = iArr2[l];
        if (i3 == -1) {
            iArr2[l] = i2;
        } else {
            while (true) {
                long j = jArr[i3];
                if (h(j) != d2 || !k.a(k, objArr[i3])) {
                    int j2 = j(j);
                    if (j2 == -1) {
                        jArr[i3] = D(j, i2);
                        break;
                    }
                    i3 = j2;
                } else {
                    int i4 = iArr[i3];
                    iArr[i3] = i;
                    return i4;
                }
            }
        }
        if (i2 != Integer.MAX_VALUE) {
            int i5 = i2 + 1;
            z(i5);
            o(i2, k, i, d2);
            this.f4659c = i5;
            if (i2 >= this.h) {
                A(this.f4661e.length * 2);
            }
            this.f4660d++;
            return 0;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    }

    @CanIgnoreReturnValue
    public int v(@NullableDecl Object obj) {
        return w(obj, y0.d(obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public int x(int i) {
        return w(this.a[i], h(this.f4662f[i]));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(int i) {
        this.a = Arrays.copyOf(this.a, i);
        this.f4658b = Arrays.copyOf(this.f4658b, i);
        long[] jArr = this.f4662f;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i);
        if (i > length) {
            Arrays.fill(copyOf, length, i, -1L);
        }
        this.f4662f = copyOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public y1(y1<? extends K> y1Var) {
        n(y1Var.C(), 1.0f);
        int e2 = y1Var.e();
        while (e2 != -1) {
            u(y1Var.i(e2), y1Var.k(e2));
            e2 = y1Var.s(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y1(int i) {
        this(i, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y1(int i, float f2) {
        n(i, f2);
    }
}
