package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes4.dex */
public class m extends q {

    /* renamed from: c  reason: collision with root package name */
    private static final ConcurrentMap<a, m> f16799c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    private final String f16800d;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f16801f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        private final int a;

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f16802b;

        a(byte[] bArr) {
            this.a = org.bouncycastle.util.a.w(bArr);
            this.f16802b = bArr;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return org.bouncycastle.util.a.c(this.f16802b, ((a) obj).f16802b);
            }
            return false;
        }

        public int hashCode() {
            return this.a;
        }
    }

    public m(String str) {
        if (str == null) {
            throw new IllegalArgumentException("'identifier' cannot be null");
        } else if (v(str)) {
            this.f16800d = str;
        } else {
            throw new IllegalArgumentException("string " + str + " not an OID");
        }
    }

    m(m mVar, String str) {
        if (u(str, 0)) {
            this.f16800d = mVar.q() + "." + str;
            return;
        }
        throw new IllegalArgumentException("string " + str + " not a valid OID branch");
    }

    m(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = true;
        long j = 0;
        BigInteger bigInteger = null;
        for (int i = 0; i != bArr.length; i++) {
            int i2 = bArr[i] & 255;
            if (j <= 72057594037927808L) {
                long j2 = j + (i2 & 127);
                if ((i2 & 128) == 0) {
                    if (z) {
                        if (j2 < 40) {
                            stringBuffer.append('0');
                        } else if (j2 < 80) {
                            stringBuffer.append('1');
                            j2 -= 40;
                        } else {
                            stringBuffer.append('2');
                            j2 -= 80;
                        }
                        z = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(j2);
                    j = 0;
                } else {
                    j = j2 << 7;
                }
            } else {
                BigInteger or = (bigInteger == null ? BigInteger.valueOf(j) : bigInteger).or(BigInteger.valueOf(i2 & 127));
                if ((i2 & 128) == 0) {
                    if (z) {
                        stringBuffer.append('2');
                        or = or.subtract(BigInteger.valueOf(80L));
                        z = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(or);
                    j = 0;
                    bigInteger = null;
                } else {
                    bigInteger = or.shiftLeft(7);
                }
            }
        }
        this.f16800d = stringBuffer.toString();
        this.f16801f = org.bouncycastle.util.a.g(bArr);
    }

    private void n(ByteArrayOutputStream byteArrayOutputStream) {
        x1 x1Var = new x1(this.f16800d);
        int parseInt = Integer.parseInt(x1Var.b()) * 40;
        String b2 = x1Var.b();
        if (b2.length() <= 18) {
            w(byteArrayOutputStream, parseInt + Long.parseLong(b2));
        } else {
            x(byteArrayOutputStream, new BigInteger(b2).add(BigInteger.valueOf(parseInt)));
        }
        while (x1Var.a()) {
            String b3 = x1Var.b();
            if (b3.length() <= 18) {
                w(byteArrayOutputStream, Long.parseLong(b3));
            } else {
                x(byteArrayOutputStream, new BigInteger(b3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m o(byte[] bArr) {
        m mVar = f16799c.get(new a(bArr));
        return mVar == null ? new m(bArr) : mVar;
    }

    private synchronized byte[] p() {
        if (this.f16801f == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            n(byteArrayOutputStream);
            this.f16801f = byteArrayOutputStream.toByteArray();
        }
        return this.f16801f;
    }

    public static m r(Object obj) {
        if (obj == null || (obj instanceof m)) {
            return (m) obj;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (eVar.c() instanceof m) {
                return (m) eVar.c();
            }
        }
        if (obj instanceof byte[]) {
            try {
                return (m) q.i((byte[]) obj);
            } catch (IOException e2) {
                throw new IllegalArgumentException("failed to construct object identifier from byte[]: " + e2.getMessage());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public static m s(x xVar, boolean z) {
        q o = xVar.o();
        return (z || (o instanceof m)) ? r(o) : o(n.m(o).o());
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001a, code lost:
        if (r3 != '.') goto L_0x001e;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean u(java.lang.String r5, int r6) {
        /*
            int r0 = r5.length()
            r1 = 0
        L_0x0005:
            r2 = 0
        L_0x0006:
            int r0 = r0 + (-1)
            if (r0 < r6) goto L_0x001f
            char r3 = r5.charAt(r0)
            r4 = 48
            if (r4 > r3) goto L_0x0018
            r4 = 57
            if (r3 > r4) goto L_0x0018
            r2 = 1
            goto L_0x0006
        L_0x0018:
            r4 = 46
            if (r3 != r4) goto L_0x001e
            if (r2 != 0) goto L_0x0005
        L_0x001e:
            return r1
        L_0x001f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.asn1.m.u(java.lang.String, int):boolean");
    }

    private static boolean v(String str) {
        char charAt;
        if (str.length() < 3 || str.charAt(1) != '.' || (charAt = str.charAt(0)) < '0' || charAt > '2') {
            return false;
        }
        return u(str, 2);
    }

    private void w(ByteArrayOutputStream byteArrayOutputStream, long j) {
        byte[] bArr = new byte[9];
        int i = 8;
        bArr[8] = (byte) (((int) j) & 127);
        while (j >= 128) {
            j >>= 7;
            i--;
            bArr[i] = (byte) ((((int) j) & 127) | 128);
        }
        byteArrayOutputStream.write(bArr, i, 9 - i);
    }

    private void x(ByteArrayOutputStream byteArrayOutputStream, BigInteger bigInteger) {
        int bitLength = (bigInteger.bitLength() + 6) / 7;
        if (bitLength == 0) {
            byteArrayOutputStream.write(0);
            return;
        }
        byte[] bArr = new byte[bitLength];
        int i = bitLength - 1;
        for (int i2 = i; i2 >= 0; i2--) {
            bArr[i2] = (byte) ((bigInteger.intValue() & 127) | 128);
            bigInteger = bigInteger.shiftRight(7);
        }
        bArr[i] = (byte) (bArr[i] & Byte.MAX_VALUE);
        byteArrayOutputStream.write(bArr, 0, bitLength);
    }

    @Override // org.bouncycastle.asn1.q
    boolean f(q qVar) {
        if (qVar == this) {
            return true;
        }
        if (!(qVar instanceof m)) {
            return false;
        }
        return this.f16800d.equals(((m) qVar).f16800d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public void g(p pVar) throws IOException {
        byte[] p = p();
        pVar.c(6);
        pVar.i(p.length);
        pVar.d(p);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public int h() throws IOException {
        int length = p().length;
        return y1.a(length) + 1 + length;
    }

    @Override // org.bouncycastle.asn1.l
    public int hashCode() {
        return this.f16800d.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public boolean j() {
        return false;
    }

    public m m(String str) {
        return new m(this, str);
    }

    public String q() {
        return this.f16800d;
    }

    public m t() {
        a aVar = new a(p());
        ConcurrentMap<a, m> concurrentMap = f16799c;
        m mVar = concurrentMap.get(aVar);
        if (mVar != null) {
            return mVar;
        }
        m putIfAbsent = concurrentMap.putIfAbsent(aVar, this);
        return putIfAbsent == null ? this : putIfAbsent;
    }

    public String toString() {
        return q();
    }
}
