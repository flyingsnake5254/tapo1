package org.bouncycastle.crypto.u;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.c;
import org.bouncycastle.crypto.u.g.b;
import org.bouncycastle.crypto.u.g.e;
import org.bouncycastle.crypto.w.a0;
import org.bouncycastle.crypto.w.b0;
import org.bouncycastle.util.a;
import org.bouncycastle.util.f;

/* loaded from: classes4.dex */
public class d implements a {
    private c a;

    /* renamed from: b  reason: collision with root package name */
    private org.bouncycastle.crypto.u.g.c f17317b;

    /* renamed from: c  reason: collision with root package name */
    private b f17318c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f17319d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f17320e;

    /* renamed from: f  reason: collision with root package name */
    private int f17321f;
    private byte[] g;
    private byte[] h;
    private byte[] i;
    private byte[] j;
    private byte[] k;
    private byte[] l;
    private byte[] m;
    private byte[] n;
    private byte[] o;
    private byte[] p;
    private byte[] q;
    private int r;
    private int s;
    private long t;
    private byte[] u;
    private int v;
    private long w;
    private long x;

    public d(c cVar) {
        this(cVar, null);
    }

    public d(c cVar, org.bouncycastle.crypto.u.g.c cVar2) {
        if (cVar.getBlockSize() == 16) {
            cVar2 = cVar2 == null ? new e() : cVar2;
            this.a = cVar;
            this.f17317b = cVar2;
            return;
        }
        throw new IllegalArgumentException("cipher required with a block size of 16.");
    }

    private void d() {
        if (this.f17320e) {
            return;
        }
        if (this.f17319d) {
            throw new IllegalStateException("GCM cipher cannot be reused for encryption");
        }
        throw new IllegalStateException("GCM cipher needs to be initialised");
    }

    private void e(byte[] bArr, byte[] bArr2, int i) {
        for (int i2 = 0; i2 < i; i2 += 16) {
            h(bArr, bArr2, i2, Math.min(i - i2, 16));
        }
    }

    private void f(byte[] bArr, byte[] bArr2) {
        org.bouncycastle.crypto.u.g.d.l(bArr, bArr2);
        this.f17317b.a(bArr);
    }

    private void g(byte[] bArr, byte[] bArr2, int i) {
        org.bouncycastle.crypto.u.g.d.m(bArr, bArr2, i);
        this.f17317b.a(bArr);
    }

    private void h(byte[] bArr, byte[] bArr2, int i, int i2) {
        org.bouncycastle.crypto.u.g.d.n(bArr, bArr2, i, i2);
        this.f17317b.a(bArr);
    }

    private void i(byte[] bArr) {
        int i = this.r;
        if (i != 0) {
            this.r = i - 1;
            byte[] bArr2 = this.q;
            int i2 = (bArr2[15] & 255) + 1;
            bArr2[15] = (byte) i2;
            int i3 = (i2 >>> 8) + (bArr2[14] & 255);
            bArr2[14] = (byte) i3;
            int i4 = (i3 >>> 8) + (bArr2[13] & 255);
            bArr2[13] = (byte) i4;
            bArr2[12] = (byte) ((i4 >>> 8) + (bArr2[12] & 255));
            this.a.d(bArr2, 0, bArr, 0);
            return;
        }
        throw new IllegalStateException("Attempt to process too many blocks");
    }

    private void j() {
        if (this.w > 0) {
            System.arraycopy(this.o, 0, this.p, 0, 16);
            this.x = this.w;
        }
        int i = this.v;
        if (i > 0) {
            h(this.p, this.u, 0, i);
            this.x += this.v;
        }
        if (this.x > 0) {
            System.arraycopy(this.p, 0, this.n, 0, 16);
        }
    }

    private void l(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (bArr2.length - i2 >= 16) {
            if (this.t == 0) {
                j();
            }
            byte[] bArr3 = new byte[16];
            i(bArr3);
            if (this.f17319d) {
                org.bouncycastle.crypto.u.g.d.m(bArr3, bArr, i);
                f(this.n, bArr3);
                System.arraycopy(bArr3, 0, bArr2, i2, 16);
            } else {
                g(this.n, bArr, i);
                org.bouncycastle.crypto.u.g.d.k(bArr3, 0, bArr, i, bArr2, i2);
            }
            this.t += 16;
            return;
        }
        throw new OutputLengthException("Output buffer too short");
    }

