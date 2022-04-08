package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.e;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.a0.a;
import com.bumptech.glide.load.engine.a0.h;
import com.bumptech.glide.load.engine.h;
import com.bumptech.glide.load.engine.p;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.i;
import com.bumptech.glide.util.k.a;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: Engine.java */
/* loaded from: classes.dex */
public class k implements m, h.a, p.a {
    private static final boolean a = Log.isLoggable("Engine", 2);

    /* renamed from: b  reason: collision with root package name */
    private final r f1463b;

    /* renamed from: c  reason: collision with root package name */
    private final o f1464c;

    /* renamed from: d  reason: collision with root package name */
    private final h f1465d;

    /* renamed from: e  reason: collision with root package name */
    private final b f1466e;

    /* renamed from: f  reason: collision with root package name */
    private final x f1467f;
    private final c g;
    private final a h;
    private final a i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Engine.java */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class a {
        final h.e a;

        /* renamed from: b  reason: collision with root package name */
        final Pools.Pool<h<?>> f1468b = com.bumptech.glide.util.k.a.d(150, new C0052a());

        /* renamed from: c  reason: collision with root package name */
        private int f1469c;

        /* compiled from: Engine.java */
        /* renamed from: com.bumptech.glide.load.engine.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0052a implements a.d<h<?>> {
            C0052a() {
            }

            /* renamed from: a */
            public h<?> c() {
                a aVar = a.this;
                return new h<>(aVar.a, aVar.f1468b);
            }
        }

        a(h.e eVar) {
            this.a = eVar;
        }

