package com.tplink.libtpmux.tsmux.f;

import java.util.ArrayList;
import java.util.List;

/* compiled from: Pat.java */
/* loaded from: classes3.dex */
public class d {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private int f12697b;

    /* renamed from: c  reason: collision with root package name */
    private int f12698c;

    /* renamed from: d  reason: collision with root package name */
    private int f12699d;

    /* renamed from: e  reason: collision with root package name */
    private int f12700e;

    /* renamed from: f  reason: collision with root package name */
    private int f12701f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private List<e> l = new ArrayList();
    private int m;

    public int a() {
        return this.i & 1;
    }

    public int b() {
        return this.k & 255;
    }

    public int c() {
        return this.f12699d & 3;
    }

    public int d() {
        return this.g & 3;
    }

    public int e() {
        return this.f12700e & 4095;
    }

    public int f() {
        return this.j & 255;
    }

    public int g() {
        return this.f12697b & 1;
    }

    public int h() {
        return this.a & 255;
    }

    public int i() {
        return this.f12701f & 65535;
    }

    public int j() {
        return this.h & 31;
    }

    public int k() {
        return this.f12698c & 1;
    }

    public void l(int i) {
        this.m = i & (-1);
    }

    public void m(int i) {
        this.i = i & 1;
    }

    public void n(int i) {
        this.k = i & 255;
    }

    public void o(List<e> list) {
        this.l = list;
    }

    public void p(int i) {
        this.f12699d = i & 3;
    }

    public void q(int i) {
        this.g = i & 3;
    }

    public void r(int i) {
        this.f12700e = i & 4095;
    }

    public void s(int i) {
        this.j = i & 255;
    }

    public void t(int i) {
        this.f12697b = i & 1;
    }

    public void u(int i) {
        this.a = i & 255;
    }

    public void v(int i) {
        this.f12701f = i & 65535;
    }

    public void w(int i) {
        this.h = i & 31;
    }

    public void x(int i) {
        this.f12698c = i & 1;
    }
}
