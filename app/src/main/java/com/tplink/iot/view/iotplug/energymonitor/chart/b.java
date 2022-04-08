package com.tplink.iot.view.iotplug.energymonitor.chart;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.renderer.LineChartRenderer;
import com.github.mikephil.charting.utils.ViewPortHandler;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: PowerLineChartRenderer.kt */
/* loaded from: classes2.dex */
public final class b extends LineChartRenderer {
    private final String a = "MyLineChartRenderer";

    /* renamed from: b  reason: collision with root package name */
    private final Paint f8673b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(LineDataProvider chart, ChartAnimator animator, ViewPortHandler viewPortHandler) {
        super(chart, animator, viewPortHandler);
        j.e(chart, "chart");
        j.e(animator, "animator");
        j.e(viewPortHandler, "viewPortHandler");
        Paint paint = new Paint();
        paint.setFlags(1);
        paint.setColor((int) 4279946239L);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(4.0f);
        paint.setPathEffect(new DashPathEffect(new float[]{12.0f, 10.0f}, 0.0f));
        p pVar = p.a;
        this.f8673b = paint;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.renderer.LineScatterCandleRadarRenderer
    public void drawHighlightLines(Canvas c2, float f2, float f3, ILineScatterCandleRadarDataSet<?> set) {
        j.e(c2, "c");
        j.e(set, "set");
        c2.drawLine(f2, this.mViewPortHandler.contentTop(), f2, f3, this.f8673b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.github.mikephil.charting.data.Entry, com.github.mikephil.charting.data.BaseEntry, java.lang.Object] */
    /* JADX WARN: Unknown variable types count: 1 */
    @Override // com.github.mikephil.charting.renderer.LineChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void drawHighlighted(android.graphics.Canvas r11, com.github.mikephil.charting.highlight.Highlight[] r12) {
        /*
            r10 = this;
            java.lang.String r0 = "c"
            kotlin.jvm.internal.j.e(r11, r0)
            java.lang.String r0 = "indices"
            kotlin.jvm.internal.j.e(r12, r0)
            com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider r0 = r10.mChart
            java.lang.String r1 = "mChart"
            kotlin.jvm.internal.j.d(r0, r1)
            com.github.mikephil.charting.data.LineData r0 = r0.getLineData()
            int r1 = r12.length
            r2 = 0
        L_0x0017:
            if (r2 >= r1) goto L_0x007e
            r3 = r12[r2]
            int r4 = r3.getDataSetIndex()
            com.github.mikephil.charting.interfaces.datasets.IDataSet r4 = r0.getDataSetByIndex(r4)
            com.github.mikephil.charting.interfaces.datasets.ILineDataSet r4 = (com.github.mikephil.charting.interfaces.datasets.ILineDataSet) r4
            if (r4 == 0) goto L_0x007b
            boolean r5 = r4.isHighlightEnabled()
            if (r5 != 0) goto L_0x002e
            goto L_0x007b
        L_0x002e:
            float r5 = r3.getX()
            float r6 = r3.getY()
            com.github.mikephil.charting.data.Entry r5 = r4.getEntryForXValue(r5, r6)
            boolean r6 = r10.isInBoundsX(r5, r4)
            if (r6 != 0) goto L_0x0041
            goto L_0x007b
        L_0x0041:
            com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider r6 = r10.mChart
            com.github.mikephil.charting.components.YAxis$AxisDependency r7 = r4.getAxisDependency()
            com.github.mikephil.charting.utils.Transformer r6 = r6.getTransformer(r7)
            java.lang.String r7 = "e"
            kotlin.jvm.internal.j.d(r5, r7)
            float r7 = r5.getX()
            float r5 = r5.getY()
            com.github.mikephil.charting.animation.ChartAnimator r8 = r10.mAnimator
            java.lang.String r9 = "mAnimator"
            kotlin.jvm.internal.j.d(r8, r9)
            float r8 = r8.getPhaseY()
            float r5 = r5 * r8
            com.github.mikephil.charting.utils.MPPointD r5 = r6.getPixelForValues(r7, r5)
            double r6 = r5.x
            float r6 = (float) r6
            double r7 = r5.y
            float r7 = (float) r7
            r3.setDraw(r6, r7)
            double r6 = r5.x
            float r3 = (float) r6
            double r5 = r5.y
            float r5 = (float) r5
            r10.drawHighlightLines(r11, r3, r5, r4)
        L_0x007b:
            int r2 = r2 + 1
            goto L_0x0017
        L_0x007e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.view.iotplug.energymonitor.chart.b.drawHighlighted(android.graphics.Canvas, com.github.mikephil.charting.highlight.Highlight[]):void");
    }
}
