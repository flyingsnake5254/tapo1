package com.tplink.libtpcontrols.wheelpicker.widget.curved;

import android.content.Context;
import android.util.AttributeSet;
import com.tplink.libtpcontrols.wheelpicker.view.WheelCurvedPicker;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class WheelDayPicker extends WheelCurvedPicker {
    private static final HashMap<Integer, List<String>> B4 = new HashMap<>();
    private static final Calendar C4 = Calendar.getInstance();
    private List<String> D4 = new ArrayList();
    private int E4;
    private int F4;
    private int G4;
    private int H4;

    public WheelDayPicker(Context context) {
        super(context);
        Calendar calendar = C4;
        this.E4 = calendar.get(5);
        this.F4 = calendar.get(2) + 1;
        this.G4 = calendar.get(1);
        x();
    }

    private void setMonth(int i) {
        int min = Math.min(Math.max(i, 1), 12);
        this.F4 = min;
        C4.set(2, min - 1);
    }

    private void setYear(int i) {
        int min = Math.min(Math.max(i, 1), 2147483646);
        this.G4 = min;
        C4.set(1, min);
    }

    private void x() {
        y();
        z();
    }

    private void y() {
        List<String> list;
        int actualMaximum = C4.getActualMaximum(5);
        if (actualMaximum != this.H4) {
            this.H4 = actualMaximum;
            HashMap<Integer, List<String>> hashMap = B4;
            if (hashMap.containsKey(Integer.valueOf(actualMaximum))) {
                list = hashMap.get(Integer.valueOf(actualMaximum));
            } else {
                ArrayList arrayList = new ArrayList();
                for (int i = 1; i <= actualMaximum; i++) {
                    arrayList.add(String.valueOf(i));
                }
                B4.put(Integer.valueOf(actualMaximum), arrayList);
                list = arrayList;
            }
            this.D4 = list;
            super.setData(list);
        }
    }

    private void z() {
        setItemIndex(this.E4 - 1);
    }

    public void A(int i, int i2) {
        setYear(i);
        setMonth(i2);
        y();
        q();
    }

    public void setCurrentDay(int i) {
        this.E4 = Math.min(Math.max(i, 1), this.H4);
        z();
    }

    public void setCurrentMonth(int i) {
        setMonth(i);
        y();
    }

    public void setCurrentYear(int i) {
        setYear(i);
        y();
    }

    @Override // com.tplink.libtpcontrols.wheelpicker.view.WheelCrossPicker, com.tplink.libtpcontrols.wheelpicker.core.AbstractWheelPicker
    public void setData(List<String> list) {
        throw new RuntimeException("Set data will not allow here!");
    }

    public WheelDayPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Calendar calendar = C4;
        this.E4 = calendar.get(5);
        this.F4 = calendar.get(2) + 1;
        this.G4 = calendar.get(1);
        x();
    }
}
