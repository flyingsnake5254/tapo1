package com.tplink.libtpcontrols.tpwheelview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import b.d.w.c.a;
import com.tplink.libtpcontrols.x0;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class LoopView extends View {
    private Context H3;
    private ScheduledFuture<?> J3;
    Handler K3;
    a L3;
    private GestureDetector M3;
    private GestureDetector.SimpleOnGestureListener N3;
    int T3;
    int W3;
    int X3;
    int Y3;
    int Z3;
    int a4;
    int b4;
    int c4;

    /* renamed from: d  reason: collision with root package name */
    private final int f12451d;
    int d4;
    int e4;
    int f4;
    int g4;
    int h4;
    int i4;
    int j4;
    Paint k4;
    Paint l4;
    Paint m4;
    g p0;
    ArrayList<String> p2;
    private int p3;

    /* renamed from: c  reason: collision with root package name */
    private final String f12450c = "LoopView";

    /* renamed from: f  reason: collision with root package name */
    private final int f12452f = 3;
    private final int q = -5263441;
    private final int x = -13553359;
    private final int y = -3815995;
    final float z = 2.0f;
    int p1 = -1;
    ScheduledExecutorService I3 = Executors.newSingleThreadScheduledExecutor();
    boolean O3 = true;
    int P3 = -13553359;
    int Q3 = -3815995;
    int R3 = -5263441;
    int S3 = 5;
    float U3 = 0.0f;
    float V3 = 0.0f;
    int[] n4 = null;

    public LoopView(Context context) {
        super(context);
        int i = (int) (getResources().getDisplayMetrics().density * 28.0f);
        this.f12451d = i;
        this.T3 = i;
        g(context);
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x0.WheelView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == x0.WheelView_isLoop) {
                this.O3 = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == x0.WheelView_itemCount) {
                int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                if (resourceId > 0) {
                    this.S3 = getResources().getInteger(resourceId);
                } else {
                    int integer = obtainStyledAttributes.getInteger(index, 3);
                    this.S3 = integer;
                    if (integer <= 0) {
                        this.S3 = 3;
                    }
                }
            } else if (index == x0.WheelView_android_textSize) {
                int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                if (resourceId2 > 0) {
                    this.T3 = getResources().getDimensionPixelSize(resourceId2);
                } else {
                    this.T3 = obtainStyledAttributes.getDimensionPixelSize(index, this.f12451d);
                }
            } else if (index == x0.WheelView_lineColor) {
                int resourceId3 = obtainStyledAttributes.getResourceId(index, 0);
                if (resourceId3 > 0) {
                    this.R3 = getResources().getColor(resourceId3);
                } else {
                    this.R3 = obtainStyledAttributes.getColor(index, -5263441);
                }
            } else if (index == x0.WheelView_selectedTextColor) {
                int resourceId4 = obtainStyledAttributes.getResourceId(index, 0);
                if (resourceId4 > 0) {
                    this.P3 = getResources().getColor(resourceId4);
                } else {
                    this.P3 = obtainStyledAttributes.getColor(index, -13553359);
                }
            } else if (index == x0.WheelView_unselectedTextColor) {
                int resourceId5 = obtainStyledAttributes.getResourceId(index, 0);
                if (resourceId5 > 0) {
                    this.Q3 = getResources().getColor(resourceId5);
                } else {
                    this.Q3 = obtainStyledAttributes.getColor(index, -3815995);
                }
            }
        }
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(LoopView loopView) {
        return loopView.p3;
    }

    private int e(int i, String str) {
        Rect rect = new Rect();
        Paint paint = new Paint();
        paint.setTypeface(Typeface.MONOSPACE);
        paint.setTextSize(i);
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.width();
    }

    private void f() {
        ArrayList<String> arrayList = this.p2;
        if (arrayList != null && arrayList.size() != 0) {
            this.k4.setColor(this.Q3);
            this.k4.setAntiAlias(true);
            this.k4.setTypeface(Typeface.MONOSPACE);
            this.k4.setTextSize(this.T3);
            this.l4.setColor(this.P3);
            this.l4.setAntiAlias(true);
            this.l4.setTypeface(Typeface.MONOSPACE);
            this.l4.setTextSize(this.T3);
            this.m4.setColor(this.R3);
            this.m4.setAntiAlias(true);
            i();
            if (this.S3 > this.p2.size()) {
                this.S3 = this.p2.size();
            }
            int i = this.S3;
            if (i % 2 == 0) {
                this.S3 = i + 1;
            }
            int i2 = this.S3 + 2;
            this.S3 = i2;
            this.n4 = new int[i2];
            int i3 = (int) (this.g4 * 2.0f * (i2 - 1));
            this.h4 = i3;
            this.b4 = (int) ((i3 * 2) / 3.141592653589793d);
            this.i4 = (int) (i3 / 3.141592653589793d);
            int size = ((this.p1 % this.p2.size()) + this.p2.size()) % this.p2.size();
            this.p1 = size;
            this.a4 = size;
        }
    }

    private void g(Context context) {
        this.W3 = 0;
        this.N3 = new d(this);
        this.K3 = new f(this);
        this.H3 = context;
        this.k4 = new Paint();
        this.l4 = new Paint();
        this.m4 = new Paint();
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        GestureDetector gestureDetector = new GestureDetector(context, this.N3);
        this.M3 = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
    }

    private void i() {
        Rect rect = new Rect();
        Paint paint = new Paint();
        paint.setTextSize(this.T3);
        paint.setTypeface(Typeface.MONOSPACE);
        for (int i = 0; i < this.p2.size(); i++) {
            String str = this.p2.get(i);
            paint.getTextBounds(str, 0, str.length(), rect);
            int width = rect.width();
            if (width > this.f4) {
                this.f4 = width;
            }
            paint.getTextBounds("星期", 0, 2, rect);
            int height = rect.height();
            if (height > this.g4) {
                this.g4 = height;
            }
        }
        this.c4 = this.f4;
    }

    private void k() {
        a();
        this.J3 = this.I3.scheduleWithFixedDelay(new e(this, (int) (this.W3 % (this.g4 * 2.0f))), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void m(LoopView loopView) {
        loopView.k();
    }

    public void a() {
        ScheduledFuture<?> scheduledFuture = this.J3;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            this.J3.cancel(true);
            this.J3 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(MotionEvent motionEvent) {
        if (this.p0 != null) {
            motionEvent.getX();
            float y = motionEvent.getY();
            if (y < this.Y3 && y > this.X3) {
                this.p0.a();
            }
        }
    }

    public final int getSelectedItem() {
        return this.p3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h() {
        if (this.L3 != null) {
            postDelayed(new b(this), 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void j(MotionEvent motionEvent) {
        if (this.p0 != null) {
            motionEvent.getX();
            float y = motionEvent.getY();
            if (y < this.Y3 && y > this.X3) {
                this.p0.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void l(float f2) {
        a();
        this.J3 = this.I3.scheduleWithFixedDelay(new c(this, f2), 0L, 20, TimeUnit.MILLISECONDS);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        ArrayList<String> arrayList = this.p2;
        if (arrayList == null || arrayList.size() == 0) {
            super.onDraw(canvas);
            a.e("LoopView", "content is empty, you must set content by call function setArrayList before use this control");
            return;
        }
        String[] strArr = new String[this.S3];
        float f2 = this.g4 * 2.0f;
        int i7 = this.W3;
        int i8 = (int) (i7 % f2);
        int i9 = (int) (i7 / f2);
        this.j4 = i9;
        int size = this.p1 + (i9 % this.p2.size());
        this.a4 = size;
        if (!this.O3) {
            if (size < 0) {
                this.a4 = 0;
            }
            if (this.a4 > this.p2.size() - 1) {
                this.a4 = this.p2.size() - 1;
            }
        } else {
            if (size < 0) {
                this.a4 = this.p2.size() + this.a4;
            }
            if (this.a4 > this.p2.size() - 1) {
                this.a4 -= this.p2.size();
            }
        }
        int i10 = 0;
        while (true) {
            int i11 = this.S3;
            if (i10 >= i11) {
                break;
            }
            int i12 = this.a4 - ((i11 / 2) - i10);
            if (this.O3) {
                if (i12 < 0) {
                    i12 += this.p2.size();
                }
                if (i12 > this.p2.size() - 1) {
                    i12 -= this.p2.size();
                }
                strArr[i10] = this.p2.get(i12);
            } else if (i12 < 0) {
                strArr[i10] = "";
            } else if (i12 > this.p2.size() - 1) {
                strArr[i10] = "";
            } else {
                strArr[i10] = this.p2.get(i12);
            }
            this.n4[i10] = e(this.T3, strArr[i10]);
            i10++;
        }
        int i13 = this.X3;
        canvas.drawLine(0.0f, i13, this.e4, i13, this.m4);
        int i14 = this.Y3;
        canvas.drawLine(0.0f, i14, this.e4, i14, this.m4);
        for (int i15 = 0; i15 < this.S3; i15++) {
            canvas.save();
            double d2 = (((i15 * f2) - i8) * 3.141592653589793d) / this.h4;
            float f3 = (float) (90.0d - ((d2 / 3.141592653589793d) * 180.0d));
            if (f3 >= 90.0f || f3 <= -90.0f) {
                canvas.restore();
            } else {
                int cos = ((int) ((this.i4 - (Math.cos(d2) * this.i4)) - ((Math.sin(d2) * this.g4) / 2.0d))) + (this.Z3 - this.i4);
                canvas.translate(this.e4 / 2.0f, cos);
                float sin = (float) ((Math.sin(d2) * 0.6000000238418579d) + 0.4000000059604645d);
                canvas.scale(sin, sin);
                float f4 = (float) (this.n4[i15] / (-2.0d));
                this.k4.setAlpha((int) (Math.sin(d2) * 255.0d * 0.3d));
                int i16 = this.X3;
                if (cos > i16 || this.g4 + cos < i16) {
                    int i17 = this.Y3;
                    if (cos <= i17 && this.g4 + cos >= i17) {
                        canvas.save();
                        canvas.clipRect((-i3) / 2.0f, 0.0f, this.e4 / 2.0f, this.Y3 - cos);
                        canvas.drawText(strArr[i15], f4, this.g4, this.l4);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect((-i4) / 2.0f, this.Y3 - cos, this.e4 / 2.0f, (int) f2);
                        canvas.drawText(strArr[i15], f4, this.g4, this.k4);
                        canvas.restore();
                    } else if (cos < i16 || this.g4 + cos > i17) {
                        canvas.clipRect((-i) / 2.0f, 0.0f, this.e4 / 2.0f, (int) f2);
                        canvas.drawText(strArr[i15], f4, this.g4, this.k4);
                    } else {
                        canvas.clipRect((-i2) / 2.0f, 0.0f, this.e4 / 2.0f, (int) f2);
                        canvas.drawText(strArr[i15], f4, this.g4, this.l4);
                        this.p3 = this.p2.indexOf(strArr[i15]);
                    }
                } else {
                    canvas.save();
                    canvas.clipRect((-i5) / 2.0f, 0.0f, this.e4 / 2.0f, this.X3 - cos);
                    canvas.drawText(strArr[i15], f4, this.g4, this.k4);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect((-i6) / 2.0f, this.X3 - cos, this.e4 / 2.0f, (int) f2);
                    canvas.drawText(strArr[i15], f4, this.g4, this.l4);
                    canvas.restore();
                }
                canvas.restore();
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            this.d4 = this.b4;
        } else {
            this.d4 = Math.max(getMeasuredHeight(), this.b4);
        }
        if (View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            this.e4 = this.c4;
        } else {
            this.e4 = getMeasuredWidth();
        }
        int i3 = this.d4;
        int i4 = this.g4;
        int i5 = (int) ((i3 - (i4 * 2.0f)) / 2.0f);
        this.X3 = i5;
        int i6 = (int) ((i3 + (i4 * 2.0f)) / 2.0f);
        this.Y3 = i6;
        this.Z3 = (i5 + i6) / 2;
        setMeasuredDimension(this.e4, i3);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int size;
        int i;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.U3 = motionEvent.getRawY();
        } else if (action != 2) {
            if (!this.M3.onTouchEvent(motionEvent) && motionEvent.getAction() == 1) {
                k();
            }
            return true;
        } else {
            float rawY = motionEvent.getRawY();
            this.V3 = rawY;
            this.U3 = rawY;
            int i2 = (int) ((this.U3 - rawY) + this.W3);
            this.W3 = i2;
            if (!this.O3 && i2 < (i = ((int) (this.p1 * this.g4 * 2.0f)) * (-1))) {
                this.W3 = i;
            }
        }
        if (!this.O3 && this.W3 >= (size = (int) (((this.p2.size() - 1) - this.p1) * this.g4 * 2.0f))) {
            this.W3 = size;
        }
        invalidate();
        if (!this.M3.onTouchEvent(motionEvent) && motionEvent.getAction() == 1) {
            k();
        }
        return true;
    }

    public final void setContentList(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            a.e("LoopView", "list can not be null or empty");
            return;
        }
        this.p2 = arrayList;
        f();
        invalidate();
    }

    public final void setInitPosition(int i) {
        ArrayList<String> arrayList = this.p2;
        if (arrayList == null || arrayList.size() == 0) {
            this.p1 = i;
        } else {
            this.p1 = ((i % this.p2.size()) + this.p2.size()) % this.p2.size();
        }
    }

    public final void setListener(a aVar) {
        this.L3 = aVar;
    }

    public void setOnTabListener(g gVar) {
        this.p0 = gVar;
    }

    public LoopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i = (int) (getResources().getDisplayMetrics().density * 28.0f);
        this.f12451d = i;
        this.T3 = i;
        c(context, attributeSet);
        g(context);
    }

    public LoopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2 = (int) (getResources().getDisplayMetrics().density * 28.0f);
        this.f12451d = i2;
        this.T3 = i2;
        c(context, attributeSet);
        g(context);
    }
}
