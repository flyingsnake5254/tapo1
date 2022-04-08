package com.github.mikephil.charting.data;

import androidx.core.view.ViewCompat;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class PieDataSet extends DataSet<PieEntry> implements IPieDataSet {
    private boolean mAutomaticallyDisableSliceSpacing;
    private ValuePosition mXValuePosition;
    private ValuePosition mYValuePosition;
    private float mSliceSpace = 0.0f;
    private float mShift = 18.0f;
    private boolean mUsingSliceColorAsValueLineColor = false;
    private int mValueLineColor = ViewCompat.MEASURED_STATE_MASK;
    private float mValueLineWidth = 1.0f;
    private float mValueLinePart1OffsetPercentage = 75.0f;
    private float mValueLinePart1Length = 0.3f;
    private float mValueLinePart2Length = 0.4f;
    private boolean mValueLineVariableLength = true;

    /* loaded from: classes.dex */
    public enum ValuePosition {
        INSIDE_SLICE,
        OUTSIDE_SLICE
    }

    public PieDataSet(List<PieEntry> list, String str) {
        super(list, str);
        ValuePosition valuePosition = ValuePosition.INSIDE_SLICE;
        this.mXValuePosition = valuePosition;
        this.mYValuePosition = valuePosition;
    }

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<PieEntry> copy() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mValues.size(); i++) {
            arrayList.add(((PieEntry) this.mValues.get(i)).copy());
        }
        PieDataSet pieDataSet = new PieDataSet(arrayList, getLabel());
        copy(pieDataSet);
        return pieDataSet;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public float getSelectionShift() {
        return this.mShift;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public float getSliceSpace() {
        return this.mSliceSpace;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public int getValueLineColor() {
        return this.mValueLineColor;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public float getValueLinePart1Length() {
        return this.mValueLinePart1Length;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public float getValueLinePart1OffsetPercentage() {
        return this.mValueLinePart1OffsetPercentage;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public float getValueLinePart2Length() {
        return this.mValueLinePart2Length;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public float getValueLineWidth() {
        return this.mValueLineWidth;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public ValuePosition getXValuePosition() {
        return this.mXValuePosition;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public ValuePosition getYValuePosition() {
        return this.mYValuePosition;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public boolean isAutomaticallyDisableSliceSpacingEnabled() {
        return this.mAutomaticallyDisableSliceSpacing;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public boolean isUsingSliceColorAsValueLineColor() {
        return this.mUsingSliceColorAsValueLineColor;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public boolean isValueLineVariableLength() {
        return this.mValueLineVariableLength;
    }

    public void setAutomaticallyDisableSliceSpacing(boolean z) {
        this.mAutomaticallyDisableSliceSpacing = z;
    }

    public void setSelectionShift(float f2) {
        this.mShift = Utils.convertDpToPixel(f2);
    }

    public void setSliceSpace(float f2) {
        if (f2 > 20.0f) {
            f2 = 20.0f;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        this.mSliceSpace = Utils.convertDpToPixel(f2);
    }

    public void setUsingSliceColorAsValueLineColor(boolean z) {
        this.mUsingSliceColorAsValueLineColor = z;
    }

    public void setValueLineColor(int i) {
        this.mValueLineColor = i;
    }

    public void setValueLinePart1Length(float f2) {
        this.mValueLinePart1Length = f2;
    }

    public void setValueLinePart1OffsetPercentage(float f2) {
        this.mValueLinePart1OffsetPercentage = f2;
    }

    public void setValueLinePart2Length(float f2) {
        this.mValueLinePart2Length = f2;
    }

    public void setValueLineVariableLength(boolean z) {
        this.mValueLineVariableLength = z;
    }

    public void setValueLineWidth(float f2) {
        this.mValueLineWidth = f2;
    }

    public void setXValuePosition(ValuePosition valuePosition) {
        this.mXValuePosition = valuePosition;
    }

    public void setYValuePosition(ValuePosition valuePosition) {
        this.mYValuePosition = valuePosition;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void calcMinMax(PieEntry pieEntry) {
        if (pieEntry != null) {
            calcMinMaxY(pieEntry);
        }
    }

    protected void copy(PieDataSet pieDataSet) {
        super.copy((DataSet) pieDataSet);
    }
}
