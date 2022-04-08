package com.tplink.nbu.b;

import b.d.b.d.a.a;
import b.d.b.d.a.b;
import com.tplink.nbu.b.n;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import okhttp3.OkHttpClient;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.r;

/* compiled from: NbuCloudClient.java */
/* loaded from: classes3.dex */
public class m extends b implements n.a {

    /* renamed from: d  reason: collision with root package name */
    private final com.tplink.cloud.context.b f15160d;

    /* renamed from: e  reason: collision with root package name */
    private final String f15161e;

    /* renamed from: f  reason: collision with root package name */
    private String f15162f;
    private String g;

    public m(com.tplink.cloud.context.b bVar) {
        super("https://api.i.tplinknbu.com");
        this.f15160d = bVar;
        Map<String, Object> g = bVar.e().g();
        this.f15162f = (String) g.get("nbu_access_key");
        this.g = (String) g.get("nbu_secret");
        this.f15161e = String.format("app:%1$s:%2$s:%3$s", (String) g.get("nbu_app_cid_app_type"), bVar.e().d(), bVar.e().q());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean U1(String str, SSLSession sSLSession) {
        if ((!str.equals(sSLSession.getPeerHost()) || !str.endsWith("tplinknbu.com")) && !HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession)) {
            return OkHostnameVerifier.INSTANCE.verify(str, sSLSession);
        }
        return true;
    }

    @Override // com.tplink.nbu.b.n.a
    public String E() {
        return String.valueOf(this.f15160d.e().g().get("nbu_alexa_app_type_x"));
    }

    public String S1() {
        return this.f15162f;
    }

    public String T1() {
        return this.g;
    }

    @Override // com.tplink.nbu.b.n.a
    public String a() {
        return this.f15160d.e().d();
    }

    @Override // com.tplink.nbu.b.n.a
    public String b() {
        return this.f15160d.e().n();
    }

    @Override // b.d.b.d.a.b, b.d.b.d.a.c.a
    public r c() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient.Builder writeTimeout = builder.connectTimeout(30L, timeUnit).readTimeout(30L, timeUnit).writeTimeout(30L, timeUnit);
        a.c a = o.a();
        if (a != null) {
            writeTimeout.sslSocketFactory(a.c(), a.d());
        }
        writeTimeout.hostnameVerifier(k.a);
        writeTimeout.addInterceptor(new n(this));
        if (!(S1() == null || T1() == null)) {
            writeTimeout.addInterceptor(new p(S1(), T1()));
        }
        HttpLoggingInterceptor k = com.tplink.cloud.context.a.k();
        if (k != null) {
            writeTimeout.addNetworkInterceptor(k);
        }
        return new r.b().c("https://api.i.tplinknbu.com").g(writeTimeout.build()).b(retrofit2.w.a.a.f()).a(new l()).e();
    }

    @Override // com.tplink.nbu.b.n.a
    public String d() {
        return this.f15160d.e().q();
    }

    @Override // com.tplink.nbu.b.n.a
    public String e() {
        return this.f15160d.c().getToken();
    }

    @Override // com.tplink.nbu.b.n.a
    public String g() {
        return this.f15161e;
    }

    @Override // com.tplink.nbu.b.n.a
    public String i() {
        return this.f15160d.e().b();
    }
}
