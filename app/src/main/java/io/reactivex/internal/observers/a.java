package io.reactivex.internal.observers;

import io.reactivex.e0.c;
import io.reactivex.h0.b.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.v;

/* compiled from: BasicFuseableObserver.java */
/* loaded from: classes4.dex */
public abstract class a<T, R> implements v<T>, d<R> {

    /* renamed from: c  reason: collision with root package name */
    protected final v<? super R> f15749c;

    /* renamed from: d  reason: collision with root package name */
    protected c f15750d;

    /* renamed from: f  reason: collision with root package name */
    protected d<T> f15751f;
    protected boolean q;
    protected int x;

    public a(v<? super R> vVar) {
        this.f15749c = vVar;
    }

    protected void a() {
    }

    protected boolean b() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(Throwable th) {
        io.reactivex.exceptions.a.b(th);
        this.f15750d.dispose();
        onError(th);
    }

    @Override // io.reactivex.h0.b.i
    public void clear() {
        this.f15751f.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int d(int i) {
        d<T> dVar = this.f15751f;
        if (dVar == null || (i & 4) != 0) {
            return 0;
        }
        int requestFusion = dVar.requestFusion(i);
        if (requestFusion != 0) {
            this.x = requestFusion;
        }
        return requestFusion;
    }

    @Override // io.reactivex.e0.c
    public void dispose() {
        this.f15750d.dispose();
    }

    @Override // io.reactivex.e0.c
    public boolean isDisposed() {
        return this.f15750d.isDisposed();
    }

    @Override // io.reactivex.h0.b.i
    public boolean isEmpty() {
        return this.f15751f.isEmpty();
    }

    @Override // io.reactivex.h0.b.i
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.v
    public void onComplete() {
        if (!this.q) {
            this.q = true;
            this.f15749c.onComplete();
        }
    }

    @Override // io.reactivex.v
    public void onError(Throwable th) {
        if (this.q) {
            io.reactivex.j0.a.r(th);
            return;
        }
        this.q = true;
        this.f15749c.onError(th);
    }

    @Override // io.reactivex.v
    public final void onSubscribe(c cVar) {
        if (DisposableHelper.validate(this.f15750d, cVar)) {
            this.f15750d = cVar;
            if (cVar instanceof d) {
                this.f15751f = (d) cVar;
            }
            if (b()) {
                this.f15749c.onSubscribe(this);
                a();
            }
        }
    }
}
