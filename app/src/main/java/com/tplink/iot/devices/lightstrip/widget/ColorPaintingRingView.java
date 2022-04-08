package com.tplink.iot.devices.lightstrip.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.tplink.iot.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: ColorPaintingRingView.kt */
/* loaded from: classes2.dex */
public final class ColorPaintingRingView extends LightingEffectBaseView {
    private float M3;
    private final float N3;
    private final RectF O3;
    private final Paint P3;
    private final Paint Q3;
    private final List<Pair<Integer, Float>> R3;

    public ColorPaintingRingView(Context context) {
        this(context, null, 0, 6, null);
    }

    public ColorPaintingRingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ColorPaintingRingView(Context context, AttributeSet attributeSet, int i, int i2, f fVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void l() {
        float mHaloWidth = (this.M3 / 2.0f) + getMHaloWidth() + getMGapWidth();
        this.O3.set(mHaloWidth, mHaloWidth, getWidth() - mHaloWidth, getHeight() - mHaloWidth);
    }

    @Override // com.tplink.iot.devices.lightstrip.widget.LightingEffectBaseView
    public void c(Canvas canvas) {
        j.e(canvas, "canvas");
        l();
        this.P3.setStrokeWidth(this.M3);
        float f2 = -90.0f;
        for (Pair<Integer, Float> pair : this.R3) {
            float floatValue = pair.getSecond().floatValue() * 360.0f;
            RectF rectF = this.O3;
            Paint paint = this.P3;
            paint.setColor(pair.getFirst().intValue());
            p pVar = p.a;
            canvas.drawArc(rectF, f2, floatValue, false, paint);
            f2 += floatValue;
        }
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, (((getWidth() - this.N3) / 2.0f) - getMHaloWidth()) - getMGapWidth(), this.Q3);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, ((((getWidth() + this.N3) / 2.0f) - getMHaloWidth()) - getMGapWidth()) - this.M3, this.Q3);
    }

    public final float getRingWidth() {
        return this.M3;
    }

    public final void k(List<Integer> colors, List<Integer> parts) {
        j.e(colors, "colors");
        j.e(parts, "parts");
        if (!(colors.isEmpty() || parts.isEmpty())) {
            this.R3.clear();
            int min = Math.min(colors.size(), parts.size());
            Iterator<T> it = parts.subList(0, min).iterator();
            if (it.hasNext()) {
                Object next = it.next();
                while (it.hasNext()) {
                    next = Integer.valueOf(((Number) next).intValue() + ((Number) it.next()).intValue());
                }
                int intValue = ((Number) next).intValue();
                for (int i = 0; i < min; i++) {
                    this.R3.add(new Pair<>(colors.get(i), Float.valueOf(parts.get(i).floatValue() / intValue)));
                }
                invalidate();
                return;
            }
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
    }

    public final void setRingWidth(float f2) {
        this.M3 = f2;
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ColorPaintingRingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j.e(context, "context");
        this.M3 = e(10);
        float e2 = e(2);
        this.N3 = e2;
        this.O3 = new RectF();
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.M3);
        paint.setStrokeCap(Paint.Cap.BUTT);
        p pVar = p.a;
        this.P3 = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(e2);
        paint2.setColor(369098752);
        this.Q3 = paint2;
        this.R3 = new ArrayList();
        setLayerType(1, null);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.ColorPaintingRingView);
        this.M3 = obtainStyledAttributes.getDimension(0, this.M3);
        obtainStyledAttributes.recycle();
    }
}
