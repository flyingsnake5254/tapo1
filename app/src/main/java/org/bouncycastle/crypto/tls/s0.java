package org.bouncycastle.crypto.tls;

import e.a.b.a.d;
import e.a.b.a.h;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Hashtable;
import org.bouncycastle.asn1.u2.e;
import org.bouncycastle.asn1.u2.j;
import org.bouncycastle.crypto.o.b;
import org.bouncycastle.crypto.s.c;
import org.bouncycastle.crypto.w.n;
import org.bouncycastle.crypto.w.o;
import org.bouncycastle.crypto.w.r;
import org.bouncycastle.crypto.w.s;
import org.bouncycastle.util.a;
import org.bouncycastle.util.d;

/* loaded from: classes4.dex */
public class s0 {
    public static final Integer a = d.b(10);

    /* renamed from: b  reason: collision with root package name */
    public static final Integer f17273b = d.b(11);

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f17274c = {"sect163k1", "sect163r1", "sect163r2", "sect193r1", "sect193r2", "sect233k1", "sect233r1", "sect239k1", "sect283k1", "sect283r1", "sect409k1", "sect409r1", "sect571k1", "sect571r1", "secp160k1", "secp160r1", "secp160r2", "secp192k1", "secp192r1", "secp224k1", "secp224r1", "secp256k1", "secp256r1", "secp384r1", "secp521r1", "brainpoolP256r1", "brainpoolP384r1", "brainpoolP512r1"};

    public static void A(short[] sArr, h hVar, OutputStream outputStream) throws IOException {
        m1.v0(y(sArr, hVar), outputStream);
    }

    public static void a(Hashtable hashtable, int[] iArr) throws IOException {
        hashtable.put(a, f(iArr));
    }

    public static void b(Hashtable hashtable, short[] sArr) throws IOException {
        hashtable.put(f17273b, g(sArr));
    }

    public static byte[] c(s sVar, r rVar) {
        b bVar = new b();
        bVar.c(rVar);
        return org.bouncycastle.util.b.a(bVar.b(), bVar.a(sVar));
    }

    private static void d(int[] iArr, int i) throws IOException {
        if (iArr != null && !a.p(iArr, i)) {
            throw new TlsFatalAlert((short) 47);
        }
    }

    public static boolean e(int[] iArr) {
        for (int i : iArr) {
            if (q(i)) {
                return true;
            }
        }
        return false;
    }

    public static byte[] f(int[] iArr) throws IOException {
        if (iArr != null && iArr.length >= 1) {
            return m1.s(iArr);
        }
        throw new TlsFatalAlert((short) 80);
    }

    public static byte[] g(short[] sArr) throws IOException {
        if (sArr == null || !a.q(sArr, (short) 0)) {
            sArr = a.b(sArr, (short) 0);
        }
        return m1.t(sArr);
    }

    public static BigInteger h(int i, byte[] bArr) throws IOException {
        if (bArr.length == (i + 7) / 8) {
            return new BigInteger(1, bArr);
        }
        throw new TlsFatalAlert((short) 50);
    }

    public static h i(short[] sArr, e.a.b.a.d dVar, byte[] bArr) throws IOException {
        if (bArr != null) {
            short s = 1;
            if (bArr.length >= 1) {
                byte b2 = bArr[0];
                if (b2 == 2 || b2 == 3) {
                    if (e.a.b.a.b.g(dVar)) {
                        s = 2;
                    } else if (!e.a.b.a.b.i(dVar)) {
                        throw new TlsFatalAlert((short) 47);
                    }
                } else if (b2 == 4) {
                    s = 0;
                } else {
                    throw new TlsFatalAlert((short) 47);
                }
                if (s == 0 || (sArr != null && a.q(sArr, s))) {
                    return dVar.k(bArr);
                }
                throw new TlsFatalAlert((short) 47);
            }
        }
        throw new TlsFatalAlert((short) 47);
    }

    public static s j(short[] sArr, n nVar, byte[] bArr) throws IOException {
        try {
            return new s(i(sArr, nVar.a(), bArr), nVar);
        } catch (RuntimeException e2) {
            throw new TlsFatalAlert((short) 47, e2);
        }
    }

