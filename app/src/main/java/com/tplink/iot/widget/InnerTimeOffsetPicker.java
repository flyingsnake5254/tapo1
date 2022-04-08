package com.tplink.iot.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tplink.iot.R;

/* loaded from: classes3.dex */
public class InnerTimeOffsetPicker extends LinearLayout {

    /* renamed from: c  reason: collision with root package name */
    private NumberPickerView f11543c;

    /* renamed from: d  reason: collision with root package name */
    private NumberPickerView f11544d;

    /* renamed from: f  reason: collision with root package name */
    private NumberPickerView f11545f;
    private Context q;
    private boolean x;

    public InnerTimeOffsetPicker(Context context) {
        this(context, null);
    }

    public void a(int i, boolean z) {
        int i2;
        int i3;
        b(z);
        if (i != 0) {
            int abs = Math.abs(i);
            if (this.x) {
                i3 = (abs / 60) % 60;
                i2 = abs % 60;
            } else {
                i3 = (abs / 60) % 6;
                i2 = abs % 60;
                this.f11543c.setValue(i < 0 ? 0 : 1);
            }
            this.f11544d.setValue(i3);
            this.f11545f.setValue(i2);
        }
    }

    public void b(boolean z) {
        this.x = z;
        this.f11543c.setVisibility(z ? 8 : 0);
        if (this.x) {
            ((TextView) findViewById(R.id.tv_picker_first)).setText(R.string.plug_time_unit_min);
            ((TextView) findViewById(R.id.tv_picker_second)).setText(R.string.plug_time_unit_sec);
            this.f11544d.S(h.f());
            this.f11545f.S(h.i());
            return;
        }
        ((TextView) findViewById(R.id.tv_picker_first)).setText(R.string.plug_time_unit_hrs);
        ((TextView) findViewById(R.id.tv_picker_second)).setText(R.string.plug_time_unit_min);
        this.f11543c.S(h.k(this.q));
        this.f11544d.S(h.j());
        this.f11545f.S(h.f());
    }

    public int getTimeOffset() {
        return ((this.f11543c.getVisibility() == 0 && this.f11543c.getValue() == 0) ? -1 : 1) * ((this.f11544d.getValue() * 60) + this.f11545f.getValue());
    }

    public InnerTimeOffsetPicker(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InnerTimeOffsetPicker(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.x = false;
        LayoutInflater.from(context).inflate(R.layout.common_time_offset_picker, (ViewGroup) this, true);
        this.q = context;
        this.f11543c = (NumberPickerView) findViewById(R.id.offset_picker);
        this.f11544d = (NumberPickerView) findViewById(R.id.hour_picker);
        this.f11545f = (NumberPickerView) findViewById(R.id.min_picker);
        this.f11543c.setWrapSelectorWheel(false);
        this.f11544d.setWrapSelectorWheel(false);
        this.f11545f.setWrapSelectorWheel(false);
    }
}
