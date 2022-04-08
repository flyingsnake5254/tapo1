package com.tplink.iot.devices.lightstrip.widget.multicolorpalette;

import android.graphics.Rect;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: ColorCursor.kt */
/* loaded from: classes2.dex */
public final class a {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private Rect f7827b;

    public a() {
        this(0, null, 3, null);
    }

    public a(int i, Rect coordinates) {
        j.e(coordinates, "coordinates");
        this.a = i;
        this.f7827b = coordinates;
    }

    public final Rect a() {
        return this.f7827b;
    }

    public final int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.a == aVar.a && j.a(this.f7827b, aVar.f7827b);
    }

    public int hashCode() {
        int i = this.a * 31;
        Rect rect = this.f7827b;
        return i + (rect != null ? rect.hashCode() : 0);
    }

    public String toString() {
        return "ColorCursor(index=" + this.a + ", coordinates=" + this.f7827b + ")";
    }

    public /* synthetic */ a(int i, Rect rect, int i2, f fVar) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? new Rect() : rect);
    }
}
