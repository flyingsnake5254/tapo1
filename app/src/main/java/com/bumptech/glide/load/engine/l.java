package com.bumptech.glide.load.engine;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.h;
import com.bumptech.glide.load.engine.p;
import com.bumptech.glide.util.i;
import com.bumptech.glide.util.k.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: EngineJob.java */
/* loaded from: classes.dex */
class l<R> implements h.b<R>, a.f {

    /* renamed from: c  reason: collision with root package name */
    private static final c f1478c = new c();
    private final AtomicInteger H3;
    private com.bumptech.glide.load.c I3;
    private boolean J3;
    private boolean K3;
    private boolean L3;
    private boolean M3;
    private u<?> N3;
    DataSource O3;
    private boolean P3;
    GlideException Q3;
    private boolean R3;
    p<?> S3;
    private h<R> T3;
    private volatile boolean U3;
    private boolean V3;

    /* renamed from: d  reason: collision with root package name */
    final e f1479d;

    /* renamed from: f  reason: collision with root package name */
    private final com.bumptech.glide.util.k.c f1480f;
    private final com.bumptech.glide.load.engine.b0.a p0;
    private final com.bumptech.glide.load.engine.b0.a p1;
    private final com.bumptech.glide.load.engine.b0.a p2;
    private final com.bumptech.glide.load.engine.b0.a p3;
    private final p.a q;
    private final Pools.Pool<l<?>> x;
    private final c y;
    private final m z;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EngineJob.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        private final com.bumptech.glide.request.h f1481c;

