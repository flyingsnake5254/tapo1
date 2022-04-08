package io.netty.handler.ssl;

import io.netty.handler.ssl.ReferenceCountedOpenSslContext;
import io.netty.internal.tcnative.CertificateCallback;
import io.netty.internal.tcnative.SSLContext;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

/* loaded from: classes3.dex */
public final class ReferenceCountedOpenSslClientContext extends ReferenceCountedOpenSslContext {
    private final OpenSslSessionContext sessionContext;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(ReferenceCountedOpenSslClientContext.class);
    private static final Set<String> SUPPORTED_KEY_TYPES = Collections.unmodifiableSet(new LinkedHashSet(Arrays.asList("RSA", "DH_RSA", "EC", "EC_RSA", "EC_EC")));
    private static final boolean ENABLE_SESSION_TICKET = SystemPropertyUtil.getBoolean("jdk.tls.client.enableSessionTicketExtension", false);

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    /* loaded from: classes3.dex */
    public static final class ExtendedTrustManagerVerifyCallback extends ReferenceCountedOpenSslContext.AbstractCertificateVerifier {
        private final X509ExtendedTrustManager manager;

        ExtendedTrustManagerVerifyCallback(OpenSslEngineMap openSslEngineMap, X509ExtendedTrustManager x509ExtendedTrustManager) {
            super(openSslEngineMap);
            this.manager = OpenSslTlsv13X509ExtendedTrustManager.wrap(x509ExtendedTrustManager);
        }

