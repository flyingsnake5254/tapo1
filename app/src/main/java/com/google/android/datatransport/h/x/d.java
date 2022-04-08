package com.google.android.datatransport.h.x;

import com.google.android.datatransport.h.u.a.b;
import com.google.android.datatransport.h.x.j.y;
import com.google.android.datatransport.runtime.backends.e;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.u;
import d.a.a;
import java.util.concurrent.Executor;

/* compiled from: DefaultScheduler_Factory.java */
/* loaded from: classes.dex */
public final class d implements b<c> {
    private final a<Executor> a;

    /* renamed from: b  reason: collision with root package name */
    private final a<e> f1907b;

    /* renamed from: c  reason: collision with root package name */
    private final a<u> f1908c;

    /* renamed from: d  reason: collision with root package name */
    private final a<y> f1909d;

    /* renamed from: e  reason: collision with root package name */
    private final a<com.google.android.datatransport.runtime.synchronization.a> f1910e;

    public d(a<Executor> aVar, a<e> aVar2, a<u> aVar3, a<y> aVar4, a<com.google.android.datatransport.runtime.synchronization.a> aVar5) {
        this.a = aVar;
        this.f1907b = aVar2;
        this.f1908c = aVar3;
        this.f1909d = aVar4;
        this.f1910e = aVar5;
    }

    public static d a(a<Executor> aVar, a<e> aVar2, a<u> aVar3, a<y> aVar4, a<com.google.android.datatransport.runtime.synchronization.a> aVar5) {
        return new d(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static c c(Executor executor, e eVar, u uVar, y yVar, com.google.android.datatransport.runtime.synchronization.a aVar) {
        return new c(executor, eVar, uVar, yVar, aVar);
    }

    /* renamed from: b */
    public c get() {
        return c(this.a.get(), this.f1907b.get(), this.f1908c.get(), this.f1909d.get(), this.f1910e.get());
    }
}
