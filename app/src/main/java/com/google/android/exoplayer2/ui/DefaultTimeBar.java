package com.google.android.exoplayer2.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.ui.y0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes.dex */
public class DefaultTimeBar extends View implements y0 {
    private final int H3;
    private final int I3;
    private final int J3;
    private final int K3;
    private final int L3;
    private final int M3;
    private final int N3;
    private final int O3;
    private final int P3;
    private final StringBuilder Q3;
    private final Formatter R3;
    private final Runnable S3;
    private final CopyOnWriteArraySet<y0.a> T3;
    private final Point U3;
    private final float V3;
    private int W3;
    private long X3;
    private int Y3;
    private Rect Z3;
    private ValueAnimator a4;
    private float b4;

    /* renamed from: c  reason: collision with root package name */
    private final Rect f3675c;
    private boolean c4;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f3676d;
    private boolean d4;
    private long e4;

    /* renamed from: f  reason: collision with root package name */
    private final Rect f3677f;
    private long f4;
    private long g4;
    private long h4;
    private int i4;
    @Nullable
    private long[] j4;
    @Nullable
    private boolean[] k4;
    private final Paint p0;
    private final Paint p1;
    private final Paint p2;
    @Nullable
    private final Drawable p3;
    private final Rect q;
    private final Paint x;
    private final Paint y;
    private final Paint z;

    public DefaultTimeBar(Context context) {
        this(context, null);
    }

    private static int c(float f2, int i) {
        return (int) ((i * f2) + 0.5f);
    }

    private void d(Canvas canvas) {
        int i;
        if (this.f4 > 0) {
            Rect rect = this.q;
            int p = o0.p(rect.right, rect.left, this.f3676d.right);
            int centerY = this.q.centerY();
            Drawable drawable = this.p3;
            if (drawable == null) {
                if (this.d4 || isFocused()) {
                    i = this.N3;
                } else {
                    i = isEnabled() ? this.L3 : this.M3;
                }
                canvas.drawCircle(p, centerY, (int) ((i * this.b4) / 2.0f), this.p2);
                return;
            }
            int intrinsicWidth = ((int) (drawable.getIntrinsicWidth() * this.b4)) / 2;
            int intrinsicHeight = ((int) (this.p3.getIntrinsicHeight() * this.b4)) / 2;
            this.p3.setBounds(p - intrinsicWidth, centerY - intrinsicHeight, p + intrinsicWidth, centerY + intrinsicHeight);
            this.p3.draw(canvas);
        }
    }

    private void e(Canvas canvas) {
        int height = this.f3676d.height();
        int centerY = this.f3676d.centerY() - (height / 2);
        int i = height + centerY;
        if (this.f4 <= 0) {
            Rect rect = this.f3676d;
            canvas.drawRect(rect.left, centerY, rect.right, i, this.z);
            return;
        }
        Rect rect2 = this.f3677f;
        int i2 = rect2.left;
        int i3 = rect2.right;
        int max = Math.max(Math.max(this.f3676d.left, i3), this.q.right);
        int i4 = this.f3676d.right;
        if (max < i4) {
            canvas.drawRect(max, centerY, i4, i, this.z);
        }
        int max2 = Math.max(i2, this.q.right);
        if (i3 > max2) {
            canvas.drawRect(max2, centerY, i3, i, this.y);
        }
        if (this.q.width() > 0) {
            Rect rect3 = this.q;
            canvas.drawRect(rect3.left, centerY, rect3.right, i, this.x);
        }
        if (this.i4 != 0) {
            long[] jArr = (long[]) g.e(this.j4);
            boolean[] zArr = (boolean[]) g.e(this.k4);
            int i5 = this.K3 / 2;
            for (int i6 = 0; i6 < this.i4; i6++) {
                long q = o0.q(jArr[i6], 0L, this.f4);
                Rect rect4 = this.f3676d;
                int min = rect4.left + Math.min(rect4.width() - this.K3, Math.max(0, ((int) ((this.f3676d.width() * q) / this.f4)) - i5));
                canvas.drawRect(min, centerY, min + this.K3, i, zArr[i6] ? this.p1 : this.p0);
            }
        }
    }

