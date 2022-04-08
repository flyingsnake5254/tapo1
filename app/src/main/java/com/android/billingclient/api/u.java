package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
/* loaded from: classes.dex */
final class u implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ v f1242c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(v vVar) {
        this.f1242c = vVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1242c.q.a = 0;
        this.f1242c.q.g = null;
        this.f1242c.f(y.r);
    }
}
