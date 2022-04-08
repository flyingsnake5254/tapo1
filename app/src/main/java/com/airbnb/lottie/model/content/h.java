package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import androidx.annotation.FloatRange;
import com.airbnb.lottie.model.a;
import com.airbnb.lottie.v.d;
import com.airbnb.lottie.v.g;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ShapeData.java */
/* loaded from: classes.dex */
public class h {
    private final List<a> a;

    /* renamed from: b  reason: collision with root package name */
    private PointF f1002b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1003c;

    public h(PointF pointF, boolean z, List<a> list) {
        this.f1002b = pointF;
        this.f1003c = z;
        this.a = new ArrayList(list);
    }

    private void e(float f2, float f3) {
        if (this.f1002b == null) {
            this.f1002b = new PointF();
        }
        this.f1002b.set(f2, f3);
    }

    public List<a> a() {
        return this.a;
    }

    public PointF b() {
        return this.f1002b;
    }

    public void c(h hVar, h hVar2, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.f1002b == null) {
            this.f1002b = new PointF();
        }
        this.f1003c = hVar.d() || hVar2.d();
        if (hVar.a().size() != hVar2.a().size()) {
            d.c("Curves must have the same number of control points. Shape 1: " + hVar.a().size() + "\tShape 2: " + hVar2.a().size());
        }
        int min = Math.min(hVar.a().size(), hVar2.a().size());
        if (this.a.size() < min) {
            for (int size = this.a.size(); size < min; size++) {
                this.a.add(new a());
            }
        } else if (this.a.size() > min) {
            for (int size2 = this.a.size() - 1; size2 >= min; size2--) {
                List<a> list = this.a;
                list.remove(list.size() - 1);
            }
        }
        PointF b2 = hVar.b();
        PointF b3 = hVar2.b();
        e(g.j(b2.x, b3.x, f2), g.j(b2.y, b3.y, f2));
        for (int size3 = this.a.size() - 1; size3 >= 0; size3--) {
            a aVar = hVar.a().get(size3);
            a aVar2 = hVar2.a().get(size3);
            PointF a = aVar.a();
            PointF b4 = aVar.b();
            PointF c2 = aVar.c();
            PointF a2 = aVar2.a();
            PointF b5 = aVar2.b();
            PointF c3 = aVar2.c();
            this.a.get(size3).d(g.j(a.x, a2.x, f2), g.j(a.y, a2.y, f2));
            this.a.get(size3).e(g.j(b4.x, b5.x, f2), g.j(b4.y, b5.y, f2));
            this.a.get(size3).f(g.j(c2.x, c3.x, f2), g.j(c2.y, c3.y, f2));
        }
    }

    public boolean d() {
        return this.f1003c;
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.a.size() + "closed=" + this.f1003c + '}';
    }

    public h() {
        this.a = new ArrayList();
    }
}
