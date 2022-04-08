package com.airbnb.lottie;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* compiled from: LottieImageAsset.java */
/* loaded from: classes.dex */
public class g {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final int f926b;

    /* renamed from: c  reason: collision with root package name */
    private final String f927c;

    /* renamed from: d  reason: collision with root package name */
    private final String f928d;

    /* renamed from: e  reason: collision with root package name */
    private final String f929e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private Bitmap f930f;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public g(int i, int i2, String str, String str2, String str3) {
        this.a = i;
        this.f926b = i2;
        this.f927c = str;
        this.f928d = str2;
        this.f929e = str3;
    }

    @Nullable
    public Bitmap a() {
        return this.f930f;
    }

    public String b() {
        return this.f928d;
    }

    public int c() {
        return this.f926b;
    }

    public String d() {
        return this.f927c;
    }

    public int e() {
        return this.a;
    }

    public void f(@Nullable Bitmap bitmap) {
        this.f930f = bitmap;
    }
}
