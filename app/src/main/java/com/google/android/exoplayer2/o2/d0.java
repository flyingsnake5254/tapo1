package com.google.android.exoplayer2.o2;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.u;
import java.util.Arrays;

/* compiled from: VorbisUtil.java */
/* loaded from: classes.dex */
public final class d0 {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VorbisUtil.java */
    /* loaded from: classes.dex */
    public static final class a {
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f2653b;

        /* renamed from: c  reason: collision with root package name */
        public final long[] f2654c;

        /* renamed from: d  reason: collision with root package name */
        public final int f2655d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f2656e;

        public a(int i, int i2, long[] jArr, int i3, boolean z) {
            this.a = i;
            this.f2653b = i2;
            this.f2654c = jArr;
            this.f2655d = i3;
            this.f2656e = z;
        }
    }

    /* compiled from: VorbisUtil.java */
    /* loaded from: classes.dex */
    public static final class b {
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public final String[] f2657b;

        /* renamed from: c  reason: collision with root package name */
        public final int f2658c;

        public b(String str, String[] strArr, int i) {
            this.a = str;
            this.f2657b = strArr;
            this.f2658c = i;
        }
    }

    /* compiled from: VorbisUtil.java */
    /* loaded from: classes.dex */
    public static final class c {
        public final boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final int f2659b;

        /* renamed from: c  reason: collision with root package name */
        public final int f2660c;

        /* renamed from: d  reason: collision with root package name */
        public final int f2661d;

        public c(boolean z, int i, int i2, int i3) {
            this.a = z;
            this.f2659b = i;
            this.f2660c = i2;
            this.f2661d = i3;
        }
    }

    /* compiled from: VorbisUtil.java */
    /* loaded from: classes.dex */
    public static final class d {
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f2662b;

        /* renamed from: c  reason: collision with root package name */
        public final int f2663c;

        /* renamed from: d  reason: collision with root package name */
        public final int f2664d;

        /* renamed from: e  reason: collision with root package name */
        public final int f2665e;

        /* renamed from: f  reason: collision with root package name */
        public final int f2666f;
        public final int g;
        public final int h;
        public final boolean i;
        public final byte[] j;

        public d(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, byte[] bArr) {
            this.a = i;
            this.f2662b = i2;
            this.f2663c = i3;
            this.f2664d = i4;
            this.f2665e = i5;
            this.f2666f = i6;
            this.g = i7;
            this.h = i8;
            this.i = z;
            this.j = bArr;
        }
    }

