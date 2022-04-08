package com.tplink.iot.c.c;

import android.os.Build;
import androidx.annotation.NonNull;
import b.d.b.e.k;
import com.tplink.cloud.context.a;
import com.tplink.iot.c.d.p;
import com.tplink.iot.cloud.bean.common.IoTWebServiceIdParams;
import okhttp3.logging.HttpLoggingInterceptor;

/* compiled from: IoTCloudContext.java */
/* loaded from: classes2.dex */
public class b implements p.a {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6089b;

    /* renamed from: c  reason: collision with root package name */
    private String f6090c;

    /* renamed from: d  reason: collision with root package name */
    private final String f6091d;

    /* renamed from: e  reason: collision with root package name */
    private final String f6092e;

    /* renamed from: f  reason: collision with root package name */
    private String f6093f = null;
    private final String g;
    private final a h;
    private final k i;
    private final HttpLoggingInterceptor.Logger j;
    private final p k;

    public b(String str, IoTWebServiceIdParams ioTWebServiceIdParams, String str2, @NonNull a aVar) {
        n(str2);
        this.h = aVar;
        String b2 = aVar.b();
        this.a = b2;
        String q = aVar.q();
        this.f6089b = q;
        this.f6091d = String.format("app:%1$s:%2$s", b2, q);
        this.f6092e = String.format("%1$s:v%2$s:%3$s:%4$s", b2, aVar.d(), aVar.o(), aVar.l());
        this.g = String.format("%1$s/%2$s(%3$s/;%4$s)", aVar.b(), aVar.d(), Build.MODEL, aVar.o());
        this.i = aVar.i();
        this.j = aVar.h();
        this.k = new p(str, this);
    }

    @Override // com.tplink.iot.c.d.p.a
    public String a() {
        return this.h.d();
    }

    @Override // com.tplink.iot.c.d.p.a
    public String b() {
        return this.h.n();
    }

    @Override // com.tplink.iot.c.d.p.a
    public String c() {
        return this.h.l();
    }

    public String d() {
        return this.f6093f;
    }

    @Override // com.tplink.iot.c.d.p.a
    public String e() {
        return this.f6090c;
    }

    @Override // com.tplink.iot.c.d.p.a
    public k f() {
        return this.i;
    }

    @Override // com.tplink.iot.c.d.p.a
    public String g() {
        return this.f6091d;
    }

    @Override // com.tplink.iot.c.d.p.a
    public String getUserAgent() {
        return this.g;
    }

    @Override // com.tplink.iot.c.d.p.a
    public HttpLoggingInterceptor.Logger h() {
        return this.j;
    }

    @Override // com.tplink.iot.c.d.p.a
    public String i() {
        return this.a;
    }

    @Override // com.tplink.iot.c.d.p.a
    public String j() {
        return this.f6089b;
    }

    public String k() {
        return this.f6092e;
    }

    public p l() {
        return this.k;
    }

    public void m(String str) {
        this.f6093f = str;
    }

    public void n(String str) {
        if (str != null) {
            this.f6090c = String.format("ut|%s", str);
        } else {
            this.f6090c = null;
        }
    }
}
