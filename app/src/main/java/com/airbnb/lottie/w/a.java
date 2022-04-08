package com.airbnb.lottie.w;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.airbnb.lottie.d;

/* compiled from: Keyframe.java */
/* loaded from: classes.dex */
public class a<T> {
    @Nullable
    private final d a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final T f1160b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public T f1161c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final Interpolator f1162d;

    /* renamed from: e  reason: collision with root package name */
    public final float f1163e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public Float f1164f;
    private float g;
    private float h;
    private int i;
    private int j;
    private float k;
    private float l;
    public PointF m;
    public PointF n;

    public a(d dVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f2, @Nullable Float f3) {
        this.g = -3987645.8f;
        this.h = -3987645.8f;
        this.i = 784923401;
        this.j = 784923401;
        this.k = Float.MIN_VALUE;
        this.l = Float.MIN_VALUE;
        this.m = null;
        this.n = null;
        this.a = dVar;
        this.f1160b = t;
        this.f1161c = t2;
        this.f1162d = interpolator;
        this.f1163e = f2;
        this.f1164f = f3;
    }

    public boolean a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return f2 >= e() && f2 < b();
    }

    public float b() {
        if (this.a == null) {
            return 1.0f;
        }
        if (this.l == Float.MIN_VALUE) {
            if (this.f1164f == null) {
                this.l = 1.0f;
            } else {
                this.l = e() + ((this.f1164f.floatValue() - this.f1163e) / this.a.e());
            }
        }
        return this.l;
    }

    public float c() {
        if (this.h == -3987645.8f) {
            this.h = ((Float) this.f1161c).floatValue();
        }
        return this.h;
    }

    public int d() {
        if (this.j == 784923401) {
            this.j = ((Integer) this.f1161c).intValue();
        }
        return this.j;
    }

    public float e() {
        d dVar = this.a;
        if (dVar == null) {
            return 0.0f;
        }
        if (this.k == Float.MIN_VALUE) {
            this.k = (this.f1163e - dVar.o()) / this.a.e();
        }
        return this.k;
    }

    public float f() {
        if (this.g == -3987645.8f) {
            this.g = ((Float) this.f1160b).floatValue();
        }
        return this.g;
    }

    public int g() {
        if (this.i == 784923401) {
            this.i = ((Integer) this.f1160b).intValue();
        }
        return this.i;
    }

    public boolean h() {
        return this.f1162d == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f1160b + ", endValue=" + this.f1161c + ", startFrame=" + this.f1163e + ", endFrame=" + this.f1164f + ", interpolator=" + this.f1162d + '}';
    }

    public a(T t) {
        this.g = -3987645.8f;
        this.h = -3987645.8f;
        this.i = 784923401;
        this.j = 784923401;
        this.k = Float.MIN_VALUE;
        this.l = Float.MIN_VALUE;
        this.m = null;
        this.n = null;
        this.a = null;
        this.f1160b = t;
        this.f1161c = t;
        this.f1162d = null;
        this.f1163e = Float.MIN_VALUE;
        this.f1164f = Float.valueOf(Float.MAX_VALUE);
    }
}
