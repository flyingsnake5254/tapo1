package com.tplink.iot.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tplink.iot.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class WeekdayView extends LinearLayout {

    /* renamed from: c  reason: collision with root package name */
    private static final int f11625c = Color.parseColor("#999999");

    /* renamed from: d  reason: collision with root package name */
    private static final int f11626d = Color.parseColor("#4D999999");

    /* renamed from: f  reason: collision with root package name */
    private int f11627f;
    private List<TextView> q = new ArrayList();

    public WeekdayView(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = 16;
        List asList = Arrays.asList(Integer.valueOf((int) R.string.week_abbreviation_sunday), Integer.valueOf((int) R.string.week_abbreviation_monday), Integer.valueOf((int) R.string.week_abbreviation_tuesday), Integer.valueOf((int) R.string.week_abbreviation_wednesday), Integer.valueOf((int) R.string.week_abbreviation_thursday), Integer.valueOf((int) R.string.week_abbreviation_friday), Integer.valueOf((int) R.string.week_abbreviation_saturday));
        for (int i = 0; i < asList.size(); i++) {
            TextView textView = new TextView(context);
            textView.setTextSize(2, 14.0f);
            textView.setText(((Integer) asList.get(i)).intValue());
            textView.setTextColor(f11626d);
            if (i == 0) {
                addView(textView);
            } else {
                addView(textView, layoutParams);
            }
            this.q.add(textView);
        }
    }

    private void b(int i, boolean z) {
        this.q.get(i).setTextColor(z ? f11625c : f11626d);
    }

    public int getWeekdayTime() {
        return this.f11627f;
    }

    public void setWeekdayTime(int i) {
        this.f11627f = i;
        for (int i2 = 0; i2 < 7; i2++) {
            boolean z = true;
            if (((1 << i2) & i) <= 0) {
                z = false;
            }
            b(i2, z);
        }
    }

    public WeekdayView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public WeekdayView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
