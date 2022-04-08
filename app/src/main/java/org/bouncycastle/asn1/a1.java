package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.a;
import org.bouncycastle.util.i;

/* loaded from: classes4.dex */
public class a1 extends q implements w {

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f16683c;

    public a1(String str) {
        this(str, false);
    }

    public a1(String str, boolean z) {
        if (!z || m(str)) {
            this.f16683c = i.e(str);
            return;
        }
        throw new IllegalArgumentException("string contains illegal characters");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a1(byte[] bArr) {
        this.f16683c = bArr;
    }

    public static boolean m(String str) {
        for (int length = str.length() - 1; length >= 0; length--) {
            char charAt = str.charAt(length);
            if (charAt > 127) {
                return false;
            }
            if (('a' > charAt || charAt > 'z') && (('A' > charAt || charAt > 'Z') && !(('0' <= charAt && charAt <= '9') || charAt == ' ' || charAt == ':' || charAt == '=' || charAt == '?'))) {
                switch (charAt) {
                    case '\'':
                    case '(':
                    case ')':
                        continue;
                    default:
                        switch (charAt) {
                            case '+':
                            case ',':
                            case '-':
                            case '.':
                            case '/':
                                continue;
                            default:
                                return false;
                        }
                }
            }
        }
        return true;
    }

    @Override // org.bouncycastle.asn1.q
    boolean f(q qVar) {
        if (!(qVar instanceof a1)) {
            return false;
        }
        return a.c(this.f16683c, ((a1) qVar).f16683c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public void g(p pVar) throws IOException {
        pVar.g(19, this.f16683c);
    }

    @Override // org.bouncycastle.asn1.w
    public String getString() {
        return i.b(this.f16683c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public int h() {
        return y1.a(this.f16683c.length) + 1 + this.f16683c.length;
    }

    @Override // org.bouncycastle.asn1.l
    public int hashCode() {
        return a.w(this.f16683c);
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
