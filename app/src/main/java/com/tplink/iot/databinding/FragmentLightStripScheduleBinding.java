package com.tplink.iot.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.devices.lightstrip.widget.LightingEffectPresetStatusView;

/* loaded from: classes2.dex */
public abstract class FragmentLightStripScheduleBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final LightingEffectPresetStatusView f7029c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final FrameLayout f7030d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final RadioGroup f7031f;
    @NonNull
    public final RadioButton q;
    @NonNull
    public final RadioButton x;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentLightStripScheduleBinding(Object obj, View view, int i, LightingEffectPresetStatusView lightingEffectPresetStatusView, FrameLayout frameLayout, RadioGroup radioGroup, RadioButton radioButton, RadioButton radioButton2) {
        super(obj, view, i);
        this.f7029c = lightingEffectPresetStatusView;
        this.f7030d = frameLayout;
        this.f7031f = radioGroup;
        this.q = radioButton;
        this.x = radioButton2;
    }
}
