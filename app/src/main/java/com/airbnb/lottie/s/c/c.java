package com.airbnb.lottie.s.c;

import com.airbnb.lottie.v.g;
import com.airbnb.lottie.w.a;
import java.util.List;

/* compiled from: FloatKeyframeAnimation.java */
/* loaded from: classes.dex */
public class c extends f<Float> {
    public c(List<a<Float>> list) {
        super(list);
    }

    public float o() {
        return p(b(), d());
    }

    float p(a<Float> aVar, float f2) {
        Float f3;
        if (aVar.f1160b == null || aVar.f1161c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.airbnb.lottie.w.c<A> cVar = this.f1113e;
        if (cVar == 0 || (f3 = (Float) cVar.b(aVar.f1163e, aVar.f1164f.floatValue(), aVar.f1160b, aVar.f1161c, f2, e(), f())) == null) {
            return g.j(aVar.f(), aVar.c(), f2);
        }
        return f3.floatValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q */
    public Float i(a<Float> aVar, float f2) {
        return Float.valueOf(p(aVar, f2));
    }
}