        a(com.bumptech.glide.request.h hVar) {
            this.f1481c = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f1481c.f()) {
                synchronized (l.this) {
                    if (l.this.f1479d.b(this.f1481c)) {
                        l.this.f(this.f1481c);
                    }
                    l.this.i();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EngineJob.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        private final com.bumptech.glide.request.h f1483c;

        b(com.bumptech.glide.request.h hVar) {
            this.f1483c = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f1483c.f()) {
                synchronized (l.this) {
                    if (l.this.f1479d.b(this.f1483c)) {
                        l.this.S3.b();
                        l.this.g(this.f1483c);
                        l.this.r(this.f1483c);
                    }
                    l.this.i();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EngineJob.java */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class c {
        c() {
        }

        public <R> p<R> a(u<R> uVar, boolean z, com.bumptech.glide.load.c cVar, p.a aVar) {
            return new p<>(uVar, z, true, cVar, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EngineJob.java */
    /* loaded from: classes.dex */
    public static final class d {
        final com.bumptech.glide.request.h a;

        /* renamed from: b  reason: collision with root package name */
        final Executor f1485b;

        d(com.bumptech.glide.request.h hVar, Executor executor) {
            this.a = hVar;
            this.f1485b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.a.equals(((d) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EngineJob.java */
    /* loaded from: classes.dex */
    public static final class e implements Iterable<d> {

        /* renamed from: c  reason: collision with root package name */
        private final List<d> f1486c;

        e() {
            this(new ArrayList(2));
        }

        private static d d(com.bumptech.glide.request.h hVar) {
            return new d(hVar, com.bumptech.glide.util.d.a());
        }

        void a(com.bumptech.glide.request.h hVar, Executor executor) {
            this.f1486c.add(new d(hVar, executor));
        }

        boolean b(com.bumptech.glide.request.h hVar) {
            return this.f1486c.contains(d(hVar));
        }

        e c() {
            return new e(new ArrayList(this.f1486c));
        }

        void clear() {
            this.f1486c.clear();
        }

        void e(com.bumptech.glide.request.h hVar) {
            this.f1486c.remove(d(hVar));
        }

        boolean isEmpty() {
            return this.f1486c.isEmpty();
        }

        @Override // java.lang.Iterable
        @NonNull
        public Iterator<d> iterator() {
            return this.f1486c.iterator();
        }

        int size() {
            return this.f1486c.size();
        }

        e(List<d> list) {
            this.f1486c = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(com.bumptech.glide.load.engine.b0.a aVar, com.bumptech.glide.load.engine.b0.a aVar2, com.bumptech.glide.load.engine.b0.a aVar3, com.bumptech.glide.load.engine.b0.a aVar4, m mVar, p.a aVar5, Pools.Pool<l<?>> pool) {
        this(aVar, aVar2, aVar3, aVar4, mVar, aVar5, pool, f1478c);
    }

    private com.bumptech.glide.load.engine.b0.a j() {
        if (this.K3) {
            return this.p2;
        }
        return this.L3 ? this.p3 : this.p1;
    }

    private boolean m() {
        return this.R3 || this.P3 || this.U3;
    }

    private synchronized void q() {
        if (this.I3 != null) {
            this.f1479d.clear();
            this.I3 = null;
            this.S3 = null;
            this.N3 = null;
            this.R3 = false;
            this.U3 = false;
            this.P3 = false;
            this.V3 = false;
            this.T3.w(false);
            this.T3 = null;
            this.Q3 = null;
            this.O3 = null;
            this.x.release(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(com.bumptech.glide.request.h hVar, Executor executor) {
        this.f1480f.c();
        this.f1479d.a(hVar, executor);
        boolean z = true;
        if (this.P3) {
            k(1);
            executor.execute(new b(hVar));
        } else if (this.R3) {
            k(1);
            executor.execute(new a(hVar));
        } else {
            if (this.U3) {
                z = false;
            }
            i.a(z, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.engine.h.b
    public void b(u<R> uVar, DataSource dataSource, boolean z) {
        synchronized (this) {
            this.N3 = uVar;
            this.O3 = dataSource;
            this.V3 = z;
        }
        o();
    }

    @Override // com.bumptech.glide.load.engine.h.b
    public void c(GlideException glideException) {
        synchronized (this) {
            this.Q3 = glideException;
        }
        n();
    }

    @Override // com.bumptech.glide.util.k.a.f
    @NonNull
    public com.bumptech.glide.util.k.c d() {
        return this.f1480f;
    }

    @Override // com.bumptech.glide.load.engine.h.b
    public void e(h<?> hVar) {
        j().execute(hVar);
    }

    @GuardedBy("this")
    void f(com.bumptech.glide.request.h hVar) {
        try {
            hVar.c(this.Q3);
        } catch (Throwable th) {
            throw new b(th);
        }
    }

    @GuardedBy("this")
    void g(com.bumptech.glide.request.h hVar) {
        try {
            hVar.b(this.S3, this.O3, this.V3);
        } catch (Throwable th) {
            throw new b(th);
        }
    }

    void h() {
        if (!m()) {
            this.U3 = true;
            this.T3.b();
            this.z.c(this, this.I3);
        }
    }

    void i() {
        p<?> pVar;
        synchronized (this) {
            this.f1480f.c();
            i.a(m(), "Not yet complete!");
            int decrementAndGet = this.H3.decrementAndGet();
            i.a(decrementAndGet >= 0, "Can't decrement below 0");
            if (decrementAndGet == 0) {
                pVar = this.S3;
                q();
            } else {
                pVar = null;
            }
        }
        if (pVar != null) {
            pVar.g();
        }
    }

    synchronized void k(int i) {
        p<?> pVar;
        i.a(m(), "Not yet complete!");
        if (this.H3.getAndAdd(i) == 0 && (pVar = this.S3) != null) {
            pVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public synchronized l<R> l(com.bumptech.glide.load.c cVar, boolean z, boolean z2, boolean z3, boolean z4) {
        this.I3 = cVar;
        this.J3 = z;
        this.K3 = z2;
        this.L3 = z3;
        this.M3 = z4;
        return this;
    }

    void n() {
        synchronized (this) {
            this.f1480f.c();
            if (this.U3) {
                q();
            } else if (this.f1479d.isEmpty()) {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            } else if (!this.R3) {
                this.R3 = true;
                com.bumptech.glide.load.c cVar = this.I3;
                e c2 = this.f1479d.c();
                k(c2.size() + 1);
                this.z.b(this, cVar, null);
                Iterator<d> it = c2.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    next.f1485b.execute(new a(next.a));
                }
                i();
            } else {
                throw new IllegalStateException("Already failed once");
            }
        }
    }

    void o() {
        synchronized (this) {
            this.f1480f.c();
            if (this.U3) {
                this.N3.c();
                q();
            } else if (this.f1479d.isEmpty()) {
                throw new IllegalStateException("Received a resource without any callbacks to notify");
            } else if (!this.P3) {
                this.S3 = this.y.a(this.N3, this.J3, this.I3, this.q);
                this.P3 = true;
                e c2 = this.f1479d.c();
                k(c2.size() + 1);
                this.z.b(this, this.I3, this.S3);
                Iterator<d> it = c2.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    next.f1485b.execute(new b(next.a));
                }
                i();
            } else {
                throw new IllegalStateException("Already have resource");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p() {
        return this.M3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void r(com.bumptech.glide.request.h hVar) {
        boolean z;
        this.f1480f.c();
        this.f1479d.e(hVar);
        if (this.f1479d.isEmpty()) {
            h();
            if (!this.P3 && !this.R3) {
                z = false;
                if (z && this.H3.get() == 0) {
                    q();
                }
            }
            z = true;
            if (z) {
                q();
            }
        }
    }

    public synchronized void s(h<R> hVar) {
        this.T3 = hVar;
        (hVar.C() ? this.p0 : j()).execute(hVar);
    }

    @VisibleForTesting
    l(com.bumptech.glide.load.engine.b0.a aVar, com.bumptech.glide.load.engine.b0.a aVar2, com.bumptech.glide.load.engine.b0.a aVar3, com.bumptech.glide.load.engine.b0.a aVar4, m mVar, p.a aVar5, Pools.Pool<l<?>> pool, c cVar) {
        this.f1479d = new e();
        this.f1480f = com.bumptech.glide.util.k.c.a();
        this.H3 = new AtomicInteger();
        this.p0 = aVar;
        this.p1 = aVar2;
        this.p2 = aVar3;
        this.p3 = aVar4;
        this.z = mVar;
        this.q = aVar5;
        this.x = pool;
        this.y = cVar;
    }
}
