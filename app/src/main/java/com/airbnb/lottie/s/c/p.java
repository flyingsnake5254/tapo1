package com.airbnb.lottie.s.c;

import androidx.annotation.Nullable;
import com.airbnb.lottie.w.a;
import com.airbnb.lottie.w.b;
import com.airbnb.lottie.w.c;
import java.util.Collections;

/* compiled from: ValueCallbackKeyframeAnimation.java */
/* loaded from: classes.dex */
public class p<K, A> extends a<K, A> {
    private final b<A> i;
    private final A j;

    public p(c<A> cVar) {
        this(cVar, null);
    }

    @Override // com.airbnb.lottie.s.c.a
    float c() {
        return 1.0f;
    }

    @Override // com.airbnb.lottie.s.c.a
    public A h() {
        c<A> cVar = this.f1113e;
        A a = this.j;
        return cVar.b(0.0f, 0.0f, a, a, f(), f(), f());
    }

    @Override // com.airbnb.lottie.s.c.a
    A i(a<K> aVar, float f2) {
        return h();
    }

    @Override // com.airbnb.lottie.s.c.a
    public void j() {
        if (this.f1113e != null) {
            super.j();
        }
    }

    @Override // com.airbnb.lottie.s.c.a
    public void l(float f2) {
        this.f1112d = f2;
    }

    public p(c<A> cVar, @Nullable A a) {
        super(Collections.emptyList());
        this.i = new b<>();
        m(cVar);
        this.j = a;
    }
}
