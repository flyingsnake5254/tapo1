package com.tplink.libtpcontrols.wheelpickerview;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OnItemSelectedRunnable.java */
/* loaded from: classes3.dex */
public final class e implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    final LoopView f12494c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(LoopView loopView) {
        this.f12494c = loopView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LoopView loopView = this.f12494c;
        loopView.y.b(loopView.getSelectedItem());
    }
}
