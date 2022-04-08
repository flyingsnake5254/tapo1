package e.a.b.a;

import e.a.b.a.e;
import e.a.b.a.h;
import e.a.b.c.m;
import java.math.BigInteger;
import java.util.Hashtable;
import java.util.Random;

/* loaded from: classes4.dex */
public abstract class d {
    protected e.a.b.b.a a;

    /* renamed from: b  reason: collision with root package name */
    protected e f15443b;

    /* renamed from: c  reason: collision with root package name */
    protected e f15444c;

    /* renamed from: d  reason: collision with root package name */
    protected BigInteger f15445d;

    /* renamed from: e  reason: collision with root package name */
    protected BigInteger f15446e;

    /* renamed from: f  reason: collision with root package name */
    protected int f15447f = 0;
    protected e.a.b.a.b0.a g = null;
    protected g h = null;

    /* loaded from: classes4.dex */
    class a implements f {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f15448b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ byte[] f15449c;

        a(int i, int i2, byte[] bArr) {
            this.a = i;
            this.f15448b = i2;
            this.f15449c = bArr;
        }

        @Override // e.a.b.a.f
        public int a() {
            return this.a;
        }

        @Override // e.a.b.a.f
        public h b(int i) {
            int i2;
            int i3 = this.f15448b;
            byte[] bArr = new byte[i3];
            byte[] bArr2 = new byte[i3];
            int i4 = 0;
            for (int i5 = 0; i5 < this.a; i5++) {
                int i6 = ((i5 ^ i) - 1) >> 31;
                int i7 = 0;
                while (true) {
                    i2 = this.f15448b;
                    if (i7 < i2) {
                        byte b2 = bArr[i7];
                        byte[] bArr3 = this.f15449c;
                        bArr[i7] = (byte) (b2 ^ (bArr3[i4 + i7] & i6));
                        bArr2[i7] = (byte) ((bArr3[(i2 + i4) + i7] & i6) ^ bArr2[i7]);
                        i7++;
                    }
                }
                i4 += i2 * 2;
            }
            d dVar = d.this;
            return dVar.i(dVar.n(new BigInteger(1, bArr)), d.this.n(new BigInteger(1, bArr2)), false);
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class b extends d {
        private BigInteger[] i = null;

        /* JADX INFO: Access modifiers changed from: protected */
        public b(int i, int i2, int i3, int i4) {
            super(E(i, i2, i3, i4));
        }

        private static e.a.b.b.a E(int i, int i2, int i3, int i4) {
            if (i2 == 0) {
                throw new IllegalArgumentException("k1 must be > 0");
            } else if (i3 == 0) {
                if (i4 == 0) {
                    return e.a.b.b.b.a(new int[]{0, i2, i});
                }
                throw new IllegalArgumentException("k3 must be 0 if k2 == 0");
            } else if (i3 <= i2) {
                throw new IllegalArgumentException("k2 must be > k1");
            } else if (i4 > i3) {
                return e.a.b.b.b.a(new int[]{0, i2, i3, i4, i});
            } else {
                throw new IllegalArgumentException("k3 must be > k2");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public synchronized BigInteger[] F() {
            if (this.i == null) {
                this.i = s.f(this);
            }
            return this.i;
        }

        public boolean G() {
            return this.f15445d != null && this.f15446e != null && this.f15444c.h() && (this.f15443b.i() || this.f15443b.h());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public e H(e eVar) {
            if (eVar.i()) {
                return eVar;
            }
            e n = n(c.a);
            int t = t();
            Random random = new Random();
            do {
                e n2 = n(new BigInteger(t, random));
                e eVar2 = eVar;
                for (int i = 1; i < t; i++) {
                    e o = eVar2.o();
                    n = n.o().a(o.j(n2));
                    eVar2 = o.a(eVar);
                }
                if (!eVar2.i()) {
                    return null;
                }
            } while (n.o().a(n).i());
            return n;
        }

        @Override // e.a.b.a.d
        public h h(BigInteger bigInteger, BigInteger bigInteger2, boolean z) {
            e n = n(bigInteger);
            e n2 = n(bigInteger2);
            int r = r();
            if (r == 5 || r == 6) {
                if (!n.i()) {
                    n2 = n2.d(n).a(n);
                } else if (!n2.o().equals(p())) {
                    throw new IllegalArgumentException();
                }
            }
            return i(n, n2, z);
        }

        @Override // e.a.b.a.d
        protected h l(int i, BigInteger bigInteger) {
            e eVar;
            e n = n(bigInteger);
            if (n.i()) {
                eVar = p().n();
            } else {
                e H = H(n.o().g().j(p()).a(o()).a(n));
                if (H != null) {
                    if (H.s() != (i == 1)) {
                        H = H.b();
                    }
                    int r = r();
                    eVar = (r == 5 || r == 6) ? H.a(n) : H.j(n);
                } else {
                    eVar = null;
                }
            }
            if (eVar != null) {
                return i(n, eVar, true);
            }
            throw new IllegalArgumentException("Invalid point compression");
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class c extends d {
        /* JADX INFO: Access modifiers changed from: protected */
        public c(BigInteger bigInteger) {
            super(e.a.b.b.b.b(bigInteger));
        }

        @Override // e.a.b.a.d
        protected h l(int i, BigInteger bigInteger) {
            e n = n(bigInteger);
            e n2 = n.o().a(this.f15443b).j(n).a(this.f15444c).n();
            if (n2 != null) {
                if (n2.s() != (i == 1)) {
                    n2 = n2.m();
                }
                return i(n, n2, true);
            }
            throw new IllegalArgumentException("Invalid point compression");
        }
    }

    /* renamed from: e.a.b.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0281d {
        protected int a;

        /* renamed from: b  reason: collision with root package name */
        protected e.a.b.a.b0.a f15451b;

        /* renamed from: c  reason: collision with root package name */
        protected g f15452c;

        C0281d(int i, e.a.b.a.b0.a aVar, g gVar) {
            this.a = i;
            this.f15451b = aVar;
            this.f15452c = gVar;
        }

        public d a() {
            if (d.this.C(this.a)) {
                d c2 = d.this.c();
                if (c2 != d.this) {
                    synchronized (c2) {
                        c2.f15447f = this.a;
                        c2.g = this.f15451b;
                        c2.h = this.f15452c;
                    }
                    return c2;
                }
                throw new IllegalStateException("implementation returned current curve");
            }
            throw new IllegalStateException("unsupported coordinate system");
        }

        public C0281d b(e.a.b.a.b0.a aVar) {
            this.f15451b = aVar;
            return this;
        }
    }

    /* loaded from: classes4.dex */
    public static class e extends b {
        private int j;
        private int k;
        private int l;
        private int m;
        private h.d n;

        /* loaded from: classes4.dex */
        class a implements f {
            final /* synthetic */ int a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f15454b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ long[] f15455c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ int[] f15456d;

            a(int i, int i2, long[] jArr, int[] iArr) {
                this.a = i;
                this.f15454b = i2;
                this.f15455c = jArr;
                this.f15456d = iArr;
            }

            @Override // e.a.b.a.f
            public int a() {
                return this.a;
            }

            @Override // e.a.b.a.f
            public h b(int i) {
                int i2;
                long[] k = m.k(this.f15454b);
                long[] k2 = m.k(this.f15454b);
                int i3 = 0;
                for (int i4 = 0; i4 < this.a; i4++) {
                    long j = ((i4 ^ i) - 1) >> 31;
                    int i5 = 0;
                    while (true) {
                        i2 = this.f15454b;
                        if (i5 < i2) {
                            long j2 = k[i5];
                            long[] jArr = this.f15455c;
                            k[i5] = j2 ^ (jArr[i3 + i5] & j);
                            k2[i5] = k2[i5] ^ (jArr[(i2 + i3) + i5] & j);
                            i5++;
                        }
                    }
                    i3 += i2 * 2;
                }
                return e.this.i(new e.c(e.this.j, this.f15456d, new n(k)), new e.c(e.this.j, this.f15456d, new n(k2)), false);
            }
        }

        protected e(int i, int i2, int i3, int i4, e eVar, e eVar2, BigInteger bigInteger, BigInteger bigInteger2) {
            super(i, i2, i3, i4);
            this.j = i;
            this.k = i2;
            this.l = i3;
            this.m = i4;
            this.f15445d = bigInteger;
            this.f15446e = bigInteger2;
            this.n = new h.d(this, null, null, false);
            this.f15443b = eVar;
            this.f15444c = eVar2;
            this.f15447f = 6;
        }

        public e(int i, int i2, int i3, int i4, BigInteger bigInteger, BigInteger bigInteger2) {
            this(i, i2, i3, i4, bigInteger, bigInteger2, (BigInteger) null, (BigInteger) null);
        }

        public e(int i, int i2, int i3, int i4, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            super(i, i2, i3, i4);
            this.j = i;
            this.k = i2;
            this.l = i3;
            this.m = i4;
            this.f15445d = bigInteger3;
            this.f15446e = bigInteger4;
            this.n = new h.d(this, null, null, false);
            this.f15443b = n(bigInteger);
            this.f15444c = n(bigInteger2);
            this.f15447f = 6;
        }

        public e(int i, int i2, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            this(i, i2, 0, 0, bigInteger, bigInteger2, bigInteger3, bigInteger4);
        }

        @Override // e.a.b.a.d
        public boolean C(int i) {
            return i == 0 || i == 1 || i == 6;
        }

        public boolean J() {
            return this.l == 0 && this.m == 0;
        }

        @Override // e.a.b.a.d
        protected d c() {
            return new e(this.j, this.k, this.l, this.m, this.f15443b, this.f15444c, this.f15445d, this.f15446e);
        }

        @Override // e.a.b.a.d
        public f e(h[] hVarArr, int i, int i2) {
            int i3 = (this.j + 63) >>> 6;
            int[] iArr = J() ? new int[]{this.k} : new int[]{this.k, this.l, this.m};
            long[] jArr = new long[i2 * i3 * 2];
            int i4 = 0;
            for (int i5 = 0; i5 < i2; i5++) {
                h hVar = hVarArr[i + i5];
                ((e.c) hVar.n()).j.k(jArr, i4);
                int i6 = i4 + i3;
                ((e.c) hVar.o()).j.k(jArr, i6);
                i4 = i6 + i3;
            }
            return new a(i2, i3, jArr, iArr);
        }

        @Override // e.a.b.a.d
        protected g f() {
            return G() ? new x() : d.super.f();
        }

        @Override // e.a.b.a.d
        protected h i(e eVar, e eVar2, boolean z) {
            return new h.d(this, eVar, eVar2, z);
        }

        @Override // e.a.b.a.d
        protected h j(e eVar, e eVar2, e[] eVarArr, boolean z) {
            return new h.d(this, eVar, eVar2, eVarArr, z);
        }

        @Override // e.a.b.a.d
        public e n(BigInteger bigInteger) {
            return new e.c(this.j, this.k, this.l, this.m, bigInteger);
        }

        @Override // e.a.b.a.d
        public int t() {
            return this.j;
        }

        @Override // e.a.b.a.d
        public h u() {
            return this.n;
        }
    }

    /* loaded from: classes4.dex */
    public static class f extends c {
        BigInteger i;
        BigInteger j;
        h.e k;

        protected f(BigInteger bigInteger, BigInteger bigInteger2, e eVar, e eVar2, BigInteger bigInteger3, BigInteger bigInteger4) {
            super(bigInteger);
            this.i = bigInteger;
            this.j = bigInteger2;
            this.k = new h.e(this, null, null, false);
            this.f15443b = eVar;
            this.f15444c = eVar2;
            this.f15445d = bigInteger3;
            this.f15446e = bigInteger4;
            this.f15447f = 4;
        }

        public f(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            this(bigInteger, bigInteger2, bigInteger3, null, null);
        }

        public f(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5) {
            super(bigInteger);
            this.i = bigInteger;
            this.j = e.d.u(bigInteger);
            this.k = new h.e(this, null, null, false);
            this.f15443b = n(bigInteger2);
            this.f15444c = n(bigInteger3);
            this.f15445d = bigInteger4;
            this.f15446e = bigInteger5;
            this.f15447f = 4;
        }

        @Override // e.a.b.a.d
        public boolean C(int i) {
            return i == 0 || i == 1 || i == 2 || i == 4;
        }

        @Override // e.a.b.a.d
        protected d c() {
            return new f(this.i, this.j, this.f15443b, this.f15444c, this.f15445d, this.f15446e);
        }

        @Override // e.a.b.a.d
        protected h i(e eVar, e eVar2, boolean z) {
            return new h.e(this, eVar, eVar2, z);
        }

        @Override // e.a.b.a.d
        protected h j(e eVar, e eVar2, e[] eVarArr, boolean z) {
            return new h.e(this, eVar, eVar2, eVarArr, z);
        }

        @Override // e.a.b.a.d
        public e n(BigInteger bigInteger) {
            return new e.d(this.i, this.j, bigInteger);
        }

        @Override // e.a.b.a.d
        public int t() {
            return this.i.bitLength();
        }

        @Override // e.a.b.a.d
        public h u() {
            return this.k;
        }

        @Override // e.a.b.a.d
        public h y(h hVar) {
            int r;
            return (this == hVar.i() || r() != 2 || hVar.u() || !((r = hVar.i().r()) == 2 || r == 3 || r == 4)) ? d.super.y(hVar) : new h.e(this, n(hVar.f15459c.t()), n(hVar.f15460d.t()), new e[]{n(hVar.f15461e[0].t())}, hVar.f15462f);
        }
    }

    protected d(e.a.b.b.a aVar) {
        this.a = aVar;
    }

    public void A(h[] hVarArr, int i, int i2, e eVar) {
        b(hVarArr, i, i2);
        int r = r();
        if (r != 0 && r != 5) {
            e[] eVarArr = new e[i2];
            int[] iArr = new int[i2];
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                int i5 = i + i4;
                h hVar = hVarArr[i5];
                if (hVar != null && (eVar != null || !hVar.v())) {
                    eVarArr[i3] = hVar.s(0);
                    i3++;
                    iArr[i3] = i5;
                }
            }
            if (i3 != 0) {
                b.k(eVarArr, 0, i3, eVar);
                for (int i6 = 0; i6 < i3; i6++) {
                    int i7 = iArr[i6];
                    hVarArr[i7] = hVarArr[i7].B(eVarArr[i6]);
                }
            }
        } else if (eVar != null) {
            throw new IllegalArgumentException("'iso' not valid for affine coordinates");
        }
    }

    public p B(h hVar, String str, o oVar) {
        Hashtable hashtable;
        p a2;
        a(hVar);
        synchronized (hVar) {
            hashtable = hVar.g;
            if (hashtable == null) {
                hashtable = new Hashtable(4);
                hVar.g = hashtable;
            }
        }
        synchronized (hashtable) {
            p pVar = (p) hashtable.get(str);
            a2 = oVar.a(pVar);
            if (a2 != pVar) {
                hashtable.put(str, a2);
            }
        }
        return a2;
    }

    public boolean C(int i) {
        return i == 0;
    }

    public h D(BigInteger bigInteger, BigInteger bigInteger2) {
        h g = g(bigInteger, bigInteger2);
        if (g.w()) {
            return g;
        }
        throw new IllegalArgumentException("Invalid point coordinates");
    }

    protected void a(h hVar) {
        if (hVar == null || this != hVar.i()) {
            throw new IllegalArgumentException("'point' must be non-null and on this curve");
        }
    }

    protected void b(h[] hVarArr, int i, int i2) {
        if (hVarArr == null) {
            throw new IllegalArgumentException("'points' cannot be null");
        } else if (i < 0 || i2 < 0 || i > hVarArr.length - i2) {
            throw new IllegalArgumentException("invalid range specified for 'points'");
        } else {
            for (int i3 = 0; i3 < i2; i3++) {
                h hVar = hVarArr[i + i3];
                if (hVar != null && this != hVar.i()) {
                    throw new IllegalArgumentException("'points' entries must be null or on this curve");
                }
            }
        }
    }

    protected abstract d c();

    public synchronized C0281d d() {
        return new C0281d(this.f15447f, this.g, this.h);
    }

    public f e(h[] hVarArr, int i, int i2) {
        int t = (t() + 7) >>> 3;
        byte[] bArr = new byte[i2 * t * 2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            h hVar = hVarArr[i + i4];
            byte[] byteArray = hVar.n().t().toByteArray();
            byte[] byteArray2 = hVar.o().t().toByteArray();
            int i5 = 1;
            int i6 = byteArray.length > t ? 1 : 0;
            int length = byteArray.length - i6;
            if (byteArray2.length <= t) {
                i5 = 0;
            }
            int length2 = byteArray2.length - i5;
            int i7 = i3 + t;
            System.arraycopy(byteArray, i6, bArr, i7 - length, length);
            i3 = i7 + t;
            System.arraycopy(byteArray2, i5, bArr, i3 - length2, length2);
        }
        return new a(i2, t, bArr);
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof d) && m((d) obj));
    }

    protected g f() {
        e.a.b.a.b0.a aVar = this.g;
        return aVar instanceof e.a.b.a.b0.b ? new m(this, (e.a.b.a.b0.b) aVar) : new u();
    }

    public h g(BigInteger bigInteger, BigInteger bigInteger2) {
        return h(bigInteger, bigInteger2, false);
    }

    public h h(BigInteger bigInteger, BigInteger bigInteger2, boolean z) {
        return i(n(bigInteger), n(bigInteger2), z);
    }

    public int hashCode() {
        return (s().hashCode() ^ org.bouncycastle.util.d.a(o().t().hashCode(), 8)) ^ org.bouncycastle.util.d.a(p().t().hashCode(), 16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract h i(e eVar, e eVar2, boolean z);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract h j(e eVar, e eVar2, e[] eVarArr, boolean z);

    public h k(byte[] bArr) {
        h hVar;
        int t = (t() + 7) / 8;
        boolean z = false;
        byte b2 = bArr[0];
        if (b2 != 0) {
            if (b2 == 2 || b2 == 3) {
                if (bArr.length == t + 1) {
                    hVar = l(b2 & 1, org.bouncycastle.util.b.d(bArr, 1, t));
                    if (!hVar.w()) {
                        throw new IllegalArgumentException("Invalid point");
                    }
                } else {
                    throw new IllegalArgumentException("Incorrect length for compressed encoding");
                }
            } else if (b2 != 4) {
                if (b2 != 6 && b2 != 7) {
                    throw new IllegalArgumentException("Invalid point encoding 0x" + Integer.toString(b2, 16));
                } else if (bArr.length == (t * 2) + 1) {
                    BigInteger d2 = org.bouncycastle.util.b.d(bArr, 1, t);
                    BigInteger d3 = org.bouncycastle.util.b.d(bArr, t + 1, t);
                    boolean testBit = d3.testBit(0);
                    if (b2 == 7) {
                        z = true;
                    }
                    if (testBit == z) {
                        hVar = D(d2, d3);
                    } else {
                        throw new IllegalArgumentException("Inconsistent Y coordinate in hybrid encoding");
                    }
                } else {
                    throw new IllegalArgumentException("Incorrect length for hybrid encoding");
                }
            } else if (bArr.length == (t * 2) + 1) {
                hVar = D(org.bouncycastle.util.b.d(bArr, 1, t), org.bouncycastle.util.b.d(bArr, t + 1, t));
            } else {
                throw new IllegalArgumentException("Incorrect length for uncompressed encoding");
            }
        } else if (bArr.length == 1) {
            hVar = u();
        } else {
            throw new IllegalArgumentException("Incorrect length for infinity encoding");
        }
        if (b2 == 0 || !hVar.u()) {
            return hVar;
        }
        throw new IllegalArgumentException("Invalid infinity encoding");
    }

    protected abstract h l(int i, BigInteger bigInteger);

    public boolean m(d dVar) {
        return this == dVar || (dVar != null && s().equals(dVar.s()) && o().t().equals(dVar.o().t()) && p().t().equals(dVar.p().t()));
    }

    public abstract e n(BigInteger bigInteger);

    public e o() {
        return this.f15443b;
    }

    public e p() {
        return this.f15444c;
    }

    public BigInteger q() {
        return this.f15446e;
    }

    public int r() {
        return this.f15447f;
    }

    public e.a.b.b.a s() {
        return this.a;
    }

    public abstract int t();

    public abstract h u();

    public synchronized g v() {
        if (this.h == null) {
            this.h = f();
        }
        return this.h;
    }

    public BigInteger w() {
        return this.f15445d;
    }

    public p x(h hVar, String str) {
        Hashtable hashtable;
        p pVar;
        a(hVar);
        synchronized (hVar) {
            hashtable = hVar.g;
        }
        if (hashtable == null) {
            return null;
        }
        synchronized (hashtable) {
            pVar = (p) hashtable.get(str);
        }
        return pVar;
    }

    public h y(h hVar) {
        if (this == hVar.i()) {
            return hVar;
        }
        if (hVar.u()) {
            return u();
        }
        h A = hVar.A();
        return h(A.q().t(), A.r().t(), A.f15462f);
    }

    public void z(h[] hVarArr) {
        A(hVarArr, 0, hVarArr.length, null);
    }
}
