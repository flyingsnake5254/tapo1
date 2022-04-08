package com.tplink.iot.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tplink.iot.R;
import com.tplink.iot.Utils.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes3.dex */
public class BulbPresetsView extends RadioGroup {

    /* renamed from: c  reason: collision with root package name */
    private c f11485c;

    /* renamed from: d  reason: collision with root package name */
    private List<RadioButton> f11486d;

    /* renamed from: f  reason: collision with root package name */
    private int f11487f;

    /* loaded from: classes3.dex */
    class a implements RadioGroup.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (BulbPresetsView.this.f11485c != null && i != -1 && BulbPresetsView.this.f11487f != -1) {
                try {
                    RadioButton radioButton = (RadioButton) BulbPresetsView.this.findViewById(i);
                    if (radioButton != null && radioButton.getTag() != null) {
                        int intValue = ((Integer) radioButton.getTag()).intValue();
                        BulbPresetsView.this.f11487f = i;
                        BulbPresetsView.this.f11485c.a(intValue);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (BulbPresetsView.this.f11487f == -1) {
                BulbPresetsView.this.f11487f = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements Comparator<Integer> {
        b() {
        }

        /* renamed from: a */
        public int compare(Integer num, Integer num2) {
            return num2.intValue() - num.intValue();
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(int i);
    }

    public BulbPresetsView(Context context) {
        this(context, null);
    }

    private List<Integer> e(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Collections.sort(arrayList);
        return arrayList;
    }

    private List<Integer> f(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Collections.sort(arrayList, new b());
        return arrayList;
    }

    public void d() {
        if (this.f11487f != -1) {
            this.f11487f = -1;
            check(-1);
        }
    }

    public void setOnPresetItemCheckListener(c cVar) {
        this.f11485c = cVar;
    }

    public void setPresets(List<Integer> list) {
        removeAllViews();
        this.f11486d.clear();
        if (list == null || list.isEmpty()) {
            setPadding(0, 0, 0, 0);
            return;
        }
        setPadding(0, k.a(getContext(), 20.0f), 0, 0);
        if (getOrientation() == 1) {
            for (Integer num : f(list)) {
                int intValue = num.intValue();
                RadioButton radioButton = (RadioButton) LayoutInflater.from(getContext()).inflate(R.layout.view_radio_preset_item, (ViewGroup) null);
                radioButton.setText(String.format("%s%%", String.valueOf(intValue)));
                radioButton.setTag(Integer.valueOf(intValue));
                addView(radioButton);
                RadioGroup.LayoutParams layoutParams = (RadioGroup.LayoutParams) radioButton.getLayoutParams();
                layoutParams.bottomMargin = k.a(getContext(), 12.0f);
                radioButton.setLayoutParams(layoutParams);
                this.f11486d.add(radioButton);
            }
            return;
        }
        for (Integer num2 : e(list)) {
            int intValue2 = num2.intValue();
            RadioButton radioButton2 = (RadioButton) LayoutInflater.from(getContext()).inflate(R.layout.view_radio_brightness_preset_horizonal_item, (ViewGroup) null);
            radioButton2.setText(String.format("%s%%", String.valueOf(intValue2)));
            radioButton2.setTag(Integer.valueOf(intValue2));
            addView(radioButton2);
            RadioGroup.LayoutParams layoutParams2 = (RadioGroup.LayoutParams) radioButton2.getLayoutParams();
            layoutParams2.leftMargin = k.a(getContext(), 12.0f);
            radioButton2.setLayoutParams(layoutParams2);
            this.f11486d.add(radioButton2);
        }
    }

    public BulbPresetsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11486d = new ArrayList();
        this.f11487f = 0;
        setOnCheckedChangeListener(new a());
    }
}
