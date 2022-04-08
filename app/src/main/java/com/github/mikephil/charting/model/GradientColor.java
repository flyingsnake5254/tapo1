package com.github.mikephil.charting.model;

/* loaded from: classes.dex */
public class GradientColor {
    private int endColor;
    private int startColor;

    public GradientColor(int i, int i2) {
        this.startColor = i;
        this.endColor = i2;
    }

    public int getEndColor() {
        return this.endColor;
    }

    public int getStartColor() {
        return this.startColor;
    }

    public void setEndColor(int i) {
        this.endColor = i;
    }

    public void setStartColor(int i) {
        this.startColor = i;
    }
}
