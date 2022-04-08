package com.tplink.libtpcontrols.tpwheelview;

/* compiled from: LoopRunnable.java */
/* loaded from: classes3.dex */
final class b implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    final LoopView f12453c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(LoopView loopView) {
        this.f12453c = loopView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LoopView loopView = this.f12453c;
        a aVar = loopView.L3;
        int d2 = LoopView.d(loopView);
        this.f12453c.p2.get(d2);
        aVar.k(d2);
    }
}
