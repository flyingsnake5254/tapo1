package b.d.b.d.a;

import androidx.annotation.RequiresApi;
import java.net.Socket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;

/* compiled from: CloudSSLSocketFactory.java */
/* loaded from: classes2.dex */
public class a {

    /* compiled from: CloudSSLSocketFactory.java */
    /* loaded from: classes2.dex */
    public static class b implements X509TrustManager {
        private final X509TrustManager a;

        /* renamed from: b  reason: collision with root package name */
        private final X509TrustManager f84b;

        public b(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyStoreException {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            this.a = a.b(instance.getTrustManagers());
            this.f84b = x509TrustManager;
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            try {
                this.a.checkClientTrusted(x509CertificateArr, str);
            } catch (CertificateException unused) {
                this.f84b.checkClientTrusted(x509CertificateArr, str);
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            try {
                this.a.checkServerTrusted(x509CertificateArr, str);
            } catch (CertificateException unused) {
                this.f84b.checkServerTrusted(x509CertificateArr, str);
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    /* compiled from: CloudSSLSocketFactory.java */
    /* loaded from: classes2.dex */
    public static class c {
        private SSLSocketFactory a;

        /* renamed from: b  reason: collision with root package name */
        private X509TrustManager f85b;

        public SSLSocketFactory c() {
            return this.a;
        }

        public X509TrustManager d() {
            return this.f85b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static X509TrustManager b(TrustManager[] trustManagerArr) {
        for (TrustManager trustManager : trustManagerArr) {
            if (trustManager instanceof X509TrustManager) {
                return (X509TrustManager) trustManager;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static b.d.b.d.a.a.c c(java.util.List<java.lang.String> r10) {
        /*
            b.d.b.d.a.a$c r0 = new b.d.b.d.a.a$c
            r0.<init>()
            r1 = 0
            r2 = 0
            java.lang.String r3 = "X.509"
            java.security.cert.CertificateFactory r3 = java.security.cert.CertificateFactory.getInstance(r3)     // Catch: all -> 0x009e, Exception -> 0x00a1
            java.lang.String r4 = java.security.KeyStore.getDefaultType()     // Catch: all -> 0x009e, Exception -> 0x00a1
            java.security.KeyStore r4 = java.security.KeyStore.getInstance(r4)     // Catch: all -> 0x009e, Exception -> 0x00a1
            r4.load(r2)     // Catch: all -> 0x009e, Exception -> 0x00a1
            r6 = r2
            r5 = 0
        L_0x001a:
            int r7 = r10.size()     // Catch: Exception -> 0x009c, all -> 0x00b5
            if (r5 >= r7) goto L_0x004e
            okio.Buffer r7 = new okio.Buffer     // Catch: Exception -> 0x009c, all -> 0x00b5
            r7.<init>()     // Catch: Exception -> 0x009c, all -> 0x00b5
            java.lang.Object r8 = r10.get(r5)     // Catch: Exception -> 0x009c, all -> 0x00b5
            java.lang.String r8 = (java.lang.String) r8     // Catch: Exception -> 0x009c, all -> 0x00b5
            okio.Buffer r7 = r7.writeUtf8(r8)     // Catch: Exception -> 0x009c, all -> 0x00b5
            java.io.InputStream r6 = r7.inputStream()     // Catch: Exception -> 0x009c, all -> 0x00b5
            java.security.cert.Certificate r7 = r3.generateCertificate(r6)     // Catch: Exception -> 0x009c, all -> 0x00b5
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: Exception -> 0x009c, all -> 0x00b5
            r8.<init>()     // Catch: Exception -> 0x009c, all -> 0x00b5
            java.lang.String r9 = "cloud_cert"
            r8.append(r9)     // Catch: Exception -> 0x009c, all -> 0x00b5
            r8.append(r5)     // Catch: Exception -> 0x009c, all -> 0x00b5
            java.lang.String r8 = r8.toString()     // Catch: Exception -> 0x009c, all -> 0x00b5
            r4.setCertificateEntry(r8, r7)     // Catch: Exception -> 0x009c, all -> 0x00b5
            int r5 = r5 + 1
            goto L_0x001a
        L_0x004e:
            java.lang.String r10 = javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm()     // Catch: Exception -> 0x009c, all -> 0x00b5
            javax.net.ssl.TrustManagerFactory r10 = javax.net.ssl.TrustManagerFactory.getInstance(r10)     // Catch: Exception -> 0x009c, all -> 0x00b5
            r10.init(r4)     // Catch: Exception -> 0x009c, all -> 0x00b5
            javax.net.ssl.TrustManager[] r10 = r10.getTrustManagers()     // Catch: Exception -> 0x009c, all -> 0x00b5
            java.lang.String r3 = "TLS"
            javax.net.ssl.SSLContext r3 = javax.net.ssl.SSLContext.getInstance(r3)     // Catch: Exception -> 0x009c, all -> 0x00b5
            javax.net.ssl.X509TrustManager r10 = b(r10)     // Catch: Exception -> 0x009c, all -> 0x00b5
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: Exception -> 0x009c, all -> 0x00b5
            r5 = 24
            if (r4 < r5) goto L_0x0073
            b.d.b.d.a.a$a r4 = new b.d.b.d.a.a$a     // Catch: Exception -> 0x009c, all -> 0x00b5
            r4.<init>(r10)     // Catch: Exception -> 0x009c, all -> 0x00b5
            goto L_0x0078
        L_0x0073:
            b.d.b.d.a.a$b r4 = new b.d.b.d.a.a$b     // Catch: Exception -> 0x009c, all -> 0x00b5
            r4.<init>(r10)     // Catch: Exception -> 0x009c, all -> 0x00b5
        L_0x0078:
            r10 = 1
            javax.net.ssl.TrustManager[] r10 = new javax.net.ssl.TrustManager[r10]     // Catch: Exception -> 0x009c, all -> 0x00b5
            r10[r1] = r4     // Catch: Exception -> 0x009c, all -> 0x00b5
            r3.init(r2, r10, r2)     // Catch: Exception -> 0x009c, all -> 0x00b5
            b.d.b.d.a.f r10 = new b.d.b.d.a.f     // Catch: Exception -> 0x009c, all -> 0x00b5
            javax.net.ssl.SSLSocketFactory r3 = r3.getSocketFactory()     // Catch: Exception -> 0x009c, all -> 0x00b5
            r10.<init>(r3)     // Catch: Exception -> 0x009c, all -> 0x00b5
            b.d.b.d.a.a.c.a(r0, r10)     // Catch: Exception -> 0x009c, all -> 0x00b5
            b.d.b.d.a.a.c.b(r0, r4)     // Catch: Exception -> 0x009c, all -> 0x00b5
            if (r6 == 0) goto L_0x00b4
            r6.close()     // Catch: IOException -> 0x0095
            goto L_0x00b4
        L_0x0095:
            r10 = move-exception
            java.lang.Object[] r1 = new java.lang.Object[r1]
            b.d.w.c.a.g(r10, r2, r1)
            goto L_0x00b4
        L_0x009c:
            r10 = move-exception
            goto L_0x00a3
        L_0x009e:
            r10 = move-exception
            r6 = r2
            goto L_0x00b6
        L_0x00a1:
            r10 = move-exception
            r6 = r2
        L_0x00a3:
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: all -> 0x00b5
            b.d.w.c.a.g(r10, r2, r3)     // Catch: all -> 0x00b5
            if (r6 == 0) goto L_0x00b4
            r6.close()     // Catch: IOException -> 0x00ae
            goto L_0x00b4
        L_0x00ae:
            r10 = move-exception
            java.lang.Object[] r1 = new java.lang.Object[r1]
            b.d.w.c.a.g(r10, r2, r1)
        L_0x00b4:
            return r0
        L_0x00b5:
            r10 = move-exception
        L_0x00b6:
            if (r6 == 0) goto L_0x00c2
            r6.close()     // Catch: IOException -> 0x00bc
            goto L_0x00c2
        L_0x00bc:
            r0 = move-exception
            java.lang.Object[] r1 = new java.lang.Object[r1]
            b.d.w.c.a.g(r0, r2, r1)
        L_0x00c2:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: b.d.b.d.a.a.c(java.util.List):b.d.b.d.a.a$c");
    }

    /* compiled from: CloudSSLSocketFactory.java */
    @RequiresApi(api = 24)
    /* renamed from: b.d.b.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0013a extends X509ExtendedTrustManager {
        private final X509TrustManager a;

        /* renamed from: b  reason: collision with root package name */
        private final X509TrustManager f83b;

        public C0013a(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyStoreException {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            this.a = a.b(instance.getTrustManagers());
            this.f83b = x509TrustManager;
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            try {
                this.a.checkClientTrusted(x509CertificateArr, str);
            } catch (CertificateException unused) {
                this.f83b.checkClientTrusted(x509CertificateArr, str);
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            try {
                this.a.checkServerTrusted(x509CertificateArr, str);
            } catch (CertificateException unused) {
                this.f83b.checkServerTrusted(x509CertificateArr, str);
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }

        @Override // javax.net.ssl.X509ExtendedTrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
            try {
                X509TrustManager x509TrustManager = this.a;
                if (x509TrustManager instanceof X509ExtendedTrustManager) {
                    ((X509ExtendedTrustManager) x509TrustManager).checkClientTrusted(x509CertificateArr, str, socket);
                } else {
                    x509TrustManager.checkClientTrusted(x509CertificateArr, str);
                }
            } catch (CertificateException unused) {
                X509TrustManager x509TrustManager2 = this.f83b;
                if (x509TrustManager2 instanceof X509ExtendedTrustManager) {
                    ((X509ExtendedTrustManager) x509TrustManager2).checkClientTrusted(x509CertificateArr, str, socket);
                } else {
                    x509TrustManager2.checkClientTrusted(x509CertificateArr, str);
                }
            }
        }

        @Override // javax.net.ssl.X509ExtendedTrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
            try {
                X509TrustManager x509TrustManager = this.a;
                if (x509TrustManager instanceof X509ExtendedTrustManager) {
                    ((X509ExtendedTrustManager) x509TrustManager).checkServerTrusted(x509CertificateArr, str, socket);
                } else {
                    x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                }
            } catch (CertificateException unused) {
                X509TrustManager x509TrustManager2 = this.f83b;
                if (x509TrustManager2 instanceof X509ExtendedTrustManager) {
                    ((X509ExtendedTrustManager) x509TrustManager2).checkServerTrusted(x509CertificateArr, str, socket);
                } else {
                    x509TrustManager2.checkServerTrusted(x509CertificateArr, str);
                }
            }
        }

        @Override // javax.net.ssl.X509ExtendedTrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
            try {
                X509TrustManager x509TrustManager = this.a;
                if (x509TrustManager instanceof X509ExtendedTrustManager) {
                    ((X509ExtendedTrustManager) x509TrustManager).checkClientTrusted(x509CertificateArr, str, sSLEngine);
                } else {
                    x509TrustManager.checkClientTrusted(x509CertificateArr, str);
                }
            } catch (CertificateException unused) {
                X509TrustManager x509TrustManager2 = this.f83b;
                if (x509TrustManager2 instanceof X509ExtendedTrustManager) {
                    ((X509ExtendedTrustManager) x509TrustManager2).checkClientTrusted(x509CertificateArr, str, sSLEngine);
                } else {
                    x509TrustManager2.checkClientTrusted(x509CertificateArr, str);
                }
            }
        }

        @Override // javax.net.ssl.X509ExtendedTrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
            try {
                X509TrustManager x509TrustManager = this.a;
                if (x509TrustManager instanceof X509ExtendedTrustManager) {
                    ((X509ExtendedTrustManager) x509TrustManager).checkServerTrusted(x509CertificateArr, str, sSLEngine);
                } else {
                    x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                }
            } catch (CertificateException unused) {
                X509TrustManager x509TrustManager2 = this.f83b;
                if (x509TrustManager2 instanceof X509ExtendedTrustManager) {
                    ((X509ExtendedTrustManager) x509TrustManager2).checkServerTrusted(x509CertificateArr, str, sSLEngine);
                } else {
                    x509TrustManager2.checkServerTrusted(x509CertificateArr, str);
                }
            }
        }
    }
}
