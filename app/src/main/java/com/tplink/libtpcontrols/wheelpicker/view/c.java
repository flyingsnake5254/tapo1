package com.tplink.libtpcontrols.wheelpicker.view;

import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.text.TextPaint;
import android.view.VelocityTracker;
import com.tplink.libtpcontrols.wheelpicker.core.d;

/* compiled from: ICrossOrientation.java */
/* loaded from: classes3.dex */
interface c {
    void a(d dVar, int i, int i2);

    int b(int i, int i2, int i3, int i4);

    void c();

    void d(Rect rect, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11);

    int e(int i, int i2, int i3, int i4);

    int f(int i, int i2, int i3);

    int g(int i, int i2, int i3);

    void h(Rect rect, Rect rect2, Rect rect3, int i, int i2, int i3, int i4);

    int i(int i, int i2, int i3);

    int j(int i, int i2, int i3, int i4, int i5, int i6);

    void k(Canvas canvas, TextPaint textPaint, String str, int i, int i2, int i3);

    void l(d dVar, VelocityTracker velocityTracker, int i, int i2, int i3, int i4);

    void m(Camera camera, int i);

    int n(int i, int i2, int i3);

    void o(Rect rect, int i, int i2, int i3, int i4);

    int p(d dVar);

    int q(int i, int i2, int i3, int i4);

    int r(int i, int i2);

    int s(int i, int i2, int i3, int i4);

    void t(Matrix matrix, int i, int i2, int i3);

    int u(int i, int i2);
}
