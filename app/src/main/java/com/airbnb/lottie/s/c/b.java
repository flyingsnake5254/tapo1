package com.airbnb.lottie.s.c;

import com.airbnb.lottie.v.g;
import com.airbnb.lottie.w.a;
import com.airbnb.lottie.w.c;
import java.util.List;

/* compiled from: ColorKeyframeAnimation.java */
/* loaded from: classes.dex */
public class b extends f<Integer> {
    public b(List<a<Integer>> list) {
        super(list);
    }

    public int o() {
        return p(b(), d());
    }

    public int p(a<Integer> aVar, float f2) {
        Integer num;
        Integer num2 = aVar.f1160b;
        if (num2 == null || aVar.f1161c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int intValue = num2.intValue();
        int intValue2 = aVar.f1161c.intValue();
        c<A> cVar = this.f1113e;
        if (cVar == 0 || (num = (Integer) cVar.b(aVar.f1163e, aVar.f1164f.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f2, e(), f())) == null) {
            return com.airbnb.lottie.v.b.c(g.b(f2, 0.0f, 1.0f), intValue, intValue2);
        }
        return num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q */
    public Integer i(a<Integer> aVar, float f2) {
        return Integer.valueOf(p(aVar, f2));
    }
}
