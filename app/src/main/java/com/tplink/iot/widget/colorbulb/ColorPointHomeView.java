package com.tplink.iot.widget.colorbulb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.Nullable;
import com.tplink.iot.R;
import net.lucode.hackware.magicindicator.g.b;

/* loaded from: classes3.dex */
public class ColorPointHomeView extends View {
    private int H3;

    /* renamed from: c  reason: collision with root package name */
    private int f11743c;

    /* renamed from: d  reason: collision with root package name */
    private int f11744d;

    /* renamed from: f  reason: collision with root package name */
    private int f11745f;
    private boolean p0;
    private Paint p1;
    private Bitmap p2;
    private Paint p3;
    private int q;
    private int x;
    private int y;
    private int z;

    public ColorPointHomeView(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        Paint paint = new Paint();
        this.p1 = paint;
        paint.setAntiAlias(true);
        this.p1.setFilterBitmap(true);
        this.p2 = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_edit);
        TextPaint textPaint = new TextPaint();
        this.p3 = textPaint;
        textPaint.setAntiAlias(true);
        this.p3.setColor(Color.parseColor("#36444B"));
        this.p3.setTextSize(b(context, 12.0f));
        this.p3.setTextAlign(Paint.Align.CENTER);
    }

    private int b(Context context, float f2) {
        return (int) TypedValue.applyDimension(2, f2, context.getResources().getDisplayMetrics());
    }

    public int getInnerCircleColor() {
        return this.f11745f;
    }

    public int getOutRingColor() {
        return this.f11743c;
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.p1.setStyle(Paint.Style.STROKE);
        this.p1.setStrokeWidth(8.0f);
        this.p1.setColor(this.f11744d);
        canvas.drawCircle(this.y, this.z, this.x - 8, this.p1);
        this.p1.setStyle(Paint.Style.FILL);
        this.p1.setColor(this.f11745f);
        canvas.drawCircle(this.y, this.z, this.x - 8, this.p1);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 0 || mode == Integer.MIN_VALUE || mode2 == 0 || mode2 == Integer.MIN_VALUE) {
            size = this.H3;
            if (size == 0) {
                size = b.a(getContext(), 44.0d);
            }
            size2 = size;
        }
        Bitmap bitmap = this.p2;
        if (bitmap != null && size < bitmap.getWidth() && this.q == 2) {
            size = this.p2.getWidth() + b.a(getContext(), 16.0d);
            size2 = size;
        }
        int max = Math.max(size, size2);
        setMeasuredDimension(max, max);
        int i3 = max / 2;
        this.z = i3;
        this.y = i3;
        this.x = i3;
    }

    public void setInnerCircleColor(int i) {
        this.f11745f = i;
        invalidate();
    }

    public void setOutRingColor(int i) {
        this.f11743c = i;
    }

    public void setOutlineColor(int i) {
        this.f11744d = i;
        invalidate();
    }

    public void setSelectedStatus(boolean z) {
        this.p0 = z;
        invalidate();
    }

    public void setType(int i) {
        this.q = i;
        invalidate();
    }

    public ColorPointHomeView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColorPointHomeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11743c = 1821695;
        this.f11744d = -1;
        this.f11745f = -1;
        this.q = 0;
        this.p0 = false;
        a(context);
    }
}
