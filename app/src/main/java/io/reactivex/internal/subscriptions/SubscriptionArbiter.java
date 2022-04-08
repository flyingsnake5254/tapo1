package io.reactivex.internal.subscriptions;

import e.b.c;
import io.reactivex.internal.util.b;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public class SubscriptionArbiter extends AtomicInteger implements c {
    private static final long serialVersionUID = -2189523197179400958L;
    c actual;
    final boolean cancelOnReplace;
    volatile boolean cancelled;
    long requested;
    protected boolean unbounded;
    final AtomicReference<c> missedSubscription = new AtomicReference<>();
    final AtomicLong missedRequested = new AtomicLong();
    final AtomicLong missedProduced = new AtomicLong();

    public SubscriptionArbiter(boolean z) {
        this.cancelOnReplace = z;
    }

    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            drain();
        }
    }

    final void drain() {
        if (getAndIncrement() == 0) {
            drainLoop();
        }
    }

    final void drainLoop() {
        int i = 1;
        c cVar = null;
        long j = 0;
        do {
            c cVar2 = this.missedSubscription.get();
            if (cVar2 != null) {
                cVar2 = this.missedSubscription.getAndSet(null);
            }
            long j2 = this.missedRequested.get();
            if (j2 != 0) {
                j2 = this.missedRequested.getAndSet(0L);
            }
            long j3 = this.missedProduced.get();
            if (j3 != 0) {
                j3 = this.missedProduced.getAndSet(0L);
            }
            c cVar3 = this.actual;
            if (this.cancelled) {
                if (cVar3 != null) {
                    cVar3.cancel();
                    this.actual = null;
                }
                if (cVar2 != null) {
                    cVar2.cancel();
                }
            } else {
                long j4 = this.requested;
                if (j4 != Long.MAX_VALUE) {
                    j4 = b.b(j4, j2);
                    if (j4 != Long.MAX_VALUE) {
                        j4 -= j3;
                        if (j4 < 0) {
                            SubscriptionHelper.reportMoreProduced(j4);
                            j4 = 0;
                        }
                    }
                    this.requested = j4;
                }
                if (cVar2 != null) {
                    if (cVar3 != null && this.cancelOnReplace) {
                        cVar3.cancel();
                    }
                    this.actual = cVar2;
                    if (j4 != 0) {
                        j = b.b(j, j4);
                        cVar = cVar2;
                    }
                } else if (!(cVar3 == null || j2 == 0)) {
                    j = b.b(j, j2);
                    cVar = cVar3;
                }
            }
            i = addAndGet(-i);
        } while (i != 0);
        if (j != 0) {
            cVar.request(j);
        }
    }

    public final boolean isCancelled() {
        return this.cancelled;
    }

    public final boolean isUnbounded() {
        return this.unbounded;
    }

    public final void produced(long j) {
        if (!this.unbounded) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                b.a(this.missedProduced, j);
                drain();
                return;
            }
            long j2 = this.requested;
            if (j2 != Long.MAX_VALUE) {
                long j3 = j2 - j;
                if (j3 < 0) {
                    SubscriptionHelper.reportMoreProduced(j3);
                    j3 = 0;
                }
                this.requested = j3;
            }
            if (decrementAndGet() != 0) {
                drainLoop();
            }
        }
    }

    @Override // e.b.c
    public final void request(long j) {
        if (SubscriptionHelper.validate(j) && !this.unbounded) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                b.a(this.missedRequested, j);
                drain();
                return;
            }
            long j2 = this.requested;
            if (j2 != Long.MAX_VALUE) {
                long b2 = b.b(j2, j);
                this.requested = b2;
                if (b2 == Long.MAX_VALUE) {
                    this.unbounded = true;
                }
            }
            c cVar = this.actual;
            if (decrementAndGet() != 0) {
                drainLoop();
            }
            if (cVar != null) {
                cVar.request(j);
            }
        }
    }

    public final void setSubscription(c cVar) {
        if (this.cancelled) {
            cVar.cancel();
            return;
        }
        io.reactivex.h0.a.b.e(cVar, "s is null");
        if (get() != 0 || !compareAndSet(0, 1)) {
            c andSet = this.missedSubscription.getAndSet(cVar);
            if (andSet != null && this.cancelOnReplace) {
                andSet.cancel();
            }
            drain();
            return;
        }
        c cVar2 = this.actual;
        if (cVar2 != null && this.cancelOnReplace) {
            cVar2.cancel();
        }
        this.actual = cVar;
        long j = this.requested;
        if (decrementAndGet() != 0) {
            drainLoop();
        }
        if (j != 0) {
            cVar.request(j);
        }
    }
}
