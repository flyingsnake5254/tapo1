package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.renderer.BarLineScatterCandleBubbleRenderer;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* loaded from: classes.dex */
public class ScatterChartRenderer extends LineScatterCandleRadarRenderer {
    protected ScatterDataProvider mChart;
    float[] mPixelBuffer = new float[2];

    public ScatterChartRenderer(ScatterDataProvider scatterDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mChart = scatterDataProvider;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        for (T t : this.mChart.getScatterData().getDataSets()) {
            if (t.isVisible()) {
                drawDataSet(canvas, t);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v9, types: [com.github.mikephil.charting.data.Entry, com.github.mikephil.charting.data.BaseEntry] */
    /* JADX WARN: Unknown variable types count: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void drawDataSet(android.graphics.Canvas r19, com.github.mikephil.charting.interfaces.datasets.IScatterDataSet r20) {
        /*
            r18 = this;
            r0 = r18
            r8 = r20
            int r1 = r20.getEntryCount()
            r9 = 1
            if (r1 >= r9) goto L_0x000c
            return
        L_0x000c:
            com.github.mikephil.charting.utils.ViewPortHandler r10 = r0.mViewPortHandler
            com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider r1 = r0.mChart
            com.github.mikephil.charting.components.YAxis$AxisDependency r2 = r20.getAxisDependency()
            com.github.mikephil.charting.utils.Transformer r11 = r1.getTransformer(r2)
            com.github.mikephil.charting.animation.ChartAnimator r1 = r0.mAnimator
            float r12 = r1.getPhaseY()
            com.github.mikephil.charting.renderer.scatter.IShapeRenderer r13 = r20.getShapeRenderer()
            if (r13 != 0) goto L_0x002c
            java.lang.String r1 = "MISSING"
            java.lang.String r2 = "There's no IShapeRenderer specified for ScatterDataSet"
            android.util.Log.i(r1, r2)
            return
        L_0x002c:
            int r1 = r20.getEntryCount()
            float r1 = (float) r1
            com.github.mikephil.charting.animation.ChartAnimator r2 = r0.mAnimator
            float r2 = r2.getPhaseX()
            float r1 = r1 * r2
            double r1 = (double) r1
            double r1 = java.lang.Math.ceil(r1)
            int r3 = r20.getEntryCount()
            float r3 = (float) r3
            double r3 = (double) r3
            double r1 = java.lang.Math.min(r1, r3)
            int r14 = (int) r1
            r15 = 0
            r7 = 0
        L_0x004b:
            if (r7 >= r14) goto L_0x00b1
            com.github.mikephil.charting.data.Entry r1 = r8.getEntryForIndex(r7)
            float[] r2 = r0.mPixelBuffer
            float r3 = r1.getX()
            r2[r15] = r3
            float[] r2 = r0.mPixelBuffer
            float r1 = r1.getY()
            float r1 = r1 * r12
            r2[r9] = r1
            float[] r1 = r0.mPixelBuffer
            r11.pointValuesToPixel(r1)
            float[] r1 = r0.mPixelBuffer
            r1 = r1[r15]
            boolean r1 = r10.isInBoundsRight(r1)
            if (r1 != 0) goto L_0x0073
            goto L_0x00b1
        L_0x0073:
            float[] r1 = r0.mPixelBuffer
            r1 = r1[r15]
            boolean r1 = r10.isInBoundsLeft(r1)
            if (r1 == 0) goto L_0x00ac
            float[] r1 = r0.mPixelBuffer
            r1 = r1[r9]
            boolean r1 = r10.isInBoundsY(r1)
            if (r1 != 0) goto L_0x0088
            goto L_0x00ac
        L_0x0088:
            android.graphics.Paint r1 = r0.mRenderPaint
            int r2 = r7 / 2
            int r2 = r8.getColor(r2)
            r1.setColor(r2)
            com.github.mikephil.charting.utils.ViewPortHandler r4 = r0.mViewPortHandler
            float[] r1 = r0.mPixelBuffer
            r5 = r1[r15]
            r6 = r1[r9]
            android.graphics.Paint r3 = r0.mRenderPaint
            r1 = r13
            r2 = r19
            r16 = r3
            r3 = r20
            r17 = r7
            r7 = r16
            r1.renderShape(r2, r3, r4, r5, r6, r7)
            goto L_0x00ae
        L_0x00ac:
            r17 = r7
        L_0x00ae:
            int r7 = r17 + 1
            goto L_0x004b
        L_0x00b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.ScatterChartRenderer.drawDataSet(android.graphics.Canvas, com.github.mikephil.charting.interfaces.datasets.IScatterDataSet):void");
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.github.mikephil.charting.data.Entry, com.github.mikephil.charting.data.BaseEntry] */
    /* JADX WARN: Unknown variable types count: 1 */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void drawHighlighted(android.graphics.Canvas r10, com.github.mikephil.charting.highlight.Highlight[] r11) {
        /*
            r9 = this;
            com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider r0 = r9.mChart
            com.github.mikephil.charting.data.ScatterData r0 = r0.getScatterData()
            int r1 = r11.length
            r2 = 0
        L_0x0008:
            if (r2 >= r1) goto L_0x0065
            r3 = r11[r2]
            int r4 = r3.getDataSetIndex()
            com.github.mikephil.charting.interfaces.datasets.IDataSet r4 = r0.getDataSetByIndex(r4)
            com.github.mikephil.charting.interfaces.datasets.IScatterDataSet r4 = (com.github.mikephil.charting.interfaces.datasets.IScatterDataSet) r4
            if (r4 == 0) goto L_0x0062
            boolean r5 = r4.isHighlightEnabled()
            if (r5 != 0) goto L_0x001f
            goto L_0x0062
        L_0x001f:
            float r5 = r3.getX()
            float r6 = r3.getY()
            com.github.mikephil.charting.data.Entry r5 = r4.getEntryForXValue(r5, r6)
            boolean r6 = r9.isInBoundsX(r5, r4)
            if (r6 != 0) goto L_0x0032
            goto L_0x0062
        L_0x0032:
            com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider r6 = r9.mChart
            com.github.mikephil.charting.components.YAxis$AxisDependency r7 = r4.getAxisDependency()
            com.github.mikephil.charting.utils.Transformer r6 = r6.getTransformer(r7)
            float r7 = r5.getX()
            float r5 = r5.getY()
            com.github.mikephil.charting.animation.ChartAnimator r8 = r9.mAnimator
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
            r9.drawHighlightLines(r10, r3, r5, r4)
        L_0x0062:
            int r2 = r2 + 1
            goto L_0x0008
        L_0x0065:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.ScatterChartRenderer.drawHighlighted(android.graphics.Canvas, com.github.mikephil.charting.highlight.Highlight[]):void");
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas canvas, String str, float f2, float f3, int i) {
        this.mValuePaint.setColor(i);
        canvas.drawText(str, f2, f3, this.mValuePaint);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        Entry entry;
        if (isDrawingValuesAllowed(this.mChart)) {
            List<T> dataSets = this.mChart.getScatterData().getDataSets();
            for (int i = 0; i < this.mChart.getScatterData().getDataSetCount(); i++) {
                IScatterDataSet iScatterDataSet = (IScatterDataSet) dataSets.get(i);
                if (shouldDrawValues(iScatterDataSet) && iScatterDataSet.getEntryCount() >= 1) {
                    applyValueTextStyle(iScatterDataSet);
                    this.mXBounds.set(this.mChart, iScatterDataSet);
                    Transformer transformer = this.mChart.getTransformer(iScatterDataSet.getAxisDependency());
                    float phaseX = this.mAnimator.getPhaseX();
                    float phaseY = this.mAnimator.getPhaseY();
                    BarLineScatterCandleBubbleRenderer.XBounds xBounds = this.mXBounds;
                    float[] generateTransformedValuesScatter = transformer.generateTransformedValuesScatter(iScatterDataSet, phaseX, phaseY, xBounds.min, xBounds.max);
                    float convertDpToPixel = Utils.convertDpToPixel(iScatterDataSet.getScatterShapeSize());
                    ValueFormatter valueFormatter = iScatterDataSet.getValueFormatter();
                    MPPointF instance = MPPointF.getInstance(iScatterDataSet.getIconsOffset());
                    instance.x = Utils.convertDpToPixel(instance.x);
                    instance.y = Utils.convertDpToPixel(instance.y);
                    for (int i2 = 0; i2 < generateTransformedValuesScatter.length && this.mViewPortHandler.isInBoundsRight(generateTransformedValuesScatter[i2]); i2 += 2) {
                        if (this.mViewPortHandler.isInBoundsLeft(generateTransformedValuesScatter[i2])) {
                            int i3 = i2 + 1;
                            if (this.mViewPortHandler.isInBoundsY(generateTransformedValuesScatter[i3])) {
                                int i4 = i2 / 2;
                                Entry entryForIndex = iScatterDataSet.getEntryForIndex(this.mXBounds.min + i4);
                                if (iScatterDataSet.isDrawValuesEnabled()) {
                                    entry = entryForIndex;
                                    iScatterDataSet = iScatterDataSet;
                                    drawValue(canvas, valueFormatter.getPointLabel(entryForIndex), generateTransformedValuesScatter[i2], generateTransformedValuesScatter[i3] - convertDpToPixel, iScatterDataSet.getValueTextColor(i4 + this.mXBounds.min));
                                } else {
                                    entry = entryForIndex;
                                    iScatterDataSet = iScatterDataSet;
                                }
                                if (entry.getIcon() != null && iScatterDataSet.isDrawIconsEnabled()) {
                                    Drawable icon = entry.getIcon();
                                    Utils.drawImage(canvas, icon, (int) (generateTransformedValuesScatter[i2] + instance.x), (int) (generateTransformedValuesScatter[i3] + instance.y), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                                }
                            }
                        }
                        iScatterDataSet = iScatterDataSet;
                    }
                    MPPointF.recycleInstance(instance);
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
    }
}
