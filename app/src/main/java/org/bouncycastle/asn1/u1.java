package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

/* loaded from: classes4.dex */
class u1 implements Enumeration {
    private i a;

    /* renamed from: b  reason: collision with root package name */
    private Object f16924b = a();

    public u1(byte[] bArr) {
        this.a = new i(bArr, true);
    }

    private Object a() {
        try {
            return this.a.t();
        } catch (IOException e2) {
            throw new ASN1ParsingException("malformed DER construction: " + e2, e2);
        }
    }

    @Override // java.util.Enumeration
    public boolean hasMoreElements() {
        return this.f16924b != null;
    }

    @Override // java.util.Enumeration
    public Object nextElement() {
        Object obj = this.f16924b;
        this.f16924b = a();
        return obj;
    }
}
