package org.bouncycastle.crypto.u;

import java.io.ByteArrayOutputStream;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.e;
import org.bouncycastle.crypto.w.b0;

/* loaded from: classes4.dex */
public class c implements a {
    private org.bouncycastle.crypto.c a;

    /* renamed from: b  reason: collision with root package name */
    private int f17311b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f17312c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f17313d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f17314e;

    /* renamed from: f  reason: collision with root package name */
    private int f17315f;
    private e g;
    private byte[] h;
    private a i = new a();
    private a j = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends ByteArrayOutputStream {
        public a() {
        }

        public byte[] a() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    public c(org.bouncycastle.crypto.c cVar) {
        this.a = cVar;
        int blockSize = cVar.getBlockSize();
        this.f17311b = blockSize;
        this.h = new byte[blockSize];
        if (blockSize != 16) {
            throw new IllegalArgumentException("cipher required with a block size of 16.");
        }
    }

    private int d(byte[] bArr, int i, int i2, byte[] bArr2) {
        org.bouncycastle.crypto.t.a aVar = new org.bouncycastle.crypto.t.a(this.a, this.f17315f * 8);
        aVar.d(this.g);
        byte[] bArr3 = new byte[16];
        if (f()) {
            bArr3[0] = (byte) (bArr3[0] | 64);
        }
        int i3 = 2;
        bArr3[0] = (byte) (bArr3[0] | ((((aVar.a() - 2) / 2) & 7) << 3));
        byte b2 = bArr3[0];
        byte[] bArr4 = this.f17313d;
        bArr3[0] = (byte) (b2 | (((15 - bArr4.length) - 1) & 7));
        System.arraycopy(bArr4, 0, bArr3, 1, bArr4.length);
        int i4 = i2;
        int i5 = 1;
        while (i4 > 0) {
            bArr3[16 - i5] = (byte) (i4 & 255);
            i4 >>>= 8;
            i5++;
        }
        aVar.update(bArr3, 0, 16);
        if (f()) {
            int e2 = e();
            if (e2 < 65280) {
                aVar.c((byte) (e2 >> 8));
                aVar.c((byte) e2);
            } else {
                aVar.c((byte) -1);
                aVar.c((byte) -2);
                aVar.c((byte) (e2 >> 24));
                aVar.c((byte) (e2 >> 16));
                aVar.c((byte) (e2 >> 8));
                aVar.c((byte) e2);
                i3 = 6;
            }
            byte[] bArr5 = this.f17314e;
            if (bArr5 != null) {
                aVar.update(bArr5, 0, bArr5.length);
            }
            if (this.i.size() > 0) {
                aVar.update(this.i.a(), 0, this.i.size());
            }
            int i6 = (i3 + e2) % 16;
            if (i6 != 0) {
                while (i6 != 16) {
                    aVar.c((byte) 0);
                    i6++;
                }
            }
        }
        aVar.update(bArr, i, i2);
        return aVar.doFinal(bArr2, 0);
    }

    private int e() {
        int size = this.i.size();
        byte[] bArr = this.f17314e;
        return size + (bArr == null ? 0 : bArr.length);
    }

    private boolean f() {
        return e() > 0;
    }

    @Override // org.bouncycastle.crypto.u.a
    public void a(boolean z, e eVar) throws IllegalArgumentException {
        e eVar2;
        this.f17312c = z;
        if (eVar instanceof org.bouncycastle.crypto.w.a) {
            org.bouncycastle.crypto.w.a aVar = (org.bouncycastle.crypto.w.a) eVar;
            this.f17313d = aVar.d();
            this.f17314e = aVar.a();
            this.f17315f = aVar.c() / 8;
            eVar2 = aVar.b();
        } else if (eVar instanceof b0) {
            b0 b0Var = (b0) eVar;
            this.f17313d = b0Var.a();
            this.f17314e = null;
            this.f17315f = this.h.length / 2;
            eVar2 = b0Var.b();
        } else {
            throw new IllegalArgumentException("invalid parameters passed to CCM: " + eVar.getClass().getName());
        }
        if (eVar2 != null) {
            this.g = eVar2;
        }
        byte[] bArr = this.f17313d;
        if (bArr == null || bArr.length < 7 || bArr.length > 13) {
            throw new IllegalArgumentException("nonce must have length from 7 to 13 octets");
        }
        h();
    }

    @Override // org.bouncycastle.crypto.u.a
    public int b(int i) {
        int size = i + this.j.size();
        if (this.f17312c) {
            return size + this.f17315f;
        }
        int i2 = this.f17315f;
        if (size < i2) {
            return 0;
        }
        return size - i2;
    }

    @Override // org.bouncycastle.crypto.u.a
    public int c(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException, IllegalStateException {
        if (bArr.length >= i + i2) {
            this.j.write(bArr, i, i2);
            return 0;
        }
        throw new DataLengthException("Input buffer too short");
    }

    @Override // org.bouncycastle.crypto.u.a
    public int doFinal(byte[] bArr, int i) throws IllegalStateException, InvalidCipherTextException {
        int g = g(this.j.a(), 0, this.j.size(), bArr, i);
        h();
        return g;
    }

    public int g(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IllegalStateException, InvalidCipherTextException, DataLengthException {
        int i4;
        if (this.g != null) {
            byte[] bArr3 = this.f17313d;
            int length = 15 - bArr3.length;
            if (length >= 4 || i2 < (1 << (length * 8))) {
                byte[] bArr4 = new byte[this.f17311b];
                bArr4[0] = (byte) ((length - 1) & 7);
                System.arraycopy(bArr3, 0, bArr4, 1, bArr3.length);
                f fVar = new f(this.a);
                fVar.a(this.f17312c, new b0(this.g, bArr4));
                if (this.f17312c) {
                    int i5 = this.f17315f + i2;
                    if (bArr2.length >= i5 + i3) {
                        d(bArr, i, i2, this.h);
                        byte[] bArr5 = new byte[this.f17311b];
                        fVar.d(this.h, 0, bArr5, 0);
                        int i6 = i;
                        int i7 = i3;
                        while (true) {
                            int i8 = i + i2;
                            int i9 = this.f17311b;
                            if (i6 < i8 - i9) {
                                fVar.d(bArr, i6, bArr2, i7);
                                int i10 = this.f17311b;
                                i7 += i10;
                                i6 += i10;
                            } else {
                                byte[] bArr6 = new byte[i9];
                                int i11 = i8 - i6;
                                System.arraycopy(bArr, i6, bArr6, 0, i11);
                                fVar.d(bArr6, 0, bArr6, 0);
                                System.arraycopy(bArr6, 0, bArr2, i7, i11);
                                System.arraycopy(bArr5, 0, bArr2, i3 + i2, this.f17315f);
                                return i5;
                            }
                        }
                    } else {
                        throw new OutputLengthException("Output buffer too short.");
                    }
                } else {
                    int i12 = this.f17315f;
                    if (i2 >= i12) {
                        int i13 = i2 - i12;
                        if (bArr2.length >= i13 + i3) {
                            int i14 = i + i13;
                            System.arraycopy(bArr, i14, this.h, 0, i12);
                            byte[] bArr7 = this.h;
                            fVar.d(bArr7, 0, bArr7, 0);
                            int i15 = this.f17315f;
                            while (true) {
                                byte[] bArr8 = this.h;
                                if (i15 == bArr8.length) {
                                    break;
                                }
                                bArr8[i15] = 0;
                                i15++;
                            }
                            int i16 = i;
                            int i17 = i3;
                            while (true) {
                                i4 = this.f17311b;
                                if (i16 >= i14 - i4) {
                                    break;
                                }
                                fVar.d(bArr, i16, bArr2, i17);
                                int i18 = this.f17311b;
                                i17 += i18;
                                i16 += i18;
                            }
                            byte[] bArr9 = new byte[i4];
                            int i19 = i13 - (i16 - i);
                            System.arraycopy(bArr, i16, bArr9, 0, i19);
                            fVar.d(bArr9, 0, bArr9, 0);
                            System.arraycopy(bArr9, 0, bArr2, i17, i19);
                            byte[] bArr10 = new byte[this.f17311b];
                            d(bArr2, i3, i13, bArr10);
                            if (org.bouncycastle.util.a.o(this.h, bArr10)) {
                                return i13;
                            }
                            throw new InvalidCipherTextException("mac check in CCM failed");
                        }
                        throw new OutputLengthException("Output buffer too short.");
                    }
                    throw new InvalidCipherTextException("data too short");
                }
            } else {
                throw new IllegalStateException("CCM packet too large for choice of q.");
            }
        } else {
            throw new IllegalStateException("CCM cipher unitialized.");
        }
    }

    public void h() {
        this.a.reset();
        this.i.reset();
        this.j.reset();
    }
}
