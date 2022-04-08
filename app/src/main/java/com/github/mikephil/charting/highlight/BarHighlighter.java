package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.MPPointD;

/* loaded from: classes.dex */
public class BarHighlighter extends ChartHighlighter<BarDataProvider> {
    public BarHighlighter(BarDataProvider barDataProvider) {
        super(barDataProvider);
    }

    protected int getClosestStackIndex(Range[] rangeArr, float f2) {
        if (rangeArr == null || rangeArr.length == 0) {
            return 0;
        }
        int i = 0;
        for (Range range : rangeArr) {
            if (range.contains(f2)) {
                return i;
            }
            i++;
        }
        int max = Math.max(rangeArr.length - 1, 0);
        if (f2 > rangeArr[max].to) {
            return max;
        }
        return 0;
    }

    @Override // com.github.mikephil.charting.highlight.ChartHighlighter
    protected BarLineScatterCandleBubbleData getData() {
        return ((BarDataProvider) this.mChart).getBarData();
    }

    @Override // com.github.mikephil.charting.highlight.ChartHighlighter
    protected float getDistance(float f2, float f3, float f4, float f5) {
        return Math.abs(f2 - f4);
    }

    @Override // com.github.mikephil.charting.highlight.ChartHighlighter, com.github.mikephil.charting.highlight.IHighlighter
    public Highlight getHighlight(float f2, float f3) {
        Highlight highlight = super.getHighlight(f2, f3);
        if (highlight == null) {
            return null;
        }
        MPPointD valsForTouch = getValsForTouch(f2, f3);
        IBarDataSet iBarDataSet = (IBarDataSet) ((BarDataProvider) this.mChart).getBarData().getDataSetByIndex(highlight.getDataSetIndex());
        if (iBarDataSet.isStacked()) {
            return getStackedHighlight(highlight, iBarDataSet, (float) valsForTouch.x, (float) valsForTouch.y);
        }
        MPPointD.recycleInstance(valsForTouch);
        return highlight;
    }

    public Highlight getStackedHighlight(Highlight highlight, IBarDataSet iBarDataSet, float f2, float f3) {
        BarEntry barEntry = (BarEntry) iBarDataSet.getEntryForXValue(f2, f3);
        if (barEntry == null) {
            return null;
        }
        if (barEntry.getYVals() == null) {
            return highlight;
        }
        Range[] ranges = barEntry.getRanges();
        if (ranges.length <= 0) {
            return null;
        }
        int closestStackIndex = getClosestStackIndex(ranges, f3);
        MPPointD pixelForValues = ((BarDataProvider) this.mChart).getTransformer(iBarDataSet.getAxisDependency()).getPixelForValues(highlight.getX(), ranges[closestStackIndex].to);
        Highlight highlight2 = new Highlight(barEntry.getX(), barEntry.getY(), (float) pixelForValues.x, (float) pixelForValues.y, highlight.getDataSetIndex(), closestStackIndex, highlight.getAxis());
        MPPointD.recycleInstance(pixelForValues);
        return highlight2;
    }
}
