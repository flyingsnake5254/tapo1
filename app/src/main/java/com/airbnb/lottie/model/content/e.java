package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.i.b;
import com.airbnb.lottie.model.i.c;
import com.airbnb.lottie.model.i.d;
import com.airbnb.lottie.model.i.f;
import com.airbnb.lottie.model.layer.a;
import com.airbnb.lottie.s.b.i;
import java.util.List;

/* compiled from: GradientStroke.java */
/* loaded from: classes.dex */
public class e implements b {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final GradientType f989b;

    /* renamed from: c  reason: collision with root package name */
    private final c f990c;

    /* renamed from: d  reason: collision with root package name */
    private final d f991d;

    /* renamed from: e  reason: collision with root package name */
    private final f f992e;

    /* renamed from: f  reason: collision with root package name */
    private final f f993f;
    private final b g;
    private final ShapeStroke.LineCapType h;
    private final ShapeStroke.LineJoinType i;
    private final float j;
    private final List<b> k;
    @Nullable
    private final b l;
    private final boolean m;

    public e(String str, GradientType gradientType, c cVar, d dVar, f fVar, f fVar2, b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f2, List<b> list, @Nullable b bVar2, boolean z) {
        this.a = str;
        this.f989b = gradientType;
        this.f990c = cVar;
        this.f991d = dVar;
        this.f992e = fVar;
        this.f993f = fVar2;
        this.g = bVar;
        this.h = lineCapType;
        this.i = lineJoinType;
        this.j = f2;
        this.k = list;
        this.l = bVar2;
        this.m = z;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.s.b.c a(com.airbnb.lottie.f fVar, a aVar) {
        return new i(fVar, aVar, this);
    }

    public ShapeStroke.LineCapType b() {
        return this.h;
    }

    @Nullable
    public b c() {
        return this.l;
    }

    public f d() {
        return this.f993f;
    }

    public c e() {
        return this.f990c;
    }

    public GradientType f() {
        return this.f989b;
    }

    public ShapeStroke.LineJoinType g() {
        return this.i;
    }

    public List<b> h() {
        return this.k;
    }

    public float i() {
        return this.j;
    }

    public String j() {
        return this.a;
    }

    public d k() {
        return this.f991d;
    }

    public f l() {
        return this.f992e;
    }

    public b m() {
        return this.g;
    }

    public boolean n() {
        return this.m;
    }
}
