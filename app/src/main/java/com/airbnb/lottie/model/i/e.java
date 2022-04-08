package com.airbnb.lottie.model.i;

import android.graphics.PointF;
import com.airbnb.lottie.s.c.i;
import com.airbnb.lottie.s.c.j;
import com.airbnb.lottie.w.a;
import java.util.List;

/* compiled from: AnimatablePathValue.java */
/* loaded from: classes.dex */
public class e implements m<PointF, PointF> {
    private final List<a<PointF>> a;

    public e(List<a<PointF>> list) {
        this.a = list;
    }

    @Override // com.airbnb.lottie.model.i.m
    public com.airbnb.lottie.s.c.a<PointF, PointF> a() {
        if (this.a.get(0).h()) {
            return new j(this.a);
        }
        return new i(this.a);
    }

    @Override // com.airbnb.lottie.model.i.m
    public List<a<PointF>> b() {
        return this.a;
    }

    @Override // com.airbnb.lottie.model.i.m
    public boolean c() {
        return this.a.size() == 1 && this.a.get(0).h();
    }
}
