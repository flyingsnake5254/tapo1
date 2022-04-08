package io.netty.handler.ssl;

import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.internal.tcnative.SSL;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLException;
import javax.net.ssl.X509KeyManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class OpenSslKeyMaterialProvider {
    private final X509KeyManager keyManager;
    private final String password;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSslKeyMaterialProvider(X509KeyManager x509KeyManager, String str) {
        this.keyManager = x509KeyManager;
        this.password = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void validateKeyMaterialSupported(X509Certificate[] x509CertificateArr, PrivateKey privateKey, String str) throws SSLException {
        validateSupported(x509CertificateArr);
        validateSupported(privateKey, str);
    }

    private static void validateSupported(PrivateKey privateKey, String str) throws SSLException {
        Throwable th;
        Exception e2;
        long bio;
        if (privateKey != null) {
            long j = 0;
            try {
                try {
                    bio = ReferenceCountedOpenSslContext.toBIO(UnpooledByteBufAllocator.DEFAULT, privateKey);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e3) {
                e2 = e3;
            }
            try {
                long parsePrivateKey = SSL.parsePrivateKey(bio, str);
                SSL.freeBIO(bio);
                if (parsePrivateKey != 0) {
                    SSL.freePrivateKey(parsePrivateKey);
                }
            } catch (Exception e4) {
                e2 = e4;
                throw new SSLException("PrivateKey type not supported " + privateKey.getFormat(), e2);
            } catch (Throwable th3) {
                th = th3;
                j = bio;
                SSL.freeBIO(j);
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public io.netty.handler.ssl.OpenSslKeyMaterial chooseKeyMaterial(io.netty.buffer.ByteBufAllocator r21, java.lang.String r22) throws java.lang.Exception {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            r2 = r22
            javax.net.ssl.X509KeyManager r3 = r1.keyManager
            java.security.cert.X509Certificate[] r9 = r3.getCertificateChain(r2)
            if (r9 == 0) goto L_0x0094
            int r3 = r9.length
            if (r3 != 0) goto L_0x0013
            goto L_0x0094
        L_0x0013:
            javax.net.ssl.X509KeyManager r3 = r1.keyManager
            java.security.PrivateKey r2 = r3.getPrivateKey(r2)
            r3 = 1
            io.netty.handler.ssl.PemEncoded r3 = io.netty.handler.ssl.PemX509Certificate.toPEM(r0, r3, r9)
            r10 = 0
            io.netty.handler.ssl.PemEncoded r4 = r3.retain()     // Catch: all -> 0x0076
            long r12 = io.netty.handler.ssl.ReferenceCountedOpenSslContext.toBIO(r0, r4)     // Catch: all -> 0x0076
            long r14 = io.netty.internal.tcnative.SSL.parseX509Chain(r12)     // Catch: all -> 0x0072
            boolean r4 = r2 instanceof io.netty.handler.ssl.OpenSslPrivateKey     // Catch: all -> 0x006d
            if (r4 == 0) goto L_0x0037
            io.netty.handler.ssl.OpenSslPrivateKey r2 = (io.netty.handler.ssl.OpenSslPrivateKey) r2     // Catch: all -> 0x006d
            io.netty.handler.ssl.OpenSslKeyMaterial r0 = r2.newKeyMaterial(r14, r9)     // Catch: all -> 0x006d
            goto L_0x0055
        L_0x0037:
            long r7 = io.netty.handler.ssl.ReferenceCountedOpenSslContext.toBIO(r0, r2)     // Catch: all -> 0x006d
            if (r2 != 0) goto L_0x0040
            r16 = r10
            goto L_0x0048
        L_0x0040:
            java.lang.String r0 = r1.password     // Catch: all -> 0x0067
            long r4 = io.netty.internal.tcnative.SSL.parsePrivateKey(r7, r0)     // Catch: all -> 0x0067
            r16 = r4
        L_0x0048:
            io.netty.handler.ssl.DefaultOpenSslKeyMaterial r0 = new io.netty.handler.ssl.DefaultOpenSslKeyMaterial     // Catch: all -> 0x0063
            r4 = r0
            r5 = r14
            r18 = r7
            r7 = r16
            r4.<init>(r5, r7, r9)     // Catch: all -> 0x005f
            r10 = r18
        L_0x0055:
            io.netty.internal.tcnative.SSL.freeBIO(r12)
            io.netty.internal.tcnative.SSL.freeBIO(r10)
            r3.release()
            return r0
        L_0x005f:
            r0 = move-exception
            r7 = r18
            goto L_0x007c
        L_0x0063:
            r0 = move-exception
            r18 = r7
            goto L_0x007c
        L_0x0067:
            r0 = move-exception
            r18 = r7
            r16 = r10
            goto L_0x007c
        L_0x006d:
            r0 = move-exception
            r7 = r10
            r16 = r7
            goto L_0x007c
        L_0x0072:
            r0 = move-exception
            r7 = r10
            r14 = r7
            goto L_0x007a
        L_0x0076:
            r0 = move-exception
            r7 = r10
            r12 = r7
            r14 = r12
        L_0x007a:
            r16 = r14
        L_0x007c:
            io.netty.internal.tcnative.SSL.freeBIO(r12)
            io.netty.internal.tcnative.SSL.freeBIO(r7)
            int r2 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1))
            if (r2 == 0) goto L_0x0089
            io.netty.internal.tcnative.SSL.freeX509Chain(r14)
        L_0x0089:
            int r2 = (r16 > r10 ? 1 : (r16 == r10 ? 0 : -1))
            if (r2 == 0) goto L_0x0090
            io.netty.internal.tcnative.SSL.freePrivateKey(r16)
        L_0x0090:
            r3.release()
            throw r0
        L_0x0094:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.OpenSslKeyMaterialProvider.chooseKeyMaterial(io.netty.buffer.ByteBufAllocator, java.lang.String):io.netty.handler.ssl.OpenSslKeyMaterial");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void destroy() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public X509KeyManager keyManager() {
        return this.keyManager;
    }

    private static void validateSupported(X509Certificate[] x509CertificateArr) throws SSLException {
        Throwable th;
        Exception e2;
        long bio;
        if (x509CertificateArr != null && x509CertificateArr.length != 0) {
            PemEncoded pemEncoded = null;
            long j = 0;
            try {
                try {
                    UnpooledByteBufAllocator unpooledByteBufAllocator = UnpooledByteBufAllocator.DEFAULT;
                    pemEncoded = PemX509Certificate.toPEM(unpooledByteBufAllocator, true, x509CertificateArr);
                    bio = ReferenceCountedOpenSslContext.toBIO(unpooledByteBufAllocator, pemEncoded.retain());
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e3) {
                e2 = e3;
            }
            try {
                long parseX509Chain = SSL.parseX509Chain(bio);
                SSL.freeBIO(bio);
                if (parseX509Chain != 0) {
                    SSL.freeX509Chain(parseX509Chain);
                }
                pemEncoded.release();
            } catch (Exception e4) {
                e2 = e4;
                throw new SSLException("Certificate type not supported", e2);
            } catch (Throwable th3) {
                th = th3;
                j = bio;
                SSL.freeBIO(j);
                if (pemEncoded != null) {
                    pemEncoded.release();
                }
                throw th;
            }
        }
    }
}
