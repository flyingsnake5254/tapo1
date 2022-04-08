package com.tplink.libtpcontrols;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.core.view.ViewCompat;

/* loaded from: classes3.dex */
public class ShSwitchView extends View {
    private int H3;
    private float I3;
    private int J3;
    private int K3;
    private Drawable L3;
    private RectF M3;
    private float N3;
    private float O3;
    private float P3;
    private float Q3;
    private boolean R3;
    private boolean S3;
    private boolean T3;
    private RectF U3;
    private float V3;
    private float W3;
    private float X3;
    private int Y3;
    private int Z3;
    private int a4;
    private Paint b4;

    /* renamed from: c  reason: collision with root package name */
    private ObjectAnimator f12043c;
    private RectF c4;

    /* renamed from: d  reason: collision with root package name */
    private Property<ShSwitchView, Float> f12044d;
    private Path d4;
    private RectF e4;

    /* renamed from: f  reason: collision with root package name */
    private ObjectAnimator f12045f;
    private boolean f4;
    private boolean g4;
    private e h4;
    private GestureDetector.SimpleOnGestureListener p0;
    private int p1;
    private int p2;
    private int p3;
    private Property<ShSwitchView, Float> q;
    private ObjectAnimator x;
    private Property<ShSwitchView, Float> y;
    private GestureDetector z;

    /* loaded from: classes3.dex */
    class a extends Property<ShSwitchView, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(ShSwitchView shSwitchView) {
            return Float.valueOf(shSwitchView.getInnerContentRate());
        }

