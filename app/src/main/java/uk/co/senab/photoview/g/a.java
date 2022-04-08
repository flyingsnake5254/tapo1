package uk.co.senab.photoview.g;

import android.annotation.TargetApi;
import android.content.Context;
import android.widget.OverScroller;

/* compiled from: GingerScroller.java */
@TargetApi(9)
/* loaded from: classes4.dex */
public class a extends d {
    protected final OverScroller a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f17767b = false;

    public a(Context context) {
        this.a = new OverScroller(context);
    }

    @Override // uk.co.senab.photoview.g.d
    public boolean a() {
        if (this.f17767b) {
            this.a.computeScrollOffset();
            this.f17767b = false;
        }
        return this.a.computeScrollOffset();
    }

    @Override // uk.co.senab.photoview.g.d
    public void b(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.a.fling(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
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
