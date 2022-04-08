package com.tplink.iot.view.notification.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.t;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory;

/* compiled from: ImgDownloaderUtil.java */
/* loaded from: classes2.dex */
public class b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ImgDownloaderUtil.java */
    /* loaded from: classes2.dex */
    public static class a implements HostnameVerifier {
        a() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ImgDownloaderUtil.java */
    /* renamed from: com.tplink.iot.view.notification.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0232b implements X509TrustManager {
        private C0232b() {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }

        /* synthetic */ C0232b(a aVar) {
            this();
        }
    }

    private static SSLSocketFactory a() {
        try {
            SSLContext instance = SSLContext.getInstance(SSLSocketFactoryFactory.DEFAULT_PROTOCOL);
            instance.init(null, new TrustManager[]{new C0232b(null)}, new SecureRandom());
            return instance.getSocketFactory();
        } catch (Exception unused) {
            return null;
        }
    }

    public static q<Bitmap> b(final String str) {
        return q.f0(1).N(new j() { // from class: com.tplink.iot.view.notification.c.a
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return b.d(str, (Integer) obj);
            }
        }).L0(io.reactivex.l0.a.c());
    }

    private static OkHttpClient c() {
        return new OkHttpClient.Builder().hostnameVerifier(new a()).sslSocketFactory(a()).build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ t d(String str, Integer num) throws Exception {
        try {
            ResponseBody body = c().newCall(new Request.Builder().url(str).build()).execute().body();
            if (body == null) {
                return q.J(new Exception("get img body is empty"));
            }
            return q.f0(BitmapFactory.decodeStream(body.byteStream()));
        } catch (Exception e2) {
            e2.printStackTrace();
            return q.J(e2);
        }
    }
}
