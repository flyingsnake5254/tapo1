package com.google.android.exoplayer2.text;

import android.graphics.Bitmap;
import android.text.Layout;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.v0;
import com.google.common.base.k;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: Cue.java */
/* loaded from: classes.dex */
public final class c {
    public static final c a = new b().o("").a();

    /* renamed from: b  reason: collision with root package name */
    public static final v0<c> f3440b = a.a;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final CharSequence f3441c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final Layout.Alignment f3442d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final Layout.Alignment f3443e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final Bitmap f3444f;
    public final float g;
    public final int h;
    public final int i;
    public final float j;
    public final int k;
    public final float l;
    public final float m;
    public final boolean n;
    public final int o;
    public final int p;
    public final float q;
    public final int r;
    public final float s;

    /* compiled from: Cue.java */
    /* loaded from: classes.dex */
    public static final class b {
        @Nullable
        private CharSequence a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private Bitmap f3445b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private Layout.Alignment f3446c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private Layout.Alignment f3447d;

        /* renamed from: e  reason: collision with root package name */
        private float f3448e;

        /* renamed from: f  reason: collision with root package name */
        private int f3449f;
        private int g;
        private float h;
        private int i;
        private int j;
        private float k;
        private float l;
        private float m;
        private boolean n;
        @ColorInt
        private int o;
        private int p;
        private float q;

        public c a() {
            return new c(this.a, this.f3446c, this.f3447d, this.f3445b, this.f3448e, this.f3449f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q);
        }

        public b b() {
            this.n = false;
            return this;
        }

        @Pure
        public int c() {
            return this.g;
        }

        @Pure
        public int d() {
            return this.i;
        }

        @Nullable
        @Pure
        public CharSequence e() {
            return this.a;
        }

        public b f(Bitmap bitmap) {
            this.f3445b = bitmap;
            return this;
        }

        public b g(float f2) {
            this.m = f2;
            return this;
        }

        public b h(float f2, int i) {
            this.f3448e = f2;
            this.f3449f = i;
            return this;
        }

        public b i(int i) {
            this.g = i;
            return this;
        }

        public b j(@Nullable Layout.Alignment alignment) {
            this.f3447d = alignment;
            return this;
        }

        public b k(float f2) {
            this.h = f2;
            return this;
        }

        public b l(int i) {
            this.i = i;
            return this;
        }

        public b m(float f2) {
            this.q = f2;
            return this;
        }

        public b n(float f2) {
            this.l = f2;
            return this;
        }

        public b o(CharSequence charSequence) {
            this.a = charSequence;
            return this;
        }

        public b p(@Nullable Layout.Alignment alignment) {
            this.f3446c = alignment;
            return this;
        }

        public b q(float f2, int i) {
            this.k = f2;
            this.j = i;
            return this;
        }

        public b r(int i) {
            this.p = i;
            return this;
        }

        public b s(@ColorInt int i) {
            this.o = i;
            this.n = true;
            return this;
        }

        public b() {
            this.a = null;
            this.f3445b = null;
            this.f3446c = null;
            this.f3447d = null;
            this.f3448e = -3.4028235E38f;
            this.f3449f = Integer.MIN_VALUE;
            this.g = Integer.MIN_VALUE;
            this.h = -3.4028235E38f;
            this.i = Integer.MIN_VALUE;
            this.j = Integer.MIN_VALUE;
            this.k = -3.4028235E38f;
            this.l = -3.4028235E38f;
            this.m = -3.4028235E38f;
            this.n = false;
            this.o = ViewCompat.MEASURED_STATE_MASK;
            this.p = Integer.MIN_VALUE;
        }

        private b(c cVar) {
            this.a = cVar.f3441c;
            this.f3445b = cVar.f3444f;
            this.f3446c = cVar.f3442d;
            this.f3447d = cVar.f3443e;
            this.f3448e = cVar.g;
            this.f3449f = cVar.h;
            this.g = cVar.i;
            this.h = cVar.j;
            this.i = cVar.k;
            this.j = cVar.p;
            this.k = cVar.q;
            this.l = cVar.l;
            this.m = cVar.m;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.r;
            this.q = cVar.s;
        }
    }

    public b a() {
        return new b();
    }

    public boolean equals(@Nullable Object obj) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return TextUtils.equals(this.f3441c, cVar.f3441c) && this.f3442d == cVar.f3442d && this.f3443e == cVar.f3443e && ((bitmap = this.f3444f) != null ? !((bitmap2 = cVar.f3444f) == null || !bitmap.sameAs(bitmap2)) : cVar.f3444f == null) && this.g == cVar.g && this.h == cVar.h && this.i == cVar.i && this.j == cVar.j && this.k == cVar.k && this.l == cVar.l && this.m == cVar.m && this.n == cVar.n && this.o == cVar.o && this.p == cVar.p && this.q == cVar.q && this.r == cVar.r && this.s == cVar.s;
    }

    public int hashCode() {
        return k.b(this.f3441c, this.f3442d, this.f3443e, this.f3444f, Float.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(this.i), Float.valueOf(this.j), Integer.valueOf(this.k), Float.valueOf(this.l), Float.valueOf(this.m), Boolean.valueOf(this.n), Integer.valueOf(this.o), Integer.valueOf(this.p), Float.valueOf(this.q), Integer.valueOf(this.r), Float.valueOf(this.s));
    }

    private c(@Nullable CharSequence charSequence, @Nullable Layout.Alignment alignment, @Nullable Layout.Alignment alignment2, @Nullable Bitmap bitmap, float f2, int i, int i2, float f3, int i3, int i4, float f4, float f5, float f6, boolean z, int i5, int i6, float f7) {
        if (charSequence == null) {
            g.e(bitmap);
        } else {
            g.a(bitmap == null);
        }
        if (charSequence instanceof Spanned) {
            this.f3441c = SpannedString.valueOf(charSequence);
        } else if (charSequence != null) {
            this.f3441c = charSequence.toString();
        } else {
            this.f3441c = null;
        }
        this.f3442d = alignment;
        this.f3443e = alignment2;
        this.f3444f = bitmap;
        this.g = f2;
        this.h = i;
        this.i = i2;
        this.j = f3;
        this.k = i3;
        this.l = f5;
        this.m = f6;
        this.n = z;
        this.o = i5;
        this.p = i4;
        this.q = f4;
        this.r = i6;
        this.s = f7;
    }
}
