package com.airbnb.lottie.s.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.airbnb.lottie.c;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.i.d;
import com.airbnb.lottie.s.c.a;
import com.airbnb.lottie.s.c.e;
import com.airbnb.lottie.s.c.p;
import com.airbnb.lottie.v.g;
import com.airbnb.lottie.v.h;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseStrokeContent.java */
/* loaded from: classes.dex */
public abstract class a implements a.b, k, e {

    /* renamed from: e  reason: collision with root package name */
    private final f f1057e;

    /* renamed from: f  reason: collision with root package name */
    protected final com.airbnb.lottie.model.layer.a f1058f;
    private final float[] h;
    final Paint i;
    private final com.airbnb.lottie.s.c.a<?, Float> j;
    private final com.airbnb.lottie.s.c.a<?, Integer> k;
    private final List<com.airbnb.lottie.s.c.a<?, Float>> l;
    @Nullable
    private final com.airbnb.lottie.s.c.a<?, Float> m;
    @Nullable
    private com.airbnb.lottie.s.c.a<ColorFilter, ColorFilter> n;
    private final PathMeasure a = new PathMeasure();

    /* renamed from: b  reason: collision with root package name */
    private final Path f1054b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final Path f1055c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final RectF f1056d = new RectF();
    private final List<b> g = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BaseStrokeContent.java */
    /* loaded from: classes.dex */
    public static final class b {
        private final List<m> a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private final s f1059b;

        private b(@Nullable s sVar) {
            this.a = new ArrayList();
            this.f1059b = sVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(f fVar, com.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f2, d dVar, com.airbnb.lottie.model.i.b bVar, List<com.airbnb.lottie.model.i.b> list, com.airbnb.lottie.model.i.b bVar2) {
        com.airbnb.lottie.s.a aVar2 = new com.airbnb.lottie.s.a(1);
        this.i = aVar2;
        this.f1057e = fVar;
        this.f1058f = aVar;
        aVar2.setStyle(Paint.Style.STROKE);
        aVar2.setStrokeCap(cap);
        aVar2.setStrokeJoin(join);
        aVar2.setStrokeMiter(f2);
        this.k = dVar.a();
        this.j = bVar.a();
        if (bVar2 == null) {
            this.m = null;
        } else {
            this.m = bVar2.a();
        }
        this.l = new ArrayList(list.size());
        this.h = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.l.add(list.get(i).a());
        }
        aVar.i(this.k);
        aVar.i(this.j);
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            aVar.i(this.l.get(i2));
        }
        com.airbnb.lottie.s.c.a<?, Float> aVar3 = this.m;
        if (aVar3 != null) {
            aVar.i(aVar3);
        }
        this.k.a(this);
        this.j.a(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.l.get(i3).a(this);
        }
        com.airbnb.lottie.s.c.a<?, Float> aVar4 = this.m;
        if (aVar4 != null) {
            aVar4.a(this);
        }
    }

    private void f(Matrix matrix) {
        c.a("StrokeContent#applyDashPattern");
        if (this.l.isEmpty()) {
            c.b("StrokeContent#applyDashPattern");
            return;
        }
        float g = h.g(matrix);
        for (int i = 0; i < this.l.size(); i++) {
            this.h[i] = this.l.get(i).h().floatValue();
            if (i % 2 == 0) {
                float[] fArr = this.h;
                if (fArr[i] < 1.0f) {
                    fArr[i] = 1.0f;
                }
            } else {
                float[] fArr2 = this.h;
                if (fArr2[i] < 0.1f) {
                    fArr2[i] = 0.1f;
                }
            }
            float[] fArr3 = this.h;
            fArr3[i] = fArr3[i] * g;
        }
        com.airbnb.lottie.s.c.a<?, Float> aVar = this.m;
        this.i.setPathEffect(new DashPathEffect(this.h, aVar == null ? 0.0f : g * aVar.h().floatValue()));
        c.b("StrokeContent#applyDashPattern");
    }

