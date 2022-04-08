package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.i.b;
import com.airbnb.lottie.model.i.m;
import com.airbnb.lottie.model.layer.a;
import com.airbnb.lottie.s.b.c;
import com.airbnb.lottie.s.b.o;

/* compiled from: RectangleShape.java */
/* loaded from: classes.dex */
public class f implements b {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final m<PointF, PointF> f994b;

    /* renamed from: c  reason: collision with root package name */
    private final com.airbnb.lottie.model.i.f f995c;

    /* renamed from: d  reason: collision with root package name */
    private final b f996d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f997e;

    public f(String str, m<PointF, PointF> mVar, com.airbnb.lottie.model.i.f fVar, b bVar, boolean z) {
        this.a = str;
        this.f994b = mVar;
        this.f995c = fVar;
        this.f996d = bVar;
        this.f997e = z;
    }

    @Override // com.airbnb.lottie.model.content.b
    public c a(com.airbnb.lottie.f fVar, a aVar) {
        return new o(fVar, aVar, this);
    }

    public b b() {
        return this.f996d;
    }

    public String c() {
        return this.a;
    }

    public m<PointF, PointF> d() {
        return this.f994b;
    }

    public com.airbnb.lottie.model.i.f e() {
        return this.f995c;
    }

    public boolean f() {
        return this.f997e;
    }

    public String toString() {
        return "RectangleShape{position=" + this.f994b + ", size=" + this.f995c + '}';
    }
}
