package com.tplink.iot.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tplink.iot.R;
import com.tplink.libtpnetwork.cameranetwork.util.e;

/* loaded from: classes3.dex */
public class FlexibleLine extends View {
    private a H3;
    private int I3;
    private int J3;
    private int K3;
    private int L3;
    private int M3;
    private int N3;
    private int O3;
    private int P3;
    private int Q3;
    private double R3;
    private int S3;
    private Bitmap T3;
    private Bitmap U3;
    private Bitmap V3;
    private Paint W3;
    private Paint X3;
    private Paint Y3;

    /* renamed from: c  reason: collision with root package name */
    private int f11522c;

    /* renamed from: d  reason: collision with root package name */
    private int f11523d;

    /* renamed from: f  reason: collision with root package name */
    private int f11524f;
    private boolean p0;
    private Point p1;
    private Point p2;
    private Context p3;
    private int q;
    private int x;
    private int y;
    private boolean z;

    /* loaded from: classes3.dex */
    public interface a {
        void F(FlexibleLine flexibleLine);

        void b0(boolean z);
    }

    public FlexibleLine(Context context) {
        super(context);
        this.p3 = context;
        j();
    }

    private void a(View view, MotionEvent motionEvent) {
        int rawX = ((int) motionEvent.getRawX()) - this.f11522c;
        int rawY = ((int) motionEvent.getRawY()) - this.f11523d;
        int i = this.I3;
        if (i == 1) {
            f(rawX, rawY);
            l(this.p2, motionEvent);
        } else if (i == 2) {
            h(this, rawX, rawY);
        } else if (i == 3) {
            g(rawX, rawY);
            l(this.p1, motionEvent);
        }
        this.f11522c = (int) motionEvent.getRawX();
        this.f11523d = (int) motionEvent.getRawY();
        invalidate();
    }

    private double b(Point point, Point point2) {
        return Math.sqrt(Math.pow(point.x - point2.x, 2.0d) + Math.pow(point.y - point2.y, 2.0d));
    }

    private double d(Point point, Point point2) {
        return (Math.atan2(point2.y - point.y, point2.x - point.x) * 180.0d) / 3.141592653589793d;
    }

    private void f(int i, int i2) {
        Point point = this.p1;
        if (b(new Point(point.x + i, point.y), this.p2) >= this.K3) {
            int i3 = this.f11524f + this.p1.x + i;
            int width = ((ViewGroup) getParent()).getWidth();
            int i4 = this.S3;
            if (i3 > width - i4) {
                this.p1.x = ((((ViewGroup) getParent()).getWidth() - this.S3) - i) - this.f11524f;
            } else {
                int i5 = this.f11524f;
                Point point2 = this.p1;
                int i6 = point2.x;
                if (i5 + i6 + i < i4) {
                    point2.x = (i4 - i) - i5;
                } else {
                    point2.x = i6 + i;
                }
            }
        }
        Point point3 = this.p1;
        if (b(new Point(point3.x, point3.y + i2), this.p2) >= this.K3) {
            int i7 = this.x + this.p1.y + i2;
            int height = ((ViewGroup) getParent()).getHeight();
            int i8 = this.S3;
            if (i7 > height - i8) {
                this.p1.y = ((((ViewGroup) getParent()).getHeight() - this.S3) - i2) - this.x;
            } else {
                int i9 = this.x;
                Point point4 = this.p1;
                int i10 = point4.y;
                if (i9 + i10 + i2 < i8) {
                    point4.y = (i8 - i2) - i9;
                } else {
                    point4.y = i10 + i2;
                }
            }
        }
        int i11 = this.f11524f;
        Point point5 = this.p1;
        int i12 = this.x;
        Point point6 = this.p2;
        m(point5.x + i11, point5.y + i12, i11 + point6.x, i12 + point6.y);
    }

