package com.android.billingclient.api;

import com.android.billingclient.api.g;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
/* loaded from: classes.dex */
final class q implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ b0 f1229c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ r f1230d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(r rVar, b0 b0Var) {
        this.f1230d = rVar;
        this.f1229c = b0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m mVar = this.f1230d.f1234f;
        g.a b2 = g.b();
        b2.c(this.f1229c.b());
        b2.b(this.f1229c.c());
        mVar.a(b2.a(), this.f1229c.a());
    }
}
