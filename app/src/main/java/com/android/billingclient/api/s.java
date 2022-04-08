package com.android.billingclient.api;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@3.0.3 */
/* loaded from: classes.dex */
public final class s implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ g f1237c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ v f1238d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(v vVar, g gVar) {
        this.f1238d = vVar;
        this.f1237c = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        e eVar;
        e eVar2;
        obj = this.f1238d.f1245c;
        synchronized (obj) {
            eVar = this.f1238d.f1247f;
            if (eVar != null) {
                eVar2 = this.f1238d.f1247f;
                eVar2.a(this.f1237c);
            }
        }
    }
}
