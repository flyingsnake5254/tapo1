package com.google.android.exoplayer2.text.s;

import android.text.Layout;
import androidx.annotation.Nullable;

/* compiled from: TtmlStyle.java */
/* loaded from: classes.dex */
final class g {
    @Nullable
    private String a;

    /* renamed from: b  reason: collision with root package name */
    private int f3561b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3562c;

    /* renamed from: d  reason: collision with root package name */
    private int f3563d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3564e;
    private float k;
    @Nullable
    private String l;
    @Nullable
    private Layout.Alignment o;
    @Nullable
    private Layout.Alignment p;
    @Nullable
    private b r;

    /* renamed from: f  reason: collision with root package name */
    private int f3565f = -1;
    private int g = -1;
    private int h = -1;
    private int i = -1;
    private int j = -1;
    private int m = -1;
    private int n = -1;
    private int q = -1;
    private float s = Float.MAX_VALUE;

    private g r(@Nullable g gVar, boolean z) {
        int i;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (gVar != null) {
            if (!this.f3562c && gVar.f3562c) {
                w(gVar.f3561b);
            }
            if (this.h == -1) {
                this.h = gVar.h;
            }
            if (this.i == -1) {
                this.i = gVar.i;
            }
            if (this.a == null && (str = gVar.a) != null) {
                this.a = str;
            }
            if (this.f3565f == -1) {
                this.f3565f = gVar.f3565f;
            }
            if (this.g == -1) {
                this.g = gVar.g;
            }
            if (this.n == -1) {
                this.n = gVar.n;
            }
            if (this.o == null && (alignment2 = gVar.o) != null) {
                this.o = alignment2;
            }
            if (this.p == null && (alignment = gVar.p) != null) {
                this.p = alignment;
            }
            if (this.q == -1) {
                this.q = gVar.q;
            }
            if (this.j == -1) {
                this.j = gVar.j;
                this.k = gVar.k;
            }
            if (this.r == null) {
                this.r = gVar.r;
            }
            if (this.s == Float.MAX_VALUE) {
                this.s = gVar.s;
            }
            if (z && !this.f3564e && gVar.f3564e) {
                u(gVar.f3563d);
            }
            if (z && this.m == -1 && (i = gVar.m) != -1) {
                this.m = i;
            }
        }
        return this;
    }

    public g A(@Nullable String str) {
        this.l = str;
        return this;
    }

    public g B(boolean z) {
        this.i = z ? 1 : 0;
        return this;
    }

    public g C(boolean z) {
        this.f3565f = z ? 1 : 0;
        return this;
    }

    public g D(@Nullable Layout.Alignment alignment) {
        this.p = alignment;
        return this;
    }

    public g E(int i) {
        this.n = i;
        return this;
    }

    public g F(int i) {
        this.m = i;
        return this;
    }

    public g G(float f2) {
        this.s = f2;
        return this;
    }

    public g H(@Nullable Layout.Alignment alignment) {
        this.o = alignment;
        return this;
    }

    public g I(boolean z) {
        this.q = z ? 1 : 0;
        return this;
    }

    public g J(@Nullable b bVar) {
        this.r = bVar;
        return this;
    }

    public g K(boolean z) {
        this.g = z ? 1 : 0;
        return this;
    }

    public g a(@Nullable g gVar) {
        return r(gVar, true);
    }

    public int b() {
        if (this.f3564e) {
            return this.f3563d;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public int c() {
        if (this.f3562c) {
            return this.f3561b;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    @Nullable
    public String d() {
        return this.a;
    }

    public float e() {
        return this.k;
    }

    public int f() {
        return this.j;
    }

    @Nullable
    public String g() {
        return this.l;
    }

    @Nullable
    public Layout.Alignment h() {
        return this.p;
    }

    public int i() {
        return this.n;
    }

    public int j() {
        return this.m;
    }

    public float k() {
        return this.s;
    }

    public int l() {
        int i = this.h;
        if (i == -1 && this.i == -1) {
            return -1;
        }
        int i2 = 0;
        int i3 = i == 1 ? 1 : 0;
        if (this.i == 1) {
            i2 = 2;
        }
        return i3 | i2;
    }

    @Nullable
    public Layout.Alignment m() {
        return this.o;
    }

    public boolean n() {
        return this.q == 1;
    }

    @Nullable
    public b o() {
        return this.r;
    }

    public boolean p() {
        return this.f3564e;
    }

    public boolean q() {
        return this.f3562c;
    }

    public boolean s() {
        return this.f3565f == 1;
    }

    public boolean t() {
        return this.g == 1;
    }

    public g u(int i) {
        this.f3563d = i;
        this.f3564e = true;
        return this;
    }

    public g v(boolean z) {
        this.h = z ? 1 : 0;
        return this;
    }

    public g w(int i) {
        this.f3561b = i;
        this.f3562c = true;
        return this;
    }

    public g x(@Nullable String str) {
        this.a = str;
        return this;
    }

    public g y(float f2) {
        this.k = f2;
        return this;
    }

    public g z(int i) {
        this.j = i;
        return this;
    }
}
