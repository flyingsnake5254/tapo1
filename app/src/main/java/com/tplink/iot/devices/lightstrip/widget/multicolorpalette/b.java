package com.tplink.iot.devices.lightstrip.widget.multicolorpalette;

/* compiled from: ColorSegment.kt */
/* loaded from: classes2.dex */
public final class b {
    private final float a;

    /* renamed from: b  reason: collision with root package name */
    private final float f7828b;

    public b(float f2, float f3) {
        this.a = f2;
        this.f7828b = f3;
    }

    public final float a() {
        return this.f7828b;
    }

    public final float b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Float.compare(this.a, bVar.a) == 0 && Float.compare(this.f7828b, bVar.f7828b) == 0;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.f7828b);
    }

    public String toString() {
        float f2 = 360;
        return "ColorSegment(Human readable hue=" + (this.a * f2) + ", colorWheelAngle=" + (this.f7828b * f2) + ')';
    }
}
