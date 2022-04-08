package com.tplink.cloud.define;

import androidx.annotation.NonNull;
import b.d.b.e.k;
import b.d.b.e.o;
import java.util.List;
import okhttp3.logging.HttpLoggingInterceptor;

/* compiled from: CloudContext.java */
/* loaded from: classes2.dex */
public class a implements o.a {
    private String a;

    /* renamed from: b  reason: collision with root package name */
    private String f5247b;

    /* renamed from: c  reason: collision with root package name */
    private String f5248c;

    /* renamed from: d  reason: collision with root package name */
    private String f5249d;

    /* renamed from: e  reason: collision with root package name */
    private String f5250e;

    /* renamed from: f  reason: collision with root package name */
    private String f5251f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private k n;
    private HttpLoggingInterceptor.Logger o;
    private List<String> p;

    public a(@NonNull com.tplink.cloud.context.a aVar) {
        g(aVar.b());
        r(aVar.d());
        w(aVar.j());
        z(aVar.n());
        B(aVar.q());
        x(aVar.l());
        s(aVar.e());
        y(aVar.m());
        D(aVar.s());
        C(aVar.r());
        e(aVar.a());
        A(aVar.p());
        v(aVar.i());
        u(aVar.h());
        t(aVar.f());
    }

    public void A(String str) {
        this.m = str;
    }

    public void B(String str) {
        this.f5249d = str;
    }

    public void C(String str) {
        this.k = str;
    }

    public void D(String str) {
        this.j = str;
    }

    public void E(String str) {
        this.f5247b = str;
    }

    @Override // b.d.b.e.o.a
    public String a() {
        return this.f5250e;
    }

    @Override // b.d.b.e.o.a
    public String b() {
        return this.f5251f;
    }

    @Override // b.d.b.e.o.a
    public String c() {
        return this.g;
    }

    @Override // b.d.b.e.o.a
    public String d() {
        return this.f5249d;
    }

    public void e(String str) {
        this.l = str;
    }

    @Override // b.d.b.e.o.a
    public k f() {
        return this.n;
    }

    public void g(String str) {
        this.f5248c = str;
    }

    @Override // b.d.b.e.o.a
    public String getToken() {
        return this.f5247b;
    }

    @Override // b.d.b.e.o.a
    public HttpLoggingInterceptor.Logger h() {
        return this.o;
    }

    @Override // b.d.b.e.o.a
    public String i() {
        return this.i;
    }

    @Override // b.d.b.e.o.a
    public String j() {
        return this.a;
    }

    @Override // b.d.b.e.o.a
    public List<String> k() {
        return this.p;
    }

    @Override // b.d.b.e.o.a
    public String l() {
        return this.h;
    }

    @Override // b.d.b.e.o.a
    public String m() {
        return this.l;
    }

    @Override // b.d.b.e.o.a
    public String n() {
        return this.j;
    }

    @Override // b.d.b.e.o.a
    public String o() {
        return this.f5248c;
    }

    @Override // b.d.b.e.o.a
    public String p() {
        return this.k;
    }

    @Override // b.d.b.e.o.a
    public String q() {
        return this.m;
    }

    public void r(String str) {
        this.f5250e = str;
    }

    public void s(String str) {
        this.h = str;
    }

    public void t(List<String> list) {
        this.p = list;
    }

    public void u(HttpLoggingInterceptor.Logger logger) {
        this.o = logger;
    }

    public void v(k kVar) {
        this.n = kVar;
    }

    public void w(String str) {
        this.a = str;
    }

    public void x(String str) {
        this.g = str;
    }

    public void y(String str) {
        this.i = str;
    }

    public void z(String str) {
        this.f5251f = str;
    }
}
