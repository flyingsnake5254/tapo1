package com.tplink.iot.databinding;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.libtpcontrols.materialnormalcompat.edittext.MaterialEditText;

/* loaded from: classes2.dex */
public abstract class FragmentThermostatTriggerBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final MaterialEditText f7127c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final MaterialEditText f7128d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final RadioGroup f7129f;
    @NonNull
    public final RadioButton q;
    @NonNull
    public final RadioButton x;
    @NonNull
    public final RadioButton y;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentThermostatTriggerBinding(Object obj, View view, int i, MaterialEditText materialEditText, MaterialEditText materialEditText2, RadioGroup radioGroup, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3) {
        super(obj, view, i);
        this.f7127c = materialEditText;
        this.f7128d = materialEditText2;
        this.f7129f = radioGroup;
        this.q = radioButton;
        this.x = radioButton2;
        this.y = radioButton3;
    }
}
