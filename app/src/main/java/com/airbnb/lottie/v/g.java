package com.airbnb.lottie.v;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.FloatRange;
import com.airbnb.lottie.model.a;
import com.airbnb.lottie.model.content.h;
import com.airbnb.lottie.model.d;
import com.airbnb.lottie.s.b.k;
import java.util.List;

/* compiled from: MiscUtils.java */
/* loaded from: classes.dex */
public class g {
    private static PointF a = new PointF();

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static float b(float f2, float f3, float f4) {
        return Math.max(f3, Math.min(f4, f2));
    }

    public static int c(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public static boolean d(float f2, float f3, float f4) {
        return f2 >= f3 && f2 <= f4;
    }

    private static int e(int i, int i2) {
        int i3 = i / i2;
        return (((i ^ i2) >= 0) || i % i2 == 0) ? i3 : i3 - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(float f2, float f3) {
        return g((int) f2, (int) f3);
    }

    private static int g(int i, int i2) {
        return i - (i2 * e(i, i2));
    }

    public static void h(h hVar, Path path) {
        path.reset();
        PointF b2 = hVar.b();
        path.moveTo(b2.x, b2.y);
        a.set(b2.x, b2.y);
        for (int i = 0; i < hVar.a().size(); i++) {
            a aVar = hVar.a().get(i);
            PointF a2 = aVar.a();
            PointF b3 = aVar.b();
            PointF c2 = aVar.c();
            if (!a2.equals(a) || !b3.equals(c2)) {
                path.cubicTo(a2.x, a2.y, b3.x, b3.y, c2.x, c2.y);
            } else {
                path.lineTo(c2.x, c2.y);
            }
            a.set(c2.x, c2.y);
        }
        if (hVar.d()) {
            path.close();
        }
    }

    public static double i(double d2, double d3, @FloatRange(from = 0.0d, to = 1.0d) double d4) {
        return d2 + (d4 * (d3 - d2));
    }

    public static float j(float f2, float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    public static int k(int i, int i2, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return (int) (i + (f2 * (i2 - i)));
    }

    public static void l(d dVar, int i, List<d> list, d dVar2, k kVar) {
        if (dVar.c(kVar.getName(), i)) {
            list.add(dVar2.a(kVar.getName()).j(kVar));
        }
    }
}
