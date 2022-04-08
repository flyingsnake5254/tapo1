package com.tplink.libtpcontrols.colorpicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.tplink.libtpcontrols.x0;

/* loaded from: classes3.dex */
public class TPArcColorView extends View {
    private Paint H3;
    private Paint I3;
    private Paint J3;
    private Path K3;
    private int[] N3;
    private float[] O3;
    private int P3;
    private int Q3;
    private int R3;
    private int S3;
    private int T3;
    private int U3;
    private int V3;
    private int W3;
    private int X3;
    private int Y3;
    private int Z3;
    private int a4;

    /* renamed from: c  reason: collision with root package name */
    private int f12195c;

    /* renamed from: d  reason: collision with root package name */
    private int f12196d;

    /* renamed from: f  reason: collision with root package name */
    private int f12197f;
    int p0;
    int p1;
    private Paint p2;
    private Paint p3;
    private int q;
    private float x;
    int y;
    int z;
    private final RectF L3 = new RectF();
    private final PointF M3 = new PointF();
    private boolean b4 = false;
    private a c4 = null;
    private b d4 = null;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, boolean z);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(float f2, boolean z);
    }

    public TPArcColorView(Context context) {
        super(context);
        e(context, null);
    }

    private int a(float f2) {
        int i;
        int i2;
        double d2 = f2;
        if (d2 < 0.5d) {
            return (((int) (((this.V3 * f2) * 2.0f) + this.P3)) << 16) + (((int) (((this.X3 * f2) * 2.0f) + this.R3)) << 8) + ((int) ((this.W3 * f2 * 2.0f) + this.Q3)) + ViewCompat.MEASURED_STATE_MASK;
        }
        if (d2 == 0.5d) {
            i = (this.S3 << 16) + (this.U3 << 8);
            i2 = this.T3;
        } else {
            double d3 = d2 - 0.5d;
            i = (((int) (((this.Y3 * 2) * d3) + this.S3)) << 16) + (((int) (((this.a4 * 2) * d3) + this.U3)) << 8);
            i2 = (int) ((this.Z3 * 2 * d3) + this.T3);
        }
        return i + i2 + ViewCompat.MEASURED_STATE_MASK;
    }

    private void b() {
        b bVar = this.d4;
        if (bVar != null) {
            bVar.a(getProgress(), this.b4);
        }
        a aVar = this.c4;
        if (aVar != null) {
            aVar.a(getPickColor(), this.b4);
        }
        this.b4 = false;
    }

    private static int c(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean d(android.graphics.PointF r21, float r22, float r23) {
        /*
            Method dump skipped, instructions count: 192
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.libtpcontrols.colorpicker.TPArcColorView.d(android.graphics.PointF, float, float):boolean");
    }

    private void e(Context context, AttributeSet attributeSet) {
        int c2 = c(context, 10.0f);
        if (attributeSet == null) {
            this.q = c2;
            this.x = 0.66f;
            this.y = ContextCompat.getColor(context, 17170456);
            this.z = ContextCompat.getColor(context, 17170443);
            this.p0 = ContextCompat.getColor(context, 17170450);
            this.p1 = ContextCompat.getColor(context, 17170445);
        } else {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x0.TPArcColorView);
            this.q = (int) obtainStyledAttributes.getDimension(x0.TPArcColorView_tp_stroke_width, c2);
            this.x = obtainStyledAttributes.getFloat(x0.TPArcColorView_tp_percent, 0.66f);
            this.y = obtainStyledAttributes.getColor(x0.TPArcColorView_tp_start_color, ContextCompat.getColor(context, 17170456));
            this.z = obtainStyledAttributes.getColor(x0.TPArcColorView_tp_middle_color, ContextCompat.getColor(context, 17170443));
            this.p0 = obtainStyledAttributes.getColor(x0.TPArcColorView_tp_end_color, ContextCompat.getColor(context, 17170450));
            this.p1 = obtainStyledAttributes.getColor(x0.TPArcColorView_tp_default_color, ContextCompat.getColor(context, 17170445));
            obtainStyledAttributes.recycle();
        }
        Paint paint = new Paint();
        this.I3 = paint;
        paint.setColor(ContextCompat.getColor(context, 17170443));
        this.I3.setStyle(Paint.Style.FILL);
        this.I3.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.J3 = paint2;
        paint2.setColor(-1184275);
        this.J3.setStrokeWidth(c(context, 1.0f));
        this.J3.setStyle(Paint.Style.STROKE);
        this.J3.setAntiAlias(true);
        this.K3 = new Path();
        int c3 = c(context, 14.0f);
        this.K3.addCircle(0.0f, 0.0f, c3, Path.Direction.CW);
        this.f12197f = c3 - (this.q / 2);
        Paint paint3 = new Paint();
        this.p2 = paint3;
        paint3.setAntiAlias(true);
        this.p2.setStrokeWidth(this.q);
        this.p2.setStyle(Paint.Style.STROKE);
        this.p2.setStrokeJoin(Paint.Join.ROUND);
        this.p2.setStrokeCap(Paint.Cap.ROUND);
        Paint paint4 = new Paint();
        this.p3 = paint4;
        paint4.setColor(this.y);
        this.p3.setAntiAlias(true);
        this.p3.setStyle(Paint.Style.FILL);
        Paint paint5 = new Paint();
        this.H3 = paint5;
        paint5.setColor(this.p0);
        this.H3.setAntiAlias(true);
        this.H3.setStyle(Paint.Style.FILL);
        int i = this.p1;
        this.N3 = new int[]{this.y, this.z, this.p0, i, i};
        float[] fArr = new float[5];
        this.O3 = fArr;
        fArr[0] = 0.0f;
        fArr[4] = 1.0f;
        g();
    }

    private boolean f(PointF pointF, float f2, float f3) {
        float f4 = (this.f12195c / 2.0f) - f2;
        float f5 = (this.f12196d / 2.0f) - f3;
        float sqrt = (float) Math.sqrt((f4 * f4) + (f5 * f5));
        float f6 = this.x;
        boolean z = false;
        if (((((double) f6) >= 0.5d && f5 < 0.0f) || (((double) f6) < 0.5d && f5 > 0.0f)) && Math.abs(f4 / f5) < Math.tan(Math.toRadians(((1.0f - this.x) / 2.0f) * 360.0f))) {
            z = true;
        }
        if (!z && sqrt > 0.0f) {
            int i = this.f12195c;
            float f7 = ((i / 2) - this.f12197f) - (this.q / 2);
            pointF.set((i / 2.0f) - ((f4 / sqrt) * f7), (this.f12196d / 2.0f) - ((f5 / sqrt) * f7));
            b();
        }
        return !z;
    }

    private void g() {
        int i = this.y;
        int i2 = (i & 16711680) >> 16;
        this.P3 = i2;
        int i3 = (i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        this.R3 = i3;
        int i4 = i & 255;
        this.Q3 = i4;
        int i5 = this.z;
        int i6 = (i5 & 16711680) >> 16;
        this.S3 = i6;
        int i7 = (i5 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        this.U3 = i7;
        int i8 = i5 & 255;
        this.T3 = i8;
        int i9 = this.p0;
        this.V3 = i6 - i2;
        this.X3 = i7 - i3;
        this.W3 = i8 - i4;
        this.Y3 = ((16711680 & i9) >> 16) - i6;
        this.a4 = ((65280 & i9) >> 8) - i7;
        this.Z3 = (i9 & 255) - i8;
    }

    private int getPickColor() {
        return a(getProgress());
    }

    public float getProgress() {
        double d2;
        double d3;
        PointF pointF = this.M3;
        float f2 = pointF.x;
        float f3 = f2 - (this.f12195c / 2.0f);
        float f4 = pointF.y - (this.f12196d / 2.0f);
        int i = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
        if (i < 0 && f4 > 0.0f) {
            d2 = -Math.atan2(Math.abs(f4), Math.abs(f3));
        } else if (i >= 0 || f4 >= 0.0f) {
            if (f3 <= 0.0f || f4 >= 0.0f) {
                d3 = Math.atan2(f4, f3);
            } else {
                d3 = -Math.atan2(Math.abs(f4), Math.abs(f3));
            }
            d2 = d3 + 3.141592653589793d;
        } else {
            d2 = Math.atan2(Math.abs(f4), Math.abs(f3));
        }
        float f5 = this.x;
        float f6 = ((float) ((d2 / 6.283185307179586d) + ((f5 - 0.5d) / 2.0d))) / f5;
        double d4 = f6;
        if (d4 > 0.99d) {
            return 1.0f;
        }
        if (d4 < 0.01d) {
            return 0.0f;
        }
        return f6;
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int save = canvas.save();
        int i = this.f12195c;
        int i2 = i / 2;
        int i3 = this.f12196d / 2;
        int i4 = ((i / 2) - (this.q / 2)) - this.f12197f;
        float f2 = this.x;
        float f3 = (((double) f2) <= 0.97d || f2 >= 1.0f) ? f2 : 0.97f;
        canvas.save();
        float f4 = f3 * 0.5f;
        float f5 = i2;
        float f6 = i3;
        canvas.rotate((0.75f - f4) * 360.0f, f5, f6);
        float[] fArr = this.O3;
        fArr[1] = f4;
        fArr[2] = f3;
        fArr[3] = f3;
        this.p2.setShader(new SweepGradient(f5, f6, this.N3, this.O3));
        canvas.drawCircle(f5, f6, i4, this.p2);
        canvas.restore();
        if (f3 > 0.0f) {
            if (f3 < 1.0f) {
                canvas.save();
                canvas.rotate(((int) Math.floor((f3 * 360.0f) / 2.0f)) - 0.5f, f5, f6);
                canvas.drawArc(this.L3, -90.0f, 180.0f, true, this.H3);
                canvas.restore();
            }
            canvas.save();
            canvas.rotate(((int) Math.floor((1.0f - (f3 / 2.0f)) * 360.0f)) + 0.5f, f5, f6);
            canvas.drawArc(this.L3, 90.0f, 180.0f, true, this.p3);
            canvas.restore();
        }
        canvas.save();
        PointF pointF = this.M3;
        canvas.translate(pointF.x, pointF.y);
        canvas.drawPath(this.K3, this.I3);
        canvas.drawPath(this.K3, this.J3);
        canvas.restore();
        canvas.restoreToCount(save);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f12195c = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f12196d = measuredHeight;
        RectF rectF = this.L3;
        int i3 = this.f12195c;
        int i4 = this.q;
        rectF.left = (i3 / 2.0f) - (i4 / 2.0f);
        int i5 = this.f12197f;
        rectF.top = i5;
        rectF.right = (measuredHeight / 2.0f) + (i4 / 2.0f);
        rectF.bottom = i4 + i5;
        this.M3.set(i3 / 2.0f, i5 + (i4 / 2.0f));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    this.b4 = true;
                    if (f(this.M3, motionEvent.getX(), motionEvent.getY())) {
                        invalidate();
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                    return true;
                } else if (action != 3) {
                    return true;
                }
            }
            getParent().requestDisallowInterceptTouchEvent(false);
            return false;
        }
        this.b4 = true;
        if (d(this.M3, motionEvent.getX(), motionEvent.getY())) {
            invalidate();
            getParent().requestDisallowInterceptTouchEvent(true);
            return true;
        }
        getParent().requestDisallowInterceptTouchEvent(false);
        return false;
    }

    public void setDefaultColor(int i) {
        this.p1 = i;
        g();
        invalidate();
    }

    public void setEndColor(int i) {
        this.p0 = i;
        g();
        invalidate();
    }

    public void setMiddleColor(int i) {
        this.z = i;
        g();
        invalidate();
    }

    public void setOnColorChangedListener(a aVar) {
        this.c4 = aVar;
    }

    public void setOnProgressListener(b bVar) {
        this.d4 = bVar;
    }

    public void setProgress(float f2) {
        float f3;
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        double d2 = ((this.x + 0.5d) * 3.141592653589793d) - (((f2 * f3) * 2.0f) * 3.141592653589793d);
        double d3 = ((this.f12195c / 2.0f) - this.f12197f) - (this.q / 2.0f);
        this.M3.set((float) ((Math.cos(d2) * d3) + (this.f12195c / 2)), (float) ((this.f12196d / 2) - (d3 * Math.sin(d2))));
        b();
        invalidate();
    }

    public void setStartColor(int i) {
        this.y = i;
        g();
        invalidate();
    }

    public TPArcColorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e(context, attributeSet);
    }

    public TPArcColorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        e(context, attributeSet);
    }
}
