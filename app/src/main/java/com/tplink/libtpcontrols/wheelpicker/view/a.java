package com.tplink.libtpcontrols.wheelpicker.view;

import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.text.TextPaint;
import android.view.VelocityTracker;
import com.tplink.libtpcontrols.wheelpicker.core.d;
import java.util.HashMap;

/* compiled from: CrossHorImpl.java */
/* loaded from: classes3.dex */
class a implements c {
    private final HashMap<Integer, Integer> a = new HashMap<>();

    @Override // com.tplink.libtpcontrols.wheelpicker.view.c
    public void a(d dVar, int i, int i2) {
        dVar.c(i, 0, i2, 0, 300);
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.view.c
    public int b(int i, int i2, int i3, int i4) {
        return (int) ((((i + 1) * i3) + ((i - 1) * i2)) / 3.141592653589793d);
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.view.c
    public void c() {
        this.a.clear();
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.view.c
    public void d(Rect rect, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        int i12 = (i4 + i) / 2;
        rect.set(i6 - i12, 0, i6 + i12, i3);
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.view.c
    public int e(int i, int i2, int i3, int i4) {
        return i4;
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.view.c
    public int f(int i, int i2, int i3) {
        return i2 + i;
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.view.c
    public int g(int i, int i2, int i3) {
        return i3;
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.view.c
    public void h(Rect rect, Rect rect2, Rect rect3, int i, int i2, int i3, int i4) {
        rect.set(rect3.left, 0, rect3.right, i2);
        int i5 = rect3.left;
        int i6 = rect3.bottom;
        rect2.set(i5, i6 - i4, rect3.right, i6);
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.view.c
    public int i(int i, int i2, int i3) {
        return i * 2;
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.view.c
    public int j(int i, int i2, int i3, int i4, int i5, int i6) {
        return (i * i2) + i3 + i5;
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.view.c
    public void k(Canvas canvas, TextPaint textPaint, String str, int i, int i2, int i3) {
        canvas.drawText(str, i2 + i, i3, textPaint);
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.view.c
    public void l(d dVar, VelocityTracker velocityTracker, int i, int i2, int i3, int i4) {
        dVar.a(i, 0, (int) velocityTracker.getXVelocity(), 0, i2, i3, 0, 0, i4, 0);
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.view.c
    public void m(Camera camera, int i) {
        camera.rotateY(i);
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.view.c
    public int n(int i, int i2, int i3) {
        if (this.a.containsKey(Integer.valueOf(i))) {
            return this.a.get(Integer.valueOf(i)).intValue();
        }
        int degrees = (int) Math.toDegrees(Math.asin((i * 1.0d) / i3));
        this.a.put(Integer.valueOf(i), Integer.valueOf(degrees));
        return degrees;
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.view.c
    public void o(Rect rect, int i, int i2, int i3, int i4) {
        rect.set(rect.left, rect.top + i2, rect.right, rect.bottom - i4);
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.view.c
    public int p(d dVar) {
        return dVar.d();
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.view.c
    public int q(int i, int i2, int i3, int i4) {
        return ((i / 2) + 1) * (i3 + i2);
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.view.c
    public int r(int i, int i2) {
        return i;
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.view.c
    public int s(int i, int i2, int i3, int i4) {
        return (i3 * i) + ((i - 1) * i2);
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.view.c
    public void t(Matrix matrix, int i, int i2, int i3) {
        int i4 = i2 + i;
        matrix.preTranslate(-i4, -i3);
        matrix.postTranslate(i4, i3);
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.view.c
    public int u(int i, int i2) {
        return i;
    }
}
