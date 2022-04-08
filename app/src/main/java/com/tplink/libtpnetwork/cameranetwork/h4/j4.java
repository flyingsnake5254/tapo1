package com.tplink.libtpnetwork.cameranetwork.h4;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.d;
import com.tplink.libtpnetwork.cameranetwork.h4.o4.t;
import com.tplink.libtpnetwork.cameranetwork.model.TypeAdapter;
import com.tplink.libtpnetwork.cameranetwork.model.Wrapper;
import com.tplink.libtpnetwork.cameranetwork.model.Wrappers;
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
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory;
import retrofit2.adapter.rxjava2.g;
import retrofit2.r;

/* compiled from: LocalRetrofitTransportFactory.java */
/* loaded from: classes3.dex */
public class j4 {
    private X509TrustManager a;

    /* renamed from: b  reason: collision with root package name */
    private SSLSocketFactory f14770b;

    /* renamed from: c  reason: collision with root package name */
    private Gson f14771c = new d().d(Wrapper.class, TypeAdapter.getWrapperSerializer()).d(Wrapper.class, TypeAdapter.getWrapperDeserializer()).d(Wrappers.class, TypeAdapter.getWrapperListSerializer()).d(Wrappers.class, TypeAdapter.getWrapperListDeserializer()).b();

    /* compiled from: LocalRetrofitTransportFactory.java */
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
    }

    public j4(InputStream inputStream) {
        try {
            SSLContext instance = SSLContext.getInstance(SSLSocketFactoryFactory.DEFAULT_PROTOCOL);
            if (inputStream != null) {
                this.a = f(inputStream);
            } else {
                this.a = new b();
            }
            instance.init(null, new TrustManager[]{this.a}, null);
            this.f14770b = instance.getSocketFactory();
        } catch (GeneralSecurityException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            b.d.w.c.a.c("Cam-OkHttp", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean c(String str, SSLSession sSLSession) {
        return true;
    }

    private KeyStore d(char[] cArr) throws GeneralSecurityException {
        try {
            KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
            instance.load(null, cArr);
            return instance;
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    private r e(String str, com.tplink.libtpnetwork.cameranetwork.h4.m4.b.b bVar, com.tplink.libtpnetwork.cameranetwork.h4.m4.a.a aVar, String str2) {
        new HttpLoggingInterceptor(c4.a).setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.hostnameVerifier(d4.a);
        builder.cookieJar(new com.tplink.libtpnetwork.cameranetwork.h4.m4.b.a(bVar, str2));
        builder.addInterceptor(new com.tplink.libtpnetwork.cameranetwork.h4.m4.a.b(str, aVar, str2));
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.readTimeout(30L, timeUnit);
        builder.writeTimeout(30L, timeUnit);
        builder.connectTimeout(30L, timeUnit);
        builder.sslSocketFactory(this.f14770b, this.a);
        builder.connectionPool(new ConnectionPool(10, 5L, TimeUnit.MINUTES));
        return new r.b().c(str).b(retrofit2.w.a.a.g(this.f14771c)).a(g.d()).g(builder.build()).e();
    }

    private X509TrustManager f(InputStream inputStream) throws GeneralSecurityException {
        Collection<? extends Certificate> generateCertificates = CertificateFactory.getInstance("X.509").generateCertificates(inputStream);
        if (!generateCertificates.isEmpty()) {
            char[] charArray = "password".toCharArray();
            KeyStore d2 = d(charArray);
            int i = 0;
            for (Certificate certificate : generateCertificates) {
                i++;
                d2.setCertificateEntry(Integer.toString(i), certificate);
            }
            KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm()).init(d2, charArray);
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init(d2);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        }
        throw new IllegalArgumentException("expected non-empty set of trusted certificates");
    }

    public t a(String str, com.tplink.libtpnetwork.cameranetwork.h4.m4.b.b bVar, com.tplink.libtpnetwork.cameranetwork.h4.m4.a.a aVar, String str2) {
        return new t(str2, (com.tplink.libtpnetwork.cameranetwork.h4.o4.r) e(str, bVar, aVar, str2).b(com.tplink.libtpnetwork.cameranetwork.h4.o4.r.class));
    }
}
