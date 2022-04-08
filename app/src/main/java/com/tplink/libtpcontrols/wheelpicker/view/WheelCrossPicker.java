package com.tplink.libtpcontrols.wheelpicker.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tplink.libtpcontrols.wheelpicker.core.AbstractWheelPicker;
import com.tplink.libtpcontrols.wheelpicker.core.a;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class WheelCrossPicker extends AbstractWheelPicker implements Runnable {
    protected c h4;
    protected Rect i4;
    protected Rect j4;
    protected Rect k4;
    protected Rect l4;
    protected int m4;
    protected int n4;
    protected int o4;
    protected int p4;
    protected int q4;
    protected int r4;

    public WheelCrossPicker(Context context) {
        super(context);
    }

    private void s() {
        if (this.H3 == 0) {
            int min = Math.min(this.p2.size() - 1, Math.max(0, this.J3 - (this.n4 / this.m4)));
            String str = this.p2.get(min);
            if (!this.p3.equals(str)) {
                this.p3 = str;
                o(min, str);
            }
        }
    }

    private void t() {
        int abs = Math.abs(this.n4 % this.m4);
        if (abs != 0) {
            int i = this.m4;
            if (abs >= i / 2.0f) {
                u(abs - i, i - abs);
            } else {
                u(abs, -abs);
            }
            postInvalidate();
            this.z.postDelayed(this, 16L);
        }
    }

    private void u(int i, int i2) {
        int i3 = this.n4;
        if (i3 < 0) {
            this.h4.a(this.f12475d, i3, i);
        } else {
            this.h4.a(this.f12475d, i3, i2);
        }
        m(2);
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.core.AbstractWheelPicker
    protected void c(Canvas canvas) {
        if (this.f4) {
            this.q.setColor(this.O3);
            canvas.drawRect(this.j4.left, (getHeight() / 2.0f) - (this.K3 / 2.0f), this.j4.right, ((getHeight() / 2.0f) - (this.K3 / 2.0f)) + this.L3, this.q);
            canvas.drawRect(this.j4.left, ((getHeight() / 2.0f) + (this.K3 / 2.0f)) - this.L3, this.j4.right, (getHeight() / 2.0f) + (this.K3 / 2.0f), this.q);
        }
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.core.AbstractWheelPicker
    protected void d(Canvas canvas) {
        if (this.p1 != null) {
            canvas.save();
            canvas.clipRect(this.i4);
            this.p1.a(canvas, this.k4, this.l4, this.q);
            canvas.restore();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.libtpcontrols.wheelpicker.core.AbstractWheelPicker
    public void g() {
        super.g();
        this.h4 = new b();
        this.i4 = new Rect();
        this.j4 = new Rect();
        this.k4 = new Rect();
        this.l4 = new Rect();
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.core.AbstractWheelPicker
    protected void j(MotionEvent motionEvent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.libtpcontrols.wheelpicker.core.AbstractWheelPicker
    public void k(MotionEvent motionEvent) {
        m(1);
        n(this.b4 + this.Z3, this.c4 + this.a4);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.libtpcontrols.wheelpicker.core.AbstractWheelPicker
    public void l(MotionEvent motionEvent) {
        this.h4.l(this.f12475d, this.f12474c, this.n4, this.o4, this.p4, this.r4);
        m(2);
        this.z.post(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.libtpcontrols.wheelpicker.core.AbstractWheelPicker, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.h4.d(this.j4, this.K3, i, i2, this.Q3, this.R3, this.U3, this.V3, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        this.h4.h(this.k4, this.l4, this.j4, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        this.i4.set(this.j4);
        if (!this.d4) {
            this.h4.o(this.i4, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.core.AbstractWheelPicker
    public void p(boolean z, a aVar) {
        super.p(z, aVar);
        invalidate(this.j4);
    }

    public void q() {
        int i = this.n4;
        int i2 = this.p4;
        if (i > i2) {
            this.h4.a(this.f12475d, i, i2 - i);
        }
        int i3 = this.n4;
        int i4 = this.o4;
        if (i3 < i4) {
            this.h4.a(this.f12475d, i3, i4 - i3);
        }
        this.z.post(this);
    }

    public void r() {
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f12475d.b()) {
            m(0);
            t();
            s();
        }
        if (this.f12475d.h()) {
            this.b4 = this.f12475d.d();
            this.c4 = this.f12475d.e();
            this.n4 = this.h4.p(this.f12475d);
            n(this.b4, this.c4);
            postInvalidate();
            this.z.postDelayed(this, 16L);
        }
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.core.AbstractWheelPicker
    public void setCurrentTextColor(int i) {
        super.setCurrentTextColor(i);
        invalidate(this.j4);
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.core.AbstractWheelPicker
    public void setData(List<String> list) {
        super.setData(list);
        r();
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.core.AbstractWheelPicker
    public void setItemCount(int i) {
        super.setItemCount(i);
        r();
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.core.AbstractWheelPicker
    public void setItemSpace(int i) {
        super.setItemSpace(i);
        r();
    }

    public void setOrientation(int i) {
        this.h4 = i == 0 ? new a() : new b();
        b();
        requestLayout();
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.core.AbstractWheelPicker
    public void setTextSize(int i) {
        super.setTextSize(i);
        r();
    }

    public WheelCrossPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
