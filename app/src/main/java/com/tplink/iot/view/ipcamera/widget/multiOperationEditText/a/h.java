package com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.view.animation.Interpolator;
import androidx.annotation.RequiresApi;
import com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a.f;

/* compiled from: ValueAnimatorCompatImplHoneycombMr1.java */
@RequiresApi(12)
@TargetApi(12)
/* loaded from: classes2.dex */
class h extends f.d {
    private final ValueAnimator a = new ValueAnimator();

    /* compiled from: ValueAnimatorCompatImplHoneycombMr1.java */
    /* loaded from: classes2.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f.d.b f9391c;

        a(f.d.b bVar) {
            this.f9391c = bVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f9391c.a();
        }
    }

    @Override // com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a.f.d
    public void a(f.d.b bVar) {
        this.a.addUpdateListener(new a(bVar));
    }

    @Override // com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a.f.d
    public void b() {
        this.a.cancel();
    }

    @Override // com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a.f.d
    public float c() {
        return ((Float) this.a.getAnimatedValue()).floatValue();
    }

    @Override // com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a.f.d
    public boolean d() {
        return this.a.isRunning();
    }

    @Override // com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a.f.d
    public void e(long j) {
        this.a.setDuration(j);
    }

    @Override // com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a.f.d
    public void f(float f2, float f3) {
        this.a.setFloatValues(f2, f3);
    }

    @Override // com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a.f.d
    public void g(Interpolator interpolator) {
        this.a.setInterpolator(interpolator);
    }

    @Override // com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a.f.d
    public void h() {
        this.a.start();
    }
}
