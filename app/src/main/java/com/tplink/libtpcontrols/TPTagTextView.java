package com.tplink.libtpcontrols;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.text.TextUtilsCompat;

/* loaded from: classes3.dex */
public class TPTagTextView extends AppCompatTextView {

    /* renamed from: c  reason: collision with root package name */
    private Paint f12167c;

    /* renamed from: d  reason: collision with root package name */
    private int f12168d;

    /* renamed from: f  reason: collision with root package name */
    private int f12169f;
    private int q;
    private int x;
    private int y;
    private int z;

    public TPTagTextView(Context context) {
        this(context, null, 0);
    }

    private int b(float f2) {
        return (int) ((f2 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void c(Canvas canvas) {
        this.f12167c.setStyle(Paint.Style.STROKE);
        Path path = new Path();
        int i = this.f12168d;
        path.moveTo(i, i);
        path.lineTo(this.f12168d, getHeight() - this.f12168d);
        path.lineTo(getWidth() - this.f12168d, getHeight() - this.f12168d);
        int width = getWidth();
        int i2 = this.f12168d;
        path.lineTo(width - i2, i2);
        path.close();
        canvas.drawPath(path, this.f12167c);
    }

    private void d(Canvas canvas) {
        this.f12167c.setStyle(Paint.Style.STROKE);
        Path path = new Path();
        if (f()) {
            path.moveTo(this.f12168d, getHeight() / 2.0f);
            int i = this.f12168d;
            path.lineTo((getHeight() / 2.0f) + i, i);
            path.lineTo(getWidth(), this.f12168d);
            path.lineTo(getWidth(), getHeight() - this.f12168d);
            path.lineTo((getHeight() / 2.0f) + this.f12168d, getHeight() - this.f12168d);
            path.close();
        } else {
            int i2 = this.f12168d;
            path.moveTo(i2, i2);
            path.lineTo(this.f12168d, getHeight() - this.f12168d);
            path.lineTo((getWidth() - (getHeight() / 2.0f)) - this.f12168d, getHeight() - this.f12168d);
            path.lineTo(getWidth() - this.f12168d, getHeight() / 2.0f);
            float width = getWidth() - (getHeight() / 2.0f);
            int i3 = this.f12168d;
            path.lineTo(width - i3, i3);
            path.close();
        }
        canvas.drawPath(path, this.f12167c);
        this.f12167c.setStyle(Paint.Style.FILL);
        if (f()) {
            canvas.drawCircle(getHeight() * 0.4f, getHeight() / 2.0f, b(1.0f), this.f12167c);
        } else {
            canvas.drawCircle(getWidth() - (getHeight() * 0.4f), getHeight() / 2.0f, b(1.0f), this.f12167c);
        }
    }

    private void e(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x0.TPTagTextView);
        int color = obtainStyledAttributes.getColor(x0.TPTagTextView_tt_border_color, ContextCompat.getColor(context, p0.common_tplink_light_gray));
        this.f12169f = obtainStyledAttributes.getInt(x0.TPTagTextView_tt_tag_style, 0);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, new int[]{16842965, 16843699, 16842967, 16843700, 16842969});
        int dimensionPixelSize = obtainStyledAttributes2.getDimensionPixelSize(0, 0);
        this.q = obtainStyledAttributes2.getDimensionPixelSize(1, dimensionPixelSize);
        this.y = obtainStyledAttributes2.getDimensionPixelSize(2, dimensionPixelSize);
        this.x = obtainStyledAttributes2.getDimensionPixelSize(3, dimensionPixelSize);
        this.z = obtainStyledAttributes2.getDimensionPixelSize(4, dimensionPixelSize);
        this.f12168d = b(1.0f);
        Paint paint = new Paint();
        this.f12167c = paint;
        paint.setFlags(1);
        this.f12167c.setColor(color);
        this.f12167c.setStrokeWidth(color);
        obtainStyledAttributes2.recycle();
        obtainStyledAttributes.recycle();
    }

    protected boolean f() {
        return TextUtilsCompat.getLayoutDirectionFromLocale(getContext().getResources().getConfiguration().locale) == 1;
    }

    public int getTextPaddingBottom() {
        return this.z;
    }

    public int getTextPaddingEnd() {
        return this.x;
    }

    public int getTextPaddingStart() {
        return this.q;
    }

    public int getTextPaddingTop() {
        return this.y;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.f12169f;
        if (i == 0) {
            d(canvas);
        } else if (1 == i) {
            c(canvas);
        }
    }

    public void setTagStyle(int i) {
        if (i > 1 || i < 0) {
            i = 0;
        }
        this.f12169f = i;
        postInvalidate();
    }

    public TPTagTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TPTagTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        e(context, attributeSet);
    }
}