    private void h(Canvas canvas, b bVar, Matrix matrix) {
        c.a("StrokeContent#applyTrimPath");
        if (bVar.f1059b == null) {
            c.b("StrokeContent#applyTrimPath");
            return;
        }
        this.f1054b.reset();
        for (int size = bVar.a.size() - 1; size >= 0; size--) {
            this.f1054b.addPath(((m) bVar.a.get(size)).getPath(), matrix);
        }
        this.a.setPath(this.f1054b, false);
        float length = this.a.getLength();
        while (this.a.nextContour()) {
            length += this.a.getLength();
        }
        float floatValue = (bVar.f1059b.f().h().floatValue() * length) / 360.0f;
        float floatValue2 = ((bVar.f1059b.h().h().floatValue() * length) / 100.0f) + floatValue;
        float floatValue3 = ((bVar.f1059b.d().h().floatValue() * length) / 100.0f) + floatValue;
        float f2 = 0.0f;
        for (int size2 = bVar.a.size() - 1; size2 >= 0; size2--) {
            this.f1055c.set(((m) bVar.a.get(size2)).getPath());
            this.f1055c.transform(matrix);
            this.a.setPath(this.f1055c, false);
            float length2 = this.a.getLength();
            float f3 = 1.0f;
            if (floatValue3 > length) {
                float f4 = floatValue3 - length;
                if (f4 < f2 + length2 && f2 < f4) {
                    h.a(this.f1055c, floatValue2 > length ? (floatValue2 - length) / length2 : 0.0f, Math.min(f4 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.f1055c, this.i);
                    f2 += length2;
                }
            }
            float f5 = f2 + length2;
            if (f5 >= floatValue2 && f2 <= floatValue3) {
                if (f5 > floatValue3 || floatValue2 >= f2) {
                    float f6 = floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2;
                    if (floatValue3 <= f5) {
                        f3 = (floatValue3 - f2) / length2;
                    }
                    h.a(this.f1055c, f6, f3, 0.0f);
                    canvas.drawPath(this.f1055c, this.i);
                } else {
                    canvas.drawPath(this.f1055c, this.i);
                }
            }
            f2 += length2;
        }
        c.b("StrokeContent#applyTrimPath");
    }

    @Override // com.airbnb.lottie.s.c.a.b
    public void a() {
        this.f1057e.invalidateSelf();
    }

    @Override // com.airbnb.lottie.s.b.c
    public void b(List<c> list, List<c> list2) {
        s sVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = list.get(size);
            if (cVar instanceof s) {
                s sVar2 = (s) cVar;
                if (sVar2.i() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    sVar = sVar2;
                }
            }
        }
        if (sVar != null) {
            sVar.c(this);
        }
        b bVar = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            c cVar2 = list2.get(size2);
            if (cVar2 instanceof s) {
                s sVar3 = (s) cVar2;
                if (sVar3.i() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    if (bVar != null) {
                        this.g.add(bVar);
                    }
                    bVar = new b(sVar3);
                    sVar3.c(this);
                }
            }
            if (cVar2 instanceof m) {
                if (bVar == null) {
                    bVar = new b(sVar);
                }
                bVar.a.add((m) cVar2);
            }
        }
        if (bVar != null) {
            this.g.add(bVar);
        }
    }

    @Override // com.airbnb.lottie.model.e
    @CallSuper
    public <T> void c(T t, @Nullable com.airbnb.lottie.w.c<T> cVar) {
        if (t == k.f933d) {
            this.k.m(cVar);
        } else if (t == k.o) {
            this.j.m(cVar);
        } else if (t == k.C) {
            com.airbnb.lottie.s.c.a<ColorFilter, ColorFilter> aVar = this.n;
            if (aVar != null) {
                this.f1058f.C(aVar);
            }
            if (cVar == null) {
                this.n = null;
                return;
            }
            p pVar = new p(cVar);
            this.n = pVar;
            pVar.a(this);
            this.f1058f.i(this.n);
        }
    }

    @Override // com.airbnb.lottie.model.e
    public void d(com.airbnb.lottie.model.d dVar, int i, List<com.airbnb.lottie.model.d> list, com.airbnb.lottie.model.d dVar2) {
        g.l(dVar, i, list, dVar2, this);
    }

    @Override // com.airbnb.lottie.s.b.e
    public void e(RectF rectF, Matrix matrix, boolean z) {
        c.a("StrokeContent#getBounds");
        this.f1054b.reset();
        for (int i = 0; i < this.g.size(); i++) {
            b bVar = this.g.get(i);
            for (int i2 = 0; i2 < bVar.a.size(); i2++) {
                this.f1054b.addPath(((m) bVar.a.get(i2)).getPath(), matrix);
            }
        }
        this.f1054b.computeBounds(this.f1056d, false);
        float o = ((com.airbnb.lottie.s.c.c) this.j).o();
        RectF rectF2 = this.f1056d;
        float f2 = o / 2.0f;
        rectF2.set(rectF2.left - f2, rectF2.top - f2, rectF2.right + f2, rectF2.bottom + f2);
        rectF.set(this.f1056d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        c.b("StrokeContent#getBounds");
    }

    @Override // com.airbnb.lottie.s.b.e
    public void g(Canvas canvas, Matrix matrix, int i) {
        c.a("StrokeContent#draw");
        if (h.h(matrix)) {
            c.b("StrokeContent#draw");
            return;
        }
        this.i.setAlpha(g.c((int) ((((i / 255.0f) * ((e) this.k).o()) / 100.0f) * 255.0f), 0, 255));
        this.i.setStrokeWidth(((com.airbnb.lottie.s.c.c) this.j).o() * h.g(matrix));
        if (this.i.getStrokeWidth() <= 0.0f) {
            c.b("StrokeContent#draw");
            return;
        }
        f(matrix);
        com.airbnb.lottie.s.c.a<ColorFilter, ColorFilter> aVar = this.n;
        if (aVar != null) {
            this.i.setColorFilter(aVar.h());
        }
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            b bVar = this.g.get(i2);
            if (bVar.f1059b != null) {
                h(canvas, bVar, matrix);
            } else {
                c.a("StrokeContent#buildPath");
                this.f1054b.reset();
                for (int size = bVar.a.size() - 1; size >= 0; size--) {
                    this.f1054b.addPath(((m) bVar.a.get(size)).getPath(), matrix);
                }
                c.b("StrokeContent#buildPath");
                c.a("StrokeContent#drawPath");
                canvas.drawPath(this.f1054b, this.i);
                c.b("StrokeContent#drawPath");
            }
        }
        c.b("StrokeContent#draw");
    }
}
