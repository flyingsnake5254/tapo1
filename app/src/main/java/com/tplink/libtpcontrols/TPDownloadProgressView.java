package com.tplink.libtpcontrols;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

/* loaded from: classes3.dex */
public class TPDownloadProgressView extends View {
    private int H3;
    private float I3;
    private float J3;
    private float K3;
    private float L3;
    private float M3;
    private float N3;
    private float O3;
    private float P3;
    private float Q3;
    private float R3;
    private float S3;
    private RectF T3;
    private RectF U3;
    private RectF V3;
    private ValueAnimator W3;
    private ValueAnimator X3;
    private ValueAnimator Y3;
    private ValueAnimator Z3;
    private ValueAnimator a4;
    private boolean b4;

    /* renamed from: c  reason: collision with root package name */
    private Paint f12096c;
    private boolean c4;

    /* renamed from: d  reason: collision with root package name */
    private Paint f12097d;
    private boolean d4;
    private int e4;

    /* renamed from: f  reason: collision with root package name */
    private Paint f12098f;
    private c f4;
    private b g4;
    private float p0;
    private float p1;
    private float p2;
    private int p3;
    private Paint q;
    private int x;
    private int y;
    private float z;

    /* loaded from: classes3.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        private int f12099c;

        /* renamed from: d  reason: collision with root package name */
        private int f12100d;

