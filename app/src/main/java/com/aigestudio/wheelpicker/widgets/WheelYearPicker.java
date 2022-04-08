package com.aigestudio.wheelpicker.widgets;

import android.content.Context;
import android.util.AttributeSet;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.aigestudio.wheelpicker.WheelPicker;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* loaded from: classes.dex */
public class WheelYearPicker extends WheelPicker {
    private int C4;
    private int D4;
    private int E4;

    public WheelYearPicker(Context context) {
        this(context, null);
    }

    private void n() {
        setSelectedItemPosition(this.E4 - this.C4);
    }

    private void o() {
        ArrayList arrayList = new ArrayList();
        for (int i = this.C4; i <= this.D4; i++) {
            arrayList.add(Integer.valueOf(i));
        }
        super.setData(arrayList);
    }

    public int getCurrentYear() {
        return Integer.valueOf(String.valueOf(getData().get(getCurrentItemPosition()))).intValue();
    }

    public int getSelectedYear() {
        return this.E4;
    }

    public int getYearEnd() {
        return this.D4;
    }

    public int getYearStart() {
        return this.C4;
    }

    @Override // com.aigestudio.wheelpicker.WheelPicker
    public void setData(List list) {
        throw new UnsupportedOperationException("You can not invoke setData in WheelYearPicker");
    }

    public void setSelectedYear(int i) {
        this.E4 = i;
        n();
    }

    public void setYearEnd(int i) {
        this.D4 = i;
        o();
    }

    public void setYearStart(int i) {
        this.C4 = i;
        this.E4 = getCurrentYear();
        o();
        n();
    }

    public WheelYearPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C4 = 1000;
        this.D4 = PathInterpolatorCompat.MAX_NUM_POINTS;
        o();
        this.E4 = Calendar.getInstance().get(1);
        n();
    }
}
