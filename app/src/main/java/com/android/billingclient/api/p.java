package com.android.billingclient.api;

import com.android.billingclient.api.Purchase;
import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
/* loaded from: classes.dex */
final class p implements Callable<Purchase.a> {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f1224c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ d f1225d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(d dVar, String str) {
        this.f1225d = dVar;
        this.f1224c = str;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Purchase.a call() throws Exception {
        return d.r(this.f1225d, this.f1224c);
    }
}
