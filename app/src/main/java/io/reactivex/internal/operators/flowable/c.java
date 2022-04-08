package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureStrategy;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.i;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableCreate.java */
/* loaded from: classes4.dex */
public final class c<T> extends io.reactivex.h<T> {

    /* renamed from: d  reason: collision with root package name */
    final j<T> f15779d;

    /* renamed from: f  reason: collision with root package name */
    final BackpressureStrategy f15780f;

    /* compiled from: FlowableCreate.java */
    /* loaded from: classes4.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[BackpressureStrategy.values().length];
            a = iArr;
            try {
                iArr[BackpressureStrategy.MISSING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BackpressureStrategy.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[BackpressureStrategy.DROP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[BackpressureStrategy.LATEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableCreate.java */
    /* loaded from: classes4.dex */
    public static abstract class b<T> extends AtomicLong implements i<T>, e.b.c {

        /* renamed from: c  reason: collision with root package name */
        final e.b.b<? super T> f15781c;

        /* renamed from: d  reason: collision with root package name */
        final SequentialDisposable f15782d = new SequentialDisposable();

        b(e.b.b<? super T> bVar) {
            this.f15781c = bVar;
        }

        @Override // io.reactivex.i
        public final void a(io.reactivex.e0.c cVar) {
            this.f15782d.update(cVar);
        }

        protected void b() {
            if (!isCancelled()) {
                try {
                    this.f15781c.onComplete();
                } finally {
                    this.f15782d.dispose();
                }
            }
        }

        @Override // e.b.c
        public final void cancel() {
            this.f15782d.dispose();
            g();
        }

        /* JADX WARN: Finally extract failed */
        protected boolean d(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (isCancelled()) {
                return false;
            }
            try {
                this.f15781c.onError(th);
                this.f15782d.dispose();
                return true;
            } catch (Throwable th2) {
                this.f15782d.dispose();
                throw th2;
            }
        }

        void f() {
        }

        void g() {
        }

        public boolean h(Throwable th) {
            return d(th);
        }

        @Override // io.reactivex.i
        public final boolean isCancelled() {
            return this.f15782d.isDisposed();
        }

        @Override // io.reactivex.g
        public void onComplete() {
            b();
        }

        @Override // io.reactivex.g
        public final void onError(Throwable th) {
            if (!h(th)) {
                io.reactivex.j0.a.r(th);
            }
        }

