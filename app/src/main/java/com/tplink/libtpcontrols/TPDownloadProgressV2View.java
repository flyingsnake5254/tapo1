package com.tplink.libtpcontrols;

import android.animation.Animator;
import android.animation.ValueAnimator;
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
import androidx.annotation.NonNull;
import androidx.core.text.TextUtilsCompat;

/* loaded from: classes3.dex */
public class TPDownloadProgressV2View extends View {
    private int H3;
    private int I3;
    private int J3;
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
    private float W3;
    private float X3;
    private ValueAnimator Y3;
    private ValueAnimator Z3;
    private ValueAnimator a4;
    private ValueAnimator b4;

    /* renamed from: c  reason: collision with root package name */
    private Paint f12087c;
    private ValueAnimator c4;

    /* renamed from: d  reason: collision with root package name */
    private Paint f12088d;
    private boolean d4;
    private boolean e4;

    /* renamed from: f  reason: collision with root package name */
    private Paint f12089f;
    private int f4;
    private f g4;
    private e h4;
    private float p0;
    private float p1;
    private float p2;
    private float p3;
    private Paint q;
    private int x;
    private int y;
    private float z;

    /* loaded from: classes3.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        private int f12090c;

        /* renamed from: d  reason: collision with root package name */
        private int f12091d;

