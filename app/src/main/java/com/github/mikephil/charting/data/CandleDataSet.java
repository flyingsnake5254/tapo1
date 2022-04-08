package com.github.mikephil.charting.data;

import android.graphics.Paint;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class CandleDataSet extends LineScatterCandleRadarDataSet<CandleEntry> implements ICandleDataSet {
    private float mShadowWidth = 3.0f;
    private boolean mShowCandleBar = true;
    private float mBarSpace = 0.1f;
    private boolean mShadowColorSameAsCandle = false;
    protected Paint.Style mIncreasingPaintStyle = Paint.Style.STROKE;
    protected Paint.Style mDecreasingPaintStyle = Paint.Style.FILL;
    protected int mNeutralColor = ColorTemplate.COLOR_SKIP;
    protected int mIncreasingColor = ColorTemplate.COLOR_SKIP;
    protected int mDecreasingColor = ColorTemplate.COLOR_SKIP;
    protected int mShadowColor = ColorTemplate.COLOR_SKIP;

    public CandleDataSet(List<CandleEntry> list, String str) {
        super(list, str);
    }

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<CandleEntry> copy() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mValues.size(); i++) {
            arrayList.add(((CandleEntry) this.mValues.get(i)).copy());
        }
        CandleDataSet candleDataSet = new CandleDataSet(arrayList, getLabel());
        copy(candleDataSet);
        return candleDataSet;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public float getBarSpace() {
        return this.mBarSpace;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public int getDecreasingColor() {
        return this.mDecreasingColor;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public Paint.Style getDecreasingPaintStyle() {
        return this.mDecreasingPaintStyle;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public int getIncreasingColor() {
        return this.mIncreasingColor;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public Paint.Style getIncreasingPaintStyle() {
        return this.mIncreasingPaintStyle;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public int getNeutralColor() {
        return this.mNeutralColor;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public int getShadowColor() {
        return this.mShadowColor;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public boolean getShadowColorSameAsCandle() {
        return this.mShadowColorSameAsCandle;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public float getShadowWidth() {
        return this.mShadowWidth;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public boolean getShowCandleBar() {
        return this.mShowCandleBar;
    }

    public void setBarSpace(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 0.45f) {
            f2 = 0.45f;
        }
        this.mBarSpace = f2;
    }

    public void setDecreasingColor(int i) {
        this.mDecreasingColor = i;
    }

    public void setDecreasingPaintStyle(Paint.Style style) {
        this.mDecreasingPaintStyle = style;
    }

    public void setIncreasingColor(int i) {
        this.mIncreasingColor = i;
    }

    public void setIncreasingPaintStyle(Paint.Style style) {
        this.mIncreasingPaintStyle = style;
    }

    public void setNeutralColor(int i) {
        this.mNeutralColor = i;
    }

    public void setShadowColor(int i) {
        this.mShadowColor = i;
    }

    public void setShadowColorSameAsCandle(boolean z) {
        this.mShadowColorSameAsCandle = z;
    }

    public void setShadowWidth(float f2) {
        this.mShadowWidth = Utils.convertDpToPixel(f2);
    }

    public void setShowCandleBar(boolean z) {
        this.mShowCandleBar = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void calcMinMax(CandleEntry candleEntry) {
        if (candleEntry.getLow() < this.mYMin) {
            this.mYMin = candleEntry.getLow();
        }
        if (candleEntry.getHigh() > this.mYMax) {
            this.mYMax = candleEntry.getHigh();
        }
        calcMinMaxX(candleEntry);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void calcMinMaxY(CandleEntry candleEntry) {
        if (candleEntry.getHigh() < this.mYMin) {
            this.mYMin = candleEntry.getHigh();
        }
        if (candleEntry.getHigh() > this.mYMax) {
            this.mYMax = candleEntry.getHigh();
        }
        if (candleEntry.getLow() < this.mYMin) {
            this.mYMin = candleEntry.getLow();
        }
        if (candleEntry.getLow() > this.mYMax) {
            this.mYMax = candleEntry.getLow();
        }
    }

    protected void copy(CandleDataSet candleDataSet) {
        super.copy((LineScatterCandleRadarDataSet) candleDataSet);
        candleDataSet.mShadowWidth = this.mShadowWidth;
        candleDataSet.mShowCandleBar = this.mShowCandleBar;
        candleDataSet.mBarSpace = this.mBarSpace;
        candleDataSet.mShadowColorSameAsCandle = this.mShadowColorSameAsCandle;
        candleDataSet.mHighLightColor = this.mHighLightColor;
        candleDataSet.mIncreasingPaintStyle = this.mIncreasingPaintStyle;
        candleDataSet.mDecreasingPaintStyle = this.mDecreasingPaintStyle;
        candleDataSet.mNeutralColor = this.mNeutralColor;
        candleDataSet.mIncreasingColor = this.mIncreasingColor;
        candleDataSet.mDecreasingColor = this.mDecreasingColor;
        candleDataSet.mShadowColor = this.mShadowColor;
    }
}
