package com.airbnb.lottie.v;

import android.view.Choreographer;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.airbnb.lottie.c;
import com.airbnb.lottie.d;
import com.github.mikephil.charting.utils.Utils;

/* compiled from: LottieValueAnimator.java */
/* loaded from: classes.dex */
public class e extends a implements Choreographer.FrameCallback {
    @Nullable
    private d p2;

    /* renamed from: f  reason: collision with root package name */
    private float f1153f = 1.0f;
    private boolean q = false;
    private long x = 0;
    private float y = 0.0f;
    private int z = 0;
    private float p0 = -2.14748365E9f;
    private float p1 = 2.14748365E9f;
    @VisibleForTesting
    protected boolean p3 = false;

    private void C() {
        if (this.p2 != null) {
            float f2 = this.y;
            if (f2 < this.p0 || f2 > this.p1) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.p0), Float.valueOf(this.p1), Float.valueOf(this.y)));
            }
        }
    }

    private float k() {
        d dVar = this.p2;
        if (dVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / dVar.h()) / Math.abs(this.f1153f);
    }

    private boolean o() {
        return n() < 0.0f;
    }

    public void A(int i) {
        z(i, (int) this.p1);
    }

    public void B(float f2) {
        this.f1153f = f2;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        a();
        s();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        r();
        if (this.p2 != null && isRunning()) {
            c.a("LottieValueAnimator#doFrame");
            long j2 = this.x;
            long j3 = 0;
            if (j2 != 0) {
                j3 = j - j2;
            }
            float k = ((float) j3) / k();
            float f2 = this.y;
            if (o()) {
                k = -k;
            }
            float f3 = f2 + k;
            this.y = f3;
            boolean z = !g.d(f3, m(), l());
            this.y = g.b(this.y, m(), l());
            this.x = j;
            e();
            if (z) {
                if (getRepeatCount() == -1 || this.z < getRepeatCount()) {
                    c();
                    this.z++;
                    if (getRepeatMode() == 2) {
                        this.q = !this.q;
                        v();
                    } else {
                        this.y = o() ? l() : m();
                    }
                    this.x = j;
                } else {
                    this.y = this.f1153f < 0.0f ? m() : l();
                    s();
                    b(o());
                }
            }
            C();
            c.b("LottieValueAnimator#doFrame");
        }
    }

    public void f() {
        this.p2 = null;
        this.p0 = -2.14748365E9f;
        this.p1 = 2.14748365E9f;
    }

    @MainThread
    public void g() {
        s();
        b(o());
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = Utils.DOUBLE_EPSILON, to = 1.0d)
    public float getAnimatedFraction() {
        float m;
        float l;
        float m2;
        if (this.p2 == null) {
            return 0.0f;
        }
        if (o()) {
            m = l() - this.y;
            l = l();
            m2 = m();
        } else {
            m = this.y - m();
            l = l();
            m2 = m();
        }
        return m / (l - m2);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(h());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        d dVar = this.p2;
        if (dVar == null) {
            return 0L;
        }
        return dVar.d();
    }

    @FloatRange(from = Utils.DOUBLE_EPSILON, to = 1.0d)
    public float h() {
        d dVar = this.p2;
        if (dVar == null) {
            return 0.0f;
        }
        return (this.y - dVar.o()) / (this.p2.f() - this.p2.o());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.p3;
    }

    public float j() {
        return this.y;
    }

    public float l() {
        d dVar = this.p2;
        if (dVar == null) {
            return 0.0f;
        }
        float f2 = this.p1;
        return f2 == 2.14748365E9f ? dVar.f() : f2;
    }

    public float m() {
        d dVar = this.p2;
        if (dVar == null) {
            return 0.0f;
        }
        float f2 = this.p0;
        return f2 == -2.14748365E9f ? dVar.o() : f2;
    }

    public float n() {
        return this.f1153f;
    }

    @MainThread
    public void p() {
        s();
    }

    @MainThread
    public void q() {
        this.p3 = true;
        d(o());
        x((int) (o() ? l() : m()));
        this.x = 0L;
        this.z = 0;
        r();
    }

    protected void r() {
        if (isRunning()) {
            t(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    protected void s() {
        t(true);
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i != 2 && this.q) {
            this.q = false;
            v();
        }
    }

    @MainThread
    protected void t(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.p3 = false;
        }
    }

    @MainThread
    public void u() {
        this.p3 = true;
        r();
        this.x = 0L;
        if (o() && j() == m()) {
            this.y = l();
        } else if (!o() && j() == l()) {
            this.y = m();
        }
    }

    public void v() {
        B(-n());
    }

    public void w(d dVar) {
        boolean z = this.p2 == null;
        this.p2 = dVar;
        if (z) {
            z((int) Math.max(this.p0, dVar.o()), (int) Math.min(this.p1, dVar.f()));
        } else {
            z((int) dVar.o(), (int) dVar.f());
        }
        float f2 = this.y;
        this.y = 0.0f;
        x((int) f2);
        e();
    }

    public void x(float f2) {
        if (this.y != f2) {
            this.y = g.b(f2, m(), l());
            this.x = 0L;
            e();
        }
    }

    public void y(float f2) {
        z(this.p0, f2);
    }

    public void z(float f2, float f3) {
        if (f2 <= f3) {
            d dVar = this.p2;
            float o = dVar == null ? -3.4028235E38f : dVar.o();
            d dVar2 = this.p2;
            float f4 = dVar2 == null ? Float.MAX_VALUE : dVar2.f();
            this.p0 = g.b(f2, o, f4);
            this.p1 = g.b(f3, o, f4);
            x((int) g.b(this.y, f2, f3));
            return;
        }
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f2), Float.valueOf(f3)));
    }
}
