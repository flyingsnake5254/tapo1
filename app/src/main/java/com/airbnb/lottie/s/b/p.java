package com.airbnb.lottie.s.b;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.model.content.g;
import com.airbnb.lottie.model.d;
import com.airbnb.lottie.s.c.a;
import com.airbnb.lottie.s.c.o;
import com.airbnb.lottie.w.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* compiled from: RepeaterContent.java */
/* loaded from: classes.dex */
public class p implements e, m, j, a.b, k {
    private final Matrix a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    private final Path f1095b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final f f1096c;

    /* renamed from: d  reason: collision with root package name */
    private final com.airbnb.lottie.model.layer.a f1097d;

    /* renamed from: e  reason: collision with root package name */
    private final String f1098e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f1099f;
    private final a<Float, Float> g;
    private final a<Float, Float> h;
    private final o i;
    private d j;

    public p(f fVar, com.airbnb.lottie.model.layer.a aVar, g gVar) {
        this.f1096c = fVar;
        this.f1097d = aVar;
        this.f1098e = gVar.c();
        this.f1099f = gVar.f();
        a<Float, Float> a = gVar.b().a();
        this.g = a;
        aVar.i(a);
        a.a(this);
        a<Float, Float> a2 = gVar.d().a();
        this.h = a2;
        aVar.i(a2);
        a2.a(this);
        o b2 = gVar.e().b();
        this.i = b2;
        b2.a(aVar);
        b2.b(this);
    }

    @Override // com.airbnb.lottie.s.c.a.b
    public void a() {
        this.f1096c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.s.b.c
    public void b(List<c> list, List<c> list2) {
        this.j.b(list, list2);
    }

    @Override // com.airbnb.lottie.model.e
    public <T> void c(T t, @Nullable c<T> cVar) {
        if (!this.i.c(t, cVar)) {
            if (t == k.q) {
                this.g.m(cVar);
            } else if (t == k.r) {
                this.h.m(cVar);
            }
        }
    }

    @Override // com.airbnb.lottie.model.e
    public void d(d dVar, int i, List<d> list, d dVar2) {
        com.airbnb.lottie.v.g.l(dVar, i, list, dVar2, this);
    }

    @Override // com.airbnb.lottie.s.b.e
    public void e(RectF rectF, Matrix matrix, boolean z) {
        this.j.e(rectF, matrix, z);
    }

    @Override // com.airbnb.lottie.s.b.j
    public void f(ListIterator<c> listIterator) {
        if (this.j == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.j = new d(this.f1096c, this.f1097d, "Repeater", this.f1099f, arrayList, null);
        }
    }

    @Override // com.airbnb.lottie.s.b.e
    public void g(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.g.h().floatValue();
        float floatValue2 = this.h.h().floatValue();
        float floatValue3 = this.i.i().h().floatValue() / 100.0f;
        float floatValue4 = this.i.e().h().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.a.set(matrix);
            float f2 = i2;
            this.a.preConcat(this.i.g(f2 + floatValue2));
            this.j.g(canvas, this.a, (int) (i * com.airbnb.lottie.v.g.j(floatValue3, floatValue4, f2 / floatValue)));
        }
    }

    @Override // com.airbnb.lottie.s.b.c
    public String getName() {
        return this.f1098e;
    }

    @Override // com.airbnb.lottie.s.b.m
    public Path getPath() {
        Path path = this.j.getPath();
        this.f1095b.reset();
        float floatValue = this.g.h().floatValue();
        float floatValue2 = this.h.h().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.a.set(this.i.g(i + floatValue2));
            this.f1095b.addPath(path, this.a);
        }
        return this.f1095b;
    }
}
