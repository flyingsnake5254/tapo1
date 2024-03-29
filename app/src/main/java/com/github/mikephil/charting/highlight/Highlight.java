package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.components.YAxis;

/* loaded from: classes.dex */
public class Highlight {
    private YAxis.AxisDependency axis;
    private int mDataIndex;
    private int mDataSetIndex;
    private float mDrawX;
    private float mDrawY;
    private int mStackIndex;
    private float mX;
    private float mXPx;
    private float mY;
    private float mYPx;

    public Highlight(float f2, float f3, int i) {
        this.mX = Float.NaN;
        this.mY = Float.NaN;
        this.mDataIndex = -1;
        this.mStackIndex = -1;
        this.mX = f2;
        this.mY = f3;
        this.mDataSetIndex = i;
    }

    public boolean equalTo(Highlight highlight) {
        return highlight != null && this.mDataSetIndex == highlight.mDataSetIndex && this.mX == highlight.mX && this.mStackIndex == highlight.mStackIndex && this.mDataIndex == highlight.mDataIndex;
    }

    public YAxis.AxisDependency getAxis() {
        return this.axis;
    }

    public int getDataIndex() {
        return this.mDataIndex;
    }

    public int getDataSetIndex() {
        return this.mDataSetIndex;
    }

    public float getDrawX() {
        return this.mDrawX;
    }

    public float getDrawY() {
        return this.mDrawY;
    }

    public int getStackIndex() {
        return this.mStackIndex;
    }

    public float getX() {
        return this.mX;
    }

    public float getXPx() {
        return this.mXPx;
    }

    public float getY() {
        return this.mY;
    }

    public float getYPx() {
        return this.mYPx;
    }

    public boolean isStacked() {
        return this.mStackIndex >= 0;
    }

    public void setDataIndex(int i) {
        this.mDataIndex = i;
    }

    public void setDraw(float f2, float f3) {
        this.mDrawX = f2;
        this.mDrawY = f3;
    }

    public String toString() {
        return "Highlight, x: " + this.mX + ", y: " + this.mY + ", dataSetIndex: " + this.mDataSetIndex + ", stackIndex (only stacked barentry): " + this.mStackIndex;
    }

    public Highlight(float f2, int i, int i2) {
        this(f2, Float.NaN, i);
        this.mStackIndex = i2;
    }

    public Highlight(float f2, float f3, float f4, float f5, int i, YAxis.AxisDependency axisDependency) {
        this.mX = Float.NaN;
        this.mY = Float.NaN;
        this.mDataIndex = -1;
        this.mStackIndex = -1;
        this.mX = f2;
        this.mY = f3;
        this.mXPx = f4;
        this.mYPx = f5;
        this.mDataSetIndex = i;
        this.axis = axisDependency;
    }

    public Highlight(float f2, float f3, float f4, float f5, int i, int i2, YAxis.AxisDependency axisDependency) {
        this(f2, f3, f4, f5, i, axisDependency);
        this.mStackIndex = i2;
    }
}
