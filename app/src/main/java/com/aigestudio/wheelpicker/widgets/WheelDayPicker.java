package com.aigestudio.wheelpicker.widgets;

import android.content.Context;
import android.util.AttributeSet;
import com.aigestudio.wheelpicker.WheelPicker;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class WheelDayPicker extends WheelPicker {
    private static final Map<Integer, List<Integer>> C4 = new HashMap();
    private Calendar D4;
    private int E4;
    private int F4;
    private int G4;

    public WheelDayPicker(Context context) {
        this(context, null);
    }

    private void n() {
        this.D4.set(1, this.E4);
        this.D4.set(2, this.F4);
        int actualMaximum = this.D4.getActualMaximum(5);
        List<Integer> list = C4.get(Integer.valueOf(actualMaximum));
        if (list == null) {
            list = new ArrayList<>();
            for (int i = 1; i <= actualMaximum; i++) {
                list.add(Integer.valueOf(i));
            }
            C4.put(Integer.valueOf(actualMaximum), list);
        }
        super.setData(list);
    }

    private void o() {
        setSelectedItemPosition(this.G4 - 1);
    }

    public int getCurrentDay() {
        return Integer.valueOf(String.valueOf(getData().get(getCurrentItemPosition()))).intValue();
    }

    public int getMonth() {
        return this.F4;
    }

    public int getSelectedDay() {
        return this.G4;
    }

    public int getYear() {
        return this.E4;
    }

    @Override // com.aigestudio.wheelpicker.WheelPicker
    public void setData(List list) {
        throw new UnsupportedOperationException("You can not invoke setData in WheelDayPicker");
    }

    public void setMonth(int i) {
        this.F4 = i - 1;
        n();
    }

    public void setSelectedDay(int i) {
        this.G4 = i;
        o();
    }

    public void setYear(int i) {
        this.E4 = i;
        n();
    }

    public WheelDayPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Calendar instance = Calendar.getInstance();
        this.D4 = instance;
        this.E4 = instance.get(1);
        this.F4 = this.D4.get(2);
        n();
        this.G4 = this.D4.get(5);
        o();
    }
}
