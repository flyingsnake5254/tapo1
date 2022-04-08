package com.tplink.iot.view.ipcamera.widget.calendar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import com.tplink.iot.R;
import com.tplink.iot.b;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* loaded from: classes2.dex */
public class MonthDateView extends View {
    private int H3;
    private int I3;
    private int K3;
    private int L3;
    private int M3;
    private List<Integer> N3;
    private DisplayMetrics O3;
    private int P3;
    private int Q3;
    private int R3;
    private int S3;
    private int T3;
    private boolean U3;
    private boolean V3;
    private int W3;
    private int X3;
    private int Y3;
    private int Z3;
    private Calendar a4;
    private boolean b4;
    private b c4;
    private GestureDetector d4;
    private a e4;
    private int p0;
    private int p1;
    private int p2;
    private int p3;
    private Paint q;
    private int x;
    private int y;
    private int z;

    /* renamed from: c  reason: collision with root package name */
    private final String f9341c = "MonthDateView";

    /* renamed from: d  reason: collision with root package name */
    private final int f9342d = 7;

    /* renamed from: f  reason: collision with root package name */
    private final int f9343f = 6;
    private int J3 = 0;
    private boolean f4 = false;
    private boolean g4 = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements GestureDetector.OnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (motionEvent.getX() - motionEvent2.getX() > 50.0f) {
                b.d.w.c.a.i("MonthDateView", "left...");
                if (MonthDateView.this.e4 != null) {
                    MonthDateView.this.e4.a();
                }
                return true;
            }
            if (motionEvent2.getX() - motionEvent.getX() > 50.0f) {
                b.d.w.c.a.i("MonthDateView", "right...");
                if (MonthDateView.this.e4 != null) {
                    MonthDateView.this.e4.b();
                }
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return true;
        }
    }

    public MonthDateView(Context context) {
        super(context);
        f(context, null);
    }

    private int b(int i, int i2) {
        int d2 = d(this.K3, this.L3);
        int c2 = c(this.K3, this.L3, 1);
        if (c2 == 7) {
            c2 = 0;
        }
        int i3 = (((i * 7) + i2) - c2) + 1;
        if (i3 <= 0 || i3 >= d2 + 1) {
            return -1;
        }
        return i3;
    }

    public static int c(int i, int i2, int i3) {
        Calendar instance = Calendar.getInstance();
        instance.set(1, i);
        instance.set(2, i2 - 1);
        instance.set(5, i3);
        int i4 = instance.get(7);
        if (i4 == 1) {
            return 7;
        }
        return i4 - 1;
    }

    public static int d(int i, int i2) {
        Calendar instance = Calendar.getInstance();
        instance.set(1, i);
        instance.set(2, i2 - 1);
        instance.set(5, 1);
        instance.roll(5, -1);
        return instance.getActualMaximum(5);
    }

    private boolean e(int i) {
        if (!this.b4) {
            return true;
        }
        List<Integer> list = this.N3;
        return list != null && list.contains(Integer.valueOf(i));
    }

    private void f(Context context, AttributeSet attributeSet) {
        this.q = new Paint();
        this.O3 = getResources().getDisplayMetrics();
        g(context, attributeSet);
        l();
        h();
        j();
        i();
    }

    private void g(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.MonthDateView);
            this.x = obtainStyledAttributes.getColor(0, ContextCompat.getColor(context, R.color.playback_calender_day));
            this.z = obtainStyledAttributes.getColor(2, ContextCompat.getColor(context, R.color.playback_calender_invalid_day));
            this.b4 = obtainStyledAttributes.getBoolean(3, false);
            this.f4 = obtainStyledAttributes.getBoolean(1, false);
            obtainStyledAttributes.recycle();
            return;
        }
        this.x = ContextCompat.getColor(context, R.color.playback_calender_day);
        this.z = ContextCompat.getColor(context, R.color.playback_calender_invalid_day);
        this.b4 = false;
    }

    private void h() {
        Calendar calendar = this.a4;
        if (calendar != null) {
            this.X3 = calendar.get(1);
            this.Y3 = this.a4.get(2);
            this.Z3 = this.a4.get(5);
            return;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(System.currentTimeMillis());
        this.X3 = instance.get(1);
        this.Y3 = instance.get(2);
        this.Z3 = instance.get(5);
    }

    private void i() {
        this.d4 = new GestureDetector(getContext(), new a());
    }

    private void j() {
        this.p0 = getResources().getColor(R.color.pure_white);
        this.p1 = getResources().getColor(R.color.playback_calender_mark_day);
        this.p2 = getResources().getColor(R.color.playback_calender_mark_day);
        this.y = getResources().getColor(R.color.playback_calender_mark_day);
        this.P3 = 16;
        this.Q3 = 1;
        this.R3 = 1;
        this.S3 = -1;
        this.T3 = -1;
        this.M3 = 0;
        this.N3 = new ArrayList();
        this.U3 = false;
        this.V3 = false;
        this.W3 = 0;
        this.p3 = 10;
        this.H3 = 40;
        this.I3 = 40;
    }

    private void k(int i, int i2, int i3, List<Integer> list, Paint paint, Canvas canvas, boolean z, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        List<Integer> list2 = list;
        int d2 = d(i, i2);
        int c2 = c(i10, i11, 1);
        int i13 = 7;
        int i14 = c2 == 7 ? 0 : c2;
        Paint paint2 = new Paint();
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        paint2.setAntiAlias(true);
        int i15 = 0;
        while (i15 < d2) {
            StringBuilder sb = new StringBuilder();
            int i16 = i15 + 1;
            sb.append(i16);
            sb.append("");
            String sb2 = sb.toString();
            int i17 = i15 + i14;
            int i18 = i17 / 7;
            int i19 = i17 % i13;
            int i20 = this.H3;
            int i21 = this.Q3;
            int measureText = ((i21 - ((int) paint.measureText(sb2))) / 2) + i20 + (i21 * i19);
            int ascent = (int) ((this.R3 / 2) - ((paint.ascent() + paint.descent()) / 2.0f));
            int i22 = (this.R3 * i18) + ascent;
            if (p(i10, i11, i16)) {
                i5 = i22;
                paint.setColor(this.x);
            } else {
                i5 = i22;
                paint.setColor(this.z);
            }
            if (!(list2 == null || !list2.contains(Integer.valueOf(i16)) || i12 == i16)) {
                paint.setColor(this.y);
                if (this.V3) {
                    Paint paint3 = new Paint();
                    paint3.setStyle(Paint.Style.FILL_AND_STROKE);
                    paint3.setAntiAlias(true);
                    paint3.setColor(this.p2);
                    int i23 = this.H3;
                    int i24 = this.Q3;
                    int i25 = i23 + (i24 * i19) + (i24 / 2);
                    int i26 = this.R3;
                    canvas.drawCircle(i25, (i26 * i18) + ascent + ((i26 - ascent) / 2), this.p3, paint3);
                }
            }
            if (i12 == i16) {
                paint2.setColor(this.p1);
                if (i4 == 1) {
                    int i27 = this.H3 + (i19 * this.Q3);
                    int i28 = i18 * this.R3;
                    i15 = i16;
                    i14 = i14;
                    paint2 = paint2;
                    i6 = i5;
                    canvas.drawRect(i27, i28, i27 + i8, i28 + i9, paint2);
                } else {
                    i15 = i16;
                    paint2 = paint2;
                    i6 = i5;
                    i14 = i14;
                    if (i4 == 0) {
                        int min = ((Math.min(this.Q3, this.R3) / 2) - ((this.R3 - ascent) / 2)) + this.p3;
                        int i29 = this.H3;
                        int i30 = this.Q3;
                        canvas.drawCircle(i29 + (i19 * i30) + (i30 / 2), (i18 * i7) + (i7 / 2), min, paint2);
                    }
                }
                paint2.setStyle(Paint.Style.FILL);
                paint2.setTextSize(this.O3.scaledDensity * this.P3);
                paint2.setColor(this.p0);
                canvas.drawText(sb2, measureText, i6, paint2);
            } else {
                i15 = i16;
                paint2 = paint2;
                i14 = i14;
                canvas.drawText(sb2, measureText, i5, paint);
            }
            i12 = i3;
            d2 = d2;
            i13 = 7;
            i10 = i;
            i11 = i2;
            list2 = list;
        }
        Paint paint4 = new Paint();
        paint4.setStyle(Paint.Style.FILL);
        paint4.setTextSize(this.O3.scaledDensity * this.P3);
        paint4.setColor(-7829368);
        if (z) {
            int d3 = i2 == 1 ? 31 : d(i, i2 - 1);
            for (int i31 = 0; i31 < i14; i31++) {
                String str = (((i31 + d3) - i14) + 1) + "";
                int i32 = this.H3;
                int i33 = this.Q3;
                canvas.drawText(str, i32 + (i33 * i31) + ((i33 - ((int) paint4.measureText(str))) / 2), (int) ((this.R3 / 2) - ((paint.ascent() + paint.descent()) / 2.0f)), paint4);
            }
            int i34 = (42 - d2) - i14;
            int i35 = 0;
            while (i35 < i34) {
                StringBuilder sb3 = new StringBuilder();
                int i36 = i35 + 1;
                sb3.append(i36);
                sb3.append("");
                String sb4 = sb3.toString();
                int i37 = i35 + i14 + d2;
                int i38 = i37 / 7;
                int i39 = this.H3;
                int i40 = this.Q3;
                int measureText2 = i39 + ((i37 % 7) * i40) + ((i40 - ((int) paint.measureText(sb4))) / 2);
                int i41 = this.R3;
                canvas.drawText(sb4, measureText2, (i38 * i41) + ((int) ((i41 / 2) - ((paint.ascent() + paint.descent()) / 2.0f))), paint4);
                i35 = i36;
            }
        }
    }

    private void l() {
        Calendar instance = Calendar.getInstance();
        this.K3 = instance.get(1);
        this.L3 = instance.get(2) + 1;
    }

    private boolean p(int i, int i2, int i3) {
        if (this.g4) {
            return true;
        }
        Calendar instance = Calendar.getInstance();
        instance.set(i, i2 - 1, i3);
        Calendar instance2 = Calendar.getInstance();
        instance2.set(this.X3, this.Y3, this.Z3);
        return instance.getTimeInMillis() <= instance2.getTimeInMillis();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f4) {
            for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
                if (parent instanceof ViewPager) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getMonth() {
        return this.L3;
    }

    public int getYear() {
        return this.K3;
    }

    public void m() {
        this.M3 = 0;
        invalidate();
    }

    public void n(int i, int i2) {
        this.K3 = i;
        this.L3 = i2;
        this.M3 = 0;
        invalidate();
    }

    public void o(Calendar calendar) {
        this.X3 = calendar.get(1);
        this.Y3 = calendar.get(2);
        this.Z3 = calendar.get(5);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int height = getHeight();
        this.Q3 = ((getWidth() - this.H3) - this.I3) / 7;
        this.R3 = height / 6;
        this.q.setStyle(Paint.Style.FILL);
        this.q.setAntiAlias(true);
        this.q.setTextSize(this.O3.scaledDensity * this.P3);
        this.q.setColor(this.x);
        if (this.W3 == 0) {
            k(this.K3, this.L3, this.M3, this.N3, this.q, canvas, this.U3, this.J3);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        double d2;
        double d3;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            d3 = (size / 7) * 6;
            d2 = 0.8d;
        } else {
            d3 = (size / 7) * 6;
            d2 = 0.75d;
        }
        setMeasuredDimension(size, (int) (d3 * d2));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.d4.onTouchEvent(motionEvent) && motionEvent.getAction() == 1) {
            int y = ((int) motionEvent.getY()) / this.R3;
            this.S3 = y;
            int x = ((int) motionEvent.getX()) / this.Q3;
            this.T3 = x;
            if (x == 7) {
                this.T3 = 6;
            }
            this.W3 = 0;
            int b2 = b(y, this.T3);
            if (b2 != -1 && e(b2) && p(this.K3, this.L3, b2)) {
                this.M3 = b2;
                invalidate();
                b bVar = this.c4;
                if (bVar != null) {
                    bVar.g0(this.K3, this.L3 - 1, this.M3);
                }
            }
        }
        return true;
    }

    public void setDayColor(int i) {
        this.x = i;
    }

    public void setIgnoreLastDay(boolean z) {
        this.g4 = z;
    }

    public void setInterceptTouch(boolean z) {
        this.f4 = z;
    }

    public void setLastDay(Calendar calendar) {
        this.a4 = calendar;
        h();
    }

    public void setMarkedDays(List<Integer> list) {
        this.N3 = list;
        if (list != null) {
            for (Integer num : list) {
                b.d.w.c.a.e("MonthDateView MONTH_DAY", String.valueOf(num));
            }
        }
        invalidate();
    }

    public void setMonthDataFlingListener(a aVar) {
        this.e4 = aVar;
    }

    public void setMonthDateClickListener(b bVar) {
        this.c4 = bVar;
    }

    public void setOnlyMarkClick(boolean z) {
        this.b4 = z;
    }

    public void setOutOfDateTextColor(int i) {
        this.z = i;
    }

    public void setSelectedDayInfo(d dVar) {
        this.K3 = dVar.a;
        this.L3 = dVar.f9348b;
        this.M3 = dVar.f9349c;
        invalidate();
    }

    public MonthDateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        f(context, attributeSet);
    }

    public MonthDateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f(context, attributeSet);
    }
}
