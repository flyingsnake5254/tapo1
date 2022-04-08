package com.tplink.iot.devices.lightstrip.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: ColorEffectPlateView.kt */
/* loaded from: classes2.dex */
public final class ColorEffectPlateView extends LightingEffectBaseView {
    private final float M3;
    private final RectF N3;
    private final Paint O3;
    private final Paint P3;
    private final List<Integer> Q3;

    public ColorEffectPlateView(Context context) {
        this(context, null, 0, 6, null);
    }

    public ColorEffectPlateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ColorEffectPlateView(Context context, AttributeSet attributeSet, int i, int i2, f fVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void l() {
        float mHaloWidth = getMHaloWidth() + getMGapWidth();
        this.N3.set(mHaloWidth, mHaloWidth, getWidth() - mHaloWidth, getHeight() - mHaloWidth);
    }

    @Override // com.tplink.iot.devices.lightstrip.widget.LightingEffectBaseView
    public void c(Canvas canvas) {
        j.e(canvas, "canvas");
        l();
        if (!this.Q3.isEmpty()) {
            float size = 360.0f / this.Q3.size();
            int size2 = this.Q3.size();
            for (int i = 0; i < size2; i++) {
                this.O3.setColor(this.Q3.get(i).intValue());
                canvas.drawArc(this.N3, (i * size) - 90.0f, size, true, this.O3);
            }
        }
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, (((getWidth() - this.M3) / 2.0f) - getMHaloWidth()) - getMGapWidth(), this.P3);
    }

    public final void k(List<Integer> colors) {
        j.e(colors, "colors");
        this.Q3.clear();
        if (!colors.isEmpty()) {
            this.Q3.addAll(colors);
        } else {
            this.Q3.add(-1);
        }
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ColorEffectPlateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j.e(context, "context");
        float e2 = e(2);
        this.M3 = e2;
        this.N3 = new RectF();
        this.O3 = new Paint(1);
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(e2);
        paint.setColor(536870912);
        p pVar = p.a;
        this.P3 = paint;
        this.Q3 = new ArrayList();
    }
}
