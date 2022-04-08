package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Objects;
import org.bouncycastle.util.a;
import org.bouncycastle.util.i;

/* loaded from: classes4.dex */
public class u0 extends q implements w {

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f16923c;

    public u0(String str) {
        this(str, false);
    }

    public u0(String str, boolean z) {
        Objects.requireNonNull(str, "string cannot be null");
        if (!z || o(str)) {
            this.f16923c = i.e(str);
            return;
        }
        throw new IllegalArgumentException("string contains illegal characters");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u0(byte[] bArr) {
        this.f16923c = bArr;
    }

    public static u0 m(Object obj) {
        if (obj == null || (obj instanceof u0)) {
            return (u0) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (u0) q.i((byte[]) obj);
            } catch (Exception e2) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e2.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public static u0 n(x xVar, boolean z) {
        q o = xVar.o();
        return (z || (o instanceof u0)) ? m(o) : new u0(((n) o).o());
    }

    public static boolean o(String str) {
        for (int length = str.length() - 1; length >= 0; length--) {
            if (str.charAt(length) > 127) {
                return false;
            }
        }
        return true;
    }

    @Override // org.bouncycastle.asn1.q
    boolean f(q qVar) {
        if (!(qVar instanceof u0)) {
            return false;
        }
        return a.c(this.f16923c, ((u0) qVar).f16923c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public void g(p pVar) throws IOException {
        pVar.g(22, this.f16923c);
    }

    @Override // org.bouncycastle.asn1.w
    public String getString() {
        return i.b(this.f16923c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public int h() {
        return y1.a(this.f16923c.length) + 1 + this.f16923c.length;
    }

    @Override // org.bouncycastle.asn1.l
    public int hashCode() {
        return a.w(this.f16923c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public boolean j() {
        return false;
    }

    public String toString() {
        return getString();
    }
}
