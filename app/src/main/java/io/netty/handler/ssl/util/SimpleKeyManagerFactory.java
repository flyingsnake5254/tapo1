package io.netty.handler.ssl.util;

import com.github.mikephil.charting.utils.Utils;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.Provider;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.KeyManagerFactorySpi;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509KeyManager;

/* loaded from: classes3.dex */
public abstract class SimpleKeyManagerFactory extends KeyManagerFactory {
    private static final Provider PROVIDER = new Provider("", Utils.DOUBLE_EPSILON, "") { // from class: io.netty.handler.ssl.util.SimpleKeyManagerFactory.1
        private static final long serialVersionUID = -2680540247105807895L;
    };
    private static final FastThreadLocal<SimpleKeyManagerFactorySpi> CURRENT_SPI = new FastThreadLocal<SimpleKeyManagerFactorySpi>() { // from class: io.netty.handler.ssl.util.SimpleKeyManagerFactory.2
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public SimpleKeyManagerFactorySpi initialValue() {
            return new SimpleKeyManagerFactorySpi();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    public SimpleKeyManagerFactory() {
        this("");
    }

    protected abstract KeyManager[] engineGetKeyManagers();

    protected abstract void engineInit(KeyStore keyStore, char[] cArr) throws Exception;

    protected abstract void engineInit(ManagerFactoryParameters managerFactoryParameters) throws Exception;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected SimpleKeyManagerFactory(java.lang.String r5) {
        /*
            r4 = this;
            io.netty.util.concurrent.FastThreadLocal<io.netty.handler.ssl.util.SimpleKeyManagerFactory$SimpleKeyManagerFactorySpi> r0 = io.netty.handler.ssl.util.SimpleKeyManagerFactory.CURRENT_SPI
            java.lang.Object r1 = r0.get()
            javax.net.ssl.KeyManagerFactorySpi r1 = (javax.net.ssl.KeyManagerFactorySpi) r1
            java.security.Provider r2 = io.netty.handler.ssl.util.SimpleKeyManagerFactory.PROVIDER
            java.lang.String r3 = "name"
            java.lang.Object r5 = io.netty.util.internal.ObjectUtil.checkNotNull(r5, r3)
            java.lang.String r5 = (java.lang.String) r5
            r4.<init>(r1, r2, r5)
            java.lang.Object r5 = r0.get()
            io.netty.handler.ssl.util.SimpleKeyManagerFactory$SimpleKeyManagerFactorySpi r5 = (io.netty.handler.ssl.util.SimpleKeyManagerFactory.SimpleKeyManagerFactorySpi) r5
            r5.init(r4)
            r0.remove()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.util.SimpleKeyManagerFactory.<init>(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class SimpleKeyManagerFactorySpi extends KeyManagerFactorySpi {
        private volatile KeyManager[] keyManagers;
        private SimpleKeyManagerFactory parent;

        private SimpleKeyManagerFactorySpi() {
        }

        @SuppressJava6Requirement(reason = "Usage guarded by java version check")
        private static void wrapIfNeeded(KeyManager[] keyManagerArr) {
            for (int i = 0; i < keyManagerArr.length; i++) {
                KeyManager keyManager = keyManagerArr[i];
                if ((keyManager instanceof X509KeyManager) && !(keyManager instanceof X509ExtendedKeyManager)) {
                    keyManagerArr[i] = new X509KeyManagerWrapper((X509KeyManager) keyManager);
                }
            }
        }

        @Override // javax.net.ssl.KeyManagerFactorySpi
        protected KeyManager[] engineGetKeyManagers() {
            KeyManager[] keyManagerArr = this.keyManagers;
            if (keyManagerArr == null) {
                keyManagerArr = this.parent.engineGetKeyManagers();
                if (PlatformDependent.javaVersion() >= 7) {
                    wrapIfNeeded(keyManagerArr);
                }
                this.keyManagers = keyManagerArr;
            }
            return (KeyManager[]) keyManagerArr.clone();
        }

        @Override // javax.net.ssl.KeyManagerFactorySpi
        protected void engineInit(KeyStore keyStore, char[] cArr) throws KeyStoreException {
            try {
                this.parent.engineInit(keyStore, cArr);
            } catch (KeyStoreException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new KeyStoreException(e3);
            }
        }

        void init(SimpleKeyManagerFactory simpleKeyManagerFactory) {
            this.parent = simpleKeyManagerFactory;
        }

        @Override // javax.net.ssl.KeyManagerFactorySpi
        protected void engineInit(ManagerFactoryParameters managerFactoryParameters) throws InvalidAlgorithmParameterException {
            try {
                this.parent.engineInit(managerFactoryParameters);
            } catch (InvalidAlgorithmParameterException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new InvalidAlgorithmParameterException(e3);
            }
        }
    }
}
