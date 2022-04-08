package com.tplink.libtpcontrols.mapmarks;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.tplink.libtpcontrols.p0;

/* loaded from: classes3.dex */
public class CustomCircleView extends View {

    /* renamed from: c  reason: collision with root package name */
    private int f12311c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f12312d;

    /* renamed from: f  reason: collision with root package name */
    private float f12313f;
    private float q;
    private float x;

    public CustomCircleView(Context context) {
        super(context);
    }

    private void a(Context context) {
        this.f12311c = ContextCompat.getColor(context, p0.teal_transparency_30);
        Paint paint = new Paint();
        this.f12312d = paint;
        paint.setColor(this.f12311c);
        this.f12312d.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.f12313f, this.q, this.x, this.f12312d);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(size, size2);
        this.f12313f = size / 2.0f;
        this.q = size2 / 2.0f;
    }

    public void setCircleRadius(float f2) {
        this.x = f2;
        postInvalidate();
    }

    public CustomCircleView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public CustomCircleView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
