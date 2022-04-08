package org.bouncycastle.pqc.crypto.xmss;

import java.util.Objects;
import org.bouncycastle.pqc.crypto.xmss.g;

/* loaded from: classes4.dex */
final class h {
    private final j a;

    /* renamed from: b  reason: collision with root package name */
    private final e f17465b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f17466c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f17467d;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(j jVar) {
        Objects.requireNonNull(jVar, "params == null");
        this.a = jVar;
        int b2 = jVar.b();
        this.f17465b = new e(jVar.a(), b2);
        this.f17466c = new byte[b2];
        this.f17467d = new byte[b2];
    }

    private byte[] a(byte[] bArr, int i, int i2, g gVar) {
        int b2 = this.a.b();
        Objects.requireNonNull(bArr, "startHash == null");
        if (bArr.length == b2) {
            Objects.requireNonNull(gVar, "otsHashAddress == null");
            Objects.requireNonNull(gVar.d(), "otsHashAddress byte array == null");
            int i3 = i + i2;
            if (i3 > this.a.d() - 1) {
                throw new IllegalArgumentException("max chain length must not be greater than w");
            } else if (i2 == 0) {
                return bArr;
            } else {
                byte[] a = a(bArr, i, i2 - 1, gVar);
                g gVar2 = (g) new g.b().g(gVar.b()).h(gVar.c()).p(gVar.g()).n(gVar.e()).o(i3 - 1).f(0).l();
                byte[] c2 = this.f17465b.c(this.f17467d, gVar2.d());
                byte[] c3 = this.f17465b.c(this.f17467d, ((g) new g.b().g(gVar2.b()).h(gVar2.c()).p(gVar2.g()).n(gVar2.e()).o(gVar2.f()).f(1).l()).d());
                byte[] bArr2 = new byte[b2];
                for (int i4 = 0; i4 < b2; i4++) {
                    bArr2[i4] = (byte) (a[i4] ^ c3[i4]);
                }
                return this.f17465b.a(c2, bArr2);
            }
        } else {
            throw new IllegalArgumentException("startHash needs to be " + b2 + "bytes");
        }
    }

    private byte[] b(int i) {
        if (i >= 0 && i < this.a.c()) {
            return this.f17465b.c(this.f17466c, u.p(i, 32));
        }
        throw new IllegalArgumentException("index out of bounds");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e c() {
        return this.f17465b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j d() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public k e(g gVar) {
        Objects.requireNonNull(gVar, "otsHashAddress == null");
        byte[][] bArr = new byte[this.a.c()];
        for (int i = 0; i < this.a.c(); i++) {
            gVar = (g) new g.b().g(gVar.b()).h(gVar.c()).p(gVar.g()).n(i).o(gVar.f()).f(gVar.a()).l();
            bArr[i] = a(b(i), 0, this.a.d() - 1, gVar);
        }
        return new k(this.a, bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] f() {
        return u.c(this.f17467d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] g(byte[] bArr, g gVar) {
        return this.f17465b.c(bArr, ((g) new g.b().g(gVar.b()).h(gVar.c()).p(gVar.g()).l()).d());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(byte[] bArr, byte[] bArr2) {
        Objects.requireNonNull(bArr, "secretKeySeed == null");
        if (bArr.length == this.a.b()) {
            Objects.requireNonNull(bArr2, "publicSeed == null");
            if (bArr2.length == this.a.b()) {
                this.f17466c = bArr;
                this.f17467d = bArr2;
                return;
            }
            throw new IllegalArgumentException("size of publicSeed needs to be equal to size of digest");
        }
        throw new IllegalArgumentException("size of secretKeySeed needs to be equal to size of digest");
    }
}
