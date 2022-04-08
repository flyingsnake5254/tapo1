package io.netty.handler.ssl;

import io.netty.util.internal.SuppressJava6Requirement;
import java.security.AlgorithmConstraints;
import javax.net.ssl.SSLParameters;

/* loaded from: classes3.dex */
final class Java7SslParametersUtils {
    private Java7SslParametersUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static void setAlgorithmConstraints(SSLParameters sSLParameters, Object obj) {
        sSLParameters.setAlgorithmConstraints((AlgorithmConstraints) obj);
    }
}
