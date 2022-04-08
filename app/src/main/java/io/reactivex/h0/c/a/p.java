package io.reactivex.h0.c.a;

import io.reactivex.c;
import io.reactivex.e;
import io.reactivex.w;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: CompletableTimeout.java */
/* loaded from: classes4.dex */
public final class p extends io.reactivex.a {

    /* renamed from: c  reason: collision with root package name */
    final e f15701c;

    /* renamed from: d  reason: collision with root package name */
    final long f15702d;

    /* renamed from: f  reason: collision with root package name */
    final TimeUnit f15703f;
    final w q;
    final e x;

    /* compiled from: CompletableTimeout.java */
    /* loaded from: classes4.dex */
    final class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        private final AtomicBoolean f15704c;

        /* renamed from: d  reason: collision with root package name */
        final io.reactivex.e0.b f15705d;

        /* renamed from: f  reason: collision with root package name */
        final c f15706f;

        /* compiled from: CompletableTimeout.java */
        /* renamed from: io.reactivex.h0.c.a.p$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        final class C0294a implements c {
            C0294a() {
            }

            @Override // io.reactivex.c
            public void onComplete() {
                a.this.f15705d.dispose();
                a.this.f15706f.onComplete();
            }

            @Override // io.reactivex.c
            public void onError(Throwable th) {
                a.this.f15705d.dispose();
                a.this.f15706f.onError(th);
            }

            @Override // io.reactivex.c
            public void onSubscribe(io.reactivex.e0.c cVar) {
                a.this.f15705d.b(cVar);
            }
        }

        a(AtomicBoolean atomicBoolean, io.reactivex.e0.b bVar, c cVar) {
            this.f15704c = atomicBoolean;
            this.f15705d = bVar;
            this.f15706f = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f15704c.compareAndSet(false, true)) {
                this.f15705d.d();
                e eVar = p.this.x;
                if (eVar == null) {
                    c cVar = this.f15706f;
                    p pVar = p.this;
                    cVar.onError(new TimeoutException(io.reactivex.internal.util.e.d(pVar.f15702d, pVar.f15703f)));
                    return;
                }
                eVar.a(new C0294a());
            }
        }
    }

    /* compiled from: CompletableTimeout.java */
    /* loaded from: classes4.dex */
    static final class b implements c {

        /* renamed from: c  reason: collision with root package name */
        private final io.reactivex.e0.b f15708c;

        /* renamed from: d  reason: collision with root package name */
        private final AtomicBoolean f15709d;

        /* renamed from: f  reason: collision with root package name */
        private final c f15710f;

        b(io.reactivex.e0.b bVar, AtomicBoolean atomicBoolean, c cVar) {
            this.f15708c = bVar;
            this.f15709d = atomicBoolean;
            this.f15710f = cVar;
        }

        @Override // io.reactivex.c
        public void onComplete() {
            if (this.f15709d.compareAndSet(false, true)) {
                this.f15708c.dispose();
                this.f15710f.onComplete();
            }
        }

        @Override // io.reactivex.c
        public void onError(Throwable th) {
            if (this.f15709d.compareAndSet(false, true)) {
                this.f15708c.dispose();
                this.f15710f.onError(th);
                return;
            }
            io.reactivex.j0.a.r(th);
        }

        @Override // io.reactivex.c
        public void onSubscribe(io.reactivex.e0.c cVar) {
            this.f15708c.b(cVar);
        }
    }

    public p(e eVar, long j, TimeUnit timeUnit, w wVar, e eVar2) {
        this.f15701c = eVar;
        this.f15702d = j;
        this.f15703f = timeUnit;
        this.q = wVar;
        this.x = eVar2;
    }

    @Override // io.reactivex.a
    public void B(c cVar) {
        io.reactivex.e0.b bVar = new io.reactivex.e0.b();
        cVar.onSubscribe(bVar);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        bVar.b(this.q.d(new a(atomicBoolean, bVar, cVar), this.f15702d, this.f15703f));
        this.f15701c.a(new b(bVar, atomicBoolean, cVar));
    }
}
