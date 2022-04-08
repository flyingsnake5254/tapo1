package com.aigestudio.wheelpicker.widgets;

import android.content.Context;
import android.util.AttributeSet;
import com.aigestudio.wheelpicker.WheelPicker;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* loaded from: classes.dex */
public class WheelMonthPicker extends WheelPicker {
    private int C4;

    public WheelMonthPicker(Context context) {
        this(context, null);
    }

    private void n() {
        setSelectedItemPosition(this.C4 - 1);
    }

    public int getCurrentMonth() {
        return Integer.valueOf(String.valueOf(getData().get(getCurrentItemPosition()))).intValue();
    }

    public int getSelectedMonth() {
        return this.C4;
    }

    @Override // com.aigestudio.wheelpicker.WheelPicker
    public void setData(List list) {
        throw new UnsupportedOperationException("You can not invoke setData in WheelMonthPicker");
    }

    public void setSelectedMonth(int i) {
        this.C4 = i;
        n();
    }

    public WheelMonthPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ArrayList arrayList = new ArrayList();
        for (int i = 1; i <= 12; i++) {
            arrayList.add(Integer.valueOf(i));
        }
        super.setData(arrayList);
        this.C4 = Calendar.getInstance().get(2) + 1;
        n();
    }
}
