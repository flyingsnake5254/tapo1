package com.tplink.libtpgoogleassistant.repository;

import androidx.lifecycle.MutableLiveData;
import b.d.b.d.a.a;
import b.d.b.d.a.c;
import b.d.b.d.a.d;
import b.d.b.f.a;
import com.tplink.cloud.context.b;
import com.tplink.libtpgoogleassistant.bean.params.AuthClientListParams;
import com.tplink.libtpgoogleassistant.bean.params.AuthCodeParams;
import com.tplink.libtpgoogleassistant.bean.result.AuthCodeResult;
import com.tplink.libtpgoogleassistant.bean.result.AuthResult;
import com.tplink.libtpgoogleassistant.bean.result.AuthValidClientList;
import io.reactivex.q;
import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.adapter.rxjava2.g;
import retrofit2.r;

/* loaded from: classes3.dex */
public class OAuthCloudRepository extends a implements c.a {

    /* renamed from: d  reason: collision with root package name */
    private MutableLiveData<Boolean> f12517d = new MutableLiveData<>();

    /* renamed from: c  reason: collision with root package name */
    private b.d.k.c.a f12516c = (b.d.k.c.a) d.b(this).a("https://n-oauth.tplinkcloud.com").b(b.d.k.c.a.class);

    public OAuthCloudRepository(b bVar) {
        super(bVar);
    }

    private boolean g(AuthResult<AuthValidClientList> authResult) {
        AuthValidClientList result;
        return (authResult == null || authResult.getErrorCode() != 0 || (result = authResult.getResult()) == null || result.getClientList() == null || result.getClientList().isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean h(String str, SSLSession sSLSession) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Response i(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder newBuilder = request.newBuilder();
        if (request.header("Content-Type") != null) {
            newBuilder.removeHeader("Content-Type");
        }
        newBuilder.addHeader("Content-Type", "application/json;charset=UTF-8");
        return chain.proceed(newBuilder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public /* synthetic */ void k(AuthResult authResult) throws Exception {
        this.f12517d.postValue(Boolean.valueOf(g(authResult)));
    }

    @Override // b.d.b.d.a.c.a
    public r c() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient.Builder writeTimeout = builder.connectTimeout(30L, timeUnit).readTimeout(30L, timeUnit).writeTimeout(30L, timeUnit);
        a.c c2 = b.d.b.d.a.a.c(Collections.singletonList("-----BEGIN CERTIFICATE-----\nMIIDBzCCAe+gAwIBAgIQT5x0ma7QnINHCQvhnmzR9zANBgkqhkiG9w0BAQsFADAV\nMRMwEQYDVQQDEwp0cC1saW5rLUNBMCAXDTE4MDExOTA4Mjc1MloYDzIwNjgwMTE5\nMDgzNzUyWjAVMRMwEQYDVQQDEwp0cC1saW5rLUNBMIIBIjANBgkqhkiG9w0BAQEF\nAAOCAQ8AMIIBCgKCAQEAuGG8n5zEUN1j5wuvUz4pAIMurhKHbpfUUu+b2acFHKS6\niU9hNJWvDyhXcihY5Wz6aq9m4D5SZcgW3k31YoNNtrztDjdg2qw7AaX85S99/G0B\nVbIXktrhs34OW19WA/haDwut3dFhLem+gCRRKUXcmuqchZc84dY7JFVfhPcJci4m\nsRjLCFNO0ho9OX+MZwfO4BLaeAqKVoAor6rf4BXVtO0xjYHDKO0fb3AWLLJ4EjGe\nq6YieqPiYlPFEqRm5PrvBXTm0IuQogygyVpK4LHr/K207ZLyV33DxLLbsUgSEJVn\npZUv/WUujXjlIDgxIvyZZCYiXO3dle2/MEvpmZk6JQIDAQABo1EwTzALBgNVHQ8E\nBAMCAYYwDwYDVR0TAQH/BAUwAwEB/zAdBgNVHQ4EFgQUxu2iBRTsef5iNnsADVhM\nJDQWi6kwEAYJKwYBBAGCNxUBBAMCAQAwDQYJKoZIhvcNAQELBQADggEBAB52Majd\n+wo3cb5BsTo63z2Psbbyl4ACMUaw68NxUMy61Oihx3mcLzLJqiIZcKePiHskLqLJ\nF7QfT9TqjvizMjFJVgsLuVubUBXKBzqyN+3KKlQci0PO3mH+ObhyaE7BzV+qrS3P\ndVTgsCWFv8DkgLTRudSWxL7VwVoedc7lRz5EroGgJ33nRGCR0ngcW919tLTARDQO\npULmzulcdWeZgG+0PLX0xjJQIjFEvbOxR1Z+gxMupBz0rWFokmWYrcga8eWiWzjQ\nIa3/ASBVJ69srV77trWlfLumkChbXk9i64NXBKnce0Jmll0Y9OC1nMPqrbQKnzcn\ndSAA4fejD/qMQn0=\n-----END CERTIFICATE-----"));
        writeTimeout.sslSocketFactory(c2.c(), c2.d());
        writeTimeout.hostnameVerifier(b.a);
        writeTimeout.addInterceptor(c.a);
        return new r.b().c("https://n-oauth.tplinkcloud.com").g(writeTimeout.build()).b(retrofit2.w.a.a.f()).a(g.d()).e();
    }

    public q<AuthResult<AuthCodeResult>> d(AuthCodeParams authCodeParams) {
        return this.f12516c.a(authCodeParams).L0(io.reactivex.l0.a.c());
    }

    public q<AuthResult<AuthValidClientList>> e(String str) {
        return this.f12516c.b(new AuthClientListParams(str)).L0(io.reactivex.l0.a.c()).E(new io.reactivex.g0.g() { // from class: com.tplink.libtpgoogleassistant.repository.a
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                OAuthCloudRepository.this.k((AuthResult) obj);
            }
        });
    }

    public Boolean f() {
        return this.f12517d.getValue();
    }
}
