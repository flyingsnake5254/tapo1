package org.bouncycastle.crypto.u;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.c;
import org.bouncycastle.crypto.e;
import org.bouncycastle.crypto.l;
import org.bouncycastle.crypto.m;
import org.bouncycastle.crypto.w.b0;
import org.bouncycastle.util.a;

/* loaded from: classes4.dex */
public class f extends l implements m {

    /* renamed from: b  reason: collision with root package name */
    private final c f17327b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17328c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f17329d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f17330e;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f17331f;
    private int g = 0;

    public f(c cVar) {
        super(cVar);
        this.f17327b = cVar;
        int blockSize = cVar.getBlockSize();
        this.f17328c = blockSize;
        this.f17329d = new byte[blockSize];
        this.f17330e = new byte[blockSize];
        this.f17331f = new byte[blockSize];
    }

    private void f() {
        if (this.f17329d.length < this.f17328c) {
            int i = 0;
            while (true) {
                byte[] bArr = this.f17329d;
                if (i == bArr.length) {
                    return;
                }
                if (this.f17330e[i] == bArr[i]) {
                    i++;
                } else {
                    throw new IllegalStateException("Counter in CTR/SIC mode out of range.");
                }
            }
        }
    }

    private void g(int i) {
        byte b2;
        int length = this.f17330e.length - i;
        do {
            length--;
            if (length >= 0) {
                byte[] bArr = this.f17330e;
                b2 = (byte) (bArr[length] + 1);
                bArr[length] = b2;
            } else {
                return;
            }
        } while (b2 == 0);
    }

    @Override // org.bouncycastle.crypto.c
    public void a(boolean z, e eVar) throws IllegalArgumentException {
        if (eVar instanceof b0) {
            b0 b0Var = (b0) eVar;
            byte[] g = a.g(b0Var.a());
            this.f17329d = g;
            int i = this.f17328c;
            if (i >= g.length) {
                int i2 = 8;
                if (8 > i / 2) {
                    i2 = i / 2;
                }
                if (i - g.length <= i2) {
                    if (b0Var.b() != null) {
                        this.f17327b.a(true, b0Var.b());
                    }
                    reset();
                    return;
                }
                throw new IllegalArgumentException("CTR/SIC mode requires IV of at least: " + (this.f17328c - i2) + " bytes.");
            }
            throw new IllegalArgumentException("CTR/SIC mode requires IV no greater than: " + this.f17328c + " bytes.");
        }
        throw new IllegalArgumentException("CTR/SIC mode requires ParametersWithIV");
    }

    @Override // org.bouncycastle.crypto.c
    public String b() {
        return this.f17327b.b() + "/SIC";
    }

    @Override // org.bouncycastle.crypto.c
    public int d(byte[] bArr, int i, byte[] bArr2, int i2) throws DataLengthException, IllegalStateException {
        c(bArr, i, this.f17328c, bArr2, i2);
        return this.f17328c;
    }

    @Override // org.bouncycastle.crypto.l
    protected byte e(byte b2) throws DataLengthException, IllegalStateException {
        int i = this.g;
        if (i == 0) {
            this.f17327b.d(this.f17330e, 0, this.f17331f, 0);
            byte[] bArr = this.f17331f;
            int i2 = this.g;
            this.g = i2 + 1;
            return (byte) (b2 ^ bArr[i2]);
        }
        byte[] bArr2 = this.f17331f;
        int i3 = i + 1;
        this.g = i3;
        byte b3 = (byte) (b2 ^ bArr2[i]);
        if (i3 == this.f17330e.length) {
            this.g = 0;
            g(0);
            f();
        }
        return b3;
    }

    @Override // org.bouncycastle.crypto.c
    public int getBlockSize() {
        return this.f17327b.getBlockSize();
    }

    @Override // org.bouncycastle.crypto.c
    public void reset() {
        a.u(this.f17330e, (byte) 0);
        byte[] bArr = this.f17329d;
        System.arraycopy(bArr, 0, this.f17330e, 0, bArr.length);
        this.f17327b.reset();
        this.g = 0;
    }
}
