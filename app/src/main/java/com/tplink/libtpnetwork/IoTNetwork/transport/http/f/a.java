package com.tplink.libtpnetwork.IoTNetwork.transport.http.f;

import androidx.annotation.NonNull;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

/* compiled from: RequestInterceptor.java */
/* loaded from: classes3.dex */
public class a implements Interceptor {
    private final String a;

    public a(String str) {
        this.a = str;
    }

    @Override // okhttp3.Interceptor
    @NonNull
    public Response intercept(@NonNull Interceptor.Chain chain) throws IOException {
        return chain.proceed(chain.request().newBuilder().addHeader("Referer", this.a).addHeader("Accept", HttpHeaders.Values.APPLICATION_JSON).addHeader("requestByApp", "true").build());
    }
}
