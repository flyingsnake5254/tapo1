package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.Arrays;
import java.util.List;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a;
import net.lucode.hackware.magicindicator.g.b;

/* loaded from: classes4.dex */
public class LinePagerIndicator extends View implements c {

    /* renamed from: c  reason: collision with root package name */
    private int f16594c;
    private float p0;
    private Paint p1;
    private List<a> p2;
    private List<Integer> p3;
    private float q;
    private float x;
    private float y;
    private float z;

    /* renamed from: d  reason: collision with root package name */
    private Interpolator f16595d = new LinearInterpolator();

    /* renamed from: f  reason: collision with root package name */
    private Interpolator f16596f = new LinearInterpolator();
    private RectF H3 = new RectF();

    public LinePagerIndicator(Context context) {
        super(context);
        b(context);
    }

    private void b(Context context) {
        Paint paint = new Paint(1);
        this.p1 = paint;
        paint.setStyle(Paint.Style.FILL);
        this.x = b.a(context, 3.0d);
        this.z = b.a(context, 10.0d);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c
    public void a(List<a> list) {
        this.p2 = list;
    }

    public List<Integer> getColors() {
        return this.p3;
    }

    public Interpolator getEndInterpolator() {
        return this.f16596f;
    }

    public float getLineHeight() {
        return this.x;
    }

    public float getLineWidth() {
        return this.z;
    }

    public int getMode() {
        return this.f16594c;
    }

    public Paint getPaint() {
        return this.p1;
    }

    public float getRoundRadius() {
        return this.p0;
    }

    public Interpolator getStartInterpolator() {
        return this.f16595d;
    }

    public float getXOffset() {
        return this.y;
    }

    public float getYOffset() {
        return this.q;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.H3;
        float f2 = this.p0;
        canvas.drawRoundRect(rectF, f2, f2, this.p1);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c
    public void onPageScrollStateChanged(int i) {
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c
    public void onPageScrolled(int i, float f2, int i2) {
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        int i3;
        List<a> list = this.p2;
        if (list != null && !list.isEmpty()) {
            List<Integer> list2 = this.p3;
            if (list2 != null && list2.size() > 0) {
                this.p1.setColor(net.lucode.hackware.magicindicator.g.a.a(f2, this.p3.get(Math.abs(i) % this.p3.size()).intValue(), this.p3.get(Math.abs(i + 1) % this.p3.size()).intValue()));
            }
            a a = net.lucode.hackware.magicindicator.a.a(this.p2, i);
            a a2 = net.lucode.hackware.magicindicator.a.a(this.p2, i + 1);
            int i4 = this.f16594c;
            if (i4 == 0) {
                f7 = this.y;
                f6 = a.a + f7;
                f5 = a2.a + f7;
                f3 = a.f16587c - f7;
                i3 = a2.f16587c;
            } else if (i4 == 1) {
                f7 = this.y;
                f6 = a.f16589e + f7;
                f5 = a2.f16589e + f7;
                f3 = a.g - f7;
                i3 = a2.g;
            } else {
                f6 = a.a + ((a.b() - this.z) / 2.0f);
                f5 = a2.a + ((a2.b() - this.z) / 2.0f);
                f3 = ((a.b() + this.z) / 2.0f) + a.a;
                f4 = ((a2.b() + this.z) / 2.0f) + a2.a;
                this.H3.left = f6 + ((f5 - f6) * this.f16595d.getInterpolation(f2));
                this.H3.right = f3 + ((f4 - f3) * this.f16596f.getInterpolation(f2));
                this.H3.top = (getHeight() - this.x) - this.q;
                this.H3.bottom = getHeight() - this.q;
                invalidate();
            }
            f4 = i3 - f7;
            this.H3.left = f6 + ((f5 - f6) * this.f16595d.getInterpolation(f2));
            this.H3.right = f3 + ((f4 - f3) * this.f16596f.getInterpolation(f2));
            this.H3.top = (getHeight() - this.x) - this.q;
            this.H3.bottom = getHeight() - this.q;
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
        this.f16596f = interpolator;
        if (interpolator == null) {
            this.f16596f = new LinearInterpolator();
        }
    }

    public void setLineHeight(float f2) {
        this.x = f2;
    }

    public void setLineWidth(float f2) {
        this.z = f2;
    }

    public void setMode(int i) {
        if (i == 2 || i == 0 || i == 1) {
            this.f16594c = i;
            return;
        }
        throw new IllegalArgumentException("mode " + i + " not supported.");
    }

    public void setRoundRadius(float f2) {
        this.p0 = f2;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f16595d = interpolator;
        if (interpolator == null) {
            this.f16595d = new LinearInterpolator();
        }
    }

    public void setXOffset(float f2) {
        this.y = f2;
    }

    public void setYOffset(float f2) {
        this.q = f2;
    }
}
