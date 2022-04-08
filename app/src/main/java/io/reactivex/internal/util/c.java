package io.reactivex.internal.util;

import io.reactivex.internal.schedulers.i;
import io.reactivex.j0.a;

/* compiled from: BlockingHelper.java */
/* loaded from: classes4.dex */
public final class c {
    public static void a() {
        if (!a.j()) {
            return;
        }
        if ((Thread.currentThread() instanceof i) || a.p()) {
            throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
        }
    }
}
