package com.tplink.libtpmux.tsmux.f;

import java.util.ArrayList;
import java.util.List;

/* compiled from: Pmt.java */
/* loaded from: classes3.dex */
public class g {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private int f12709b;

    /* renamed from: c  reason: collision with root package name */
    private int f12710c;

    /* renamed from: d  reason: collision with root package name */
    private int f12711d;

    /* renamed from: e  reason: collision with root package name */
    private int f12712e;

    /* renamed from: f  reason: collision with root package name */
    private int f12713f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    List<h> p = new ArrayList();
    private int q;

    public void A(int i) {
        this.f12712e = i & 4095;
    }

    public void B(int i) {
        this.j = i & 255;
    }

    public void C(int i) {
        this.f12709b = i & 1;
    }

    public void D(int i) {
        this.a = i & 255;
    }

    public void E(int i) {
        this.h = i & 31;
    }

    public void F(int i) {
        this.f12710c = i & 1;
    }

    public int a() {
        return this.i & 1;
    }

    public int b() {
        return this.k & 255;
    }

    public int c() {
        return this.m & 8191;
    }

    public int d() {
        return this.o & 4095;
    }

    public int e() {
        return this.f12713f & 65535;
    }

    public int f() {
        return this.f12711d & 3;
    }

    public int g() {
        return this.g & 3;
    }

    public int h() {
        return this.l & 7;
    }

    public int i() {
        return this.n & 15;
    }

    public int j() {
        return this.f12712e & 4095;
    }

    public int k() {
        return this.j & 255;
    }

    public int l() {
        return this.f12709b & 1;
    }

    public int m() {
        return this.a & 255;
    }

    public int n() {
        return this.h & 31;
    }

    public int o() {
        return this.f12710c & 1;
    }

    public void p(int i) {
        this.q = i & (-1);
    }

    public void q(int i) {
        this.i = i & 1;
    }

    public void r(int i) {
        this.k = i & 255;
    }

    public void s(int i) {
        this.m = i & 8191;
    }

    public void t(List<h> list) {
        this.p = list;
    }

    public void u(int i) {
        this.o = i & 4095;
    }

    public void v(int i) {
        this.f12713f = i & 65535;
    }

    public void w(int i) {
        this.f12711d = i & 3;
    }

    public void x(int i) {
        this.g = i & 3;
    }

    public void y(int i) {
        this.l = i & 7;
    }

    public void z(int i) {
        this.n = i & 15;
    }
}
