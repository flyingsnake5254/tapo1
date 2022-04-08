package com.tplink.iot.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tplink.iot.R;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.widget.NumberPickerView;

/* loaded from: classes3.dex */
public class InnerTimePicker extends LinearLayout implements NumberPickerView.d {

    /* renamed from: c  reason: collision with root package name */
    private NumberPickerView f11546c;

    /* renamed from: d  reason: collision with root package name */
    private NumberPickerView f11547d;

    /* renamed from: f  reason: collision with root package name */
    private NumberPickerView f11548f;
    private boolean p0;
    private int p1;
    private NumberPickerView q;
    private TextView x;
    private a y;
    private boolean z;

    /* loaded from: classes3.dex */
    public interface a {
        void m();
    }

    public InnerTimePicker(Context context) {
        this(context, null);
    }

    private int b(NumberPickerView numberPickerView) {
        if (this.f11546c.getValue() != 11) {
            return (((numberPickerView.getValue() * 12) + this.f11546c.getValue() + 1) * 60) + this.f11547d.getValue();
        }
        if (numberPickerView.getValue() == 0) {
            return this.f11547d.getValue();
        }
        return this.f11547d.getValue() + 720;
    }

    private void d(Context context) {
        this.z = o0.p(context);
        boolean q = o0.q(context);
        this.p0 = q;
        if (this.z) {
            this.f11548f.setVisibility(8);
            this.q.setVisibility(8);
            this.f11546c.S(h.b());
            this.f11547d.S(h.f());
            return;
        }
        if (q) {
            this.f11548f.setVisibility(0);
            this.q.setVisibility(8);
            this.f11548f.S(h.c());
        } else {
            this.f11548f.setVisibility(8);
            this.q.setVisibility(0);
            this.q.S(h.c());
        }
        this.f11546c.S(h.a());
        this.f11547d.S(h.f());
    }

    @Override // com.tplink.iot.widget.NumberPickerView.d
    public void a(NumberPickerView numberPickerView, int i, int i2) {
        a aVar = this.y;
        if (aVar != null) {
            aVar.m();
        }
    }

    public void c(int i) {
        if (i >= 0) {
            this.p1 = i;
            int i2 = (i / 60) % 24;
            int i3 = i % 60;
            int i4 = i2 < 12 ? 0 : 1;
            if (!this.z) {
                int i5 = i2 % 12;
                i2 = i5 == 0 ? 11 : i5 - 1;
            }
            if (this.p0) {
                this.f11548f.a0(i4);
            } else {
                this.q.a0(i4);
            }
            this.f11546c.a0(i2);
            this.f11547d.a0(i3);
        }
    }

    public int getMinutesOfDay() {
        if (this.z) {
            return (this.f11546c.getValue() * 60) + this.f11547d.getValue();
        }
        if (this.p0) {
            return b(this.f11548f);
        }
        return b(this.q);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            d(getContext());
            setMinuteOfDay(this.p1);
            return;
        }
        this.p1 = getMinutesOfDay();
    }

    public void setMinuteOfDay(int i) {
        if (i >= 0) {
            this.p1 = i;
            int i2 = (i / 60) % 24;
            int i3 = i % 60;
            int i4 = i2 < 12 ? 0 : 1;
            if (!this.z) {
                int i5 = i2 % 12;
                i2 = i5 == 0 ? 11 : i5 - 1;
            }
            if (this.p0) {
                this.f11548f.setValue(i4);
            } else {
                this.q.setValue(i4);
            }
            this.f11546c.setValue(i2);
            this.f11547d.setValue(i3);
        }
    }

    public void setOnTimePickerChangeListener(a aVar) {
        this.y = aVar;
    }

    public InnerTimePicker(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InnerTimePicker(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.z = true;
        this.p1 = 0;
        LayoutInflater.from(context).inflate(R.layout.common_time_picker, (ViewGroup) this, true);
        this.f11546c = (NumberPickerView) findViewById(R.id.hour_picker);
        this.f11547d = (NumberPickerView) findViewById(R.id.min_picker);
        this.f11548f = (NumberPickerView) findViewById(R.id.am_pm_start);
        this.q = (NumberPickerView) findViewById(R.id.am_pm_end);
        this.x = (TextView) findViewById(R.id.tv_space_divider);
        findViewById(R.id.top_operation).setVisibility(8);
        this.f11548f.S(h.c());
        this.q.S(h.c());
        this.f11546c.S(h.b());
        this.f11547d.S(h.f());
        d(context);
        this.f11546c.setWrapSelectorWheel(false);
        this.f11547d.setWrapSelectorWheel(false);
        this.f11548f.setOnValueChangedListener(this);
        this.q.setOnValueChangedListener(this);
        this.f11546c.setOnValueChangedListener(this);
        this.f11547d.setOnValueChangedListener(this);
    }
}
