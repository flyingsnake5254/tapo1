package com.tplink.libtpcontrols.wheelpicker.core;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

/* compiled from: OverScrollerCompat.java */
@TargetApi(9)
/* loaded from: classes3.dex */
class b implements d {
    private OverScroller a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, Interpolator interpolator) {
        this.a = new OverScroller(context, interpolator);
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.core.d
    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.a.fling(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.core.d
    public boolean b() {
        return this.a.isFinished();
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.core.d
    public void c(int i, int i2, int i3, int i4, int i5) {
        this.a.startScroll(i, i2, i3, i4, i5);
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.core.d
    public int d() {
        return this.a.getCurrX();
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.core.d
    public int e() {
        return this.a.getCurrY();
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.core.d
    @TargetApi(11)
    public void f(float f2) {
        this.a.setFriction(f2);
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.core.d
    public void g() {
        this.a.abortAnimation();
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.core.d
    public boolean h() {
        return this.a.computeScrollOffset();
    }
}