    private void m(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        byte[] bArr3 = new byte[16];
        i(bArr3);
        if (this.f17319d) {
            org.bouncycastle.crypto.u.g.d.j(bArr, i, bArr3, 0, i2);
            h(this.n, bArr, i, i2);
        } else {
            h(this.n, bArr, i, i2);
            org.bouncycastle.crypto.u.g.d.j(bArr, i, bArr3, 0, i2);
        }
        System.arraycopy(bArr, i, bArr2, i3, i2);
        this.t += i2;
    }

    private void n(boolean z) {
        this.a.reset();
        this.n = new byte[16];
        this.o = new byte[16];
        this.p = new byte[16];
        this.u = new byte[16];
        this.v = 0;
        this.w = 0L;
        this.x = 0L;
        this.q = a.g(this.k);
        this.r = -2;
        this.s = 0;
        this.t = 0L;
        byte[] bArr = this.l;
        if (bArr != null) {
            a.u(bArr, (byte) 0);
        }
        if (z) {
            this.m = null;
        }
        if (this.f17319d) {
            this.f17320e = false;
            return;
        }
        byte[] bArr2 = this.i;
        if (bArr2 != null) {
            k(bArr2, 0, bArr2.length);
        }
    }

    @Override // org.bouncycastle.crypto.u.a
    public void a(boolean z, org.bouncycastle.crypto.e eVar) throws IllegalArgumentException {
        a0 a0Var;
        byte[] bArr;
        byte[] bArr2;
        this.f17319d = z;
        this.m = null;
        this.f17320e = true;
        if (eVar instanceof org.bouncycastle.crypto.w.a) {
            org.bouncycastle.crypto.w.a aVar = (org.bouncycastle.crypto.w.a) eVar;
            bArr = aVar.d();
            this.i = aVar.a();
            int c2 = aVar.c();
            if (c2 < 32 || c2 > 128 || c2 % 8 != 0) {
                throw new IllegalArgumentException("Invalid value for MAC size: " + c2);
            }
            this.f17321f = c2 / 8;
            a0Var = aVar.b();
        } else if (eVar instanceof b0) {
            b0 b0Var = (b0) eVar;
            bArr = b0Var.a();
            this.i = null;
            this.f17321f = 16;
            a0Var = (a0) b0Var.b();
        } else {
            throw new IllegalArgumentException("invalid parameters passed to GCM");
        }
        this.l = new byte[z ? 16 : this.f17321f + 16];
        if (bArr == null || bArr.length < 1) {
            throw new IllegalArgumentException("IV must be at least 1 byte");
        }
        if (z && (bArr2 = this.h) != null && a.c(bArr2, bArr)) {
            if (a0Var != null) {
                byte[] bArr3 = this.g;
                if (bArr3 != null && a.c(bArr3, a0Var.a())) {
                    throw new IllegalArgumentException("cannot reuse nonce for GCM encryption");
                }
            } else {
                throw new IllegalArgumentException("cannot reuse nonce for GCM encryption");
            }
        }
        this.h = bArr;
        if (a0Var != null) {
            this.g = a0Var.a();
        }
        if (a0Var != null) {
            this.a.a(true, a0Var);
            byte[] bArr4 = new byte[16];
            this.j = bArr4;
            this.a.d(bArr4, 0, bArr4, 0);
            this.f17317b.init(this.j);
            this.f17318c = null;
        } else if (this.j == null) {
            throw new IllegalArgumentException("Key must be specified in initial init");
        }
        byte[] bArr5 = new byte[16];
        this.k = bArr5;
        byte[] bArr6 = this.h;
        if (bArr6.length == 12) {
            System.arraycopy(bArr6, 0, bArr5, 0, bArr6.length);
            this.k[15] = 1;
        } else {
            e(bArr5, bArr6, bArr6.length);
            byte[] bArr7 = new byte[16];
            f.l(this.h.length * 8, bArr7, 8);
            f(this.k, bArr7);
        }
        this.n = new byte[16];
        this.o = new byte[16];
        this.p = new byte[16];
        this.u = new byte[16];
        this.v = 0;
        this.w = 0L;
        this.x = 0L;
        this.q = a.g(this.k);
        this.r = -2;
        this.s = 0;
        this.t = 0L;
        byte[] bArr8 = this.i;
        if (bArr8 != null) {
            k(bArr8, 0, bArr8.length);
        }
    }

    @Override // org.bouncycastle.crypto.u.a
    public int b(int i) {
        int i2 = i + this.s;
        if (this.f17319d) {
            return i2 + this.f17321f;
        }
        int i3 = this.f17321f;
        if (i2 < i3) {
            return 0;
        }
        return i2 - i3;
    }

