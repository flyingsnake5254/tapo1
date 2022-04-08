package com.tplink.iot.widget.trv;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.util.Objects;
import kotlin.f;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: TemperatureSlider.kt */
/* loaded from: classes3.dex */
public final class TemperatureSlider extends FrameLayout {
    private int H3;
    private int I3;
    private final boolean J3;
    private a K3;
    private float L3;
    private float M3;
    private ValueAnimator N3;
    private boolean O3;

    /* renamed from: c  reason: collision with root package name */
    private final float f11857c;

    /* renamed from: d  reason: collision with root package name */
    private final float f11858d;

    /* renamed from: f  reason: collision with root package name */
    private final float f11859f;
    private final Paint p0;
    private int p1;
    private int p2;
    private final int p3;
    private final float q;
    private final f x;
    private final RectF y;
    private final Path z;

    /* compiled from: TemperatureSlider.kt */
    /* loaded from: classes3.dex */
    public interface a {
        void N0(int i, int i2);

        void y(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TemperatureSlider.kt */
    /* loaded from: classes3.dex */
    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator it) {
            TemperatureSlider temperatureSlider = TemperatureSlider.this;
            j.d(it, "it");
            Object animatedValue = it.getAnimatedValue();
            Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            temperatureSlider.M3 = ((Float) animatedValue).floatValue();
            TemperatureSlider.this.invalidate();
        }
    }

    /* compiled from: Animator.kt */
    /* loaded from: classes3.dex */
    public static final class c implements Animator.AnimatorListener {
        public c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            j.f(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            j.f(animator, "animator");
            TemperatureSlider.this.M3 = 0.0f;
            TemperatureSlider temperatureSlider = TemperatureSlider.this;
            temperatureSlider.I3 = temperatureSlider.p3;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            j.f(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            j.f(animator, "animator");
        }
    }

    /* compiled from: TemperatureSlider.kt */
    /* loaded from: classes3.dex */
    static final class d extends Lambda implements kotlin.jvm.b.a<GradientDrawable> {
        d() {
            super(0);
        }

        /* renamed from: a */
        public final GradientDrawable invoke() {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{335544320, 503316480});
            gradientDrawable.setBounds(0, 0, TemperatureSlider.this.getWidth(), TemperatureSlider.this.getHeight());
            return gradientDrawable;
        }
    }