        /* loaded from: classes3.dex */
        static class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f12099c);
            parcel.writeInt(this.f12100d);
        }

        public SavedState(Parcelable parcelable, int i, int i2) {
            super(parcelable);
            this.f12099c = i;
            this.f12100d = i2;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f12099c = parcel.readInt();
            this.f12100d = parcel.readInt();
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onComplete();
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(float f2);
    }

    public TPDownloadProgressView(Context context) {
        this(context, null);
    }

    private void a(Canvas canvas) {
        this.T3 = new RectF();
        if (this.I3 == 0.0f) {
            this.I3 = (getMeasuredHeight() * this.z) / 2.0f;
        }
        RectF rectF = this.T3;
        rectF.left = 2.0f;
        rectF.top = ((getMeasuredHeight() * (1.0f - this.z)) / 2.0f) + 2.0f;
        this.T3.right = getMeasuredWidth() - 2;
        this.T3.bottom = ((getMeasuredHeight() * (this.z + 1.0f)) / 2.0f) - 2.0f;
        int i = this.e4;
        if (i == 0) {
            if (this.q.getShader() != null) {
                this.q.setShader(null);
            }
            this.q.setColor(this.y);
            RectF rectF2 = this.U3;
            float f2 = this.I3;
            canvas.drawRoundRect(rectF2, f2, f2, this.q);
            this.f12096c.setColor(this.x);
            RectF rectF3 = this.U3;
            float f3 = this.I3;
            canvas.drawRoundRect(rectF3, f3, f3, this.f12096c);
            canvas.drawCircle(this.I3 + 2.0f + this.S3, getMeasuredHeight() / 2.0f, this.J3, this.f12097d);
        } else if (i == 1) {
            float f4 = this.p0 / (this.p3 + 0.0f);
            LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{this.x, this.y}, new float[]{f4, f4 + 0.001f}, Shader.TileMode.CLAMP);
            this.q.setShader(linearGradient);
            this.q.setColor(this.x);
            this.q.setShader(linearGradient);
            RectF rectF4 = this.T3;
            float f5 = this.I3;
            canvas.drawRoundRect(rectF4, f5, f5, this.q);
            if (this.b4) {
                float f6 = this.I3;
                float f7 = (float) (this.T3.right - (f6 * 1.5d));
                float measuredHeight = f6 + ((getMeasuredHeight() * (1.0f - this.z)) / 2.0f);
                float f8 = this.K3;
                if (f8 > 0.0f && f7 - f8 > this.I3 * 0.35d) {
                    canvas.drawCircle(f7 - f8, measuredHeight - this.L3, 10.0f, this.f12098f);
                }
                float f9 = this.M3;
                if (f9 > 0.0f && f7 - f9 > this.I3 * 0.35d) {
                    canvas.drawCircle(f7 - f9, measuredHeight - this.N3, 4.0f, this.f12098f);
                }
                float f10 = this.O3;
                if (f10 > 0.0f && f7 - f10 > this.I3 * 0.35d) {
                    canvas.drawCircle(f7 - f10, measuredHeight - this.P3, 6.0f, this.f12098f);
                }
                float f11 = this.Q3;
                if (f11 > 0.0f && f7 - f11 > this.I3 * 0.35d) {
                    canvas.drawCircle(f7 - f11, measuredHeight - this.R3, 8.0f, this.f12098f);
                }
                float f12 = this.Q3;
                if (f12 > 0.0f) {
                    float f13 = f12 + this.I3;
                    float f14 = this.T3.right;
                    int i2 = this.p3;
                    float f15 = this.p0;
                    if (f13 > (f14 * (i2 - f15)) / i2) {
                        this.b4 = false;
                        if (this.p2 >= f15 + 10.0f) {
                            setTargetProgress((((int) (f15 / 10.0f)) * 10) + 10);
                        }
                    }
                }
            }
            this.f12096c.setColor(this.x);
            RectF rectF5 = this.T3;
            float f16 = this.I3;
            canvas.drawRoundRect(rectF5, f16, f16, this.f12096c);
            float f17 = this.T3.right;
            float f18 = this.I3;
            canvas.drawCircle(f17 - f18, f18 + ((getMeasuredHeight() * (1.0f - this.z)) / 2.0f), this.I3 - 1.0f, this.f12097d);
        } else if (i == 2) {
            if (!this.c4) {
                this.f12096c.setColor(this.x);
                RectF rectF6 = this.V3;
                float f19 = this.I3;
                canvas.drawRoundRect(rectF6, f19, f19, this.f12096c);
                this.q.setShader(null);
                this.q.setColor(this.x);
                RectF rectF7 = this.V3;
                float f20 = this.I3;
                canvas.drawRoundRect(rectF7, f20, f20, this.q);
                return;
            }
            canvas.drawCircle(this.I3 + this.S3, getMeasuredHeight() / 2.0f, this.J3, this.f12097d);
        }
    }

    private void b() {
        this.p3 = 100;
        this.H3 = 0;
        this.p0 = 0.0f;
        Paint paint = new Paint();
        this.f12096c = paint;
        paint.setAntiAlias(true);
        this.f12096c.setStrokeWidth(3.0f);
        this.f12096c.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.q = paint2;
        paint2.setAntiAlias(true);
        this.q.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint();
        this.f12097d = paint3;
        paint3.setAntiAlias(true);
        this.f12097d.setStyle(Paint.Style.FILL);
        this.f12097d.setColor(this.x);
        Paint paint4 = new Paint();
        this.f12098f = paint4;
        paint4.setAntiAlias(true);
        this.f12098f.setStyle(Paint.Style.FILL);
        this.f12098f.setColor(this.x);
        this.e4 = 0;
        invalidate();
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x0.TPDownloadProgressView);
        this.x = obtainStyledAttributes.getColor(x0.TPDownloadProgressView_dl_progressbtn_backgroud_color, Color.parseColor("#FFcb00"));
        this.y = obtainStyledAttributes.getColor(x0.TPDownloadProgressView_dl_progressbtn_backgroud_second_color, -1);
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void e(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.K3 = (floatValue / 360.0f) * ((getMeasuredWidth() * 2.0f) / 5.0f);
        this.L3 = ((((float) Math.sin(Math.toRadians(floatValue))) * this.I3) * 4.0f) / 5.0f;
        float f2 = floatValue - 40.0f;
        this.M3 = (f2 / 360.0f) * ((getMeasuredWidth() * 2.0f) / 5.0f);
        this.N3 = ((((float) Math.sin(Math.toRadians(f2))) * this.I3) * 4.0f) / 5.0f;
        float f3 = floatValue - 80.0f;
        this.O3 = (f3 / 360.0f) * ((getMeasuredWidth() * 2.0f) / 5.0f);
        this.P3 = ((((float) Math.sin(Math.toRadians(f3))) * this.I3) * 4.0f) / 5.0f;
        float f4 = floatValue - 120.0f;
        this.Q3 = (f4 / 360.0f) * ((getMeasuredWidth() * 2.0f) / 5.0f);
        this.R3 = ((((float) Math.sin(Math.toRadians(f4))) * this.I3) * 4.0f) / 5.0f;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void g(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float f2 = (this.p1 - 10.0f) + ((floatValue * 10.0f) / 100.0f);
        this.p0 = f2;
        c cVar = this.f4;
        if (cVar != null) {
            cVar.a(f2);
        }
        if (floatValue != 100.0f) {
            invalidate();
        } else if (this.p2 >= this.p0 + 10.0f) {
            this.X3.cancel();
            o();
        }
        if (this.p0 >= 100.0f) {
            setState(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ void i(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.c4 = false;
        RectF rectF = this.V3;
        rectF.left = 2.0f;
        rectF.top = ((getMeasuredHeight() * (1.0f - this.z)) / 2.0f) + 2.0f;
        this.V3.bottom = ((getMeasuredHeight() * (this.z + 1.0f)) / 2.0f) - 2.0f;
        RectF rectF2 = this.V3;
        float f2 = this.T3.right;
        rectF2.right = f2 - (((f2 - (this.I3 * 2.0f)) * floatValue) / 100.0f);
        invalidate();
        if (floatValue == 100.0f) {
            this.c4 = true;
            this.Z3.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public /* synthetic */ void k(ValueAnimator valueAnimator) {
        b bVar;
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (floatValue <= 100.0f) {
            this.J3 = this.I3 - 1.0f;
            this.S3 = (((getMeasuredWidth() / 2.0f) - this.I3) * floatValue) / 100.0f;
        } else {
            float f2 = this.I3;
            this.S3 = (getMeasuredWidth() / 2.0f) - f2;
            this.J3 = (f2 - 1.0f) + (((f2 * 2.5f) * (floatValue - 100.0f)) / 100.0f);
            if (floatValue >= 130.0f && (bVar = this.g4) != null) {
                bVar.onComplete();
            }
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public /* synthetic */ void m(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (floatValue >= 30.0f) {
            RectF rectF = this.U3;
            rectF.left = 2.0f;
            rectF.top = ((getMeasuredHeight() * (1.0f - this.z)) / 2.0f) + 2.0f;
            this.U3.bottom = ((getMeasuredHeight() * (this.z + 1.0f)) / 2.0f) - 2.0f;
            RectF rectF2 = this.U3;
            float f2 = this.I3;
            float f3 = floatValue - 30.0f;
            rectF2.right = (this.I3 * 2.0f) + ((((getMeasuredWidth() - 2) - (f2 * 2.0f)) * f3) / 100.0f);
            this.J3 = f2 - 1.0f;
            float f4 = this.I3;
            this.S3 = (((((getMeasuredWidth() - 2) - f4) - f4) - 2.0f) * f3) / 100.0f;
            invalidate();
        }
    }

    private void n() {
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1005.0f).setDuration(2000L);
        this.W3 = duration;
        duration.setInterpolator(new AccelerateDecelerateInterpolator());
        this.W3.setRepeatMode(1);
        this.W3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tplink.libtpcontrols.x
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                TPDownloadProgressView.this.e(valueAnimator);
            }
        });
        ValueAnimator duration2 = ValueAnimator.ofFloat(0.0f, 100.0f).setDuration(1500L);
        this.X3 = duration2;
        duration2.setRepeatMode(1);
        this.X3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tplink.libtpcontrols.t
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                TPDownloadProgressView.this.g(valueAnimator);
            }
        });
        ValueAnimator duration3 = ValueAnimator.ofFloat(0.0f, 100.0f).setDuration(1000L);
        this.Y3 = duration3;
        duration3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tplink.libtpcontrols.u
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                TPDownloadProgressView.this.i(valueAnimator);
            }
        });
        ValueAnimator duration4 = ValueAnimator.ofFloat(0.0f, 130.0f).setDuration(1300L);
        this.Z3 = duration4;
        duration4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tplink.libtpcontrols.w
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                TPDownloadProgressView.this.k(valueAnimator);
            }
        });
        ValueAnimator duration5 = ValueAnimator.ofFloat(0.0f, 130.0f).setDuration(1300L);
        this.a4 = duration5;
        duration5.setInterpolator(new AccelerateDecelerateInterpolator());
        this.a4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tplink.libtpcontrols.v
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                TPDownloadProgressView.this.m(valueAnimator);
            }
        });
    }

    @TargetApi(19)
    private void setTargetProgress(float f2) {
        int i = this.H3;
        if (f2 >= i && f2 <= this.p3) {
            this.p1 = f2;
            this.X3.start();
        } else if (f2 < i) {
            this.p0 = 0.0f;
        } else if (f2 > this.p3) {
            this.p0 = 100.0f;
            invalidate();
        }
    }

    public int getMaxProgress() {
        return this.p3;
    }

    public int getMinProgress() {
        return this.H3;
    }

    public float getProgress() {
        return this.p0;
    }

    public int getState() {
        return this.e4;
    }

    public void o() {
        int i = this.e4;
        if (i == 2) {
            this.b4 = false;
            this.W3.cancel();
            invalidate();
        } else if (i == 0) {
            this.b4 = false;
            this.W3.cancel();
            invalidate();
        } else if (i == 1 && !this.W3.isRunning() && !this.X3.isRunning()) {
            this.b4 = true;
            this.W3.start();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.d4) {
            this.d4 = false;
            this.a4.start();
        } else if (!isInEditMode()) {
            a(canvas);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.e4 = savedState.f12100d;
        this.p0 = savedState.f12099c;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), (int) this.p0, this.e4);
    }

    public void setCircleColor(int i) {
        this.f12097d.setColor(i);
        invalidate();
    }

    public void setMaxProgress(int i) {
        this.p3 = i;
    }

    public void setMinProgress(int i) {
        this.H3 = i;
    }

    public void setOnDownloadCompleteListener(b bVar) {
        this.g4 = bVar;
    }

    public void setOnProgressListener(c cVar) {
        this.f4 = cVar;
    }

    public void setProgress(float f2) {
        this.p0 = f2;
    }

    public void setState(int i) {
        this.e4 = i;
        if (i == 2) {
            this.Y3.start();
        } else if (i == 0) {
            invalidate();
        }
    }

    public void setToProgress(float f2) {
        int i = this.H3;
        if (f2 >= i && f2 <= this.p3) {
            if (this.p2 < f2) {
                this.p2 = f2;
            }
            if (this.p2 >= this.p0 + 10.0f) {
                o();
            }
        } else if (f2 < i) {
            this.p2 = 0.0f;
        } else if (f2 > this.p3) {
            this.p2 = 100.0f;
        }
    }

    public TPDownloadProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.z = 0.4f;
        this.U3 = new RectF();
        this.V3 = new RectF();
        this.b4 = false;
        this.c4 = false;
        this.d4 = true;
        this.f4 = null;
        this.g4 = null;
        if (!isInEditMode()) {
            c(context, attributeSet);
            b();
            n();
        }
    }
}
