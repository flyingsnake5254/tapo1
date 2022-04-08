package com.tplink.iot.databinding;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.libtpcontrols.materialnormalcompat.edittext.MaterialEditText;

/* loaded from: classes2.dex */
public abstract class FragmentThermostatControlBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final MaterialEditText f7124c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final RadioGroup f7125d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final RadioButton f7126f;
    @NonNull
    public final RadioButton q;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentThermostatControlBinding(Object obj, View view, int i, MaterialEditText materialEditText, RadioGroup radioGroup, RadioButton radioButton, RadioButton radioButton2) {
        super(obj, view, i);
        this.f7124c = materialEditText;
        this.f7125d = radioGroup;
        this.f7126f = radioButton;
        this.q = radioButton2;
    }
}
