package org.bouncycastle.crypto.u;

import io.netty.handler.codec.memcache.binary.DefaultBinaryMemcacheRequest;
import java.util.Vector;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.c;
import org.bouncycastle.crypto.w.a;
import org.bouncycastle.crypto.w.a0;
import org.bouncycastle.crypto.w.b0;

/* loaded from: classes4.dex */
public class e implements a {
    private c a;

    /* renamed from: b  reason: collision with root package name */
    private c f17322b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f17323c;

    /* renamed from: d  reason: collision with root package name */
    private int f17324d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f17325e;

    /* renamed from: f  reason: collision with root package name */
    private Vector f17326f;
    private byte[] g;
    private byte[] h;
    private byte[] l;
    private byte[] m;
    private int n;
    private int o;
    private long p;
    private long q;
    private byte[] r;
    private byte[] s;
    private byte[] u;
    private byte[] v;
    private byte[] i = null;
    private byte[] j = new byte[24];
    private byte[] k = new byte[16];
    private byte[] t = new byte[16];

    public e(c cVar, c cVar2) {
        if (cVar == null) {
            throw new IllegalArgumentException("'hashCipher' cannot be null");
        } else if (cVar.getBlockSize() != 16) {
            throw new IllegalArgumentException("'hashCipher' must have a block size of 16");
        } else if (cVar2 == null) {
            throw new IllegalArgumentException("'mainCipher' cannot be null");
        } else if (cVar2.getBlockSize() != 16) {
            throw new IllegalArgumentException("'mainCipher' must have a block size of 16");
        } else if (cVar.b().equals(cVar2.b())) {
            this.a = cVar;
            this.f17322b = cVar2;
        } else {
            throw new IllegalArgumentException("'hashCipher' and 'mainCipher' must be the same algorithm");
        }
    }

    protected static byte[] d(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        bArr2[15] = (byte) ((135 >>> ((1 - n(bArr, bArr2)) << 3)) ^ bArr2[15]);
        return bArr2;
    }

    protected static void e(byte[] bArr, int i) {
        bArr[i] = DefaultBinaryMemcacheRequest.REQUEST_MAGIC_BYTE;
        while (true) {
            i++;
            if (i < 16) {
                bArr[i] = 0;
            } else {
                return;
            }
        }
    }

    protected static int f(long j) {
        if (j == 0) {
            return 64;
        }
        int i = 0;
        while ((1 & j) == 0) {
            i++;
            j >>>= 1;
        }
        return i;
    }

    protected static int n(byte[] bArr, byte[] bArr2) {
        int i = 16;
        int i2 = 0;
        while (true) {
            i--;
            if (i < 0) {
                return i2;
            }
            int i3 = bArr[i] & 255;
            bArr2[i] = (byte) (i2 | (i3 << 1));
            i2 = (i3 >>> 7) & 1;
        }
    }

