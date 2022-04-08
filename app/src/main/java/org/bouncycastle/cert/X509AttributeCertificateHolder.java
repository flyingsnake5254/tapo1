package org.bouncycastle.cert;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x509.a;
import org.bouncycastle.asn1.x509.d;
import org.bouncycastle.asn1.x509.e;
import org.bouncycastle.asn1.x509.f;
import org.bouncycastle.asn1.x509.l;
import org.bouncycastle.asn1.x509.m;
import org.bouncycastle.asn1.z0;
import org.bouncycastle.operator.b;
import org.bouncycastle.operator.c;

/* loaded from: classes4.dex */
public class X509AttributeCertificateHolder implements Serializable {
    private static d[] EMPTY_ARRAY = new d[0];
    private static final long serialVersionUID = 20170722001L;
    private transient e attrCert;
    private transient m extensions;

    public X509AttributeCertificateHolder(e eVar) {
        init(eVar);
    }

    public X509AttributeCertificateHolder(byte[] bArr) throws IOException {
        this(parseBytes(bArr));
    }

    private void init(e eVar) {
        this.attrCert = eVar;
        this.extensions = eVar.f().h();
    }

    private static e parseBytes(byte[] bArr) throws IOException {
        try {
            return e.g(c.i(bArr));
        } catch (ClassCastException e2) {
            throw new CertIOException("malformed data: " + e2.getMessage(), e2);
        } catch (IllegalArgumentException e3) {
            throw new CertIOException("malformed data: " + e3.getMessage(), e3);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init(e.g(objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof X509AttributeCertificateHolder)) {
            return false;
        }
        return this.attrCert.equals(((X509AttributeCertificateHolder) obj).attrCert);
    }

    public d[] getAttributes() {
        r g = this.attrCert.f().g();
        d[] dVarArr = new d[g.size()];
        for (int i = 0; i != g.size(); i++) {
            dVarArr[i] = d.g(g.p(i));
        }
        return dVarArr;
    }

    public d[] getAttributes(org.bouncycastle.asn1.m mVar) {
        r g = this.attrCert.f().g();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i != g.size(); i++) {
            d g2 = d.g(g.p(i));
            if (g2.f().equals(mVar)) {
                arrayList.add(g2);
            }
        }
        return arrayList.size() == 0 ? EMPTY_ARRAY : (d[]) arrayList.toArray(new d[arrayList.size()]);
    }

    public Set getCriticalExtensionOIDs() {
        return c.e(this.extensions);
    }

    public byte[] getEncoded() throws IOException {
        return this.attrCert.d();
    }

    public l getExtension(org.bouncycastle.asn1.m mVar) {
        m mVar2 = this.extensions;
        if (mVar2 != null) {
            return mVar2.g(mVar);
        }
        return null;
    }

    public List getExtensionOIDs() {
        return c.f(this.extensions);
    }

    public m getExtensions() {
        return this.extensions;
    }

    public a getHolder() {
        return new a((r) this.attrCert.f().i().c());
    }

    public b getIssuer() {
        return new b(this.attrCert.f().k());
    }

    public boolean[] getIssuerUniqueID() {
        return c.a(this.attrCert.f().l());
    }

    public Set getNonCriticalExtensionOIDs() {
        return c.g(this.extensions);
    }

    public Date getNotAfter() {
        return c.j(this.attrCert.f().f().g());
    }

    public Date getNotBefore() {
        return c.j(this.attrCert.f().f().h());
    }

    public BigInteger getSerialNumber() {
        return this.attrCert.f().m().p();
    }

    public byte[] getSignature() {
        return this.attrCert.i().p();
    }

    public a getSignatureAlgorithm() {
        return this.attrCert.h();
    }

    public int getVersion() {
        return this.attrCert.f().o().p().intValue() + 1;
    }

    public boolean hasExtensions() {
        return this.extensions != null;
    }

    public int hashCode() {
        return this.attrCert.hashCode();
    }

    public boolean isSignatureValid(c cVar) throws CertException {
        f f2 = this.attrCert.f();
        if (c.h(f2.n(), this.attrCert.h())) {
            try {
                b a = cVar.a(f2.n());
                OutputStream outputStream = a.getOutputStream();
                new z0(outputStream).j(f2);
                outputStream.close();
                return a.verify(getSignature());
            } catch (Exception e2) {
                throw new CertException("unable to process signature: " + e2.getMessage(), e2);
            }
        } else {
            throw new CertException("signature invalid - algorithm identifier mismatch");
        }
    }

    public boolean isValidOn(Date date) {
        org.bouncycastle.asn1.x509.c f2 = this.attrCert.f().f();
        return !date.before(c.j(f2.h())) && !date.after(c.j(f2.g()));
    }

    public e toASN1Structure() {
        return this.attrCert;
    }
}
