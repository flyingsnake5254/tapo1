package com.tplink.libtpnetwork.libwss;

import androidx.lifecycle.MutableLiveData;
import b.d.b.d.a.c;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.d;
import com.tplink.libtpnetwork.Utils.x;
import com.tplink.libtpnetwork.libwss.bean.WssException;
import com.tplink.libtpnetwork.libwss.bean.params.SkillActiveParams;
import com.tplink.libtpnetwork.libwss.enumerate.WssAccountBindState;
import io.reactivex.e;
import io.reactivex.f;
import io.reactivex.g0.j;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.tls.OkHostnameVerifier;
import retrofit2.HttpException;
import retrofit2.adapter.rxjava2.g;
import retrofit2.r;

/* loaded from: classes3.dex */
public class WssCloudRepository extends b.d.b.f.a implements c.a {

    /* renamed from: c  reason: collision with root package name */
    private static final Gson f15060c = new d().c().b();

    /* renamed from: d  reason: collision with root package name */
    private com.tplink.cloud.context.b f15061d;

    /* renamed from: f  reason: collision with root package name */
    private MutableLiveData<WssAccountBindState> f15063f = new MutableLiveData<>();

    /* renamed from: e  reason: collision with root package name */
    private com.tplink.libtpnetwork.libwss.b.c f15062e = (com.tplink.libtpnetwork.libwss.b.c) b.d.b.d.a.d.b(this).a("https://alexa-ffs.tplinknbu.com/").b(com.tplink.libtpnetwork.libwss.b.c.class);

    /* loaded from: classes3.dex */
    class a implements HostnameVerifier {
        a() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            if ((!str.equals(sSLSession.getPeerHost()) || !str.endsWith("tplinknbu.com")) && !HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession)) {
                return OkHostnameVerifier.INSTANCE.verify(str, sSLSession);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements f {

        /* loaded from: classes3.dex */
        class a implements j<Throwable, e> {
            a() {
            }

            /* renamed from: a */
            public e apply(Throwable th) throws Exception {
                ResponseBody d2;
                if (!(th instanceof HttpException) || (d2 = ((HttpException) th).response().d()) == null) {
                    return io.reactivex.a.m(th);
                }
                try {
                    return io.reactivex.a.m((Throwable) WssCloudRepository.f15060c.j(d2.charStream(), WssException.class));
                } catch (JsonSyntaxException unused) {
                    return io.reactivex.a.m(th);
                }
            }
        }

        b() {
        }

        @Override // io.reactivex.f
        public e a(io.reactivex.a aVar) {
            return aVar.u(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements io.reactivex.g0.a {
        c() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            WssCloudRepository.this.f15063f.postValue(WssAccountBindState.BIND);
        }
    }

    public WssCloudRepository(com.tplink.cloud.context.b bVar) {
        super(bVar);
        this.f15061d = bVar;
        this.f15063f.postValue(WssAccountBindState.UNKNOWN);
    }

    private f g() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ Response i(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Request request2 = chain.request();
        Request.Builder newBuilder = request2.newBuilder();
        com.tplink.cloud.context.b bVar = this.f15061d;
        if (!(bVar == null || bVar.c() == null || this.f15061d.c().getToken() == null || request.header("Authorization") != null)) {
            newBuilder.addHeader("Authorization", this.f15061d.c().getToken());
        }
        if (request2.header("Content-Type") == null) {
            newBuilder.addHeader("Content-Type", "application/json;charset=UTF-8");
        } else {
            newBuilder.removeHeader("Content-Type");
            newBuilder.addHeader("Content-Type", "application/json;charset=UTF-8");
        }
        newBuilder.addHeader("Locale", x.d(Locale.getDefault()));
        newBuilder.addHeader("X-App-Type", "android");
        return chain.proceed(newBuilder.build());
    }

    @Override // b.d.b.d.a.c.a
    public r c() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient.Builder writeTimeout = builder.connectTimeout(30L, timeUnit).readTimeout(30L, timeUnit).writeTimeout(30L, timeUnit);
        writeTimeout.hostnameVerifier(new a());
        writeTimeout.addInterceptor(new Interceptor() { // from class: com.tplink.libtpnetwork.libwss.a
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) {
                return WssCloudRepository.this.i(chain);
            }
        });
        return new r.b().c("https://alexa-ffs.tplinknbu.com/").g(writeTimeout.build()).b(retrofit2.w.a.a.f()).a(g.d()).e();
    }

    public io.reactivex.a f(String str, SkillActiveParams skillActiveParams) {
        return this.f15062e.a(str, skillActiveParams).f(g()).i(new c()).C(io.reactivex.l0.a.c());
    }

    public io.reactivex.a j(String str) {
        return this.f15062e.b(str).f(g()).C(io.reactivex.l0.a.c());
    }
}
