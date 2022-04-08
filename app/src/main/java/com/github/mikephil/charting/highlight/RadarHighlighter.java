package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.charts.RadarChart;
import java.util.List;

/* loaded from: classes.dex */
public class RadarHighlighter extends PieRadarHighlighter<RadarChart> {
    public RadarHighlighter(RadarChart radarChart) {
        super(radarChart);
    }

    @Override // com.github.mikephil.charting.highlight.PieRadarHighlighter
    protected Highlight getClosestHighlight(int i, float f2, float f3) {
        List<Highlight> highlightsAtIndex = getHighlightsAtIndex(i);
        float distanceToCenter = ((RadarChart) this.mChart).distanceToCenter(f2, f3) / ((RadarChart) this.mChart).getFactor();
        Highlight highlight = null;
        float f4 = Float.MAX_VALUE;
        for (int i2 = 0; i2 < highlightsAtIndex.size(); i2++) {
            Highlight highlight2 = highlightsAtIndex.get(i2);
            float abs = Math.abs(highlight2.getY() - distanceToCenter);
            if (abs < f4) {
                highlight = highlight2;
                f4 = abs;
            }
        }
        return highlight;
    }

    /* JADX WARN: Type inference failed for: r9v0, types: [com.github.mikephil.charting.data.Entry, com.github.mikephil.charting.data.BaseEntry] */
    /* JADX WARN: Unknown variable types count: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.util.List<com.github.mikephil.charting.highlight.Highlight> getHighlightsAtIndex(int r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            java.util.List<com.github.mikephil.charting.highlight.Highlight> r2 = r0.mHighlightBuffer
            r2.clear()
            T extends com.github.mikephil.charting.charts.PieRadarChartBase r2 = r0.mChart
            com.github.mikephil.charting.charts.RadarChart r2 = (com.github.mikephil.charting.charts.RadarChart) r2
            com.github.mikephil.charting.animation.ChartAnimator r2 = r2.getAnimator()
            float r2 = r2.getPhaseX()
            T extends com.github.mikephil.charting.charts.PieRadarChartBase r3 = r0.mChart
            com.github.mikephil.charting.charts.RadarChart r3 = (com.github.mikephil.charting.charts.RadarChart) r3
            com.github.mikephil.charting.animation.ChartAnimator r3 = r3.getAnimator()
            float r3 = r3.getPhaseY()
            T extends com.github.mikephil.charting.charts.PieRadarChartBase r4 = r0.mChart
            com.github.mikephil.charting.charts.RadarChart r4 = (com.github.mikephil.charting.charts.RadarChart) r4
            float r4 = r4.getSliceAngle()
            T extends com.github.mikephil.charting.charts.PieRadarChartBase r5 = r0.mChart
            com.github.mikephil.charting.charts.RadarChart r5 = (com.github.mikephil.charting.charts.RadarChart) r5
            float r5 = r5.getFactor()
            r6 = 0
            com.github.mikephil.charting.utils.MPPointF r6 = com.github.mikephil.charting.utils.MPPointF.getInstance(r6, r6)
            r7 = 0
        L_0x0037:
            T extends com.github.mikephil.charting.charts.PieRadarChartBase r8 = r0.mChart
            com.github.mikephil.charting.charts.RadarChart r8 = (com.github.mikephil.charting.charts.RadarChart) r8
            com.github.mikephil.charting.data.ChartData r8 = r8.getData()
            com.github.mikephil.charting.data.RadarData r8 = (com.github.mikephil.charting.data.RadarData) r8
            int r8 = r8.getDataSetCount()
            if (r7 >= r8) goto L_0x00a5
            T extends com.github.mikephil.charting.charts.PieRadarChartBase r8 = r0.mChart
            com.github.mikephil.charting.charts.RadarChart r8 = (com.github.mikephil.charting.charts.RadarChart) r8
            com.github.mikephil.charting.data.ChartData r8 = r8.getData()
            com.github.mikephil.charting.data.RadarData r8 = (com.github.mikephil.charting.data.RadarData) r8
            com.github.mikephil.charting.interfaces.datasets.IDataSet r8 = r8.getDataSetByIndex(r7)
            com.github.mikephil.charting.data.Entry r9 = r8.getEntryForIndex(r1)
            float r10 = r9.getY()
            T extends com.github.mikephil.charting.charts.PieRadarChartBase r11 = r0.mChart
            com.github.mikephil.charting.charts.RadarChart r11 = (com.github.mikephil.charting.charts.RadarChart) r11
            float r11 = r11.getYChartMin()
            float r10 = r10 - r11
            T extends com.github.mikephil.charting.charts.PieRadarChartBase r11 = r0.mChart
            com.github.mikephil.charting.charts.RadarChart r11 = (com.github.mikephil.charting.charts.RadarChart) r11
            com.github.mikephil.charting.utils.MPPointF r11 = r11.getCenterOffsets()
            float r10 = r10 * r5
            float r10 = r10 * r3
            float r12 = (float) r1
            float r13 = r4 * r12
            float r13 = r13 * r2
            T extends com.github.mikephil.charting.charts.PieRadarChartBase r14 = r0.mChart
            com.github.mikephil.charting.charts.RadarChart r14 = (com.github.mikephil.charting.charts.RadarChart) r14
            float r14 = r14.getRotationAngle()
            float r13 = r13 + r14
            com.github.mikephil.charting.utils.Utils.getPosition(r11, r10, r13, r6)
            java.util.List<com.github.mikephil.charting.highlight.Highlight> r15 = r0.mHighlightBuffer
            com.github.mikephil.charting.highlight.Highlight r14 = new com.github.mikephil.charting.highlight.Highlight
            float r10 = r9.getY()
            float r11 = r6.x
            float r13 = r6.y
            com.github.mikephil.charting.components.YAxis$AxisDependency r16 = r8.getAxisDependency()
            r8 = r14
            r9 = r12
            r12 = r13
            r13 = r7
            r1 = r14
            r14 = r16
            r8.<init>(r9, r10, r11, r12, r13, r14)
            r15.add(r1)
            int r7 = r7 + 1
            r1 = r18
            goto L_0x0037
        L_0x00a5:
            java.util.List<com.github.mikephil.charting.highlight.Highlight> r1 = r0.mHighlightBuffer
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.highlight.RadarHighlighter.getHighlightsAtIndex(int):java.util.List");
    }
}
