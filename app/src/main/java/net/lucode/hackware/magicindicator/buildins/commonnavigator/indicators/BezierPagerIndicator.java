package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.Arrays;
import java.util.List;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a;
import net.lucode.hackware.magicindicator.g.b;

/* loaded from: classes4.dex */
public class BezierPagerIndicator extends View implements c {

    /* renamed from: c  reason: collision with root package name */
    private List<a> f16591c;

    /* renamed from: d  reason: collision with root package name */
    private float f16592d;

    /* renamed from: f  reason: collision with root package name */
    private float f16593f;
    private float p0;
    private Paint p1;
    private List<Integer> p3;
    private float q;
    private float x;
    private float y;
    private float z;
    private Path p2 = new Path();
    private Interpolator H3 = new AccelerateInterpolator();
    private Interpolator I3 = new DecelerateInterpolator();

    public BezierPagerIndicator(Context context) {
        super(context);
        c(context);
    }

    private void b(Canvas canvas) {
        this.p2.reset();
        float height = (getHeight() - this.y) - this.z;
        this.p2.moveTo(this.x, height);
        this.p2.lineTo(this.x, height - this.q);
        Path path = this.p2;
        float f2 = this.x;
        float f3 = this.f16593f;
        path.quadTo(f2 + ((f3 - f2) / 2.0f), height, f3, height - this.f16592d);
        this.p2.lineTo(this.f16593f, this.f16592d + height);
        Path path2 = this.p2;
        float f4 = this.x;
        path2.quadTo(((this.f16593f - f4) / 2.0f) + f4, height, f4, this.q + height);
        this.p2.close();
        canvas.drawPath(this.p2, this.p1);
    }

    private void c(Context context) {
        Paint paint = new Paint(1);
        this.p1 = paint;
        paint.setStyle(Paint.Style.FILL);
        this.z = b.a(context, 3.5d);
        this.p0 = b.a(context, 2.0d);
        this.y = b.a(context, 1.5d);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c
    public void a(List<a> list) {
        this.f16591c = list;
    }

    public float getMaxCircleRadius() {
        return this.z;
    }

    public float getMinCircleRadius() {
        return this.p0;
    }

    public float getYOffset() {
        return this.y;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(this.f16593f, (getHeight() - this.y) - this.z, this.f16592d, this.p1);
        canvas.drawCircle(this.x, (getHeight() - this.y) - this.z, this.q, this.p1);
        b(canvas);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c
    public void onPageScrollStateChanged(int i) {
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c
    public void onPageScrolled(int i, float f2, int i2) {
        List<a> list = this.f16591c;
        if (list != null && !list.isEmpty()) {
            List<Integer> list2 = this.p3;
            if (list2 != null && list2.size() > 0) {
                this.p1.setColor(net.lucode.hackware.magicindicator.g.a.a(f2, this.p3.get(Math.abs(i) % this.p3.size()).intValue(), this.p3.get(Math.abs(i + 1) % this.p3.size()).intValue()));
            }
            a a = net.lucode.hackware.magicindicator.a.a(this.f16591c, i);
            a a2 = net.lucode.hackware.magicindicator.a.a(this.f16591c, i + 1);
            int i3 = a.a;
            float f3 = i3 + ((a.f16587c - i3) / 2);
            int i4 = a2.a;
            float f4 = (i4 + ((a2.f16587c - i4) / 2)) - f3;
            this.f16593f = (this.H3.getInterpolation(f2) * f4) + f3;
            this.x = f3 + (f4 * this.I3.getInterpolation(f2));
            float f5 = this.z;
            this.f16592d = f5 + ((this.p0 - f5) * this.I3.getInterpolation(f2));
            float f6 = this.p0;
            this.q = f6 + ((this.z - f6) * this.H3.getInterpolation(f2));
            invalidate();
        }
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c
    public void onPageSelected(int i) {
    }

    public void setColors(Integer... numArr) {
        this.p3 = Arrays.asList(numArr);
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.I3 = interpolator;
        if (interpolator == null) {
            this.I3 = new DecelerateInterpolator();
        }
    }

    public void setMaxCircleRadius(float f2) {
        this.z = f2;
    }

    public void setMinCircleRadius(float f2) {
        this.p0 = f2;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.H3 = interpolator;
        if (interpolator == null) {
            this.H3 = new AccelerateInterpolator();
        }
    }

    public void setYOffset(float f2) {
        this.y = f2;
    }
}