    public static org.bouncycastle.crypto.b k(SecureRandom secureRandom, n nVar) {
        c cVar = new c();
        cVar.c(new o(nVar, secureRandom));
        return cVar.b();
    }

    public static r l(SecureRandom secureRandom, short[] sArr, n nVar, OutputStream outputStream) throws IOException {
        org.bouncycastle.crypto.b k = k(secureRandom, nVar);
        A(sArr, ((s) k.b()).c(), outputStream);
        return (r) k.a();
    }

    public static String m(int i) {
        if (r(i)) {
            return f17274c[i - 1];
        }
        return null;
    }

    public static n n(int i) {
        String m = m(i);
        if (m == null) {
            return null;
        }
        j h = org.bouncycastle.crypto.q.a.h(m);
        if (h == null && (h = e.b(m)) == null) {
            return null;
        }
        return new n(h.f(), h.g(), h.j(), h.h(), h.k());
    }

    public static short[] o(Hashtable hashtable) throws IOException {
        byte[] B = m1.B(hashtable, f17273b);
        if (B == null) {
            return null;
        }
        return x(B);
    }

    public static boolean p(short[] sArr, short s) {
        short s2;
        if (sArr == null) {
            return false;
        }
        for (int i = 0; i < sArr.length && (s2 = sArr[i]) != 0; i++) {
            if (s2 == s) {
                return true;
            }
        }
        return false;
    }

