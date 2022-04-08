package com.airbnb.lottie.model.i;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.f;
import com.airbnb.lottie.model.content.b;
import com.airbnb.lottie.model.layer.a;
import com.airbnb.lottie.s.b.c;
import com.airbnb.lottie.s.c.o;

/* compiled from: AnimatableTransform.java */
/* loaded from: classes.dex */
public class l implements b {
    @Nullable
    private final e a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final m<PointF, PointF> f1025b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final g f1026c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final b f1027d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final d f1028e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final b f1029f;
    @Nullable
    private final b g;
    @Nullable
    private final b h;
    @Nullable
    private final b i;

    public l() {
        this(null, null, null, null, null, null, null, null, null);
    }

    @Override // com.airbnb.lottie.model.content.b
    @Nullable
    public c a(f fVar, a aVar) {
        return null;
    }

    public o b() {
        return new o(this);
    }

    @Nullable
    public e c() {
        return this.a;
    }

    @Nullable
    public b d() {
        return this.i;
    }

    @Nullable
    public d e() {
        return this.f1028e;
    }

    @Nullable
    public m<PointF, PointF> f() {
        return this.f1025b;
    }

    @Nullable
    public b g() {
        return this.f1027d;
    }

    @Nullable
    public g h() {
        return this.f1026c;
    }

    @Nullable
    public b i() {
        return this.f1029f;
    }

    @Nullable
    public b j() {
        return this.g;
    }

    @Nullable
    public b k() {
        return this.h;
    }

    public l(@Nullable e eVar, @Nullable m<PointF, PointF> mVar, @Nullable g gVar, @Nullable b bVar, @Nullable d dVar, @Nullable b bVar2, @Nullable b bVar3, @Nullable b bVar4, @Nullable b bVar5) {
        this.a = eVar;
        this.f1025b = mVar;
        this.f1026c = gVar;
        this.f1027d = bVar;
        this.f1028e = dVar;
        this.h = bVar2;
        this.i = bVar3;
        this.f1029f = bVar4;
        this.g = bVar5;
    }
}
