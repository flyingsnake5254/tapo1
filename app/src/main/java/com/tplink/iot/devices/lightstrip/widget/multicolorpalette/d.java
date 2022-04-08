package com.tplink.iot.devices.lightstrip.widget.multicolorpalette;

import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import kotlin.jvm.internal.f;

/* compiled from: ColorSpace.kt */
/* loaded from: classes2.dex */
public final class d {
    public static final a a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private int f7833b;

    /* renamed from: c  reason: collision with root package name */
    private int f7834c;

    /* renamed from: d  reason: collision with root package name */
    private int f7835d;

    /* compiled from: ColorSpace.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final d a(@ColorInt int i) {
            return new d(Color.red(i), Color.green(i), Color.blue(i));
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public d(@IntRange(from = 0, to = 255) int i, @IntRange(from = 0, to = 255) int i2, @IntRange(from = 0, to = 255) int i3) {
        this.f7833b = i;
        this.f7834c = i2;
        this.f7835d = i3;
    }

    public static final d a(@ColorInt int i) {
        return a.a(i);
    }

    @ColorInt
    public final int b() {
        return Color.argb(255, this.f7833b, this.f7834c, this.f7835d);
    }

    public final c c() {
        float[] fArr = new float[3];
        Color.colorToHSV(b(), fArr);
        float f2 = 100;
        return new c((int) fArr[0], (int) (fArr[1] * f2), (int) (fArr[2] * f2));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f7833b == dVar.f7833b && this.f7834c == dVar.f7834c && this.f7835d == dVar.f7835d;
    }

    public int hashCode() {
        return (((this.f7833b * 31) + this.f7834c) * 31) + this.f7835d;
    }

    public String toString() {
        return "RGB(red=" + this.f7833b + ", green=" + this.f7834c + ", blue=" + this.f7835d + ")";
    }
}