    protected static void p(byte[] bArr, byte[] bArr2) {
        for (int i = 15; i >= 0; i--) {
            bArr[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
    }

    @Override // org.bouncycastle.crypto.u.a
    public void a(boolean z, org.bouncycastle.crypto.e eVar) throws IllegalArgumentException {
        a0 a0Var;
        byte[] bArr;
        boolean z2 = this.f17323c;
        this.f17323c = z;
        this.v = null;
        if (eVar instanceof a) {
            a aVar = (a) eVar;
            bArr = aVar.d();
            this.f17325e = aVar.a();
            int c2 = aVar.c();
            if (c2 < 64 || c2 > 128 || c2 % 8 != 0) {
                throw new IllegalArgumentException("Invalid value for MAC size: " + c2);
            }
            this.f17324d = c2 / 8;
            a0Var = aVar.b();
        } else if (eVar instanceof b0) {
            b0 b0Var = (b0) eVar;
            bArr = b0Var.a();
            this.f17325e = null;
            this.f17324d = 16;
            a0Var = (a0) b0Var.b();
        } else {
            throw new IllegalArgumentException("invalid parameters passed to OCB");
        }
        this.l = new byte[16];
        this.m = new byte[z ? 16 : this.f17324d + 16];
        if (bArr == null) {
            bArr = new byte[0];
        }
        if (bArr.length <= 15) {
            if (a0Var != null) {
                this.a.a(true, a0Var);
                this.f17322b.a(z, a0Var);
                this.i = null;
            } else if (z2 != z) {
                throw new IllegalArgumentException("cannot change encrypting state without providing key.");
            }
            byte[] bArr2 = new byte[16];
            this.g = bArr2;
            this.a.d(bArr2, 0, bArr2, 0);
            this.h = d(this.g);
            Vector vector = new Vector();
            this.f17326f = vector;
            vector.addElement(d(this.h));
            int l = l(bArr);
            int i = l % 8;
            int i2 = l / 8;
            if (i == 0) {
                System.arraycopy(this.j, i2, this.k, 0, 16);
            } else {
                for (int i3 = 0; i3 < 16; i3++) {
                    byte[] bArr3 = this.j;
                    i2++;
                    this.k[i3] = (byte) (((bArr3[i2] & 255) >>> (8 - i)) | ((bArr3[i2] & 255) << i));
                }
            }
            this.n = 0;
            this.o = 0;
            this.p = 0L;
            this.q = 0L;
            this.r = new byte[16];
            this.s = new byte[16];
            System.arraycopy(this.k, 0, this.t, 0, 16);
            this.u = new byte[16];
            byte[] bArr4 = this.f17325e;
            if (bArr4 != null) {
                i(bArr4, 0, bArr4.length);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("IV must be no more than 15 bytes");
    }

    @Override // org.bouncycastle.crypto.u.a
    public int b(int i) {
        int i2 = i + this.o;
        if (this.f17323c) {
            return i2 + this.f17324d;
        }
        int i3 = this.f17324d;
        if (i2 < i3) {
            return 0;
        }
        return i2 - i3;
    }

    @Override // org.bouncycastle.crypto.u.a
    public int c(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException {
        if (bArr.length >= i + i2) {
            int i4 = 0;
            for (int i5 = 0; i5 < i2; i5++) {
                byte[] bArr3 = this.m;
                int i6 = this.o;
                bArr3[i6] = bArr[i + i5];
                int i7 = i6 + 1;
                this.o = i7;
                if (i7 == bArr3.length) {
                    k(bArr2, i3 + i4);
                    i4 += 16;
                }
            }
            return i4;
        }
        throw new DataLengthException("Input buffer too short");
    }

    @Override // org.bouncycastle.crypto.u.a
    public int doFinal(byte[] bArr, int i) throws IllegalStateException, InvalidCipherTextException {
        byte[] bArr2;
        if (!this.f17323c) {
            int i2 = this.o;
            int i3 = this.f17324d;
            if (i2 >= i3) {
                int i4 = i2 - i3;
                this.o = i4;
                bArr2 = new byte[i3];
                System.arraycopy(this.m, i4, bArr2, 0, i3);
            } else {
                throw new InvalidCipherTextException("data too short");
            }
        } else {
            bArr2 = null;
        }
        int i5 = this.n;
        if (i5 > 0) {
            e(this.l, i5);
            o(this.g);
        }
        int i6 = this.o;
        if (i6 > 0) {
            if (this.f17323c) {
                e(this.m, i6);
                p(this.u, this.m);
            }
            p(this.t, this.g);
            byte[] bArr3 = new byte[16];
            this.a.d(this.t, 0, bArr3, 0);
            p(this.m, bArr3);
            int length = bArr.length;
            int i7 = this.o;
            if (length >= i + i7) {
                System.arraycopy(this.m, 0, bArr, i, i7);
                if (!this.f17323c) {
                    e(this.m, this.o);
                    p(this.u, this.m);
                }
            } else {
                throw new OutputLengthException("Output buffer too short");
            }
        }
        p(this.u, this.t);
        p(this.u, this.h);
        c cVar = this.a;
        byte[] bArr4 = this.u;
        cVar.d(bArr4, 0, bArr4, 0);
        p(this.u, this.s);
        int i8 = this.f17324d;
        byte[] bArr5 = new byte[i8];
        this.v = bArr5;
        System.arraycopy(this.u, 0, bArr5, 0, i8);
        int i9 = this.o;
        if (this.f17323c) {
            int length2 = bArr.length;
            int i10 = i + i9;
            int i11 = this.f17324d;
            if (length2 >= i10 + i11) {
                System.arraycopy(this.v, 0, bArr, i10, i11);
                i9 += this.f17324d;
            } else {
                throw new OutputLengthException("Output buffer too short");
            }
        } else if (!org.bouncycastle.util.a.o(this.v, bArr2)) {
            throw new InvalidCipherTextException("mac check in OCB failed");
        }
        m(false);
        return i9;
    }

    protected void g(byte[] bArr) {
        if (bArr != null) {
            org.bouncycastle.util.a.u(bArr, (byte) 0);
        }
    }

    protected byte[] h(int i) {
        while (i >= this.f17326f.size()) {
            Vector vector = this.f17326f;
            vector.addElement(d((byte[]) vector.lastElement()));
        }
        return (byte[]) this.f17326f.elementAt(i);
    }

    public void i(byte[] bArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            byte[] bArr2 = this.l;
            int i4 = this.n;
            bArr2[i4] = bArr[i + i3];
            int i5 = i4 + 1;
            this.n = i5;
            if (i5 == bArr2.length) {
                j();
            }
        }
    }

    protected void j() {
        long j = this.p + 1;
        this.p = j;
        o(h(f(j)));
        this.n = 0;
    }

    protected void k(byte[] bArr, int i) {
        if (bArr.length >= i + 16) {
            if (this.f17323c) {
                p(this.u, this.m);
                this.o = 0;
            }
            byte[] bArr2 = this.t;
            long j = this.q + 1;
            this.q = j;
            p(bArr2, h(f(j)));
            p(this.m, this.t);
            c cVar = this.f17322b;
            byte[] bArr3 = this.m;
            cVar.d(bArr3, 0, bArr3, 0);
            p(this.m, this.t);
            System.arraycopy(this.m, 0, bArr, i, 16);
            if (!this.f17323c) {
                p(this.u, this.m);
                byte[] bArr4 = this.m;
                System.arraycopy(bArr4, 16, bArr4, 0, this.f17324d);
                this.o = this.f17324d;
                return;
            }
            return;
        }
        throw new OutputLengthException("Output buffer too short");
    }

    protected int l(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        System.arraycopy(bArr, 0, bArr2, 16 - bArr.length, bArr.length);
        bArr2[0] = (byte) (this.f17324d << 4);
        int length = 15 - bArr.length;
        bArr2[length] = (byte) (bArr2[length] | 1);
        int i2 = bArr2[15] & 63;
        bArr2[15] = (byte) (bArr2[15] & 192);
        byte[] bArr3 = this.i;
        if (bArr3 == null || !org.bouncycastle.util.a.c(bArr2, bArr3)) {
            byte[] bArr4 = new byte[16];
            this.i = bArr2;
            this.a.d(bArr2, 0, bArr4, 0);
            System.arraycopy(bArr4, 0, this.j, 0, 16);
            while (i < 8) {
                byte[] bArr5 = this.j;
                int i3 = i + 16;
                byte b2 = bArr4[i];
                i++;
                bArr5[i3] = (byte) (b2 ^ bArr4[i]);
            }
        }
        return i2;
    }

    protected void m(boolean z) {
        this.a.reset();
        this.f17322b.reset();
        g(this.l);
        g(this.m);
        this.n = 0;
        this.o = 0;
        this.p = 0L;
        this.q = 0L;
        g(this.r);
        g(this.s);
        System.arraycopy(this.k, 0, this.t, 0, 16);
        g(this.u);
        if (z) {
            this.v = null;
        }
        byte[] bArr = this.f17325e;
        if (bArr != null) {
            i(bArr, 0, bArr.length);
        }
    }

    protected void o(byte[] bArr) {
        p(this.r, bArr);
        p(this.l, this.r);
        c cVar = this.a;
        byte[] bArr2 = this.l;
        cVar.d(bArr2, 0, bArr2, 0);
        p(this.s, this.l);
    }
}
