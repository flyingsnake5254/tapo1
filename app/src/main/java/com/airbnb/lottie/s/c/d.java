package com.airbnb.lottie.s.c;

import com.airbnb.lottie.model.content.c;
import com.airbnb.lottie.w.a;
import java.util.List;

/* compiled from: GradientColorKeyframeAnimation.java */
/* loaded from: classes.dex */
public class d extends f<c> {
    private final c i;

    public d(List<a<c>> list) {
        super(list);
        int i = 0;
        c cVar = list.get(0).f1160b;
        i = cVar != null ? cVar.c() : i;
        this.i = new c(new float[i], new int[i]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public c i(a<c> aVar, float f2) {
        this.i.d(aVar.f1160b, aVar.f1161c, f2);
        return this.i;
    }
}
