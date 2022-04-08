package io.reactivex.internal.schedulers;

import io.reactivex.w;
import java.util.concurrent.ThreadFactory;

/* compiled from: NewThreadScheduler.java */
/* loaded from: classes4.dex */
public final class g extends w {

    /* renamed from: c  reason: collision with root package name */
    private static final RxThreadFactory f16202c = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));

    /* renamed from: d  reason: collision with root package name */
    final ThreadFactory f16203d;

    public g() {
        this(f16202c);
    }

    @Override // io.reactivex.w
    public w.c b() {
        return new h(this.f16203d);
    }

    public g(ThreadFactory threadFactory) {
        this.f16203d = threadFactory;
    }
}
