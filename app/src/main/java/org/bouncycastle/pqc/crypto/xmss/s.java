package org.bouncycastle.pqc.crypto.xmss;

import java.io.IOException;
import java.util.Objects;
import org.bouncycastle.pqc.crypto.xmss.g;
import org.bouncycastle.util.f;

/* loaded from: classes4.dex */
public final class s extends org.bouncycastle.crypto.w.b {

    /* renamed from: d  reason: collision with root package name */
    private final r f17499d;

    /* renamed from: f  reason: collision with root package name */
    private final byte[] f17500f;
    private final byte[] q;
    private final byte[] x;
    private final byte[] y;
    private final BDS z;

    /* loaded from: classes4.dex */
    public static class b {
        private final r a;

        /* renamed from: b  reason: collision with root package name */
        private int f17501b = 0;

        /* renamed from: c  reason: collision with root package name */
        private byte[] f17502c = null;

        /* renamed from: d  reason: collision with root package name */
        private byte[] f17503d = null;

        /* renamed from: e  reason: collision with root package name */
        private byte[] f17504e = null;

        /* renamed from: f  reason: collision with root package name */
        private byte[] f17505f = null;
        private BDS g = null;
        private byte[] h = null;
        private r i = null;

        public b(r rVar) {
            this.a = rVar;
        }

        public s j() {
            return new s(this);
        }

        public b k(BDS bds) {
            this.g = bds;
            return this;
        }

        public b l(int i) {
            this.f17501b = i;
            return this;
        }

        public b m(byte[] bArr) {
            this.f17504e = u.c(bArr);
            return this;
        }

        public b n(byte[] bArr) {
            this.f17505f = u.c(bArr);
            return this;
        }

        public b o(byte[] bArr) {
            this.f17503d = u.c(bArr);
            return this;
        }

        public b p(byte[] bArr) {
            this.f17502c = u.c(bArr);
            return this;
        }
    }

    private s(b bVar) {
        super(true);
        r rVar = bVar.a;
        this.f17499d = rVar;
        Objects.requireNonNull(rVar, "params == null");
        int c2 = rVar.c();
        byte[] bArr = bVar.h;
        if (bArr != null) {
            Objects.requireNonNull(bVar.i, "xmss == null");
            int d2 = rVar.d();
            int a2 = f.a(bArr, 0);
            if (u.l(d2, a2)) {
                this.f17500f = u.g(bArr, 4, c2);
                int i = 4 + c2;
                this.q = u.g(bArr, i, c2);
                int i2 = i + c2;
                this.x = u.g(bArr, i2, c2);
                int i3 = i2 + c2;
                this.y = u.g(bArr, i3, c2);
                int i4 = i3 + c2;
                try {
                    BDS bds = (BDS) u.f(u.g(bArr, i4, bArr.length - i4), BDS.class);
                    bds.setXMSS(bVar.i);
                    bds.validate();
                    if (bds.getIndex() == a2) {
                        this.z = bds;
                        return;
                    }
                    throw new IllegalStateException("serialized BDS has wrong index");
                } catch (IOException e2) {
                    throw new IllegalArgumentException(e2.getMessage(), e2);
                } catch (ClassNotFoundException e3) {
                    throw new IllegalArgumentException(e3.getMessage(), e3);
                }
            } else {
                throw new IllegalArgumentException("index out of bounds");
            }
        } else {
            byte[] bArr2 = bVar.f17502c;
            if (bArr2 == null) {
                this.f17500f = new byte[c2];
            } else if (bArr2.length == c2) {
                this.f17500f = bArr2;
            } else {
                throw new IllegalArgumentException("size of secretKeySeed needs to be equal size of digest");
            }
            byte[] bArr3 = bVar.f17503d;
            if (bArr3 == null) {
                this.q = new byte[c2];
            } else if (bArr3.length == c2) {
                this.q = bArr3;
            } else {
                throw new IllegalArgumentException("size of secretKeyPRF needs to be equal size of digest");
            }
            byte[] bArr4 = bVar.f17504e;
            if (bArr4 == null) {
                this.x = new byte[c2];
            } else if (bArr4.length == c2) {
                this.x = bArr4;
            } else {
                throw new IllegalArgumentException("size of publicSeed needs to be equal size of digest");
            }
            byte[] bArr5 = bVar.f17505f;
            if (bArr5 == null) {
                this.y = new byte[c2];
            } else if (bArr5.length == c2) {
                this.y = bArr5;
            } else {
                throw new IllegalArgumentException("size of root needs to be equal size of digest");
            }
            BDS bds2 = bVar.g;
            if (bds2 != null) {
                this.z = bds2;
            } else {
                this.z = (bVar.f17501b >= (1 << rVar.d()) + (-2) || bArr4 == null || bArr2 == null) ? new BDS(rVar, bVar.f17501b) : new BDS(rVar, bArr4, bArr2, (g) new g.b().l(), bVar.f17501b);
            }
        }
    }

    public r b() {
        return this.f17499d;
    }

    public byte[] c() {
        int c2 = this.f17499d.c();
        byte[] bArr = new byte[c2 + 4 + c2 + c2 + c2];
        f.d(this.z.getIndex(), bArr, 0);
        u.e(bArr, this.f17500f, 4);
        int i = 4 + c2;
        u.e(bArr, this.q, i);
        int i2 = i + c2;
        u.e(bArr, this.x, i2);
        u.e(bArr, this.y, i2 + c2);
        try {
            return org.bouncycastle.util.a.l(bArr, u.o(this.z));
        } catch (IOException e2) {
            throw new RuntimeException("error serializing bds state: " + e2.getMessage());
        }
    }
}