        /* renamed from: b */
        public void set(ShSwitchView shSwitchView, Float f2) {
            shSwitchView.setInnerContentRate(f2.floatValue());
        }
    }

    /* loaded from: classes3.dex */
    class b extends Property<ShSwitchView, Float> {
        b(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(ShSwitchView shSwitchView) {
            return Float.valueOf(shSwitchView.getKnobExpandRate());
        }

        /* renamed from: b */
        public void set(ShSwitchView shSwitchView, Float f2) {
            shSwitchView.setKnobExpandRate(f2.floatValue());
        }
    }

    /* loaded from: classes3.dex */
    class c extends Property<ShSwitchView, Float> {
        c(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(ShSwitchView shSwitchView) {
            return Float.valueOf(shSwitchView.getKnobMoveRate());
        }

        /* renamed from: b */
        public void set(ShSwitchView shSwitchView, Float f2) {
            shSwitchView.setKnobMoveRate(f2.floatValue());
        }
    }

    /* loaded from: classes3.dex */
    class d extends GestureDetector.SimpleOnGestureListener {
        d() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            if (!ShSwitchView.this.isEnabled()) {
                return false;
            }
            ShSwitchView shSwitchView = ShSwitchView.this;
            shSwitchView.T3 = shSwitchView.S3;
            ShSwitchView.this.f12043c.setFloatValues(ShSwitchView.this.V3, 0.0f);
            ShSwitchView.this.f12043c.start();
            ShSwitchView.this.f12045f.setFloatValues(ShSwitchView.this.P3, 1.0f);
            ShSwitchView.this.f12045f.start();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (motionEvent2.getX() > ShSwitchView.this.p3) {
                if (!ShSwitchView.this.R3) {
                    ShSwitchView.this.R3 = true;
                    ShSwitchView.this.x.setFloatValues(ShSwitchView.this.Q3, 1.0f);
                    ShSwitchView.this.x.start();
                    ShSwitchView.this.f12043c.setFloatValues(ShSwitchView.this.V3, 0.0f);
                    ShSwitchView.this.f12043c.start();
                }
            } else if (ShSwitchView.this.R3) {
                ShSwitchView.this.R3 = false;
                ShSwitchView.this.x.setFloatValues(ShSwitchView.this.Q3, 0.0f);
                ShSwitchView.this.x.start();
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            ShSwitchView shSwitchView = ShSwitchView.this;
            shSwitchView.S3 = shSwitchView.R3;
            if (ShSwitchView.this.T3 == ShSwitchView.this.S3) {
                ShSwitchView shSwitchView2 = ShSwitchView.this;
                shSwitchView2.S3 = !shSwitchView2.S3;
                ShSwitchView shSwitchView3 = ShSwitchView.this;
                shSwitchView3.R3 = !shSwitchView3.R3;
            }
            if (ShSwitchView.this.R3) {
                ShSwitchView.this.x.setFloatValues(ShSwitchView.this.Q3, 1.0f);
                ShSwitchView.this.x.start();
                ShSwitchView.this.f12043c.setFloatValues(ShSwitchView.this.V3, 0.0f);
            } else {
                ShSwitchView.this.x.setFloatValues(ShSwitchView.this.Q3, 0.0f);
                ShSwitchView.this.x.start();
                ShSwitchView.this.f12043c.setFloatValues(ShSwitchView.this.V3, 1.0f);
            }
            ShSwitchView.this.f12043c.start();
            ShSwitchView.this.f12045f.setFloatValues(ShSwitchView.this.P3, 0.0f);
            ShSwitchView.this.f12045f.start();
            if (!(ShSwitchView.this.h4 == null || ShSwitchView.this.S3 == ShSwitchView.this.T3)) {
                ShSwitchView.this.h4.a(ShSwitchView.this.S3);
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(boolean z);
    }

    public ShSwitchView(Context context) {
        this(context, null);
    }

    private int a(float f2, int i, int i2) {
        int i3 = (i >> 16) & 255;
        int i4 = (i >> 8) & 255;
        int i5 = i & 255;
        return ((i3 + ((int) ((((i2 >> 16) & 255) - i3) * f2))) << 16) | ViewCompat.MEASURED_STATE_MASK | ((i4 + ((int) ((((i2 >> 8) & 255) - i4) * f2))) << 8) | (i5 + ((int) (((i2 & 255) - i5) * f2)));
    }

    private void p(float f2, float f3, float f4, float f5, float f6, Canvas canvas, Paint paint) {
        RectF rectF = this.e4;
        rectF.left = f2;
        rectF.top = f3;
        rectF.right = f4;
        rectF.bottom = f5;
        canvas.drawRoundRect(rectF, f6, f6, paint);
    }

    float getInnerContentRate() {
        return this.V3;
    }

    float getKnobExpandRate() {
        return this.P3;
    }

    float getKnobMoveRate() {
        return this.Q3;
    }

    public e getOnSwitchStateChangeListener() {
        return this.h4;
    }

    public int getTintColor() {
        return this.Y3;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        boolean z;
        super.onAttachedToWindow();
        this.g4 = true;
        if (this.f4) {
            boolean z2 = this.S3;
            this.R3 = z2;
            if (z2) {
                this.x.setFloatValues(this.Q3, 1.0f);
                this.x.start();
                this.f12043c.setFloatValues(this.V3, 0.0f);
            } else {
                this.x.setFloatValues(this.Q3, 0.0f);
                this.x.start();
                this.f12043c.setFloatValues(this.V3, 1.0f);
            }
            this.f12043c.start();
            this.f12045f.setFloatValues(this.P3, 0.0f);
            this.f12045f.start();
            e eVar = this.h4;
            if (!(eVar == null || (z = this.S3) == this.T3)) {
                eVar.a(z);
            }
            this.f4 = false;
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.g4 = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f2 = this.V3;
        float f3 = (this.W3 / 2.0f) * f2;
        float f4 = (this.X3 / 2.0f) * f2;
        RectF rectF = this.U3;
        int i = this.p3;
        rectF.left = i - f3;
        int i2 = this.H3;
        rectF.top = i2 - f4;
        rectF.right = i + f3;
        rectF.bottom = i2 + f4;
        float f5 = this.O3;
        float f6 = f5 + ((this.N3 - f5) * this.P3);
        RectF rectF2 = this.M3;
        if (rectF2.left + (rectF2.width() / 2.0f) > ((float) this.p3)) {
            RectF rectF3 = this.M3;
            rectF3.left = rectF3.right - f6;
        } else {
            RectF rectF4 = this.M3;
            rectF4.right = rectF4.left + f6;
        }
        float width = this.M3.width();
        float f7 = (this.p1 - width) - ((this.J3 + this.K3) * 2);
        float f8 = this.Q3;
        float f9 = f7 * f8;
        int a2 = a(f8, -3355444, this.Y3);
        this.a4 = a2;
        RectF rectF5 = this.M3;
        float f10 = this.J3 + this.K3 + f9;
        rectF5.left = f10;
        rectF5.right = f10 + width;
        this.b4.setColor(a2);
        this.b4.setStyle(Paint.Style.FILL);
        int i3 = this.J3;
        p(i3, i3, this.p1 - i3, this.p2 - i3, this.I3, canvas, this.b4);
        this.b4.setColor(-1052689);
        RectF rectF6 = this.U3;
        canvas.drawRoundRect(rectF6, rectF6.height() / 2.0f, this.U3.height() / 2.0f, this.b4);
        RectF rectF7 = this.M3;
        float f11 = this.I3;
        int i4 = this.K3;
        canvas.drawRoundRect(rectF7, f11 - i4, f11 - i4, this.b4);
        this.b4.setColor(-3355444);
        this.b4.setStyle(Paint.Style.STROKE);
        this.b4.setStrokeWidth(1.0f);
        RectF rectF8 = this.M3;
        float f12 = this.I3;
        int i5 = this.K3;
        canvas.drawRoundRect(rectF8, f12 - i5, f12 - i5, this.b4);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.p1 = View.MeasureSpec.getSize(i);
        int size = View.MeasureSpec.getSize(i2);
        this.p2 = size;
        int i3 = this.p1;
        if (size / i3 < 0.33333f) {
            this.p2 = (int) (i3 * 0.33333f);
            super.setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(i3, View.MeasureSpec.getMode(i)), View.MeasureSpec.makeMeasureSpec(this.p2, View.MeasureSpec.getMode(i2)));
        }
        int i4 = this.p1;
        this.p3 = i4 / 2;
        int i5 = this.p2;
        int i6 = i5 / 2;
        this.H3 = i6;
        int i7 = this.J3;
        this.I3 = i6 - i7;
        RectF rectF = this.U3;
        int i8 = this.K3;
        rectF.left = i8 + i7;
        rectF.top = i8 + i7;
        rectF.right = (i4 - i8) - i7;
        rectF.bottom = (i5 - i8) - i7;
        this.W3 = rectF.width();
        this.X3 = this.U3.height();
        RectF rectF2 = this.M3;
        int i9 = this.K3;
        int i10 = this.J3;
        rectF2.left = i9 + i10;
        rectF2.top = i9 + i10;
        int i11 = this.p2;
        rectF2.right = (i11 - i9) - i10;
        rectF2.bottom = (i11 - i9) - i10;
        this.O3 = rectF2.height();
        float f2 = this.p1 * 0.7f;
        this.N3 = f2;
        if (f2 > this.M3.width() * 1.25f) {
            this.N3 = this.M3.width() * 1.25f;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 1 || action == 3) {
            if (!this.R3) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, this.f12044d, this.V3, 1.0f);
                this.f12043c = ofFloat;
                ofFloat.setDuration(300L);
                this.f12043c.setInterpolator(new DecelerateInterpolator());
                this.f12043c.start();
            }
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, this.q, this.P3, 0.0f);
            this.f12045f = ofFloat2;
            ofFloat2.setDuration(300L);
            this.f12045f.setInterpolator(new DecelerateInterpolator());
            this.f12045f.start();
            boolean z = this.R3;
            this.S3 = z;
            e eVar = this.h4;
            if (!(eVar == null || z == this.T3)) {
                eVar.a(z);
            }
        }
        return this.z.onTouchEvent(motionEvent);
    }

    public void q(boolean z, boolean z2) {
        boolean z3;
        if (this.S3 != z) {
            if (this.g4 || !z2) {
                this.S3 = z;
                this.R3 = z;
                if (!z2) {
                    if (z) {
                        setKnobMoveRate(1.0f);
                        setInnerContentRate(0.0f);
                    } else {
                        setKnobMoveRate(0.0f);
                        setInnerContentRate(1.0f);
                    }
                    setKnobExpandRate(0.0f);
                } else {
                    if (z) {
                        this.x.setFloatValues(this.Q3, 1.0f);
                        this.x.start();
                        this.f12043c.setFloatValues(this.V3, 0.0f);
                    } else {
                        this.x.setFloatValues(this.Q3, 0.0f);
                        this.x.start();
                        this.f12043c.setFloatValues(this.V3, 1.0f);
                    }
                    this.f12043c.start();
                    this.f12045f.setFloatValues(this.P3, 0.0f);
                    this.f12045f.start();
                }
                e eVar = this.h4;
                if (eVar != null && (z3 = this.S3) != this.T3) {
                    eVar.a(z3);
                    return;
                }
                return;
            }
            this.f4 = true;
            this.S3 = z;
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            this.Y3 = this.Z3;
        } else {
            this.Y3 = a(0.5f, this.Z3, -1);
        }
    }

    void setInnerContentRate(float f2) {
        this.V3 = f2;
        invalidate();
    }

    void setKnobExpandRate(float f2) {
        this.P3 = f2;
        invalidate();
    }

    void setKnobMoveRate(float f2) {
        this.Q3 = f2;
        invalidate();
    }

    public void setOn(boolean z) {
        q(z, false);
    }

    public void setOnSwitchStateChangeListener(e eVar) {
        this.h4 = eVar;
    }

    public void setTintColor(int i) {
        this.Y3 = i;
        this.Z3 = i;
    }

    public ShSwitchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12044d = new a(Float.class, "innerBound");
        this.q = new b(Float.class, "knobExpand");
        this.y = new c(Float.class, "knobMove");
        this.p0 = new d();
        this.V3 = 1.0f;
        this.a4 = -3355444;
        this.f4 = false;
        this.g4 = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x0.ShSwitchView);
        int color = obtainStyledAttributes.getColor(x0.ShSwitchView_tintColor, -6493879);
        this.Y3 = color;
        this.Z3 = color;
        this.K3 = obtainStyledAttributes.getDimensionPixelOffset(x0.ShSwitchView_outerStrokeWidth, (int) TypedValue.applyDimension(1, 1.5f, context.getResources().getDisplayMetrics()));
        this.J3 = obtainStyledAttributes.getDimensionPixelOffset(x0.ShSwitchView_shadowSpace, (int) TypedValue.applyDimension(1, 5.0f, context.getResources().getDisplayMetrics()));
        obtainStyledAttributes.recycle();
        this.M3 = new RectF();
        this.U3 = new RectF();
        this.c4 = new RectF();
        this.e4 = new RectF();
        this.b4 = new Paint(1);
        this.d4 = new Path();
        GestureDetector gestureDetector = new GestureDetector(context, this.p0);
        this.z = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, this.f12044d, this.V3, 1.0f);
        this.f12043c = ofFloat;
        ofFloat.setDuration(300L);
        this.f12043c.setInterpolator(new DecelerateInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, this.q, this.P3, 1.0f);
        this.f12045f = ofFloat2;
        ofFloat2.setDuration(300L);
        this.f12045f.setInterpolator(new DecelerateInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, this.y, this.Q3, 1.0f);
        this.x = ofFloat3;
        ofFloat3.setDuration(300L);
        this.x.setInterpolator(new DecelerateInterpolator());
        this.L3 = context.getResources().getDrawable(r0.shadow);
    }
}
