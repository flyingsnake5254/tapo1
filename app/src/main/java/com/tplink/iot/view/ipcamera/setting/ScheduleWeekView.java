package com.tplink.iot.view.ipcamera.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.d.q.b.o;
import com.tplink.iot.R;

/* loaded from: classes2.dex */
public class ScheduleWeekView extends LinearLayout {

    /* renamed from: c  reason: collision with root package name */
    TextView[] f9153c;

    /* renamed from: d  reason: collision with root package name */
    int[] f9154d = {R.string.week_abbreviation_sunday, R.string.week_abbreviation_monday, R.string.week_abbreviation_tuesday, R.string.week_abbreviation_wednesday, R.string.week_abbreviation_thursday, R.string.week_abbreviation_friday, R.string.week_abbreviation_saturday};

    /* renamed from: f  reason: collision with root package name */
    int f9155f = 0;
    private b q;
    private boolean[] x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            ScheduleWeekView.this.x[intValue] = !ScheduleWeekView.this.x[intValue];
            if (ScheduleWeekView.this.x[intValue]) {
                ScheduleWeekView scheduleWeekView = ScheduleWeekView.this;
                scheduleWeekView.f9153c[intValue].setBackground(scheduleWeekView.getResources().getDrawable(R.drawable.circle_bg));
                ScheduleWeekView scheduleWeekView2 = ScheduleWeekView.this;
                scheduleWeekView2.f9153c[intValue].setTextColor(scheduleWeekView2.getResources().getColor(R.color.pure_white));
            } else {
                ScheduleWeekView scheduleWeekView3 = ScheduleWeekView.this;
                scheduleWeekView3.f9153c[intValue].setBackground(scheduleWeekView3.getResources().getDrawable(R.drawable.circle_white_bg));
                ScheduleWeekView scheduleWeekView4 = ScheduleWeekView.this;
                scheduleWeekView4.f9153c[intValue].setTextColor(scheduleWeekView4.getResources().getColor(R.color.common_iot_main_blue));
            }
            if (ScheduleWeekView.this.q != null) {
                ScheduleWeekView.this.q.a(intValue, ScheduleWeekView.this.x[intValue]);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(int i, boolean z);
    }

    public ScheduleWeekView(Context context) {
        super(context);
        c(context);
    }

    private void c(Context context) {
        this.f9155f = o.c(context) / 8;
        setOrientation(0);
        this.f9153c = new TextView[7];
        this.x = new boolean[7];
        int i = 0;
        while (true) {
            TextView[] textViewArr = this.f9153c;
            if (i < textViewArr.length) {
                textViewArr[i] = new TextView(context);
                addView(this.f9153c[i]);
                this.x[i] = true;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f9153c[i].getLayoutParams();
                int i2 = this.f9155f;
                layoutParams.width = (i2 / 8) * 7;
                layoutParams.height = (i2 / 8) * 7;
                if (i != 0) {
                    layoutParams.setMargins(i2 / 4, 0, 0, 0);
                }
                this.f9153c[i].setGravity(17);
                this.f9153c[i].setText(this.f9154d[i]);
                this.f9153c[i].setBackground(getResources().getDrawable(R.drawable.circle_bg));
                this.f9153c[i].setTextColor(getResources().getColor(R.color.pure_white));
                this.f9153c[i].setTag(Integer.valueOf(i));
                this.f9153c[i].setTextSize(2, 18.0f);
                this.f9153c[i].setOnClickListener(new a());
                i++;
            } else {
                return;
            }
        }
    }

    public boolean[] getChosenArray() {
        return this.x;
    }

    public void setInitial(boolean[] zArr) {
        if (zArr != null && zArr.length == 7) {
            this.x = zArr;
            for (int i = 0; i < 7; i++) {
                if (zArr[i]) {
                    this.f9153c[i].setBackground(getResources().getDrawable(R.drawable.circle_bg));
                    this.f9153c[i].setTextColor(getResources().getColor(R.color.pure_white));
                } else {
                    this.f9153c[i].setBackground(getResources().getDrawable(R.drawable.circle_white_bg));
                    this.f9153c[i].setTextColor(getResources().getColor(R.color.common_iot_main_blue));
                }
            }
        }
    }

    public void setListener(b bVar) {
        this.q = bVar;
    }

    public ScheduleWeekView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context);
    }

    public ScheduleWeekView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(context);
    }
}
