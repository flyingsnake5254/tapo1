package org.bouncycastle.jcajce.provider.asymmetric.x509;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.security.NoSuchProviderException;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.d1;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.i;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.n2.d;
import org.bouncycastle.asn1.n2.g;
import org.bouncycastle.asn1.n2.l;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.jcajce.a.a;
import org.bouncycastle.jcajce.a.c;
import org.bouncycastle.util.io.pem.b;

/* loaded from: classes4.dex */
public class PKIXCertPath extends CertPath {
    static final List certPathEncodings;
    private List certificates;
    private final c helper;

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add("PkiPath");
        arrayList.add("PEM");
        arrayList.add("PKCS7");
        certPathEncodings = Collections.unmodifiableList(arrayList);
    }

    PKIXCertPath(InputStream inputStream, String str) throws CertificateException {
        super("X.509");
        a aVar = new a();
        this.helper = aVar;
        try {
            if (!str.equalsIgnoreCase("PkiPath")) {
                if (!str.equalsIgnoreCase("PKCS7") && !str.equalsIgnoreCase("PEM")) {
                    throw new CertificateException("unsupported encoding: " + str);
                }
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                this.certificates = new ArrayList();
                CertificateFactory a = aVar.a("X.509");
                while (true) {
                    Certificate generateCertificate = a.generateCertificate(bufferedInputStream);
                    if (generateCertificate == null) {
                        break;
                    }
                    this.certificates.add(generateCertificate);
                }
            } else {
                q t = new i(inputStream).t();
                if (t instanceof r) {
                    Enumeration q = ((r) t).q();
                    this.certificates = new ArrayList();
                    CertificateFactory a2 = aVar.a("X.509");
                    while (q.hasMoreElements()) {
                        this.certificates.add(0, a2.generateCertificate(new ByteArrayInputStream(((e) q.nextElement()).c().e("DER"))));
                    }
                } else {
                    throw new CertificateException("input stream does not contain a ASN1 SEQUENCE while reading PkiPath encoded data to load CertPath");
                }
            }
            this.certificates = sortCerts(this.certificates);
        } catch (IOException e2) {
            throw new CertificateException("IOException throw while decoding CertPath:\n" + e2.toString());
        } catch (NoSuchProviderException e3) {
            throw new CertificateException("BouncyCastle provider not found while trying to get a CertificateFactory:\n" + e3.toString());
        }
    }

    PKIXCertPath(List list) {
        super("X.509");
        this.helper = new a();
        this.certificates = sortCerts(new ArrayList(list));
    }

    private List sortCerts(List list) {
        boolean z;
        boolean z2;
        if (list.size() < 2) {
            return list;
        }
        X500Principal issuerX500Principal = ((X509Certificate) list.get(0)).getIssuerX500Principal();
        int i = 1;
        while (true) {
            if (i == list.size()) {
                z = true;
                break;
            }
            if (!issuerX500Principal.equals(((X509Certificate) list.get(i)).getSubjectX500Principal())) {
                z = false;
                break;
            }
            issuerX500Principal = ((X509Certificate) list.get(i)).getIssuerX500Principal();
            i++;
        }
        if (z) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list);
        for (int i2 = 0; i2 < list.size(); i2++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i2);
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            int i3 = 0;
            while (true) {
                if (i3 == list.size()) {
                    z2 = false;
                    break;
                } else if (((X509Certificate) list.get(i3)).getIssuerX500Principal().equals(subjectX500Principal)) {
                    z2 = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (!z2) {
                arrayList.add(x509Certificate);
                list.remove(i2);
            }
        }
        if (arrayList.size() > 1) {
            return arrayList2;
        }
        for (int i4 = 0; i4 != arrayList.size(); i4++) {
            X500Principal issuerX500Principal2 = ((X509Certificate) arrayList.get(i4)).getIssuerX500Principal();
            int i5 = 0;
            while (true) {
                if (i5 < list.size()) {
                    X509Certificate x509Certificate2 = (X509Certificate) list.get(i5);
                    if (issuerX500Principal2.equals(x509Certificate2.getSubjectX500Principal())) {
                        arrayList.add(x509Certificate2);
                        list.remove(i5);
                        break;
                    }
                    i5++;
                }
            }
        }
        return list.size() > 0 ? arrayList2 : arrayList;
    }

    private q toASN1Object(X509Certificate x509Certificate) throws CertificateEncodingException {
        try {
            return new i(x509Certificate.getEncoded()).t();
        } catch (Exception e2) {
            throw new CertificateEncodingException("Exception while encoding certificate: " + e2.toString());
        }
    }

    private byte[] toDEREncoded(e eVar) throws CertificateEncodingException {
        try {
            return eVar.c().e("DER");
        } catch (IOException e2) {
            throw new CertificateEncodingException("Exception thrown: " + e2);
        }
    }

    @Override // java.security.cert.CertPath
    public List getCertificates() {
        return Collections.unmodifiableList(new ArrayList(this.certificates));
    }

    @Override // java.security.cert.CertPath
    public byte[] getEncoded() throws CertificateEncodingException {
        Iterator encodings = getEncodings();
        if (!encodings.hasNext()) {
            return null;
        }
        Object next = encodings.next();
        if (next instanceof String) {
            return getEncoded((String) next);
        }
        return null;
    }

    @Override // java.security.cert.CertPath
    public byte[] getEncoded(String str) throws CertificateEncodingException {
        if (str.equalsIgnoreCase("PkiPath")) {
            f fVar = new f();
            List list = this.certificates;
            ListIterator listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                fVar.a(toASN1Object((X509Certificate) listIterator.previous()));
            }
            return toDEREncoded(new b1(fVar));
        }
        int i = 0;
        if (str.equalsIgnoreCase("PKCS7")) {
            d dVar = new d(g.r0, null);
            f fVar2 = new f();
            while (i != this.certificates.size()) {
                fVar2.a(toASN1Object((X509Certificate) this.certificates.get(i)));
                i++;
            }
            return toDEREncoded(new d(g.s0, new l(new j(1L), new d1(), dVar, new d1(fVar2), null, new d1())));
        } else if (str.equalsIgnoreCase("PEM")) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            org.bouncycastle.util.io.pem.f fVar3 = new org.bouncycastle.util.io.pem.f(new OutputStreamWriter(byteArrayOutputStream));
            while (i != this.certificates.size()) {
                try {
                    fVar3.c(new b("CERTIFICATE", ((X509Certificate) this.certificates.get(i)).getEncoded()));
                    i++;
                } catch (Exception unused) {
                    throw new CertificateEncodingException("can't encode certificate for PEM encoded path");
                }
            }
            fVar3.close();
            return byteArrayOutputStream.toByteArray();
        } else {
            throw new CertificateEncodingException("unsupported encoding: " + str);
        }
    }

    @Override // java.security.cert.CertPath
    public Iterator getEncodings() {
        return certPathEncodings.iterator();
    }
}