    private void g(int i, int i2) {
        Point point = this.p1;
        Point point2 = this.p2;
        if (b(point, new Point(point2.x + i, point2.y)) >= this.K3) {
            int i3 = this.f11524f + this.p2.x + i;
            int width = ((ViewGroup) getParent()).getWidth();
            int i4 = this.S3;
            if (i3 > width - i4) {
                this.p2.x = ((((ViewGroup) getParent()).getWidth() - this.S3) - i) - this.f11524f;
            } else {
                int i5 = this.f11524f;
                Point point3 = this.p2;
                int i6 = point3.x;
                if (i5 + i6 + i < i4) {
                    point3.x = (i4 - i) - i5;
                } else {
                    point3.x = i6 + i;
                }
            }
        }
        Point point4 = this.p1;
        Point point5 = this.p2;
        if (b(point4, new Point(point5.x, point5.y + i2)) >= this.K3) {
            int i7 = this.x + this.p2.y + i2;
            int height = ((ViewGroup) getParent()).getHeight();
            int i8 = this.S3;
            if (i7 > height - i8) {
                this.p2.y = ((((ViewGroup) getParent()).getHeight() - this.S3) - i2) - this.x;
            } else {
                int i9 = this.x;
                Point point6 = this.p2;
                int i10 = point6.y;
                if (i9 + i10 + i2 < i8) {
                    point6.y = (i8 - i2) - i9;
                } else {
                    point6.y = i10 + i2;
                }
            }
        }
        int i11 = this.f11524f;
        Point point7 = this.p1;
        int i12 = this.x;
        Point point8 = this.p2;
        m(point7.x + i11, point7.y + i12, i11 + point8.x, i12 + point8.y);
    }

    private void h(View view, int i, int i2) {
        this.f11524f = view.getLeft() + i;
        this.x = view.getTop() + i2;
        this.q = view.getRight() + i;
        this.y = view.getBottom() + i2;
        if (this.f11524f < 0) {
            this.f11524f = 0;
            this.q = view.getWidth() + 0;
        }
        if (this.q > ((ViewGroup) getParent()).getWidth()) {
            int width = ((ViewGroup) getParent()).getWidth();
            this.q = width;
            this.f11524f = width - view.getWidth();
        }
        if (this.x < 0) {
            this.x = 0;
            this.y = 0 + view.getHeight();
        }
        if (this.y > ((ViewGroup) getParent()).getHeight()) {
            int height = ((ViewGroup) getParent()).getHeight();
            this.y = height;
            this.x = height - view.getHeight();
        }
        view.layout(this.f11524f, this.x, this.q, this.y);
        invalidate();
    }

    private int i(View view, int i, int i2) {
        if (Math.abs(i - this.p1.x) <= this.S3 && Math.abs(i2 - this.p1.y) <= this.S3) {
            return 1;
        }
        if (Math.abs(i - this.p2.x) > this.S3 || Math.abs(i2 - this.p2.y) > this.S3) {
            return c(this.p1, this.p2, i, i2) <= ((double) (this.V3.getHeight() / 2)) ? 2 : 0;
        }
        return 3;
    }

    private void j() {
        setWillNotDraw(false);
        setClickable(true);
        setBackgroundColor(getResources().getColor(R.color.transparent));
        int a2 = e.a(2, getContext());
        setLayerType(1, null);
        this.T3 = BitmapFactory.decodeResource(getResources(), R.mipmap.passenger_flow_belt_editable_anchor_icon);
        this.U3 = BitmapFactory.decodeResource(getResources(), R.mipmap.passenger_flow_belt_uneditable_anchor_icon);
        this.S3 = this.T3.getWidth() / 2;
        this.J3 = 2;
        this.I3 = 0;
        setArrowBitmap(2);
        Paint paint = new Paint(4);
        this.W3 = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint(4);
        this.X3 = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint(4);
        this.Y3 = paint3;
        paint3.setShadowLayer(a2, 0.0f, 0.0f, getResources().getColor(R.color.black));
        this.Y3.setColor(getResources().getColor(R.color.white));
        this.Y3.setStrokeWidth(e.a(2, this.p3));
        this.Y3.setAntiAlias(true);
        int width = this.T3.getWidth() + this.V3.getWidth();
        this.K3 = width;
        this.L3 = width + (this.S3 * 2);
        setWidth(e.a(97, this.p3));
        this.O3 = Math.max(this.V3.getHeight(), this.T3.getHeight());
        this.P3 = e.a(4, getContext());
        this.Q3 = e.a(8, getContext());
        this.p1 = new Point();
        this.p2 = new Point();
        this.p1.set(this.S3, this.O3 / 2);
        this.p2.set(this.N3 - this.S3, this.O3 / 2);
        int i = e.c(getContext())[0];
        int i2 = e.c(getContext())[1];
        m(i / 4, i2 / 3, (i * 3) / 4, (i2 * 2) / 3);
        this.z = false;
        this.p0 = false;
    }

    private void l(Point point, MotionEvent motionEvent) {
        if (b(point, new Point((int) motionEvent.getX(), (int) motionEvent.getY())) > this.K3) {
            k(false);
        } else {
            k(true);
        }
    }

