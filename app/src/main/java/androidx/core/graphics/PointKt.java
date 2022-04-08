package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.PointF;
import kotlin.jvm.internal.j;

/* compiled from: Point.kt */
/* loaded from: classes.dex */
public final class PointKt {
    public static final int component1(Point component1) {
        j.f(component1, "$this$component1");
        return component1.x;
    }

    public static final int component2(Point component2) {
        j.f(component2, "$this$component2");
        return component2.y;
    }

    public static final Point minus(Point minus, Point p) {
        j.f(minus, "$this$minus");
        j.f(p, "p");
        Point point = new Point(minus.x, minus.y);
        point.offset(-p.x, -p.y);
        return point;
    }

    public static final Point plus(Point plus, Point p) {
        j.f(plus, "$this$plus");
        j.f(p, "p");
        Point point = new Point(plus.x, plus.y);
        point.offset(p.x, p.y);
        return point;
    }

    public static final Point toPoint(PointF toPoint) {
        j.f(toPoint, "$this$toPoint");
        return new Point((int) toPoint.x, (int) toPoint.y);
    }

    public static final PointF toPointF(Point toPointF) {
        j.f(toPointF, "$this$toPointF");
        return new PointF(toPointF);
    }

    public static final Point unaryMinus(Point unaryMinus) {
        j.f(unaryMinus, "$this$unaryMinus");
        return new Point(-unaryMinus.x, -unaryMinus.y);
    }

    public static final float component1(PointF component1) {
        j.f(component1, "$this$component1");
        return component1.x;
    }

    public static final float component2(PointF component2) {
        j.f(component2, "$this$component2");
        return component2.y;
    }

    public static final PointF unaryMinus(PointF unaryMinus) {
        j.f(unaryMinus, "$this$unaryMinus");
        return new PointF(-unaryMinus.x, -unaryMinus.y);
    }

    public static final PointF minus(PointF minus, PointF p) {
        j.f(minus, "$this$minus");
        j.f(p, "p");
        PointF pointF = new PointF(minus.x, minus.y);
        pointF.offset(-p.x, -p.y);
        return pointF;
    }

    public static final PointF plus(PointF plus, PointF p) {
        j.f(plus, "$this$plus");
        j.f(p, "p");
        PointF pointF = new PointF(plus.x, plus.y);
        pointF.offset(p.x, p.y);
        return pointF;
    }

    public static final Point minus(Point minus, int i) {
        j.f(minus, "$this$minus");
        Point point = new Point(minus.x, minus.y);
        int i2 = -i;
        point.offset(i2, i2);
        return point;
    }

    public static final Point plus(Point plus, int i) {
        j.f(plus, "$this$plus");
        Point point = new Point(plus.x, plus.y);
        point.offset(i, i);
        return point;
    }

    public static final PointF minus(PointF minus, float f2) {
        j.f(minus, "$this$minus");
        PointF pointF = new PointF(minus.x, minus.y);
        float f3 = -f2;
        pointF.offset(f3, f3);
        return pointF;
    }

    public static final PointF plus(PointF plus, float f2) {
        j.f(plus, "$this$plus");
        PointF pointF = new PointF(plus.x, plus.y);
        pointF.offset(f2, f2);
        return pointF;
    }
}
