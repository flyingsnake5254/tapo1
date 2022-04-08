package com.tplink.libtpcontrols;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import b.d.w.f.a;

/* loaded from: classes3.dex */
public class CustomTimeline extends View {

    /* renamed from: c  reason: collision with root package name */
    private static float f12035c = 7.0f;

    /* renamed from: d  reason: collision with root package name */
    private static float f12036d = 1.0f;
    private float H3;
    private int I3;
    private int J3;
    private int K3;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12037f;
    private int p0;
    private Paint p1;
    private boolean p2;
    private boolean p3;
    private boolean q;
    private int x;
    private int y;
    private int z;

    public CustomTimeline(Context context) {
        super(context);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.p1 = new Paint();
        this.f12037f = false;
        this.q = false;
        this.p2 = false;
        this.p3 = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x0.CustomTimeline);
        this.f12037f = obtainStyledAttributes.getBoolean(x0.CustomTimeline_drawTimeLineHead, false);
        this.q = obtainStyledAttributes.getBoolean(x0.CustomTimeline_drawTimeLineEnd, false);
        this.x = obtainStyledAttributes.getDimensionPixelSize(x0.CustomTimeline_pointPadding, a.a(context, f12035c));
        this.y = obtainStyledAttributes.getDimensionPixelSize(x0.CustomTimeline_lineWidth, a.a(context, f12036d));
        this.z = obtainStyledAttributes.getColor(x0.CustomTimeline_timePointColor, -7829368);
        this.p0 = obtainStyledAttributes.getColor(x0.CustomTimeline_timeLineColor, -7829368);
        this.p2 = obtainStyledAttributes.getBoolean(x0.CustomTimeline_timePointTop, false);
        this.p3 = obtainStyledAttributes.getBoolean(x0.CustomTimeline_timePointLine, false);
        this.H3 = obtainStyledAttributes.getDimension(x0.CustomTimeline_timePointMarginTop, 0.0f);
        obtainStyledAttributes.recycle();
    }

    public int getTimePointPadding() {
        return this.x;
    }

    public float getTimelineWidth() {
        return this.y;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f2 = this.I3 / 2.0f;
        float f3 = this.J3 / 2.0f;
        int i = this.K3;
        int i2 = this.x;
        float f4 = (((float) i) > ((float) i2) ? i2 : i) / 2.0f;
        this.p1.setStrokeWidth(i2);
        this.p1.setStyle(Paint.Style.FILL);
        this.p1.setColor(this.z);
        this.p1.setAntiAlias(true);
        if (!this.p2) {
            canvas.drawCircle(f2, f3, f4, this.p1);
            if (this.f12037f) {
                this.p1.setStrokeWidth(this.y);
                this.p1.setColor(this.p0);
                this.p1.setAntiAlias(true);
                canvas.drawLine(f2, f3, f2, 0.0f, this.p1);
            }
            if (this.q) {
                this.p1.setStrokeWidth(this.y);
                this.p1.setColor(this.p0);
                this.p1.setAntiAlias(true);
                canvas.drawLine(f2, f3, f2, this.J3, this.p1);
                return;
            }
            return;
        }
        canvas.drawCircle(f2, this.H3, f4, this.p1);
        if (this.p3) {
            this.p1.setStrokeWidth(this.y);
            this.p1.setColor(this.p0);
            this.p1.setAntiAlias(true);
            canvas.drawLine(f2, f4 / 2.0f, f2, this.J3, this.p1);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.I3 = getWidth();
        int height = getHeight();
        this.J3 = height;
        this.K3 = Math.min(this.I3, height);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
    }

    public void setDrawTimelineEnd(boolean z) {
        this.q = z;
        postInvalidate();
    }

    public void setDrawTimelineHead(boolean z) {
        this.f12037f = z;
        postInvalidate();
    }

    public void setPointTopMode(boolean z) {
        this.p2 = z;
        postInvalidate();
    }

    public void setTimePointPadding(int i) {
        this.x = i;
    }

    public void setTimelineDraw(boolean z) {
        this.p3 = z;
        postInvalidate();
    }

    public void setTimelineWidth(int i) {
        this.y = i;
    }

    public CustomTimeline(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }
}
