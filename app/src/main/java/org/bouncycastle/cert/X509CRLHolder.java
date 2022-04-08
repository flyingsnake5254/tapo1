package org.bouncycastle.cert;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.t2.c;
import org.bouncycastle.asn1.x509.i;
import org.bouncycastle.asn1.x509.l;
import org.bouncycastle.asn1.x509.m;
import org.bouncycastle.asn1.x509.o;
import org.bouncycastle.asn1.x509.p;
import org.bouncycastle.asn1.x509.s;
import org.bouncycastle.asn1.x509.x;
import org.bouncycastle.asn1.z0;
import org.bouncycastle.operator.b;

/* loaded from: classes4.dex */
public class X509CRLHolder implements Serializable {
    private static final long serialVersionUID = 20170722001L;
    private transient m extensions;
    private transient boolean isIndirect;
    private transient p issuerName;
    private transient i x509CRL;

    public X509CRLHolder(InputStream inputStream) throws IOException {
        this(parseStream(inputStream));
    }

    public X509CRLHolder(i iVar) {
        init(iVar);
    }

    public X509CRLHolder(byte[] bArr) throws IOException {
        this(parseStream(new ByteArrayInputStream(bArr)));
    }

    private void init(i iVar) {
        this.x509CRL = iVar;
        m f2 = iVar.l().f();
        this.extensions = f2;
        this.isIndirect = isIndirectCRL(f2);
        this.issuerName = new p(new o(iVar.g()));
    }

    private static boolean isIndirectCRL(m mVar) {
        l g;
        return (mVar == null || (g = mVar.g(l.I3)) == null || !s.h(g.j()).i()) ? false : true;
    }

    private static i parseStream(InputStream inputStream) throws IOException {
        try {
            q t = new org.bouncycastle.asn1.i(inputStream, true).t();
            if (t != null) {
                return i.f(t);
            }
            throw new IOException("no content found");
        } catch (ClassCastException e2) {
            throw new CertIOException("malformed data: " + e2.getMessage(), e2);
        } catch (IllegalArgumentException e3) {
            throw new CertIOException("malformed data: " + e3.getMessage(), e3);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init(i.f(objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof X509CRLHolder)) {
            return false;
        }
        return this.x509CRL.equals(((X509CRLHolder) obj).x509CRL);
    }

    public Set getCriticalExtensionOIDs() {
        return c.e(this.extensions);
    }

    public byte[] getEncoded() throws IOException {
        return this.x509CRL.d();
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

    public c getIssuer() {
        return c.f(this.x509CRL.g());
    }

    public Set getNonCriticalExtensionOIDs() {
        return c.g(this.extensions);
    }

    public d getRevokedCertificate(BigInteger bigInteger) {
        l g;
        p pVar = this.issuerName;
        Enumeration h = this.x509CRL.h();
        while (h.hasMoreElements()) {
            x.b bVar = (x.b) h.nextElement();
            if (bVar.h().p().equals(bigInteger)) {
                return new d(bVar, this.isIndirect, pVar);
            }
            if (this.isIndirect && bVar.i() && (g = bVar.f().g(l.J3)) != null) {
                pVar = p.f(g.j());
            }
        }
        return null;
    }

    public Collection getRevokedCertificates() {
        ArrayList arrayList = new ArrayList(this.x509CRL.i().length);
        p pVar = this.issuerName;
        Enumeration h = this.x509CRL.h();
        while (h.hasMoreElements()) {
            d dVar = new d((x.b) h.nextElement(), this.isIndirect, pVar);
            arrayList.add(dVar);
            pVar = dVar.a();
        }
        return arrayList;
    }

    public boolean hasExtensions() {
        return this.extensions != null;
    }

    public int hashCode() {
        return this.x509CRL.hashCode();
    }

    public boolean isSignatureValid(org.bouncycastle.operator.c cVar) throws CertException {
        x l = this.x509CRL.l();
        if (c.h(l.k(), this.x509CRL.k())) {
            try {
                b a = cVar.a(l.k());
                OutputStream outputStream = a.getOutputStream();
                new z0(outputStream).j(l);
                outputStream.close();
                return a.verify(this.x509CRL.j().p());
            } catch (Exception e2) {
                throw new CertException("unable to process signature: " + e2.getMessage(), e2);
            }
        } else {
            throw new CertException("signature invalid - algorithm identifier mismatch");
        }
    }

    public i toASN1Structure() {
        return this.x509CRL;
    }
}
