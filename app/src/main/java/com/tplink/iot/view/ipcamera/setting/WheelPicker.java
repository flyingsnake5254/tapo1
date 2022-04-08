package com.tplink.iot.view.ipcamera.setting;

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
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import com.tplink.iot.R;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* loaded from: classes2.dex */
public class WheelPicker extends View implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    private static final String f9176c = WheelPicker.class.getSimpleName();
    private Camera H3;
    private Matrix I3;
    private Matrix J3;
    private List K3;
    private String L3;
    private int M3;
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
    private final Handler f9177d;
    private int d4;
    private int e4;

    /* renamed from: f  reason: collision with root package name */
    private Paint f9178f;
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
    private Rect p0;
    private Rect p1;
    private Rect p2;
    private Rect p3;
    private int p4;
    private Scroller q;
    private int q4;
    private boolean r4;
    private boolean s4;
    private boolean t4;
    private boolean u4;
    private boolean v4;
    private boolean w4;
    private VelocityTracker x;
    private boolean x4;
    private a y;
    private boolean y4;
    private b z;
    private boolean z4;

    /* loaded from: classes2.dex */
    public interface a {
        void a(WheelPicker wheelPicker, Object obj, int i);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(int i);

        void b(int i);

        void c(int i);
    }

    public WheelPicker(Context context) {
        this(context, null);
    }

    private void a() {
        if (this.t4 || this.S3 != -1) {
            Rect rect = this.p3;
            Rect rect2 = this.p0;
            int i = rect2.left;
            int i2 = this.j4;
            int i3 = this.a4;
            rect.set(i, i2 - i3, rect2.right, i2 + i3);
        }
    }

    private int b(int i) {
        return (int) (this.b4 - (Math.cos(Math.toRadians(i)) * this.b4));
    }

    private int c(int i) {
        int i2;
        if (Math.abs(i) <= this.a4) {
            return -i;
        }
        if (this.m4 < 0) {
            i2 = -this.Z3;
        } else {
            i2 = this.Z3;
        }
        return i2 - i;
    }

    private void d() {
        int i = this.Y3;
        if (i == 1) {
            this.k4 = this.p0.left;
        } else if (i != 2) {
            this.k4 = this.i4;
        } else {
            this.k4 = this.p0.right;
        }
        this.l4 = (int) (this.j4 - ((this.f9178f.ascent() + this.f9178f.descent()) / 2.0f));
    }

    private void e() {
        int i = this.c4;
        int i2 = this.Z3;
        int i3 = i * i2;
        this.e4 = this.v4 ? Integer.MIN_VALUE : ((-i2) * (this.K3.size() - 1)) + i3;
        if (this.v4) {
            i3 = Integer.MAX_VALUE;
        }
        this.f4 = i3;
    }

    private void f() {
        if (this.s4) {
            int i = this.U3 / 2;
            int i2 = this.j4;
            int i3 = this.a4;
            int i4 = i2 + i3;
            int i5 = i2 - i3;
            Rect rect = this.p1;
            Rect rect2 = this.p0;
            rect.set(rect2.left, i4 - i, rect2.right, i4 + i);
            Rect rect3 = this.p2;
            Rect rect4 = this.p0;
            rect3.set(rect4.left, i5 - i, rect4.right, i5 + i);
        }
    }

    private int g(int i) {
        return (int) (Math.sin(Math.toRadians(i)) * this.b4);
    }

    private void h() {
        this.Q3 = 0;
        this.P3 = 0;
        if (this.r4) {
            this.P3 = (int) this.f9178f.measureText(String.valueOf(this.K3.get(0)));
        } else if (i(this.n4)) {
            this.P3 = (int) this.f9178f.measureText(String.valueOf(this.K3.get(this.n4)));
        } else if (!TextUtils.isEmpty(this.L3)) {
            this.P3 = (int) this.f9178f.measureText(this.L3);
        } else {
            for (Object obj : this.K3) {
                String valueOf = String.valueOf(obj);
                this.P3 = Math.max(this.P3, (int) this.f9178f.measureText(valueOf));
            }
        }
        Paint.FontMetrics fontMetrics = this.f9178f.getFontMetrics();
        this.Q3 = (int) (fontMetrics.bottom - fontMetrics.top);
    }

    private boolean i(int i) {
        return i >= 0 && i < this.K3.size();
    }

    private int j(int i, int i2, int i3) {
        return i == 1073741824 ? i2 : i == Integer.MIN_VALUE ? Math.min(i3, i2) : i3;
    }

    private void k() {
        int i = this.Y3;
        if (i == 1) {
            this.f9178f.setTextAlign(Paint.Align.LEFT);
        } else if (i != 2) {
            this.f9178f.setTextAlign(Paint.Align.CENTER);
        } else {
            this.f9178f.setTextAlign(Paint.Align.RIGHT);
        }
    }

    private void l() {
        int i = this.M3;
        if (i >= 2) {
            if (i % 2 == 0) {
                this.M3 = i + 1;
            }
            int i2 = this.M3 + 2;
            this.N3 = i2;
            this.O3 = i2 / 2;
            return;
        }
        throw new ArithmeticException("Wheel's visible item count can not be less than 2!");
    }

    public int getCurrentItemPosition() {
        return this.d4;
    }

    public int getCurtainColor() {
        return this.W3;
    }

    public List getData() {
        return this.K3;
    }

    public int getIndicatorColor() {
        return this.V3;
    }

    public int getIndicatorSize() {
        return this.U3;
    }

    public int getItemAlign() {
        return this.Y3;
    }

    public int getItemSpace() {
        return this.X3;
    }

    public int getItemTextColor() {
        return this.R3;
    }

    public int getItemTextSize() {
        return this.T3;
    }

    public String getMaximumWidthText() {
        return this.L3;
    }

    public int getMaximumWidthTextPosition() {
        return this.n4;
    }

    public int getSelectedItemPosition() {
        return this.c4;
    }

    public int getSelectedItemTextColor() {
        return this.S3;
    }

    public Typeface getTypeface() {
        Paint paint = this.f9178f;
        if (paint != null) {
            return paint.getTypeface();
        }
        return null;
    }

    public int getVisibleItemCount() {
        return this.M3;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String str;
        int i;
        int i2;
        b bVar = this.z;
        if (bVar != null) {
            bVar.c(this.m4);
        }
        int i3 = (-this.m4) / this.Z3;
        int i4 = this.O3;
        int i5 = i3 - i4;
        int i6 = this.c4 + i5;
        int i7 = -i4;
        while (i6 < this.c4 + i5 + this.N3) {
            if (this.v4) {
                int size = i6 % this.K3.size();
                if (size < 0) {
                    size += this.K3.size();
                }
                str = String.valueOf(this.K3.get(size));
            } else {
                str = i(i6) ? String.valueOf(this.K3.get(i6)) : "";
            }
            this.f9178f.setColor(this.R3);
            this.f9178f.setStyle(Paint.Style.FILL);
            int i8 = this.l4;
            int i9 = this.Z3;
            int i10 = (i7 * i9) + i8 + (this.m4 % i9);
            if (this.w4) {
                int abs = i8 - Math.abs(i8 - i10);
                int i11 = this.p0.top;
                int i12 = this.l4;
                float f2 = 90.0f;
                float f3 = (-(1.0f - (((abs - i11) * 1.0f) / (i12 - i11)))) * 90.0f * (i10 > i12 ? 1 : i10 < i12 ? -1 : 0);
                if (f3 < -90.0f) {
                    f3 = -90.0f;
                }
                if (f3 <= 90.0f) {
                    f2 = f3;
                }
                i = g((int) f2);
                int i13 = this.i4;
                int i14 = this.Y3;
                if (i14 == 1) {
                    i13 = this.p0.left;
                } else if (i14 == 2) {
                    i13 = this.p0.right;
                }
                int i15 = this.j4 - i;
                this.H3.save();
                this.H3.rotateX(f2);
                this.H3.getMatrix(this.I3);
                this.H3.restore();
                float f4 = -i13;
                float f5 = -i15;
                this.I3.preTranslate(f4, f5);
                float f6 = i13;
                float f7 = i15;
                this.I3.postTranslate(f6, f7);
                this.H3.save();
                this.H3.translate(0.0f, 0.0f, b(i2));
                this.H3.getMatrix(this.J3);
                this.H3.restore();
                this.J3.preTranslate(f4, f5);
                this.J3.postTranslate(f6, f7);
            } else {
                i = 0;
            }
            if (this.u4) {
                int i16 = this.l4;
                int abs2 = (int) ((((i16 - Math.abs(i16 - i10)) * 1.0f) / this.l4) * 255.0f);
                this.f9178f.setAlpha(abs2 < 0 ? 0 : abs2);
            }
            if (this.w4) {
                i10 = this.l4 - i;
            }
            if (this.S3 != -1) {
                canvas.save();
                if (this.w4) {
                    canvas.concat(this.J3);
                }
                canvas.clipRect(this.p3, Region.Op.DIFFERENCE);
                float f8 = i10;
                canvas.drawText(str, this.k4, f8, this.f9178f);
                canvas.restore();
                this.f9178f.setColor(this.S3);
                canvas.save();
                if (this.w4) {
                    canvas.concat(this.J3);
                }
                canvas.clipRect(this.p3);
                canvas.drawText(str, this.k4, f8, this.f9178f);
                canvas.restore();
            } else {
                canvas.save();
                canvas.clipRect(this.p0);
                if (this.w4) {
                    canvas.concat(this.J3);
                }
                canvas.drawText(str, this.k4, i10, this.f9178f);
                canvas.restore();
            }
            if (this.z4) {
                canvas.save();
                canvas.clipRect(this.p0);
                this.f9178f.setColor(-1166541);
                int i17 = this.j4 + (this.Z3 * i7);
                Rect rect = this.p0;
                float f9 = i17;
                canvas.drawLine(rect.left, f9, rect.right, f9, this.f9178f);
                this.f9178f.setColor(-13421586);
                this.f9178f.setStyle(Paint.Style.STROKE);
                int i18 = i17 - this.a4;
                Rect rect2 = this.p0;
                canvas.drawRect(rect2.left, i18, rect2.right, i18 + this.Z3, this.f9178f);
                canvas.restore();
            }
            i6++;
            i7++;
        }
        if (this.t4) {
            this.f9178f.setColor(this.W3);
            this.f9178f.setStyle(Paint.Style.FILL);
            canvas.drawRect(this.p3, this.f9178f);
        }
        if (this.s4) {
            this.f9178f.setColor(this.V3);
            this.f9178f.setStyle(Paint.Style.FILL);
            canvas.drawRect(this.p1, this.f9178f);
            canvas.drawRect(this.p2, this.f9178f);
        }
        if (this.z4) {
            this.f9178f.setColor(1144254003);
            this.f9178f.setStyle(Paint.Style.FILL);
            canvas.drawRect(0.0f, 0.0f, getPaddingLeft(), getHeight(), this.f9178f);
            canvas.drawRect(0.0f, 0.0f, getWidth(), getPaddingTop(), this.f9178f);
            canvas.drawRect(getWidth() - getPaddingRight(), 0.0f, getWidth(), getHeight(), this.f9178f);
            canvas.drawRect(0.0f, getHeight() - getPaddingBottom(), getWidth(), getHeight(), this.f9178f);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i3 = this.P3;
        int i4 = this.Q3;
        int i5 = this.M3;
        int i6 = (i4 * i5) + (this.X3 * (i5 - 1));
        if (this.w4) {
            i6 = (int) ((i6 * 2) / 3.141592653589793d);
        }
        if (this.z4) {
            i3 += getPaddingLeft() + getPaddingRight();
        }
        int paddingTop = i6 + getPaddingTop() + getPaddingBottom();
        if (this.z4) {
            i3 = j(mode, size, i3);
        }
        setMeasuredDimension(i3, j(mode2, size2, paddingTop));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.p0.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        if (this.z4) {
            this.i4 = this.p0.centerX();
        }
        this.j4 = this.p0.centerY();
        d();
        this.b4 = this.p0.height() / 2;
        int height = this.p0.height() / this.M3;
        this.Z3 = height;
        this.a4 = height / 2;
        e();
        f();
        a();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
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
                Scroller scroller = this.q;
                scroller.setFinalY(scroller.getFinalY() + c(this.q.getFinalY() % this.Z3));
            }
            int y = (int) motionEvent.getY();
            this.o4 = y;
            this.p4 = y;
        } else if (action == 1) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            if (!this.x4) {
                this.x.addMovement(motionEvent);
                if (Build.VERSION.SDK_INT >= 4) {
                    this.x.computeCurrentVelocity(1000, this.h4);
                } else {
                    this.x.computeCurrentVelocity(1000);
                }
                this.y4 = false;
                int yVelocity = (int) this.x.getYVelocity();
                if (Math.abs(yVelocity) > this.g4) {
                    this.q.fling(0, this.m4, 0, yVelocity, 0, 0, this.e4, this.f4);
                    Scroller scroller2 = this.q;
                    scroller2.setFinalY(scroller2.getFinalY() + c(this.q.getFinalY() % this.Z3));
                } else {
                    Scroller scroller3 = this.q;
                    int i = this.m4;
                    scroller3.startScroll(0, i, 0, c(i % this.Z3));
                    Scroller scroller4 = this.q;
                    scroller4.setFinalY(scroller4.getFinalY() + c(this.q.getFinalY() % this.Z3));
                }
                if (!this.v4) {
                    int finalY = this.q.getFinalY();
                    int i2 = this.f4;
                    if (finalY > i2) {
                        this.q.setFinalY(i2);
                    } else {
                        int finalY2 = this.q.getFinalY();
                        int i3 = this.e4;
                        if (finalY2 < i3) {
                            this.q.setFinalY(i3);
                        }
                    }
                }
                this.f9177d.post(this);
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
        } else if (Math.abs(this.p4 - motionEvent.getY()) < this.q4) {
            this.x4 = true;
        } else {
            this.x4 = false;
            this.x.addMovement(motionEvent);
            b bVar = this.z;
            if (bVar != null) {
                bVar.a(1);
            }
            float y2 = motionEvent.getY() - this.o4;
            if (Math.abs(y2) >= 1.0f) {
                this.m4 = (int) (this.m4 + y2);
                this.o4 = (int) motionEvent.getY();
                invalidate();
            }
        }
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        List list = this.K3;
        if (list != null && list.size() != 0) {
            if (this.q.isFinished() && !this.y4) {
                int i = this.Z3;
                if (i != 0) {
                    int size = (((-this.m4) / i) + this.c4) % this.K3.size();
                    if (size < 0) {
                        size += this.K3.size();
                    }
                    if (this.z4) {
                        this.d4 = size;
                    }
                    a aVar = this.y;
                    if (aVar != null) {
                        aVar.a(this, this.K3.get(size), size);
                    }
                    b bVar = this.z;
                    if (bVar != null) {
                        bVar.b(size);
                        this.z.a(0);
                    }
                } else {
                    return;
                }
            }
            if (this.q.computeScrollOffset()) {
                b bVar2 = this.z;
                if (bVar2 != null) {
                    bVar2.a(2);
                }
                this.m4 = this.q.getCurrY();
                postInvalidate();
                this.f9177d.postDelayed(this, 16L);
            }
        }
    }

    public void setAtmospheric(boolean z) {
        this.u4 = z;
        invalidate();
    }

    public void setCurtain(boolean z) {
        this.t4 = z;
        a();
        invalidate();
    }

    public void setCurtainColor(int i) {
        this.W3 = i;
        invalidate();
    }

    public void setCurved(boolean z) {
        this.w4 = z;
        requestLayout();
        invalidate();
    }

    public void setCyclic(boolean z) {
        this.v4 = z;
        e();
        invalidate();
    }

    public void setData(List list) {
        Objects.requireNonNull(list, "WheelPicker's data can not be null!");
        this.K3 = list;
        if (this.c4 > list.size() - 1 || this.d4 > list.size() - 1) {
            int size = list.size() - 1;
            this.d4 = size;
            this.c4 = size;
        } else {
            this.c4 = this.d4;
        }
        this.m4 = 0;
        h();
        e();
        requestLayout();
        invalidate();
    }

    public void setDebug(boolean z) {
        this.z4 = z;
    }

    public void setIndicator(boolean z) {
        this.s4 = z;
        f();
        invalidate();
    }

    public void setIndicatorColor(int i) {
        this.V3 = i;
        invalidate();
    }

    public void setIndicatorSize(int i) {
        this.U3 = i;
        f();
        invalidate();
    }

    public void setItemAlign(int i) {
        this.Y3 = i;
        k();
        d();
        invalidate();
    }

    public void setItemSpace(int i) {
        this.X3 = i;
        requestLayout();
        invalidate();
    }

    public void setItemTextColor(int i) {
        this.R3 = i;
        invalidate();
    }

    public void setItemTextSize(int i) {
        this.T3 = i;
        this.f9178f.setTextSize(i);
        h();
        requestLayout();
        invalidate();
    }

    public void setMaximumWidthText(String str) {
        Objects.requireNonNull(str, "Maximum width text can not be null!");
        this.L3 = str;
        h();
        requestLayout();
        invalidate();
    }

    public void setMaximumWidthTextPosition(int i) {
        if (i(i)) {
            this.n4 = i;
            h();
            requestLayout();
            invalidate();
            return;
        }
        throw new ArrayIndexOutOfBoundsException("Maximum width text Position must in [0, " + this.K3.size() + "), but current is " + i);
    }

    public void setOnItemSelectedListener(a aVar) {
        this.y = aVar;
    }

    public void setOnWheelChangeListener(b bVar) {
        this.z = bVar;
    }

    public void setSameWidth(boolean z) {
        this.r4 = z;
        h();
        requestLayout();
        invalidate();
    }

    public void setSelectedItemPosition(int i) {
        int max = Math.max(Math.min(i, this.K3.size() - 1), 0);
        this.c4 = max;
        this.d4 = max;
        this.m4 = 0;
        e();
        requestLayout();
        invalidate();
    }

    public void setSelectedItemTextColor(int i) {
        this.S3 = i;
        a();
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        Paint paint = this.f9178f;
        if (paint != null) {
            paint.setTypeface(typeface);
        }
        h();
        requestLayout();
        invalidate();
    }

    public void setVisibleItemCount(int i) {
        this.M3 = i;
        l();
        requestLayout();
    }

    public WheelPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9177d = new Handler();
        this.g4 = 50;
        this.h4 = 8000;
        this.q4 = 8;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tplink.iot.b.WheelPicker);
        int resourceId = obtainStyledAttributes.getResourceId(5, 0);
        this.K3 = Arrays.asList(getResources().getStringArray(resourceId == 0 ? R.array.time_axis_hour_text : resourceId));
        this.T3 = obtainStyledAttributes.getDimensionPixelSize(13, getResources().getDimensionPixelSize(R.dimen.text_size_16));
        this.M3 = obtainStyledAttributes.getInt(19, 7);
        this.c4 = obtainStyledAttributes.getInt(17, 0);
        this.r4 = obtainStyledAttributes.getBoolean(16, false);
        this.n4 = obtainStyledAttributes.getInt(15, -1);
        this.L3 = obtainStyledAttributes.getString(14);
        this.S3 = obtainStyledAttributes.getColor(18, -16742145);
        this.R3 = obtainStyledAttributes.getColor(12, -1979711488);
        this.X3 = obtainStyledAttributes.getDimensionPixelSize(11, getResources().getDimensionPixelSize(R.dimen.text_size_12));
        this.v4 = obtainStyledAttributes.getBoolean(4, false);
        this.s4 = obtainStyledAttributes.getBoolean(7, false);
        this.V3 = obtainStyledAttributes.getColor(8, -16742145);
        this.U3 = obtainStyledAttributes.getDimensionPixelSize(9, getResources().getDimensionPixelSize(R.dimen.common_divide_line_height));
        this.t4 = obtainStyledAttributes.getBoolean(1, false);
        this.W3 = obtainStyledAttributes.getColor(2, -1996488705);
        this.u4 = obtainStyledAttributes.getBoolean(0, false);
        this.w4 = obtainStyledAttributes.getBoolean(3, false);
        this.Y3 = obtainStyledAttributes.getInt(10, 0);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint(69);
        this.f9178f = paint;
        paint.setTextSize(this.T3);
        this.q = new Scroller(getContext());
        if (Build.VERSION.SDK_INT >= 4) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
            this.g4 = viewConfiguration.getScaledMinimumFlingVelocity();
            this.h4 = viewConfiguration.getScaledMaximumFlingVelocity();
            this.q4 = viewConfiguration.getScaledTouchSlop();
        }
        this.p0 = new Rect();
        this.p1 = new Rect();
        this.p2 = new Rect();
        this.p3 = new Rect();
        this.H3 = new Camera();
        this.I3 = new Matrix();
        this.J3 = new Matrix();
    }
}
