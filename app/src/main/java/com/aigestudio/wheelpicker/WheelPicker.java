package com.aigestudio.wheelpicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import com.tplink.libtpmediastatistics.SSLClient;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class WheelPicker extends View implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    private static final String f867c = WheelPicker.class.getSimpleName();
    private String A4;
    private boolean B4;
    private Rect H3;
    private Camera I3;
    private Matrix J3;
    private Matrix K3;
    private List L3;
    private String M3;
    private int N3;
    private int O3;
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
    private int b4;
    private int c4;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f868d;
    private int d4;
    private int e4;

    /* renamed from: f  reason: collision with root package name */
    private Paint f869f;
    private int f4;
    private int g4;
    private int h4;
    private int i4;
    private int j4;
    private int k4;
    private int l4;
    private int m4;
    private int n4;
    private int o4;
    private b p0;
    private Rect p1;
    private Rect p2;
    private Rect p3;
    private int p4;
    private Scroller q;
    private int q4;
    private int r4;
    private boolean s4;
    private boolean t4;
    private boolean u4;
    private boolean v4;
    private boolean w4;
    private VelocityTracker x;
    private boolean x4;
    private boolean y;
    private boolean y4;
    private a z;
    private boolean z4;

    /* loaded from: classes.dex */
    public interface a {
        void a(WheelPicker wheelPicker, Object obj, int i);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i);

        void b(int i);

        void c(int i);
    }

    public WheelPicker(Context context) {
        this(context, null);
    }

    private void a() {
        if (this.u4 || this.T3 != -1) {
            Rect rect = this.H3;
            Rect rect2 = this.p1;
            int i = rect2.left;
            int i2 = this.k4;
            int i3 = this.b4;
            rect.set(i, i2 - i3, rect2.right, i2 + i3);
        }
    }

    private int b(int i) {
        return (int) (this.c4 - (Math.cos(Math.toRadians(i)) * this.c4));
    }

    private int c(int i) {
        int i2;
        if (Math.abs(i) <= this.b4) {
            return -i;
        }
        if (this.n4 < 0) {
            i2 = -this.a4;
        } else {
            i2 = this.a4;
        }
        return i2 - i;
    }

    private void d() {
        int i = this.Z3;
        if (i == 1) {
            this.l4 = this.p1.left;
        } else if (i != 2) {
            this.l4 = this.j4;
        } else {
            this.l4 = this.p1.right;
        }
        this.m4 = (int) (this.k4 - ((this.f869f.ascent() + this.f869f.descent()) / 2.0f));
    }

    private void e() {
        int i = this.d4;
        int i2 = this.a4;
        int i3 = i * i2;
        this.f4 = this.w4 ? Integer.MIN_VALUE : ((-i2) * (this.L3.size() - 1)) + i3;
        if (this.w4) {
            i3 = Integer.MAX_VALUE;
        }
        this.g4 = i3;
    }

    private void f() {
        if (this.t4) {
            int i = this.V3 / 2;
            int i2 = this.k4;
            int i3 = this.b4;
            int i4 = i2 + i3;
            int i5 = i2 - i3;
            Rect rect = this.p2;
            Rect rect2 = this.p1;
            rect.set(rect2.left, i4 - i, rect2.right, i4 + i);
            Rect rect3 = this.p3;
            Rect rect4 = this.p1;
            rect3.set(rect4.left, i5 - i, rect4.right, i5 + i);
        }
    }

    private int g(int i) {
        return (int) (Math.sin(Math.toRadians(i)) * this.c4);
    }

    private void h() {
        this.R3 = 0;
        this.Q3 = 0;
        if (this.s4) {
            this.Q3 = (int) this.f869f.measureText(String.valueOf(this.L3.get(0)));
        } else if (i(this.o4)) {
            this.Q3 = (int) this.f869f.measureText(String.valueOf(this.L3.get(this.o4)));
        } else if (!TextUtils.isEmpty(this.M3)) {
            this.Q3 = (int) this.f869f.measureText(this.M3);
        } else {
            for (Object obj : this.L3) {
                String valueOf = String.valueOf(obj);
                this.Q3 = Math.max(this.Q3, (int) this.f869f.measureText(valueOf));
            }
        }
        Paint.FontMetrics fontMetrics = this.f869f.getFontMetrics();
        this.R3 = (int) (fontMetrics.bottom - fontMetrics.top);
    }

    private boolean i(int i) {
        return i >= 0 && i < this.L3.size();
    }

    private int j(int i, int i2, int i3) {
        return i == 1073741824 ? i2 : i == Integer.MIN_VALUE ? Math.min(i3, i2) : i3;
    }

    private void l() {
        int i = this.Z3;
        if (i == 1) {
            this.f869f.setTextAlign(Paint.Align.LEFT);
        } else if (i != 2) {
            this.f869f.setTextAlign(Paint.Align.CENTER);
        } else {
            this.f869f.setTextAlign(Paint.Align.RIGHT);
        }
    }

    private void m() {
        int i = this.N3;
        if (i >= 2) {
            if (i % 2 == 0) {
                this.N3 = i + 1;
            }
            int i2 = this.N3 + 2;
            this.O3 = i2;
            this.P3 = i2 / 2;
            return;
        }
        throw new ArithmeticException("Wheel's visible item count can not be less than 2!");
    }

    public int getCurrentItemPosition() {
        return this.e4;
    }

    public int getCurtainColor() {
        return this.X3;
    }

    public List getData() {
        return this.L3;
    }

    public int getIndicatorColor() {
        return this.W3;
    }

    public int getIndicatorSize() {
        return this.V3;
    }

    public int getItemAlign() {
        return this.Z3;
    }

    public int getItemSpace() {
        return this.Y3;
    }

    public int getItemTextColor() {
        return this.S3;
    }

    public int getItemTextSize() {
        return this.U3;
    }

    public String getMaximumWidthText() {
        return this.M3;
    }

    public int getMaximumWidthTextPosition() {
        return this.o4;
    }

    public int getSelectedItemPosition() {
        return this.d4;
    }

    public int getSelectedItemTextColor() {
        return this.T3;
    }

    public Typeface getTypeface() {
        Paint paint = this.f869f;
        if (paint != null) {
            return paint.getTypeface();
        }
        return null;
    }

    public int getVisibleItemCount() {
        return this.N3;
    }

    public void k(int i, boolean z) {
        this.y = false;
        if (!z || !this.q.isFinished()) {
            if (!this.q.isFinished()) {
                this.q.abortAnimation();
            }
            int max = Math.max(Math.min(i, this.L3.size() - 1), 0);
            this.d4 = max;
            this.e4 = max;
            this.n4 = 0;
            e();
            requestLayout();
            invalidate();
            return;
        }
        int size = getData().size();
        int i2 = i - this.e4;
        if (i2 != 0) {
            if (this.w4 && Math.abs(i2) > size / 2) {
                if (i2 > 0) {
                    size = -size;
                }
                i2 += size;
            }
            Scroller scroller = this.q;
            scroller.startScroll(0, scroller.getCurrY(), 0, (-i2) * this.a4);
            this.f868d.post(this);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String str;
        int i;
        int i2;
        b bVar = this.p0;
        if (bVar != null) {
            bVar.c(this.n4);
        }
        if (this.L3.size() != 0) {
            int i3 = (-this.n4) / this.a4;
            int i4 = this.P3;
            int i5 = i3 - i4;
            int i6 = this.d4 + i5;
            int i7 = -i4;
            while (i6 < this.d4 + i5 + this.O3) {
                if (this.w4) {
                    int size = i6 % this.L3.size();
                    if (size < 0) {
                        size += this.L3.size();
                    }
                    str = String.valueOf(this.L3.get(size));
                } else {
                    str = i(i6) ? String.valueOf(this.L3.get(i6)) : "";
                }
                this.f869f.setColor(this.S3);
                this.f869f.setStyle(Paint.Style.FILL);
                int i8 = this.m4;
                int i9 = this.a4;
                int i10 = (i7 * i9) + i8 + (this.n4 % i9);
                if (this.x4) {
                    int abs = i8 - Math.abs(i8 - i10);
                    int i11 = this.p1.top;
                    int i12 = this.m4;
                    float f2 = 90.0f;
                    float f3 = (-(1.0f - (((abs - i11) * 1.0f) / (i12 - i11)))) * 90.0f * (i10 > i12 ? 1 : i10 < i12 ? -1 : 0);
                    if (f3 < -90.0f) {
                        f3 = -90.0f;
                    }
                    if (f3 <= 90.0f) {
                        f2 = f3;
                    }
                    i = g((int) f2);
                    int i13 = this.j4;
                    int i14 = this.Z3;
                    if (i14 == 1) {
                        i13 = this.p1.left;
                    } else if (i14 == 2) {
                        i13 = this.p1.right;
                    }
                    int i15 = this.k4 - i;
                    this.I3.save();
                    this.I3.rotateX(f2);
                    this.I3.getMatrix(this.J3);
                    this.I3.restore();
                    float f4 = -i13;
                    float f5 = -i15;
                    this.J3.preTranslate(f4, f5);
                    float f6 = i13;
                    float f7 = i15;
                    this.J3.postTranslate(f6, f7);
                    this.I3.save();
                    this.I3.translate(0.0f, 0.0f, b(i2));
                    this.I3.getMatrix(this.K3);
                    this.I3.restore();
                    this.K3.preTranslate(f4, f5);
                    this.K3.postTranslate(f6, f7);
                    this.J3.postConcat(this.K3);
                } else {
                    i = 0;
                }
                if (this.v4) {
                    int i16 = this.m4;
                    int abs2 = (int) ((((i16 - Math.abs(i16 - i10)) * 1.0f) / this.m4) * 255.0f);
                    this.f869f.setAlpha(abs2 < 0 ? 0 : abs2);
                }
                if (this.x4) {
                    i10 = this.m4 - i;
                }
                if (this.T3 != -1) {
                    canvas.save();
                    if (this.x4) {
                        canvas.concat(this.J3);
                    }
                    canvas.clipRect(this.H3, Region.Op.DIFFERENCE);
                    float f8 = i10;
                    canvas.drawText(str, this.l4, f8, this.f869f);
                    canvas.restore();
                    this.f869f.setColor(this.T3);
                    canvas.save();
                    if (this.x4) {
                        canvas.concat(this.J3);
                    }
                    canvas.clipRect(this.H3);
                    canvas.drawText(str, this.l4, f8, this.f869f);
                    canvas.restore();
                } else {
                    canvas.save();
                    canvas.clipRect(this.p1);
                    if (this.x4) {
                        canvas.concat(this.J3);
                    }
                    canvas.drawText(str, this.l4, i10, this.f869f);
                    canvas.restore();
                }
                if (this.B4) {
                    canvas.save();
                    canvas.clipRect(this.p1);
                    this.f869f.setColor(-1166541);
                    int i17 = this.k4 + (this.a4 * i7);
                    Rect rect = this.p1;
                    float f9 = i17;
                    canvas.drawLine(rect.left, f9, rect.right, f9, this.f869f);
                    this.f869f.setColor(-13421586);
                    this.f869f.setStyle(Paint.Style.STROKE);
                    int i18 = i17 - this.b4;
                    Rect rect2 = this.p1;
                    canvas.drawRect(rect2.left, i18, rect2.right, i18 + this.a4, this.f869f);
                    canvas.restore();
                }
                i6++;
                i7++;
            }
            if (this.u4) {
                this.f869f.setColor(this.X3);
                this.f869f.setStyle(Paint.Style.FILL);
                canvas.drawRect(this.H3, this.f869f);
            }
            if (this.t4) {
                this.f869f.setColor(this.W3);
                this.f869f.setStyle(Paint.Style.FILL);
                canvas.drawRect(this.p2, this.f869f);
                canvas.drawRect(this.p3, this.f869f);
            }
            if (this.B4) {
                this.f869f.setColor(1144254003);
                this.f869f.setStyle(Paint.Style.FILL);
                canvas.drawRect(0.0f, 0.0f, getPaddingLeft(), getHeight(), this.f869f);
                canvas.drawRect(0.0f, 0.0f, getWidth(), getPaddingTop(), this.f869f);
                canvas.drawRect(getWidth() - getPaddingRight(), 0.0f, getWidth(), getHeight(), this.f869f);
                canvas.drawRect(0.0f, getHeight() - getPaddingBottom(), getWidth(), getHeight(), this.f869f);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i3 = this.Q3;
        int i4 = this.R3;
        int i5 = this.N3;
        int i6 = (i4 * i5) + (this.Y3 * (i5 - 1));
        if (this.x4) {
            i6 = (int) ((i6 * 2) / 3.141592653589793d);
        }
        if (this.B4) {
            String str = f867c;
            Log.i(str, "Wheel's content size is (" + i3 + SSLClient.COLON + i6 + ")");
        }
        int paddingLeft = i3 + getPaddingLeft() + getPaddingRight();
        int paddingTop = i6 + getPaddingTop() + getPaddingBottom();
        if (this.B4) {
            String str2 = f867c;
            Log.i(str2, "Wheel's size is (" + paddingLeft + SSLClient.COLON + paddingTop + ")");
        }
        setMeasuredDimension(j(mode, size, paddingLeft), j(mode2, size2, paddingTop));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.p1.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        if (this.B4) {
            String str = f867c;
            Log.i(str, "Wheel's drawn rect size is (" + this.p1.width() + SSLClient.COLON + this.p1.height() + ") and location is (" + this.p1.left + SSLClient.COLON + this.p1.top + ")");
        }
        this.j4 = this.p1.centerX();
        this.k4 = this.p1.centerY();
        d();
        this.c4 = this.p1.height() / 2;
        int height = this.p1.height() / this.N3;
        this.a4 = height;
        this.b4 = height / 2;
        e();
        f();
        a();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.y = true;
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            VelocityTracker velocityTracker = this.x;
            if (velocityTracker == null) {
                this.x = VelocityTracker.obtain();
            } else {
                velocityTracker.clear();
            }
            this.x.addMovement(motionEvent);
            if (!this.q.isFinished()) {
                this.q.abortAnimation();
                this.z4 = true;
            }
            int y = (int) motionEvent.getY();
            this.p4 = y;
            this.q4 = y;
        } else if (action == 1) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            if (!this.y4 || this.z4) {
                this.x.addMovement(motionEvent);
                if (Build.VERSION.SDK_INT >= 4) {
                    this.x.computeCurrentVelocity(1000, this.i4);
                } else {
                    this.x.computeCurrentVelocity(1000);
                }
                this.z4 = false;
                int yVelocity = (int) this.x.getYVelocity();
                if (Math.abs(yVelocity) > this.h4) {
                    this.q.fling(0, this.n4, 0, yVelocity, 0, 0, this.f4, this.g4);
                    Scroller scroller = this.q;
                    scroller.setFinalY(scroller.getFinalY() + c(this.q.getFinalY() % this.a4));
                } else {
                    Scroller scroller2 = this.q;
                    int i = this.n4;
                    scroller2.startScroll(0, i, 0, c(i % this.a4));
                }
                if (!this.w4) {
                    int finalY = this.q.getFinalY();
                    int i2 = this.g4;
                    if (finalY > i2) {
                        this.q.setFinalY(i2);
                    } else {
                        int finalY2 = this.q.getFinalY();
                        int i3 = this.f4;
                        if (finalY2 < i3) {
                            this.q.setFinalY(i3);
                        }
                    }
                }
                this.f868d.post(this);
                VelocityTracker velocityTracker2 = this.x;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.x = null;
                }
            }
        } else if (action != 2) {
            if (action == 3) {
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                VelocityTracker velocityTracker3 = this.x;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.x = null;
                }
            }
        } else if (Math.abs(this.q4 - motionEvent.getY()) < this.r4) {
            this.y4 = true;
        } else {
            this.y4 = false;
            this.x.addMovement(motionEvent);
            b bVar = this.p0;
            if (bVar != null) {
                bVar.a(1);
            }
            float y2 = motionEvent.getY() - this.p4;
            if (Math.abs(y2) >= 1.0f) {
                this.n4 = (int) (this.n4 + y2);
                this.p4 = (int) motionEvent.getY();
                invalidate();
            }
        }
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        List list = this.L3;
        if (list != null && list.size() != 0) {
            if (this.q.isFinished() && !this.z4) {
                int i = this.a4;
                if (i != 0) {
                    int size = (((-this.n4) / i) + this.d4) % this.L3.size();
                    if (size < 0) {
                        size += this.L3.size();
                    }
                    if (this.B4) {
                        String str = f867c;
                        Log.i(str, size + SSLClient.COLON + this.L3.get(size) + SSLClient.COLON + this.n4);
                    }
                    this.e4 = size;
                    a aVar = this.z;
                    if (aVar != null && this.y) {
                        aVar.a(this, this.L3.get(size), size);
                    }
                    b bVar = this.p0;
                    if (bVar != null && this.y) {
                        bVar.b(size);
                        this.p0.a(0);
                    }
                } else {
                    return;
                }
            }
            if (this.q.computeScrollOffset()) {
                b bVar2 = this.p0;
                if (bVar2 != null) {
                    bVar2.a(2);
                }
                this.n4 = this.q.getCurrY();
                postInvalidate();
                this.f868d.postDelayed(this, 16L);
            }
        }
    }

    public void setAtmospheric(boolean z) {
        this.v4 = z;
        invalidate();
    }

    public void setCurtain(boolean z) {
        this.u4 = z;
        a();
        invalidate();
    }

    public void setCurtainColor(int i) {
        this.X3 = i;
        invalidate();
    }

    public void setCurved(boolean z) {
        this.x4 = z;
        requestLayout();
        invalidate();
    }

    public void setCyclic(boolean z) {
        this.w4 = z;
        e();
        invalidate();
    }

    public void setData(List list) {
        Objects.requireNonNull(list, "WheelPicker's data can not be null!");
        this.L3 = list;
        if (this.d4 > list.size() - 1 || this.e4 > list.size() - 1) {
            int size = list.size() - 1;
            this.e4 = size;
            this.d4 = size;
        } else {
            this.d4 = this.e4;
        }
        this.n4 = 0;
        h();
        e();
        requestLayout();
        invalidate();
    }

    public void setDebug(boolean z) {
        this.B4 = z;
    }

    public void setIndicator(boolean z) {
        this.t4 = z;
        f();
        invalidate();
    }

    public void setIndicatorColor(int i) {
        this.W3 = i;
        invalidate();
    }

    public void setIndicatorSize(int i) {
        this.V3 = i;
        f();
        invalidate();
    }

    public void setItemAlign(int i) {
        this.Z3 = i;
        l();
        d();
        invalidate();
    }

    public void setItemSpace(int i) {
        this.Y3 = i;
        requestLayout();
        invalidate();
    }

    public void setItemTextColor(int i) {
        this.S3 = i;
        invalidate();
    }

    public void setItemTextSize(int i) {
        this.U3 = i;
        this.f869f.setTextSize(i);
        h();
        requestLayout();
        invalidate();
    }

    public void setMaximumWidthText(String str) {
        Objects.requireNonNull(str, "Maximum width text can not be null!");
        this.M3 = str;
        h();
        requestLayout();
        invalidate();
    }

    public void setMaximumWidthTextPosition(int i) {
        if (i(i)) {
            this.o4 = i;
            h();
            requestLayout();
            invalidate();
            return;
        }
        throw new ArrayIndexOutOfBoundsException("Maximum width text Position must in [0, " + this.L3.size() + "), but current is " + i);
    }

    public void setOnItemSelectedListener(a aVar) {
        this.z = aVar;
    }

    public void setOnWheelChangeListener(b bVar) {
        this.p0 = bVar;
    }

    public void setSameWidth(boolean z) {
        this.s4 = z;
        h();
        requestLayout();
        invalidate();
    }

    public void setSelectedItemPosition(int i) {
        k(i, true);
    }

    public void setSelectedItemTextColor(int i) {
        this.T3 = i;
        a();
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        Paint paint = this.f869f;
        if (paint != null) {
            paint.setTypeface(typeface);
        }
        h();
        requestLayout();
        invalidate();
    }

    public void setVisibleItemCount(int i) {
        this.N3 = i;
        m();
        requestLayout();
    }

    public WheelPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f868d = new Handler();
        this.h4 = 50;
        this.i4 = 8000;
        this.r4 = 8;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.WheelPicker);
        int resourceId = obtainStyledAttributes.getResourceId(e.WheelPicker_wheel_data, 0);
        this.L3 = Arrays.asList(getResources().getStringArray(resourceId == 0 ? a.WheelArrayDefault : resourceId));
        this.U3 = obtainStyledAttributes.getDimensionPixelSize(e.WheelPicker_wheel_item_text_size, getResources().getDimensionPixelSize(b.WheelItemTextSize));
        this.N3 = obtainStyledAttributes.getInt(e.WheelPicker_wheel_visible_item_count, 7);
        this.d4 = obtainStyledAttributes.getInt(e.WheelPicker_wheel_selected_item_position, 0);
        this.s4 = obtainStyledAttributes.getBoolean(e.WheelPicker_wheel_same_width, false);
        this.o4 = obtainStyledAttributes.getInt(e.WheelPicker_wheel_maximum_width_text_position, -1);
        this.M3 = obtainStyledAttributes.getString(e.WheelPicker_wheel_maximum_width_text);
        this.T3 = obtainStyledAttributes.getColor(e.WheelPicker_wheel_selected_item_text_color, -1);
        this.S3 = obtainStyledAttributes.getColor(e.WheelPicker_wheel_item_text_color, -7829368);
        this.Y3 = obtainStyledAttributes.getDimensionPixelSize(e.WheelPicker_wheel_item_space, getResources().getDimensionPixelSize(b.WheelItemSpace));
        this.w4 = obtainStyledAttributes.getBoolean(e.WheelPicker_wheel_cyclic, false);
        this.t4 = obtainStyledAttributes.getBoolean(e.WheelPicker_wheel_indicator, false);
        this.W3 = obtainStyledAttributes.getColor(e.WheelPicker_wheel_indicator_color, -1166541);
        this.V3 = obtainStyledAttributes.getDimensionPixelSize(e.WheelPicker_wheel_indicator_size, getResources().getDimensionPixelSize(b.WheelIndicatorSize));
        this.u4 = obtainStyledAttributes.getBoolean(e.WheelPicker_wheel_curtain, false);
        this.X3 = obtainStyledAttributes.getColor(e.WheelPicker_wheel_curtain_color, -1996488705);
        this.v4 = obtainStyledAttributes.getBoolean(e.WheelPicker_wheel_atmospheric, false);
        this.x4 = obtainStyledAttributes.getBoolean(e.WheelPicker_wheel_curved, false);
        this.Z3 = obtainStyledAttributes.getInt(e.WheelPicker_wheel_item_align, 0);
        this.A4 = obtainStyledAttributes.getString(e.WheelPicker_wheel_font_path);
        obtainStyledAttributes.recycle();
        m();
        Paint paint = new Paint(69);
        this.f869f = paint;
        paint.setTextSize(this.U3);
        if (this.A4 != null) {
            setTypeface(Typeface.createFromAsset(context.getAssets(), this.A4));
        }
        l();
        h();
        this.q = new Scroller(getContext());
        if (Build.VERSION.SDK_INT >= 4) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
            this.h4 = viewConfiguration.getScaledMinimumFlingVelocity();
            this.i4 = viewConfiguration.getScaledMaximumFlingVelocity();
            this.r4 = viewConfiguration.getScaledTouchSlop();
        }
        this.p1 = new Rect();
        this.p2 = new Rect();
        this.p3 = new Rect();
        this.H3 = new Rect();
        this.I3 = new Camera();
        this.J3 = new Matrix();
        this.K3 = new Matrix();
    }
}
