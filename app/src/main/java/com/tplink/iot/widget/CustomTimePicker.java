package com.tplink.iot.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.NumberPicker;
import com.tplink.iot.R;

/* loaded from: classes3.dex */
public class CustomTimePicker extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    NumberPicker f11495c;

    /* renamed from: d  reason: collision with root package name */
    NumberPicker f11496d;

    /* renamed from: f  reason: collision with root package name */
    NumberPicker f11497f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements NumberPicker.Formatter {
        a() {
        }

        @Override // android.widget.NumberPicker.Formatter
        public String format(int i) {
            if (i >= 10) {
                return String.valueOf(i);
            }
            return "0" + i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements NumberPicker.Formatter {
        b() {
        }

        @Override // android.widget.NumberPicker.Formatter
        public String format(int i) {
            if (i >= 10) {
                return String.valueOf(i);
            }
            return "0" + i;
        }
    }

    public CustomTimePicker(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        View inflate = FrameLayout.inflate(context, R.layout.widget_time_picker, this);
        this.f11495c = (NumberPicker) inflate.findViewById(R.id.time_picker_hour);
        this.f11496d = (NumberPicker) inflate.findViewById(R.id.time_picker_minute);
        this.f11497f = (NumberPicker) inflate.findViewById(R.id.am_pm);
        this.f11495c.setMinValue(0);
        this.f11495c.setMaxValue(23);
        this.f11495c.setFormatter(new a());
        this.f11495c.setDescendantFocusability(393216);
        this.f11496d.setMaxValue(59);
        this.f11496d.setMinValue(0);
        this.f11496d.setFormatter(new b());
        this.f11496d.setDescendantFocusability(393216);
    }

    public int getCurrentHour() {
        return this.f11495c.getValue();
    }

    public int getCurrentMinute() {
        return this.f11496d.getValue();
    }

    public void setCurrentHour(int i) {
        this.f11495c.setValue(i);
    }

    public void setCurrentMinute(int i) {
        this.f11496d.setValue(i);
    }

    public CustomTimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public CustomTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
