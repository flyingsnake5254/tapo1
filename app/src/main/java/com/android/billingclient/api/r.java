package com.android.billingclient.api;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@3.0.3 */
/* loaded from: classes.dex */
public final class r implements Callable<Void> {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f1232c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ List f1233d;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ m f1234f;
    final /* synthetic */ d q;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(d dVar, String str, List list, String str2, m mVar) {
        this.q = dVar;
        this.f1232c = str;
        this.f1233d = list;
        this.f1234f = mVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Void call() throws Exception {
        this.q.m(new q(this, this.q.o(this.f1232c, this.f1233d, null)));
        return null;
    }
}
