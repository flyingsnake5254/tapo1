package com.tplink.iot.widget.colorbulb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.tplink.libtpcontrols.z0.e;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class TPCircleColorView extends View {
    private int H3;
    private int I3;
    private int J3;
    private float[] K3;
    private boolean L3;
    private boolean M3;
    private boolean N3;
    private c O3;
    private boolean P3;
    private int Q3;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f11773c;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f11774d;

    /* renamed from: f  reason: collision with root package name */
    private final Paint f11775f;
    private b p0;
    private e p1;
    private int p2;
    private int p3;
    private final Path q;
    private final Path x;
    private final PointF y;
    private Bitmap z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements g<Long> {
        a() {
        }

        /* renamed from: a */
        public void accept(Long l) throws Exception {
            int n = TPCircleColorView.this.n();
            if ((n != TPCircleColorView.this.Q3 || l.longValue() == 0) && TPCircleColorView.this.p0 != null) {
                TPCircleColorView.this.p0.w(n);
            }
            TPCircleColorView.this.Q3 = n;
            if (TPCircleColorView.this.P3 && TPCircleColorView.this.O3 != null) {
                TPCircleColorView.this.O3.dispose();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void J();

        void g(int i, boolean z);

        void w(int i);
    }

    public TPCircleColorView(Context context) {
        this(context, null);
    }

    private boolean g(PointF pointF, float f2, float f3, boolean z) {
        float min = Math.min(f2, this.p2);
        float min2 = Math.min(f3, this.p3);
        float f4 = (this.p2 / 2) - min;
        float f5 = (this.p3 / 2) - min2;
        float sqrt = (float) Math.sqrt((f4 * f4) + (f5 * f5));
        int i = this.p2;
        boolean z2 = sqrt > ((float) (i / 2));
        if (!z2 || !z) {
            if (z2) {
                min = (i / 2) - ((f4 * (i / 2)) / sqrt);
                min2 = (i / 2) - ((f5 * (i / 2)) / sqrt);
            }
            pointF.set(min, min2);
        }
        return !z2;
    }

    public static int h(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private Bitmap j(int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        int[] iArr = new int[13];
        float[] fArr = {0.0f, 1.0f, 1.0f};
        for (int i3 = 0; i3 < 13; i3++) {
            fArr[0] = (i3 * 30) % 360;
            iArr[i3] = Color.HSVToColor(fArr);
        }
        iArr[12] = iArr[0];
        float f2 = i / 2;
        float f3 = i2 / 2;
        this.f11773c.setShader(new ComposeShader(new SweepGradient(f2, f3, iArr, (float[]) null), new RadialGradient(f2, f3, f2, -1, 16777215, Shader.TileMode.CLAMP), PorterDuff.Mode.SRC_OVER));
        new Canvas(createBitmap).drawCircle(f2, f3, f2, this.f11773c);
        return createBitmap;
    }

    private void k() {
        this.N3 = true;
        b bVar = this.p0;
        if (bVar != null) {
            bVar.J();
        }
    }

    private float l(float f2, float f3) {
        double d2 = this.p2 / 2;
        return (float) (((Math.atan2((d2 - f3) / d2, (d2 - f2) / d2) * 360.0d) / 6.283185307179586d) + 180.0d);
    }

    private float m(float f2, float f3) {
        double d2 = this.p2 / 2;
        double d3 = (d2 - f2) / d2;
        double d4 = (d2 - f3) / d2;
        return (float) Math.sqrt((d3 * d3) + (d4 * d4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int n() {
        PointF pointF = this.y;
        PointF pointF2 = this.y;
        return Color.HSVToColor(new float[]{l(pointF.x, pointF.y), m(pointF2.x, pointF2.y), 1.0f}) & 16777215;
    }

    private void o(float f2, float f3) {
        double d2 = this.p2 / 2;
        double d3 = f3 * d2;
        double d4 = ((f2 - 180.0d) / 360.0d) * 3.141592653589793d * 2.0d;
        this.y.set((float) (d2 - (Math.cos(d4) * d3)), (float) (d2 - (d3 * Math.sin(d4))));
    }

    private void p() {
        c cVar = this.O3;
        if (cVar != null) {
            cVar.dispose();
        }
        this.P3 = false;
        this.Q3 = n();
        this.O3 = q.a0(0L, 500L, TimeUnit.MILLISECONDS).L0(io.reactivex.l0.a.c()).G0(new a());
    }

    private void q() {
        float[] fArr = this.K3;
        PointF pointF = this.y;
        fArr[0] = l(pointF.x, pointF.y);
        float[] fArr2 = this.K3;
        PointF pointF2 = this.y;
        fArr2[1] = m(pointF2.x, pointF2.y);
        float[] fArr3 = this.K3;
        fArr3[2] = 1.0f;
        r(Color.HSVToColor(fArr3));
    }

    private void r(int i) {
        this.f11774d.setColor(i);
        b bVar = this.p0;
        if (bVar != null) {
            bVar.g(i & 16777215, this.L3);
        }
        this.M3 = true;
        this.L3 = false;
        invalidate();
    }

    public boolean i() {
        return this.N3;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = this.z;
        int i = this.I3;
        int i2 = this.J3;
        canvas.drawBitmap(bitmap, i + i2, i + i2, (Paint) null);
        if (this.N3) {
            canvas.drawPath(this.x, this.f11774d);
            canvas.save();
            if (Build.VERSION.SDK_INT >= 18) {
                canvas.clipPath(this.x);
            }
            PointF pointF = this.y;
            canvas.translate(pointF.x, pointF.y);
            canvas.drawPath(this.q, this.f11775f);
            canvas.restore();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode == 0) {
            size = size2;
        } else if (mode2 != 0) {
            size = Math.min(size, size2);
        }
        int max = Math.max(size, this.H3);
        setMeasuredDimension(max, max);
        this.p2 = max;
        this.p3 = max;
        this.x.reset();
        Path path = this.x;
        int i3 = this.p2;
        path.addCircle(i3 / 2, this.p3 / 2, (i3 / 2) - this.I3, Path.Direction.CW);
        if (this.z == null) {
            int i4 = this.p2;
            int i5 = this.I3;
            int i6 = this.J3;
            this.z = j(i4 - ((i5 + i6) * 2), i4 - ((i5 + i6) * 2));
        }
        float[] fArr = this.K3;
        o(fArr[0], fArr[1]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000e, code lost:
        if (r0 != 3) goto L_0x003d;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            int r0 = r5.getActionMasked()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0044
            if (r0 == r2) goto L_0x0034
            r3 = 2
            if (r0 == r3) goto L_0x0011
            r3 = 3
            if (r0 == r3) goto L_0x0034
            goto L_0x003d
        L_0x0011:
            r4.L3 = r2
            r4.M3 = r1
            android.graphics.PointF r0 = r4.y
            float r3 = r5.getX()
            float r5 = r5.getY()
            r4.g(r0, r3, r5, r1)
            r4.q()
            android.view.ViewParent r5 = r4.getParent()
            r5.requestDisallowInterceptTouchEvent(r2)
            com.tplink.libtpcontrols.z0.e r5 = r4.p1
            if (r5 == 0) goto L_0x0033
            r5.a(r1)
        L_0x0033:
            return r2
        L_0x0034:
            r4.P3 = r2
            com.tplink.libtpcontrols.z0.e r0 = r4.p1
            if (r0 == 0) goto L_0x003d
            r0.a(r2)
        L_0x003d:
            r4.M3 = r1
            boolean r5 = super.onTouchEvent(r5)
            return r5
        L_0x0044:
            r4.L3 = r2
            r4.M3 = r1
            r4.P3 = r1
            r4.k()
            android.graphics.PointF r0 = r4.y
            float r3 = r5.getX()
            float r5 = r5.getY()
            boolean r5 = r4.g(r0, r3, r5, r2)
            if (r5 == 0) goto L_0x0067
            r4.q()
            android.view.ViewParent r0 = r4.getParent()
            r0.requestDisallowInterceptTouchEvent(r2)
        L_0x0067:
            com.tplink.libtpcontrols.z0.e r0 = r4.p1
            if (r0 == 0) goto L_0x006e
            r0.a(r1)
        L_0x006e:
            r4.p()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.widget.colorbulb.TPCircleColorView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setColor(int i) {
        if (i > 16777215) {
            i = 16777215;
        } else if (i < 0) {
            i = 0;
        }
        Color.colorToHSV(i | ViewCompat.MEASURED_STATE_MASK, this.K3);
        float[] fArr = this.K3;
        fArr[0] = (float) (((int) fArr[0]) * 1.0d);
        fArr[1] = (float) ((((int) (fArr[1] * 100.0f)) * 1.0d) / 100.0d);
        fArr[2] = 1.0f;
        k();
        float[] fArr2 = this.K3;
        o(fArr2[0], fArr2[1]);
        r(Color.HSVToColor(this.K3));
        if (!this.M3) {
            this.L3 = false;
        }
    }

    public void setOnColorListener(b bVar) {
        this.p0 = bVar;
    }

    public void setOnTouchCancelListener(e eVar) {
        this.p1 = eVar;
    }

    public void setSelectedStatus(boolean z) {
        if (this.N3 != z) {
            this.N3 = z;
            invalidate();
        }
    }

    public TPCircleColorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = new PointF();
        this.p0 = null;
        this.K3 = new float[]{0.0f, 0.0f, 1.0f};
        this.L3 = false;
        this.M3 = false;
        this.N3 = false;
        this.P3 = true;
        this.H3 = h(context, 200.0f);
        this.J3 = h(context, 6.0f);
        this.I3 = h(context, 3.0f);
        Paint paint = new Paint();
        this.f11773c = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f11774d = paint2;
        paint2.setColor(-1);
        paint2.setStrokeWidth(this.I3);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.f11775f = paint3;
        paint3.setColor(-1);
        paint3.setStrokeWidth(h(context, 3.0f));
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setAntiAlias(true);
        Path path = new Path();
        this.q = path;
        path.addCircle(0.0f, 0.0f, h(context, 16.0f), Path.Direction.CW);
        this.x = new Path();
    }
}
