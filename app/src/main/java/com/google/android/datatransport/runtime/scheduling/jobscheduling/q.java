package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.h.n;
import com.google.android.datatransport.h.x.j.e0;
import com.google.android.datatransport.h.x.j.y;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.e;
import com.google.android.datatransport.runtime.backends.f;
import com.google.android.datatransport.runtime.backends.l;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.a;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: Uploader.java */
/* loaded from: classes.dex */
public class q {
    private final Context a;

    /* renamed from: b  reason: collision with root package name */
    private final e f1988b;

    /* renamed from: c  reason: collision with root package name */
    private final y f1989c;

    /* renamed from: d  reason: collision with root package name */
    private final u f1990d;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f1991e;

    /* renamed from: f  reason: collision with root package name */
    private final a f1992f;
    private final com.google.android.datatransport.h.y.a g;

    public q(Context context, e eVar, y yVar, u uVar, Executor executor, a aVar, com.google.android.datatransport.h.y.a aVar2) {
        this.a = context;
        this.f1988b = eVar;
        this.f1989c = yVar;
        this.f1990d = uVar;
        this.f1991e = executor;
        this.f1992f = aVar;
        this.g = aVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ Boolean c(n nVar) {
        return Boolean.valueOf(this.f1989c.n(nVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ Iterable e(n nVar) {
        return this.f1989c.p(nVar);
    }

    private /* synthetic */ Object f(Iterable iterable, n nVar, long j) {
        this.f1989c.o(iterable);
        this.f1989c.f(nVar, this.g.a() + j);
        return null;
    }

    private /* synthetic */ Object h(Iterable iterable) {
        this.f1989c.d(iterable);
        return null;
    }

    private /* synthetic */ Object j(n nVar, long j) {
        this.f1989c.f(nVar, this.g.a() + j);
        return null;
    }

    private /* synthetic */ Object l(n nVar, int i) {
        this.f1990d.a(nVar, i + 1);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public /* synthetic */ void o(final n nVar, final int i, Runnable runnable) {
        try {
            try {
                a aVar = this.f1992f;
                final y yVar = this.f1989c;
                Objects.requireNonNull(yVar);
                aVar.a(new a.AbstractC0073a() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.b
                    @Override // com.google.android.datatransport.runtime.synchronization.a.AbstractC0073a
                    public final Object execute() {
                        return Integer.valueOf(y.this.b());
                    }
                });
                if (!a()) {
                    this.f1992f.a(new a.AbstractC0073a() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.j
                        @Override // com.google.android.datatransport.runtime.synchronization.a.AbstractC0073a
                        public final Object execute() {
                            q.this.m(nVar, i);
                            return null;
                        }
                    });
                } else {
                    p(nVar, i);
                }
            } catch (SynchronizationException unused) {
                this.f1990d.a(nVar, i + 1);
            }
        } finally {
            runnable.run();
        }
    }

    boolean a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public /* synthetic */ Object g(Iterable iterable, n nVar, long j) {
        f(iterable, nVar, j);
        return null;
    }

    public /* synthetic */ Object i(Iterable iterable) {
        h(iterable);
        return null;
    }

    public /* synthetic */ Object k(n nVar, long j) {
        j(nVar, j);
        return null;
    }

    public /* synthetic */ Object m(n nVar, int i) {
        l(nVar, i);
        return null;
    }

    void p(final n nVar, int i) {
        BackendResponse backendResponse;
        l lVar = this.f1988b.get(nVar.b());
        final long j = 0;
        while (true) {
            while (((Boolean) this.f1992f.a(new a.AbstractC0073a() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.e
                @Override // com.google.android.datatransport.runtime.synchronization.a.AbstractC0073a
                public final Object execute() {
                    return q.this.c(nVar);
                }
            })).booleanValue()) {
                final Iterable<e0> iterable = (Iterable) this.f1992f.a(new a.AbstractC0073a() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.f
                    @Override // com.google.android.datatransport.runtime.synchronization.a.AbstractC0073a
                    public final Object execute() {
                        return q.this.e(nVar);
                    }
                });
                if (iterable.iterator().hasNext()) {
                    if (lVar == null) {
                        com.google.android.datatransport.h.v.a.a("Uploader", "Unknown backend for %s, deleting event batch for it...", nVar);
                        backendResponse = BackendResponse.a();
                    } else {
                        ArrayList arrayList = new ArrayList();
                        for (e0 e0Var : iterable) {
                            arrayList.add(e0Var.b());
                        }
                        backendResponse = lVar.b(f.a().b(arrayList).c(nVar.c()).a());
                    }
                    if (backendResponse.c() != BackendResponse.Status.TRANSIENT_ERROR) {
                        this.f1992f.a(new a.AbstractC0073a() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.i
                            @Override // com.google.android.datatransport.runtime.synchronization.a.AbstractC0073a
                            public final Object execute() {
                                q.this.i(iterable);
                                return null;
                            }
                        });
                        if (backendResponse.c() == BackendResponse.Status.OK) {
                            break;
                        }
                    } else {
                        this.f1992f.a(new a.AbstractC0073a() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.g
                            @Override // com.google.android.datatransport.runtime.synchronization.a.AbstractC0073a
                            public final Object execute() {
                                q.this.g(iterable, nVar, j);
                                return null;
                            }
                        });
                        this.f1990d.b(nVar, i + 1, true);
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f1992f.a(new a.AbstractC0073a() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.h
                @Override // com.google.android.datatransport.runtime.synchronization.a.AbstractC0073a
                public final Object execute() {
                    q.this.k(nVar, j);
                    return null;
                }
            });
            return;
            j = Math.max(j, backendResponse.b());
        }
    }

    public void q(final n nVar, final int i, final Runnable runnable) {
        this.f1991e.execute(new Runnable() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.d
            @Override // java.lang.Runnable
            public final void run() {
                q.this.o(nVar, i, runnable);
            }
        });
    }
}
