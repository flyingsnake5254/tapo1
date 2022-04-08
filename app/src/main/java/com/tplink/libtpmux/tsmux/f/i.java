package com.tplink.libtpmux.tsmux.f;

/* compiled from: Pts.java */
/* loaded from: classes3.dex */
public class i {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private int f12718b;

    /* renamed from: c  reason: collision with root package name */
    private int f12719c;

    /* renamed from: d  reason: collision with root package name */
    private int f12720d;

    /* renamed from: e  reason: collision with root package name */
    private int f12721e;

    /* renamed from: f  reason: collision with root package name */
    private int f12722f;
    private int g;

    public int a() {
        return this.a & 15;
    }

    public int b() {
        return this.f12718b & 7;
    }

    public int c() {
        return this.f12720d & 32767;
    }

    public int d() {
        return this.f12722f & 32767;
    }

    public int e() {
        return this.f12719c & 1;
    }

    public int f() {
        return this.f12721e & 1;
    }

    public int g() {
        return this.g & 1;
    }

    public void h(int i) {
        this.a = i & 15;
    }

    public void i(int i) {
        this.f12718b = i & 7;
    }

    public void j(int i) {
        this.f12720d = i & 32767;
    }

    public void k(int i) {
        this.f12722f = i & 32767;
    }

    public void l(int i) {
        this.f12719c = i & 1;
    }

    public void m(int i) {
        this.f12721e = i & 1;
    }

    public void n(int i) {
        this.g = i & 1;
    }
}
