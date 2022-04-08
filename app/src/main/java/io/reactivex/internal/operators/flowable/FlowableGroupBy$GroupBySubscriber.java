package io.reactivex.internal.operators.flowable;

import e.b.b;
import e.b.c;
import io.reactivex.f0.a;
import io.reactivex.g0.j;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.k;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes4.dex */
public final class FlowableGroupBy$GroupBySubscriber<T, K, V> extends BasicIntQueueSubscription<a<K, V>> implements k<T> {
    static final Object NULL_KEY = new Object();
    private static final long serialVersionUID = -3688291656102519502L;
    final int bufferSize;
    final boolean delayError;
    boolean done;
    final b<? super a<K, V>> downstream;
    Throwable error;
    final Queue<n<K, V>> evictedGroups;
    volatile boolean finished;
    final Map<Object, n<K, V>> groups;
    final j<? super T, ? extends K> keySelector;
    boolean outputFused;
    final io.reactivex.internal.queue.b<a<K, V>> queue;
    c upstream;
    final j<? super T, ? extends V> valueSelector;
    final AtomicBoolean cancelled = new AtomicBoolean();
    final AtomicLong requested = new AtomicLong();
    final AtomicInteger groupCount = new AtomicInteger(1);

    public FlowableGroupBy$GroupBySubscriber(b<? super a<K, V>> bVar, j<? super T, ? extends K> jVar, j<? super T, ? extends V> jVar2, int i, boolean z, Map<Object, n<K, V>> map, Queue<n<K, V>> queue) {
        this.downstream = bVar;
        this.keySelector = jVar;
        this.valueSelector = jVar2;
        this.bufferSize = i;
        this.delayError = z;
        this.groups = map;
        this.evictedGroups = queue;
        this.queue = new io.reactivex.internal.queue.b<>(i);
    }

