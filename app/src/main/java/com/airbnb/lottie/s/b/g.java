package com.airbnb.lottie.s.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.model.content.i;
import com.airbnb.lottie.model.d;
import com.airbnb.lottie.s.c.a;
import com.airbnb.lottie.s.c.b;
import com.airbnb.lottie.s.c.p;
import com.airbnb.lottie.w.c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FillContent.java */
/* loaded from: classes.dex */
public class g implements e, a.b, k {
    private final Path a;

    /* renamed from: c  reason: collision with root package name */
    private final com.airbnb.lottie.model.layer.a f1071c;

    /* renamed from: d  reason: collision with root package name */
    private final String f1072d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f1073e;
    private final a<Integer, Integer> g;
    private final a<Integer, Integer> h;
    @Nullable
    private a<ColorFilter, ColorFilter> i;
    private final f j;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f1070b = new com.airbnb.lottie.s.a(1);

    /* renamed from: f  reason: collision with root package name */
    private final List<m> f1074f = new ArrayList();

    public g(f fVar, com.airbnb.lottie.model.layer.a aVar, i iVar) {
        Path path = new Path();
        this.a = path;
        this.f1071c = aVar;
        this.f1072d = iVar.d();
        this.f1073e = iVar.f();
        this.j = fVar;
        if (iVar.b() == null || iVar.e() == null) {
            this.g = null;
            this.h = null;
            return;
        }
        path.setFillType(iVar.c());
        a<Integer, Integer> a = iVar.b().a();
        this.g = a;
        a.a(this);
        aVar.i(a);
        a<Integer, Integer> a2 = iVar.e().a();
        this.h = a2;
        a2.a(this);
        aVar.i(a2);
    }

    @Override // com.airbnb.lottie.s.c.a.b
    public void a() {
        this.j.invalidateSelf();
    }

    @Override // com.airbnb.lottie.s.b.c
    public void b(List<c> list, List<c> list2) {
        for (int i = 0; i < list2.size(); i++) {
            c cVar = list2.get(i);
            if (cVar instanceof m) {
                this.f1074f.add((m) cVar);
            }
        }
    }

    @Override // com.airbnb.lottie.model.e
    public <T> void c(T t, @Nullable c<T> cVar) {
        if (t == k.a) {
            this.g.m(cVar);
        } else if (t == k.f933d) {
            this.h.m(cVar);
        } else if (t == k.C) {
            a<ColorFilter, ColorFilter> aVar = this.i;
            if (aVar != null) {
                this.f1071c.C(aVar);
            }
            if (cVar == null) {
                this.i = null;
                return;
            }
            p pVar = new p(cVar);
            this.i = pVar;
            pVar.a(this);
            this.f1071c.i(this.i);
        }
    }

    @Override // com.airbnb.lottie.model.e
    public void d(d dVar, int i, List<d> list, d dVar2) {
        com.airbnb.lottie.v.g.l(dVar, i, list, dVar2, this);
    }

    @Override // com.airbnb.lottie.s.b.e
    public void e(RectF rectF, Matrix matrix, boolean z) {
        this.a.reset();
        for (int i = 0; i < this.f1074f.size(); i++) {
            this.a.addPath(this.f1074f.get(i).getPath(), matrix);
        }
        this.a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.s.b.e
    public void g(Canvas canvas, Matrix matrix, int i) {
        if (!this.f1073e) {
            com.airbnb.lottie.c.a("FillContent#draw");
            this.f1070b.setColor(((b) this.g).o());
            this.f1070b.setAlpha(com.airbnb.lottie.v.g.c((int) ((((i / 255.0f) * this.h.h().intValue()) / 100.0f) * 255.0f), 0, 255));
            a<ColorFilter, ColorFilter> aVar = this.i;
            if (aVar != null) {
                this.f1070b.setColorFilter(aVar.h());
            }
            this.a.reset();
            for (int i2 = 0; i2 < this.f1074f.size(); i2++) {
                this.a.addPath(this.f1074f.get(i2).getPath(), matrix);
            }
            canvas.drawPath(this.a, this.f1070b);
            com.airbnb.lottie.c.b("FillContent#draw");
        }
    }

    @Override // com.airbnb.lottie.s.b.c
    public String getName() {
        return this.f1072d;
    }
}
