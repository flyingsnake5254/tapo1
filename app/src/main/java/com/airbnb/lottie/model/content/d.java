package com.airbnb.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.i.b;
import com.airbnb.lottie.model.i.c;
import com.airbnb.lottie.model.i.f;
import com.airbnb.lottie.model.layer.a;
import com.airbnb.lottie.s.b.h;

/* compiled from: GradientFill.java */
/* loaded from: classes.dex */
public class d implements b {
    private final GradientType a;

    /* renamed from: b  reason: collision with root package name */
    private final Path.FillType f984b;

    /* renamed from: c  reason: collision with root package name */
    private final c f985c;

    /* renamed from: d  reason: collision with root package name */
    private final com.airbnb.lottie.model.i.d f986d;

    /* renamed from: e  reason: collision with root package name */
    private final f f987e;

    /* renamed from: f  reason: collision with root package name */
    private final f f988f;
    private final String g;
    @Nullable
    private final b h;
    @Nullable
    private final b i;
    private final boolean j;

    public d(String str, GradientType gradientType, Path.FillType fillType, c cVar, com.airbnb.lottie.model.i.d dVar, f fVar, f fVar2, b bVar, b bVar2, boolean z) {
        this.a = gradientType;
        this.f984b = fillType;
        this.f985c = cVar;
        this.f986d = dVar;
        this.f987e = fVar;
        this.f988f = fVar2;
        this.g = str;
        this.h = bVar;
        this.i = bVar2;
        this.j = z;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.s.b.c a(com.airbnb.lottie.f fVar, a aVar) {
        return new h(fVar, aVar, this);
    }

    public f b() {
        return this.f988f;
    }

    public Path.FillType c() {
        return this.f984b;
    }

    public c d() {
        return this.f985c;
    }

    public GradientType e() {
        return this.a;
    }

    public String f() {
        return this.g;
    }

    public com.airbnb.lottie.model.i.d g() {
        return this.f986d;
    }

    public f h() {
        return this.f987e;
    }

    public boolean i() {
        return this.j;
    }
}
