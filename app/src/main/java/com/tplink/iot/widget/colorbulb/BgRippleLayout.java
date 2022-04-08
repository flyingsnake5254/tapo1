package com.tplink.iot.widget.colorbulb;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public class BgRippleLayout extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    private Path f11728c;

    /* renamed from: d  reason: collision with root package name */
    private float f11729d;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11730f;
    private boolean q;

    public BgRippleLayout(@NonNull Context context) {
        this(context, null);
    }

    private void a() {
        this.f11728c = new Path();
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        if (!this.q) {
            return super.drawChild(canvas, view, j);
        }
        int width = getWidth();
        int height = getHeight();
        int save = canvas.save();
        this.f11728c.reset();
        if (this.f11730f) {
            float f2 = height;
            this.f11728c.lineTo(0.0f, f2);
            this.f11728c.lineTo(0.0f, this.f11729d);
            Path path = this.f11728c;
            float f3 = this.f11729d;
            float f4 = width;
            path.cubicTo(0.0f, f3, width / 2, f3 - 150.0f, f4, f3);
            this.f11728c.lineTo(f4, f2);
            this.f11728c.lineTo(0.0f, f2);
        } else {
            this.f11728c.lineTo(0.0f, 0.0f);
            float f5 = width;
            this.f11728c.lineTo(f5, 0.0f);
            this.f11728c.lineTo(f5, this.f11729d);
            Path path2 = this.f11728c;
            float f6 = this.f11729d;
            path2.cubicTo(f5, f6, width / 2, f6 - 150.0f, 0.0f, f6);
            this.f11728c.lineTo(0.0f, 0.0f);
        }
        canvas.clipPath(this.f11728c);
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        return drawChild;
    }

    @Keep
    public void setAnimValue(float f2) {
        setAlpha(f2);
        if (this.f11730f) {
            f2 = 1.0f - f2;
        }
        this.f11729d = f2 * getHeight();
        invalidate();
    }

    public void setOn(boolean z) {
        this.f11730f = z;
    }

    public void setRunning(boolean z) {
        this.q = z;
    }

    public BgRippleLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BgRippleLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
