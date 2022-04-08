package com.airbnb.lottie.s.b;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.d;
import com.airbnb.lottie.s.c.a;
import com.airbnb.lottie.v.g;
import com.airbnb.lottie.w.c;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

/* compiled from: PolystarContent.java */
/* loaded from: classes.dex */
public class n implements m, a.b, k {

    /* renamed from: b  reason: collision with root package name */
    private final String f1085b;

    /* renamed from: c  reason: collision with root package name */
    private final f f1086c;

    /* renamed from: d  reason: collision with root package name */
    private final PolystarShape.Type f1087d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f1088e;

    /* renamed from: f  reason: collision with root package name */
    private final com.airbnb.lottie.s.c.a<?, Float> f1089f;
    private final com.airbnb.lottie.s.c.a<?, PointF> g;
    private final com.airbnb.lottie.s.c.a<?, Float> h;
    @Nullable
    private final com.airbnb.lottie.s.c.a<?, Float> i;
    private final com.airbnb.lottie.s.c.a<?, Float> j;
    @Nullable
    private final com.airbnb.lottie.s.c.a<?, Float> k;
    private final com.airbnb.lottie.s.c.a<?, Float> l;
    private boolean n;
    private final Path a = new Path();
    private b m = new b();

    /* compiled from: PolystarContent.java */
    /* loaded from: classes.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[PolystarShape.Type.values().length];
            a = iArr;
            try {
                iArr[PolystarShape.Type.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PolystarShape.Type.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public n(f fVar, com.airbnb.lottie.model.layer.a aVar, PolystarShape polystarShape) {
        this.f1086c = fVar;
        this.f1085b = polystarShape.d();
        PolystarShape.Type j = polystarShape.j();
        this.f1087d = j;
        this.f1088e = polystarShape.k();
        com.airbnb.lottie.s.c.a<Float, Float> a2 = polystarShape.g().a();
        this.f1089f = a2;
        com.airbnb.lottie.s.c.a<PointF, PointF> a3 = polystarShape.h().a();
        this.g = a3;
        com.airbnb.lottie.s.c.a<Float, Float> a4 = polystarShape.i().a();
        this.h = a4;
        com.airbnb.lottie.s.c.a<Float, Float> a5 = polystarShape.e().a();
        this.j = a5;
        com.airbnb.lottie.s.c.a<Float, Float> a6 = polystarShape.f().a();
        this.l = a6;
        PolystarShape.Type type = PolystarShape.Type.STAR;
        if (j == type) {
            this.i = polystarShape.b().a();
            this.k = polystarShape.c().a();
        } else {
            this.i = null;
            this.k = null;
        }
        aVar.i(a2);
        aVar.i(a3);
        aVar.i(a4);
        aVar.i(a5);
        aVar.i(a6);
        if (j == type) {
            aVar.i(this.i);
            aVar.i(this.k);
        }
        a2.a(this);
        a3.a(this);
        a4.a(this);
        a5.a(this);
        a6.a(this);
        if (j == type) {
            this.i.a(this);
            this.k.a(this);
        }
    }

    private void f() {
        com.airbnb.lottie.s.c.a<?, Float> aVar;
        double d2;
        double d3;
        int i;
        int floor = (int) Math.floor(this.f1089f.h().floatValue());
        double radians = Math.toRadians((this.h == null ? Utils.DOUBLE_EPSILON : aVar.h().floatValue()) - 90.0d);
        double d4 = floor;
        float floatValue = this.l.h().floatValue() / 100.0f;
        float floatValue2 = this.j.h().floatValue();
        double d5 = floatValue2;
        float cos = (float) (Math.cos(radians) * d5);
        float sin = (float) (Math.sin(radians) * d5);
        this.a.moveTo(cos, sin);
        double d6 = (float) (6.283185307179586d / d4);
        double d7 = radians + d6;
        double ceil = Math.ceil(d4);
        int i2 = 0;
        while (i2 < ceil) {
            float cos2 = (float) (Math.cos(d7) * d5);
            float sin2 = (float) (d5 * Math.sin(d7));
            if (floatValue != 0.0f) {
                d5 = d5;
                i = i2;
                d3 = d7;
                double atan2 = (float) (Math.atan2(sin, cos) - 1.5707963267948966d);
                float cos3 = (float) Math.cos(atan2);
                d2 = d6;
                double atan22 = (float) (Math.atan2(sin2, cos2) - 1.5707963267948966d);
                float f2 = floatValue2 * floatValue * 0.25f;
                this.a.cubicTo(cos - (cos3 * f2), sin - (((float) Math.sin(atan2)) * f2), cos2 + (((float) Math.cos(atan22)) * f2), sin2 + (f2 * ((float) Math.sin(atan22))), cos2, sin2);
            } else {
                d3 = d7;
                d5 = d5;
                d2 = d6;
                i = i2;
                this.a.lineTo(cos2, sin2);
            }
            d7 = d3 + d2;
            i2 = i + 1;
            sin = sin2;
            cos = cos2;
            ceil = ceil;
            d6 = d2;
        }
        PointF h = this.g.h();
        this.a.offset(h.x, h.y);
        this.a.close();
    }

    private void h() {
        com.airbnb.lottie.s.c.a<?, Float> aVar;
        double d2;
        int i;
        float f2;
        float f3;
        float f4;
        double d3;
        float f5;
        double d4;
        float floatValue = this.f1089f.h().floatValue();
        double radians = Math.toRadians((this.h == null ? Utils.DOUBLE_EPSILON : aVar.h().floatValue()) - 90.0d);
        double d5 = floatValue;
        float f6 = (float) (6.283185307179586d / d5);
        float f7 = f6 / 2.0f;
        float f8 = floatValue - ((int) floatValue);
        int i2 = (f8 > 0.0f ? 1 : (f8 == 0.0f ? 0 : -1));
        if (i2 != 0) {
            radians += (1.0f - f8) * f7;
        }
        float floatValue2 = this.j.h().floatValue();
        float floatValue3 = this.i.h().floatValue();
        com.airbnb.lottie.s.c.a<?, Float> aVar2 = this.k;
        float floatValue4 = aVar2 != null ? aVar2.h().floatValue() / 100.0f : 0.0f;
        com.airbnb.lottie.s.c.a<?, Float> aVar3 = this.l;
        float floatValue5 = aVar3 != null ? aVar3.h().floatValue() / 100.0f : 0.0f;
        if (i2 != 0) {
            f2 = ((floatValue2 - floatValue3) * f8) + floatValue3;
            i = i2;
            double d6 = f2;
            d2 = d5;
            f4 = (float) (d6 * Math.cos(radians));
            f3 = (float) (d6 * Math.sin(radians));
            this.a.moveTo(f4, f3);
            d3 = radians + ((f6 * f8) / 2.0f);
        } else {
            d2 = d5;
            i = i2;
            double d7 = floatValue2;
            float cos = (float) (Math.cos(radians) * d7);
            float sin = (float) (d7 * Math.sin(radians));
            this.a.moveTo(cos, sin);
            d3 = radians + f7;
            f4 = cos;
            f3 = sin;
            f2 = 0.0f;
        }
        double ceil = Math.ceil(d2) * 2.0d;
        int i3 = 0;
        boolean z = false;
        while (true) {
            double d8 = i3;
            if (d8 < ceil) {
                float f9 = z ? floatValue2 : floatValue3;
                int i4 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                if (i4 == 0 || d8 != ceil - 2.0d) {
                    f6 = f6;
                    f5 = f7;
                } else {
                    f5 = (f6 * f8) / 2.0f;
                    f6 = f6;
                }
                if (i4 == 0 || d8 != ceil - 1.0d) {
                    f7 = f7;
                    d4 = d8;
                } else {
                    f7 = f7;
                    d4 = d8;
                    f9 = f2;
                }
                double d9 = f9;
                float cos2 = (float) (d9 * Math.cos(d3));
                float sin2 = (float) (d9 * Math.sin(d3));
                if (floatValue4 == 0.0f && floatValue5 == 0.0f) {
                    this.a.lineTo(cos2, sin2);
                    floatValue4 = floatValue4;
                    f2 = f2;
                } else {
                    floatValue4 = floatValue4;
                    f2 = f2;
                    double atan2 = (float) (Math.atan2(f3, f4) - 1.5707963267948966d);
                    float cos3 = (float) Math.cos(atan2);
                    float sin3 = (float) Math.sin(atan2);
                    double atan22 = (float) (Math.atan2(sin2, cos2) - 1.5707963267948966d);
                    float cos4 = (float) Math.cos(atan22);
                    float sin4 = (float) Math.sin(atan22);
                    float f10 = z ? floatValue4 : floatValue5;
                    float f11 = z ? floatValue5 : floatValue4;
                    float f12 = (z ? floatValue3 : floatValue2) * f10 * 0.47829f;
                    float f13 = cos3 * f12;
                    float f14 = f12 * sin3;
                    float f15 = (z ? floatValue2 : floatValue3) * f11 * 0.47829f;
                    float f16 = cos4 * f15;
                    float f17 = f15 * sin4;
                    if (i != 0) {
                        if (i3 == 0) {
                            f13 *= f8;
                            f14 *= f8;
                        } else if (d4 == ceil - 1.0d) {
                            f16 *= f8;
                            f17 *= f8;
                        }
                    }
                    this.a.cubicTo(f4 - f13, f3 - f14, cos2 + f16, sin2 + f17, cos2, sin2);
                }
                d3 += f5;
                z = !z;
                i3++;
                f4 = cos2;
                f3 = sin2;
                ceil = ceil;
            } else {
                PointF h = this.g.h();
                this.a.offset(h.x, h.y);
                this.a.close();
                return;
            }
        }
    }

    private void i() {
        this.n = false;
        this.f1086c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.s.c.a.b
    public void a() {
        i();
    }

    @Override // com.airbnb.lottie.s.b.c
    public void b(List<c> list, List<c> list2) {
        for (int i = 0; i < list.size(); i++) {
            c cVar = list.get(i);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.i() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.m.a(sVar);
                    sVar.c(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.model.e
    public <T> void c(T t, @Nullable c<T> cVar) {
        com.airbnb.lottie.s.c.a<?, Float> aVar;
        com.airbnb.lottie.s.c.a<?, Float> aVar2;
        if (t == k.s) {
            this.f1089f.m(cVar);
        } else if (t == k.t) {
            this.h.m(cVar);
        } else if (t == k.j) {
            this.g.m(cVar);
        } else if (t == k.u && (aVar2 = this.i) != null) {
            aVar2.m(cVar);
        } else if (t == k.v) {
            this.j.m(cVar);
        } else if (t == k.w && (aVar = this.k) != null) {
            aVar.m(cVar);
        } else if (t == k.x) {
            this.l.m(cVar);
        }
    }

    @Override // com.airbnb.lottie.model.e
    public void d(d dVar, int i, List<d> list, d dVar2) {
        g.l(dVar, i, list, dVar2, this);
    }

    @Override // com.airbnb.lottie.s.b.c
    public String getName() {
        return this.f1085b;
    }

    @Override // com.airbnb.lottie.s.b.m
    public Path getPath() {
        if (this.n) {
            return this.a;
        }
        this.a.reset();
        if (this.f1088e) {
            this.n = true;
            return this.a;
        }
        int i = a.a[this.f1087d.ordinal()];
        if (i == 1) {
            h();
        } else if (i == 2) {
            f();
        }
        this.a.close();
        this.m.b(this.a);
        this.n = true;
        return this.a;
    }
}
