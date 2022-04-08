package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import kotlin.jvm.internal.j;

/* compiled from: Rect.kt */
/* loaded from: classes.dex */
public final class RectKt {
    @SuppressLint({"CheckResult"})
    public static final Rect and(Rect and, Rect r) {
        j.f(and, "$this$and");
        j.f(r, "r");
        Rect rect = new Rect(and);
        rect.intersect(r);
        return rect;
    }

    public static final int component1(Rect component1) {
        j.f(component1, "$this$component1");
        return component1.left;
    }

    public static final int component2(Rect component2) {
        j.f(component2, "$this$component2");
        return component2.top;
    }

    public static final int component3(Rect component3) {
        j.f(component3, "$this$component3");
        return component3.right;
    }

    public static final int component4(Rect component4) {
        j.f(component4, "$this$component4");
        return component4.bottom;
    }

    public static final boolean contains(Rect contains, Point p) {
        j.f(contains, "$this$contains");
        j.f(p, "p");
        return contains.contains(p.x, p.y);
    }

    public static final Region minus(Rect minus, Rect r) {
        j.f(minus, "$this$minus");
        j.f(r, "r");
        Region region = new Region(minus);
        region.op(r, Region.Op.DIFFERENCE);
        return region;
    }

    public static final Rect or(Rect or, Rect r) {
        j.f(or, "$this$or");
        j.f(r, "r");
        Rect rect = new Rect(or);
        rect.union(r);
        return rect;
    }

    public static final Rect plus(Rect plus, Rect r) {
        j.f(plus, "$this$plus");
        j.f(r, "r");
        Rect rect = new Rect(plus);
        rect.union(r);
        return rect;
    }

    public static final Rect times(Rect times, int i) {
        j.f(times, "$this$times");
        Rect rect = new Rect(times);
        rect.top *= i;
        rect.left *= i;
        rect.right *= i;
        rect.bottom *= i;
        return rect;
    }

    public static final Rect toRect(RectF toRect) {
        j.f(toRect, "$this$toRect");
        Rect rect = new Rect();
        toRect.roundOut(rect);
        return rect;
    }

    public static final RectF toRectF(Rect toRectF) {
        j.f(toRectF, "$this$toRectF");
        return new RectF(toRectF);
    }

    public static final Region toRegion(Rect toRegion) {
        j.f(toRegion, "$this$toRegion");
        return new Region(toRegion);
    }

    public static final RectF transform(RectF transform, Matrix m) {
        j.f(transform, "$this$transform");
        j.f(m, "m");
        m.mapRect(transform);
        return transform;
    }

    public static final Region xor(Rect xor, Rect r) {
        j.f(xor, "$this$xor");
        j.f(r, "r");
        Region region = new Region(xor);
        region.op(r, Region.Op.XOR);
        return region;
    }

    public static final float component1(RectF component1) {
        j.f(component1, "$this$component1");
        return component1.left;
    }

    public static final float component2(RectF component2) {
        j.f(component2, "$this$component2");
        return component2.top;
    }

    public static final float component3(RectF component3) {
        j.f(component3, "$this$component3");
        return component3.right;
    }

    public static final float component4(RectF component4) {
        j.f(component4, "$this$component4");
        return component4.bottom;
    }

    public static final boolean contains(RectF contains, PointF p) {
        j.f(contains, "$this$contains");
        j.f(p, "p");
        return contains.contains(p.x, p.y);
    }

    public static final Region toRegion(RectF toRegion) {
        j.f(toRegion, "$this$toRegion");
        Rect rect = new Rect();
        toRegion.roundOut(rect);
        return new Region(rect);
    }

    @SuppressLint({"CheckResult"})
    public static final RectF and(RectF and, RectF r) {
        j.f(and, "$this$and");
        j.f(r, "r");
        RectF rectF = new RectF(and);
        rectF.intersect(r);
        return rectF;
    }

    public static final Rect minus(Rect minus, int i) {
        j.f(minus, "$this$minus");
        Rect rect = new Rect(minus);
        int i2 = -i;
        rect.offset(i2, i2);
        return rect;
    }

    public static final RectF or(RectF or, RectF r) {
        j.f(or, "$this$or");
        j.f(r, "r");
        RectF rectF = new RectF(or);
        rectF.union(r);
        return rectF;
    }

    public static final RectF plus(RectF plus, RectF r) {
        j.f(plus, "$this$plus");
        j.f(r, "r");
        RectF rectF = new RectF(plus);
        rectF.union(r);
        return rectF;
    }

    public static final Region xor(RectF xor, RectF r) {
        j.f(xor, "$this$xor");
        j.f(r, "r");
        Rect rect = new Rect();
        xor.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        r.roundOut(rect2);
        region.op(rect2, Region.Op.XOR);
        return region;
    }

    public static final RectF minus(RectF minus, float f2) {
        j.f(minus, "$this$minus");
        RectF rectF = new RectF(minus);
        float f3 = -f2;
        rectF.offset(f3, f3);
        return rectF;
    }

    public static final Rect plus(Rect plus, int i) {
        j.f(plus, "$this$plus");
        Rect rect = new Rect(plus);
        rect.offset(i, i);
        return rect;
    }

    public static final RectF times(RectF times, float f2) {
        j.f(times, "$this$times");
        RectF rectF = new RectF(times);
        rectF.top *= f2;
        rectF.left *= f2;
        rectF.right *= f2;
        rectF.bottom *= f2;
        return rectF;
    }

    public static final Rect minus(Rect minus, Point xy) {
        j.f(minus, "$this$minus");
        j.f(xy, "xy");
        Rect rect = new Rect(minus);
        rect.offset(-xy.x, -xy.y);
        return rect;
    }

    public static final RectF plus(RectF plus, float f2) {
        j.f(plus, "$this$plus");
        RectF rectF = new RectF(plus);
        rectF.offset(f2, f2);
        return rectF;
    }

    public static final RectF minus(RectF minus, PointF xy) {
        j.f(minus, "$this$minus");
        j.f(xy, "xy");
        RectF rectF = new RectF(minus);
        rectF.offset(-xy.x, -xy.y);
        return rectF;
    }

    public static final Rect plus(Rect plus, Point xy) {
        j.f(plus, "$this$plus");
        j.f(xy, "xy");
        Rect rect = new Rect(plus);
        rect.offset(xy.x, xy.y);
        return rect;
    }

    public static final Region minus(RectF minus, RectF r) {
        j.f(minus, "$this$minus");
        j.f(r, "r");
        Rect rect = new Rect();
        minus.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        r.roundOut(rect2);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    public static final RectF plus(RectF plus, PointF xy) {
        j.f(plus, "$this$plus");
        j.f(xy, "xy");
        RectF rectF = new RectF(plus);
        rectF.offset(xy.x, xy.y);
        return rectF;
    }

    public static final RectF times(RectF times, int i) {
        j.f(times, "$this$times");
        float f2 = i;
        RectF rectF = new RectF(times);
        rectF.top *= f2;
        rectF.left *= f2;
        rectF.right *= f2;
        rectF.bottom *= f2;
        return rectF;
    }
}