        @Override // io.netty.handler.ssl.ReferenceCountedOpenSslContext.AbstractCertificateVerifier
        void verify(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, X509Certificate[] x509CertificateArr, String str) throws Exception {
            this.manager.checkServerTrusted(x509CertificateArr, str, referenceCountedOpenSslEngine);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class OpenSslClientCertificateCallback implements CertificateCallback {
        private final OpenSslEngineMap engineMap;
        private final OpenSslKeyMaterialManager keyManagerHolder;

        OpenSslClientCertificateCallback(OpenSslEngineMap openSslEngineMap, OpenSslKeyMaterialManager openSslKeyMaterialManager) {
            this.engineMap = openSslEngineMap;
            this.keyManagerHolder = openSslKeyMaterialManager;
        }

        private static String clientKeyType(byte b2) {
            if (b2 == 1) {
                return "RSA";
            }
            if (b2 == 3) {
                return "DH_RSA";
            }
            switch (b2) {
                case 64:
                    return "EC";
                case 65:
                    return "EC_RSA";
                case 66:
                    return "EC_EC";
                default:
                    return null;
            }
        }

        private static Set<String> supportedClientKeyTypes(byte[] bArr) {
            if (bArr == null) {
                return ReferenceCountedOpenSslClientContext.SUPPORTED_KEY_TYPES;
            }
            HashSet hashSet = new HashSet(bArr.length);
            for (byte b2 : bArr) {
                String clientKeyType = clientKeyType(b2);
                if (clientKeyType != null) {
                    hashSet.add(clientKeyType);
                }
            }
            return hashSet;
        }

        public void handle(long j, byte[] bArr, byte[][] bArr2) throws Exception {
            X500Principal[] x500PrincipalArr;
            ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine = this.engineMap.get(j);
            if (referenceCountedOpenSslEngine != null) {
                try {
                    Set<String> supportedClientKeyTypes = supportedClientKeyTypes(bArr);
                    String[] strArr = (String[]) supportedClientKeyTypes.toArray(new String[0]);
                    if (bArr2 == null) {
                        x500PrincipalArr = null;
                    } else {
                        X500Principal[] x500PrincipalArr2 = new X500Principal[bArr2.length];
                        for (int i = 0; i < bArr2.length; i++) {
                            x500PrincipalArr2[i] = new X500Principal(bArr2[i]);
                        }
                        x500PrincipalArr = x500PrincipalArr2;
                    }
                    this.keyManagerHolder.setKeyMaterialClientSide(referenceCountedOpenSslEngine, strArr, x500PrincipalArr);
                } catch (Throwable th) {
                    ReferenceCountedOpenSslClientContext.logger.debug("request of key failed", th);
                    referenceCountedOpenSslEngine.initHandshakeException(th);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class OpenSslClientSessionContext extends OpenSslSessionContext {
        OpenSslClientSessionContext(ReferenceCountedOpenSslContext referenceCountedOpenSslContext, OpenSslKeyMaterialProvider openSslKeyMaterialProvider) {
            super(referenceCountedOpenSslContext, openSslKeyMaterialProvider);
        }

        @Override // javax.net.ssl.SSLSessionContext
        public int getSessionCacheSize() {
            return 0;
        }

        @Override // javax.net.ssl.SSLSessionContext
        public int getSessionTimeout() {
            return 0;
        }

        @Override // io.netty.handler.ssl.OpenSslSessionContext
        public boolean isSessionCacheEnabled() {
            return false;
        }

        @Override // io.netty.handler.ssl.OpenSslSessionContext
        public void setSessionCacheEnabled(boolean z) {
        }

        @Override // javax.net.ssl.SSLSessionContext
        public void setSessionCacheSize(int i) {
            if (i < 0) {
                throw new IllegalArgumentException();
            }
        }

        @Override // javax.net.ssl.SSLSessionContext
        public void setSessionTimeout(int i) {
            if (i < 0) {
                throw new IllegalArgumentException();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class TrustManagerVerifyCallback extends ReferenceCountedOpenSslContext.AbstractCertificateVerifier {
        private final X509TrustManager manager;

        TrustManagerVerifyCallback(OpenSslEngineMap openSslEngineMap, X509TrustManager x509TrustManager) {
            super(openSslEngineMap);
            this.manager = x509TrustManager;
        }

        @Override // io.netty.handler.ssl.ReferenceCountedOpenSslContext.AbstractCertificateVerifier
        void verify(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, X509Certificate[] x509CertificateArr, String str) throws Exception {
            this.manager.checkServerTrusted(x509CertificateArr, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReferenceCountedOpenSslClientContext(X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, String[] strArr, long j, long j2, boolean z, String str2) throws SSLException {
        super(iterable, cipherSuiteFilter, applicationProtocolConfig, j, j2, 0, (Certificate[]) x509CertificateArr2, ClientAuth.NONE, strArr, false, z, true);
        try {
            OpenSslSessionContext newSessionContext = newSessionContext(this, this.ctx, this.engineMap, x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, str2);
            this.sessionContext = newSessionContext;
            if (ENABLE_SESSION_TICKET) {
                newSessionContext.setTicketKeys(new OpenSslSessionTicketKey[0]);
            }
        } catch (Throwable th) {
            release();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OpenSslSessionContext newSessionContext(ReferenceCountedOpenSslContext referenceCountedOpenSslContext, long j, OpenSslEngineMap openSslEngineMap, X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, String str2) throws SSLException {
        Throwable th;
        Exception e2;
        KeyManagerFactory keyManagerFactory2;
        if ((privateKey != null || x509CertificateArr2 == null) && (privateKey == null || x509CertificateArr2 != null)) {
            OpenSslKeyMaterialProvider openSslKeyMaterialProvider = null;
            try {
                try {
                    if (OpenSsl.useKeyManagerFactory()) {
                        if (keyManagerFactory != null || x509CertificateArr2 == null) {
                            openSslKeyMaterialProvider = keyManagerFactory != null ? ReferenceCountedOpenSslContext.providerFor(keyManagerFactory, str) : null;
                        } else {
                            char[] keyStorePassword = SslContext.keyStorePassword(str);
                            KeyStore buildKeyStore = SslContext.buildKeyStore(x509CertificateArr2, privateKey, keyStorePassword, str2);
                            if (buildKeyStore.aliases().hasMoreElements()) {
                                keyManagerFactory2 = new OpenSslX509KeyManagerFactory();
                            } else {
                                keyManagerFactory2 = new OpenSslCachingX509KeyManagerFactory(KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm()));
                            }
                            keyManagerFactory2.init(buildKeyStore, keyStorePassword);
                            openSslKeyMaterialProvider = ReferenceCountedOpenSslContext.providerFor(keyManagerFactory2, str);
                        }
                        if (openSslKeyMaterialProvider != null) {
                            try {
                                try {
                                    SSLContext.setCertificateCallback(j, new OpenSslClientCertificateCallback(openSslEngineMap, new OpenSslKeyMaterialManager(openSslKeyMaterialProvider)));
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (openSslKeyMaterialProvider != null) {
                                        openSslKeyMaterialProvider.destroy();
                                    }
                                    throw th;
                                }
                            } catch (Exception e3) {
                                e2 = e3;
                                throw new SSLException("failed to set certificate and key", e2);
                            }
                        }
                    } else if (keyManagerFactory == null) {
                        if (x509CertificateArr2 != null) {
                            ReferenceCountedOpenSslContext.setKeyMaterial(j, x509CertificateArr2, privateKey, str);
                        }
                        openSslKeyMaterialProvider = null;
                    } else {
                        throw new IllegalArgumentException("KeyManagerFactory not supported");
                    }
                    SSLContext.setVerify(j, 1, 10);
                    try {
                        if (x509CertificateArr != null) {
                            trustManagerFactory = SslContext.buildTrustManagerFactory(x509CertificateArr, trustManagerFactory, str2);
                        } else if (trustManagerFactory == null) {
                            trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                            trustManagerFactory.init((KeyStore) null);
                        }
                        setVerifyCallback(j, openSslEngineMap, ReferenceCountedOpenSslContext.chooseTrustManager(trustManagerFactory.getTrustManagers()));
                        return new OpenSslClientSessionContext(referenceCountedOpenSslContext, openSslKeyMaterialProvider);
                    } catch (Exception e4) {
                        if (openSslKeyMaterialProvider != null) {
                            openSslKeyMaterialProvider.destroy();
                        }
                        throw new SSLException("unable to setup trustmanager", e4);
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e5) {
                e2 = e5;
            }
        } else {
            throw new IllegalArgumentException("Either both keyCertChain and key needs to be null or none of them");
        }
    }

    @SuppressJava6Requirement(reason = "Guarded by java version check")
    private static void setVerifyCallback(long j, OpenSslEngineMap openSslEngineMap, X509TrustManager x509TrustManager) {
        if (ReferenceCountedOpenSslContext.useExtendedTrustManager(x509TrustManager)) {
            SSLContext.setCertVerifyCallback(j, new ExtendedTrustManagerVerifyCallback(openSslEngineMap, (X509ExtendedTrustManager) x509TrustManager));
        } else {
            SSLContext.setCertVerifyCallback(j, new TrustManagerVerifyCallback(openSslEngineMap, x509TrustManager));
        }
    }

    @Override // io.netty.handler.ssl.ReferenceCountedOpenSslContext, io.netty.handler.ssl.SslContext
    public OpenSslSessionContext sessionContext() {
        return this.sessionContext;
    }
}
