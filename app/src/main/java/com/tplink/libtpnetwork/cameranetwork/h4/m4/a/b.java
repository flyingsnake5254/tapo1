package com.tplink.libtpnetwork.cameranetwork.h4.m4.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tplink.libtpmediastatistics.SSLClient;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.IOException;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: RequestInterceptor.java */
/* loaded from: classes3.dex */
public class b implements Interceptor {
    @NonNull
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private a f14787b;

    /* renamed from: c  reason: collision with root package name */
    private String f14788c;

    public b(@NonNull String str, @NonNull a aVar, @NonNull String str2) {
        this.a = str;
        this.f14787b = aVar;
        this.f14788c = str2;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Character ch;
        Request request = chain.request();
        Request.Builder addHeader = request.newBuilder().addHeader("Referer", this.a).addHeader("Accept", HttpHeaders.Values.APPLICATION_JSON).addHeader("Accept-Encoding", "gzip, deflate").addHeader("User-Agent", "Tapo CameraClient Android").addHeader("Connection", "Keep-Alive").addHeader("requestByApp", "true");
        a aVar = this.f14787b;
        if (aVar != null) {
            Map<String, String> b2 = aVar.b(this.f14788c);
            Map<String, String> a = this.f14787b.a(this.f14788c);
            StringBuilder sb = new StringBuilder();
            HttpUrl url = request.url();
            if (url.querySize() > 0) {
                ch = '&';
            } else {
                ch = '?';
            }
            if (b2 != null) {
                for (Map.Entry<String, String> entry : b2.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                        sb.append(ch);
                        sb.append(key);
                        sb.append(SSLClient.EQUALS);
                        sb.append(value);
                        ch = '&';
                    }
                }
            }
            if (a != null) {
                for (Map.Entry<String, String> entry2 : a.entrySet()) {
                    String key2 = entry2.getKey();
                    String value2 = entry2.getValue();
                    if (!TextUtils.isEmpty(key2) && !TextUtils.isEmpty(value2)) {
                        sb.append(ch);
                        sb.append(key2);
                        sb.append(SSLClient.EQUALS);
                        sb.append(value2);
                        ch = '&';
                    }
                }
            }
            addHeader.url(url + sb.toString());
        }
        return chain.proceed(addHeader.build());
    }
}
