package org.bouncycastle.pqc.jcajce.provider;

import com.tplink.libtpmediastatistics.SSLClient;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivateKey;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n2.h;
import org.bouncycastle.asn1.x509.w;

/* loaded from: classes4.dex */
public class BouncyCastlePQCProvider extends Provider implements org.bouncycastle.jcajce.provider.config.a {
    private static final String ALGORITHM_PACKAGE = "org.bouncycastle.pqc.jcajce.provider.";
    public static final org.bouncycastle.jcajce.provider.config.b CONFIGURATION = null;
    public static String PROVIDER_NAME = "BCPQC";
    private static String info = "BouncyCastle Post-Quantum Security Provider v1.60";
    private static final Map keyInfoConverters = new HashMap();
    private static final String[] ALGORITHMS = {"Rainbow", "McEliece", "SPHINCS", "NH", "XMSS"};

    /* loaded from: classes4.dex */
    class a implements PrivilegedAction {
        a() {
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            BouncyCastlePQCProvider.this.setup();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class b implements PrivilegedAction {
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            try {
                return Class.forName(this.a);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public BouncyCastlePQCProvider() {
        super(PROVIDER_NAME, 1.6d, info);
        AccessController.doPrivileged(new a());
    }

    private static org.bouncycastle.jcajce.provider.util.b getAsymmetricKeyInfoConverter(m mVar) {
        org.bouncycastle.jcajce.provider.util.b bVar;
        Map map = keyInfoConverters;
        synchronized (map) {
            bVar = (org.bouncycastle.jcajce.provider.util.b) map.get(mVar);
        }
        return bVar;
    }

    public static PrivateKey getPrivateKey(h hVar) throws IOException {
        org.bouncycastle.jcajce.provider.util.b asymmetricKeyInfoConverter = getAsymmetricKeyInfoConverter(hVar.h().f());
        if (asymmetricKeyInfoConverter == null) {
            return null;
        }
        return asymmetricKeyInfoConverter.a(hVar);
    }

    public static PublicKey getPublicKey(w wVar) throws IOException {
        org.bouncycastle.jcajce.provider.util.b asymmetricKeyInfoConverter = getAsymmetricKeyInfoConverter(wVar.f().f());
        if (asymmetricKeyInfoConverter == null) {
            return null;
        }
        return asymmetricKeyInfoConverter.b(wVar);
    }

    private void loadAlgorithms(String str, String[] strArr) {
        for (int i = 0; i != strArr.length; i++) {
            Class loadClass = loadClass(BouncyCastlePQCProvider.class, str + strArr[i] + "$Mappings");
            if (loadClass != null) {
                try {
                    ((org.bouncycastle.jcajce.provider.util.a) loadClass.newInstance()).a(this);
                } catch (Exception e2) {
                    throw new InternalError("cannot create instance of " + str + strArr[i] + "$Mappings : " + e2);
                }
            }
        }
    }

    static Class loadClass(Class cls, String str) {
        try {
            ClassLoader classLoader = cls.getClassLoader();
            return classLoader != null ? classLoader.loadClass(str) : (Class) AccessController.doPrivileged(new b(str));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        loadAlgorithms(ALGORITHM_PACKAGE, ALGORITHMS);
    }

    public void addAlgorithm(String str, String str2) {
        if (!containsKey(str)) {
            put(str, str2);
            return;
        }
        throw new IllegalStateException("duplicate provider key (" + str + ") found");
    }

    public void addAlgorithm(String str, m mVar, String str2) {
        if (containsKey(str + "." + str2)) {
            addAlgorithm(str + "." + mVar, str2);
            addAlgorithm(str + ".OID." + mVar, str2);
            return;
        }
        throw new IllegalStateException("primary key (" + str + "." + str2 + ") not found");
    }

    public void addAttributes(String str, Map<String, String> map) {
        for (String str2 : map.keySet()) {
            String str3 = str + SSLClient.WHITE_SPACE + str2;
            if (!containsKey(str3)) {
                put(str3, map.get(str2));
            } else {
                throw new IllegalStateException("duplicate provider attribute key (" + str3 + ") found");
            }
        }
    }

    public void addKeyInfoConverter(m mVar, org.bouncycastle.jcajce.provider.util.b bVar) {
        Map map = keyInfoConverters;
        synchronized (map) {
            map.put(mVar, bVar);
        }
    }

    public boolean hasAlgorithm(String str, String str2) {
        if (!containsKey(str + "." + str2)) {
            if (!containsKey("Alg.Alias." + str + "." + str2)) {
                return false;
            }
        }
        return true;
    }

    public void setParameter(String str, Object obj) {
        synchronized (CONFIGURATION) {
        }
    }
}
