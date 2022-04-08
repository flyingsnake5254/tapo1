package com.airbnb.lottie.model;

import android.graphics.PointF;
import androidx.annotation.RestrictTo;

/* compiled from: CubicCurveData.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class a {
    private final PointF a;

    /* renamed from: b  reason: collision with root package name */
    private final PointF f948b;

    /* renamed from: c  reason: collision with root package name */
    private final PointF f949c;

    public a() {
        this.a = new PointF();
        this.f948b = new PointF();
        this.f949c = new PointF();
    }

    public PointF a() {
        return this.a;
    }

    public PointF b() {
        return this.f948b;
    }

    public PointF c() {
        return this.f949c;
    }

    public void d(float f2, float f3) {
        this.a.set(f2, f3);
    }

    public void e(float f2, float f3) {
        this.f948b.set(f2, f3);
    }

    public void f(float f2, float f3) {
        this.f949c.set(f2, f3);
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.a = pointF;
        this.f948b = pointF2;
        this.f949c = pointF3;
    }
}
