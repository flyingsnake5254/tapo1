package io.netty.handler.ssl;

import io.netty.handler.ssl.util.SimpleKeyManagerFactory;
import io.netty.util.internal.ObjectUtil;
import java.security.KeyStore;
import javax.net.ssl.KeyManager;
import javax.net.ssl.ManagerFactoryParameters;

/* loaded from: classes3.dex */
final class KeyManagerFactoryWrapper extends SimpleKeyManagerFactory {
    private final KeyManager km;

    /* JADX INFO: Access modifiers changed from: package-private */
    public KeyManagerFactoryWrapper(KeyManager keyManager) {
        this.km = (KeyManager) ObjectUtil.checkNotNull(keyManager, "km");
    }

    @Override // io.netty.handler.ssl.util.SimpleKeyManagerFactory
    protected KeyManager[] engineGetKeyManagers() {
        return new KeyManager[]{this.km};
    }

    @Override // io.netty.handler.ssl.util.SimpleKeyManagerFactory
    protected void engineInit(KeyStore keyStore, char[] cArr) throws Exception {
    }

    @Override // io.netty.handler.ssl.util.SimpleKeyManagerFactory
    protected void engineInit(ManagerFactoryParameters managerFactoryParameters) throws Exception {
    }
}
