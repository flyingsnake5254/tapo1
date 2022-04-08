package com.tplink.libtpcontrols;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.NonNull;
import com.github.mikephil.charting.utils.Utils;

/* loaded from: classes3.dex */
public class TPProgressWheel extends View {
    private boolean P3;
    private b T3;
    private boolean U3;

    /* renamed from: c  reason: collision with root package name */
    private final int f12136c = 16;

    /* renamed from: d  reason: collision with root package name */
    private int f12137d = 28;

    /* renamed from: f  reason: collision with root package name */
    private int f12138f = 4;
    private int q = 4;
    private boolean x = false;
    private double y = Utils.DOUBLE_EPSILON;
    private double z = 360.0d;
    private double p0 = Utils.DOUBLE_EPSILON;
    private float p1 = 0.0f;
    private float p2 = 0.0f;
    private boolean p3 = true;
    private long H3 = 0;
    private int I3 = -1426063361;
    private int J3 = 0;
    private Paint K3 = new Paint();
    private Paint L3 = new Paint();
    private RectF M3 = new RectF();
    private float N3 = 480.0f;
    private long O3 = 0;
    private float Q3 = 0.0f;
    private float R3 = 0.0f;
    private boolean S3 = false;
    private boolean V3 = false;
    private boolean W3 = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class WheelSavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<WheelSavedState> CREATOR = new a();
        boolean H3;
        boolean I3;

        /* renamed from: c  reason: collision with root package name */
        float f12139c;

        /* renamed from: d  reason: collision with root package name */
        float f12140d;

        /* renamed from: f  reason: collision with root package name */
        boolean f12141f;
        int p0;
        int p1;
        int p2;
        int p3;
        boolean q;
        boolean x;
        float y;
        int z;

        /* loaded from: classes3.dex */
        static class a implements Parcelable.Creator<WheelSavedState> {
            a() {
            }

            /* renamed from: a */
            public WheelSavedState createFromParcel(Parcel parcel) {
                return new WheelSavedState(parcel);
            }

            /* renamed from: b */
            public WheelSavedState[] newArray(int i) {
                return new WheelSavedState[i];
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.f12139c);
            parcel.writeFloat(this.f12140d);
            parcel.writeByte(this.f12141f ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.q ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.x ? (byte) 1 : (byte) 0);
            parcel.writeFloat(this.y);
            parcel.writeInt(this.z);
            parcel.writeInt(this.p0);
            parcel.writeInt(this.p1);
            parcel.writeInt(this.p2);
            parcel.writeInt(this.p3);
            parcel.writeByte(this.H3 ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.I3 ? (byte) 1 : (byte) 0);
        }

        WheelSavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private WheelSavedState(Parcel parcel) {
            super(parcel);
            this.f12139c = parcel.readFloat();
            this.f12140d = parcel.readFloat();
            boolean z = true;
            this.f12141f = parcel.readByte() != 0;
            this.q = parcel.readByte() != 0;
            this.x = parcel.readByte() != 0;
            this.y = parcel.readFloat();
            this.z = parcel.readInt();
            this.p0 = parcel.readInt();
            this.p1 = parcel.readInt();
            this.p2 = parcel.readInt();
            this.p3 = parcel.readInt();
            this.H3 = parcel.readByte() != 0;
            this.I3 = parcel.readByte() == 0 ? false : z;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(float f2);
    }

