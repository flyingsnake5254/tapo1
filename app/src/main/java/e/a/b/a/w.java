package e.a.b.a;

import java.math.BigInteger;

/* loaded from: classes4.dex */
public abstract class w {
    private static final int[] a = {13, 41, 121, 337, 897, 2305};

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f15481b = new byte[0];

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f15482c = new int[0];

    /* renamed from: d  reason: collision with root package name */
    private static final h[] f15483d = new h[0];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a implements o {
        final /* synthetic */ v a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i f15484b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f15485c;

        a(v vVar, i iVar, boolean z) {
            this.a = vVar;
            this.f15484b = iVar;
            this.f15485c = z;
        }

        @Override // e.a.b.a.o
        public p a(p pVar) {
            v vVar = new v();
            h c2 = this.a.c();
            if (c2 != null) {
                vVar.f(this.f15484b.a(c2));
            }
            h[] a = this.a.a();
            int length = a.length;
            h[] hVarArr = new h[length];
            for (int i = 0; i < a.length; i++) {
                hVarArr[i] = this.f15484b.a(a[i]);
            }
            vVar.d(hVarArr);
            if (this.f15485c) {
                h[] hVarArr2 = new h[length];
                for (int i2 = 0; i2 < length; i2++) {
                    hVarArr2[i2] = hVarArr[i2].z();
                }
                vVar.e(hVarArr2);
            }
            return vVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class b implements o {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f15486b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ h f15487c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d f15488d;

        b(int i, boolean z, h hVar, d dVar) {
            this.a = i;
            this.f15486b = z;
            this.f15487c = hVar;
            this.f15488d = dVar;
        }

        private boolean b(v vVar, int i, boolean z) {
            return vVar != null && c(vVar.a(), i) && (!z || c(vVar.b(), i));
        }

        private boolean c(h[] hVarArr, int i) {
            return hVarArr != null && hVarArr.length >= i;
        }

        /* JADX WARN: Removed duplicated region for block: B:43:0x00c5 A[LOOP:0: B:42:0x00c3->B:43:0x00c5, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:54:0x00ea A[LOOP:1: B:53:0x00e8->B:54:0x00ea, LOOP_END] */
        @Override // e.a.b.a.o
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public e.a.b.a.p a(e.a.b.a.p r12) {
            /*
                Method dump skipped, instructions count: 260
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: e.a.b.a.w.b.a(e.a.b.a.p):e.a.b.a.p");
        }
    }

    public static int[] c(BigInteger bigInteger) {
        if ((bigInteger.bitLength() >>> 16) != 0) {
            throw new IllegalArgumentException("'k' must have bitlength < 2^16");
        } else if (bigInteger.signum() == 0) {
            return f15482c;
        } else {
            BigInteger add = bigInteger.shiftLeft(1).add(bigInteger);
            int bitLength = add.bitLength();
            int i = bitLength >> 1;
            int[] iArr = new int[i];
            BigInteger xor = add.xor(bigInteger);
            int i2 = bitLength - 1;
            int i3 = 0;
            int i4 = 0;
            int i5 = 1;
            while (i5 < i2) {
                if (!xor.testBit(i5)) {
                    i4++;
                } else {
                    i3++;
                    iArr[i3] = i4 | ((bigInteger.testBit(i5) ? -1 : 1) << 16);
                    i5++;
                    i4 = 1;
                }
                i5++;
            }
            int i6 = i3 + 1;
            iArr[i3] = 65536 | i4;
            return i > i6 ? p(iArr, i6) : iArr;
        }
    }

    public static int[] d(int i, BigInteger bigInteger) {
        if (i == 2) {
            return c(bigInteger);
        }
        if (i < 2 || i > 16) {
            throw new IllegalArgumentException("'width' must be in the range [2, 16]");
        } else if ((bigInteger.bitLength() >>> 16) != 0) {
            throw new IllegalArgumentException("'k' must have bitlength < 2^16");
        } else if (bigInteger.signum() == 0) {
            return f15482c;
        } else {
            int bitLength = (bigInteger.bitLength() / i) + 1;
            int[] iArr = new int[bitLength];
            int i2 = 1 << i;
            int i3 = i2 - 1;
            int i4 = i2 >>> 1;
            int i5 = 0;
            int i6 = 0;
            boolean z = false;
            while (i5 <= bigInteger.bitLength()) {
                if (bigInteger.testBit(i5) == z) {
                    i5++;
                } else {
                    bigInteger = bigInteger.shiftRight(i5);
                    int intValue = bigInteger.intValue() & i3;
                    if (z) {
                        intValue++;
                    }
                    z = (intValue & i4) != 0;
                    if (z) {
                        intValue -= i2;
                    }
                    if (i6 > 0) {
                        i5--;
                    }
                    i6++;
                    iArr[i6] = i5 | (intValue << 16);
                    i5 = i;
                }
            }
            return bitLength > i6 ? p(iArr, i6) : iArr;
        }
    }

    public static byte[] e(BigInteger bigInteger) {
        if (bigInteger.signum() == 0) {
            return f15481b;
        }
        BigInteger add = bigInteger.shiftLeft(1).add(bigInteger);
        int bitLength = add.bitLength() - 1;
        byte[] bArr = new byte[bitLength];
        BigInteger xor = add.xor(bigInteger);
        int i = 1;
        while (i < bitLength) {
            if (xor.testBit(i)) {
                bArr[i - 1] = (byte) (bigInteger.testBit(i) ? -1 : 1);
                i++;
            }
            i++;
        }
        bArr[bitLength - 1] = 1;
        return bArr;
    }

    public static byte[] f(int i, BigInteger bigInteger) {
        if (i == 2) {
            return e(bigInteger);
        }
        if (i < 2 || i > 8) {
            throw new IllegalArgumentException("'width' must be in the range [2, 8]");
        } else if (bigInteger.signum() == 0) {
            return f15481b;
        } else {
            int bitLength = bigInteger.bitLength() + 1;
            byte[] bArr = new byte[bitLength];
            int i2 = 1 << i;
            int i3 = i2 - 1;
            int i4 = i2 >>> 1;
            int i5 = 0;
            int i6 = 0;
            boolean z = false;
            while (i5 <= bigInteger.bitLength()) {
                if (bigInteger.testBit(i5) == z) {
                    i5++;
                } else {
                    bigInteger = bigInteger.shiftRight(i5);
                    int intValue = bigInteger.intValue() & i3;
                    if (z) {
                        intValue++;
                    }
                    z = (intValue & i4) != 0;
                    if (z) {
                        intValue -= i2;
                    }
                    if (i6 > 0) {
                        i5--;
                    }
                    int i7 = i6 + i5;
                    i6 = i7 + 1;
                    bArr[i7] = (byte) intValue;
                    i5 = i;
                }
            }
            return bitLength > i6 ? o(bArr, i6) : bArr;
        }
    }

    public static int g(BigInteger bigInteger) {
        if (bigInteger.signum() == 0) {
            return 0;
        }
        return bigInteger.shiftLeft(1).add(bigInteger).xor(bigInteger).bitCount();
    }

    public static v h(h hVar) {
        return i(hVar.i().x(hVar, "bc_wnaf"));
    }

    public static v i(p pVar) {
        if (pVar instanceof v) {
            return (v) pVar;
        }
        return null;
    }

    public static int j(int i) {
        return k(i, a);
    }

    public static int k(int i, int[] iArr) {
        int i2 = 0;
        while (i2 < iArr.length && i >= iArr[i2]) {
            i2++;
        }
        return i2 + 2;
    }

    public static h l(h hVar, int i, boolean z, i iVar) {
        d i2 = hVar.i();
        v m = m(hVar, i, z);
        h a2 = iVar.a(hVar);
        i2.B(a2, "bc_wnaf", new a(m, iVar, z));
        return a2;
    }

    public static v m(h hVar, int i, boolean z) {
        d i2 = hVar.i();
        return (v) i2.B(hVar, "bc_wnaf", new b(i, z, hVar, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static h[] n(h[] hVarArr, int i) {
        h[] hVarArr2 = new h[i];
        System.arraycopy(hVarArr, 0, hVarArr2, 0, hVarArr.length);
        return hVarArr2;
    }

    private static byte[] o(byte[] bArr, int i) {
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        return bArr2;
    }

    private static int[] p(int[] iArr, int i) {
        int[] iArr2 = new int[i];
        System.arraycopy(iArr, 0, iArr2, 0, i);
        return iArr2;
    }
}