    @Override // org.bouncycastle.crypto.u.a
    public int c(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException {
        int i4;
        d();
        if (bArr.length - i >= i2) {
            if (this.f17319d) {
                if (this.s != 0) {
                    while (i2 > 0) {
                        i2--;
                        byte[] bArr3 = this.l;
                        int i5 = this.s;
                        int i6 = i + 1;
                        bArr3[i5] = bArr[i];
                        int i7 = i5 + 1;
                        this.s = i7;
                        if (i7 == 16) {
                            l(bArr3, 0, bArr2, i3);
                            this.s = 0;
                            i = i6;
                            i4 = 16;
                            break;
                        }
                        i = i6;
                    }
                }
                i4 = 0;
                while (i2 >= 16) {
                    l(bArr, i, bArr2, i3 + i4);
                    i += 16;
                    i2 -= 16;
                    i4 += 16;
                }
                if (i2 > 0) {
                    System.arraycopy(bArr, i, this.l, 0, i2);
                    this.s = i2;
                }
            } else {
                i4 = 0;
                for (int i8 = 0; i8 < i2; i8++) {
                    byte[] bArr4 = this.l;
                    int i9 = this.s;
                    bArr4[i9] = bArr[i + i8];
                    int i10 = i9 + 1;
                    this.s = i10;
                    if (i10 == bArr4.length) {
                        l(bArr4, 0, bArr2, i3 + i4);
                        byte[] bArr5 = this.l;
                        System.arraycopy(bArr5, 16, bArr5, 0, this.f17321f);
                        this.s = this.f17321f;
                        i4 += 16;
                    }
                }
            }
            return i4;
        }
        throw new DataLengthException("Input buffer too short");
    }

    @Override // org.bouncycastle.crypto.u.a
    public int doFinal(byte[] bArr, int i) throws IllegalStateException, InvalidCipherTextException {
        d();
        if (this.t == 0) {
            j();
        }
        int i2 = this.s;
        if (!this.f17319d) {
            int i3 = this.f17321f;
            if (i2 >= i3) {
                i2 -= i3;
                if (bArr.length - i < i2) {
                    throw new OutputLengthException("Output buffer too short");
                }
            } else {
                throw new InvalidCipherTextException("data too short");
            }
        } else if (bArr.length - i < this.f17321f + i2) {
            throw new OutputLengthException("Output buffer too short");
        }
        if (i2 > 0) {
            m(this.l, 0, i2, bArr, i);
        }
        long j = this.w;
        int i4 = this.v;
        long j2 = j + i4;
        this.w = j2;
        if (j2 > this.x) {
            if (i4 > 0) {
                h(this.o, this.u, 0, i4);
            }
            if (this.x > 0) {
                org.bouncycastle.crypto.u.g.d.l(this.o, this.p);
            }
            long j3 = ((this.t * 8) + 127) >>> 7;
            byte[] bArr2 = new byte[16];
            if (this.f17318c == null) {
                org.bouncycastle.crypto.u.g.a aVar = new org.bouncycastle.crypto.u.g.a();
                this.f17318c = aVar;
                aVar.init(this.j);
            }
            this.f17318c.a(j3, bArr2);
            org.bouncycastle.crypto.u.g.d.e(this.o, bArr2);
            org.bouncycastle.crypto.u.g.d.l(this.n, this.o);
        }
        byte[] bArr3 = new byte[16];
        f.l(this.w * 8, bArr3, 0);
        f.l(this.t * 8, bArr3, 8);
        f(this.n, bArr3);
        byte[] bArr4 = new byte[16];
        this.a.d(this.k, 0, bArr4, 0);
        org.bouncycastle.crypto.u.g.d.l(bArr4, this.n);
        int i5 = this.f17321f;
        byte[] bArr5 = new byte[i5];
        this.m = bArr5;
        System.arraycopy(bArr4, 0, bArr5, 0, i5);
        if (this.f17319d) {
            System.arraycopy(this.m, 0, bArr, i + this.s, this.f17321f);
            i2 += this.f17321f;
        } else {
            int i6 = this.f17321f;
            byte[] bArr6 = new byte[i6];
            System.arraycopy(this.l, i2, bArr6, 0, i6);
            if (!a.o(this.m, bArr6)) {
                throw new InvalidCipherTextException("mac check in GCM failed");
            }
        }
        n(false);
        return i2;
    }

    public void k(byte[] bArr, int i, int i2) {
        d();
        for (int i3 = 0; i3 < i2; i3++) {
            byte[] bArr2 = this.u;
            int i4 = this.v;
            bArr2[i4] = bArr[i + i3];
            int i5 = i4 + 1;
            this.v = i5;
            if (i5 == 16) {
                f(this.o, bArr2);
                this.v = 0;
                this.w += 16;
            }
        }
    }
}
