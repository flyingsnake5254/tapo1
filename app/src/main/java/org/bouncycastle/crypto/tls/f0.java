package org.bouncycastle.crypto.tls;

import java.io.IOException;
import org.bouncycastle.crypto.u.a;
import org.bouncycastle.crypto.w.a0;

/* loaded from: classes4.dex */
public class f0 implements i0 {
    protected p0 a;

    /* renamed from: b  reason: collision with root package name */
    protected int f17223b;

    /* renamed from: c  reason: collision with root package name */
    protected int f17224c;

    /* renamed from: d  reason: collision with root package name */
    protected a f17225d;

    /* renamed from: e  reason: collision with root package name */
    protected a f17226e;

    /* renamed from: f  reason: collision with root package name */
    protected byte[] f17227f;
    protected byte[] g;
    protected int h;

    public f0(p0 p0Var, a aVar, a aVar2, int i, int i2) throws IOException {
        this(p0Var, aVar, aVar2, i, i2, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f0(p0 p0Var, a aVar, a aVar2, int i, int i2, int i3) throws IOException {
        int i4;
        if (m1.P(p0Var)) {
            this.h = i3;
            if (i3 == 1) {
                i4 = 4;
                this.f17224c = 8;
            } else if (i3 == 2) {
                i4 = 12;
                this.f17224c = 0;
            } else {
                throw new TlsFatalAlert((short) 80);
            }
            this.a = p0Var;
            this.f17223b = i2;
            int i5 = (i * 2) + (i4 * 2);
            byte[] d2 = m1.d(p0Var, i5);
            a0 a0Var = new a0(d2, 0, i);
            int i6 = i + 0;
            a0 a0Var2 = new a0(d2, i6, i);
            int i7 = i6 + i;
            int i8 = i7 + i4;
            byte[] s = org.bouncycastle.util.a.s(d2, i7, i8);
            int i9 = i8 + i4;
            byte[] s2 = org.bouncycastle.util.a.s(d2, i8, i9);
            if (i9 == i5) {
                if (p0Var.isServer()) {
                    this.f17225d = aVar2;
                    this.f17226e = aVar;
                    this.f17227f = s2;
                    this.g = s;
                    a0Var2 = a0Var;
                    a0Var = a0Var2;
                } else {
                    this.f17225d = aVar;
                    this.f17226e = aVar2;
                    this.f17227f = s;
                    this.g = s2;
                }
                byte[] bArr = new byte[i4 + this.f17224c];
                int i10 = i2 * 8;
                this.f17225d.a(true, new org.bouncycastle.crypto.w.a(a0Var, i10, bArr));
                this.f17226e.a(false, new org.bouncycastle.crypto.w.a(a0Var2, i10, bArr));
                return;
            }
            throw new TlsFatalAlert((short) 80);
        }
        throw new TlsFatalAlert((short) 80);
    }

    @Override // org.bouncycastle.crypto.tls.i0
    public byte[] a(long j, short s, byte[] bArr, int i, int i2) throws IOException {
        if (d(i2) >= 0) {
            byte[] bArr2 = this.g;
            int length = bArr2.length + this.f17224c;
            byte[] bArr3 = new byte[length];
            int i3 = this.h;
            if (i3 == 1) {
                System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
                int i4 = this.f17224c;
                System.arraycopy(bArr, i, bArr3, length - i4, i4);
            } else if (i3 == 2) {
                m1.E0(j, bArr3, length - 8);
                int i5 = 0;
                while (true) {
                    byte[] bArr4 = this.g;
                    if (i5 >= bArr4.length) {
                        break;
                    }
                    bArr3[i5] = (byte) (bArr4[i5] ^ bArr3[i5]);
                    i5++;
                }
            } else {
                throw new TlsFatalAlert((short) 80);
            }
            int i6 = this.f17224c;
            int i7 = i + i6;
            int i8 = i2 - i6;
            int b2 = this.f17226e.b(i8);
            byte[] bArr5 = new byte[b2];
            try {
                this.f17226e.a(false, new org.bouncycastle.crypto.w.a(null, this.f17223b * 8, bArr3, c(j, s, b2)));
                int c2 = this.f17226e.c(bArr, i7, i8, bArr5, 0) + 0;
                if (c2 + this.f17226e.doFinal(bArr5, c2) == b2) {
                    return bArr5;
                }
                throw new TlsFatalAlert((short) 80);
            } catch (Exception e2) {
                throw new TlsFatalAlert((short) 20, e2);
            }
        } else {
            throw new TlsFatalAlert((short) 50);
        }
    }

    @Override // org.bouncycastle.crypto.tls.i0
    public byte[] b(long j, short s, byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2 = this.f17227f;
        int length = bArr2.length + this.f17224c;
        byte[] bArr3 = new byte[length];
        int i3 = this.h;
        if (i3 == 1) {
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
            m1.E0(j, bArr3, this.f17227f.length);
        } else if (i3 == 2) {
            m1.E0(j, bArr3, length - 8);
            int i4 = 0;
            while (true) {
                byte[] bArr4 = this.f17227f;
                if (i4 >= bArr4.length) {
                    break;
                }
                bArr3[i4] = (byte) (bArr4[i4] ^ bArr3[i4]);
                i4++;
            }
        } else {
            throw new TlsFatalAlert((short) 80);
        }
        int b2 = this.f17225d.b(i2);
        int i5 = this.f17224c;
        int i6 = i5 + b2;
        byte[] bArr5 = new byte[i6];
        if (i5 != 0) {
            System.arraycopy(bArr3, length - i5, bArr5, 0, i5);
        }
        int i7 = this.f17224c;
        try {
            this.f17225d.a(true, new org.bouncycastle.crypto.w.a(null, this.f17223b * 8, bArr3, c(j, s, i2)));
            int c2 = i7 + this.f17225d.c(bArr, i, i2, bArr5, i7);
            if (c2 + this.f17225d.doFinal(bArr5, c2) == i6) {
                return bArr5;
            }
            throw new TlsFatalAlert((short) 80);
        } catch (Exception e2) {
            throw new TlsFatalAlert((short) 80, e2);
        }
    }

    protected byte[] c(long j, short s, int i) throws IOException {
        byte[] bArr = new byte[13];
        m1.E0(j, bArr, 0);
        m1.I0(s, bArr, 8);
        m1.O0(this.a.b(), bArr, 9);
        m1.x0(i, bArr, 11);
        return bArr;
    }

    public int d(int i) {
        return (i - this.f17223b) - this.f17224c;
    }
}