        /* loaded from: classes3.dex */
        static class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f12090c);
            parcel.writeInt(this.f12091d);
        }

        public SavedState(Parcelable parcelable, int i, int i2) {
            super(parcelable);
            this.f12090c = i;
            this.f12091d = i2;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f12090c = parcel.readInt();
            this.f12091d = parcel.readInt();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            TPDownloadProgressV2View.this.setState(2);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            TPDownloadProgressV2View.this.Z3.cancel();
            if (TPDownloadProgressV2View.this.p2 >= TPDownloadProgressV2View.this.p0 + TPDownloadProgressV2View.this.J3 && !TPDownloadProgressV2View.this.Y3.isRunning()) {
                TPDownloadProgressV2View.this.d4 = true;
                TPDownloadProgressV2View.this.Y3.start();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            TPDownloadProgressV2View.this.setState(4);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements Animator.AnimatorListener {
        d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            TPDownloadProgressV2View.this.setState(5);
            if (TPDownloadProgressV2View.this.h4 != null) {
                TPDownloadProgressV2View.this.h4.a();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a();
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a(float f2);
    }

    public TPDownloadProgressV2View(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public /* synthetic */ void B(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float f2 = this.p1;
        float f3 = this.p3;
        float f4 = (f2 - f3) + (f3 * floatValue);
        this.p0 = f4;
        f fVar = this.g4;
        if (fVar != null) {
            fVar.a(f4);
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public /* synthetic */ void D(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (v()) {
            RectF rectF = this.V3;
            RectF rectF2 = this.T3;
            float f2 = rectF2.left;
            float f3 = rectF2.right;
            rectF.left = f2 + (((f3 - (this.W3 * 2.0f)) * floatValue) / 100.0f);
            rectF.right = f3;
        } else {
            RectF rectF3 = this.V3;
            rectF3.left = 2.0f;
            float f4 = this.T3.right;
            rectF3.right = f4 - (((f4 - (this.W3 * 2.0f)) * floatValue) / 100.0f);
        }
        this.V3.top = ((getMeasuredHeight() * (1.0f - this.z)) / 2.0f) + 2.0f;
        this.V3.bottom = ((getMeasuredHeight() * (this.z + 1.0f)) / 2.0f) - 2.0f;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public /* synthetic */ void F(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (floatValue <= 100.0f) {
            this.X3 = this.W3 - 1.0f;
            if (v()) {
                this.S3 = (getMeasuredWidth() - (this.W3 * 2.0f)) - ((((getMeasuredWidth() / 2.0f) - this.W3) * floatValue) / 100.0f);
            } else {
                this.S3 = (((getMeasuredWidth() / 2.0f) - this.W3) * floatValue) / 100.0f;
            }
        } else {
            float f2 = this.W3;
            this.S3 = (getMeasuredWidth() / 2.0f) - f2;
            this.X3 = (f2 - 1.0f) + (((f2 * 2.5f) * (floatValue - 100.0f)) / 100.0f);
        }
        invalidate();
    }

    private void G() {
        if (this.f4 != 2) {
            this.d4 = false;
            this.Y3.cancel();
            invalidate();
        } else if (!this.Y3.isRunning() && !this.Z3.isRunning()) {
            this.d4 = true;
            this.Y3.start();
        }
    }

    private void H(float f2) {
        this.U3.top = ((getMeasuredHeight() * (1.0f - this.z)) / 2.0f) + 2.0f;
        this.U3.bottom = ((getMeasuredHeight() * (this.z + 1.0f)) / 2.0f) - 2.0f;
        this.X3 = this.W3 - 1.0f;
        if (v()) {
            this.U3.left = ((getMeasuredWidth() - 2) - (this.W3 * 2.0f)) - (((getMeasuredWidth() - 2) - (this.W3 * 2.0f)) * f2);
            this.U3.right = getMeasuredWidth() - 2;
            float f3 = this.W3;
            this.S3 = ((((getMeasuredWidth() - 2) - f3) - f3) - 2.0f) * (1.0f - f2);
            return;
        }
        RectF rectF = this.U3;
        rectF.left = 2.0f;
        rectF.right = (this.W3 * 2.0f) + (((getMeasuredWidth() - 2) - (this.W3 * 2.0f)) * f2);
        float f4 = this.W3;
        this.S3 = ((((getMeasuredWidth() - 2) - f4) - f4) - 2.0f) * f2;
    }

    private void i(Canvas canvas) {
        if (this.q.getShader() != null) {
            this.q.setShader(null);
        }
        this.q.setColor(this.y);
        RectF rectF = this.U3;
        float f2 = this.W3;
        canvas.drawRoundRect(rectF, f2, f2, this.q);
        this.f12087c.setColor(this.x);
        RectF rectF2 = this.U3;
        float f3 = this.W3;
        canvas.drawRoundRect(rectF2, f3, f3, this.f12087c);
        canvas.drawCircle(this.W3 + 2.0f + this.S3, getMeasuredHeight() / 2.0f, this.X3, this.f12088d);
    }

    private void j(Canvas canvas) {
        canvas.drawCircle(this.W3 + this.S3, getMeasuredHeight() / 2.0f, this.X3, this.f12088d);
    }

    private void k(Canvas canvas) {
        if (this.d4) {
            float measuredHeight = this.W3 + ((getMeasuredHeight() * (1.0f - this.z)) / 2.0f);
            if (v()) {
                RectF rectF = this.T3;
                float f2 = this.W3;
                float f3 = (float) (rectF.left + (f2 * 1.5d));
                float f4 = this.K3;
                if (f4 > 0.0f && f4 + f3 < rectF.right - (f2 * 0.35d)) {
                    canvas.drawCircle(f4 + f3, measuredHeight - this.L3, 10.0f, this.f12089f);
                }
                float f5 = this.M3;
                if (f5 > 0.0f && f5 + f3 < this.T3.right - (this.W3 * 0.35d)) {
                    canvas.drawCircle(f5 + f3, measuredHeight - this.N3, 4.0f, this.f12089f);
                }
                float f6 = this.O3;
                if (f6 > 0.0f && f6 + f3 < this.T3.right - (this.W3 * 0.35d)) {
                    canvas.drawCircle(f6 + f3, measuredHeight - this.P3, 6.0f, this.f12089f);
                }
                float f7 = this.Q3;
                if (f7 > 0.0f && f7 + f3 < this.T3.right - (this.W3 * 0.35d)) {
                    canvas.drawCircle(f7 + f3, measuredHeight - this.R3, 8.0f, this.f12089f);
                }
            } else {
                float f8 = this.W3;
                float f9 = (float) (this.T3.right - (f8 * 1.5d));
                float f10 = this.K3;
                if (f10 > 0.0f && f9 - f10 > f8 * 0.35d) {
                    canvas.drawCircle(f9 - f10, measuredHeight - this.L3, 10.0f, this.f12089f);
                }
                float f11 = this.M3;
                if (f11 > 0.0f && f9 - f11 > this.W3 * 0.35d) {
                    canvas.drawCircle(f9 - f11, measuredHeight - this.N3, 4.0f, this.f12089f);
                }
                float f12 = this.O3;
                if (f12 > 0.0f && f9 - f12 > this.W3 * 0.35d) {
                    canvas.drawCircle(f9 - f12, measuredHeight - this.P3, 6.0f, this.f12089f);
                }
                float f13 = this.Q3;
                if (f13 > 0.0f && f9 - f13 > this.W3 * 0.35d) {
                    canvas.drawCircle(f9 - f13, measuredHeight - this.R3, 8.0f, this.f12089f);
                }
            }
            float f14 = this.Q3;
            if (f14 > 0.0f) {
                float f15 = f14 + this.W3;
                float f16 = this.T3.right;
                int i = this.H3;
                if (f15 > (f16 * (i - this.p0)) / i) {
                    q();
                }
            }
        }
    }

    private void l(Canvas canvas) {
        this.f12087c.setColor(this.x);
        RectF rectF = this.T3;
        float f2 = this.W3;
        canvas.drawRoundRect(rectF, f2, f2, this.f12087c);
        if (v()) {
            float f3 = this.T3.left;
            float f4 = this.W3;
            canvas.drawCircle(f3 + f4, f4 + ((getMeasuredHeight() * (1.0f - this.z)) / 2.0f), this.W3 - 1.0f, this.f12088d);
            return;
        }
        float f5 = this.T3.right;
        float f6 = this.W3;
        canvas.drawCircle(f5 - f6, f6 + ((getMeasuredHeight() * (1.0f - this.z)) / 2.0f), this.W3 - 1.0f, this.f12088d);
    }

    private void m(Canvas canvas) {
        this.f12087c.setColor(this.x);
        RectF rectF = this.V3;
        float f2 = this.W3;
        canvas.drawRoundRect(rectF, f2, f2, this.f12087c);
        float f3 = this.p0;
        if (f3 == 0.0f) {
            this.q.setShader(null);
            this.q.setColor(this.y);
        } else {
            RectF rectF2 = this.V3;
            RectF rectF3 = this.T3;
            float f4 = (this.H3 * (rectF2.right - rectF2.left)) / (rectF3.right - rectF3.left);
            if (f3 < f4) {
                float f5 = f3 / (f4 + 0.0f);
                this.q.setShader(new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{this.x, this.y}, new float[]{f5, f5 + 0.001f}, Shader.TileMode.CLAMP));
            } else {
                this.q.setShader(null);
                this.q.setColor(this.x);
            }
        }
        RectF rectF4 = this.V3;
        float f6 = this.W3;
        canvas.drawRoundRect(rectF4, f6, f6, this.q);
        if (v()) {
            float f7 = this.V3.left;
            float f8 = this.W3;
            canvas.drawCircle(f7 + f8, f8 + ((getMeasuredHeight() * (1.0f - this.z)) / 2.0f), this.W3 - 1.0f, this.f12088d);
            return;
        }
        float f9 = this.V3.right;
        float f10 = this.W3;
        canvas.drawCircle(f9 - f10, f10 + ((getMeasuredHeight() * (1.0f - this.z)) / 2.0f), this.W3 - 1.0f, this.f12088d);
    }

    private void n(Canvas canvas) {
        LinearGradient linearGradient;
        float f2 = this.p0 / (this.H3 + 0.0f);
        if (v()) {
            linearGradient = new LinearGradient(getMeasuredWidth(), 0.0f, 0.0f, 0.0f, new int[]{this.x, this.y}, new float[]{f2, f2 + 0.001f}, Shader.TileMode.CLAMP);
        } else {
            linearGradient = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{this.x, this.y}, new float[]{f2, f2 + 0.001f}, Shader.TileMode.CLAMP);
        }
        this.q.setColor(this.x);
        this.q.setShader(linearGradient);
        RectF rectF = this.T3;
        float f3 = this.W3;
        canvas.drawRoundRect(rectF, f3, f3, this.q);
    }

    private void o(Canvas canvas) {
        float f2 = this.W3;
        canvas.drawCircle(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f, (f2 - 1.0f) + (f2 * 2.5f * 0.3f), this.f12088d);
    }

    private void p(Canvas canvas) {
        int i = this.f4;
        if (i == 0) {
            i(canvas);
        } else if (i == 2) {
            n(canvas);
            k(canvas);
            l(canvas);
        } else if (i == 3) {
            m(canvas);
        } else if (i == 4) {
            j(canvas);
        } else if (i == 5) {
            o(canvas);
        }
    }

    private void q() {
        this.d4 = false;
        this.Y3.cancel();
        float f2 = this.p2;
        float f3 = this.p0;
        int i = this.J3;
        if (f2 >= i + f3) {
            setInterTargetProgress((((int) ((f2 - f3) / i)) * i) + f3);
        }
    }

    private void r() {
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(1000L);
        this.c4 = duration;
        duration.setInterpolator(new AccelerateDecelerateInterpolator());
        this.c4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tplink.libtpcontrols.r
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                TPDownloadProgressV2View.this.x(valueAnimator);
            }
        });
        this.c4.addListener(new a());
        ValueAnimator duration2 = ValueAnimator.ofFloat(0.0f, 1005.0f).setDuration(2000L);
        this.Y3 = duration2;
        duration2.setInterpolator(new AccelerateDecelerateInterpolator());
        this.Y3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tplink.libtpcontrols.o
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                TPDownloadProgressV2View.this.z(valueAnimator);
            }
        });
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.Z3 = ofFloat;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tplink.libtpcontrols.s
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                TPDownloadProgressV2View.this.B(valueAnimator);
            }
        });
        this.Z3.addListener(new b());
        ValueAnimator duration3 = ValueAnimator.ofFloat(0.0f, 100.0f).setDuration(1000L);
        this.a4 = duration3;
        duration3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tplink.libtpcontrols.q
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                TPDownloadProgressV2View.this.D(valueAnimator);
            }
        });
        this.a4.addListener(new c());
        ValueAnimator duration4 = ValueAnimator.ofFloat(0.0f, 130.0f).setDuration(1300L);
        this.b4 = duration4;
        duration4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tplink.libtpcontrols.p
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                TPDownloadProgressV2View.this.F(valueAnimator);
            }
        });
        this.b4.addListener(new d());
    }

    private void s(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x0.TPDownloadProgressView);
        this.x = obtainStyledAttributes.getColor(x0.TPDownloadProgressView_dl_progressbtn_backgroud_color, Color.parseColor("#FFcb00"));
        this.y = obtainStyledAttributes.getColor(x0.TPDownloadProgressView_dl_progressbtn_backgroud_second_color, -1);
        obtainStyledAttributes.recycle();
    }

    private void setInterTargetProgress(float f2) {
        int i = this.I3;
        if (f2 >= i && f2 <= this.H3) {
            this.p1 = f2;
            float f3 = f2 - this.p0;
            this.p3 = f3;
            this.Z3.setDuration(f3 * 150.0f);
            this.Z3.start();
        } else if (f2 < i) {
            this.p0 = 0.0f;
        } else if (f2 > this.H3) {
            this.p0 = 100.0f;
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setState(int i) {
        this.f4 = i;
        if (i == 3) {
            if (this.Y3.isStarted() || this.Y3.isRunning()) {
                this.Y3.cancel();
            }
            if (this.Z3.isStarted() || this.Z3.isRunning()) {
                this.Z3.cancel();
            }
            this.a4.start();
        } else if (i == 4) {
            this.b4.start();
        } else if (i == 5) {
            invalidate();
        }
    }

    private void t() {
        if (this.W3 == 0.0f) {
            this.W3 = (getMeasuredHeight() * this.z) / 2.0f;
        }
        RectF rectF = this.T3;
        rectF.left = 2.0f;
        rectF.top = ((getMeasuredHeight() * (1.0f - this.z)) / 2.0f) + 2.0f;
        this.T3.right = getMeasuredWidth() - 2;
        this.T3.bottom = ((getMeasuredHeight() * (this.z + 1.0f)) / 2.0f) - 2.0f;
    }

    private void u() {
        Paint paint = new Paint();
        this.f12087c = paint;
        paint.setAntiAlias(true);
        this.f12087c.setStrokeWidth(3.0f);
        this.f12087c.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.q = paint2;
        paint2.setAntiAlias(true);
        this.q.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint();
        this.f12088d = paint3;
        paint3.setAntiAlias(true);
        this.f12088d.setStyle(Paint.Style.FILL);
        this.f12088d.setColor(this.x);
        Paint paint4 = new Paint();
        this.f12089f = paint4;
        paint4.setAntiAlias(true);
        this.f12089f.setStyle(Paint.Style.FILL);
        this.f12089f.setColor(this.x);
        this.f4 = 0;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w */
    public /* synthetic */ void x(ValueAnimator valueAnimator) {
        H(((Float) valueAnimator.getAnimatedValue()).floatValue());
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public /* synthetic */ void z(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.K3 = (floatValue / 360.0f) * ((getMeasuredWidth() * 2.0f) / 5.0f);
        this.L3 = ((((float) Math.sin(Math.toRadians(floatValue))) * this.W3) * 4.0f) / 5.0f;
        float f2 = floatValue - 40.0f;
        this.M3 = (f2 / 360.0f) * ((getMeasuredWidth() * 2.0f) / 5.0f);
        this.N3 = ((((float) Math.sin(Math.toRadians(f2))) * this.W3) * 4.0f) / 5.0f;
        float f3 = floatValue - 80.0f;
        this.O3 = (f3 / 360.0f) * ((getMeasuredWidth() * 2.0f) / 5.0f);
        this.P3 = ((((float) Math.sin(Math.toRadians(f3))) * this.W3) * 4.0f) / 5.0f;
        float f4 = floatValue - 120.0f;
        this.Q3 = (f4 / 360.0f) * ((getMeasuredWidth() * 2.0f) / 5.0f);
        this.R3 = ((((float) Math.sin(Math.toRadians(f4))) * this.W3) * 4.0f) / 5.0f;
        invalidate();
    }

    public int getMaxProgress() {
        return this.H3;
    }

    public int getMinProgress() {
        return this.I3;
    }

    public float getProgress() {
        return this.p0;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.e4) {
            this.e4 = false;
        } else {
            p(canvas);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f4 = savedState.f12091d;
        this.p0 = savedState.f12090c;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), (int) this.p0, this.f4);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        t();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        invalidate();
    }

    public void setCircleColor(int i) {
        this.f12088d.setColor(i);
        invalidate();
    }

    public void setMaxProgress(int i) {
        this.H3 = i;
    }

    public void setMinProgress(int i) {
        this.I3 = i;
    }

    public void setOnMoveToCenterCallback(e eVar) {
        this.h4 = eVar;
    }

    public void setOnProgressListener(f fVar) {
        this.g4 = fVar;
    }

    public void setProgress(float f2) {
        this.e4 = false;
        int i = this.I3;
        if (f2 >= i && f2 <= this.H3) {
            if (this.p2 <= f2) {
                this.p2 = f2;
            }
            if (this.p2 >= this.p0 + this.J3) {
                G();
            }
        } else if (f2 < i) {
            this.p2 = i;
        } else {
            int i2 = this.H3;
            if (f2 > i2) {
                this.p2 = i2;
            }
        }
    }

    protected boolean v() {
        return TextUtilsCompat.getLayoutDirectionFromLocale(getContext().getResources().getConfiguration().locale) == 1;
    }

    public TPDownloadProgressV2View(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.z = 0.4f;
        this.H3 = 100;
        this.I3 = 0;
        this.J3 = 1;
        this.T3 = new RectF();
        this.U3 = new RectF();
        this.V3 = new RectF();
        this.d4 = false;
        this.e4 = true;
        this.g4 = null;
        this.h4 = null;
        s(context, attributeSet);
        u();
        r();
    }
}