    protected double c(Point point, Point point2, int i, int i2) {
        int i3 = point2.x;
        int i4 = point.x;
        if (i3 == i4) {
            return Math.abs(i - i4);
        }
        int i5 = point2.y;
        int i6 = point.y;
        double d2 = (i5 - i6) / (i3 - i4);
        return Math.abs(((i * d2) + (i6 - (i4 * d2))) - i2) / Math.sqrt(Math.pow(d2, 2.0d) + 1.0d);
    }

    protected int e(float f2, int i) {
        int i2 = this.S3;
        return Math.min(i - i2, Math.max(i2, (int) f2));
    }

    public int getAnchorRadius() {
        return this.S3;
    }

    public int getArrowDirection() {
        return this.J3;
    }

    public int getLastBottom() {
        return this.y;
    }

    public int getLastLeft() {
        return this.f11524f;
    }

    public int getLastRight() {
        return this.q;
    }

    public int getLastTop() {
        return this.x;
    }

    public int getX1ForDevice() {
        return (int) (((this.f11524f + this.p1.x) * 10000.0f) / ((ViewGroup) getParent()).getWidth());
    }

    public int getX2ForDevice() {
        return (int) (((this.f11524f + this.p2.x) * 10000.0f) / ((ViewGroup) getParent()).getWidth());
    }

    public int getY1ForDevice() {
        return (int) (((this.x + this.p1.y) * 10000.0f) / ((ViewGroup) getParent()).getHeight());
    }

    public int getY2ForDevice() {
        return (int) (((this.x + this.p2.y) * 10000.0f) / ((ViewGroup) getParent()).getHeight());
    }

    public void k(boolean z) {
        a aVar = this.H3;
        if (aVar != null) {
            aVar.b0(z);
        }
    }

    public void m(int i, int i2, int i3, int i4) {
        int i5 = this.S3;
        this.f11524f = Math.min(i - i5, i3 - i5);
        int i6 = this.S3;
        this.x = Math.min(i2 - i6, i4 - i6);
        int i7 = this.S3;
        this.q = Math.max(i + i7, i7 + i3);
        int i8 = this.S3;
        this.y = Math.max(i2 + i8, i8 + i4);
        this.p1.set(i - this.f11524f, i2 - this.x);
        this.p2.set(i3 - this.f11524f, i4 - this.x);
        setWidth(this.q - this.f11524f);
        setHeight(this.y - this.x);
        layout(this.f11524f, this.x, this.q, this.y);
        o();
    }

    public void n(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i6 / 3;
        this.K3 = i7;
        this.L3 = i7 + (this.S3 * 2);
        float f2 = i5;
        float f3 = i6;
        m(e((i / 10000.0f) * f2, i5), e((i2 / 10000.0f) * f3, i6), e((i3 / 10000.0f) * f2, i5), e((i4 / 10000.0f) * f3, i6));
    }

