package com.airbnb.lottie.s.c;

import com.airbnb.lottie.v.g;
import com.airbnb.lottie.w.a;
import com.airbnb.lottie.w.c;
import java.util.List;

/* compiled from: IntegerKeyframeAnimation.java */
/* loaded from: classes.dex */
public class e extends f<Integer> {
    public e(List<a<Integer>> list) {
        super(list);
    }

    public int o() {
        return p(b(), d());
    }

    int p(a<Integer> aVar, float f2) {
        Integer num;
        if (aVar.f1160b == null || aVar.f1161c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        c<A> cVar = this.f1113e;
        if (cVar == 0 || (num = (Integer) cVar.b(aVar.f1163e, aVar.f1164f.floatValue(), aVar.f1160b, aVar.f1161c, f2, e(), f())) == null) {
            return g.k(aVar.g(), aVar.d(), f2);
        }
        return num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q */
    public Integer i(a<Integer> aVar, float f2) {
        return Integer.valueOf(p(aVar, f2));
    }
}
