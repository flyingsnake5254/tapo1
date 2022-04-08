package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import java.util.List;

/* loaded from: classes.dex */
public class BubbleData extends BarLineScatterCandleBubbleData<IBubbleDataSet> {
    public BubbleData() {
    }

    public void setHighlightCircleWidth(float f2) {
        for (T t : this.mDataSets) {
            t.setHighlightCircleWidth(f2);
        }
    }

    public BubbleData(IBubbleDataSet... iBubbleDataSetArr) {
        super(iBubbleDataSetArr);
    }

    public BubbleData(List<IBubbleDataSet> list) {
        super(list);
    }
}
