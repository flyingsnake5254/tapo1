package com.android.billingclient.api;

import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
/* loaded from: classes.dex */
final class l0 implements Callable<Void> {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ h f1211c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ i f1212d;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ d f1213f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l0(d dVar, h hVar, i iVar) {
        this.f1213f = dVar;
        this.f1211c = hVar;
        this.f1212d = iVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Void call() throws Exception {
        d.t(this.f1213f, this.f1211c, this.f1212d);
        return null;
    }
}
