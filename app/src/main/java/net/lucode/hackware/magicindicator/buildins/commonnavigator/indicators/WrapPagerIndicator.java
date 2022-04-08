package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.List;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a;
import net.lucode.hackware.magicindicator.g.b;

/* loaded from: classes4.dex */
public class WrapPagerIndicator extends View implements c {

    /* renamed from: c  reason: collision with root package name */
    private int f16603c;

    /* renamed from: d  reason: collision with root package name */
    private int f16604d;

    /* renamed from: f  reason: collision with root package name */
    private int f16605f;
    private Paint p0;
    private boolean p2;
    private float q;
    private List<a> z;
    private Interpolator x = new LinearInterpolator();
    private Interpolator y = new LinearInterpolator();
    private RectF p1 = new RectF();

    public WrapPagerIndicator(Context context) {
        super(context);
        b(context);
    }

    private void b(Context context) {
        Paint paint = new Paint(1);
        this.p0 = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f16603c = b.a(context, 6.0d);
        this.f16604d = b.a(context, 10.0d);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c
    public void a(List<a> list) {
        this.z = list;
    }

    public Interpolator getEndInterpolator() {
        return this.y;
    }

    public int getFillColor() {
        return this.f16605f;
    }

    public int getHorizontalPadding() {
        return this.f16604d;
    }

    public Paint getPaint() {
        return this.p0;
    }

    public float getRoundRadius() {
        return this.q;
    }

    public Interpolator getStartInterpolator() {
        return this.x;
    }

    public int getVerticalPadding() {
        return this.f16603c;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.p0.setColor(this.f16605f);
        RectF rectF = this.p1;
        float f2 = this.q;
        canvas.drawRoundRect(rectF, f2, f2, this.p0);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c
    public void onPageScrollStateChanged(int i) {
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c
    public void onPageScrolled(int i, float f2, int i2) {
        List<a> list = this.z;
        if (list != null && !list.isEmpty()) {
            a a = net.lucode.hackware.magicindicator.a.a(this.z, i);
            a a2 = net.lucode.hackware.magicindicator.a.a(this.z, i + 1);
            RectF rectF = this.p1;
            int i3 = a.f16589e;
            rectF.left = (i3 - this.f16604d) + ((a2.f16589e - i3) * this.y.getInterpolation(f2));
            RectF rectF2 = this.p1;
            rectF2.top = a.f16590f - this.f16603c;
            int i4 = a.g;
            rectF2.right = this.f16604d + i4 + ((a2.g - i4) * this.x.getInterpolation(f2));
            RectF rectF3 = this.p1;
            rectF3.bottom = a.h + this.f16603c;
            if (!this.p2) {
                this.q = rectF3.height() / 2.0f;
            }
            invalidate();
        }
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c
    public void onPageSelected(int i) {
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.y = interpolator;
        if (interpolator == null) {
            this.y = new LinearInterpolator();
        }
    }

    public void setFillColor(int i) {
        this.f16605f = i;
    }

    public void setHorizontalPadding(int i) {
        this.f16604d = i;
    }

    public void setRoundRadius(float f2) {
        this.q = f2;
        this.p2 = true;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.x = interpolator;
        if (interpolator == null) {
            this.x = new LinearInterpolator();
        }
    }

    public void setVerticalPadding(int i) {
        this.f16603c = i;
    }
}
