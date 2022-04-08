package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.i.f;
import com.airbnb.lottie.model.i.m;
import com.airbnb.lottie.s.b.c;

/* compiled from: CircleShape.java */
/* loaded from: classes.dex */
public class a implements b {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final m<PointF, PointF> f979b;

    /* renamed from: c  reason: collision with root package name */
    private final f f980c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f981d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f982e;

    public a(String str, m<PointF, PointF> mVar, f fVar, boolean z, boolean z2) {
        this.a = str;
        this.f979b = mVar;
        this.f980c = fVar;
        this.f981d = z;
        this.f982e = z2;
    }

    @Override // com.airbnb.lottie.model.content.b
    public c a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.s.b.f(fVar, aVar, this);
    }

    public String b() {
        return this.a;
    }

    public m<PointF, PointF> c() {
        return this.f979b;
    }

    public f d() {
        return this.f980c;
    }

    public boolean e() {
        return this.f982e;
    }

    public boolean f() {
        return this.f981d;
    }
}
