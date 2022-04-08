package com.github.mikephil.charting.buffer;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

/* loaded from: classes.dex */
public class BarBuffer extends AbstractBuffer<IBarDataSet> {
    protected boolean mContainsStacks;
    protected int mDataSetCount;
    protected int mDataSetIndex = 0;
    protected boolean mInverted = false;
    protected float mBarWidth = 1.0f;

    public BarBuffer(int i, int i2, boolean z) {
        super(i);
        this.mDataSetCount = 1;
        this.mContainsStacks = false;
        this.mDataSetCount = i2;
        this.mContainsStacks = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addBar(float f2, float f3, float f4, float f5) {
        float[] fArr = this.buffer;
        int i = this.index;
        int i2 = i + 1;
        this.index = i2;
        fArr[i] = f2;
        int i3 = i2 + 1;
        this.index = i3;
        fArr[i2] = f3;
        int i4 = i3 + 1;
        this.index = i4;
        fArr[i3] = f4;
        this.index = i4 + 1;
        fArr[i4] = f5;
    }

    public void setBarWidth(float f2) {
        this.mBarWidth = f2;
    }

    public void setDataSet(int i) {
        this.mDataSetIndex = i;
    }

    public void setInverted(boolean z) {
        this.mInverted = z;
    }

    public void feed(IBarDataSet iBarDataSet) {
        float f2;
        float entryCount = iBarDataSet.getEntryCount() * this.phaseX;
        float f3 = this.mBarWidth / 2.0f;
        for (int i = 0; i < entryCount; i++) {
            BarEntry barEntry = (BarEntry) iBarDataSet.getEntryForIndex(i);
            if (barEntry != null) {
                float x = barEntry.getX();
                float y = barEntry.getY();
                float[] yVals = barEntry.getYVals();
                if (!this.mContainsStacks || yVals == null) {
                    float f4 = x - f3;
                    float f5 = x + f3;
                    if (this.mInverted) {
                        y = y >= 0.0f ? y : 0.0f;
                        if (y > 0.0f) {
                            y = 0.0f;
                        }
                    } else {
                        y = y >= 0.0f ? y : 0.0f;
                        if (y > 0.0f) {
                            y = 0.0f;
                        }
                    }
                    if (y > 0.0f) {
                        y *= this.phaseY;
                    } else {
                        y *= this.phaseY;
                    }
                    addBar(f4, y, f5, y);
                } else {
                    float f6 = -barEntry.getNegativeSum();
                    float f7 = 0.0f;
                    for (float f8 : yVals) {
                        int i2 = (f8 > 0.0f ? 1 : (f8 == 0.0f ? 0 : -1));
                        if (i2 == 0 && (f7 == 0.0f || f6 == 0.0f)) {
                            f2 = f8;
                            f6 = f6;
                            f6 = f2;
                        } else if (i2 >= 0) {
                            f2 = f8 + f7;
                            f6 = f6;
                            f6 = f7;
                            f7 = f2;
                        } else {
                            f2 = Math.abs(f8) + f6;
                            f6 = Math.abs(f8) + f6;
                        }
                        float f9 = x - f3;
                        float f10 = x + f3;
                        if (this.mInverted) {
                            f6 = f6 >= f2 ? f6 : f2;
                            if (f6 > f2) {
                                f6 = f2;
                            }
                        } else {
                            f6 = f6 >= f2 ? f6 : f2;
                            if (f6 > f2) {
                                f6 = f2;
                            }
                        }
                        float f11 = this.phaseY;
                        addBar(f9, f6 * f11, f10, f6 * f11);
                    }
                }
            }
        }
        reset();
    }
}
