package com.tplink.iot.widget.trv;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tplink.iot.R;
import com.tplink.iot.Utils.k;
import com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.collections.v;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: TemperaturePresetsView.kt */
/* loaded from: classes3.dex */
public final class TemperaturePresetsView extends RadioGroup {

    /* renamed from: c  reason: collision with root package name */
    private b f11842c;

    /* renamed from: d  reason: collision with root package name */
    private final List<RadioButton> f11843d;

    /* renamed from: f  reason: collision with root package name */
    private int f11844f;

    /* compiled from: TemperaturePresetsView.kt */
    /* loaded from: classes3.dex */
    static final class a implements RadioGroup.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public final void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (i != -1 && TemperaturePresetsView.this.f11844f != -1) {
                try {
                    RadioButton radioButton = (RadioButton) TemperaturePresetsView.this.findViewById(i);
                    if (radioButton != null && radioButton.getTag() != null) {
                        Object tag = radioButton.getTag();
                        if (tag != null) {
                            int intValue = ((Integer) tag).intValue();
                            TemperaturePresetsView.this.f11844f = i;
                            b bVar = TemperaturePresetsView.this.f11842c;
                            if (bVar != null) {
                                bVar.a(intValue);
                                return;
                            }
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (TemperaturePresetsView.this.f11844f == -1) {
                TemperaturePresetsView.this.f11844f = 0;
            }
        }
    }

    /* compiled from: TemperaturePresetsView.kt */
    /* loaded from: classes3.dex */
    public interface b {
        void a(int i);
    }

    public TemperaturePresetsView(Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ TemperaturePresetsView(Context context, AttributeSet attributeSet, int i, f fVar) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final void d() {
        if (this.f11844f != -1) {
            this.f11844f = -1;
            check(-1);
        }
    }

    public final void e(List<Integer> list, EnumTemperatureUnit tempUnit) {
        List<Number> M;
        j.e(tempUnit, "tempUnit");
        removeAllViews();
        this.f11843d.clear();
        if (list == null || list.isEmpty()) {
            setPadding(0, 0, 0, 0);
            return;
        }
        setPadding(0, k.a(getContext(), 20.0f), 0, 0);
        M = v.M(list);
        for (Number number : M) {
            int intValue = number.intValue();
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.view_radio_brightness_preset_horizonal_item, (ViewGroup) null);
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.RadioButton");
            RadioButton radioButton = (RadioButton) inflate;
            radioButton.setText(com.tplink.iot.g.d.a.b.d(intValue, tempUnit));
            radioButton.setTag(Integer.valueOf(intValue));
            addView(radioButton);
            ViewGroup.LayoutParams layoutParams = radioButton.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.RadioGroup.LayoutParams");
            RadioGroup.LayoutParams layoutParams2 = (RadioGroup.LayoutParams) layoutParams;
            layoutParams2.leftMargin = k.a(getContext(), 12.0f);
            radioButton.setLayoutParams(layoutParams2);
            this.f11843d.add(radioButton);
        }
    }

    public final void setOnPresetItemCheckListener(b bVar) {
        this.f11842c = bVar;
    }

    public TemperaturePresetsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11843d = new ArrayList();
        setOnCheckedChangeListener(new a());
    }
}
