package com.tplink.iot.widget.colorbulb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
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
public class ColorPointView extends View {
    private Paint H3;
    private int I3;

    /* renamed from: c  reason: collision with root package name */
    private int f11746c;

    /* renamed from: d  reason: collision with root package name */
    private int f11747d;

    /* renamed from: f  reason: collision with root package name */
    private int f11748f;
    private int p0;
    private boolean p1;
    private Paint p2;
    private Bitmap p3;
    private int q;
    private int x;
    private int y;
    private int z;

    public ColorPointView(Context context, int i, int i2, int i3, int i4) {
        this(context);
        this.I3 = i;
        this.f11746c = i2;
        this.f11747d = i3;
        this.f11748f = i4;
    }

    private void a(Context context) {
        Paint paint = new Paint();
        this.p2 = paint;
        paint.setAntiAlias(true);
        this.p2.setFilterBitmap(true);
        if (this.x == -1) {
            this.p3 = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_edit);
        } else {
            this.p3 = BitmapFactory.decodeResource(getResources(), this.x);
        }
        TextPaint textPaint = new TextPaint();
        this.H3 = textPaint;
        textPaint.setAntiAlias(true);
        this.H3.setColor(Color.parseColor("#36444B"));
        this.H3.setTextSize(d(context, 12.0f));
        this.H3.setTextAlign(Paint.Align.CENTER);
    }

    private int d(Context context, float f2) {
        return (int) TypedValue.applyDimension(2, f2, context.getResources().getDisplayMetrics());
    }

    public boolean b() {
        return this.p1;
    }

    public void c(int i, int i2, int i3) {
        this.f11748f = i;
        this.f11747d = i2;
        this.f11746c = i3;
        invalidate();
    }

    public int getInnerCircleColor() {
        return this.f11748f;
    }

    public int getOutRingColor() {
        return this.f11746c;
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.p2.setStyle(Paint.Style.STROKE);
        this.p2.setStrokeWidth(8.0f);
        this.p2.setColor(this.f11747d);
        canvas.drawCircle(this.z, this.p0, this.y - 20, this.p2);
        this.p2.setStyle(Paint.Style.FILL);
        this.p2.setColor(this.f11748f);
        canvas.drawCircle(this.z, this.p0, this.y - 20, this.p2);
        int i = this.q;
        if (i == 1) {
            canvas.drawText("Auto", this.z, (int) (((getHeight() - (this.H3.descent() - this.H3.ascent())) / 2.0f) - this.H3.ascent()), this.H3);
        } else if ((i == 2 && b()) || this.q == 3) {
            canvas.drawBitmap(this.p3, (getWidth() - this.p3.getWidth()) / 2, (getHeight() - this.p3.getHeight()) / 2, this.p2);
        }
        if (this.p1) {
            this.p2.setStyle(Paint.Style.STROKE);
            this.p2.setStrokeWidth(6.0f);
            this.p2.setColor(this.f11746c);
            canvas.drawCircle(this.z, this.p0, this.y - 6, this.p2);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 0 || mode == Integer.MIN_VALUE || mode2 == 0 || mode2 == Integer.MIN_VALUE) {
            size = this.I3;
            if (size == 0) {
                size = b.a(getContext(), 44.0d);
            }
            size2 = size;
        }
        Bitmap bitmap = this.p3;
        if (bitmap != null && size < bitmap.getWidth() && this.q == 2) {
            size = this.p3.getWidth() + b.a(getContext(), 16.0d);
            size2 = size;
        }
        int max = Math.max(size, size2);
        setMeasuredDimension(max, max);
        int i3 = max / 2;
        this.p0 = i3;
        this.z = i3;
        this.y = i3;
    }

    public void setInnerCircleColor(int i) {
        this.f11748f = i;
        invalidate();
    }

    public void setOutRingColor(int i) {
        this.f11746c = i;
    }

    public void setOutlineColor(int i) {
        this.f11747d = i;
        invalidate();
    }

    public void setSelectedStatus(boolean z) {
        this.p1 = z;
        invalidate();
    }

    public void setType(int i) {
        this.q = i;
        invalidate();
    }

    public ColorPointView(Context context, int i, int i2, int i3) {
        this(context);
        this.I3 = i;
        this.f11746c = i2;
        this.f11748f = i3;
    }

    public ColorPointView(Context context) {
        this(context, null);
    }

    public ColorPointView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColorPointView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11746c = 1821695;
        this.f11747d = -1315861;
        this.f11748f = -1;
        this.q = 0;
        this.x = -1;
        this.p1 = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tplink.iot.b.ColorPointView, i, 0);
        if (obtainStyledAttributes != null) {
            this.f11746c = obtainStyledAttributes.getColor(3, this.f11746c);
            this.f11747d = obtainStyledAttributes.getColor(4, this.f11747d);
            this.f11748f = obtainStyledAttributes.getColor(1, this.f11748f);
            this.q = obtainStyledAttributes.getInt(0, this.q);
            this.x = obtainStyledAttributes.getResourceId(2, -1);
            obtainStyledAttributes.recycle();
        }
        a(context);
    }
}
