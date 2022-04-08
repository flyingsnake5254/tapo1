package org.bouncycastle.cert.jcajce;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.cert.CertificateException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import org.bouncycastle.cert.X509CertificateHolder;

/* loaded from: classes4.dex */
public class c {
    private a a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends CertificateException {

        /* renamed from: c  reason: collision with root package name */
        private Throwable f17059c;

        public a(String str, Throwable th) {
            super(str);
            this.f17059c = th;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.f17059c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b extends CertificateParsingException {

        /* renamed from: c  reason: collision with root package name */
        private Throwable f17061c;

        public b(String str, Throwable th) {
            super(str);
            this.f17061c = th;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.f17061c;
        }
    }

    public c() {
        this.a = new b();
        this.a = new b();
    }

    public X509Certificate a(X509CertificateHolder x509CertificateHolder) throws CertificateException {
        try {
            return (X509Certificate) this.a.b("X.509").generateCertificate(new ByteArrayInputStream(x509CertificateHolder.getEncoded()));
        } catch (IOException e2) {
            throw new b("exception parsing certificate: " + e2.getMessage(), e2);
        } catch (NoSuchProviderException e3) {
            throw new a("cannot find required provider:" + e3.getMessage(), e3);
        }
    }

    public c b(Provider provider) {
        this.a = new e(provider);
        return this;
    }
}
