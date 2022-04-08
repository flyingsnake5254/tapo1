package io.netty.handler.ssl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import javax.net.ssl.SSLException;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509KeyManager;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class OpenSslKeyMaterialManager {
    private static final Map<String, String> KEY_TYPES;
    static final String KEY_TYPE_DH_RSA = "DH_RSA";
    static final String KEY_TYPE_EC = "EC";
    static final String KEY_TYPE_EC_EC = "EC_EC";
    static final String KEY_TYPE_EC_RSA = "EC_RSA";
    static final String KEY_TYPE_RSA = "RSA";
    private final OpenSslKeyMaterialProvider provider;

    static {
        HashMap hashMap = new HashMap();
        KEY_TYPES = hashMap;
        hashMap.put(KEY_TYPE_RSA, KEY_TYPE_RSA);
        hashMap.put("DHE_RSA", KEY_TYPE_RSA);
        hashMap.put("ECDHE_RSA", KEY_TYPE_RSA);
        hashMap.put("ECDHE_ECDSA", KEY_TYPE_EC);
        hashMap.put("ECDH_RSA", KEY_TYPE_EC_RSA);
        hashMap.put("ECDH_ECDSA", KEY_TYPE_EC_EC);
        hashMap.put(KEY_TYPE_DH_RSA, KEY_TYPE_DH_RSA);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSslKeyMaterialManager(OpenSslKeyMaterialProvider openSslKeyMaterialProvider) {
        this.provider = openSslKeyMaterialProvider;
    }

    private String chooseClientAlias(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, String[] strArr, X500Principal[] x500PrincipalArr) {
        X509KeyManager keyManager = this.provider.keyManager();
        if (keyManager instanceof X509ExtendedKeyManager) {
            return ((X509ExtendedKeyManager) keyManager).chooseEngineClientAlias(strArr, x500PrincipalArr, referenceCountedOpenSslEngine);
        }
        return keyManager.chooseClientAlias(strArr, x500PrincipalArr, null);
    }

    private String chooseServerAlias(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, String str) {
        X509KeyManager keyManager = this.provider.keyManager();
        if (keyManager instanceof X509ExtendedKeyManager) {
            return ((X509ExtendedKeyManager) keyManager).chooseEngineServerAlias(str, null, referenceCountedOpenSslEngine);
        }
        return keyManager.chooseServerAlias(str, null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0017 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean setKeyMaterial(io.netty.handler.ssl.ReferenceCountedOpenSslEngine r4, java.lang.String r5) throws javax.net.ssl.SSLException {
        /*
            r3 = this;
            r0 = 0
            io.netty.handler.ssl.OpenSslKeyMaterialProvider r1 = r3.provider     // Catch: all -> 0x001b, Exception -> 0x001d, SSLException -> 0x0024
            io.netty.buffer.ByteBufAllocator r2 = r4.alloc     // Catch: all -> 0x001b, Exception -> 0x001d, SSLException -> 0x0024
            io.netty.handler.ssl.OpenSslKeyMaterial r0 = r1.chooseKeyMaterial(r2, r5)     // Catch: all -> 0x001b, Exception -> 0x001d, SSLException -> 0x0024
            if (r0 == 0) goto L_0x0014
            boolean r4 = r4.setKeyMaterial(r0)     // Catch: all -> 0x001b, Exception -> 0x001d, SSLException -> 0x0024
            if (r4 == 0) goto L_0x0012
            goto L_0x0014
        L_0x0012:
            r4 = 0
            goto L_0x0015
        L_0x0014:
            r4 = 1
        L_0x0015:
            if (r0 == 0) goto L_0x001a
            r0.release()
        L_0x001a:
            return r4
        L_0x001b:
            r4 = move-exception
            goto L_0x0026
        L_0x001d:
            r4 = move-exception
            javax.net.ssl.SSLException r5 = new javax.net.ssl.SSLException     // Catch: all -> 0x001b
            r5.<init>(r4)     // Catch: all -> 0x001b
            throw r5     // Catch: all -> 0x001b
        L_0x0024:
            r4 = move-exception
            throw r4     // Catch: all -> 0x001b
        L_0x0026:
            if (r0 == 0) goto L_0x002b
            r0.release()
        L_0x002b:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.OpenSslKeyMaterialManager.setKeyMaterial(io.netty.handler.ssl.ReferenceCountedOpenSslEngine, java.lang.String):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setKeyMaterialClientSide(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, String[] strArr, X500Principal[] x500PrincipalArr) throws SSLException {
        String chooseClientAlias = chooseClientAlias(referenceCountedOpenSslEngine, strArr, x500PrincipalArr);
        if (chooseClientAlias != null) {
            setKeyMaterial(referenceCountedOpenSslEngine, chooseClientAlias);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setKeyMaterialServerSide(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine) throws SSLException {
        String chooseServerAlias;
        String[] authMethods = referenceCountedOpenSslEngine.authMethods();
        if (authMethods.length != 0) {
            HashSet hashSet = new HashSet(authMethods.length);
            for (String str : authMethods) {
                String str2 = KEY_TYPES.get(str);
                if (str2 != null && (chooseServerAlias = chooseServerAlias(referenceCountedOpenSslEngine, str2)) != null && hashSet.add(chooseServerAlias) && !setKeyMaterial(referenceCountedOpenSslEngine, chooseServerAlias)) {
                    return;
                }
            }
        }
    }
}
