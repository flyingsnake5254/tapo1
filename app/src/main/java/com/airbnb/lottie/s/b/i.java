package com.airbnb.lottie.s.b;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.c;
import com.airbnb.lottie.model.content.e;
import com.airbnb.lottie.s.c.a;
import com.airbnb.lottie.s.c.p;

/* compiled from: GradientStrokeContent.java */
/* loaded from: classes.dex */
public class i extends a {
    private final String o;
    private final boolean p;
    private final LongSparseArray<LinearGradient> q = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> r = new LongSparseArray<>();
    private final RectF s = new RectF();
    private final GradientType t;
    private final int u;
    private final a<c, c> v;
    private final a<PointF, PointF> w;
    private final a<PointF, PointF> x;
    @Nullable
    private p y;

    public i(f fVar, com.airbnb.lottie.model.layer.a aVar, e eVar) {
        super(fVar, aVar, eVar.b().toPaintCap(), eVar.g().toPaintJoin(), eVar.i(), eVar.k(), eVar.m(), eVar.h(), eVar.c());
        this.o = eVar.j();
        this.t = eVar.f();
        this.p = eVar.n();
        this.u = (int) (fVar.m().d() / 32.0f);
        a<c, c> a = eVar.e().a();
        this.v = a;
        a.a(this);
        aVar.i(a);
        a<PointF, PointF> a2 = eVar.l().a();
        this.w = a2;
        a2.a(this);
        aVar.i(a2);
        a<PointF, PointF> a3 = eVar.d().a();
        this.x = a3;
        a3.a(this);
        aVar.i(a3);
    }

    private int[] i(int[] iArr) {
        p pVar = this.y;
        if (pVar != null) {
            Integer[] numArr = (Integer[]) pVar.h();
            int i = 0;
            if (iArr.length == numArr.length) {
                while (i < iArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i < numArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            }
        }
        return iArr;
    }

    private int j() {
        int round = Math.round(this.w.f() * this.u);
        int round2 = Math.round(this.x.f() * this.u);
        int round3 = Math.round(this.v.f() * this.u);
        int i = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        return round3 != 0 ? i * 31 * round3 : i;
    }

    private LinearGradient k() {
        long j = j();
        LinearGradient linearGradient = this.q.get(j);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF h = this.w.h();
        PointF h2 = this.x.h();
        c h3 = this.v.h();
        LinearGradient linearGradient2 = new LinearGradient(h.x, h.y, h2.x, h2.y, i(h3.a()), h3.b(), Shader.TileMode.CLAMP);
        this.q.put(j, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient l() {
        float f2;
        float f3;
        long j = j();
        RadialGradient radialGradient = this.r.get(j);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF h = this.w.h();
        PointF h2 = this.x.h();
        c h3 = this.v.h();
        int[] i = i(h3.a());
        float[] b2 = h3.b();
        RadialGradient radialGradient2 = new RadialGradient(h.x, h.y, (float) Math.hypot(h2.x - f2, h2.y - f3), i, b2, Shader.TileMode.CLAMP);
        this.r.put(j, radialGradient2);
        return radialGradient2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.s.b.a, com.airbnb.lottie.model.e
    public <T> void c(T t, @Nullable com.airbnb.lottie.w.c<T> cVar) {
        super.c(t, cVar);
        if (t == k.D) {
            p pVar = this.y;
            if (pVar != null) {
                this.f1058f.C(pVar);
            }
            if (cVar == null) {
                this.y = null;
                return;
            }
            p pVar2 = new p(cVar);
            this.y = pVar2;
            pVar2.a(this);
            this.f1058f.i(this.y);
        }
    }

    @Override // com.airbnb.lottie.s.b.a, com.airbnb.lottie.s.b.e
    public void g(Canvas canvas, Matrix matrix, int i) {
        Shader shader;
        if (!this.p) {
            e(this.s, matrix, false);
            if (this.t == GradientType.LINEAR) {
                shader = k();
            } else {
                shader = l();
            }
            shader.setLocalMatrix(matrix);
            this.i.setShader(shader);
            super.g(canvas, matrix, i);
        }
    }

    @Override // com.airbnb.lottie.s.b.c
    public String getName() {
        return this.o;
    }
}
