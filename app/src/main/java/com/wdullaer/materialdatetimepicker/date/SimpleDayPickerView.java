package com.wdullaer.materialdatetimepicker.date;

import android.content.Context;
import android.util.AttributeSet;

/* loaded from: classes3.dex */
public class SimpleDayPickerView extends DayPickerView {
    public SimpleDayPickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DayPickerView
    public MonthAdapter a(a aVar) {
        return new SimpleMonthAdapter(aVar);
    }
}
