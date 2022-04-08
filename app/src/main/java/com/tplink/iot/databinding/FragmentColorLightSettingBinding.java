package com.tplink.iot.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.widget.BrightnessSeekBar;
import com.tplink.iot.widget.colorbulb.ColorPlateWrapView;

/* loaded from: classes2.dex */
public abstract class FragmentColorLightSettingBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final BrightnessSeekBar f6978c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ColorPlateWrapView f6979d;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentColorLightSettingBinding(Object obj, View view, int i, BrightnessSeekBar brightnessSeekBar, ColorPlateWrapView colorPlateWrapView) {
        super(obj, view, i);
        this.f6978c = brightnessSeekBar;
        this.f6979d = colorPlateWrapView;
    }
}
