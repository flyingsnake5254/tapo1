package com.airbnb.lottie.s.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import androidx.annotation.Nullable;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.layer.a;
import com.airbnb.lottie.s.c.b;
import com.airbnb.lottie.s.c.p;
import com.airbnb.lottie.w.c;

/* compiled from: StrokeContent.java */
/* loaded from: classes.dex */
public class r extends a {
    private final a o;
    private final String p;
    private final boolean q;
    private final com.airbnb.lottie.s.c.a<Integer, Integer> r;
    @Nullable
    private com.airbnb.lottie.s.c.a<ColorFilter, ColorFilter> s;

    public r(f fVar, a aVar, ShapeStroke shapeStroke) {
        super(fVar, aVar, shapeStroke.b().toPaintCap(), shapeStroke.e().toPaintJoin(), shapeStroke.g(), shapeStroke.i(), shapeStroke.j(), shapeStroke.f(), shapeStroke.d());
        this.o = aVar;
        this.p = shapeStroke.h();
        this.q = shapeStroke.k();
        com.airbnb.lottie.s.c.a<Integer, Integer> a = shapeStroke.c().a();
        this.r = a;
        a.a(this);
        aVar.i(a);
    }

    @Override // com.airbnb.lottie.s.b.a, com.airbnb.lottie.model.e
    public <T> void c(T t, @Nullable c<T> cVar) {
        super.c(t, cVar);
        if (t == k.f931b) {
            this.r.m(cVar);
        } else if (t == k.C) {
            com.airbnb.lottie.s.c.a<ColorFilter, ColorFilter> aVar = this.s;
            if (aVar != null) {
                this.o.C(aVar);
            }
            if (cVar == null) {
                this.s = null;
                return;
            }
            p pVar = new p(cVar);
            this.s = pVar;
            pVar.a(this);
            this.o.i(this.r);
        }
    }

    @Override // com.airbnb.lottie.s.b.a, com.airbnb.lottie.s.b.e
    public void g(Canvas canvas, Matrix matrix, int i) {
        if (!this.q) {
            this.i.setColor(((b) this.r).o());
            com.airbnb.lottie.s.c.a<ColorFilter, ColorFilter> aVar = this.s;
            if (aVar != null) {
                this.i.setColorFilter(aVar.h());
            }
            super.g(canvas, matrix, i);
        }
    }

    @Override // com.airbnb.lottie.s.b.c
    public String getName() {
        return this.p;
    }
}
