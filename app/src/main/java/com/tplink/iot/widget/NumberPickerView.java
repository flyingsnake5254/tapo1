package com.tplink.iot.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ScrollerCompat;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.LoadInfoBean;
import java.util.Objects;

/* loaded from: classes3.dex */
public class NumberPickerView extends View {
    private Handler A4;
    private f B4;
    private d C4;
    private c D4;
    private e E4;
    private int G4;
    private int H4;
    private int I4;
    private int J4;
    private int O4;
    private int P4;
    private int Q4;
    private float R4;
    private float S4;
    private float T4;
    private String a4;
    private String b4;
    private String c4;
    private String d4;
    private ScrollerCompat q4;
    private VelocityTracker r4;
    private String[] v4;
    private CharSequence[] w4;
    private CharSequence[] x4;
    private HandlerThread y4;
    private Handler z4;

    /* renamed from: c  reason: collision with root package name */
    private int f11574c = -1717986919;

    /* renamed from: d  reason: collision with root package name */
    private int f11575d = -14891265;

    /* renamed from: f  reason: collision with root package name */
    private int f11576f = -14891265;
    private int q = 0;
    private int x = 0;
    private int y = 0;
    private int z = 0;
    private int p0 = 0;
    private int p1 = 0;
    private int p2 = 0;
    private int p3 = 0;
    private int H3 = 0;
    private int I3 = 16777215;
    private int J3 = 2;
    private int K3 = 0;
    private int L3 = 0;
    private int M3 = 3;
    private int N3 = 0;
    private int O3 = 0;
    private int P3 = -1;
    private int Q3 = -1;
    private int R3 = 0;
    private int S3 = 0;
    private int T3 = 0;
    private int U3 = 0;
    private int V3 = 0;
    private int W3 = 0;
    private int X3 = 0;
    private int Y3 = 150;
    private int Z3 = 8;
    private float e4 = 1.0f;
    private float f4 = 0.0f;
    private float g4 = 0.0f;
    private float h4 = 0.0f;
    private boolean i4 = true;
    private boolean j4 = true;
    private boolean k4 = false;
    private boolean l4 = false;
    private boolean m4 = true;
    private boolean n4 = false;
    private boolean o4 = false;
    private boolean p4 = true;
    private Paint s4 = new Paint();
    private TextPaint t4 = new TextPaint();
    private Paint u4 = new Paint();
    private int F4 = 0;
    private float K4 = 0.0f;
    private float L4 = 0.0f;
    private float M4 = 0.0f;
    private boolean N4 = false;
    private int U4 = 0;
    private int V4 = 0;
    private int W4 = 0;
    private int X4 = 0;
    private int Y4 = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i;
            int i2 = message.what;
            if (i2 == 1) {
                int i3 = 0;
                if (!NumberPickerView.this.q4.isFinished()) {
                    if (NumberPickerView.this.F4 == 0) {
                        NumberPickerView.this.Q(1);
                    }
                    NumberPickerView.this.z4.sendMessageDelayed(NumberPickerView.this.D(1, 0, 0, message.obj), 32L);
                    return;
                }
                if (NumberPickerView.this.V4 != 0) {
                    if (NumberPickerView.this.F4 == 0) {
                        NumberPickerView.this.Q(1);
                    }
                    if (NumberPickerView.this.V4 < (-NumberPickerView.this.Q4) / 2) {
                        i3 = (int) (((NumberPickerView.this.Q4 + NumberPickerView.this.V4) * 300.0f) / NumberPickerView.this.Q4);
                        NumberPickerView.this.q4.startScroll(0, NumberPickerView.this.W4, 0, NumberPickerView.this.V4 + NumberPickerView.this.Q4, i3 * 3);
                        NumberPickerView numberPickerView = NumberPickerView.this;
                        i = numberPickerView.G(numberPickerView.W4 + NumberPickerView.this.Q4 + NumberPickerView.this.V4);
                    } else {
                        i3 = (int) (((-NumberPickerView.this.V4) * 300.0f) / NumberPickerView.this.Q4);
                        NumberPickerView.this.q4.startScroll(0, NumberPickerView.this.W4, 0, NumberPickerView.this.V4, i3 * 3);
                        NumberPickerView numberPickerView2 = NumberPickerView.this;
                        i = numberPickerView2.G(numberPickerView2.W4 + NumberPickerView.this.V4);
                    }
                    NumberPickerView.this.postInvalidate();
                } else {
                    NumberPickerView.this.Q(0);
                    NumberPickerView numberPickerView3 = NumberPickerView.this;
                    i = numberPickerView3.G(numberPickerView3.W4);
                }
                NumberPickerView numberPickerView4 = NumberPickerView.this;
                Message D = numberPickerView4.D(2, numberPickerView4.X3, i, message.obj);
                if (NumberPickerView.this.p4) {
                    NumberPickerView.this.A4.sendMessageDelayed(D, i3 * 2);
                } else {
                    NumberPickerView.this.z4.sendMessageDelayed(D, i3 * 2);
                }
            } else if (i2 == 2) {
                NumberPickerView.this.U(message.arg1, message.arg2, message.obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends Handler {
        b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 2) {
                NumberPickerView.this.U(message.arg1, message.arg2, message.obj);
            } else if (i == 3) {
                NumberPickerView.this.requestLayout();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(NumberPickerView numberPickerView, int i);
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(NumberPickerView numberPickerView, int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(NumberPickerView numberPickerView, int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a(NumberPickerView numberPickerView, int i, int i2, String[] strArr);
    }

    public NumberPickerView(Context context) {
        super(context);
        I(context);
    }

    private int A(int i, int i2, boolean z) {
        if (i2 <= 0) {
            return 0;
        }
        if (!z) {
            return i;
        }
        int i3 = i % i2;
        return i3 < 0 ? i3 + i2 : i3;
    }

    private int B(CharSequence[] charSequenceArr, Paint paint) {
        if (charSequenceArr == null) {
            return 0;
        }
        int i = 0;
        for (CharSequence charSequence : charSequenceArr) {
            if (charSequence != null) {
                i = Math.max(F(charSequence, paint), i);
            }
        }
        return i;
    }

    private Message C(int i) {
        return D(i, 0, 0, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Message D(int i, int i2, int i3, Object obj) {
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.arg1 = i2;
        obtain.arg2 = i3;
        obtain.obj = obj;
        return obtain;
    }

    private float E(Paint.FontMetrics fontMetrics) {
        if (fontMetrics == null) {
            return 0.0f;
        }
        return Math.abs(fontMetrics.top + fontMetrics.bottom) / 2.0f;
    }

    private int F(CharSequence charSequence, Paint paint) {
        if (!TextUtils.isEmpty(charSequence)) {
            return (int) (paint.measureText(charSequence.toString()) + 0.5f);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int G(int i) {
        int i2 = this.Q4;
        boolean z = false;
        if (i2 == 0) {
            return 0;
        }
        int i3 = (i / i2) + (this.M3 / 2);
        int oneRecycleSize = getOneRecycleSize();
        if (this.j4 && this.m4) {
            z = true;
        }
        int A = A(i3, oneRecycleSize, z);
        if (A >= 0 && A < getOneRecycleSize()) {
            return A + this.P3;
        }
        throw new IllegalArgumentException("getWillPickIndexByGlobalY illegal index : " + A + " getOneRecycleSize() : " + getOneRecycleSize() + " mWrapSelectorWheel : " + this.j4);
    }

    private void H() {
        if (this.v4 == null) {
            this.v4 = r0;
            String[] strArr = {"0"};
        }
    }

    private void I(Context context) {
        this.q4 = ScrollerCompat.create(context);
        this.Y3 = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
        this.Z3 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        if (this.q == 0) {
            this.q = c0(context, 20.0f);
        }
        if (this.x == 0) {
            this.x = c0(context, 22.0f);
        }
        if (this.y == 0) {
            this.y = c0(context, 14.0f);
        }
        if (this.p1 == 0) {
            this.p1 = s(context, 8.0f);
        }
        if (this.p2 == 0) {
            this.p2 = s(context, 8.0f);
        }
        this.s4.setColor(this.I3);
        this.s4.setAntiAlias(true);
        this.s4.setStyle(Paint.Style.STROKE);
        this.s4.setStrokeWidth(this.J3);
        this.t4.setColor(this.f11574c);
        this.t4.setAntiAlias(true);
        this.t4.setTextAlign(Paint.Align.CENTER);
        this.u4.setColor(this.f11576f);
        this.u4.setAntiAlias(true);
        this.u4.setTextAlign(Paint.Align.CENTER);
        this.u4.setTextSize(this.y);
        int i = this.M3;
        if (i % 2 == 0) {
            this.M3 = i + 1;
        }
        if (this.P3 == -1 || this.Q3 == -1) {
            m0();
        }
        K();
    }

    private void J(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tplink.iot.b.NumberPickerView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 17) {
                    this.M3 = obtainStyledAttributes.getInt(index, 3);
                } else if (index == 3) {
                    this.I3 = obtainStyledAttributes.getColor(index, 16777215);
                } else if (index == 4) {
                    this.J3 = obtainStyledAttributes.getDimensionPixelSize(index, 2);
                } else if (index == 5) {
                    this.K3 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 6) {
                    this.L3 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 19) {
                    this.v4 = q(obtainStyledAttributes.getTextArray(index));
                } else if (index == 21) {
                    this.f11574c = obtainStyledAttributes.getColor(index, -1717986919);
                } else if (index == 22) {
                    this.f11575d = obtainStyledAttributes.getColor(index, -14891265);
                } else if (index == 20) {
                    this.f11576f = obtainStyledAttributes.getColor(index, -14891265);
                } else if (index == 25) {
                    this.q = obtainStyledAttributes.getDimensionPixelSize(index, c0(context, 20.0f));
                } else if (index == 26) {
                    this.x = obtainStyledAttributes.getDimensionPixelSize(index, c0(context, 22.0f));
                } else if (index == 24) {
                    this.y = obtainStyledAttributes.getDimensionPixelSize(index, c0(context, 14.0f));
                } else if (index == 14) {
                    this.P3 = obtainStyledAttributes.getInteger(index, 0);
                } else if (index == 13) {
                    this.Q3 = obtainStyledAttributes.getInteger(index, 0);
                } else if (index == 27) {
                    this.j4 = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == 18) {
                    this.i4 = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == 8) {
                    this.a4 = obtainStyledAttributes.getString(index);
                } else if (index == 0) {
                    this.d4 = obtainStyledAttributes.getString(index);
                } else if (index == 7) {
                    this.c4 = obtainStyledAttributes.getString(index);
                } else if (index == 12) {
                    this.p1 = obtainStyledAttributes.getDimensionPixelSize(index, s(context, 8.0f));
                } else if (index == 11) {
                    this.p2 = obtainStyledAttributes.getDimensionPixelSize(index, s(context, 8.0f));
                } else if (index == 10) {
                    this.p3 = obtainStyledAttributes.getDimensionPixelSize(index, s(context, 2.0f));
                } else if (index == 9) {
                    this.H3 = obtainStyledAttributes.getDimensionPixelSize(index, s(context, 5.0f));
                } else if (index == 1) {
                    this.w4 = obtainStyledAttributes.getTextArray(index);
                } else if (index == 2) {
                    this.x4 = obtainStyledAttributes.getTextArray(index);
                } else if (index == 16) {
                    this.o4 = obtainStyledAttributes.getBoolean(index, false);
                } else if (index == 15) {
                    this.p4 = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == 23) {
                    this.b4 = obtainStyledAttributes.getString(index);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    private void K() {
        HandlerThread handlerThread = new HandlerThread("HandlerThread-For-Refreshing");
        this.y4 = handlerThread;
        handlerThread.start();
        this.z4 = new a(this.y4.getLooper());
        this.A4 = new b();
    }

    private void L() {
        r(getPickedIndexRelativeToRaw() - this.P3, false);
        this.j4 = false;
        postInvalidate();
    }

    private boolean M(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    private int N(int i) {
        if (this.j4 && this.m4) {
            return i;
        }
        int i2 = this.J4;
        return (i >= i2 && i <= (i2 = this.I4)) ? i : i2;
    }

    private int O(int i) {
        int mode = View.MeasureSpec.getMode(i);
        this.Y4 = mode;
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int paddingTop = getPaddingTop() + getPaddingBottom() + (this.M3 * (this.U3 + (this.p3 * 2)));
        return mode == Integer.MIN_VALUE ? Math.min(paddingTop, size) : paddingTop;
    }

    private int P(int i) {
        int mode = View.MeasureSpec.getMode(i);
        this.X4 = mode;
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int i2 = 0;
        int i3 = Math.max(this.z, this.p0) == 0 ? 0 : this.p2;
        if (Math.max(this.z, this.p0) != 0) {
            i2 = this.p1;
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight() + Math.max(this.V3, Math.max(this.T3, this.W3) + ((i2 + Math.max(this.z, this.p0) + i3 + (this.H3 * 2)) * 2));
        return mode == Integer.MIN_VALUE ? Math.min(paddingLeft, size) : paddingLeft;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(int i) {
        if (this.F4 != i) {
            this.F4 = i;
            c cVar = this.D4;
            if (cVar != null) {
                cVar.a(this, i);
            }
        }
    }

    private int R(int i, int i2, int i3, boolean z) {
        if (!z) {
            return i > i3 ? i3 : i < i2 ? i2 : i;
        }
        if (i > i3) {
            return (((i - i3) % getOneRecycleSize()) + i2) - 1;
        }
        return i < i2 ? ((i - i2) % getOneRecycleSize()) + i3 + 1 : i;
    }

    private void T() {
        VelocityTracker velocityTracker = this.r4;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.r4.recycle();
            this.r4 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i, int i2, Object obj) {
        Q(0);
        if (i != i2 && (obj == null || !(obj instanceof Boolean) || ((Boolean) obj).booleanValue())) {
            d dVar = this.C4;
            if (dVar != null) {
                int i3 = this.R3;
                dVar.a(this, i + i3, i3 + i2);
            }
            f fVar = this.B4;
            if (fVar != null) {
                fVar.a(this, i, i2, this.v4);
            }
        }
        this.X3 = i2;
        if (this.n4) {
            this.n4 = false;
            L();
        }
    }

    private void V(int i, int i2) {
        this.E4.a(this, i, i2);
    }

    private void W(int i) {
        X(i, true);
    }

    private void X(int i, boolean z) {
        int i2;
        int pickedIndexRelativeToRaw;
        int pickedIndexRelativeToRaw2;
        int i3;
        if ((!this.j4 || !this.m4) && ((pickedIndexRelativeToRaw2 = (pickedIndexRelativeToRaw = getPickedIndexRelativeToRaw()) + i) > (i3 = this.Q3) || pickedIndexRelativeToRaw2 < (i3 = this.P3))) {
            i = i3 - pickedIndexRelativeToRaw;
        }
        int i4 = this.V4;
        int i5 = this.Q4;
        if (i4 < (-i5) / 2) {
            i4 = i5 + i4;
            int i6 = (int) (((i4 + i5) * 300.0f) / i5);
            i2 = i < 0 ? (-i6) - (i * 300) : i6 + (i * 300);
        } else {
            int i7 = (int) (((-i4) * 300.0f) / i5);
            i2 = i < 0 ? i7 - (i * 300) : i7 + (i * 300);
        }
        int i8 = i4 + (i * i5);
        if (i2 < 300) {
            i2 = 300;
        }
        if (i2 > 600) {
            i2 = 600;
        }
        this.q4.startScroll(0, this.W4, 0, i8, i2);
        if (z) {
            this.z4.sendMessageDelayed(C(1), i2 / 4);
        } else {
            this.z4.sendMessageDelayed(D(1, 0, 0, new Boolean(z)), i2 / 4);
        }
        postInvalidate();
    }

    private int c0(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    private void d0() {
        Handler handler = this.z4;
        if (handler != null) {
            handler.removeMessages(1);
        }
    }

    private void f0(String[] strArr) {
        this.v4 = strArr;
        n0();
    }

    private void g0() {
        int i;
        int i2;
        int i3;
        int i4 = this.M3 / 2;
        this.N3 = i4;
        this.O3 = i4 + 1;
        int i5 = this.P4;
        this.R4 = (i4 * i5) / i;
        this.S4 = (i2 * i5) / i;
        if (this.K3 < 0) {
            this.K3 = 0;
        }
        if (this.L3 < 0) {
            this.L3 = 0;
        }
        if (this.K3 + this.L3 != 0 && getPaddingLeft() + this.K3 >= (this.O4 - getPaddingRight()) - this.L3) {
            int paddingLeft = getPaddingLeft() + this.K3 + getPaddingRight();
            int i6 = this.L3;
            int i7 = (paddingLeft + i6) - this.O4;
            int i8 = this.K3;
            float f2 = i7;
            this.K3 = (int) (i8 - ((i8 * f2) / (i8 + i6)));
            this.L3 = (int) (i6 - ((f2 * i6) / (i3 + i6)));
        }
    }

    private TextUtils.TruncateAt getEllipsizeType() {
        String str = this.b4;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1074341483:
                if (str.equals(LoadInfoBean.LoadLevel.MIDDLE)) {
                    c2 = 0;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    c2 = 1;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return TextUtils.TruncateAt.MIDDLE;
            case 1:
                return TextUtils.TruncateAt.END;
            case 2:
                return TextUtils.TruncateAt.START;
            default:
                throw new IllegalArgumentException("Illegal text ellipsize type.");
        }
    }

    private void h0() {
        int i = this.q;
        int i2 = this.Q4;
        if (i > i2) {
            this.q = i2;
        }
        if (this.x > i2) {
            this.x = i2;
        }
        Paint paint = this.u4;
        if (paint != null) {
            paint.setTextSize(this.y);
            this.h4 = E(this.u4.getFontMetrics());
            this.z = F(this.a4, this.u4);
            TextPaint textPaint = this.t4;
            if (textPaint != null) {
                textPaint.setTextSize(this.x);
                this.g4 = E(this.t4.getFontMetrics());
                this.t4.setTextSize(this.q);
                this.f4 = E(this.t4.getFontMetrics());
                return;
            }
            throw new IllegalArgumentException("mPaintText should not be null.");
        }
        throw new IllegalArgumentException("mPaintHint should not be null.");
    }

    private void i0() {
        float textSize = this.t4.getTextSize();
        this.t4.setTextSize(this.x);
        this.U3 = (int) ((this.t4.getFontMetrics().bottom - this.t4.getFontMetrics().top) + 0.5d);
        this.t4.setTextSize(textSize);
    }

    private void j0(boolean z) {
        k0();
        i0();
        if (!z) {
            return;
        }
        if (this.X4 == Integer.MIN_VALUE || this.Y4 == Integer.MIN_VALUE) {
            this.A4.sendEmptyMessage(3);
        }
    }

    private void k0() {
        float textSize = this.t4.getTextSize();
        this.t4.setTextSize(this.x);
        this.T3 = B(this.v4, this.t4);
        this.V3 = B(this.w4, this.t4);
        this.W3 = B(this.x4, this.t4);
        this.t4.setTextSize(this.y);
        this.p0 = F(this.d4, this.t4);
        this.t4.setTextSize(textSize);
    }

    private void l0() {
        this.I4 = 0;
        this.J4 = (-this.M3) * this.Q4;
        if (this.v4 != null) {
            int oneRecycleSize = getOneRecycleSize();
            int i = this.M3;
            int i2 = this.Q4;
            this.I4 = ((oneRecycleSize - (i / 2)) - 1) * i2;
            this.J4 = (-(i / 2)) * i2;
        }
    }

    private void m0() {
        H();
        n0();
        if (this.P3 == -1) {
            this.P3 = 0;
        }
        if (this.Q3 == -1) {
            this.Q3 = this.v4.length - 1;
        }
        Z(this.P3, this.Q3, false);
    }

    private void n() {
        int floor = (int) Math.floor(this.W4 / this.Q4);
        this.U4 = floor;
        int i = this.W4;
        int i2 = this.Q4;
        int i3 = -(i - (floor * i2));
        this.V4 = i3;
        if (this.E4 != null) {
            if ((-i3) > i2 / 2) {
                this.H4 = floor + 1 + (this.M3 / 2);
            } else {
                this.H4 = floor + (this.M3 / 2);
            }
            int oneRecycleSize = this.H4 % getOneRecycleSize();
            this.H4 = oneRecycleSize;
            if (oneRecycleSize < 0) {
                this.H4 = oneRecycleSize + getOneRecycleSize();
            }
            int i4 = this.G4;
            int i5 = this.H4;
            if (i4 != i5) {
                V(i4, i5);
            }
            this.G4 = this.H4;
        }
    }

    private void n0() {
        this.m4 = this.v4.length > this.M3;
    }

    private void o(MotionEvent motionEvent) {
        float y = motionEvent.getY();
        for (int i = 0; i < this.M3; i++) {
            int i2 = this.Q4;
            if (i2 * i <= y && y < i2 * (i + 1)) {
                p(i);
                return;
            }
        }
    }

    private void p(int i) {
        int i2;
        if (i >= 0 && i < (i2 = this.M3)) {
            W(i - (i2 / 2));
        }
    }

    private String[] q(CharSequence[] charSequenceArr) {
        if (charSequenceArr == null) {
            return null;
        }
        String[] strArr = new String[charSequenceArr.length];
        for (int i = 0; i < charSequenceArr.length; i++) {
            strArr[i] = charSequenceArr[i].toString();
        }
        return strArr;
    }

    private void r(int i, boolean z) {
        int i2 = i - ((this.M3 - 1) / 2);
        this.U4 = i2;
        int A = A(i2, getOneRecycleSize(), z);
        this.U4 = A;
        int i3 = this.Q4;
        if (i3 == 0) {
            this.k4 = true;
            return;
        }
        this.W4 = i3 * A;
        int i4 = A + (this.M3 / 2);
        this.G4 = i4;
        int oneRecycleSize = i4 % getOneRecycleSize();
        this.G4 = oneRecycleSize;
        if (oneRecycleSize < 0) {
            this.G4 = oneRecycleSize + getOneRecycleSize();
        }
        this.H4 = this.G4;
        n();
    }

    private int s(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void t(Canvas canvas) {
        float f2;
        float f3;
        int i;
        int i2;
        float f4 = 0.0f;
        for (int i3 = 0; i3 < this.M3 + 1; i3++) {
            float f5 = this.V4 + (this.Q4 * i3);
            int A = A(this.U4 + i3, getOneRecycleSize(), this.j4 && this.m4);
            int i4 = this.M3;
            if (i3 == i4 / 2) {
                f4 = (this.V4 + i2) / this.Q4;
                i = w(f4, this.f11574c, this.f11575d);
                f3 = z(f4, this.q, this.x);
                f2 = z(f4, this.f4, this.g4);
            } else if (i3 == (i4 / 2) + 1) {
                float f6 = 1.0f - f4;
                i = w(f6, this.f11574c, this.f11575d);
                f3 = z(f6, this.q, this.x);
                f2 = z(f6, this.f4, this.g4);
                f4 = f4;
            } else {
                int abs = Math.abs(i3 - (i4 / 2));
                i = x(3.0f, abs, this.f11574c);
                f3 = y(0.08f, abs, this.q);
                f2 = this.f4;
                f4 = f4;
            }
            this.t4.setColor(i);
            this.t4.setTextSize(f3);
            if (A >= 0 && A < getOneRecycleSize()) {
                CharSequence charSequence = this.v4[A + this.P3];
                if (this.b4 != null) {
                    charSequence = TextUtils.ellipsize(charSequence, this.t4, getWidth() - (this.H3 * 2), getEllipsizeType());
                }
                canvas.drawText(charSequence.toString(), this.T4, f5 + (this.Q4 / 2) + f2, this.t4);
            } else if (!TextUtils.isEmpty(this.c4)) {
                canvas.drawText(this.c4, this.T4, f5 + (this.Q4 / 2) + f2, this.t4);
            }
        }
    }

    private void u(Canvas canvas) {
        if (!TextUtils.isEmpty(this.a4)) {
            canvas.drawText(this.a4, this.T4 + ((this.T3 + this.z) / 2) + this.p1, ((this.R4 + this.S4) / 2.0f) + this.h4, this.u4);
        }
    }

    private void v(Canvas canvas) {
        if (this.i4) {
            canvas.drawLine(getPaddingLeft() + this.K3, this.R4, (this.O4 - getPaddingRight()) - this.L3, this.R4, this.s4);
            canvas.drawLine(getPaddingLeft() + this.K3, this.S4, (this.O4 - getPaddingRight()) - this.L3, this.S4, this.s4);
        }
    }

    private int w(float f2, int i, int i2) {
        int i3 = (i & ViewCompat.MEASURED_STATE_MASK) >>> 24;
        int i4 = (i & 16711680) >>> 16;
        int i5 = (i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >>> 8;
        int i6 = (i & 255) >>> 0;
        return ((int) (i6 + ((((i2 & 255) >>> 0) - i6) * f2))) | (((int) (i3 + (((((-16777216) & i2) >>> 24) - i3) * f2))) << 24) | (((int) (i4 + ((((16711680 & i2) >>> 16) - i4) * f2))) << 16) | (((int) (i5 + ((((65280 & i2) >>> 8) - i5) * f2))) << 8);
    }

    private int x(float f2, int i, int i2) {
        if (i == 1) {
            return i2;
        }
        int i3 = ((-16777216) & i2) >> 24;
        int i4 = (int) (((16711680 & i2) >> 16) * f2);
        int i5 = (int) (((65280 & i2) >> 8) * f2);
        int i6 = (int) ((i2 & 255) * f2);
        if (i4 >= 255) {
            i4 = 204;
        }
        if (i5 >= 255) {
            i5 = 204;
        }
        if (i6 >= 255) {
            i6 = 204;
        }
        return i6 | (i3 << 24) | (i4 << 16) | (i5 << 8);
    }

    private float y(float f2, int i, int i2) {
        return i == 1 ? i2 : (1.0f - (f2 * i)) * i2;
    }

    private float z(float f2, float f3, float f4) {
        return f3 + ((f4 - f3) * f2);
    }

    public void S(String[] strArr) {
        int minValue = getMinValue();
        int maxValue = (getMaxValue() - minValue) + 1;
        int length = strArr.length - 1;
        if ((length - minValue) + 1 > maxValue) {
            setDisplayedValues(strArr);
            setMaxValue(length);
            return;
        }
        setMaxValue(length);
        setDisplayedValues(strArr);
    }

    public void Y(int i, int i2) {
        Z(i, i2, true);
    }

    public void Z(int i, int i2, boolean z) {
        if (i <= i2) {
            String[] strArr = this.v4;
            if (strArr == null) {
                throw new IllegalArgumentException("mDisplayedValues should not be null, you need to set mDisplayedValues first.");
            } else if (i >= 0) {
                boolean z2 = true;
                if (i > strArr.length - 1) {
                    throw new IllegalArgumentException("minShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.v4.length - 1) + " minShowIndex is " + i);
                } else if (i2 < 0) {
                    throw new IllegalArgumentException("maxShowIndex should not be less than 0, now maxShowIndex is " + i2);
                } else if (i2 <= strArr.length - 1) {
                    this.P3 = i;
                    this.Q3 = i2;
                    if (z) {
                        this.X3 = i + 0;
                        if (!this.j4 || !this.m4) {
                            z2 = false;
                        }
                        r(0, z2);
                        postInvalidate();
                    }
                } else {
                    throw new IllegalArgumentException("maxShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.v4.length - 1) + " maxShowIndex is " + i2);
                }
            } else {
                throw new IllegalArgumentException("minShowIndex should not be less than 0, now minShowIndex is " + i);
            }
        } else {
            throw new IllegalArgumentException("minShowIndex should be less than maxShowIndex, minShowIndex is " + i + ", maxShowIndex is " + i2 + ".");
        }
    }

    public void a0(int i) {
        b0(getValue(), i, true);
    }

    public void b0(int i, int i2, boolean z) {
        int i3;
        boolean z2 = true;
        int R = R(i, this.R3, this.S3, this.j4 && this.m4);
        int i4 = this.R3;
        int i5 = this.S3;
        if (!this.j4 || !this.m4) {
            z2 = false;
        }
        int R2 = R(i2, i4, i5, z2);
        if (!this.j4 || !this.m4) {
            i3 = R2 - R;
        } else {
            i3 = R2 - R;
            int oneRecycleSize = getOneRecycleSize() / 2;
            if (i3 < (-oneRecycleSize) || oneRecycleSize < i3) {
                int oneRecycleSize2 = getOneRecycleSize();
                i3 = i3 > 0 ? i3 - oneRecycleSize2 : i3 + oneRecycleSize2;
            }
        }
        setValue(R);
        if (R != R2) {
            X(i3, z);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.Q4 != 0 && this.q4.computeScrollOffset()) {
            this.W4 = this.q4.getCurrY();
            n();
            postInvalidate();
        }
    }

    public void e0() {
        ScrollerCompat scrollerCompat = this.q4;
        if (scrollerCompat != null && !scrollerCompat.isFinished()) {
            ScrollerCompat scrollerCompat2 = this.q4;
            scrollerCompat2.startScroll(0, scrollerCompat2.getCurrY(), 0, 0, 1);
            this.q4.abortAnimation();
            postInvalidate();
        }
    }

    public String getContentByCurrValue() {
        return this.v4[getValue() - this.R3];
    }

    public String[] getDisplayedValues() {
        return this.v4;
    }

    public int getMaxValue() {
        return this.S3;
    }

    public int getMinValue() {
        return this.R3;
    }

    public int getOneRecycleSize() {
        return (this.Q3 - this.P3) + 1;
    }

    public int getPickedIndexRelativeToRaw() {
        int i = this.V4;
        if (i == 0) {
            return G(this.W4);
        }
        int i2 = this.Q4;
        if (i < (-i2) / 2) {
            return G(this.W4 + i2 + i);
        }
        return G(this.W4 + i);
    }

    public int getRawContentSize() {
        String[] strArr = this.v4;
        if (strArr != null) {
            return strArr.length;
        }
        return 0;
    }

    public int getValue() {
        return getPickedIndexRelativeToRaw() + this.R3;
    }

    public boolean getWrapSelectorWheel() {
        return this.j4;
    }

    public boolean getWrapSelectorWheelAbsolutely() {
        return this.j4 && this.m4;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        HandlerThread handlerThread = this.y4;
        if (handlerThread == null || !handlerThread.isAlive()) {
            K();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.y4.quit();
        if (this.Q4 != 0) {
            if (!this.q4.isFinished()) {
                this.q4.abortAnimation();
                this.W4 = this.q4.getCurrY();
                n();
                int i = this.V4;
                if (i != 0) {
                    int i2 = this.Q4;
                    if (i < (-i2) / 2) {
                        this.W4 = this.W4 + i2 + i;
                    } else {
                        this.W4 += i;
                    }
                    n();
                }
                Q(0);
            }
            int G = G(this.W4);
            int i3 = this.X3;
            if (G != i3 && this.o4) {
                try {
                    d dVar = this.C4;
                    if (dVar != null) {
                        int i4 = this.R3;
                        dVar.a(this, i3 + i4, i4 + G);
                    }
                    f fVar = this.B4;
                    if (fVar != null) {
                        fVar.a(this, this.X3, G, this.v4);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.X3 = G;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        t(canvas);
        v(canvas);
        u(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        j0(false);
        setMeasuredDimension(P(i), O(i2));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5;
        super.onSizeChanged(i, i2, i3, i4);
        this.O4 = i;
        this.P4 = i2;
        this.Q4 = i2 / this.M3;
        this.T4 = ((i + getPaddingLeft()) - getPaddingRight()) / 2.0f;
        boolean z = false;
        if (getOneRecycleSize() > 1) {
            if (this.l4) {
                i5 = getValue() - this.R3;
            } else if (this.k4) {
                i5 = this.U4 + ((this.M3 - 1) / 2);
            }
            if (this.j4 && this.m4) {
                z = true;
            }
            r(i5, z);
            h0();
            l0();
            g0();
            this.l4 = true;
        }
        i5 = 0;
        if (this.j4) {
            z = true;
        }
        r(i5, z);
        h0();
        l0();
        g0();
        this.l4 = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0059, code lost:
        if (r1 < r3) goto L_0x006e;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.widget.NumberPickerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setContentTextTypeface(Typeface typeface) {
        this.t4.setTypeface(typeface);
    }

    public void setDisplayedValues(String[] strArr) {
        d0();
        e0();
        if (strArr != null) {
            boolean z = true;
            if ((this.S3 - this.R3) + 1 <= strArr.length) {
                f0(strArr);
                j0(true);
                this.X3 = this.P3 + 0;
                if (!this.j4 || !this.m4) {
                    z = false;
                }
                r(0, z);
                postInvalidate();
                this.A4.sendEmptyMessage(3);
                return;
            }
            throw new IllegalArgumentException("mMaxValue - mMinValue + 1 should not be greater than mDisplayedValues.length, now ((mMaxValue - mMinValue + 1) is " + ((this.S3 - this.R3) + 1) + " newDisplayedValues.length is " + strArr.length + ", you need to set MaxValue and MinValue before setDisplayedValues(String[])");
        }
        throw new IllegalArgumentException("newDisplayedValues should not be null.");
    }

    public void setDividerColor(int i) {
        if (this.I3 != i) {
            this.I3 = i;
            this.s4.setColor(i);
            postInvalidate();
        }
    }

    public void setFriction(float f2) {
        if (f2 > 0.0f) {
            ViewConfiguration.get(getContext());
            this.e4 = ViewConfiguration.getScrollFriction() / f2;
            return;
        }
        throw new IllegalArgumentException("you should set a a positive float friction, now friction is " + f2);
    }

    public void setHintText(String str) {
        if (!M(this.a4, str)) {
            this.a4 = str;
            this.h4 = E(this.u4.getFontMetrics());
            this.z = F(this.a4, this.u4);
            this.A4.sendEmptyMessage(3);
        }
    }

    public void setHintTextColor(int i) {
        if (this.f11576f != i) {
            this.f11576f = i;
            this.u4.setColor(i);
            postInvalidate();
        }
    }

    public void setHintTextTypeface(Typeface typeface) {
        this.u4.setTypeface(typeface);
    }

    public void setMaxValue(int i) {
        String[] strArr = this.v4;
        Objects.requireNonNull(strArr, "mDisplayedValues should not be null");
        int i2 = this.R3;
        if ((i - i2) + 1 <= strArr.length) {
            this.S3 = i;
            int i3 = this.P3;
            int i4 = (i - i2) + i3;
            this.Q3 = i4;
            Y(i3, i4);
            l0();
            return;
        }
        throw new IllegalArgumentException("(maxValue - mMinValue + 1) should not be greater than mDisplayedValues.length now  (maxValue - mMinValue + 1) is " + ((i - this.R3) + 1) + " and mDisplayedValues.length is " + this.v4.length);
    }

    public void setMinValue(int i) {
        this.R3 = i;
        this.P3 = 0;
        l0();
    }

    public void setNormalTextColor(int i) {
        if (this.f11574c != i) {
            this.f11574c = i;
            postInvalidate();
        }
    }

    public void setOnScrollListener(c cVar) {
        this.D4 = cVar;
    }

    public void setOnValueChangeListenerInScrolling(e eVar) {
        this.E4 = eVar;
    }

    public void setOnValueChangedListener(d dVar) {
        this.C4 = dVar;
    }

    public void setOnValueChangedListenerRelativeToRaw(f fVar) {
        this.B4 = fVar;
    }

    public void setPickedIndexRelativeToMin(int i) {
        if (i >= 0 && i < getOneRecycleSize()) {
            this.X3 = this.P3 + i;
            r(i, this.j4 && this.m4);
            postInvalidate();
        }
    }

    public void setPickedIndexRelativeToRaw(int i) {
        int i2 = this.P3;
        if (i2 > -1 && i2 <= i && i <= this.Q3) {
            this.X3 = i;
            r(i - i2, this.j4 && this.m4);
            postInvalidate();
        }
    }

    public void setSelectedTextColor(int i) {
        if (this.f11575d != i) {
            this.f11575d = i;
            postInvalidate();
        }
    }

    public void setValue(int i) {
        int i2 = this.R3;
        if (i < i2) {
            throw new IllegalArgumentException("should not set a value less than mMinValue, value is " + i);
        } else if (i <= this.S3) {
            setPickedIndexRelativeToRaw(i - i2);
        } else {
            throw new IllegalArgumentException("should not set a value greater than mMaxValue, value is " + i);
        }
    }

    public void setWrapSelectorWheel(boolean z) {
        if (this.j4 == z) {
            return;
        }
        if (z) {
            this.j4 = z;
            n0();
            postInvalidate();
        } else if (this.F4 == 0) {
            L();
        } else {
            this.n4 = true;
        }
    }

    public NumberPickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        J(context, attributeSet);
        I(context);
    }

    public NumberPickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        J(context, attributeSet);
        I(context);
    }
}
