package com.tplink.iot.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.devices.lightstrip.widget.LightStripBrightnessController;
import com.tplink.iot.widget.colorbulb.SimpleTextSwitcher;
import com.tplink.libtpcontrols.materialnormalcompat.checkbox.TPCheckboxCompat;

/* loaded from: classes2.dex */
public abstract class LayoutLightStripControllerBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final SimpleTextSwitcher f7244c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TPCheckboxCompat f7245d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final LightStripBrightnessController f7246f;
    @NonNull
    public final TextView q;

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutLightStripControllerBinding(Object obj, View view, int i, SimpleTextSwitcher simpleTextSwitcher, TPCheckboxCompat tPCheckboxCompat, LightStripBrightnessController lightStripBrightnessController, TextView textView) {
        super(obj, view, i);
        this.f7244c = simpleTextSwitcher;
        this.f7245d = tPCheckboxCompat;
        this.f7246f = lightStripBrightnessController;
        this.q = textView;
    }
}
