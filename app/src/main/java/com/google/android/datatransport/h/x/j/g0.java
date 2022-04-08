package com.google.android.datatransport.h.x.j;

import com.google.android.datatransport.h.u.a.b;
import d.a.a;

/* compiled from: SQLiteEventStore_Factory.java */
/* loaded from: classes.dex */
public final class g0 implements b<f0> {
    private final a<com.google.android.datatransport.h.y.a> a;

    /* renamed from: b  reason: collision with root package name */
    private final a<com.google.android.datatransport.h.y.a> f1920b;

    /* renamed from: c  reason: collision with root package name */
    private final a<z> f1921c;

    /* renamed from: d  reason: collision with root package name */
    private final a<h0> f1922d;

    public g0(a<com.google.android.datatransport.h.y.a> aVar, a<com.google.android.datatransport.h.y.a> aVar2, a<z> aVar3, a<h0> aVar4) {
        this.a = aVar;
        this.f1920b = aVar2;
        this.f1921c = aVar3;
        this.f1922d = aVar4;
    }

    public static g0 a(a<com.google.android.datatransport.h.y.a> aVar, a<com.google.android.datatransport.h.y.a> aVar2, a<z> aVar3, a<h0> aVar4) {
        return new g0(aVar, aVar2, aVar3, aVar4);
    }

    public static f0 c(com.google.android.datatransport.h.y.a aVar, com.google.android.datatransport.h.y.a aVar2, Object obj, Object obj2) {
        return new f0(aVar, aVar2, (z) obj, (h0) obj2);
    }

    /* renamed from: b */
    public f0 get() {
        return c(this.a.get(), this.f1920b.get(), this.f1921c.get(), this.f1922d.get());
    }
}
