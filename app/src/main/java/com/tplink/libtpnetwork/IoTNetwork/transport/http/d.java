package com.tplink.libtpnetwork.IoTNetwork.transport.http;

import android.annotation.SuppressLint;
import com.tplink.libtpnetwork.IoTNetwork.transport.http.cookie.c;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory;
import retrofit2.adapter.rxjava2.g;
import retrofit2.r;

/* compiled from: RetrofitFactory.java */
/* loaded from: classes3.dex */
public class d {
    private X509TrustManager a;

    /* renamed from: b  reason: collision with root package name */
    private SSLSocketFactory f13620b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RetrofitFactory.java */
    /* loaded from: classes3.dex */
    public class a implements HostnameVerifier {
        a() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    /* compiled from: RetrofitFactory.java */
    /* loaded from: classes3.dex */
    private static class b implements X509TrustManager {
        private b() {
        }

        @Override // javax.net.ssl.X509TrustManager
        @SuppressLint({"TrustAllX509TrustManager"})
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        @SuppressLint({"TrustAllX509TrustManager"})
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    public d(InputStream inputStream) {
        try {
            SSLContext instance = SSLContext.getInstance(SSLSocketFactoryFactory.DEFAULT_PROTOCOL);
            if (inputStream != null) {
                this.a = d(inputStream);
            } else {
                this.a = new b(null);
            }
            instance.init(null, new TrustManager[]{this.a}, null);
            this.f13620b = instance.getSocketFactory();
        } catch (GeneralSecurityException e2) {
            throw new RuntimeException(e2);
        }
    }

    private KeyStore c(char[] cArr) throws GeneralSecurityException {
        try {
            KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
            instance.load(null, cArr);
            return instance;
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    private X509TrustManager d(InputStream inputStream) throws GeneralSecurityException {
        Collection<? extends Certificate> generateCertificates = CertificateFactory.getInstance("X.509").generateCertificates(inputStream);
        if (!generateCertificates.isEmpty()) {
            char[] charArray = "password".toCharArray();
            KeyStore c2 = c(charArray);
            int i = 0;
            for (Certificate certificate : generateCertificates) {
                i++;
                c2.setCertificateEntry(Integer.toString(i), certificate);
            }
            KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm()).init(c2, charArray);
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init(c2);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        }
        throw new IllegalArgumentException("expected non-empty set of trusted certificates");
    }

    public <T> T a(String str, Class<T> cls, c cVar, boolean z) {
        return (T) b(str, cVar, z).b(cls);
    }

    public r b(String str, c cVar, boolean z) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.hostnameVerifier(new a());
        builder.cookieJar(new com.tplink.libtpnetwork.IoTNetwork.transport.http.cookie.a(cVar));
        builder.addInterceptor(new com.tplink.libtpnetwork.IoTNetwork.transport.http.f.a(str));
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.readTimeout(30L, timeUnit);
        builder.writeTimeout(30L, timeUnit);
        builder.connectTimeout(30L, timeUnit);
        builder.sslSocketFactory(this.f13620b, this.a);
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequestsPerHost(4);
        builder.dispatcher(dispatcher);
        return new r.b().c(str).g(builder.build()).b(retrofit2.w.a.a.g(new com.google.gson.d().c().b())).a(z ? g.e() : g.d()).e();
    }
}