    private void completeEvictions() {
        if (this.evictedGroups != null) {
            int i = 0;
            while (true) {
                n<K, V> poll = this.evictedGroups.poll();
                if (poll == null) {
                    break;
                }
                poll.onComplete();
                i++;
            }
            if (i != 0) {
                this.groupCount.addAndGet(-i);
            }
        }
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, e.b.c
    public void cancel() {
        if (this.cancelled.compareAndSet(false, true)) {
            completeEvictions();
            if (this.groupCount.decrementAndGet() == 0) {
                this.upstream.cancel();
            }
        }
    }

    boolean checkTerminated(boolean z, boolean z2, b<?> bVar, io.reactivex.internal.queue.b<?> bVar2) {
        if (this.cancelled.get()) {
            bVar2.clear();
            return true;
        } else if (this.delayError) {
            if (!z || !z2) {
                return false;
            }
            Throwable th = this.error;
            if (th != null) {
                bVar.onError(th);
            } else {
                bVar.onComplete();
            }
            return true;
        } else if (!z) {
            return false;
        } else {
            Throwable th2 = this.error;
            if (th2 != null) {
                bVar2.clear();
                bVar.onError(th2);
                return true;
            } else if (!z2) {
                return false;
            } else {
                bVar.onComplete();
                return true;
            }
        }
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, io.reactivex.h0.b.i
    public void clear() {
        this.queue.clear();
    }

    void drain() {
        if (getAndIncrement() == 0) {
            if (this.outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }
    }

    void drainFused() {
        Throwable th;
        io.reactivex.internal.queue.b<a<K, V>> bVar = this.queue;
        b<? super a<K, V>> bVar2 = this.downstream;
        int i = 1;
        while (!this.cancelled.get()) {
            boolean z = this.finished;
            if (!z || this.delayError || (th = this.error) == null) {
                bVar2.onNext(null);
                if (z) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        bVar2.onError(th2);
                        return;
                    } else {
                        bVar2.onComplete();
                        return;
                    }
                } else {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            } else {
                bVar.clear();
                bVar2.onError(th);
                return;
            }
        }
    }

    void drainNormal() {
        int i;
        io.reactivex.internal.queue.b<a<K, V>> bVar = this.queue;
        b<? super a<K, V>> bVar2 = this.downstream;
        int i2 = 1;
        do {
            long j = this.requested.get();
            long j2 = 0;
            while (true) {
                i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                if (i == 0) {
                    break;
                }
                boolean z = this.finished;
                a<K, V> poll = bVar.poll();
                boolean z2 = poll == null;
                if (!checkTerminated(z, z2, bVar2, bVar)) {
                    if (z2) {
                        break;
                    }
                    bVar2.onNext(poll);
                    j2++;
                } else {
                    return;
                }
            }
            if (i != 0 || !checkTerminated(this.finished, bVar.isEmpty(), bVar2, bVar)) {
                if (j2 != 0) {
                    if (j != Long.MAX_VALUE) {
                        this.requested.addAndGet(-j2);
                    }
                    this.upstream.request(j2);
                }
                i2 = addAndGet(-i2);
            } else {
                return;
            }
        } while (i2 != 0);
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, io.reactivex.h0.b.i
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override // e.b.b
    public void onComplete() {
        if (!this.done) {
            for (n<K, V> nVar : this.groups.values()) {
                nVar.onComplete();
            }
            this.groups.clear();
            Queue<n<K, V>> queue = this.evictedGroups;
            if (queue != null) {
                queue.clear();
            }
            this.done = true;
            this.finished = true;
            drain();
        }
    }

    @Override // e.b.b
    public void onError(Throwable th) {
        if (this.done) {
            io.reactivex.j0.a.r(th);
            return;
        }
        this.done = true;
        for (n<K, V> nVar : this.groups.values()) {
            nVar.onError(th);
        }
        this.groups.clear();
        Queue<n<K, V>> queue = this.evictedGroups;
        if (queue != null) {
            queue.clear();
        }
        this.error = th;
        this.finished = true;
        drain();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e.b.b
    public void onNext(T t) {
        if (!this.done) {
            io.reactivex.internal.queue.b<a<K, V>> bVar = this.queue;
            try {
                Object apply = this.keySelector.apply(t);
                boolean z = false;
                Object obj = apply != null ? apply : NULL_KEY;
                n<K, V> nVar = this.groups.get(obj);
                if (nVar == null) {
                    if (!this.cancelled.get()) {
                        nVar = n.M(apply, this.bufferSize, this, this.delayError);
                        this.groups.put(obj, nVar);
                        this.groupCount.getAndIncrement();
                        z = true;
                    } else {
                        return;
                    }
                }
                try {
                    nVar.onNext(io.reactivex.h0.a.b.e(this.valueSelector.apply(t), "The valueSelector returned null"));
                    completeEvictions();
                    if (z) {
                        bVar.offer(nVar);
                        drain();
                    }
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    this.upstream.cancel();
                    onError(th);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.upstream.cancel();
                onError(th2);
            }
        }
    }

    @Override // io.reactivex.k, e.b.b
    public void onSubscribe(c cVar) {
        if (SubscriptionHelper.validate(this.upstream, cVar)) {
            this.upstream = cVar;
            this.downstream.onSubscribe(this);
            cVar.request(this.bufferSize);
        }
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, e.b.c
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            io.reactivex.internal.util.b.a(this.requested, j);
            drain();
        }
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, io.reactivex.h0.b.e
    public int requestFusion(int i) {
        if ((i & 2) == 0) {
            return 0;
        }
        this.outputFused = true;
        return 2;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, io.reactivex.h0.b.i
    public a<K, V> poll() {
        return this.queue.poll();
    }

    public void cancel(K k) {
        if (k == null) {
            k = (K) NULL_KEY;
        }
        this.groups.remove(k);
        if (this.groupCount.decrementAndGet() == 0) {
            this.upstream.cancel();
            if (!this.outputFused && getAndIncrement() == 0) {
                this.queue.clear();
            }
        }
    }
}