    public static boolean q(int i) {
        if (i == 52396) {
            return true;
        }
        switch (i) {
            case 49153:
            case 49154:
            case 49155:
            case 49156:
            case 49157:
            case 49158:
            case 49159:
            case 49160:
            case 49161:
            case 49162:
            case 49163:
            case 49164:
            case 49165:
            case 49166:
            case 49167:
            case 49168:
            case 49169:
            case 49170:
            case 49171:
            case 49172:
            case 49173:
            case 49174:
            case 49175:
            case 49176:
            case 49177:
                return true;
            default:
                switch (i) {
                    case 49187:
                    case 49188:
                    case 49189:
                    case 49190:
                    case 49191:
                    case 49192:
                    case 49193:
                    case 49194:
                    case 49195:
                    case 49196:
                    case 49197:
                    case 49198:
                    case 49199:
                    case 49200:
                    case 49201:
                    case 49202:
                    case 49203:
                    case 49204:
                    case 49205:
                    case 49206:
                    case 49207:
                    case 49208:
                    case 49209:
                    case 49210:
                    case 49211:
                        return true;
                    default:
                        switch (i) {
                            case 49266:
                            case 49267:
                            case 49268:
                            case 49269:
                            case 49270:
                            case 49271:
                            case 49272:
                            case 49273:
                                return true;
                            default:
                                switch (i) {
                                    case 49286:
                                    case 49287:
                                    case 49288:
                                    case 49289:
                                    case 49290:
                                    case 49291:
                                    case 49292:
                                    case 49293:
                                        return true;
                                    default:
                                        switch (i) {
                                            case 49306:
                                            case 49307:
                                                return true;
                                            default:
                                                switch (i) {
                                                    case 49324:
                                                    case 49325:
                                                    case 49326:
                                                    case 49327:
                                                        return true;
                                                    default:
                                                        switch (i) {
                                                            case 52392:
                                                            case 52393:
                                                                return true;
                                                            default:
                                                                switch (i) {
                                                                    case 65282:
                                                                    case 65283:
                                                                    case 65284:
                                                                    case 65285:
                                                                        return true;
                                                                    default:
                                                                        switch (i) {
                                                                            case 65300:
                                                                            case 65301:
                                                                                return true;
                                                                            default:
                                                                                return false;
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }

    public static boolean r(int i) {
        return i > 0 && i <= f17274c.length;
    }

    public static int s(int i, InputStream inputStream) throws IOException {
        int intValue;
        BigInteger u = u(inputStream);
        if (u.bitLength() < 32 && (intValue = u.intValue()) > 0 && intValue < i) {
            return intValue;
        }
        throw new TlsFatalAlert((short) 47);
    }

    public static BigInteger t(int i, InputStream inputStream) throws IOException {
        return h(i, m1.c0(inputStream));
    }

    public static BigInteger u(InputStream inputStream) throws IOException {
        return new BigInteger(1, m1.c0(inputStream));
    }

    public static n v(int[] iArr, short[] sArr, InputStream inputStream) throws IOException {
        int i;
        int i2;
        BigInteger bigInteger;
        d.e eVar;
        try {
            short j0 = m1.j0(inputStream);
            if (j0 == 1) {
                d(iArr, 65281);
                BigInteger u = u(inputStream);
                BigInteger t = t(u.bitLength(), inputStream);
                BigInteger t2 = t(u.bitLength(), inputStream);
                byte[] c0 = m1.c0(inputStream);
                BigInteger u2 = u(inputStream);
                BigInteger u3 = u(inputStream);
                d.f fVar = new d.f(u, t, t2, u2, u3);
                return new n(fVar, i(sArr, fVar, c0), u2, u3);
            } else if (j0 == 2) {
                d(iArr, 65282);
                int d0 = m1.d0(inputStream);
                short j02 = m1.j0(inputStream);
                if (r.a(j02)) {
                    int s = s(d0, inputStream);
                    if (j02 == 2) {
                        i2 = s(d0, inputStream);
                        i = s(d0, inputStream);
                    } else {
                        i2 = -1;
                        i = -1;
                    }
                    BigInteger t3 = t(d0, inputStream);
                    BigInteger t4 = t(d0, inputStream);
                    byte[] c02 = m1.c0(inputStream);
                    BigInteger u4 = u(inputStream);
                    BigInteger u5 = u(inputStream);
                    if (j02 == 2) {
                        bigInteger = u4;
                        eVar = new d.e(d0, s, i2, i, t3, t4, u4, u5);
                    } else {
                        bigInteger = u4;
                        eVar = new d.e(d0, s, t3, t4, bigInteger, u5);
                    }
                    return new n(eVar, i(sArr, eVar, c02), bigInteger, u5);
                }
                throw new TlsFatalAlert((short) 47);
            } else if (j0 == 3) {
                int d02 = m1.d0(inputStream);
                if (u.a(d02)) {
                    d(iArr, d02);
                    return n(d02);
                }
                throw new TlsFatalAlert((short) 47);
            } else {
                throw new TlsFatalAlert((short) 47);
            }
        } catch (RuntimeException e2) {
            throw new TlsFatalAlert((short) 47, e2);
        }
    }

    public static int[] w(byte[] bArr) throws IOException {
        if (bArr != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            int d0 = m1.d0(byteArrayInputStream);
            if (d0 < 2 || (d0 & 1) != 0) {
                throw new TlsFatalAlert((short) 50);
            }
            int[] f0 = m1.f0(d0 / 2, byteArrayInputStream);
            g1.c(byteArrayInputStream);
            return f0;
        }
        throw new IllegalArgumentException("'extensionData' cannot be null");
    }

    public static short[] x(byte[] bArr) throws IOException {
        if (bArr != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            short j0 = m1.j0(byteArrayInputStream);
            if (j0 >= 1) {
                short[] l0 = m1.l0(j0, byteArrayInputStream);
                g1.c(byteArrayInputStream);
                if (a.q(l0, (short) 0)) {
                    return l0;
                }
                throw new TlsFatalAlert((short) 47);
            }
            throw new TlsFatalAlert((short) 50);
        }
        throw new IllegalArgumentException("'extensionData' cannot be null");
    }

    public static byte[] y(short[] sArr, h hVar) throws IOException {
        boolean z;
        short s;
        e.a.b.a.d i = hVar.i();
        if (e.a.b.a.b.i(i)) {
            s = 1;
        } else if (e.a.b.a.b.g(i)) {
            s = 2;
        } else {
            z = false;
            return hVar.l(z);
        }
        z = p(sArr, s);
        return hVar.l(z);
    }

    public static s z(s sVar) throws IOException {
        return sVar;
    }
}