    public TPProgressWheel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context.obtainStyledAttributes(attributeSet, x0.TPProgressWheel));
        f();
    }

    private void a(long j) {
        if (this.p0 == Utils.DOUBLE_EPSILON) {
            this.p0 = this.y;
        }
        double d2 = this.p0 + j;
        this.p0 = d2;
        double d3 = this.z;
        if (d2 >= d3) {
            this.p0 = d3;
        }
        this.p1 = ((((float) Math.cos(((this.p0 / d3) + 1.0d) * 3.141592653589793d)) / 2.0f) + 0.5f) * 344.0f;
    }

    private void b(TypedArray typedArray) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.f12138f = (int) TypedValue.applyDimension(1, this.f12138f, displayMetrics);
        this.q = (int) TypedValue.applyDimension(1, this.q, displayMetrics);
        int applyDimension = (int) TypedValue.applyDimension(1, this.f12137d, displayMetrics);
        this.f12137d = applyDimension;
        this.f12137d = (int) typedArray.getDimension(x0.TPProgressWheel_matProg_circleRadius, applyDimension);
        this.x = typedArray.getBoolean(x0.TPProgressWheel_matProg_fillRadius, false);
        this.f12138f = (int) typedArray.getDimension(x0.TPProgressWheel_matProg_barWidth, this.f12138f);
        this.q = (int) typedArray.getDimension(x0.TPProgressWheel_matProg_rimWidth, this.q);
        this.N3 = typedArray.getFloat(x0.TPProgressWheel_matProg_spinSpeed, this.N3 / 360.0f) * 360.0f;
        this.z = typedArray.getInt(x0.TPProgressWheel_matProg_barSpinCycleTime, (int) this.z);
        this.I3 = typedArray.getColor(x0.TPProgressWheel_matProg_barColor, this.I3);
        this.J3 = typedArray.getColor(x0.TPProgressWheel_matProg_rimColor, this.J3);
        this.P3 = typedArray.getBoolean(x0.TPProgressWheel_matProg_linearProgress, false);
        if (typedArray.getBoolean(x0.TPProgressWheel_matProg_progressIndeterminate, false)) {
            i();
        }
        typedArray.recycle();
    }

    private void c() {
        if (this.T3 != null) {
            this.T3.a(Math.round((this.Q3 * 100.0f) / 360.0f) / 100.0f);
        }
    }

    private void d(float f2) {
        b bVar = this.T3;
        if (bVar != null) {
            bVar.a(f2);
        }
    }

    private void e(float f2) {
        if (this.T3 != null) {
            this.T3.a(Math.round((f2 * 100.0f) / 360.0f) / 100.0f);
        }
    }

    @TargetApi(17)
    private void f() {
        float f2;
        if (Build.VERSION.SDK_INT >= 17) {
            f2 = Settings.Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f);
        } else {
            f2 = Settings.System.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f);
        }
        this.U3 = f2 != 0.0f;
    }

    private void g(int i, int i2) {
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        if (!this.x) {
            int i3 = (i - paddingLeft) - paddingRight;
            int min = Math.min(Math.min(i3, (i2 - paddingBottom) - paddingTop), (this.f12137d * 2) - (this.f12138f * 2));
            int i4 = ((i3 - min) / 2) + paddingLeft;
            int i5 = ((((i2 - paddingTop) - paddingBottom) - min) / 2) + paddingTop;
            int i6 = this.f12138f;
            this.M3 = new RectF(i4 + i6, i5 + i6, (i4 + min) - i6, (i5 + min) - i6);
            return;
        }
        int i7 = this.f12138f;
        this.M3 = new RectF(paddingLeft + i7, paddingTop + i7, (i - paddingRight) - i7, (i2 - paddingBottom) - i7);
    }

    private void h() {
        this.K3.setColor(this.I3);
        this.K3.setAntiAlias(true);
        this.K3.setStyle(Paint.Style.STROKE);
        this.K3.setStrokeWidth(this.f12138f);
        this.L3.setColor(this.J3);
        this.L3.setAntiAlias(true);
        this.L3.setStyle(Paint.Style.STROKE);
        this.L3.setStrokeWidth(this.q);
    }

    private void j(long j) {
        long j2 = this.H3;
        if (j2 >= 120) {
            double d2 = this.y + j;
            this.y = d2;
            double d3 = this.z;
            if (d2 > d3) {
                this.y = d2 - d3;
                this.H3 = 0L;
                this.p3 = !this.p3;
            }
            float cos = (((float) Math.cos(((this.y / d3) + 1.0d) * 3.141592653589793d)) / 2.0f) + 0.5f;
            if (this.p3) {
                this.p2 = cos * 254.0f;
                return;
            }
            float f2 = (1.0f - cos) * 254.0f;
            this.Q3 += this.p2 - f2;
            this.p2 = f2;
            return;
        }
        this.H3 = j2 + j;
    }

    public int getBarColor() {
        return this.I3;
    }

    public int getBarWidth() {
        return this.f12138f;
    }

    public int getCircleRadius() {
        return this.f12137d;
    }

    public float getProgress() {
        if (this.S3) {
            return -1.0f;
        }
        return this.Q3 / 360.0f;
    }

    public int getRimColor() {
        return this.J3;
    }

    public int getRimWidth() {
        return this.q;
    }

    public float getSpinSpeed() {
        return this.N3 / 360.0f;
    }

    public void i() {
        this.O3 = SystemClock.uptimeMillis();
        this.S3 = true;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f2;
        super.onDraw(canvas);
        if (this.V3) {
            canvas.drawArc(this.M3, 360.0f, 360.0f, false, this.K3);
            return;
        }
        canvas.drawArc(this.M3, 360.0f, 360.0f, false, this.L3);
        if (this.U3) {
            float f3 = 0.0f;
            boolean z = true;
            if (this.S3) {
                long uptimeMillis = SystemClock.uptimeMillis() - this.O3;
                j(uptimeMillis);
                float f4 = this.Q3 + ((((float) uptimeMillis) * this.N3) / 1000.0f);
                this.Q3 = f4;
                if (f4 > 360.0f) {
                    this.Q3 = f4 - 360.0f;
                    d(-1.0f);
                }
                this.O3 = SystemClock.uptimeMillis();
                float f5 = this.Q3 - 90.0f;
                float f6 = this.p2 + 16.0f;
                if (isInEditMode()) {
                    f5 = 0.0f;
                    f6 = 135.0f;
                }
                canvas.drawArc(this.M3, f5, f6, false, this.K3);
            } else if (!this.W3) {
                float f7 = this.Q3;
                if (f7 != this.R3) {
                    this.Q3 = Math.min(this.Q3 + ((((float) (SystemClock.uptimeMillis() - this.O3)) / 1000.0f) * this.N3), this.R3);
                } else {
                    z = false;
                }
                if (f7 != this.Q3) {
                    c();
                }
                float f8 = this.Q3;
                if (!this.P3) {
                    f3 = ((float) (1.0d - Math.pow(1.0f - (f8 / 360.0f), 4.0f))) * 360.0f;
                    f8 = ((float) (1.0d - Math.pow(1.0f - (this.Q3 / 360.0f), 2.0f))) * 360.0f;
                }
                if (isInEditMode()) {
                    f8 = 360.0f;
                }
                canvas.drawArc(this.M3, f3 - 90.0f, f8, false, this.K3);
            } else {
                long uptimeMillis2 = SystemClock.uptimeMillis() - this.O3;
                float f9 = this.Q3 + ((((float) uptimeMillis2) * this.N3) / 1000.0f);
                this.Q3 = f9;
                if (f9 > 360.0f) {
                    this.Q3 = f9 - 360.0f;
                }
                a(uptimeMillis2);
                float f10 = this.p2 + 16.0f + this.p1;
                if (isInEditMode()) {
                    f10 = 360.0f;
                }
                if (f10 >= 360.0f) {
                    z = false;
                    f2 = 360.0f;
                } else {
                    f2 = f10;
                }
                e(f2);
                this.O3 = SystemClock.uptimeMillis();
                canvas.drawArc(this.M3, this.Q3 - 90.0f, f2, false, this.K3);
            }
            if (z) {
                invalidate();
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int paddingLeft = this.f12137d + getPaddingLeft() + getPaddingRight();
        int paddingTop = this.f12137d + getPaddingTop() + getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            paddingLeft = size;
        } else if (mode == Integer.MIN_VALUE) {
            paddingLeft = Math.min(paddingLeft, size);
        }
        if (mode2 == 1073741824 || mode == 1073741824) {
            paddingTop = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            paddingTop = Math.min(paddingTop, size2);
        }
        setMeasuredDimension(paddingLeft, paddingTop);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof WheelSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        WheelSavedState wheelSavedState = (WheelSavedState) parcelable;
        super.onRestoreInstanceState(wheelSavedState.getSuperState());
        this.Q3 = wheelSavedState.f12139c;
        this.R3 = wheelSavedState.f12140d;
        this.S3 = wheelSavedState.f12141f;
        this.V3 = wheelSavedState.q;
        this.W3 = wheelSavedState.x;
        this.N3 = wheelSavedState.y;
        this.f12138f = wheelSavedState.z;
        this.I3 = wheelSavedState.p0;
        this.q = wheelSavedState.p1;
        this.J3 = wheelSavedState.p2;
        this.f12137d = wheelSavedState.p3;
        this.P3 = wheelSavedState.H3;
        this.x = wheelSavedState.I3;
        this.O3 = SystemClock.uptimeMillis();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        WheelSavedState wheelSavedState = new WheelSavedState(super.onSaveInstanceState());
        wheelSavedState.f12139c = this.Q3;
        wheelSavedState.f12140d = this.R3;
        wheelSavedState.f12141f = this.S3;
        wheelSavedState.q = this.V3;
        wheelSavedState.x = this.W3;
        wheelSavedState.y = this.N3;
        wheelSavedState.z = this.f12138f;
        wheelSavedState.p0 = this.I3;
        wheelSavedState.p1 = this.q;
        wheelSavedState.p2 = this.J3;
        wheelSavedState.p3 = this.f12137d;
        wheelSavedState.H3 = this.P3;
        wheelSavedState.I3 = this.x;
        return wheelSavedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        g(i, i2);
        h();
        invalidate();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            this.O3 = SystemClock.uptimeMillis();
        }
    }

    public void setBarColor(int i) {
        this.I3 = i;
        h();
        if (!this.S3) {
            invalidate();
        }
    }

    public void setBarColorAfter(int i) {
        this.I3 = i;
        h();
        this.V3 = true;
        if (!this.S3) {
            invalidate();
        }
    }

    public void setBarWidth(int i) {
        this.f12138f = i;
        if (!this.S3) {
            invalidate();
        }
    }

    public void setCallback(b bVar) {
        this.T3 = bVar;
        if (!this.S3) {
            c();
        }
    }

    public void setCircleRadius(int i) {
        this.f12137d = i;
        if (!this.S3) {
            requestLayout();
        }
    }

    public void setInstantProgress(float f2) {
        if (this.S3) {
            this.Q3 = 0.0f;
            this.S3 = false;
        }
        if (f2 > 1.0f) {
            f2 -= 1.0f;
        } else if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 != this.R3) {
            float min = Math.min(f2 * 360.0f, 360.0f);
            this.R3 = min;
            this.Q3 = min;
            this.O3 = SystemClock.uptimeMillis();
            invalidate();
        }
    }

    public void setLinearProgress(boolean z) {
        this.P3 = z;
        if (!this.S3) {
            invalidate();
        }
    }

    public void setProgress(float f2) {
        if (this.S3) {
            this.S3 = false;
            c();
        }
        if (f2 > 1.0f) {
            f2 -= 1.0f;
        } else if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        float f3 = this.R3;
        if (f2 != f3) {
            if (this.Q3 == f3) {
                this.O3 = SystemClock.uptimeMillis();
            }
            this.R3 = Math.min(f2 * 360.0f, 360.0f);
            invalidate();
        }
    }

    public void setRimColor(int i) {
        this.J3 = i;
        h();
        if (!this.S3) {
            invalidate();
        }
    }

    public void setRimWidth(int i) {
        this.q = i;
        if (!this.S3) {
            invalidate();
        }
    }

    public void setSpinSpeed(float f2) {
        this.N3 = f2 * 360.0f;
    }

    public TPProgressWheel(Context context) {
        super(context);
        f();
    }
}
