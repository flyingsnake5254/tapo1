package org.bouncycastle.asn1;

import io.netty.handler.codec.memcache.binary.DefaultBinaryMemcacheRequest;
import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.util.a;
import org.bouncycastle.util.g;

/* loaded from: classes4.dex */
public class j extends q {

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f16772c;

    public j(long j) {
        this.f16772c = BigInteger.valueOf(j).toByteArray();
    }

    public j(BigInteger bigInteger) {
        this.f16772c = bigInteger.toByteArray();
    }

    public j(byte[] bArr) {
        this(bArr, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(byte[] bArr, boolean z) {
        if (g.c("org.bouncycastle.asn1.allow_unsafe_integer") || !q(bArr)) {
            this.f16772c = z ? a.g(bArr) : bArr;
            return;
        }
        throw new IllegalArgumentException("malformed integer");
    }

    public static j m(Object obj) {
        if (obj == null || (obj instanceof j)) {
            return (j) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (j) q.i((byte[]) obj);
            } catch (Exception e2) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e2.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public static j n(x xVar, boolean z) {
        q o = xVar.o();
        return (z || (o instanceof j)) ? m(o) : new j(n.m(o).o());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean q(byte[] bArr) {
        if (bArr.length > 1) {
            if (bArr[0] == 0 && (bArr[1] & DefaultBinaryMemcacheRequest.REQUEST_MAGIC_BYTE) == 0) {
                return true;
            }
            if (bArr[0] == -1 && (bArr[1] & DefaultBinaryMemcacheRequest.REQUEST_MAGIC_BYTE) != 0) {
                return true;
            }
        }
        return false;
    }

    @Override // org.bouncycastle.asn1.q
    boolean f(q qVar) {
        if (!(qVar instanceof j)) {
            return false;
        }
        return a.c(this.f16772c, ((j) qVar).f16772c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public void g(p pVar) throws IOException {
        pVar.g(2, this.f16772c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public int h() {
        return y1.a(this.f16772c.length) + 1 + this.f16772c.length;
    }

    @Override // org.bouncycastle.asn1.l
    public int hashCode() {
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f16772c;
            if (i == bArr.length) {
                return i2;
            }
            i2 ^= (bArr[i] & 255) << (i % 4);
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public boolean j() {
        return false;
    }

    public BigInteger o() {
        return new BigInteger(1, this.f16772c);
    }

    public BigInteger p() {
        return new BigInteger(this.f16772c);
    }

    public String toString() {
        return p().toString();
    }
}