        @Override // e.b.c
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this, j);
                f();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public String toString() {
            return String.format("%s{%s}", getClass().getSimpleName(), super.toString());
        }
    }

    /* compiled from: FlowableCreate.java */
    /* renamed from: io.reactivex.internal.operators.flowable.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static final class C0298c<T> extends b<T> {

        /* renamed from: f  reason: collision with root package name */
        final io.reactivex.internal.queue.b<T> f15783f;
        Throwable q;
        volatile boolean x;
        final AtomicInteger y = new AtomicInteger();

        C0298c(e.b.b<? super T> bVar, int i) {
            super(bVar);
            this.f15783f = new io.reactivex.internal.queue.b<>(i);
        }

        @Override // io.reactivex.internal.operators.flowable.c.b
        void f() {
            i();
        }

        @Override // io.reactivex.internal.operators.flowable.c.b
        void g() {
            if (this.y.getAndIncrement() == 0) {
                this.f15783f.clear();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.c.b
        public boolean h(Throwable th) {
            if (this.x || isCancelled()) {
                return false;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.q = th;
            this.x = true;
            i();
            return true;
        }

        void i() {
            int i;
            if (this.y.getAndIncrement() == 0) {
                e.b.b<? super T> bVar = this.f15781c;
                io.reactivex.internal.queue.b<T> bVar2 = this.f15783f;
                int i2 = 1;
                do {
                    long j = get();
                    long j2 = 0;
                    while (true) {
                        i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i == 0) {
                            break;
                        } else if (isCancelled()) {
                            bVar2.clear();
                            return;
                        } else {
                            boolean z = this.x;
                            Object obj = (T) bVar2.poll();
                            boolean z2 = obj == null;
                            if (z && z2) {
                                Throwable th = this.q;
                                if (th != null) {
                                    d(th);
                                    return;
                                } else {
                                    b();
                                    return;
                                }
                            } else if (z2) {
                                break;
                            } else {
                                bVar.onNext(obj);
                                j2++;
                            }
                        }
                    }
                    if (i == 0) {
                        if (isCancelled()) {
                            bVar2.clear();
                            return;
                        }
                        boolean z3 = this.x;
                        boolean isEmpty = bVar2.isEmpty();
                        if (z3 && isEmpty) {
                            Throwable th2 = this.q;
                            if (th2 != null) {
                                d(th2);
                                return;
                            } else {
                                b();
                                return;
                            }
                        }
                    }
                    if (j2 != 0) {
                        io.reactivex.internal.util.b.c(this, j2);
                    }
                    i2 = this.y.addAndGet(-i2);
                } while (i2 != 0);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.c.b, io.reactivex.g
        public void onComplete() {
            this.x = true;
            i();
        }

        @Override // io.reactivex.g
        public void onNext(T t) {
            if (!this.x && !isCancelled()) {
                if (t == null) {
                    onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                    return;
                }
                this.f15783f.offer(t);
                i();
            }
        }
    }

    /* compiled from: FlowableCreate.java */
    /* loaded from: classes4.dex */
    static final class d<T> extends h<T> {
        d(e.b.b<? super T> bVar) {
            super(bVar);
        }

        @Override // io.reactivex.internal.operators.flowable.c.h
        void i() {
        }
    }

    /* compiled from: FlowableCreate.java */
    /* loaded from: classes4.dex */
    static final class e<T> extends h<T> {
        e(e.b.b<? super T> bVar) {
            super(bVar);
        }

        @Override // io.reactivex.internal.operators.flowable.c.h
        void i() {
            onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
        }
    }

    /* compiled from: FlowableCreate.java */
    /* loaded from: classes4.dex */
    static final class f<T> extends b<T> {
        Throwable q;
        volatile boolean x;

        /* renamed from: f  reason: collision with root package name */
        final AtomicReference<T> f15784f = new AtomicReference<>();
        final AtomicInteger y = new AtomicInteger();

        f(e.b.b<? super T> bVar) {
            super(bVar);
        }

        @Override // io.reactivex.internal.operators.flowable.c.b
        void f() {
            i();
        }

        @Override // io.reactivex.internal.operators.flowable.c.b
        void g() {
            if (this.y.getAndIncrement() == 0) {
                this.f15784f.lazySet(null);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.c.b
        public boolean h(Throwable th) {
            if (this.x || isCancelled()) {
                return false;
            }
            if (th == null) {
                onError(new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."));
            }
            this.q = th;
            this.x = true;
            i();
            return true;
        }

        void i() {
            boolean z;
            int i;
            if (this.y.getAndIncrement() == 0) {
                e.b.b<? super T> bVar = this.f15781c;
                AtomicReference<T> atomicReference = this.f15784f;
                int i2 = 1;
                do {
                    long j = get();
                    long j2 = 0;
                    while (true) {
                        z = false;
                        i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i == 0) {
                            break;
                        } else if (isCancelled()) {
                            atomicReference.lazySet(null);
                            return;
                        } else {
                            boolean z2 = this.x;
                            Object obj = (T) atomicReference.getAndSet(null);
                            boolean z3 = obj == null;
                            if (z2 && z3) {
                                Throwable th = this.q;
                                if (th != null) {
                                    d(th);
                                    return;
                                } else {
                                    b();
                                    return;
                                }
                            } else if (z3) {
                                break;
                            } else {
                                bVar.onNext(obj);
                                j2++;
                            }
                        }
                    }
                    if (i == 0) {
                        if (isCancelled()) {
                            atomicReference.lazySet(null);
                            return;
                        }
                        boolean z4 = this.x;
                        if (atomicReference.get() == null) {
                            z = true;
                        }
                        if (z4 && z) {
                            Throwable th2 = this.q;
                            if (th2 != null) {
                                d(th2);
                                return;
                            } else {
                                b();
                                return;
                            }
                        }
                    }
                    if (j2 != 0) {
                        io.reactivex.internal.util.b.c(this, j2);
                    }
                    i2 = this.y.addAndGet(-i2);
                } while (i2 != 0);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.c.b, io.reactivex.g
        public void onComplete() {
            this.x = true;
            i();
        }

        @Override // io.reactivex.g
        public void onNext(T t) {
            if (!this.x && !isCancelled()) {
                if (t == null) {
                    onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                    return;
                }
                this.f15784f.set(t);
                i();
            }
        }
    }

    /* compiled from: FlowableCreate.java */
    /* loaded from: classes4.dex */
    static final class g<T> extends b<T> {
        g(e.b.b<? super T> bVar) {
            super(bVar);
        }

        @Override // io.reactivex.g
        public void onNext(T t) {
            long j;
            if (!isCancelled()) {
                if (t != null) {
                    this.f15781c.onNext(t);
                    do {
                        j = get();
                        if (j == 0) {
                            return;
                        }
                    } while (!compareAndSet(j, j - 1));
                    return;
                }
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            }
        }
    }

    /* compiled from: FlowableCreate.java */
    /* loaded from: classes4.dex */
    static abstract class h<T> extends b<T> {
        h(e.b.b<? super T> bVar) {
            super(bVar);
        }

        abstract void i();

        @Override // io.reactivex.g
        public final void onNext(T t) {
            if (!isCancelled()) {
                if (t == null) {
                    onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                } else if (get() != 0) {
                    this.f15781c.onNext(t);
                    io.reactivex.internal.util.b.c(this, 1L);
                } else {
                    i();
                }
            }
        }
    }

    public c(j<T> jVar, BackpressureStrategy backpressureStrategy) {
        this.f15779d = jVar;
        this.f15780f = backpressureStrategy;
    }

    @Override // io.reactivex.h
    public void H(e.b.b<? super T> bVar) {
        b bVar2;
        int i = a.a[this.f15780f.ordinal()];
        if (i == 1) {
            bVar2 = new g(bVar);
        } else if (i == 2) {
            bVar2 = new e(bVar);
        } else if (i == 3) {
            bVar2 = new d(bVar);
        } else if (i != 4) {
            bVar2 = new C0298c(bVar, io.reactivex.h.c());
        } else {
            bVar2 = new f(bVar);
        }
        bVar.onSubscribe(bVar2);
        try {
            this.f15779d.subscribe(bVar2);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            bVar2.onError(th);
        }
    }
}