    public static int a(int i) {
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    private static long b(long j, long j2) {
        return (long) Math.floor(Math.pow(j, 1.0d / j2));
    }

    private static a c(c0 c0Var) throws ParserException {
        if (c0Var.d(24) == 5653314) {
            int d2 = c0Var.d(16);
            int d3 = c0Var.d(24);
            long[] jArr = new long[d3];
            boolean c2 = c0Var.c();
            long j = 0;
            if (!c2) {
                boolean c3 = c0Var.c();
                for (int i = 0; i < d3; i++) {
                    if (!c3) {
                        jArr[i] = c0Var.d(5) + 1;
                    } else if (c0Var.c()) {
                        jArr[i] = c0Var.d(5) + 1;
                    } else {
                        jArr[i] = 0;
                    }
                }
            } else {
                int d4 = c0Var.d(5) + 1;
                int i2 = 0;
                while (i2 < d3) {
                    int d5 = c0Var.d(a(d3 - i2));
                    for (int i3 = 0; i3 < d5 && i2 < d3; i3++) {
                        jArr[i2] = d4;
                        i2++;
                    }
                    d4++;
                }
            }
            int d6 = c0Var.d(4);
            if (d6 <= 2) {
                if (d6 == 1 || d6 == 2) {
                    c0Var.e(32);
                    c0Var.e(32);
                    int d7 = c0Var.d(4) + 1;
                    c0Var.e(1);
                    if (d6 != 1) {
                        j = d3 * d2;
                    } else if (d2 != 0) {
                        j = b(d3, d2);
                    }
                    c0Var.e((int) (j * d7));
                }
                return new a(d2, d3, jArr, d6, c2);
            }
            StringBuilder sb = new StringBuilder(53);
            sb.append("lookup type greater than 2 not decodable: ");
            sb.append(d6);
            throw ParserException.createForMalformedContainer(sb.toString(), null);
        }
        int b2 = c0Var.b();
        StringBuilder sb2 = new StringBuilder(66);
        sb2.append("expected code book to start with [0x56, 0x43, 0x42] at ");
        sb2.append(b2);
        throw ParserException.createForMalformedContainer(sb2.toString(), null);
    }

    private static void d(c0 c0Var) throws ParserException {
        int d2 = c0Var.d(6) + 1;
        for (int i = 0; i < d2; i++) {
            int d3 = c0Var.d(16);
            if (d3 == 0) {
                c0Var.e(8);
                c0Var.e(16);
                c0Var.e(16);
                c0Var.e(6);
                c0Var.e(8);
                int d4 = c0Var.d(4) + 1;
                for (int i2 = 0; i2 < d4; i2++) {
                    c0Var.e(8);
                }
            } else if (d3 == 1) {
                int d5 = c0Var.d(5);
                int i3 = -1;
                int[] iArr = new int[d5];
                for (int i4 = 0; i4 < d5; i4++) {
                    iArr[i4] = c0Var.d(4);
                    if (iArr[i4] > i3) {
                        i3 = iArr[i4];
                    }
                }
                int i5 = i3 + 1;
                int[] iArr2 = new int[i5];
                for (int i6 = 0; i6 < i5; i6++) {
                    iArr2[i6] = c0Var.d(3) + 1;
                    int d6 = c0Var.d(2);
                    if (d6 > 0) {
                        c0Var.e(8);
                    }
                    for (int i7 = 0; i7 < (1 << d6); i7++) {
                        c0Var.e(8);
                    }
                }
                c0Var.e(2);
                int d7 = c0Var.d(4);
                int i8 = 0;
                int i9 = 0;
                for (int i10 = 0; i10 < d5; i10++) {
                    i8 += iArr2[iArr[i10]];
                    while (i9 < i8) {
                        c0Var.e(d7);
                        i9++;
                    }
                }
            } else {
                StringBuilder sb = new StringBuilder(52);
                sb.append("floor type greater than 1 not decodable: ");
                sb.append(d3);
                throw ParserException.createForMalformedContainer(sb.toString(), null);
            }
        }
    }

    private static void e(int i, c0 c0Var) throws ParserException {
        int d2 = c0Var.d(6) + 1;
        for (int i2 = 0; i2 < d2; i2++) {
            int d3 = c0Var.d(16);
            if (d3 != 0) {
                StringBuilder sb = new StringBuilder(52);
                sb.append("mapping type other than 0 not supported: ");
                sb.append(d3);
                u.c("VorbisUtil", sb.toString());
            } else {
                int d4 = c0Var.c() ? c0Var.d(4) + 1 : 1;
                if (c0Var.c()) {
                    int d5 = c0Var.d(8) + 1;
                    for (int i3 = 0; i3 < d5; i3++) {
                        int i4 = i - 1;
                        c0Var.e(a(i4));
                        c0Var.e(a(i4));
                    }
                }
                if (c0Var.d(2) == 0) {
                    if (d4 > 1) {
                        for (int i5 = 0; i5 < i; i5++) {
                            c0Var.e(4);
                        }
                    }
                    for (int i6 = 0; i6 < d4; i6++) {
                        c0Var.e(8);
                        c0Var.e(8);
                        c0Var.e(8);
                    }
                } else {
                    throw ParserException.createForMalformedContainer("to reserved bits must be zero after mapping coupling steps", null);
                }
            }
        }
    }

    private static c[] f(c0 c0Var) {
        int d2 = c0Var.d(6) + 1;
        c[] cVarArr = new c[d2];
        for (int i = 0; i < d2; i++) {
            cVarArr[i] = new c(c0Var.c(), c0Var.d(16), c0Var.d(16), c0Var.d(8));
        }
        return cVarArr;
    }

    private static void g(c0 c0Var) throws ParserException {
        int d2 = c0Var.d(6) + 1;
        for (int i = 0; i < d2; i++) {
            if (c0Var.d(16) <= 2) {
                c0Var.e(24);
                c0Var.e(24);
                c0Var.e(24);
                int d3 = c0Var.d(6) + 1;
                c0Var.e(8);
                int[] iArr = new int[d3];
                for (int i2 = 0; i2 < d3; i2++) {
                    iArr[i2] = ((c0Var.c() ? c0Var.d(5) : 0) * 8) + c0Var.d(3);
                }
                for (int i3 = 0; i3 < d3; i3++) {
                    for (int i4 = 0; i4 < 8; i4++) {
                        if ((iArr[i3] & (1 << i4)) != 0) {
                            c0Var.e(8);
                        }
                    }
                }
            } else {
                throw ParserException.createForMalformedContainer("residueType greater than 2 is not decodable", null);
            }
        }
    }

    public static b h(com.google.android.exoplayer2.util.d0 d0Var) throws ParserException {
        return i(d0Var, true, true);
    }

    public static b i(com.google.android.exoplayer2.util.d0 d0Var, boolean z, boolean z2) throws ParserException {
        if (z) {
            l(3, d0Var, false);
        }
        String A = d0Var.A((int) d0Var.t());
        int length = 11 + A.length();
        long t = d0Var.t();
        String[] strArr = new String[(int) t];
        int i = length + 4;
        for (int i2 = 0; i2 < t; i2++) {
            strArr[i2] = d0Var.A((int) d0Var.t());
            i = i + 4 + strArr[i2].length();
        }
        if (!z2 || (d0Var.D() & 1) != 0) {
            return new b(A, strArr, i + 1);
        }
        throw ParserException.createForMalformedContainer("framing bit expected to be set", null);
    }

    public static d j(com.google.android.exoplayer2.util.d0 d0Var) throws ParserException {
        boolean z = true;
        l(1, d0Var, false);
        int u = d0Var.u();
        int D = d0Var.D();
        int u2 = d0Var.u();
        int q = d0Var.q();
        if (q <= 0) {
            q = -1;
        }
        int q2 = d0Var.q();
        if (q2 <= 0) {
            q2 = -1;
        }
        int q3 = d0Var.q();
        if (q3 <= 0) {
            q3 = -1;
        }
        int D2 = d0Var.D();
        int pow = (int) Math.pow(2.0d, D2 & 15);
        int pow2 = (int) Math.pow(2.0d, (D2 & 240) >> 4);
        if ((d0Var.D() & 1) <= 0) {
            z = false;
        }
        return new d(u, D, u2, q, q2, q3, pow, pow2, z, Arrays.copyOf(d0Var.d(), d0Var.f()));
    }

    public static c[] k(com.google.android.exoplayer2.util.d0 d0Var, int i) throws ParserException {
        l(5, d0Var, false);
        int D = d0Var.D() + 1;
        c0 c0Var = new c0(d0Var.d());
        c0Var.e(d0Var.e() * 8);
        for (int i2 = 0; i2 < D; i2++) {
            c(c0Var);
        }
        int d2 = c0Var.d(6) + 1;
        for (int i3 = 0; i3 < d2; i3++) {
            if (c0Var.d(16) != 0) {
                throw ParserException.createForMalformedContainer("placeholder of time domain transforms not zeroed out", null);
            }
        }
        d(c0Var);
        g(c0Var);
        e(i, c0Var);
        c[] f2 = f(c0Var);
        if (c0Var.c()) {
            return f2;
        }
        throw ParserException.createForMalformedContainer("framing bit after modes not set as expected", null);
    }

    public static boolean l(int i, com.google.android.exoplayer2.util.d0 d0Var, boolean z) throws ParserException {
        if (d0Var.a() < 7) {
            if (z) {
                return false;
            }
            int a2 = d0Var.a();
            StringBuilder sb = new StringBuilder(29);
            sb.append("too short header: ");
            sb.append(a2);
            throw ParserException.createForMalformedContainer(sb.toString(), null);
        } else if (d0Var.D() != i) {
            if (z) {
                return false;
            }
            String valueOf = String.valueOf(Integer.toHexString(i));
            throw ParserException.createForMalformedContainer(valueOf.length() != 0 ? "expected header type ".concat(valueOf) : new String("expected header type "), null);
        } else if (d0Var.D() == 118 && d0Var.D() == 111 && d0Var.D() == 114 && d0Var.D() == 98 && d0Var.D() == 105 && d0Var.D() == 115) {
            return true;
        } else {
            if (z) {
                return false;
            }
            throw ParserException.createForMalformedContainer("expected characters 'vorbis'", null);
        }
    }
}
