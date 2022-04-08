package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import com.google.android.datatransport.h.u.a.b;
import com.google.android.datatransport.h.x.j.y;
import com.google.android.datatransport.runtime.backends.e;
import d.a.a;
import java.util.concurrent.Executor;

/* compiled from: Uploader_Factory.java */
/* loaded from: classes.dex */
public final class r implements b<q> {
    private final a<Context> a;

    /* renamed from: b  reason: collision with root package name */
    private final a<e> f1993b;

    /* renamed from: c  reason: collision with root package name */
    private final a<y> f1994c;

    /* renamed from: d  reason: collision with root package name */
    private final a<u> f1995d;

    /* renamed from: e  reason: collision with root package name */
    private final a<Executor> f1996e;

    /* renamed from: f  reason: collision with root package name */
    private final a<com.google.android.datatransport.runtime.synchronization.a> f1997f;
    private final a<com.google.android.datatransport.h.y.a> g;

    public r(a<Context> aVar, a<e> aVar2, a<y> aVar3, a<u> aVar4, a<Executor> aVar5, a<com.google.android.datatransport.runtime.synchronization.a> aVar6, a<com.google.android.datatransport.h.y.a> aVar7) {
        this.a = aVar;
        this.f1993b = aVar2;
        this.f1994c = aVar3;
        this.f1995d = aVar4;
        this.f1996e = aVar5;
        this.f1997f = aVar6;
        this.g = aVar7;
    }

    public static r a(a<Context> aVar, a<e> aVar2, a<y> aVar3, a<u> aVar4, a<Executor> aVar5, a<com.google.android.datatransport.runtime.synchronization.a> aVar6, a<com.google.android.datatransport.h.y.a> aVar7) {
        return new r(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
    }

    public static q c(Context context, e eVar, y yVar, u uVar, Executor executor, com.google.android.datatransport.runtime.synchronization.a aVar, com.google.android.datatransport.h.y.a aVar2) {
        return new q(context, eVar, yVar, uVar, executor, aVar, aVar2);
    }

    /* renamed from: b */
    public q get() {
        return c(this.a.get(), this.f1993b.get(), this.f1994c.get(), this.f1995d.get(), this.f1996e.get(), this.f1997f.get(), this.g.get());
    }
}
