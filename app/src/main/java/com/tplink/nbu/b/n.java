package com.tplink.nbu.b;

import android.os.Build;
import androidx.annotation.NonNull;
import com.tplink.iab.beans.Platform;
import java.io.IOException;
import java.util.Locale;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: NbuRequestInterceptor.java */
/* loaded from: classes3.dex */
public class n implements Interceptor {
    private final a a;

    /* compiled from: NbuRequestInterceptor.java */
    /* loaded from: classes3.dex */
    public interface a {
        String E();

        String a();

        String b();

        String d();

        String e();

        String g();

        String i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(a aVar) {
        this.a = aVar;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(@NonNull Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder newBuilder = request.newBuilder();
        if (request.header("Content-Type") == null) {
            newBuilder.addHeader("Content-Type", "application/json;charset=UTF-8");
        }
        if (request.header("Platform") == null) {
            newBuilder.addHeader("Platform", Platform.ANDROID);
        }
        if (request.header("X-App-Os") == null) {
            newBuilder.addHeader("X-App-Os", "android");
        }
        if (request.header("App-Type") == null && this.a.i() != null) {
            newBuilder.addHeader("App-Type", this.a.i());
        }
        if (request.header("X-App-Type") == null && this.a.E() != null) {
            newBuilder.addHeader("X-App-Type", this.a.E());
        }
        if (request.header("x-app-name") == null && this.a.i() != null) {
            newBuilder.addHeader("x-app-name", this.a.i());
        }
        if (request.header("AppVer") == null && this.a.a() != null) {
            newBuilder.addHeader("AppVer", this.a.a());
        }
        if (request.header("X-App-Ver") == null && this.a.a() != null) {
            newBuilder.addHeader("X-App-Ver", this.a.a());
        }
        if (request.header("x-app-version") == null && this.a.a() != null) {
            newBuilder.addHeader("x-app-version", this.a.a());
        }
        if (request.header("OsVer") == null) {
            newBuilder.addHeader("OsVer", Build.VERSION.RELEASE);
        }
        if (request.header("x-ospf") == null) {
            newBuilder.addHeader("x-ospf", "Android " + Build.VERSION.RELEASE);
        }
        if (request.header("x-net-type") == null && this.a.b() != null) {
            newBuilder.addHeader("x-net-type", this.a.b());
        }
        if (request.header("UUID") == null && this.a.d() != null) {
            newBuilder.addHeader("UUID", this.a.d());
        }
        if (request.header("x-term-id") == null && this.a.d() != null) {
            newBuilder.addHeader("x-term-id", this.a.d());
        }
        if (this.a.g() != null && request.header("app-cid") == null) {
            newBuilder.addHeader("app-cid", this.a.g());
        }
        if (request.header("Locale") == null) {
            Locale locale = Locale.getDefault();
            newBuilder.addHeader("Locale", locale.getLanguage() + "_" + locale.getCountry());
        }
        if (request.header("x-locale") == null) {
            Locale locale2 = Locale.getDefault();
            newBuilder.addHeader("x-locale", locale2.getLanguage() + "_" + locale2.getCountry());
        }
        if (request.header("Accept-Language") == null) {
            Locale locale3 = Locale.getDefault();
            newBuilder.addHeader("Accept-Language", locale3.getLanguage() + "_" + locale3.getCountry());
        }
        String header = request.header("Authorization-Required");
        if ((header == null || !header.equals("false")) && request.header("Authorization") == null) {
            String header2 = request.header("Authorization-Format");
            String e2 = header2 == null ? this.a.e() : String.format(header2, this.a.e());
            if (e2 != null) {
                newBuilder.addHeader("Authorization", e2);
            }
        }
        newBuilder.removeHeader("Authorization-Required");
        newBuilder.removeHeader("Authorization-Format");
        return chain.proceed(newBuilder.build());
    }
}
