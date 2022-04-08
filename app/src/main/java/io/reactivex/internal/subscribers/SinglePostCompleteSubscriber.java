package io.reactivex.internal.subscribers;

import e.b.b;
import e.b.c;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.k;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes4.dex */
public abstract class SinglePostCompleteSubscriber<T, R> extends AtomicLong implements k<T>, c {
    static final long COMPLETE_MASK = Long.MIN_VALUE;
    static final long REQUEST_MASK = Long.MAX_VALUE;
    private static final long serialVersionUID = 7917814472626990048L;
    protected final b<? super R> downstream;
    protected long produced;
    protected c upstream;
    protected R value;

    public SinglePostCompleteSubscriber(b<? super R> bVar) {
        this.downstream = bVar;
    }

    @Override // e.b.c
    public void cancel() {
        this.upstream.cancel();
    }

    protected final void complete(R r) {
        long j = this.produced;
        if (j != 0) {
            io.reactivex.internal.util.b.c(this, j);
        }
        while (true) {
            long j2 = get();
            if ((j2 & Long.MIN_VALUE) != 0) {
                onDrop(r);
                return;
            } else if ((j2 & REQUEST_MASK) != 0) {
                lazySet(-9223372036854775807L);
                this.downstream.onNext(r);
                this.downstream.onComplete();
                return;
            } else {
                this.value = r;
                if (!compareAndSet(0L, Long.MIN_VALUE)) {
                    this.value = null;
                } else {
                    return;
                }
            }
        }
    }

    @Override // e.b.b
    public abstract /* synthetic */ void onComplete();

    protected void onDrop(R r) {
    }

    @Override // e.b.b
    public abstract /* synthetic */ void onError(Throwable th);

    @Override // e.b.b
    public abstract /* synthetic */ void onNext(T t);

    @Override // io.reactivex.k, e.b.b
    public void onSubscribe(c cVar) {
        if (SubscriptionHelper.validate(this.upstream, cVar)) {
            this.upstream = cVar;
            this.downstream.onSubscribe(this);
        }
    }

    @Override // e.b.c
    public final void request(long j) {
        long j2;
        if (SubscriptionHelper.validate(j)) {
            do {
                j2 = get();
                if ((j2 & Long.MIN_VALUE) != 0) {
                    if (compareAndSet(Long.MIN_VALUE, -9223372036854775807L)) {
                        this.downstream.onNext((R) this.value);
                        this.downstream.onComplete();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(j2, io.reactivex.internal.util.b.b(j2, j)));
            this.upstream.request(j);
        }
    }
}
