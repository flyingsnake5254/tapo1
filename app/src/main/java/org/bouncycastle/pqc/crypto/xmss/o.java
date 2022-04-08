package org.bouncycastle.pqc.crypto.xmss;

import java.util.Objects;

/* loaded from: classes4.dex */
public final class o extends org.bouncycastle.crypto.w.b {

    /* renamed from: d  reason: collision with root package name */
    private final m f17491d;

    /* renamed from: f  reason: collision with root package name */
    private final byte[] f17492f;
    private final byte[] q;

    /* loaded from: classes4.dex */
    public static class b {
        private final m a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f17493b = null;

        /* renamed from: c  reason: collision with root package name */
        private byte[] f17494c = null;

        /* renamed from: d  reason: collision with root package name */
        private byte[] f17495d = null;

        public b(m mVar) {
            this.a = mVar;
        }

        public o e() {
            return new o(this);
        }

        public b f(byte[] bArr) {
            this.f17494c = u.c(bArr);
            return this;
        }

        public b g(byte[] bArr) {
            this.f17493b = u.c(bArr);
            return this;
        }
    }

    private o(b bVar) {
        super(false);
        m mVar = bVar.a;
        this.f17491d = mVar;
        Objects.requireNonNull(mVar, "params == null");
        int b2 = mVar.b();
        byte[] bArr = bVar.f17495d;
        if (bArr != null) {
            if (bArr.length == b2 + b2) {
                this.f17492f = u.g(bArr, 0, b2);
                this.q = u.g(bArr, b2 + 0, b2);
                return;
            }
            throw new IllegalArgumentException("public key has wrong size");
        }
        byte[] bArr2 = bVar.f17493b;
        if (bArr2 == null) {
            this.f17492f = new byte[b2];
        } else if (bArr2.length == b2) {
            this.f17492f = bArr2;
        } else {
            throw new IllegalArgumentException("length of root must be equal to length of digest");
        }
        byte[] bArr3 = bVar.f17494c;
        if (bArr3 == null) {
            this.q = new byte[b2];
        } else if (bArr3.length == b2) {
            this.q = bArr3;
        } else {
            throw new IllegalArgumentException("length of publicSeed must be equal to length of digest");
        }
    }

    public m b() {
        return this.f17491d;
    }

    public byte[] c() {
        return u.c(this.q);
    }

    public byte[] d() {
        return u.c(this.f17492f);
    }

    public byte[] e() {
        int b2 = this.f17491d.b();
        byte[] bArr = new byte[b2 + b2];
        u.e(bArr, this.f17492f, 0);
        u.e(bArr, this.q, b2 + 0);
        return bArr;
    }
}
