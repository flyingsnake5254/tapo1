package com.tplink.libtpmux.tsmux.f;

/* compiled from: Header.java */
/* loaded from: classes3.dex */
public class b {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private int f12690b;

    /* renamed from: c  reason: collision with root package name */
    private int f12691c;

    /* renamed from: d  reason: collision with root package name */
    private int f12692d;

    /* renamed from: e  reason: collision with root package name */
    private int f12693e;

    /* renamed from: f  reason: collision with root package name */
    private int f12694f;
    private int g;
    private int h;

    public int a() {
        return this.g & 3;
    }

    public int b() {
        return this.h & 15;
    }

    public int c() {
        return this.f12693e & 8191;
    }

    public int d() {
        return this.f12691c & 1;
    }

    public int e() {
        return this.a & 255;
    }

    public int f() {
        return this.f12690b & 1;
    }

    public int g() {
        return this.f12692d & 1;
    }

    public int h() {
        return this.f12694f & 3;
    }

    public void i(int i) {
        this.g = i & 3;
    }

    public void j(int i) {
        this.h = i & 15;
    }

    public void k(int i) {
        this.f12693e = i & 8191;
    }

    public void l(int i) {
        this.f12691c = i & 1;
    }

    public void m(int i) {
        this.a = i & 255;
    }

    public void n(int i) {
        this.f12690b = i & 1;
    }

    public void o(int i) {
        this.f12692d = i & 1;
    }

    public void p(int i) {
        this.f12694f = i & 3;
    }
}
