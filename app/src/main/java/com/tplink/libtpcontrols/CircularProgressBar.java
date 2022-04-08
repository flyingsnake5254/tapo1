package com.tplink.libtpcontrols;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes3.dex */
public class CircularProgressBar extends View {

    /* renamed from: c  reason: collision with root package name */
    private Paint f12029c;

    /* renamed from: d  reason: collision with root package name */
    private RectF f12030d;

    /* renamed from: f  reason: collision with root package name */
    private int f12031f;
    private boolean p0;
    private boolean p1;
    private boolean p2;
    private float q;
    private int x;
    private float y;
    private float z;

    public CircularProgressBar(Context context) {
        this(context, null);
    }

    public int getCircleColor() {
        return this.f12031f;
    }

    public int getCircleProgressColor() {
        return this.x;
    }

    public float getCircleStrokeWidth() {
        return this.q;
    }

    public float getProgressStrokeWidth() {
        return this.y;
    }

    public float getProgressValue() {
        return this.z;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f2;
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int min = Math.min(width, height);
        float f3 = width / 2.0f;
        float f4 = height / 2.0f;
        if (this.p2) {
            f2 = ((min / 2.0f) - (this.y / 2.0f)) - 15.0f;
        } else {
            f2 = (min / 2.0f) - (this.y / 2.0f);
        }
        this.f12029c.setStrokeWidth(this.q);
        this.f12029c.setStyle(Paint.Style.STROKE);
        this.f12029c.setColor(this.f12031f);
        this.f12029c.setAntiAlias(true);
        canvas.drawCircle(f3, f4, f2, this.f12029c);
        if (this.p0) {
            if (this.p2) {
                this.f12029c.setStrokeWidth(0.0f);
                this.f12029c.setStyle(Paint.Style.FILL);
                this.f12029c.setColor(this.x);
                this.f12029c.setAntiAlias(true);
                canvas.drawCircle(f3, f4 - f2, this.y / 2.0f, this.f12029c);
            }
            this.f12029c.setStrokeWidth(this.y);
            this.f12029c.setStyle(Paint.Style.STROKE);
            this.f12029c.setColor(this.x);
            this.f12029c.setAntiAlias(true);
            this.f12030d.set(f3 - f2, f4 - f2, f3 + f2, f4 + f2);
            canvas.drawArc(this.f12030d, 270.0f, this.z * 360.0f, false, this.f12029c);
            if (this.p1) {
                double radians = (float) Math.toRadians(this.z * 360.0f);
                this.f12029c.setStrokeWidth(0.0f);
                this.f12029c.setStyle(Paint.Style.FILL);
                this.f12029c.setColor(this.x);
                this.f12029c.setAntiAlias(true);
                canvas.drawCircle(f3 + (((float) Math.sin(radians)) * f2), f4 - (f2 * ((float) Math.cos(radians))), (this.y / 2.0f) + 15.0f, this.f12029c);
            }
        }
    }

    public void setCircleColor(int i) {
        this.f12031f = i;
        invalidate();
    }

    public void setCircleProgressColor(int i) {
        this.x = i;
        invalidate();
    }

    public void setCircleStrokeWidth(float f2) {
        this.q = f2;
        invalidate();
    }

    public void setMarkerEnabled(boolean z) {
        this.p1 = z;
        invalidate();
    }

    public void setProgressEnabled(boolean z) {
        this.p0 = z;
        invalidate();
    }

    public void setProgressStrokeWidth(float f2) {
        this.y = Math.max(f2, this.q);
        invalidate();
    }

    public void setProgressValue(float f2) {
        if (f2 < 0.0f) {
            this.z = 0.0f;
        } else if (f2 > 1.0f) {
            this.z = 1.0f;
        } else {
            this.z = f2;
        }
        invalidate();
    }

    public CircularProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircularProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12029c = new Paint();
        this.f12030d = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x0.CircularProgressBar);
        this.f12031f = obtainStyledAttributes.getColor(x0.CircularProgressBar_circleColor, 0);
        this.x = obtainStyledAttributes.getColor(x0.CircularProgressBar_progressColor, 0);
        this.q = obtainStyledAttributes.getDimension(x0.CircularProgressBar_circleStrokeWidth, 5.0f);
        this.y = obtainStyledAttributes.getDimension(x0.CircularProgressBar_progressStrokeWidth, 5.0f);
        this.z = obtainStyledAttributes.getFloat(x0.CircularProgressBar_progressValue, 0.0f);
        this.p0 = obtainStyledAttributes.getBoolean(x0.CircularProgressBar_progressEnabled, false);
        this.p1 = obtainStyledAttributes.getBoolean(x0.CircularProgressBar_markerEnabled, true);
        this.p2 = obtainStyledAttributes.getBoolean(x0.CircularProgressBar_startPointEnabled, false);
        obtainStyledAttributes.recycle();
    }
}
