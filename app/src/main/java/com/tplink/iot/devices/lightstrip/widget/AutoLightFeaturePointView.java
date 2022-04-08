package com.tplink.iot.devices.lightstrip.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: AutoLightFeaturePointView.kt */
/* loaded from: classes2.dex */
public final class AutoLightFeaturePointView extends LightingEffectBaseView {
    private final int M3;
    private final float N3;
    private final Paint O3;
    private int P3;
    private final Paint Q3;
    private final String R3;
    private final TextPaint S3;

    public AutoLightFeaturePointView(Context context) {
        this(context, null, 0, 6, null);
    }

    public AutoLightFeaturePointView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ AutoLightFeaturePointView(Context context, AttributeSet attributeSet, int i, int i2, f fVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final float k(int i) {
        Context context = getContext();
        j.d(context, "context");
        Resources resources = context.getResources();
        j.d(resources, "context.resources");
        return TypedValue.applyDimension(2, i, resources.getDisplayMetrics());
    }

    @Override // com.tplink.iot.devices.lightstrip.widget.LightingEffectBaseView
    public void c(Canvas canvas) {
        j.e(canvas, "canvas");
        float width = getWidth() / 2.0f;
        this.Q3.setColor(this.P3);
        canvas.drawCircle(width, getHeight() / 2.0f, (width - getMHaloWidth()) - getMGapWidth(), this.Q3);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, (((getWidth() - this.N3) / 2.0f) - getMHaloWidth()) - getMGapWidth(), this.O3);
        Paint.FontMetrics fontMetrics = this.S3.getFontMetrics();
        float f2 = fontMetrics.descent;
        float f3 = fontMetrics.ascent;
        canvas.drawText(this.R3, width, ((getHeight() - (f2 - f3)) / 2) - f3, this.S3);
    }

    @Override // com.tplink.iot.devices.lightstrip.widget.LightingEffectBaseView
    protected int getMDefaultSize() {
        return this.M3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoLightFeaturePointView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j.e(context, "context");
        this.M3 = (int) e(48);
        float e2 = e(2);
        this.N3 = e2;
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(e2);
        paint.setColor(536870912);
        p pVar = p.a;
        this.O3 = paint;
        this.P3 = -1;
        this.Q3 = new Paint(1);
        this.R3 = "Auto";
        TextPaint textPaint = new TextPaint(1);
        textPaint.setColor((int) 4281746507L);
        textPaint.setTextSize(k(12));
        textPaint.setTextAlign(Paint.Align.CENTER);
        this.S3 = textPaint;
    }
}