        <R> h<R> a(e eVar, Object obj, n nVar, com.bumptech.glide.load.c cVar, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, j jVar, Map<Class<?>, i<?>> map, boolean z, boolean z2, boolean z3, f fVar, h.b<R> bVar) {
            h hVar = (h) com.bumptech.glide.util.i.d(this.f1468b.acquire());
            int i3 = this.f1469c;
            this.f1469c = i3 + 1;
            return hVar.n(eVar, obj, nVar, cVar, i, i2, cls, cls2, priority, jVar, map, z, z2, z3, fVar, bVar, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Engine.java */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class b {
        final com.bumptech.glide.load.engine.b0.a a;

        /* renamed from: b  reason: collision with root package name */
        final com.bumptech.glide.load.engine.b0.a f1470b;

        /* renamed from: c  reason: collision with root package name */
        final com.bumptech.glide.load.engine.b0.a f1471c;

        /* renamed from: d  reason: collision with root package name */
        final com.bumptech.glide.load.engine.b0.a f1472d;

        /* renamed from: e  reason: collision with root package name */
        final m f1473e;

        /* renamed from: f  reason: collision with root package name */
        final p.a f1474f;
        final Pools.Pool<l<?>> g = com.bumptech.glide.util.k.a.d(150, new a());

        /* compiled from: Engine.java */
        /* loaded from: classes.dex */
        class a implements a.d<l<?>> {
            a() {
            }

            /* renamed from: a */
            public l<?> c() {
                b bVar = b.this;
                return new l<>(bVar.a, bVar.f1470b, bVar.f1471c, bVar.f1472d, bVar.f1473e, bVar.f1474f, bVar.g);
            }
        }

        b(com.bumptech.glide.load.engine.b0.a aVar, com.bumptech.glide.load.engine.b0.a aVar2, com.bumptech.glide.load.engine.b0.a aVar3, com.bumptech.glide.load.engine.b0.a aVar4, m mVar, p.a aVar5) {
            this.a = aVar;
            this.f1470b = aVar2;
            this.f1471c = aVar3;
            this.f1472d = aVar4;
            this.f1473e = mVar;
            this.f1474f = aVar5;
        }

        <R> l<R> a(com.bumptech.glide.load.c cVar, boolean z, boolean z2, boolean z3, boolean z4) {
            return ((l) com.bumptech.glide.util.i.d(this.g.acquire())).l(cVar, z, z2, z3, z4);
        }
    }

    /* compiled from: Engine.java */
    /* loaded from: classes.dex */
    private static class c implements h.e {
        private final a.AbstractC0046a a;

        /* renamed from: b  reason: collision with root package name */
        private volatile com.bumptech.glide.load.engine.a0.a f1475b;

        c(a.AbstractC0046a aVar) {
            this.a = aVar;
        }

        @Override // com.bumptech.glide.load.engine.h.e
        public com.bumptech.glide.load.engine.a0.a a() {
            if (this.f1475b == null) {
                synchronized (this) {
                    if (this.f1475b == null) {
                        this.f1475b = this.a.build();
                    }
                    if (this.f1475b == null) {
                        this.f1475b = new com.bumptech.glide.load.engine.a0.b();
                    }
                }
            }
            return this.f1475b;
        }
    }

    /* compiled from: Engine.java */
    /* loaded from: classes.dex */
    public class d {
        private final l<?> a;

        /* renamed from: b  reason: collision with root package name */
        private final com.bumptech.glide.request.h f1476b;

        d(com.bumptech.glide.request.h hVar, l<?> lVar) {
            this.f1476b = hVar;
            this.a = lVar;
        }

        public void a() {
            synchronized (k.this) {
                this.a.r(this.f1476b);
            }
        }
    }

    public k(com.bumptech.glide.load.engine.a0.h hVar, a.AbstractC0046a aVar, com.bumptech.glide.load.engine.b0.a aVar2, com.bumptech.glide.load.engine.b0.a aVar3, com.bumptech.glide.load.engine.b0.a aVar4, com.bumptech.glide.load.engine.b0.a aVar5, boolean z) {
        this(hVar, aVar, aVar2, aVar3, aVar4, aVar5, null, null, null, null, null, null, z);
    }

    private p<?> e(com.bumptech.glide.load.c cVar) {
        u<?> d2 = this.f1465d.d(cVar);
        if (d2 == null) {
            return null;
        }
        if (d2 instanceof p) {
            return (p) d2;
        }
        return new p<>(d2, true, true, cVar, this);
    }

    @Nullable
    private p<?> g(com.bumptech.glide.load.c cVar) {
        p<?> e2 = this.i.e(cVar);
        if (e2 != null) {
            e2.b();
        }
        return e2;
    }

    private p<?> h(com.bumptech.glide.load.c cVar) {
        p<?> e2 = e(cVar);
        if (e2 != null) {
            e2.b();
            this.i.a(cVar, e2);
        }
        return e2;
    }

    @Nullable
    private p<?> i(n nVar, boolean z, long j) {
        if (!z) {
            return null;
        }
        p<?> g = g(nVar);
        if (g != null) {
            if (a) {
                j("Loaded resource from active resources", j, nVar);
            }
            return g;
        }
        p<?> h = h(nVar);
        if (h == null) {
            return null;
        }
        if (a) {
            j("Loaded resource from cache", j, nVar);
        }
        return h;
    }

    private static void j(String str, long j, com.bumptech.glide.load.c cVar) {
        Log.v("Engine", str + " in " + com.bumptech.glide.util.e.a(j) + "ms, key: " + cVar);
    }

    private <R> d l(e eVar, Object obj, com.bumptech.glide.load.c cVar, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, j jVar, Map<Class<?>, i<?>> map, boolean z, boolean z2, f fVar, boolean z3, boolean z4, boolean z5, boolean z6, com.bumptech.glide.request.h hVar, Executor executor, n nVar, long j) {
        l<?> a2 = this.f1463b.a(nVar, z6);
        if (a2 != null) {
            a2.a(hVar, executor);
            if (a) {
                j("Added to existing load", j, nVar);
            }
            return new d(hVar, a2);
        }
        l<R> a3 = this.f1466e.a(nVar, z3, z4, z5, z6);
        h<R> a4 = this.h.a(eVar, obj, nVar, cVar, i, i2, cls, cls2, priority, jVar, map, z, z2, z6, fVar, a3);
        this.f1463b.c(nVar, a3);
        a3.a(hVar, executor);
        a3.s(a4);
        if (a) {
            j("Started new load", j, nVar);
        }
        return new d(hVar, a3);
    }

    @Override // com.bumptech.glide.load.engine.a0.h.a
    public void a(@NonNull u<?> uVar) {
        this.f1467f.a(uVar, true);
    }

    @Override // com.bumptech.glide.load.engine.m
    public synchronized void b(l<?> lVar, com.bumptech.glide.load.c cVar, p<?> pVar) {
        if (pVar != null) {
            if (pVar.f()) {
                this.i.a(cVar, pVar);
            }
        }
        this.f1463b.d(cVar, lVar);
    }

    @Override // com.bumptech.glide.load.engine.m
    public synchronized void c(l<?> lVar, com.bumptech.glide.load.c cVar) {
        this.f1463b.d(cVar, lVar);
    }

    @Override // com.bumptech.glide.load.engine.p.a
    public void d(com.bumptech.glide.load.c cVar, p<?> pVar) {
        this.i.d(cVar);
        if (pVar.f()) {
            this.f1465d.c(cVar, pVar);
        } else {
            this.f1467f.a(pVar, false);
        }
    }

    public <R> d f(e eVar, Object obj, com.bumptech.glide.load.c cVar, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, j jVar, Map<Class<?>, i<?>> map, boolean z, boolean z2, f fVar, boolean z3, boolean z4, boolean z5, boolean z6, com.bumptech.glide.request.h hVar, Executor executor) {
        long b2 = a ? com.bumptech.glide.util.e.b() : 0L;
        n a2 = this.f1464c.a(obj, cVar, i, i2, map, cls, cls2, fVar);
        synchronized (this) {
            p<?> i3 = i(a2, z3, b2);
            if (i3 == null) {
                return l(eVar, obj, cVar, i, i2, cls, cls2, priority, jVar, map, z, z2, fVar, z3, z4, z5, z6, hVar, executor, a2, b2);
            }
            hVar.b(i3, DataSource.MEMORY_CACHE, false);
            return null;
        }
    }

    public void k(u<?> uVar) {
        if (uVar instanceof p) {
            ((p) uVar).g();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    @VisibleForTesting
    k(com.bumptech.glide.load.engine.a0.h hVar, a.AbstractC0046a aVar, com.bumptech.glide.load.engine.b0.a aVar2, com.bumptech.glide.load.engine.b0.a aVar3, com.bumptech.glide.load.engine.b0.a aVar4, com.bumptech.glide.load.engine.b0.a aVar5, r rVar, o oVar, a aVar6, b bVar, a aVar7, x xVar, boolean z) {
        this.f1465d = hVar;
        c cVar = new c(aVar);
        this.g = cVar;
        a aVar8 = aVar6 == null ? new a(z) : aVar6;
        this.i = aVar8;
        aVar8.f(this);
        this.f1464c = oVar == null ? new o() : oVar;
        this.f1463b = rVar == null ? new r() : rVar;
        this.f1466e = bVar == null ? new b(aVar2, aVar3, aVar4, aVar5, this, this) : bVar;
        this.h = aVar7 == null ? new a(cVar) : aVar7;
        this.f1467f = xVar == null ? new x() : xVar;
        hVar.e(this);
    }
}
