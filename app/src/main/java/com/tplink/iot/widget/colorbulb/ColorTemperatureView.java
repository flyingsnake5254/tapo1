package com.tplink.iot.widget.colorbulb;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.tplink.iot.Utils.s0;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class ColorTemperatureView extends View {
    private RectF H3;
    private RectF I3;
    private int J3;
    private float K3;
    private boolean L3;
    private int M3;
    private boolean N3;
    private int O3;
    private b P3;
    private c Q3;
    private boolean R3;
    int S3;

    /* renamed from: c  reason: collision with root package name */
    private int f11759c;

    /* renamed from: d  reason: collision with root package name */
    private int f11760d;

    /* renamed from: f  reason: collision with root package name */
    private int f11761f;
    private Paint p0;
    private Paint p1;
    private Paint p2;
    private LinearGradient p3;
    private int q;
    private int x;
    private int y;
    private int z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements g<Long> {
        a() {
        }

        /* renamed from: a */
        public void accept(Long l) throws Exception {
            int i = ColorTemperatureView.this.M3;
            if ((i != ColorTemperatureView.this.S3 || l.longValue() == 0) && ColorTemperatureView.this.P3 != null) {
                ColorTemperatureView.this.P3.b(i);
            }
            ColorTemperatureView colorTemperatureView = ColorTemperatureView.this;
            colorTemperatureView.S3 = i;
            if (colorTemperatureView.R3 && ColorTemperatureView.this.Q3 != null) {
                ColorTemperatureView.this.Q3.dispose();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i);

        void b(int i);

        void c();
    }

    public ColorTemperatureView(Context context) {
        this(context, null);
    }

    private float e(int i) {
        return (float) ((((i - this.f11759c) * 1.0d) * this.x) / this.f11761f);
    }

    private boolean f(float f2) {
        RectF rectF = this.H3;
        return f2 >= rectF.left && f2 <= rectF.right;
    }

    private boolean g(int i) {
        return i == 2700 || i == 4500 || i == 5500;
    }

    private void i() {
        this.N3 = true;
        b bVar = this.P3;
        if (bVar != null) {
            bVar.c();
        }
    }

    private int j(int i) {
        int i2 = this.f11759c;
        return i < i2 ? i2 : Math.min(i, this.f11760d);
    }

    private int k(float f2) {
        return (j((int) (this.f11759c + (((f2 * 1.0d) / this.x) * this.f11761f))) / 5) * 5;
    }

    private void m() {
        c cVar = this.Q3;
        if (cVar != null) {
            cVar.dispose();
        }
        this.R3 = false;
        this.S3 = this.M3;
        this.Q3 = q.a0(0L, 500L, TimeUnit.MILLISECONDS).L0(io.reactivex.l0.a.c()).G0(new a());
    }

    private void n(int i, int i2) {
        b.d.w.c.a.e("colorTemp", "currentColorTemp=" + i + ", lastMoveColorTemp=" + i2);
        if (!g(i2) && g(i)) {
            s0.D(getContext(), 100L);
        }
    }

    private void setInnerSetColorTemp(int i) {
        this.M3 = i;
        invalidate();
    }

    public int getColorTemp() {
        if (this.N3) {
            return this.M3;
        }
        return 0;
    }

    public boolean h() {
        return this.N3;
    }

    public void l(int i, int i2) {
        if (i <= i2) {
            this.f11759c = i;
            this.f11760d = i2;
            this.f11761f = i2 - i;
            if (i == i2) {
                this.f11761f = 1;
            }
            this.M3 = j(this.M3);
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.p1.setShader(this.p3);
        this.H3.set((getWidth() / 2) - (this.y / 2), 0.0f, (getWidth() / 2) + (this.y / 2), this.z);
        RectF rectF = this.H3;
        int i = this.J3;
        canvas.drawRoundRect(rectF, i, i, this.p1);
        this.p1.setXfermode(null);
        if (this.N3) {
            float e2 = e(this.M3);
            if (e2 < 24.0f) {
                e2 = 24.0f;
            } else {
                int i2 = this.x;
                if (e2 > i2 - 24) {
                    e2 = i2 - 24;
                }
            }
            RectF rectF2 = this.I3;
            int i3 = this.q;
            int i4 = this.y;
            rectF2.set(((i3 - i4) / 2) - 10, e2 - 20.0f, ((i3 + i4) / 2) + 10, e2 + 20.0f);
            canvas.drawRoundRect(this.I3, 10.0f, 10.0f, this.p2);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        if (size < net.lucode.hackware.magicindicator.g.b.a(getContext(), 74.0d)) {
            size = net.lucode.hackware.magicindicator.g.b.a(getContext(), 74.0d);
        }
        setMeasuredDimension(size, net.lucode.hackware.magicindicator.g.b.a(getContext(), 240.0d));
        this.q = getMeasuredWidth();
        this.x = getMeasuredHeight();
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0016, code lost:
        if (r2 != 3) goto L_0x0080;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            float r0 = r6.getX()
            float r1 = r6.getY()
            int r2 = r6.getAction()
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0048
            if (r2 == r4) goto L_0x0043
            r0 = 2
            if (r2 == r0) goto L_0x0019
            r0 = 3
            if (r2 == r0) goto L_0x0043
            goto L_0x0080
        L_0x0019:
            boolean r0 = r5.L3
            if (r0 == 0) goto L_0x0080
            float r6 = r5.K3
            float r1 = r1 - r6
            int r0 = (int) r1
            float r0 = (float) r0
            float r6 = r6 + r0
            int r6 = r5.k(r6)
            int r0 = r5.O3
            r5.n(r6, r0)
            r5.O3 = r6
            r5.setInnerSetColorTemp(r6)
            com.tplink.iot.widget.colorbulb.ColorTemperatureView$b r0 = r5.P3
            if (r0 == 0) goto L_0x0038
            r0.a(r6)
        L_0x0038:
            r5.invalidate()
            android.view.ViewParent r6 = r5.getParent()
            r6.requestDisallowInterceptTouchEvent(r4)
            return r4
        L_0x0043:
            r5.L3 = r3
            r5.R3 = r4
            goto L_0x0080
        L_0x0048:
            boolean r0 = r5.f(r0)
            if (r0 == 0) goto L_0x007e
            r5.K3 = r1
            r5.L3 = r4
            r5.i()
            int r6 = r5.k(r1)
            int r0 = r5.O3
            r5.n(r6, r0)
            r5.O3 = r6
            r5.setInnerSetColorTemp(r6)
            com.tplink.iot.widget.colorbulb.ColorTemperatureView$b r0 = r5.P3
            if (r0 == 0) goto L_0x006a
            r0.a(r6)
        L_0x006a:
            com.tplink.iot.widget.colorbulb.ColorTemperatureView$b r6 = r5.P3
            if (r6 == 0) goto L_0x0071
            r6.c()
        L_0x0071:
            android.view.ViewParent r6 = r5.getParent()
            r6.requestDisallowInterceptTouchEvent(r4)
            r5.R3 = r3
            r5.m()
            return r4
        L_0x007e:
            r5.R3 = r4
        L_0x0080:
            boolean r6 = super.onTouchEvent(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.widget.colorbulb.ColorTemperatureView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setColorTemp(int i) {
        this.M3 = i;
        i();
        invalidate();
    }

    public void setOnColorTemperatureListener(b bVar) {
        this.P3 = bVar;
    }

    public void setSelectedStatus(boolean z) {
        if (this.N3 != z) {
            this.N3 = z;
            invalidate();
        }
    }

    public ColorTemperatureView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColorTemperatureView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11759c = 2500;
        this.f11760d = 6500;
        this.f11761f = 4000;
        this.L3 = false;
        this.M3 = 2700;
        this.N3 = false;
        this.O3 = 2700;
        this.R3 = true;
        this.y = net.lucode.hackware.magicindicator.g.b.a(context, 60.0d);
        this.z = net.lucode.hackware.magicindicator.g.b.a(context, 240.0d);
        this.p3 = new LinearGradient(0.0f, 0.0f, 0.0f, this.z, new int[]{-15821, -657931, -9124865}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
        Paint paint = new Paint(1);
        this.p0 = paint;
        paint.setColor(-1717986919);
        this.p0.setStrokeWidth(2.0f);
        this.p0.setPathEffect(new DashPathEffect(new float[]{10.0f, 10.0f}, 0.0f));
        this.p1 = new Paint(1);
        this.H3 = new RectF();
        Paint paint2 = new Paint(1);
        this.p2 = paint2;
        paint2.setColor(Color.parseColor("#F2F2F2"));
        this.p2.setStyle(Paint.Style.STROKE);
        this.p2.setStrokeWidth(12.0f);
        this.I3 = new RectF();
        this.J3 = net.lucode.hackware.magicindicator.g.b.a(context, 10.0d);
    }
}