    public void o() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int i = this.f11524f;
        layoutParams.leftMargin = i;
        int i2 = this.x;
        layoutParams.topMargin = i2;
        layoutParams.width = this.q - i;
        layoutParams.height = this.y - i2;
        setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Point point;
        int i9;
        Point point2;
        super.onDraw(canvas);
        this.M3 = (int) b(this.p1, this.p2);
        double d2 = (float) d(this.p1, this.p2);
        this.R3 = d2;
        Point point3 = this.p1;
        canvas.rotate((float) d2, point3.x, point3.y);
        if (this.p0) {
            int i10 = this.p1.x;
            float f2 = this.S3 + i10;
            float width = ((i10 + (this.M3 / 2)) - (this.V3.getWidth() / 2)) - this.P3;
            while (true) {
                if (f2 > width) {
                    break;
                }
                int i11 = this.P3;
                if (i11 + f2 <= width && this.Q3 + f2 + i11 >= width) {
                    float f3 = f2 + i11;
                    int i12 = this.p1.y;
                    canvas.drawLine(f3, i12, width, i12, this.Y3);
                    break;
                }
                int i13 = this.Q3;
                if (i13 + f2 + i11 >= width) {
                    break;
                }
                int i14 = this.p1.y;
                canvas.drawLine(f2 + i11, i14, i13 + f2 + i11, i14, this.Y3);
                f2 = f2 + this.Q3 + this.P3;
            }
            int i15 = this.p1.x;
            int i16 = this.M3;
            float f4 = (i15 + i16) - this.S3;
            float width2 = i15 + (i16 / 2) + (this.V3.getWidth() / 2) + this.P3;
            while (true) {
                if (f4 < width2) {
                    break;
                }
                int i17 = this.P3;
                if (f4 - i17 >= width2 && f4 - (this.Q3 + i17) <= width2) {
                    int i18 = this.p1.y;
                    canvas.drawLine(width2, i18, f4 - i17, i18, this.Y3);
                    break;
                }
                int i19 = this.Q3;
                if (f4 - (i19 + i17) <= width2) {
                    break;
                }
                float f5 = f4 - (i19 + i17);
                int i20 = this.p1.y;
                canvas.drawLine(f5, i20, f4 - i17, i20, this.Y3);
                f4 -= this.Q3 + this.P3;
            }
        } else {
            canvas.drawLine(this.p1.x, point.y, ((i9 + (this.M3 / 2)) - (this.V3.getWidth() / 2)) - this.P3, this.p1.y, this.Y3);
            float width3 = this.p1.x + (this.M3 / 2) + (this.V3.getWidth() / 2) + this.P3;
            int i21 = this.p1.y;
            canvas.drawLine(width3, i21, point2.x + this.M3, i21, this.Y3);
        }
        canvas.drawBitmap(this.V3, this.p1.x + ((this.M3 - bitmap.getWidth()) / 2), this.p1.y - (this.V3.getHeight() / 2), this.X3);
        boolean z = this.p0;
        Bitmap bitmap2 = z ? this.T3 : this.U3;
        if (z) {
            i2 = this.p1.x;
            i = this.S3;
        } else {
            i2 = this.p1.x;
            i = this.U3.getWidth() / 2;
        }
        float f6 = i2 - i;
        if (this.p0) {
            i4 = this.p1.y;
            i3 = this.S3;
        } else {
            i4 = this.p1.y;
            i3 = this.U3.getWidth() / 2;
        }
        canvas.drawBitmap(bitmap2, f6, i4 - i3, this.W3);
        boolean z2 = this.p0;
        Bitmap bitmap3 = z2 ? this.T3 : this.U3;
        if (z2) {
            i6 = this.p1.x + this.M3;
            i5 = this.S3;
        } else {
            i6 = this.p1.x + this.M3;
            i5 = this.U3.getWidth() / 2;
        }
        float f7 = i6 - i5;
        if (this.p0) {
            i8 = this.p1.y;
            i7 = this.S3;
        } else {
            i8 = this.p1.y;
            i7 = this.U3.getWidth() / 2;
        }
        canvas.drawBitmap(bitmap3, f7, i8 - i7, this.W3);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.N3, this.O3);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.z) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.p0 = true;
            a aVar = this.H3;
            if (aVar != null) {
                aVar.F(this);
            }
            this.f11522c = (int) motionEvent.getRawX();
            this.f11523d = (int) motionEvent.getRawY();
            this.I3 = i(this, (int) motionEvent.getX(), (int) motionEvent.getY());
        } else if (action == 1) {
            this.I3 = 0;
        } else if (action == 2) {
            a(this, motionEvent);
        }
        this.R3 = d(this.p1, this.p2);
        if (this.I3 == 0) {
            return false;
        }
        invalidate();
        o();
        return true;
    }

    public void setActive(boolean z) {
        this.p0 = z;
        invalidate();
    }

    protected void setArrowBitmap(int i) {
        if (i == 0) {
            this.V3 = BitmapFactory.decodeResource(getResources(), R.mipmap.line_crossing_up);
        } else if (i == 1) {
            this.V3 = BitmapFactory.decodeResource(getResources(), R.mipmap.line_crossing_down);
        } else if (i == 2) {
            this.V3 = BitmapFactory.decodeResource(getResources(), R.mipmap.line_crossing_up_and_down);
        }
    }

    public void setArrowDirection(int i) {
        if (i != this.J3) {
            this.J3 = i;
            setArrowBitmap(i);
            invalidate();
        }
    }

    public void setEditable(boolean z) {
        this.z = z;
        invalidate();
    }

    public void setHeight(int i) {
        this.O3 = i;
    }

    public void setOnLineSelectListener(a aVar) {
        a aVar2 = this.H3;
        if (aVar2 == null || aVar2 != aVar) {
            this.H3 = aVar;
        }
    }

    public void setWidth(int i) {
        this.N3 = Math.max(i, this.L3);
    }
}
