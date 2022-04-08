package com.tplink.iot.view.ipcamera.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tplink.iot.R;

/* loaded from: classes2.dex */
public class WeekdaySelectedView extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    private Context f9338c;

    /* renamed from: d  reason: collision with root package name */
    private TextView[] f9339d = new TextView[7];

    /* renamed from: f  reason: collision with root package name */
    private TextView f9340f;

    public WeekdaySelectedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9338c = context;
        a();
    }

    private void a() {
        FrameLayout.inflate(this.f9338c, R.layout.layout_weekday_selected_view, this);
        this.f9339d[1] = (TextView) findViewById(R.id.monday);
        this.f9339d[2] = (TextView) findViewById(R.id.tuesday);
        this.f9339d[3] = (TextView) findViewById(R.id.wednesday);
        this.f9339d[4] = (TextView) findViewById(R.id.thursday);
        this.f9339d[5] = (TextView) findViewById(R.id.friday);
        this.f9339d[6] = (TextView) findViewById(R.id.saturday);
        this.f9339d[0] = (TextView) findViewById(R.id.sunday);
        this.f9340f = (TextView) findViewById(R.id.everyday);
    }

    private void setEverydaySelected(boolean z) {
        TextView[] textViewArr = this.f9339d;
        int length = textViewArr.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = 8;
            if (i2 >= length) {
                break;
            }
            TextView textView = textViewArr[i2];
            if (!z) {
                i3 = 0;
            }
            textView.setVisibility(i3);
            i2++;
        }
        TextView textView2 = this.f9340f;
        if (!z) {
            i = 8;
        }
        textView2.setVisibility(i);
    }

    public void setDays(boolean[] zArr) {
        if (zArr != null && zArr.length == 7) {
            boolean z = true;
            for (int i = 0; i < zArr.length; i++) {
                this.f9339d[i].setTextColor(zArr[i] ? -13421773 : 1295990591);
                if (!zArr[i]) {
                    z = false;
                }
            }
            setEverydaySelected(z);
        }
    }
}
