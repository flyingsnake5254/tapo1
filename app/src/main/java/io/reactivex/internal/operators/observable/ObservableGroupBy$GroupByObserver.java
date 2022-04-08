package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.g0.j;
import io.reactivex.h0.a.b;
import io.reactivex.i0.a;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.v;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class ObservableGroupBy$GroupByObserver<T, K, V> extends AtomicInteger implements v<T>, c {
    static final Object NULL_KEY = new Object();
    private static final long serialVersionUID = -3688291656102519502L;
    final int bufferSize;
    final boolean delayError;
    final v<? super a<K, V>> downstream;
    final j<? super T, ? extends K> keySelector;
    c upstream;
    final j<? super T, ? extends V> valueSelector;
    final AtomicBoolean cancelled = new AtomicBoolean();
    final Map<Object, b0<K, V>> groups = new ConcurrentHashMap();

    public ObservableGroupBy$GroupByObserver(v<? super a<K, V>> vVar, j<? super T, ? extends K> jVar, j<? super T, ? extends V> jVar2, int i, boolean z) {
        this.downstream = vVar;
        this.keySelector = jVar;
        this.valueSelector = jVar2;
        this.bufferSize = i;
        this.delayError = z;
        lazySet(1);
    }

    public void cancel(K k) {
        if (k == null) {
            k = (K) NULL_KEY;
        }
        this.groups.remove(k);
        if (decrementAndGet() == 0) {
            this.upstream.dispose();
        }
    }

    @Override // io.reactivex.e0.c
    public void dispose() {
        if (this.cancelled.compareAndSet(false, true) && decrementAndGet() == 0) {
            this.upstream.dispose();
        }
    }

    @Override // io.reactivex.e0.c
    public boolean isDisposed() {
        return this.cancelled.get();
    }

    @Override // io.reactivex.v
    public void onComplete() {
        ArrayList<b0> arrayList = new ArrayList(this.groups.values());
        this.groups.clear();
        for (b0 b0Var : arrayList) {
            b0Var.onComplete();
        }
        this.downstream.onComplete();
    }

    @Override // io.reactivex.v
    public void onError(Throwable th) {
        ArrayList<b0> arrayList = new ArrayList(this.groups.values());
        this.groups.clear();
        for (b0 b0Var : arrayList) {
            b0Var.onError(th);
        }
        this.downstream.onError(th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.v
    public void onNext(T t) {
        try {
            Object apply = this.keySelector.apply(t);
            Object obj = apply != null ? apply : NULL_KEY;
            b0<K, V> b0Var = this.groups.get(obj);
            if (b0Var == null) {
                if (!this.cancelled.get()) {
                    b0Var = b0.j1(apply, this.bufferSize, this, this.delayError);
                    this.groups.put(obj, b0Var);
                    getAndIncrement();
                    this.downstream.onNext(b0Var);
                } else {
                    return;
                }
            }
            try {
                b0Var.onNext(b.e(this.valueSelector.apply(t), "The value supplied is null"));
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.upstream.dispose();
                onError(th);
            }
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            this.upstream.dispose();
            onError(th2);
        }
    }

    @Override // io.reactivex.v
    public void onSubscribe(c cVar) {
        if (DisposableHelper.validate(this.upstream, cVar)) {
            this.upstream = cVar;
            this.downstream.onSubscribe(this);
        }
    }
}