    /* compiled from: TemperatureSlider.kt */
    /* loaded from: classes3.dex */
    static final class e implements ValueAnimator.AnimatorUpdateListener {
        e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator it) {
            TemperatureSlider temperatureSlider = TemperatureSlider.this;
            j.d(it, "it");
            Object animatedValue = it.getAnimatedValue();
            Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            temperatureSlider.M3 = ((Float) animatedValue).floatValue();
            TemperatureSlider.this.invalidate();
        }
    }

    public TemperatureSlider(Context context) {
        this(context, null, 0, 6, null);
    }

    public TemperatureSlider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ TemperatureSlider(Context context, AttributeSet attributeSet, int i, int i2, kotlin.jvm.internal.f fVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final float d() {
        int i = this.I3;
        int i2 = this.p3;
        float f2 = (i - i2) / (this.H3 - i2);
        this.M3 = f2;
        return f2;
    }

    private final float e() {
        return (1.0f - this.M3) * getHeight();
    }

    private final void f(boolean z) {
        a aVar;
        a aVar2 = this.K3;
        if (aVar2 != null) {
            aVar2.N0(this.I3, h());
        }
        if (z && (aVar = this.K3) != null) {
            aVar.y(this.I3, h());
        }
    }

    static /* synthetic */ void g(TemperatureSlider temperatureSlider, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        temperatureSlider.f(z);
    }

    private final GradientDrawable getMBgGradientDrawable() {
        return (GradientDrawable) this.x.getValue();
    }

    private final int h() {
        if (this.J3) {
            return (this.I3 + this.p1) - 1;
        }
        return this.I3 + this.p1;
    }

    private final int i(int i) {
        if (this.J3) {
            return (i - this.p1) + 1;
        }
        return i - this.p1;
    }

    private final ValueAnimator j() {
        ValueAnimator valueAnimator = this.N3;
        if (valueAnimator != null) {
            return valueAnimator;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.M3, 0.0f);
        ofFloat.addUpdateListener(new b());
        ofFloat.addListener(new c());
        ofFloat.setDuration(200L);
        this.N3 = ofFloat;
        j.d(ofFloat, "ValueAnimator.ofFloat(mS…ator = this\n            }");
        return ofFloat;
    }

    private final float k(int i) {
        Context context = getContext();
        j.d(context, "context");
        Resources resources = context.getResources();
        j.d(resources, "context.resources");
        return TypedValue.applyDimension(1, i, resources.getDisplayMetrics());
    }

    private final void l() {
        float f2;
        int i = this.I3;
        if (i == this.p3) {
            f2 = 0.0f;
        } else {
            f2 = i == this.H3 ? 1.0f : this.M3;
        }
        this.M3 = f2;
        invalidate();
        f(true);
    }

    private final void o(float f2) {
        int b2;
        float min = Math.min(Math.max(0.0f, this.M3 + f2), 1.0f);
        this.M3 = min;
        b2 = kotlin.s.c.b(min * (this.H3 - this.p3));
        this.I3 = b2;
        invalidate();
        g(this, false, 1, null);
    }

    public final int getMaxProgress() {
        return this.H3;
    }

    public final int getMaxValue() {
        return this.p2;
    }

    public final int getMinProgress() {
        return this.p3;
    }

    public final int getMinValue() {
        return this.p1;
    }

    public final int getProgress() {
        return this.I3;
    }

    public final void m(int i, boolean z) {
        if (!this.O3) {
            int i2 = this.p1;
            int i3 = this.p2;
            if (i2 <= i && i3 >= i) {
                this.I3 = i(i);
                if (z) {
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(this.M3, d());
                    ofFloat.addUpdateListener(new e());
                    ofFloat.setDuration(200L);
                    ofFloat.start();
                    return;
                }
                d();
                invalidate();
            }
        }
    }

    public final void n(boolean z) {
        if (z) {
            ValueAnimator j = j();
            j.setFloatValues(this.M3, 0.0f);
            j.start();
            return;
        }
        ValueAnimator valueAnimator = this.N3;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.M3 = 0.0f;
        this.I3 = this.p3;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        j.e(canvas, "canvas");
        super.onDraw(canvas);
        canvas.clipPath(this.z);
        getMBgGradientDrawable().draw(canvas);
        canvas.drawRect(0.0f, e(), getWidth(), getHeight(), this.p0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.y.set(0.0f, 0.0f, getWidth(), getHeight());
        this.z.reset();
        Path path = this.z;
        RectF rectF = this.y;
        float f2 = this.q;
        path.addRoundRect(rectF, f2, f2, Path.Direction.CW);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(Math.min(getMeasuredWidth(), (int) this.f11857c), Math.max((int) this.f11858d, Math.min(getMeasuredHeight(), (int) this.f11859f)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001a, code lost:
        if (r0 != 3) goto L_0x0055;
     */
    @Override // android.view.View
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            java.lang.String r0 = "event"
            kotlin.jvm.internal.j.e(r5, r0)
            boolean r0 = r4.isEnabled()
            r1 = 0
            if (r0 != 0) goto L_0x000d
            return r1
        L_0x000d:
            int r0 = r5.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L_0x0046
            if (r0 == r2) goto L_0x0036
            r3 = 2
            if (r0 == r3) goto L_0x001d
            r5 = 3
            if (r0 == r5) goto L_0x0036
            goto L_0x0055
        L_0x001d:
            r4.O3 = r2
            float r0 = r4.L3
            float r1 = r5.getY()
            float r0 = r0 - r1
            int r1 = r4.getHeight()
            float r1 = (float) r1
            float r0 = r0 / r1
            r4.o(r0)
            float r5 = r5.getY()
            r4.L3 = r5
            goto L_0x0055
        L_0x0036:
            r4.O3 = r1
            r5 = 0
            r4.L3 = r5
            r4.l()
            android.view.ViewParent r5 = r4.getParent()
            r5.requestDisallowInterceptTouchEvent(r1)
            goto L_0x0055
        L_0x0046:
            r4.O3 = r2
            float r5 = r5.getY()
            r4.L3 = r5
            android.view.ViewParent r5 = r4.getParent()
            r5.requestDisallowInterceptTouchEvent(r2)
        L_0x0055:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.widget.trv.TemperatureSlider.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p(int i, int i2) {
        if (i <= i2) {
            this.p1 = i;
            this.p2 = i2;
            this.H3 = this.J3 ? (i2 - i) + 1 : i2 - i;
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        setAlpha(z ? 1.0f : 0.6f);
    }

    public final void setOnSliderChangeListener(a aVar) {
        this.K3 = aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TemperatureSlider(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        f b2;
        j.e(context, "context");
        this.f11857c = k(150);
        this.f11858d = k(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
        this.f11859f = k(360);
        this.q = k(16);
        b2 = i.b(new d());
        this.x = b2;
        this.y = new RectF();
        this.z = new Path();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(-1);
        p pVar = p.a;
        this.p0 = paint;
        this.J3 = true;
        setWillNotDraw(false);
        p(5, 30);
    }
}
