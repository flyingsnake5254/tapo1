package com.tplink.iot.Utils.z0;

import android.view.View;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: ControlComponent.kt */
/* loaded from: classes2.dex */
public final class k {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final int f5397b;

    /* renamed from: c  reason: collision with root package name */
    private int f5398c;

    /* renamed from: d  reason: collision with root package name */
    private View.OnClickListener f5399d;

    public k(int i, int i2, int i3, View.OnClickListener onClickListener) {
        this.a = i;
        this.f5397b = i2;
        this.f5398c = i3;
        this.f5399d = onClickListener;
    }

    public final View.OnClickListener a() {
        return this.f5399d;
    }

    public final int b() {
        return this.f5398c;
    }

    public final int c() {
        return this.a;
    }

    public final int d() {
        return this.f5397b;
    }

    public final void e(View.OnClickListener onClickListener) {
        this.f5399d = onClickListener;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.a == kVar.a && this.f5397b == kVar.f5397b && this.f5398c == kVar.f5398c && j.a(this.f5399d, kVar.f5399d);
    }

    public int hashCode() {
        int i = ((((this.a * 31) + this.f5397b) * 31) + this.f5398c) * 31;
        View.OnClickListener onClickListener = this.f5399d;
        return i + (onClickListener != null ? onClickListener.hashCode() : 0);
    }

    public String toString() {
        return "ControlComponent(id=" + this.a + ", textId=" + this.f5397b + ", drawableId=" + this.f5398c + ", clickListener=" + this.f5399d + ")";
    }

    public /* synthetic */ k(int i, int i2, int i3, View.OnClickListener onClickListener, int i4, f fVar) {
        this(i, i2, i3, (i4 & 8) != 0 ? null : onClickListener);
    }
}
