package uk.co.senab.photoview.g;

import android.content.Context;
import android.widget.Scroller;

/* compiled from: PreGingerScroller.java */
/* loaded from: classes4.dex */
public class c extends d {
    private final Scroller a;

    public c(Context context) {
        this.a = new Scroller(context);
    }

    @Override // uk.co.senab.photoview.g.d
    public boolean a() {
        return this.a.computeScrollOffset();
    }

    @Override // uk.co.senab.photoview.g.d
    public void b(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.a.fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    @Override // uk.co.senab.photoview.g.d
    public void c(boolean z) {
        this.a.forceFinished(z);
    }

    @Override // uk.co.senab.photoview.g.d
    public int d() {
        return this.a.getCurrX();
    }

    @Override // uk.co.senab.photoview.g.d
    public int e() {
        return this.a.getCurrY();
    }

    @Override // uk.co.senab.photoview.g.d
    public boolean g() {
        return this.a.isFinished();
    }
}