    private long getPositionIncrement() {
        long j = this.X3;
        if (j != -9223372036854775807L) {
            return j;
        }
        long j2 = this.f4;
        if (j2 == -9223372036854775807L) {
            return 0L;
        }
        return j2 / this.W3;
    }

    private String getProgressText() {
        return o0.Z(this.Q3, this.R3, this.g4);
    }

    private long getScrubberPosition() {
        if (this.f3676d.width() <= 0 || this.f4 == -9223372036854775807L) {
            return 0L;
        }
        return (this.q.width() * this.f4) / this.f3676d.width();
    }

    private boolean h(float f2, float f3) {
        return this.f3675c.contains((int) f2, (int) f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public /* synthetic */ void j() {
        w(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public /* synthetic */ void l(ValueAnimator valueAnimator) {
        this.b4 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate(this.f3675c);
    }

    private void m(float f2) {
        Rect rect = this.q;
        Rect rect2 = this.f3676d;
        rect.right = o0.p((int) f2, rect2.left, rect2.right);
    }

    private static int n(float f2, int i) {
        return (int) (i / f2);
    }

    private Point o(MotionEvent motionEvent) {
        this.U3.set((int) motionEvent.getX(), (int) motionEvent.getY());
        return this.U3;
    }

    private boolean p(long j) {
        long j2 = this.f4;
        if (j2 <= 0) {
            return false;
        }
        long j3 = this.d4 ? this.e4 : this.g4;
        long q = o0.q(j3 + j, 0L, j2);
        if (q == j3) {
            return false;
        }
        if (!this.d4) {
            v(q);
        } else {
            z(q);
        }
        x();
        return true;
    }

    private boolean q(Drawable drawable) {
        return o0.a >= 23 && r(drawable, getLayoutDirection());
    }

    private static boolean r(Drawable drawable, int i) {
        return o0.a >= 23 && drawable.setLayoutDirection(i);
    }

    @RequiresApi(29)
    private void s(int i, int i2) {
        Rect rect = this.Z3;
        if (rect == null || rect.width() != i || this.Z3.height() != i2) {
            Rect rect2 = new Rect(0, 0, i, i2);
            this.Z3 = rect2;
            setSystemGestureExclusionRects(Collections.singletonList(rect2));
        }
    }

    private void v(long j) {
        this.e4 = j;
        this.d4 = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator<y0.a> it = this.T3.iterator();
        while (it.hasNext()) {
            it.next().i(this, j);
        }
    }

    private void w(boolean z) {
        removeCallbacks(this.S3);
        this.d4 = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator<y0.a> it = this.T3.iterator();
        while (it.hasNext()) {
            it.next().h(this, this.e4, z);
        }
    }

    private void x() {
        this.f3677f.set(this.f3676d);
        this.q.set(this.f3676d);
        long j = this.d4 ? this.e4 : this.g4;
        if (this.f4 > 0) {
            int width = (int) ((this.f3676d.width() * this.h4) / this.f4);
            Rect rect = this.f3677f;
            Rect rect2 = this.f3676d;
            rect.right = Math.min(rect2.left + width, rect2.right);
            int width2 = (int) ((this.f3676d.width() * j) / this.f4);
            Rect rect3 = this.q;
            Rect rect4 = this.f3676d;
            rect3.right = Math.min(rect4.left + width2, rect4.right);
        } else {
            Rect rect5 = this.f3677f;
            int i = this.f3676d.left;
            rect5.right = i;
            this.q.right = i;
        }
        invalidate(this.f3675c);
    }

    private void y() {
        Drawable drawable = this.p3;
        if (drawable != null && drawable.isStateful() && this.p3.setState(getDrawableState())) {
            invalidate();
        }
    }

    private void z(long j) {
        if (this.e4 != j) {
            this.e4 = j;
            Iterator<y0.a> it = this.T3.iterator();
            while (it.hasNext()) {
                it.next().b(this, j);
            }
        }
    }

    @Override // com.google.android.exoplayer2.ui.y0
    public void a(y0.a aVar) {
        g.e(aVar);
        this.T3.add(aVar);
    }

    @Override // com.google.android.exoplayer2.ui.y0
    public void b(@Nullable long[] jArr, @Nullable boolean[] zArr, int i) {
        g.a(i == 0 || !(jArr == null || zArr == null));
        this.i4 = i;
        this.j4 = jArr;
        this.k4 = zArr;
        x();
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        y();
    }

    public void f(long j) {
        if (this.a4.isStarted()) {
            this.a4.cancel();
        }
        this.a4.setFloatValues(this.b4, 0.0f);
        this.a4.setDuration(j);
        this.a4.start();
    }

    public void g(boolean z) {
        if (this.a4.isStarted()) {
            this.a4.cancel();
        }
        this.c4 = z;
        this.b4 = 0.0f;
        invalidate(this.f3675c);
    }

    @Override // com.google.android.exoplayer2.ui.y0
    public long getPreferredUpdateDelay() {
        int n = n(this.V3, this.f3676d.width());
        if (n != 0) {
            long j = this.f4;
            if (!(j == 0 || j == -9223372036854775807L)) {
                return j / n;
            }
        }
        return Long.MAX_VALUE;
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.p3;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        e(canvas);
        d(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z, int i, @Nullable Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (this.d4 && !z) {
            w(false);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName("android.widget.SeekBar");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.SeekBar");
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (this.f4 > 0) {
            if (o0.a >= 21) {
                accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
                accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
                return;
            }
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(8192);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    @Override // android.view.View, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onKeyDown(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            boolean r0 = r4.isEnabled()
            if (r0 == 0) goto L_0x0030
            long r0 = r4.getPositionIncrement()
            r2 = 66
            r3 = 1
            if (r5 == r2) goto L_0x0027
            switch(r5) {
                case 21: goto L_0x0013;
                case 22: goto L_0x0014;
                case 23: goto L_0x0027;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x0030
        L_0x0013:
            long r0 = -r0
        L_0x0014:
            boolean r0 = r4.p(r0)
            if (r0 == 0) goto L_0x0030
            java.lang.Runnable r5 = r4.S3
            r4.removeCallbacks(r5)
            java.lang.Runnable r5 = r4.S3
            r0 = 1000(0x3e8, double:4.94E-321)
            r4.postDelayed(r5, r0)
            return r3
        L_0x0027:
            boolean r0 = r4.d4
            if (r0 == 0) goto L_0x0030
            r5 = 0
            r4.w(r5)
            return r3
        L_0x0030:
            boolean r5 = super.onKeyDown(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.DefaultTimeBar.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i3 - i;
        int i8 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = i7 - getPaddingRight();
        int i9 = this.c4 ? 0 : this.O3;
        if (this.J3 == 1) {
            i6 = (i8 - getPaddingBottom()) - this.I3;
            int i10 = this.H3;
            i5 = ((i8 - getPaddingBottom()) - i10) - Math.max(i9 - (i10 / 2), 0);
        } else {
            i6 = (i8 - this.I3) / 2;
            i5 = (i8 - this.H3) / 2;
        }
        this.f3675c.set(paddingLeft, i6, paddingRight, this.I3 + i6);
        Rect rect = this.f3676d;
        Rect rect2 = this.f3675c;
        rect.set(rect2.left + i9, i5, rect2.right - i9, this.H3 + i5);
        if (o0.a >= 29) {
            s(i7, i8);
        }
        x();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 0) {
            size = this.I3;
        } else if (mode != 1073741824) {
            size = Math.min(this.I3, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), size);
        y();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        Drawable drawable = this.p3;
        if (drawable != null && r(drawable, i)) {
            invalidate();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
        if (r3 != 3) goto L_0x0076;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            boolean r0 = r7.isEnabled()
            r1 = 0
            if (r0 == 0) goto L_0x0076
            long r2 = r7.f4
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 > 0) goto L_0x0010
            goto L_0x0076
        L_0x0010:
            android.graphics.Point r0 = r7.o(r8)
            int r2 = r0.x
            int r0 = r0.y
            int r3 = r8.getAction()
            r4 = 1
            if (r3 == 0) goto L_0x005d
            r5 = 3
            if (r3 == r4) goto L_0x004e
            r6 = 2
            if (r3 == r6) goto L_0x0028
            if (r3 == r5) goto L_0x004e
            goto L_0x0076
        L_0x0028:
            boolean r8 = r7.d4
            if (r8 == 0) goto L_0x0076
            int r8 = r7.P3
            if (r0 >= r8) goto L_0x003a
            int r8 = r7.Y3
            int r2 = r2 - r8
            int r2 = r2 / r5
            int r8 = r8 + r2
            float r8 = (float) r8
            r7.m(r8)
            goto L_0x0040
        L_0x003a:
            r7.Y3 = r2
            float r8 = (float) r2
            r7.m(r8)
        L_0x0040:
            long r0 = r7.getScrubberPosition()
            r7.z(r0)
            r7.x()
            r7.invalidate()
            return r4
        L_0x004e:
            boolean r0 = r7.d4
            if (r0 == 0) goto L_0x0076
            int r8 = r8.getAction()
            if (r8 != r5) goto L_0x0059
            r1 = 1
        L_0x0059:
            r7.w(r1)
            return r4
        L_0x005d:
            float r8 = (float) r2
            float r0 = (float) r0
            boolean r0 = r7.h(r8, r0)
            if (r0 == 0) goto L_0x0076
            r7.m(r8)
            long r0 = r7.getScrubberPosition()
            r7.v(r0)
            r7.x()
            r7.invalidate()
            return r4
        L_0x0076:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.DefaultTimeBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i, @Nullable Bundle bundle) {
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        if (this.f4 <= 0) {
            return false;
        }
        if (i == 8192) {
            if (p(-getPositionIncrement())) {
                w(false);
            }
        } else if (i != 4096) {
            return false;
        } else {
            if (p(getPositionIncrement())) {
                w(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    public void setAdMarkerColor(@ColorInt int i) {
        this.p0.setColor(i);
        invalidate(this.f3675c);
    }

    public void setBufferedColor(@ColorInt int i) {
        this.y.setColor(i);
        invalidate(this.f3675c);
    }

    @Override // com.google.android.exoplayer2.ui.y0
    public void setBufferedPosition(long j) {
        this.h4 = j;
        x();
    }

    @Override // com.google.android.exoplayer2.ui.y0
    public void setDuration(long j) {
        this.f4 = j;
        if (this.d4 && j == -9223372036854775807L) {
            w(true);
        }
        x();
    }

    @Override // android.view.View, com.google.android.exoplayer2.ui.y0
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (this.d4 && !z) {
            w(true);
        }
    }

    public void setKeyCountIncrement(int i) {
        g.a(i > 0);
        this.W3 = i;
        this.X3 = -9223372036854775807L;
    }

    public void setKeyTimeIncrement(long j) {
        g.a(j > 0);
        this.W3 = -1;
        this.X3 = j;
    }

    public void setPlayedAdMarkerColor(@ColorInt int i) {
        this.p1.setColor(i);
        invalidate(this.f3675c);
    }

    public void setPlayedColor(@ColorInt int i) {
        this.x.setColor(i);
        invalidate(this.f3675c);
    }

    @Override // com.google.android.exoplayer2.ui.y0
    public void setPosition(long j) {
        this.g4 = j;
        setContentDescription(getProgressText());
        x();
    }

    public void setScrubberColor(@ColorInt int i) {
        this.p2.setColor(i);
        invalidate(this.f3675c);
    }

    public void setUnplayedColor(@ColorInt int i) {
        this.z.setColor(i);
        invalidate(this.f3675c);
    }

    public void t() {
        if (this.a4.isStarted()) {
            this.a4.cancel();
        }
        this.c4 = false;
        this.b4 = 1.0f;
        invalidate(this.f3675c);
    }

    public void u(long j) {
        if (this.a4.isStarted()) {
            this.a4.cancel();
        }
        this.c4 = false;
        this.a4.setFloatValues(this.b4, 1.0f);
        this.a4.setDuration(j);
        this.a4.start();
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, attributeSet);
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet, int i, @Nullable AttributeSet attributeSet2) {
        this(context, attributeSet, i, attributeSet2, 0);
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet, int i, @Nullable AttributeSet attributeSet2, int i2) {
        super(context, attributeSet, i);
        this.f3675c = new Rect();
        this.f3676d = new Rect();
        this.f3677f = new Rect();
        this.q = new Rect();
        Paint paint = new Paint();
        this.x = paint;
        Paint paint2 = new Paint();
        this.y = paint2;
        Paint paint3 = new Paint();
        this.z = paint3;
        Paint paint4 = new Paint();
        this.p0 = paint4;
        Paint paint5 = new Paint();
        this.p1 = paint5;
        Paint paint6 = new Paint();
        this.p2 = paint6;
        paint6.setAntiAlias(true);
        this.T3 = new CopyOnWriteArraySet<>();
        this.U3 = new Point();
        float f2 = context.getResources().getDisplayMetrics().density;
        this.V3 = f2;
        this.P3 = c(f2, -50);
        int c2 = c(f2, 4);
        int c3 = c(f2, 26);
        int c4 = c(f2, 4);
        int c5 = c(f2, 12);
        int c6 = c(f2, 0);
        int c7 = c(f2, 16);
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, t0.DefaultTimeBar, i, i2);
            try {
                Drawable drawable = obtainStyledAttributes.getDrawable(t0.DefaultTimeBar_scrubber_drawable);
                this.p3 = drawable;
                if (drawable != null) {
                    q(drawable);
                    c3 = Math.max(drawable.getMinimumHeight(), c3);
                }
                this.H3 = obtainStyledAttributes.getDimensionPixelSize(t0.DefaultTimeBar_bar_height, c2);
                this.I3 = obtainStyledAttributes.getDimensionPixelSize(t0.DefaultTimeBar_touch_target_height, c3);
                this.J3 = obtainStyledAttributes.getInt(t0.DefaultTimeBar_bar_gravity, 0);
                this.K3 = obtainStyledAttributes.getDimensionPixelSize(t0.DefaultTimeBar_ad_marker_width, c4);
                this.L3 = obtainStyledAttributes.getDimensionPixelSize(t0.DefaultTimeBar_scrubber_enabled_size, c5);
                this.M3 = obtainStyledAttributes.getDimensionPixelSize(t0.DefaultTimeBar_scrubber_disabled_size, c6);
                this.N3 = obtainStyledAttributes.getDimensionPixelSize(t0.DefaultTimeBar_scrubber_dragged_size, c7);
                int i3 = obtainStyledAttributes.getInt(t0.DefaultTimeBar_played_color, -1);
                int i4 = obtainStyledAttributes.getInt(t0.DefaultTimeBar_scrubber_color, -1);
                int i5 = obtainStyledAttributes.getInt(t0.DefaultTimeBar_buffered_color, -855638017);
                int i6 = obtainStyledAttributes.getInt(t0.DefaultTimeBar_unplayed_color, 872415231);
                int i7 = obtainStyledAttributes.getInt(t0.DefaultTimeBar_ad_marker_color, -1291845888);
                int i8 = obtainStyledAttributes.getInt(t0.DefaultTimeBar_played_ad_marker_color, 872414976);
                paint.setColor(i3);
                paint6.setColor(i4);
                paint2.setColor(i5);
                paint3.setColor(i6);
                paint4.setColor(i7);
                paint5.setColor(i8);
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            this.H3 = c2;
            this.I3 = c3;
            this.J3 = 0;
            this.K3 = c4;
            this.L3 = c5;
            this.M3 = c6;
            this.N3 = c7;
            paint.setColor(-1);
            paint6.setColor(-1);
            paint2.setColor(-855638017);
            paint3.setColor(872415231);
            paint4.setColor(-1291845888);
            paint5.setColor(872414976);
            this.p3 = null;
        }
        StringBuilder sb = new StringBuilder();
        this.Q3 = sb;
        this.R3 = new Formatter(sb, Locale.getDefault());
        this.S3 = new Runnable() { // from class: com.google.android.exoplayer2.ui.b
            @Override // java.lang.Runnable
            public final void run() {
                DefaultTimeBar.this.j();
            }
        };
        Drawable drawable2 = this.p3;
        if (drawable2 != null) {
            this.O3 = (drawable2.getMinimumWidth() + 1) / 2;
        } else {
            this.O3 = (Math.max(this.M3, Math.max(this.L3, this.N3)) + 1) / 2;
        }
        this.b4 = 1.0f;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.a4 = valueAnimator;
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.exoplayer2.ui.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                DefaultTimeBar.this.l(valueAnimator2);
            }
        });
        this.f4 = -9223372036854775807L;
        this.X3 = -9223372036854775807L;
        this.W3 = 20;
        setFocusable(true);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }
}
