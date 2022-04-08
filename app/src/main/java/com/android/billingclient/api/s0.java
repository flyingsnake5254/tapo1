package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zza;
import java.util.concurrent.Future;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@3.0.3 */
/* loaded from: classes.dex */
public final class s0 implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Future f1239c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Runnable f1240d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s0(d dVar, Future future, Runnable runnable) {
        this.f1239c = future;
        this.f1240d = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.f1239c.isDone() && !this.f1239c.isCancelled()) {
            this.f1239c.cancel(true);
            zza.zzb("BillingClient", "Async task is taking too long, cancel it!");
            Runnable runnable = this.f1240d;
            if (runnable != null) {
                runnable.run();
            }
        }
    }
}
