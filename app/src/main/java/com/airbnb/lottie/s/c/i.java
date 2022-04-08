package com.airbnb.lottie.s.c;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.w.a;
import com.airbnb.lottie.w.c;
import java.util.List;

/* compiled from: PathKeyframeAnimation.java */
/* loaded from: classes.dex */
public class i extends f<PointF> {
    private h k;
    private final PointF i = new PointF();
    private final float[] j = new float[2];
    private PathMeasure l = new PathMeasure();

    public i(List<? extends a<PointF>> list) {
        super(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: o */
    public PointF i(a<PointF> aVar, float f2) {
        PointF pointF;
        h hVar = (h) aVar;
        Path j = hVar.j();
        if (j == null) {
            return aVar.f1160b;
        }
        c<A> cVar = this.f1113e;
        if (cVar != 0 && (pointF = (PointF) cVar.b(hVar.f1163e, hVar.f1164f.floatValue(), hVar.f1160b, hVar.f1161c, e(), f2, f())) != null) {
            return pointF;
        }
        if (this.k != hVar) {
            this.l.setPath(j, false);
            this.k = hVar;
        }
        PathMeasure pathMeasure = this.l;
        pathMeasure.getPosTan(f2 * pathMeasure.getLength(), this.j, null);
        PointF pointF2 = this.i;
        float[] fArr = this.j;
        pointF2.set(fArr[0], fArr[1]);
        return this.i;
    }
}
