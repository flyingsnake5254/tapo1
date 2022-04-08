package com.tplink.libtpcontrols.wheelpicker.widget.curved;

import android.content.Context;
import android.util.AttributeSet;
import com.tplink.libtpcontrols.wheelpicker.view.WheelCurvedPicker;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* loaded from: classes3.dex */
public class WheelYearPicker extends WheelCurvedPicker {
    private static final List<String> B4 = new ArrayList();
    private List<String> C4 = B4;
    private int D4 = 1900;
    private int E4 = 2100;
    private int F4;

    static {
        for (int i = 1900; i <= 2100; i++) {
            B4.add(String.valueOf(i));
        }
    }

    public WheelYearPicker(Context context) {
        super(context);
        x();
    }

    private void x() {
        super.setData(this.C4);
        setCurrentYear(Calendar.getInstance().get(1));
    }

    public void setCurrentYear(int i) {
        int min = Math.min(Math.max(i, this.D4), this.E4);
        this.F4 = min;
        setItemIndex(min - this.D4);
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.view.WheelCrossPicker, com.tplink.libtpcontrols.wheelpicker.core.AbstractWheelPicker
    public void setData(List<String> list) {
        throw new RuntimeException("Set data will not allow here!");
    }

    public WheelYearPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        x();
    }
}
