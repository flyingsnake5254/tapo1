package com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.b;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.b.a;

/* compiled from: AnimatorCompatV11.java */
@TargetApi(11)
/* loaded from: classes3.dex */
public class b extends a {
    ValueAnimator a;

    /* compiled from: AnimatorCompatV11.java */
    /* loaded from: classes3.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ a.AbstractC0251a f12367c;

        a(a.AbstractC0251a aVar) {
            this.f12367c = aVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f12367c.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public b(float f2, float f3, a.AbstractC0251a aVar) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, f3);
        this.a = ofFloat;
        ofFloat.addUpdateListener(new a(aVar));
    }

    @Override // com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.b.a
    public void a() {
        this.a.cancel();
    }

    @Override // com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.b.a
    public boolean c() {
        return this.a.isRunning();
    }

    @Override // com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.b.a
    public void d(int i) {
        this.a.setDuration(i);
    }

    @Override // com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.b.a
    public void e() {
        this.a.start();
    }
}
