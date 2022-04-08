package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.a;

/* loaded from: classes4.dex */
public class c extends q {

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f16699c = {-1};

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f16700d = {0};

    /* renamed from: f  reason: collision with root package name */
    public static final c f16701f = new c(false);
    public static final c q = new c(true);
    private final byte[] x;

    public c(boolean z) {
        this.x = z ? f16699c : f16700d;
    }

    c(byte[] bArr) {
        if (bArr.length != 1) {
            throw new IllegalArgumentException("byte value should have 1 byte in it");
        } else if (bArr[0] == 0) {
            this.x = f16700d;
        } else if ((bArr[0] & 255) == 255) {
            this.x = f16699c;
        } else {
            this.x = a.g(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c m(byte[] bArr) {
        if (bArr.length == 1) {
            return bArr[0] == 0 ? f16701f : (bArr[0] & 255) == 255 ? q : new c(bArr);
        }
        throw new IllegalArgumentException("BOOLEAN value should have 1 byte in it");
    }

    public static c n(Object obj) {
        if (obj == null || (obj instanceof c)) {
            return (c) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (c) q.i((byte[]) obj);
            } catch (IOException e2) {
                throw new IllegalArgumentException("failed to construct boolean from byte[]: " + e2.getMessage());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public static c o(x xVar, boolean z) {
        q o = xVar.o();
        return (z || (o instanceof c)) ? n(o) : m(((n) o).o());
    }

    public static c p(boolean z) {
        return z ? q : f16701f;
    }

    @Override // org.bouncycastle.asn1.q
    protected boolean f(q qVar) {
        return (qVar instanceof c) && this.x[0] == ((c) qVar).x[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public void g(p pVar) throws IOException {
        pVar.g(1, this.x);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public int h() {
        return 3;
    }

    @Override // org.bouncycastle.asn1.l
    public int hashCode() {
        return this.x[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public boolean j() {
        return false;
    }

    public boolean q() {
        return this.x[0] != 0;
    }

    public String toString() {
        return this.x[0] != 0 ? "TRUE" : "FALSE";
    }
}
