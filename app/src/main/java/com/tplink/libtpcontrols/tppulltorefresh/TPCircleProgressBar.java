package com.tplink.libtpcontrols.tppulltorefresh;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.tplink.libtpcontrols.p0;

/* loaded from: classes3.dex */
public class TPCircleProgressBar extends View {
    private long H3;
    private boolean I3;
    private boolean J3;
    private long K3;
    private float L3;
    private int M3;

    /* renamed from: c  reason: collision with root package name */
    private Paint f12428c;

    /* renamed from: d  reason: collision with root package name */
    private float f12429d;

    /* renamed from: f  reason: collision with root package name */
    private float f12430f;
    private long p0;
    private long p1;
    private boolean p2;
    private long p3;
    private int q;
    private float x;
    private float y;
    private float z;

    public TPCircleProgressBar(Context context) {
        this(context, null, -1);
    }

    private int a(float f2) {
        return (int) ((f2 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void b(Canvas canvas) {
        canvas.save();
        canvas.rotate(this.x + 20.0f, getWidth() / 2.0f, getHeight() / 2.0f);
        canvas.drawCircle(getWidth() - (this.q / 2.0f), getHeight() / 2.0f, this.q / 2.0f, this.f12428c);
        canvas.restore();
    }

    private void c(Canvas canvas) {
        this.f12428c.setStrokeWidth(this.q);
        this.f12428c.setStyle(Paint.Style.STROKE);
        int i = this.q;
        RectF rectF = new RectF(i / 2.0f, i / 2.0f, getWidth() - (this.q / 2.0f), getHeight() - (this.q / 2.0f));
        float f2 = this.y;
        canvas.drawArc(rectF, f2, ((this.x + 360.0f) - f2) % 360.0f, false, this.f12428c);
        this.f12428c.setStrokeWidth(0.0f);
        this.f12428c.setStyle(Paint.Style.FILL);
        canvas.save();
        canvas.rotate(this.y, getWidth() / 2.0f, getHeight() / 2.0f);
        canvas.drawCircle(getWidth() - (this.q / 2.0f), getHeight() / 2.0f, this.q / 2.0f, this.f12428c);
        canvas.restore();
        canvas.save();
        canvas.rotate(this.x, getWidth() / 2.0f, getHeight() / 2.0f);
        canvas.drawCircle(getWidth() - (this.q / 2.0f), getHeight() / 2.0f, this.q / 2.0f, this.f12428c);
        canvas.restore();
    }

    private void d(Context context) {
        this.q = a(2.0f);
        Paint paint = new Paint();
        this.f12428c = paint;
        paint.setColor(ContextCompat.getColor(context, p0.common_tplink_yellow));
        this.f12428c.setAntiAlias(true);
    }

    private void j(long j) {
        if (this.J3) {
            long j2 = this.p3 + j;
            this.p3 = j2;
            long j3 = this.p1;
            if (j2 >= j3) {
                this.p3 = j3;
                this.J3 = false;
                this.H3 = 0L;
            }
            if (this.p2) {
                float f2 = this.y + ((this.z / 1000.0f) * ((float) j));
                this.y = f2;
                long j4 = this.p3;
                if (j4 <= j3) {
                    float f3 = this.f12429d;
                    float f4 = this.f12430f;
                    this.x = f2 + f4 + (((f3 - f4) / ((float) j3)) * ((float) j4));
                } else {
                    this.x = f2 + this.f12429d;
                }
            } else {
                float f5 = this.x + ((this.z / 1000.0f) * ((float) j));
                this.x = f5;
                long j5 = this.p3;
                if (j5 <= j3) {
                    float f6 = this.f12429d;
                    this.y = (f5 + 360.0f) - (f6 - (((f6 - this.f12430f) / ((float) j3)) * ((float) j5)));
                } else {
                    this.y = (f5 + 360.0f) - this.f12430f;
                }
            }
        } else {
            long j6 = this.H3 + j;
            this.H3 = j6;
            long j7 = this.p0;
            if (j6 >= j7) {
                this.H3 = j7;
                this.J3 = true;
                this.p3 = 0L;
                this.p2 = true ^ this.p2;
            }
            float f7 = this.x;
            float f8 = this.z;
            float f9 = (float) j;
            this.x = f7 + ((f8 / 1000.0f) * f9);
            this.y += (f8 / 1000.0f) * f9;
        }
        this.x %= 360.0f;
        this.y %= 360.0f;
    }

    public boolean e() {
        return this.I3;
    }

    public void f() {
        this.J3 = true;
        this.p2 = true;
        this.p3 = 0L;
        this.H3 = 0L;
        this.y = 0.0f;
        this.x = this.f12430f;
        invalidate();
    }

    public void g() {
        this.I3 = true;
        this.K3 = SystemClock.uptimeMillis();
        invalidate();
    }

    public void h() {
        this.I3 = true;
        f();
        invalidate();
    }

    public void i() {
        this.I3 = false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f12428c.setStyle(Paint.Style.STROKE);
        this.f12428c.setStrokeWidth(this.q);
        c(canvas);
        b(canvas);
        if (this.I3) {
            long uptimeMillis = SystemClock.uptimeMillis();
            j(uptimeMillis - this.K3);
            invalidate();
            this.K3 = uptimeMillis;
        }
    }

    public void setProgress(float f2) {
        if (f2 < 0.0f) {
            this.L3 = 0.0f;
        } else if (f2 > 1.0f) {
            this.L3 = 1.0f;
        } else {
            this.L3 = f2;
        }
        if (this.I3) {
            this.I3 = false;
        }
        this.y = 0.0f;
        this.J3 = true;
        this.p2 = true;
        float f3 = (float) this.p1;
        float f4 = this.L3;
        this.p3 = f3 * f4;
        this.y = 0.0f;
        float f5 = this.f12429d;
        float f6 = this.f12430f;
        this.x = ((f5 - f6) * f4) + f6;
        invalidate();
    }

    public void setProgressBarColor(int i) {
        this.M3 = i;
        this.f12428c.setColor(i);
    }

    public TPCircleProgressBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public TPCircleProgressBar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12429d = 270.0f;
        this.f12430f = 16.0f;
        this.x = 270.0f;
        this.y = 0.0f;
        this.z = 360.0f;
        this.p0 = 200L;
        this.p1 = 460L;
        this.p2 = false;
        this.p3 = 0L;
        this.H3 = 0L;
        this.I3 = false;
        this.J3 = false;
        this.K3 = 0L;
        this.M3 = -1;
        d(context);
    }
}
