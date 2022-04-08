package com.tplink.iot.view.ipcamera.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.BindingAdapter;
import com.tplink.iot.Utils.c0;

/* loaded from: classes2.dex */
public class ScheduleWeekdayTextView extends AppCompatTextView {
    public ScheduleWeekdayTextView(Context context) {
        super(context);
    }

    @BindingAdapter({"android:days"})
    public static void b(ScheduleWeekdayTextView scheduleWeekdayTextView, int i) {
        scheduleWeekdayTextView.setDays(i);
    }

    public void setDays(int i) {
        setText(c0.b(getContext(), i, true));
        if (i == 0) {
            setTextColor(-13568);
        } else {
            setTextColor(-13421773);
        }
    }

    public ScheduleWeekdayTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScheduleWeekdayTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
