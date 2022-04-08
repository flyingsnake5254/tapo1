package com.tplink.libtpcontrols.wheelpicker.widget.curved;

import android.content.Context;
import android.util.AttributeSet;
import com.tplink.libtpcontrols.wheelpicker.view.WheelCurvedPicker;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* loaded from: classes3.dex */
public class WheelMonthPicker extends WheelCurvedPicker {
    private static final List<String> B4 = new ArrayList();
    private List<String> C4 = B4;
    private int D4;

    static {
        for (int i = 1; i <= 12; i++) {
            B4.add(String.valueOf(i));
        }
    }

    public WheelMonthPicker(Context context) {
        super(context);
        x();
    }

    private void x() {
        super.setData(this.C4);
        setCurrentMonth(Calendar.getInstance().get(2) + 1);
    }

    public void setCurrentMonth(int i) {
        int min = Math.min(Math.max(i, 1), 12);
        this.D4 = min;
        setItemIndex(min - 1);
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.view.WheelCrossPicker, com.tplink.libtpcontrols.wheelpicker.core.AbstractWheelPicker
    public void setData(List<String> list) {
        throw new RuntimeException("Set data will not allow here!");
    }

    public WheelMonthPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        x();
    }
}
