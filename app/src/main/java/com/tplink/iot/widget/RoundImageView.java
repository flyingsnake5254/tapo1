package com.tplink.iot.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import b.d.w.c.a;

/* loaded from: classes3.dex */
public class RoundImageView extends AppCompatImageView {

    /* renamed from: c  reason: collision with root package name */
    float f11593c;

    /* renamed from: d  reason: collision with root package name */
    float f11594d;

    /* renamed from: f  reason: collision with root package name */
    Path f11595f;
    float q;

    public RoundImageView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            float f2 = this.f11593c;
            float f3 = this.q;
            if (f2 > f3 && this.f11594d > f3) {
                this.f11595f.moveTo(f3, 0.0f);
                this.f11595f.lineTo(this.f11593c - this.q, 0.0f);
                Path path = this.f11595f;
                float f4 = this.f11593c;
                path.quadTo(f4, 0.0f, f4, this.q);
                this.f11595f.lineTo(this.f11593c, this.f11594d - this.q);
                Path path2 = this.f11595f;
                float f5 = this.f11593c;
                float f6 = this.f11594d;
                path2.quadTo(f5, f6, f5 - this.q, f6);
                this.f11595f.lineTo(this.q, this.f11594d);
                Path path3 = this.f11595f;
                float f7 = this.f11594d;
                path3.quadTo(0.0f, f7, 0.0f, f7 - this.q);
                this.f11595f.lineTo(0.0f, this.q);
                this.f11595f.quadTo(0.0f, 0.0f, this.q, 0.0f);
                canvas.clipPath(this.f11595f);
            }
            super.onDraw(canvas);
        } catch (Exception unused) {
            a.a("onDraw Exception");
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f11593c = getWidth();
        this.f11594d = getHeight();
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11595f = new Path();
        this.q = b.d.w.f.a.a(context, 10.0f);
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }
}
