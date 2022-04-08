package com.tplink.iot.c.d;

import android.os.Build;
import androidx.annotation.NonNull;
import com.tplink.iot.c.d.p;
import java.io.IOException;
import java.util.Locale;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: HeadersParamsInterceptor.java */
/* loaded from: classes2.dex */
public class m implements Interceptor {
    private final p.a a;

    public m(p.a aVar) {
        this.a = aVar;
    }

    private void a(Request request, String str, Request.Builder builder, String str2) {
        if (str2 != null && request.header(str) == null) {
            builder.addHeader(str, str2);
        }
    }

    @Override // okhttp3.Interceptor
    @NonNull
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder newBuilder = request.newBuilder();
        String header = request.header("Authorization-Required");
        if ((header == null || !header.equals("false")) && this.a.e() != null && request.header("Authorization") == null) {
            newBuilder.addHeader("Authorization", this.a.e());
        }
        a(request, "app-cid", newBuilder, this.a.g());
        a(request, "x-app-name", newBuilder, this.a.i());
        a(request, "x-app-version", newBuilder, this.a.a());
        a(request, "x-term-id", newBuilder, this.a.j());
        a(request, "x-ospf", newBuilder, "Android " + Build.VERSION.RELEASE);
        a(request, "x-net-type", newBuilder, this.a.b());
        String c2 = this.a.c();
        if (c2 == null) {
            c2 = Locale.getDefault().toString();
        }
        a(request, "x-locale", newBuilder, c2);
        a(request, "User-Agent", newBuilder, this.a.getUserAgent());
        if (request.body() != null && request.header("Content-Type") == null) {
            newBuilder.addHeader("Content-Type", "application/json;charset=UTF-8");
        }
        return chain.proceed(newBuilder.build());
    }
}
