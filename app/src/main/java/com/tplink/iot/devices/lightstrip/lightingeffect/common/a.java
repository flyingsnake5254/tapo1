package com.tplink.iot.devices.lightstrip.lightingeffect.common;

import java.util.List;

/* compiled from: KasaLightStateGroup.java */
/* loaded from: classes2.dex */
public class a {
    private Integer a;

    /* renamed from: b  reason: collision with root package name */
    private Integer f7511b;

    /* renamed from: c  reason: collision with root package name */
    private Integer f7512c;

    /* renamed from: d  reason: collision with root package name */
    private String f7513d;

    /* renamed from: e  reason: collision with root package name */
    private List<KasaLightState> f7514e;

    /* compiled from: KasaLightStateGroup.java */
    /* loaded from: classes2.dex */
    public static final class b {
        private Integer a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f7515b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f7516c;

        /* renamed from: d  reason: collision with root package name */
        private String f7517d;

        /* renamed from: e  reason: collision with root package name */
        private List<KasaLightState> f7518e;

        public a f() {
            return new a(this);
        }

        public b g(List<KasaLightState> list) {
            this.f7518e = list;
            return this;
        }

        public b h(Integer num) {
            this.f7516c = num;
            return this;
        }

        private b() {
        }
    }

    public static b a() {
        return new b();
    }

    public List<KasaLightState> b() {
        return this.f7514e;
    }

    public Integer c() {
        return this.f7512c;
    }

    public void d(Integer num) {
        this.a = num;
    }

    public void e(List<KasaLightState> list) {
        this.f7514e = list;
    }

    public void f(String str) {
        this.f7513d = str;
    }

    public void g(Integer num) {
        this.f7512c = num;
    }

    public void h(Integer num) {
        this.f7511b = num;
    }

    public a() {
    }

    private a(b bVar) {
        d(bVar.a);
        h(bVar.f7515b);
        g(bVar.f7516c);
        f(bVar.f7517d);
        e(bVar.f7518e);
    }
}
