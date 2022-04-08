package com.tplink.libtpmux.tsmux.f;

/* compiled from: PmtStream.java */
/* loaded from: classes3.dex */
public class h {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private int f12714b;

    /* renamed from: c  reason: collision with root package name */
    private int f12715c;

    /* renamed from: d  reason: collision with root package name */
    private int f12716d;

    /* renamed from: e  reason: collision with root package name */
    private int f12717e;

    public int a() {
        return this.f12717e & 4095;
    }

    public int b() {
        return this.f12715c & 8191;
    }

    public int c() {
        return this.f12714b & 7;
    }

    public int d() {
        return this.f12716d & 15;
    }

    public int e() {
        return this.a & 255;
    }

    public void f(int i) {
        this.f12717e = i & 4095;
    }

    public void g(int i) {
        this.f12715c = i & 8191;
    }

    public void h(int i) {
        this.f12714b = i & 7;
    }

    public void i(int i) {
        this.f12716d = i & 15;
    }

    public void j(int i) {
        this.a = i & 255;
    }
}
