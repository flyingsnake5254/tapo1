package com.tplink.iot.devices.lightstrip.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.core.view.ViewCompat;
import java.util.List;
import java.util.Objects;
import kotlin.collections.n;
import kotlin.collections.v;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: LightStripBrightnessController.kt */
/* loaded from: classes2.dex */
public final class LightStripBrightnessController extends View {
    private final PorterDuffXfermode H3;
    private boolean I3;
    private final RectF J3;
    private final Paint K3;
    private final Paint L3;
    private final RectF M3;
    private final Path N3;
    private final Paint O3;
    private final int P3;
    private final int Q3;
    private final float R3;
    private final int S3;
    private final int T3;
    private int U3;
    private boolean V3;
    private boolean W3;
    private float X3;
    private float Y3;
    private a Z3;
    private ValueAnimator a4;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f7780c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Integer> f7781d;

    /* renamed from: f  reason: collision with root package name */
    private final float f7782f;
    private final float p0;
    private final float p1;
    private final float p2;
    private final float p3;
    private final float q;
    private final float x;
    private final float y;
    private final float z;

    /* compiled from: LightStripBrightnessController.kt */
    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void b();

        void d(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LightStripBrightnessController.kt */
    /* loaded from: classes2.dex */
    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator it) {
            LightStripBrightnessController lightStripBrightnessController = LightStripBrightnessController.this;
            j.d(it, "it");
            Object animatedValue = it.getAnimatedValue();
            Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            lightStripBrightnessController.Y3 = ((Float) animatedValue).floatValue();
            LightStripBrightnessController.this.postInvalidateOnAnimation();
        }
    }

    /* compiled from: LightStripBrightnessController.kt */
    /* loaded from: classes2.dex */
    static final /* synthetic */ class c extends FunctionReferenceImpl implements p<Integer, Integer, Integer> {

        /* renamed from: c  reason: collision with root package name */
        public static final c f7784c = new c();

        c() {
            super(2, kotlin.s.a.class, "max", "max(II)I", 1);
        }

        public final int a(int i, int i2) {
            return Math.max(i, i2);
        }

        @Override // kotlin.jvm.b.p
        public /* bridge */ /* synthetic */ Integer invoke(Integer num, Integer num2) {
            return Integer.valueOf(a(num.intValue(), num2.intValue()));
        }
    }

    /* compiled from: LightStripBrightnessController.kt */
    /* loaded from: classes2.dex */
    static final /* synthetic */ class d extends FunctionReferenceImpl implements p<Integer, Integer, Integer> {

        /* renamed from: c  reason: collision with root package name */
        public static final d f7785c = new d();

        d() {
            super(2, kotlin.s.a.class, "min", "min(II)I", 1);
        }

        public final int a(int i, int i2) {
            return Math.min(i, i2);
        }

        @Override // kotlin.jvm.b.p
        public /* bridge */ /* synthetic */ Integer invoke(Integer num, Integer num2) {
            return Integer.valueOf(a(num.intValue(), num2.intValue()));
        }
    }

    public LightStripBrightnessController(Context context) {
        this(context, null, 0, 6, null);
    }

    public LightStripBrightnessController(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ LightStripBrightnessController(Context context, AttributeSet attributeSet, int i, int i2, f fVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final boolean b() {
        return (((float) getHeight()) - (this.p0 * 2.0f)) * this.Y3 >= this.p3 + (this.p2 * 2.0f);
    }

    private final float d(int i) {
        Context context = getContext();
        j.d(context, "context");
        Resources resources = context.getResources();
        j.d(resources, "context.resources");
        return TypedValue.applyDimension(1, i, resources.getDisplayMetrics());
    }

    private final int e(int i, int i2, p<? super Integer, ? super Integer, Integer> pVar) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode != Integer.MIN_VALUE) {
            return mode != 1073741824 ? i : size;
        }
        return pVar.invoke(Integer.valueOf(i), Integer.valueOf(size)).intValue();
    }

    private final void f() {
        if (this.a4 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setDuration(300L);
            valueAnimator.addUpdateListener(new b());
            kotlin.p pVar = kotlin.p.a;
            this.a4 = valueAnimator;
        }
    }

    private final void g() {
        float f2;
        int i = this.U3;
        if (i == this.S3) {
            f2 = this.R3;
        } else {
            f2 = i == this.T3 ? 1.0f : this.Y3;
        }
        this.Y3 = f2;
        invalidate();
    }

    private final void h() {
        int[] R;
        if (!this.I3) {
            this.I3 = true;
            if (this.f7781d.size() == 1) {
                this.K3.setShader(null);
                this.K3.setColor((this.f7781d.get(0).intValue() & 16777215) | ((int) 3003121664L));
            } else if (this.f7781d.size() > 1) {
                Paint paint = this.K3;
                float height = getHeight();
                R = v.R(this.f7781d);
                paint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, height, R, (float[]) null, Shader.TileMode.CLAMP));
            } else {
                this.K3.setShader(null);
                this.K3.setColor(-1);
            }
        }
    }

    private final void j(float f2) {
        float min = Math.min(Math.max(this.R3, this.Y3 + f2), 1.0f);
        this.Y3 = min;
        int i = (int) (min * this.T3);
        this.U3 = i;
        a aVar = this.Z3;
        if (aVar != null) {
            aVar.d(i);
        }
        invalidate();
    }

    private final void l(float f2, boolean z) {
        ValueAnimator valueAnimator = this.a4;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (z) {
            f();
            ValueAnimator valueAnimator2 = this.a4;
            if (valueAnimator2 != null) {
                valueAnimator2.setFloatValues(this.Y3, f2);
                valueAnimator2.start();
                return;
            }
            return;
        }
        this.Y3 = f2;
        invalidate();
    }

    public final void c(boolean z) {
        setEnabled(false);
        this.V3 = true;
        k(z);
    }

    public final int getBrightness() {
        return this.U3;
    }

    public final void i(int i, boolean z) {
        if (!this.W3) {
            int max = Math.max(this.S3, Math.min(i, this.T3));
            this.U3 = max;
            int i2 = this.S3;
            float max2 = Math.max(this.R3, Math.min((max - i2) / (this.T3 - i2), 1.0f));
            setEnabled(true);
            this.V3 = false;
            l(max2, z);
        }
    }

    public final void k(boolean z) {
        this.U3 = 0;
        l(0.0f, z);
    }

    public final void m(List<Integer> colors) {
        j.e(colors, "colors");
        this.f7781d.clear();
        this.f7781d.addAll(colors);
        this.I3 = false;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        j.e(canvas, "canvas");
        super.onDraw(canvas);
        if (!this.V3) {
            h();
            this.J3.set(0.0f, 0.0f, getWidth(), getHeight());
            RectF rectF = this.J3;
            float f2 = this.y;
            canvas.drawRoundRect(rectF, f2, f2, this.K3);
        }
        RectF rectF2 = this.J3;
        float f3 = this.p0;
        rectF2.set(f3, f3, getWidth() - this.p0, getHeight() - this.p0);
        RectF rectF3 = this.J3;
        float f4 = this.z;
        canvas.drawRoundRect(rectF3, f4, f4, this.L3);
        int saveLayer = canvas.saveLayer(null, null, 31);
        this.O3.setColor(this.P3);
        this.O3.setStrokeWidth(0.0f);
        float height = this.p0 + ((getHeight() - (this.p0 * 2.0f)) * (1.0f - this.Y3));
        canvas.clipPath(this.N3);
        canvas.drawRect(this.p0, height, getWidth() - this.p0, getHeight() - this.p0, this.O3);
        if (b()) {
            this.O3.setColor(this.Q3);
            this.O3.setStrokeWidth(this.p3);
            this.O3.setXfermode(this.H3);
            float f5 = this.p1;
            float width = (getWidth() - f5) / 2.0f;
            float f6 = height + this.p2 + (this.p3 / 2.0f);
            canvas.drawLine(width, f6, width + f5, f6, this.O3);
            this.O3.setXfermode(null);
        }
        canvas.restoreToCount(saveLayer);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        RectF rectF = this.M3;
        float f2 = this.p0;
        rectF.set(f2, f2, getWidth() - this.p0, getHeight() - this.p0);
        this.N3.reset();
        Path path = this.N3;
        RectF rectF2 = this.M3;
        float f3 = this.z;
        path.addRoundRect(rectF2, f3, f3, Path.Direction.CW);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(e((int) this.f7782f, i, d.f7785c), Math.max(Math.min(e((int) this.q, i2, c.f7784c), (int) this.x), (int) this.q));
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001a, code lost:
        if (r0 != 3) goto L_0x005e;
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
            goto L_0x005e
        L_0x001d:
            r4.W3 = r2
            float r0 = r4.X3
            float r1 = r5.getY()
            float r0 = r0 - r1
            int r1 = r4.getHeight()
            float r1 = (float) r1
            float r0 = r0 / r1
            r4.j(r0)
            float r5 = r5.getY()
            r4.X3 = r5
            goto L_0x005e
        L_0x0036:
            r4.W3 = r1
            r5 = 0
            r4.X3 = r5
            r4.g()
            com.tplink.iot.devices.lightstrip.widget.LightStripBrightnessController$a r5 = r4.Z3
            if (r5 == 0) goto L_0x005e
            r5.b()
            goto L_0x005e
        L_0x0046:
            android.view.ViewParent r0 = r4.getParent()
            r0.requestDisallowInterceptTouchEvent(r2)
            r4.V3 = r1
            r4.W3 = r2
            float r5 = r5.getY()
            r4.X3 = r5
            com.tplink.iot.devices.lightstrip.widget.LightStripBrightnessController$a r5 = r4.Z3
            if (r5 == 0) goto L_0x005e
            r5.a()
        L_0x005e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.devices.lightstrip.widget.LightStripBrightnessController.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void setOnBrightnessChangeListener(a listener) {
        j.e(listener, "listener");
        this.Z3 = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LightStripBrightnessController(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        List<Integer> h;
        j.e(context, "context");
        this.f7780c = new int[]{(int) 4294960006L, (int) 4294945232L, (int) 4290550772L, (int) 4284477183L};
        h = n.h(-3355444);
        this.f7781d = h;
        this.f7782f = d(150);
        this.q = d(240);
        this.x = d(360);
        this.y = d(24);
        this.z = d(18);
        this.p0 = d(10);
        this.p1 = d(28);
        this.p2 = d(4);
        float d2 = d(4);
        this.p3 = d2;
        this.H3 = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        this.J3 = new RectF();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor((int) 4294945485L);
        kotlin.p pVar = kotlin.p.a;
        this.K3 = paint;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(335544320);
        this.L3 = paint2;
        this.M3 = new RectF();
        this.N3 = new Path();
        Paint paint3 = new Paint();
        paint3.setAntiAlias(true);
        paint3.setStyle(Paint.Style.FILL_AND_STROKE);
        paint3.setStrokeWidth(d2);
        paint3.setStrokeCap(Paint.Cap.ROUND);
        paint3.setStrokeJoin(Paint.Join.ROUND);
        this.O3 = paint3;
        this.P3 = -1;
        this.Q3 = ViewCompat.MEASURED_STATE_MASK;
        this.R3 = 0.01f;
        this.S3 = 1;
        this.T3 = 100;
        this.U3 = 1;
        this.Y3 = 0.5f;
    }
}
