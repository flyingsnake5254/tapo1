package com.google.android.datatransport.h;

import com.google.android.datatransport.h.u.a.b;
import com.google.android.datatransport.h.x.e;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.q;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.s;
import d.a.a;

/* compiled from: TransportRuntime_Factory.java */
/* loaded from: classes.dex */
public final class t implements b<r> {
    private final a<com.google.android.datatransport.h.y.a> a;

    /* renamed from: b  reason: collision with root package name */
    private final a<com.google.android.datatransport.h.y.a> f1890b;

    /* renamed from: c  reason: collision with root package name */
    private final a<e> f1891c;

    /* renamed from: d  reason: collision with root package name */
    private final a<q> f1892d;

    /* renamed from: e  reason: collision with root package name */
    private final a<s> f1893e;

    public t(a<com.google.android.datatransport.h.y.a> aVar, a<com.google.android.datatransport.h.y.a> aVar2, a<e> aVar3, a<q> aVar4, a<s> aVar5) {
        this.a = aVar;
        this.f1890b = aVar2;
        this.f1891c = aVar3;
        this.f1892d = aVar4;
        this.f1893e = aVar5;
    }

    public static t a(a<com.google.android.datatransport.h.y.a> aVar, a<com.google.android.datatransport.h.y.a> aVar2, a<e> aVar3, a<q> aVar4, a<s> aVar5) {
        return new t(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static r c(com.google.android.datatransport.h.y.a aVar, com.google.android.datatransport.h.y.a aVar2, e eVar, q qVar, s sVar) {
        return new r(aVar, aVar2, eVar, qVar, sVar);
    }

    /* renamed from: b */
    public r get() {
        return c(this.a.get(), this.f1890b.get(), this.f1891c.get(), this.f1892d.get(), this.f1893e.get());
    }
}
