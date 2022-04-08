package b.d.b.e;

import android.os.Build;
import androidx.annotation.NonNull;
import b.d.b.e.o;
import java.io.IOException;
import java.util.Locale;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: QueryParamsInterceptor.java */
/* loaded from: classes2.dex */
public class m implements Interceptor {
    private final o.a a;

    public m(o.a aVar) {
        this.a = aVar;
    }

    @Override // okhttp3.Interceptor
    @NonNull
    public Response intercept(@NonNull Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl url = request.url();
        String header = request.header("query-params-required");
        String str = null;
        HttpUrl.Builder builder = null;
        if (header == null || !header.equals("false")) {
            String header2 = request.header("token-required");
            if (header2 == null || !header2.equals("false")) {
                str = this.a.getToken();
            }
            HttpUrl.Builder addQueryParameter = url.newBuilder().addQueryParameter("appName", this.a.o()).addQueryParameter("appVer", this.a.a()).addQueryParameter("netType", this.a.b()).addQueryParameter("termID", this.a.d());
            HttpUrl.Builder addQueryParameter2 = addQueryParameter.addQueryParameter("ospf", "Android " + Build.VERSION.RELEASE).addQueryParameter("brand", this.a.l() == null ? "TPLINK" : this.a.l());
            String c2 = this.a.c();
            if (c2 == null) {
                c2 = Locale.getDefault().toString();
            }
            addQueryParameter2.addQueryParameter("locale", c2);
            if (this.a.i() != null) {
                addQueryParameter2.addQueryParameter("model", this.a.i());
            }
            if (this.a.n() != null) {
                addQueryParameter2.addQueryParameter("termName", this.a.n());
            }
            if (this.a.p() != null) {
                addQueryParameter2.addQueryParameter("termMeta", this.a.p());
            }
            if (str != null) {
                addQueryParameter2.addQueryParameter("token", str);
            }
            builder = addQueryParameter2;
        }
        Request.Builder newBuilder = request.newBuilder();
        if (builder != null) {
            newBuilder.url(builder.build());
        }
        newBuilder.removeHeader("token-required");
        newBuilder.removeHeader("query-params-required");
        if (request.header("Content-Type") == null) {
            newBuilder.addHeader("Content-Type", "application/json;charset=UTF-8");
        }
        return chain.proceed(newBuilder.build());
    }
}
