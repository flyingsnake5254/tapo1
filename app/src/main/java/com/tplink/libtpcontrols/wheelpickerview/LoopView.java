package com.tplink.libtpcontrols.wheelpickerview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.github.mikephil.charting.utils.Utils;
import com.tplink.libtpcontrols.x0;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class LoopView extends View {

    /* renamed from: c  reason: collision with root package name */
    private static final int f12487c = (int) (Resources.getSystem().getDisplayMetrics().density * 15.0f);
    List<String> H3;
    int I3;
    int J3;
    int K3;
    int L3;
    int M3;
    float N3;
    boolean O3;
    int P3;
    int Q3;
    int R3;
    int S3;
    private int T3;
    int U3;
    int V3;
    int W3;
    String[] X3;
    int Y3;
    int Z3;
    int a4;
    int b4;
    private float d4;

    /* renamed from: f  reason: collision with root package name */
    private Context f12489f;
    private int g4;
    private int h4;
    private ScheduledFuture<?> p0;
    private Paint p1;
    private Paint p2;
    private Paint p3;
    Handler q;
    private GestureDetector x;
    d y;

    /* renamed from: d  reason: collision with root package name */
    private float f12488d = 1.05f;
    ScheduledExecutorService z = Executors.newSingleThreadScheduledExecutor();
    private int c4 = 0;
    long e4 = 0;
    private Rect f4 = new Rect();

    /* loaded from: classes3.dex */
    public enum ACTION {
        CLICK,
        FLING,
        DAGGLE
    }

    public LoopView(Context context) {
        super(context);
        c(context, null);
    }

    private int b(String str, Paint paint, Rect rect) {
        paint.getTextBounds(str, 0, str.length(), rect);
        int i = this.Z3;
        int i2 = this.g4;
        return (((i - i2) - ((int) (rect.width() * this.f12488d))) / 2) + i2;
    }

    private void c(Context context, AttributeSet attributeSet) {
        this.f12489f = context;
        this.q = new c(this);
        GestureDetector gestureDetector = new GestureDetector(context, new b(this));
        this.x = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x0.androidWheelView);
        this.I3 = obtainStyledAttributes.getInteger(x0.androidWheelView_awv_textsize, f12487c);
        this.I3 = (int) (Resources.getSystem().getDisplayMetrics().density * this.I3);
        this.N3 = obtainStyledAttributes.getFloat(x0.androidWheelView_awv_lineSpace, 2.0f);
        this.L3 = obtainStyledAttributes.getInteger(x0.androidWheelView_awv_centerTextColor, -13553359);
        this.K3 = obtainStyledAttributes.getInteger(x0.androidWheelView_awv_outerTextColor, -5263441);
        this.M3 = obtainStyledAttributes.getInteger(x0.androidWheelView_awv_dividerTextColor, -3815995);
        int integer = obtainStyledAttributes.getInteger(x0.androidWheelView_awv_itemsVisibleCount, 9);
        this.W3 = integer;
        if (integer % 2 == 0) {
            this.W3 = 9;
        }
        this.O3 = obtainStyledAttributes.getBoolean(x0.androidWheelView_awv_isLoop, true);
        obtainStyledAttributes.recycle();
        this.X3 = new String[this.W3];
        this.R3 = 0;
        this.S3 = -1;
        d();
    }

    private void d() {
        Paint paint = new Paint();
        this.p1 = paint;
        paint.setColor(this.K3);
        this.p1.setAntiAlias(true);
        this.p1.setTypeface(Typeface.MONOSPACE);
        this.p1.setTextSize(this.I3);
        Paint paint2 = new Paint();
        this.p2 = paint2;
        paint2.setColor(this.L3);
        this.p2.setAntiAlias(true);
        this.p2.setTextScaleX(this.f12488d);
        this.p2.setTypeface(Typeface.MONOSPACE);
        this.p2.setTextSize(this.I3);
        Paint paint3 = new Paint();
        this.p3 = paint3;
        paint3.setColor(this.M3);
        this.p3.setAntiAlias(true);
    }

    private void f() {
        if (this.H3 != null) {
            this.Z3 = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.Y3 = measuredHeight;
            if (this.Z3 != 0 && measuredHeight != 0) {
                this.g4 = getPaddingLeft();
                int paddingRight = getPaddingRight();
                this.h4 = paddingRight;
                this.Z3 -= paddingRight;
                this.p2.getTextBounds("星期", 0, 2, this.f4);
                this.J3 = this.f4.height();
                int i = this.Y3;
                int i2 = (int) ((i * 3.141592653589793d) / 2.0d);
                this.a4 = i2;
                float f2 = this.N3;
                int i3 = (int) (i2 / ((this.W3 - 1) * f2));
                this.J3 = i3;
                this.b4 = i / 2;
                this.P3 = (int) ((i - (i3 * f2)) / 2.0f);
                this.Q3 = (int) ((i + (f2 * i3)) / 2.0f);
                if (this.S3 == -1) {
                    if (this.O3) {
                        this.S3 = (this.H3.size() + 1) / 2;
                    } else {
                        this.S3 = 0;
                    }
                }
                this.U3 = this.S3;
            }
        }
    }

    public void a() {
        ScheduledFuture<?> scheduledFuture = this.p0;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            this.p0.cancel(true);
            this.p0 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e() {
        if (this.y != null) {
            postDelayed(new e(this), 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g(float f2) {
        a();
        this.p0 = this.z.scheduleWithFixedDelay(new a(this, f2), 0L, 10, TimeUnit.MILLISECONDS);
    }

    public final int getSelectedItem() {
        return this.T3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(ACTION action) {
        a();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            float f2 = this.N3 * this.J3;
            int i = (int) (((this.R3 % f2) + f2) % f2);
            this.c4 = i;
            if (i > f2 / 2.0f) {
                this.c4 = (int) (f2 - i);
            } else {
                this.c4 = -i;
            }
        }
        this.p0 = this.z.scheduleWithFixedDelay(new f(this, this.c4), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        String[] strArr4;
        String[] strArr5;
        String[] strArr6;
        List<String> list = this.H3;
        if (list != null) {
            int i = (int) (this.R3 / (this.N3 * this.J3));
            this.V3 = i;
            int size = this.S3 + (i % list.size());
            this.U3 = size;
            if (!this.O3) {
                if (size < 0) {
                    this.U3 = 0;
                }
                if (this.U3 > this.H3.size() - 1) {
                    this.U3 = this.H3.size() - 1;
                }
            } else {
                if (size < 0) {
                    this.U3 = this.H3.size() + this.U3;
                }
                if (this.U3 > this.H3.size() - 1) {
                    this.U3 -= this.H3.size();
                }
            }
            int i2 = (int) (this.R3 % (this.N3 * this.J3));
            int i3 = 0;
            while (true) {
                int i4 = this.W3;
                if (i3 >= i4) {
                    break;
                }
                int i5 = this.U3 - ((i4 / 2) - i3);
                if (this.O3) {
                    while (i5 < 0) {
                        i5 += this.H3.size();
                    }
                    while (i5 > this.H3.size() - 1) {
                        i5 -= this.H3.size();
                    }
                    this.X3[i3] = this.H3.get(i5);
                } else if (i5 < 0) {
                    this.X3[i3] = "";
                } else if (i5 > this.H3.size() - 1) {
                    this.X3[i3] = "";
                } else {
                    this.X3[i3] = this.H3.get(i5);
                }
                i3++;
            }
            float f2 = this.g4;
            int i6 = this.P3;
            canvas.drawLine(f2, i6, this.Z3, i6, this.p3);
            float f3 = this.g4;
            int i7 = this.Q3;
            canvas.drawLine(f3, i7, this.Z3, i7, this.p3);
            for (int i8 = 0; i8 < this.W3; i8++) {
                canvas.save();
                float f4 = this.J3 * this.N3;
                double d2 = (((i8 * f4) - i2) * 3.141592653589793d) / this.a4;
                if (d2 >= 3.141592653589793d || d2 <= Utils.DOUBLE_EPSILON) {
                    canvas.restore();
                } else {
                    int cos = (int) ((this.b4 - (Math.cos(d2) * this.b4)) - ((Math.sin(d2) * this.J3) / 2.0d));
                    canvas.translate(0.0f, cos);
                    canvas.scale(1.0f, (float) Math.sin(d2));
                    int i9 = this.P3;
                    if (cos > i9 || this.J3 + cos < i9) {
                        int i10 = this.Q3;
                        if (cos <= i10 && this.J3 + cos >= i10) {
                            canvas.save();
                            canvas.clipRect(0, 0, this.Z3, this.Q3 - cos);
                            canvas.drawText(this.X3[i8], b(strArr3[i8], this.p2, this.f4), this.J3, this.p2);
                            canvas.restore();
                            canvas.save();
                            canvas.clipRect(0, this.Q3 - cos, this.Z3, (int) f4);
                            canvas.drawText(this.X3[i8], b(strArr4[i8], this.p1, this.f4), this.J3, this.p1);
                            canvas.restore();
                        } else if (cos < i9 || this.J3 + cos > i10) {
                            canvas.clipRect(0, 0, this.Z3, (int) f4);
                            canvas.drawText(this.X3[i8], b(strArr[i8], this.p1, this.f4), this.J3, this.p1);
                        } else {
                            canvas.clipRect(0, 0, this.Z3, (int) f4);
                            canvas.drawText(this.X3[i8], b(strArr2[i8], this.p2, this.f4), this.J3, this.p2);
                            this.T3 = this.H3.indexOf(this.X3[i8]);
                        }
                    } else {
                        canvas.save();
                        canvas.clipRect(0, 0, this.Z3, this.P3 - cos);
                        canvas.drawText(this.X3[i8], b(strArr5[i8], this.p1, this.f4), this.J3, this.p1);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0, this.P3 - cos, this.Z3, (int) f4);
                        canvas.drawText(this.X3[i8], b(strArr6[i8], this.p2, this.f4), this.J3, this.p2);
                        canvas.restore();
                    }
                    canvas.restore();
                }
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        f();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.x.onTouchEvent(motionEvent);
        float f2 = this.N3 * this.J3;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.e4 = System.currentTimeMillis();
            a();
            this.d4 = motionEvent.getRawY();
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action != 2) {
            if (!onTouchEvent) {
                float y = motionEvent.getY();
                int i = this.b4;
                this.c4 = (int) (((((int) (((Math.acos((i - y) / i) * this.b4) + (f2 / 2.0f)) / f2)) - (this.W3 / 2)) * f2) - (((this.R3 % f2) + f2) % f2));
                if (System.currentTimeMillis() - this.e4 > 120) {
                    h(ACTION.DAGGLE);
                } else {
                    h(ACTION.CLICK);
                }
            }
            getParent().requestDisallowInterceptTouchEvent(false);
        } else {
            this.d4 = motionEvent.getRawY();
            this.R3 = (int) (this.R3 + (this.d4 - motionEvent.getRawY()));
            if (!this.O3) {
                float f3 = (-this.S3) * f2;
                float size = ((this.H3.size() - 1) - this.S3) * f2;
                int i2 = this.R3;
                if (i2 < f3) {
                    this.R3 = (int) f3;
                } else if (i2 > size) {
                    this.R3 = (int) size;
                }
            }
        }
        invalidate();
        return true;
    }

    public void setCenterTextColor(int i) {
        this.L3 = i;
        this.p2.setColor(i);
    }

    public void setCurrentPosition(int i) {
        if (i >= 0 && i < this.H3.size() && i != this.T3) {
            this.S3 = i;
            this.R3 = 0;
            this.c4 = 0;
            invalidate();
        }
    }

    public void setDividerColor(int i) {
        this.M3 = i;
        this.p3.setColor(i);
    }

    public final void setInitPosition(int i) {
        if (i < 0) {
            this.S3 = 0;
            return;
        }
        List<String> list = this.H3;
        if (list != null && list.size() > i) {
            this.S3 = i;
        }
    }

    public final void setItems(List<String> list) {
        this.H3 = list;
        f();
        invalidate();
    }

    public void setItemsVisibleCount(int i) {
        if (i % 2 != 0 && i != this.W3) {
            this.W3 = i;
            this.X3 = new String[i];
        }
    }

    public void setLineSpacingMultiplier(float f2) {
        if (f2 > 1.0f) {
            this.N3 = f2;
        }
    }

    public final void setListener(d dVar) {
        this.y = dVar;
    }

    public void setOuterTextColor(int i) {
        this.K3 = i;
        this.p1.setColor(i);
    }

    @Override // android.view.View
    public void setScaleX(float f2) {
        this.f12488d = f2;
    }

    public final void setTextSize(float f2) {
        if (f2 > 0.0f) {
            int i = (int) (this.f12489f.getResources().getDisplayMetrics().density * f2);
            this.I3 = i;
            this.p1.setTextSize(i);
            this.p2.setTextSize(this.I3);
        }
    }

    public LoopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context, attributeSet);
    }

    public LoopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(context, attributeSet);
    }
}
