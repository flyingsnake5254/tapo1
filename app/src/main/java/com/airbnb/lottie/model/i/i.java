package com.airbnb.lottie.model.i;

import android.graphics.PointF;
import com.airbnb.lottie.s.c.a;
import com.airbnb.lottie.s.c.m;
import java.util.List;

/* compiled from: AnimatableSplitDimensionPathValue.java */
/* loaded from: classes.dex */
public class i implements m<PointF, PointF> {
    private final b a;

    /* renamed from: b  reason: collision with root package name */
    private final b f1021b;

    public i(b bVar, b bVar2) {
        this.a = bVar;
        this.f1021b = bVar2;
    }

    @Override // com.airbnb.lottie.model.i.m
    public a<PointF, PointF> a() {
        return new m(this.a.a(), this.f1021b.a());
    }

    @Override // com.airbnb.lottie.model.i.m
    public List<com.airbnb.lottie.w.a<PointF>> b() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // com.airbnb.lottie.model.i.m
    public boolean c() {
        return this.a.c() && this.f1021b.c();
    }
}
