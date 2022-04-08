package org.bouncycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

/* loaded from: classes4.dex */
public class h {
    public static final h a = new h(new org.bouncycastle.asn1.x509.h[0]);

    /* renamed from: b  reason: collision with root package name */
    protected org.bouncycastle.asn1.x509.h[] f17237b;

    public h(org.bouncycastle.asn1.x509.h[] hVarArr) {
        if (hVarArr != null) {
            this.f17237b = hVarArr;
            return;
        }
        throw new IllegalArgumentException("'certificateList' cannot be null");
    }

    public static h d(InputStream inputStream) throws IOException {
        int g0 = m1.g0(inputStream);
        if (g0 == 0) {
            return a;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(m1.Z(g0, inputStream));
        Vector vector = new Vector();
        while (byteArrayInputStream.available() > 0) {
            vector.addElement(org.bouncycastle.asn1.x509.h.g(m1.W(m1.b0(byteArrayInputStream))));
        }
        org.bouncycastle.asn1.x509.h[] hVarArr = new org.bouncycastle.asn1.x509.h[vector.size()];
        for (int i = 0; i < vector.size(); i++) {
            hVarArr[i] = (org.bouncycastle.asn1.x509.h) vector.elementAt(i);
        }
        return new h(hVarArr);
    }

    public void a(OutputStream outputStream) throws IOException {
        Vector vector = new Vector(this.f17237b.length);
        int i = 0;
        int i2 = 0;
        while (true) {
            org.bouncycastle.asn1.x509.h[] hVarArr = this.f17237b;
            if (i >= hVarArr.length) {
                break;
            }
            byte[] e2 = hVarArr[i].e("DER");
            vector.addElement(e2);
            i2 += e2.length + 3;
            i++;
        }
        m1.j(i2);
        m1.C0(i2, outputStream);
        for (int i3 = 0; i3 < vector.size(); i3++) {
            m1.u0((byte[]) vector.elementAt(i3), outputStream);
        }
    }

    public org.bouncycastle.asn1.x509.h b(int i) {
        return this.f17237b[i];
    }

    public boolean c() {
        return this.f17237b.length == 0;
    }
}
