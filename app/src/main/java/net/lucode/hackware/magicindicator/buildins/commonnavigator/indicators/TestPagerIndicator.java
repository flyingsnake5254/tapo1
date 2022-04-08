package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import java.util.List;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a;

/* loaded from: classes4.dex */
public class TestPagerIndicator extends View implements c {

    /* renamed from: c  reason: collision with root package name */
    private Paint f16597c;

    /* renamed from: d  reason: collision with root package name */
    private int f16598d;

    /* renamed from: f  reason: collision with root package name */
    private int f16599f;
    private RectF q = new RectF();
    private RectF x = new RectF();
    private List<a> y;

    public TestPagerIndicator(Context context) {
        super(context);
        b(context);
    }

    private void b(Context context) {
        Paint paint = new Paint(1);
        this.f16597c = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f16598d = SupportMenu.CATEGORY_MASK;
        this.f16599f = -16711936;
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c
    public void a(List<a> list) {
        this.y = list;
    }

    public int getInnerRectColor() {
        return this.f16599f;
    }

    public int getOutRectColor() {
        return this.f16598d;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f16597c.setColor(this.f16598d);
        canvas.drawRect(this.q, this.f16597c);
        this.f16597c.setColor(this.f16599f);
        canvas.drawRect(this.x, this.f16597c);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c
    public void onPageScrollStateChanged(int i) {
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c
    public void onPageScrolled(int i, float f2, int i2) {
        List<a> list = this.y;
        if (list != null && !list.isEmpty()) {
            a a = net.lucode.hackware.magicindicator.a.a(this.y, i);
            a a2 = net.lucode.hackware.magicindicator.a.a(this.y, i + 1);
            RectF rectF = this.q;
            int i3 = a.a;
            rectF.left = i3 + ((a2.a - i3) * f2);
            int i4 = a.f16586b;
            rectF.top = i4 + ((a2.f16586b - i4) * f2);
            int i5 = a.f16587c;
            rectF.right = i5 + ((a2.f16587c - i5) * f2);
            int i6 = a.f16588d;
            rectF.bottom = i6 + ((a2.f16588d - i6) * f2);
            RectF rectF2 = this.x;
            int i7 = a.f16589e;
            rectF2.left = i7 + ((a2.f16589e - i7) * f2);
            int i8 = a.f16590f;
            rectF2.top = i8 + ((a2.f16590f - i8) * f2);
            int i9 = a.g;
            rectF2.right = i9 + ((a2.g - i9) * f2);
            int i10 = a.h;
            rectF2.bottom = i10 + ((a2.h - i10) * f2);
            invalidate();
        }
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c
    public void onPageSelected(int i) {
    }

    public void setInnerRectColor(int i) {
        this.f16599f = i;
    }

    public void setOutRectColor(int i) {
        this.f16598d = i;
    }
}
