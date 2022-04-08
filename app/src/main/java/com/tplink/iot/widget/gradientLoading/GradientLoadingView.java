package com.tplink.iot.widget.gradientLoading;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.tplink.iot.R;

/* loaded from: classes3.dex */
public class GradientLoadingView extends View {

    /* renamed from: d  reason: collision with root package name */
    private Matrix f11814d;
    private float[] p0;
    private int q;
    private int x;
    private RectF y;
    private int[] z;

    /* renamed from: c  reason: collision with root package name */
    private LinearGradient f11813c = null;

    /* renamed from: f  reason: collision with root package name */
    private Paint f11815f = null;
    private int p1 = 0;
    private boolean p2 = true;

    public GradientLoadingView(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        this.f11815f = new Paint();
        this.f11814d = new Matrix();
        int color = context.getResources().getColor(R.color.gradient_start_color);
        int color2 = context.getResources().getColor(R.color.gradient_end_color);
        this.z = new int[]{color2, color, color2};
        this.p0 = new float[]{0.0f, 0.5f, 1.0f};
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.p2) {
            int i = this.p1 + 20;
            this.p1 = i;
            if (i > this.x * 2) {
                this.p1 = 0;
            }
            this.f11814d.setTranslate(this.p1, 0.0f);
            this.f11813c.setLocalMatrix(this.f11814d);
            this.f11815f.setShader(this.f11813c);
            this.f11815f.setAntiAlias(true);
            float f2 = this.q * 2;
            canvas.drawRoundRect(this.y, f2, f2, this.f11815f);
            postInvalidateDelayed(10L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.x = i3 - i;
        this.q = i4 - i2;
        this.f11813c = new LinearGradient(-this.x, 0.0f, 0.0f, 0.0f, this.z, this.p0, Shader.TileMode.CLAMP);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.y = new RectF(0.0f, 0.0f, i, i2);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.p2 = i == 0;
    }

    public GradientLoadingView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public GradientLoadingView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
