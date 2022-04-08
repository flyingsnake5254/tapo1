package b.d.b.e;

import androidx.annotation.NonNull;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;

/* compiled from: GzipRequestInterceptor.java */
/* loaded from: classes2.dex */
public class l implements Interceptor {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GzipRequestInterceptor.java */
    /* loaded from: classes2.dex */
    public class a extends RequestBody {
        final /* synthetic */ RequestBody a;

        a(RequestBody requestBody) {
            this.a = requestBody;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() {
            return -1L;
        }

        @Override // okhttp3.RequestBody
        public MediaType contentType() {
            return this.a.contentType();
        }

        @Override // okhttp3.RequestBody
        public void writeTo(BufferedSink bufferedSink) throws IOException {
            BufferedSink buffer = Okio.buffer(new GzipSink(bufferedSink));
            this.a.writeTo(buffer);
            buffer.close();
        }
    }

    private RequestBody a(RequestBody requestBody) {
        return new a(requestBody);
    }

    @Override // okhttp3.Interceptor
    @NonNull
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        if (request.body() == null) {
            return chain.proceed(request);
        }
        if ("gzip".equalsIgnoreCase(request.header("Content-Encoding"))) {
            return chain.proceed(request.newBuilder().method(request.method(), a(request.body())).build());
        }
        return chain.proceed(request);
    }
}
