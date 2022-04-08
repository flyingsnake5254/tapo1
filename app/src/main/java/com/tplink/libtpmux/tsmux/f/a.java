package com.tplink.libtpmux.tsmux.f;

/* compiled from: Adaptation.java */
/* loaded from: classes3.dex */
public class a {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private int f12685b;

    /* renamed from: c  reason: collision with root package name */
    private int f12686c;

    /* renamed from: d  reason: collision with root package name */
    private int f12687d;

    /* renamed from: e  reason: collision with root package name */
    private int f12688e;

    /* renamed from: f  reason: collision with root package name */
    private int f12689f;
    private int g;
    private int h;
    private int i;
    private c j;

    public int a() {
        return this.i & 1;
    }

    public int b() {
        return this.a & 255;
    }

    public int c() {
        return this.f12685b & 1;
    }

    public int d() {
        return this.f12687d & 1;
    }

    public int e() {
        return this.f12689f & 1;
    }

    public c f() {
        return this.j;
    }

    public int g() {
        return this.f12688e & 1;
    }

    public int h() {
        return this.f12686c & 1;
    }

    public int i() {
        return this.g & 1;
    }

    public int j() {
        return this.h & 1;
    }

    public void k(int i) {
        this.i = i & 1;
    }

    public void l(int i) {
        this.a = i & 255;
    }

    public void m(int i) {
        this.f12685b = i & 1;
    }

    public void n(int i) {
        this.f12687d = i & 1;
    }

    public void o(int i) {
        this.f12689f = i & 1;
    }

    public void p(c cVar) {
        this.j = cVar;
    }

    public void q(int i) {
        this.f12688e = i & 1;
    }

    public void r(int i) {
        this.f12686c = i & 1;
    }

    public void s(int i) {
        this.g = i & 1;
    }

    public void t(int i) {
        this.h = i & 1;
    }
}
