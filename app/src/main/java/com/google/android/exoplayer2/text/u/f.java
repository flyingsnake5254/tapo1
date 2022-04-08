package com.google.android.exoplayer2.text.u;

import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.google.common.base.c;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: WebvttCssStyle.java */
/* loaded from: classes.dex */
public final class f {
    @ColorInt

    /* renamed from: f  reason: collision with root package name */
    private int f3581f;
    private int h;
    private float o;
    private String a = "";

    /* renamed from: b  reason: collision with root package name */
    private String f3577b = "";

    /* renamed from: c  reason: collision with root package name */
    private Set<String> f3578c = Collections.emptySet();

    /* renamed from: d  reason: collision with root package name */
    private String f3579d = "";
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private String f3580e = null;
    private boolean g = false;
    private boolean i = false;
    private int j = -1;
    private int k = -1;
    private int l = -1;
    private int m = -1;
    private int n = -1;
    private int p = -1;
    private boolean q = false;

    private static int B(int i, String str, @Nullable String str2, int i2) {
        if (str.isEmpty() || i == -1) {
            return i;
        }
        if (str.equals(str2)) {
            return i + i2;
        }
        return -1;
    }

    public f A(boolean z) {
        this.k = z ? 1 : 0;
        return this;
    }

    public int a() {
        if (this.i) {
            return this.h;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    public boolean b() {
        return this.q;
    }

    public int c() {
        if (this.g) {
            return this.f3581f;
        }
        throw new IllegalStateException("Font color not defined");
    }

    @Nullable
    public String d() {
        return this.f3580e;
    }

    public float e() {
        return this.o;
    }

    public int f() {
        return this.n;
    }

    public int g() {
        return this.p;
    }

    public int h(@Nullable String str, @Nullable String str2, Set<String> set, @Nullable String str3) {
        if (this.a.isEmpty() && this.f3577b.isEmpty() && this.f3578c.isEmpty() && this.f3579d.isEmpty()) {
            return TextUtils.isEmpty(str2) ? 1 : 0;
        }
        int B = B(B(B(0, this.a, str, Pow2.MAX_POW2), this.f3577b, str2, 2), this.f3579d, str3, 4);
        if (B == -1 || !set.containsAll(this.f3578c)) {
            return 0;
        }
        return B + (this.f3578c.size() * 4);
    }

    public int i() {
        int i = this.l;
        if (i == -1 && this.m == -1) {
            return -1;
        }
        int i2 = 0;
        int i3 = i == 1 ? 1 : 0;
        if (this.m == 1) {
            i2 = 2;
        }
        return i3 | i2;
    }

    public boolean j() {
        return this.i;
    }

    public boolean k() {
        return this.g;
    }

    public boolean l() {
        return this.j == 1;
    }

    public boolean m() {
        return this.k == 1;
    }

    public f n(int i) {
        this.h = i;
        this.i = true;
        return this;
    }

    public f o(boolean z) {
        this.l = z ? 1 : 0;
        return this;
    }

    public f p(boolean z) {
        this.q = z;
        return this;
    }

    public f q(int i) {
        this.f3581f = i;
        this.g = true;
        return this;
    }

    public f r(@Nullable String str) {
        this.f3580e = str == null ? null : c.e(str);
        return this;
    }

    public f s(float f2) {
        this.o = f2;
        return this;
    }

    public f t(int i) {
        this.n = i;
        return this;
    }

    public f u(boolean z) {
        this.m = z ? 1 : 0;
        return this;
    }

    public f v(int i) {
        this.p = i;
        return this;
    }

    public void w(String[] strArr) {
        this.f3578c = new HashSet(Arrays.asList(strArr));
    }

    public void x(String str) {
        this.a = str;
    }

    public void y(String str) {
        this.f3577b = str;
    }

    public void z(String str) {
        this.f3579d = str;
    }
}
