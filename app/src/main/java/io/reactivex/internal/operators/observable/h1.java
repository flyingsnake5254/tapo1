package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.g0.j;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.v;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableZip.java */
/* loaded from: classes4.dex */
public final class h1<T, R> extends q<R> {

    /* renamed from: c  reason: collision with root package name */
    final t<? extends T>[] f15995c;

    /* renamed from: d  reason: collision with root package name */
    final Iterable<? extends t<? extends T>> f15996d;

    /* renamed from: f  reason: collision with root package name */
    final j<? super Object[], ? extends R> f15997f;
    final int q;
    final boolean x;

    /* compiled from: ObservableZip.java */
    /* loaded from: classes4.dex */
    static final class a<T, R> extends AtomicInteger implements c {

        /* renamed from: c  reason: collision with root package name */
        final v<? super R> f15998c;

        /* renamed from: d  reason: collision with root package name */
        final j<? super Object[], ? extends R> f15999d;

        /* renamed from: f  reason: collision with root package name */
        final b<T, R>[] f16000f;
        final T[] q;
        final boolean x;
        volatile boolean y;

        a(v<? super R> vVar, j<? super Object[], ? extends R> jVar, int i, boolean z) {
            this.f15998c = vVar;
            this.f15999d = jVar;
            this.f16000f = new b[i];
            this.q = (T[]) new Object[i];
            this.x = z;
        }

        void a() {
            f();
            b();
        }

        void b() {
            for (b<T, R> bVar : this.f16000f) {
                bVar.a();
            }
        }

        boolean d(boolean z, boolean z2, v<? super R> vVar, boolean z3, b<?, ?> bVar) {
            if (this.y) {
                a();
                return true;
            } else if (!z) {
                return false;
            } else {
                if (!z3) {
                    Throwable th = bVar.q;
                    if (th != null) {
                        this.y = true;
                        a();
                        vVar.onError(th);
                        return true;
                    } else if (!z2) {
                        return false;
                    } else {
                        this.y = true;
                        a();
                        vVar.onComplete();
                        return true;
                    }
                } else if (!z2) {
                    return false;
                } else {
                    Throwable th2 = bVar.q;
                    this.y = true;
                    a();
                    if (th2 != null) {
                        vVar.onError(th2);
                    } else {
                        vVar.onComplete();
                    }
                    return true;
                }
            }
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            if (!this.y) {
                this.y = true;
                b();
                if (getAndIncrement() == 0) {
                    f();
                }
            }
        }

        void f() {
            for (b<T, R> bVar : this.f16000f) {
                bVar.f16002d.clear();
            }
        }

        public void g() {
            Throwable th;
            if (getAndIncrement() == 0) {
                b<T, R>[] bVarArr = this.f16000f;
                v<? super R> vVar = this.f15998c;
                T[] tArr = this.q;
                boolean z = this.x;
                int i = 1;
                while (true) {
                    int i2 = 0;
                    int i3 = 0;
                    for (b<T, R> bVar : bVarArr) {
                        if (tArr[i3] == null) {
                            boolean z2 = bVar.f16003f;
                            T poll = bVar.f16002d.poll();
                            boolean z3 = poll == null;
                            if (d(z2, z3, vVar, z, bVar)) {
                                return;
                            }
                            if (!z3) {
                                tArr[i3] = poll;
                            } else {
                                i2++;
                            }
                        } else if (bVar.f16003f && !z && (th = bVar.q) != null) {
                            this.y = true;
                            a();
                            vVar.onError(th);
                            return;
                        }
                        i3++;
                    }
                    if (i2 != 0) {
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        try {
                            vVar.onNext((Object) io.reactivex.h0.a.b.e(this.f15999d.apply(tArr.clone()), "The zipper returned a null value"));
                            Arrays.fill(tArr, (Object) null);
                        } catch (Throwable th2) {
                            io.reactivex.exceptions.a.b(th2);
                            a();
                            vVar.onError(th2);
                            return;
                        }
                    }
                }
            }
        }

        public void h(t<? extends T>[] tVarArr, int i) {
            b<T, R>[] bVarArr = this.f16000f;
            int length = bVarArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                bVarArr[i2] = new b<>(this, i);
            }
            lazySet(0);
            this.f15998c.onSubscribe(this);
            for (int i3 = 0; i3 < length && !this.y; i3++) {
                tVarArr[i3].a(bVarArr[i3]);
            }
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return this.y;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableZip.java */
    /* loaded from: classes4.dex */
    public static final class b<T, R> implements v<T> {

        /* renamed from: c  reason: collision with root package name */
        final a<T, R> f16001c;

        /* renamed from: d  reason: collision with root package name */
        final io.reactivex.internal.queue.b<T> f16002d;

        /* renamed from: f  reason: collision with root package name */
        volatile boolean f16003f;
        Throwable q;
        final AtomicReference<c> x = new AtomicReference<>();

        b(a<T, R> aVar, int i) {
            this.f16001c = aVar;
            this.f16002d = new io.reactivex.internal.queue.b<>(i);
        }

        public void a() {
            DisposableHelper.dispose(this.x);
        }

        @Override // io.reactivex.v
        public void onComplete() {
            this.f16003f = true;
            this.f16001c.g();
        }

        @Override // io.reactivex.v
        public void onError(Throwable th) {
            this.q = th;
            this.f16003f = true;
            this.f16001c.g();
        }

        @Override // io.reactivex.v
        public void onNext(T t) {
            this.f16002d.offer(t);
            this.f16001c.g();
        }

        @Override // io.reactivex.v
        public void onSubscribe(c cVar) {
            DisposableHelper.setOnce(this.x, cVar);
        }
    }

    public h1(t<? extends T>[] tVarArr, Iterable<? extends t<? extends T>> iterable, j<? super Object[], ? extends R> jVar, int i, boolean z) {
        this.f15995c = tVarArr;
        this.f15996d = iterable;
        this.f15997f = jVar;
        this.q = i;
        this.x = z;
    }

    @Override // io.reactivex.q
    public void K0(v<? super R> vVar) {
        int i;
        t<? extends T>[] tVarArr = this.f15995c;
        if (tVarArr == null) {
            tVarArr = new t[8];
            i = 0;
            for (t<? extends T> tVar : this.f15996d) {
                if (i == tVarArr.length) {
                    t<? extends T>[] tVarArr2 = new t[(i >> 2) + i];
                    System.arraycopy(tVarArr, 0, tVarArr2, 0, i);
                    tVarArr = tVarArr2;
                }
                i++;
                tVarArr[i] = tVar;
            }
        } else {
            i = tVarArr.length;
        }
        if (i == 0) {
            EmptyDisposable.complete(vVar);
        } else {
            new a(vVar, this.f15997f, i, this.x).h(tVarArr, this.q);
        }
    }
}
