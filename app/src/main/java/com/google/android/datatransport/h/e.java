package com.google.android.datatransport.h;

import android.content.Context;
import com.google.android.datatransport.h.s;
import com.google.android.datatransport.h.u.a.d;
import com.google.android.datatransport.h.x.c;
import com.google.android.datatransport.h.x.g;
import com.google.android.datatransport.h.x.j.b0;
import com.google.android.datatransport.h.x.j.c0;
import com.google.android.datatransport.h.x.j.d0;
import com.google.android.datatransport.h.x.j.f0;
import com.google.android.datatransport.h.x.j.g0;
import com.google.android.datatransport.h.x.j.i0;
import com.google.android.datatransport.h.x.j.y;
import com.google.android.datatransport.runtime.backends.i;
import com.google.android.datatransport.runtime.backends.k;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.q;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.r;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.s;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.t;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.u;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DaggerTransportRuntimeComponent.java */
/* loaded from: classes.dex */
public final class e extends s {
    private d.a.a<r> H3;

    /* renamed from: c  reason: collision with root package name */
    private d.a.a<Executor> f1874c;

    /* renamed from: d  reason: collision with root package name */
    private d.a.a<Context> f1875d;

    /* renamed from: f  reason: collision with root package name */
    private d.a.a f1876f;
    private d.a.a<u> p0;
    private d.a.a<c> p1;
    private d.a.a<q> p2;
    private d.a.a<s> p3;
    private d.a.a q;
    private d.a.a x;
    private d.a.a<f0> y;
    private d.a.a<SchedulerConfig> z;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DaggerTransportRuntimeComponent.java */
    /* loaded from: classes.dex */
    public static final class b implements s.a {
        private Context a;

        private b() {
        }

        /* renamed from: b */
        public b a(Context context) {
            this.a = (Context) d.b(context);
            return this;
        }

        @Override // com.google.android.datatransport.h.s.a
        public s build() {
            d.a(this.a, Context.class);
            return new e(this.a);
        }
    }

    public static s.a e() {
        return new b();
    }

    private void g(Context context) {
        this.f1874c = com.google.android.datatransport.h.u.a.a.a(k.a());
        com.google.android.datatransport.h.u.a.b a2 = com.google.android.datatransport.h.u.a.c.a(context);
        this.f1875d = a2;
        i a3 = i.a(a2, com.google.android.datatransport.h.y.c.a(), com.google.android.datatransport.h.y.d.a());
        this.f1876f = a3;
        this.q = com.google.android.datatransport.h.u.a.a.a(k.a(this.f1875d, a3));
        this.x = i0.a(this.f1875d, b0.a(), c0.a());
        this.y = com.google.android.datatransport.h.u.a.a.a(g0.a(com.google.android.datatransport.h.y.c.a(), com.google.android.datatransport.h.y.d.a(), d0.a(), this.x));
        g b2 = g.b(com.google.android.datatransport.h.y.c.a());
        this.z = b2;
        com.google.android.datatransport.h.x.i a4 = com.google.android.datatransport.h.x.i.a(this.f1875d, this.y, b2, com.google.android.datatransport.h.y.d.a());
        this.p0 = a4;
        d.a.a<Executor> aVar = this.f1874c;
        d.a.a aVar2 = this.q;
        d.a.a<f0> aVar3 = this.y;
        this.p1 = com.google.android.datatransport.h.x.d.a(aVar, aVar2, a4, aVar3, aVar3);
        d.a.a<Context> aVar4 = this.f1875d;
        d.a.a aVar5 = this.q;
        d.a.a<f0> aVar6 = this.y;
        this.p2 = r.a(aVar4, aVar5, aVar6, this.p0, this.f1874c, aVar6, com.google.android.datatransport.h.y.c.a());
        d.a.a<Executor> aVar7 = this.f1874c;
        d.a.a<f0> aVar8 = this.y;
        this.p3 = t.a(aVar7, aVar8, this.p0, aVar8);
        this.H3 = com.google.android.datatransport.h.u.a.a.a(t.a(com.google.android.datatransport.h.y.c.a(), com.google.android.datatransport.h.y.d.a(), this.p1, this.p2, this.p3));
    }

    @Override // com.google.android.datatransport.h.s
    y a() {
        return this.y.get();
    }

    @Override // com.google.android.datatransport.h.s
    r c() {
        return this.H3.get();
    }

    private e(Context context) {
        g(context);
    }
}
