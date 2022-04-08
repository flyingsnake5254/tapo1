package org.bouncycastle.pqc.crypto.xmss;

import java.util.Objects;

/* loaded from: classes4.dex */
public final class t extends org.bouncycastle.crypto.w.b {

    /* renamed from: d  reason: collision with root package name */
    private final r f17506d;

    /* renamed from: f  reason: collision with root package name */
    private final byte[] f17507f;
    private final byte[] q;

    /* loaded from: classes4.dex */
    public static class b {
        private final r a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f17508b = null;

        /* renamed from: c  reason: collision with root package name */
        private byte[] f17509c = null;

        /* renamed from: d  reason: collision with root package name */
        private byte[] f17510d = null;

        public b(r rVar) {
            this.a = rVar;
        }

        public t e() {
            return new t(this);
        }

        public b f(byte[] bArr) {
            this.f17509c = u.c(bArr);
            return this;
        }

        public b g(byte[] bArr) {
            this.f17508b = u.c(bArr);
            return this;
        }
    }

    private t(b bVar) {
        super(false);
        r rVar = bVar.a;
        this.f17506d = rVar;
        Objects.requireNonNull(rVar, "params == null");
        int c2 = rVar.c();
        byte[] bArr = bVar.f17510d;
        if (bArr != null) {
            if (bArr.length == c2 + c2) {
                this.f17507f = u.g(bArr, 0, c2);
                this.q = u.g(bArr, c2 + 0, c2);
                return;
            }
            throw new IllegalArgumentException("public key has wrong size");
        }
        byte[] bArr2 = bVar.f17508b;
        if (bArr2 == null) {
            this.f17507f = new byte[c2];
        } else if (bArr2.length == c2) {
            this.f17507f = bArr2;
        } else {
            throw new IllegalArgumentException("length of root must be equal to length of digest");
        }
        byte[] bArr3 = bVar.f17509c;
        if (bArr3 == null) {
            this.q = new byte[c2];
        } else if (bArr3.length == c2) {
            this.q = bArr3;
        } else {
            throw new IllegalArgumentException("length of publicSeed must be equal to length of digest");
        }
    }

    public r b() {
        return this.f17506d;
    }

    public byte[] c() {
        return u.c(this.q);
    }

    public byte[] d() {
        return u.c(this.f17507f);
    }

    public byte[] e() {
        int c2 = this.f17506d.c();
        byte[] bArr = new byte[c2 + c2];
        u.e(bArr, this.f17507f, 0);
        u.e(bArr, this.q, c2 + 0);
        return bArr;
    }
}
