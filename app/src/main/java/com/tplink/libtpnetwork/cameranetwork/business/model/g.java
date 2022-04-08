package com.tplink.libtpnetwork.cameranetwork.business.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: MotionDetectSetting.java */
/* loaded from: classes3.dex */
public class g {
    private boolean a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f14129b;

    /* renamed from: c  reason: collision with root package name */
    private int f14130c;

    /* renamed from: d  reason: collision with root package name */
    private Boolean f14131d = null;

    /* renamed from: e  reason: collision with root package name */
    private List<d> f14132e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private b f14133f = new b();

    public g a() {
        g gVar = new g();
        gVar.h(this.f14129b);
        gVar.g(this.a);
        gVar.k(this.f14130c);
        gVar.i(this.f14131d);
        gVar.j(this.f14132e);
        b bVar = this.f14133f;
        if (bVar != null) {
            gVar.f(bVar);
        }
        return gVar;
    }

    public Boolean b() {
        return this.f14131d;
    }

    public List<d> c() {
        return Collections.unmodifiableList(this.f14132e);
    }

    public int d() {
        return this.f14130c;
    }

    public boolean e() {
        return this.f14129b;
    }

    public boolean equals(Object obj) {
        b bVar;
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (gVar.f14129b == this.f14129b && gVar.a == this.a && gVar.f14130c == this.f14130c && gVar.f14131d == this.f14131d && gVar.f14132e.equals(this.f14132e)) {
                b bVar2 = gVar.f14133f;
                if (bVar2 == null || (bVar = this.f14133f) == null) {
                    return true;
                }
                return bVar2.equals(bVar);
            }
        }
        return false;
    }

    public void f(b bVar) {
        this.f14133f = bVar.a();
    }

    public void g(boolean z) {
        this.a = z;
    }

    public void h(boolean z) {
        this.f14129b = z;
    }

    public void i(Boolean bool) {
        this.f14131d = bool;
    }

    public void j(List<d> list) {
        this.f14132e.clear();
        this.f14132e.addAll(list);
    }

    public void k(int i) {
        this.f14130c = i;
    }
}
