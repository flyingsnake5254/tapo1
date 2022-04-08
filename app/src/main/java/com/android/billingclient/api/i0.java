package com.android.billingclient.api;

import android.content.Context;
import android.content.IntentFilter;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@3.0.3 */
/* loaded from: classes.dex */
public final class i0 {
    private final Context a;

    /* renamed from: b  reason: collision with root package name */
    private final h0 f1207b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i0(Context context, k kVar) {
        this.a = context;
        this.f1207b = new h0(this, kVar, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.f1207b.a(this.a, new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final k b() {
        return h0.c(this.f1207b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        this.f1207b.b(this.a);
    }
}
