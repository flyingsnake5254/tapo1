package com.tplink.libtpcontrols.wheelpicker.view;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.MotionEvent;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class WheelCurvedPicker extends WheelCrossPicker {
    private int A4;
    private final HashMap<Integer, Integer> s4 = new HashMap<>();
    private final HashMap<Integer, Integer> t4 = new HashMap<>();
    private final Camera u4 = new Camera();
    private final Matrix v4 = new Matrix();
    private final Matrix w4 = new Matrix();
    private int x4;
    private int y4;
    private int z4;

    public WheelCurvedPicker(Context context) {
        super(context);
    }

    private int v(int i) {
        if (this.t4.containsKey(Integer.valueOf(i))) {
            return this.t4.get(Integer.valueOf(i)).intValue();
        }
        int cos = (int) (this.x4 - (Math.cos(Math.toRadians(i)) * this.x4));
        this.t4.put(Integer.valueOf(i), Integer.valueOf(cos));
        return cos;
    }

    private int w(int i) {
        if (this.s4.containsKey(Integer.valueOf(i))) {
            return this.s4.get(Integer.valueOf(i)).intValue();
        }
        int sin = (int) (Math.sin(Math.toRadians(i)) * this.x4);
        this.s4.put(Integer.valueOf(i), Integer.valueOf(sin));
        return sin;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.libtpcontrols.wheelpicker.core.AbstractWheelPicker
    public void b() {
        super.b();
        int b2 = this.h4.b(this.I3, this.K3, this.Q3, this.R3);
        this.x4 = b2;
        this.m4 = (int) (180.0f / (this.I3 + 1));
        this.S3 = this.h4.i(b2, this.Q3, this.R3);
        this.T3 = this.h4.g(this.x4, this.Q3, this.R3);
        this.q4 = -90;
        this.r4 = 90;
        int size = this.p2.size();
        int i = this.J3;
        this.o4 = (-this.m4) * ((size - i) - 1);
        this.p4 = this.m4 * i;
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.core.AbstractWheelPicker
    protected void e(Canvas canvas) {
        for (int i = -this.J3; i < this.p2.size() - this.J3; i++) {
            int i2 = (this.m4 * i) + this.n4 + this.y4;
            if (i2 <= this.r4 && i2 >= this.q4) {
                int w = w(i2);
                if (w == 0) {
                    i2 = 1;
                }
                int v = v(i2);
                this.u4.save();
                this.h4.m(this.u4, i2);
                this.u4.getMatrix(this.v4);
                this.u4.restore();
                this.h4.t(this.v4, w, this.U3, this.V3);
                this.u4.save();
                this.u4.translate(0.0f, 0.0f, v);
                this.u4.getMatrix(this.w4);
                this.u4.restore();
                this.h4.t(this.w4, w, this.U3, this.V3);
                this.v4.postConcat(this.w4);
                canvas.save();
                canvas.concat(this.v4);
                canvas.clipRect(this.j4, Region.Op.DIFFERENCE);
                this.f12476f.setColor(this.N3);
                this.f12476f.setAlpha(255 - ((Math.abs(i2) * 255) / this.r4));
                this.h4.k(canvas, this.f12476f, this.p2.get(this.J3 + i), w, this.U3, this.W3);
                canvas.restore();
                canvas.save();
                canvas.clipRect(this.j4);
                this.f12476f.setColor(this.P3);
                this.h4.k(canvas, this.f12476f, this.p2.get(this.J3 + i), w, this.U3, this.W3);
                canvas.restore();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.libtpcontrols.wheelpicker.view.WheelCrossPicker, com.tplink.libtpcontrols.wheelpicker.core.AbstractWheelPicker
    public void k(MotionEvent motionEvent) {
        this.A4 = this.h4.n(this.Z3, this.a4, this.x4);
        int r = this.h4.r(this.Z3, this.a4);
        if (Math.abs(r) >= this.x4) {
            if (r >= 0) {
                this.z4++;
            } else {
                this.z4--;
            }
            this.Z3 = 0;
            this.a4 = 0;
            this.A4 = 0;
        }
        this.y4 = (this.z4 * 80) + this.A4;
        super.k(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.libtpcontrols.wheelpicker.view.WheelCrossPicker, com.tplink.libtpcontrols.wheelpicker.core.AbstractWheelPicker
    public void l(MotionEvent motionEvent) {
        this.n4 += this.y4;
        this.y4 = 0;
        this.A4 = 0;
        this.z4 = 0;
        super.l(motionEvent);
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.view.WheelCrossPicker
    public void r() {
        this.s4.clear();
        this.t4.clear();
        this.h4.c();
    }

    public WheelCurvedPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
