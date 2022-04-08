package com.tplink.iot.c.d;

import com.google.gson.Gson;
import com.google.gson.d;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;

/* compiled from: IoTCloudHttpLoggingInterceptor.java */
/* loaded from: classes2.dex */
public class o implements Interceptor {
    private static final Charset a = StandardCharsets.UTF_8;

    /* renamed from: b  reason: collision with root package name */
    private final Gson f6101b;

    /* renamed from: c  reason: collision with root package name */
    private final HttpLoggingInterceptor.Logger f6102c;

    public o() {
        this(HttpLoggingInterceptor.Logger.DEFAULT);
    }

    private static boolean a(Headers headers) {
        String str = headers.get("Content-Encoding");
        return str != null && !str.equalsIgnoreCase("identity") && !str.equalsIgnoreCase("gzip");
    }

    static boolean b(Buffer buffer) {
        try {
            Buffer buffer2 = new Buffer();
            buffer.copyTo(buffer2, 0L, buffer.size() < 64 ? buffer.size() : 64L);
            for (int i = 0; i < 16; i++) {
                if (buffer2.exhausted()) {
                    return true;
                }
                int readUtf8CodePoint = buffer2.readUtf8CodePoint();
                if (Character.isISOControl(readUtf8CodePoint) && !Character.isWhitespace(readUtf8CodePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01fb  */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r25) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 894
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.c.d.o.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }

    public o(HttpLoggingInterceptor.Logger logger) {
        this.f6101b = new d().f().b();
        this.f6102c = logger;
    }
}
