package com.tplink.iot.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import com.tplink.iot.R;
import com.tplink.iot.b;

/* loaded from: classes3.dex */
public class ProgressBarButton extends AppCompatButton {
    private int H3;
    private int I3;
    private float J3;
    private Matrix K3;

    /* renamed from: c  reason: collision with root package name */
    private int f11586c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f11587d;

    /* renamed from: f  reason: collision with root package name */
    private PorterDuffXfermode f11588f;
    private int p0;
    private int p1;
    private int p2;
    private int p3;
    private RectF q;
    private RectF x;
    private int y;
    private int z;

    public ProgressBarButton(Context context) {
        this(context, null);
    }

    private int a(float f2) {
        return (int) ((getContext().getResources().getDisplayMetrics().density * f2) + 0.5f);
    }

    private int b(int i) {
        if (i == 0) {
            return this.p1;
        }
        if (i == 1) {
            return this.p2;
        }
        if (i == 2) {
            return this.p3;
        }
        if (i == 4) {
            return this.H3;
        }
        return this.I3;
    }

    private void c() {
        Paint paint = new Paint(1);
        this.f11587d = paint;
        paint.setColor(this.f11586c);
        this.f11587d.setAntiAlias(true);
        this.f11587d.setStyle(Paint.Style.FILL);
        this.f11588f = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        setGravity(17);
        this.K3 = new Matrix();
    }

    public void d(int i, String str) {
        this.z = i;
        invalidate();
        g(str, b(i));
    }

    public void e() {
        TextPaint paint = getPaint();
        String string = getContext().getString(R.string.fw_installing);
        String string2 = getContext().getString(R.string.update_again);
        String string3 = getContext().getString(R.string.up_to_date);
        float max = Math.max(paint.measureText(getContext().getString(R.string.common_waiting)), Math.max(paint.measureText(string3), Math.max(paint.measureText(string), paint.measureText(string2)))) + a(28.0f);
        float a = a(84.0f);
        if (max < a) {
            max = a;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = (int) max;
        setLayoutParams(layoutParams);
    }

    public void f(int i, String str) {
        this.z = 1;
        this.p0 = i;
        invalidate();
        g(str, this.p2);
    }

    public void g(String str, int i) {
        setTextColor(i);
        setText(str);
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        float height = this.q.height();
        float width = this.q.width();
        if (height >= 0.0f && width >= 0.0f) {
            float f2 = (float) (height / 2.0d);
            float height2 = (float) (this.x.height() / 2.0d);
            this.f11587d.setShader(null);
            int i = this.z;
            if (i != 0) {
                if (i == 1) {
                    float f3 = width - ((int) (((this.p0 * 1.0d) / 100.0d) * width));
                    LinearGradient linearGradient = new LinearGradient(f3, 0.0f, width, 0.0f, new int[]{this.f11586c, -13155590}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
                    int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
                    if (this.y == 0) {
                        this.f11587d.setColor(this.f11586c);
                        canvas.drawRoundRect(this.q, f2, f2, this.f11587d);
                        this.f11587d.setColor(-1);
                        canvas.drawRoundRect(this.x, height2, height2, this.f11587d);
                    } else {
                        this.f11587d.setColor(-4000518);
                        canvas.drawRoundRect(this.q, f2, f2, this.f11587d);
                    }
                    this.f11587d.setXfermode(this.f11588f);
                    this.f11587d.setShader(linearGradient);
                    canvas.save();
                    canvas.translate(-f3, 0.0f);
                    canvas.drawRoundRect(this.q, f2, f2, this.f11587d);
                    canvas.restore();
                    canvas.restoreToCount(saveLayer);
                    this.f11587d.setXfermode(null);
                } else if (i == 2) {
                    float f4 = this.J3;
                    float f5 = width / 30.0f;
                    float f6 = f4 + f5 > 2.0f * width ? 0.0f : f4 + f5;
                    this.J3 = f6;
                    this.K3.setTranslate(f6, 0.0f);
                    int i2 = this.f11586c;
                    LinearGradient linearGradient2 = new LinearGradient(-width, 0.0f, 0.0f, 0.0f, new int[]{i2, -13155590, i2}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
                    linearGradient2.setLocalMatrix(this.K3);
                    this.f11587d.setShader(linearGradient2);
                    canvas.drawRoundRect(this.q, f2, f2, this.f11587d);
                    postInvalidateDelayed(10L);
                } else if (i == 3) {
                    this.f11587d.setColor(-1);
                    canvas.drawRoundRect(this.q, f2, f2, this.f11587d);
                } else if (i == 4) {
                    this.f11587d.setColor(-7829368);
                    canvas.drawRoundRect(this.q, f2, f2, this.f11587d);
                }
            } else if (this.y == 0) {
                this.f11587d.setColor(this.f11586c);
                canvas.drawRoundRect(this.q, f2, f2, this.f11587d);
                this.f11587d.setColor(-1);
                canvas.drawRoundRect(this.x, height2, height2, this.f11587d);
            } else {
                this.f11587d.setColor(this.f11586c);
                canvas.drawRoundRect(this.q, f2, f2, this.f11587d);
            }
            setClickable(this.z == 0);
            super.onDraw(canvas);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.q = new RectF(0.0f, 0.0f, i, i2);
        this.x = new RectF(4.0f, 4.0f, i - 4, i2 - 4);
    }

    public void setType(int i) {
        this.y = i;
        invalidate();
    }

    public ProgressBarButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProgressBarButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11586c = -14955521;
        this.y = 0;
        this.z = 0;
        this.J3 = 0.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.ProgressBarButton, i, 0);
        if (obtainStyledAttributes != null) {
            this.y = obtainStyledAttributes.getInteger(4, 0);
            this.p1 = obtainStyledAttributes.getColor(0, this.f11586c);
            this.p2 = obtainStyledAttributes.getColor(2, this.f11586c);
            this.p3 = obtainStyledAttributes.getColor(1, this.f11586c);
            this.H3 = obtainStyledAttributes.getColor(5, this.f11586c);
            this.I3 = obtainStyledAttributes.getColor(3, this.f11586c);
            obtainStyledAttributes.recycle();
        }
        c();
    }
}
