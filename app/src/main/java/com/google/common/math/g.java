package com.google.common.math;

import com.github.mikephil.charting.utils.Utils;
import com.google.common.primitives.b;
import java.util.Iterator;

/* compiled from: StatsAccumulator.java */
/* loaded from: classes2.dex */
public final class g {
    private long a = 0;

    /* renamed from: b  reason: collision with root package name */
    private double f4709b = Utils.DOUBLE_EPSILON;

    /* renamed from: c  reason: collision with root package name */
    private double f4710c = Utils.DOUBLE_EPSILON;

    /* renamed from: d  reason: collision with root package name */
    private double f4711d = Double.NaN;

    /* renamed from: e  reason: collision with root package name */
    private double f4712e = Double.NaN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double g(double d2, double d3) {
        if (b.f(d2)) {
            return d3;
        }
        if (b.f(d3) || d2 == d3) {
            return d2;
        }
        return Double.NaN;
    }

    public void a(double d2) {
        long j = this.a;
        if (j == 0) {
            this.a = 1L;
            this.f4709b = d2;
            this.f4711d = d2;
            this.f4712e = d2;
            if (!b.f(d2)) {
                this.f4710c = Double.NaN;
                return;
            }
            return;
        }
        this.a = j + 1;
        if (!b.f(d2) || !b.f(this.f4709b)) {
            this.f4709b = g(this.f4709b, d2);
            this.f4710c = Double.NaN;
        } else {
            double d3 = this.f4709b;
            double d4 = d2 - d3;
            double d5 = d3 + (d4 / this.a);
            this.f4709b = d5;
            this.f4710c += d4 * (d2 - d5);
        }
        this.f4711d = Math.min(this.f4711d, d2);
        this.f4712e = Math.max(this.f4712e, d2);
    }

    public void b(Iterable<? extends Number> iterable) {
        for (Number number : iterable) {
            a(number.doubleValue());
        }
    }

    public void c(Iterator<? extends Number> it) {
        while (it.hasNext()) {
            a(((Number) it.next()).doubleValue());
        }
    }

    public void d(double... dArr) {
        for (double d2 : dArr) {
            a(d2);
        }
    }

    public void e(int... iArr) {
        for (int i : iArr) {
            a(i);
        }
    }

    public void f(long... jArr) {
        for (long j : jArr) {
            a(j);
        }
    }

    public Stats h() {
        return new Stats(this.a, this.f4709b, this.f4710c, this.f4711d, this.f4712e);
    }
}
