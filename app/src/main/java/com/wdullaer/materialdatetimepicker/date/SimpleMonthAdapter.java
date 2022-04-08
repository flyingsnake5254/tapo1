package com.wdullaer.materialdatetimepicker.date;

import android.content.Context;

/* loaded from: classes3.dex */
public class SimpleMonthAdapter extends MonthAdapter {
    public SimpleMonthAdapter(a aVar) {
        super(aVar);
    }

    @Override // com.wdullaer.materialdatetimepicker.date.MonthAdapter
    public MonthView m(Context context) {
        return new SimpleMonthView(context, null, this.a);
    }
}
