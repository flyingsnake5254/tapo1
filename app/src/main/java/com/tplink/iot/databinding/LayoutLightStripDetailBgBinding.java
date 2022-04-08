package com.tplink.iot.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.devices.lightstrip.widget.LightStripDetailBgView;
import com.tplink.iot.devices.lightstrip.widget.RippleRevealFrameLayout;

/* loaded from: classes2.dex */
public abstract class LayoutLightStripDetailBgBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final RippleRevealFrameLayout f7247c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final View f7248d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final LightStripDetailBgView f7249f;
    @NonNull
    public final View q;

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutLightStripDetailBgBinding(Object obj, View view, int i, RippleRevealFrameLayout rippleRevealFrameLayout, View view2, LightStripDetailBgView lightStripDetailBgView, View view3) {
        super(obj, view, i);
        this.f7247c = rippleRevealFrameLayout;
        this.f7248d = view2;
        this.f7249f = lightStripDetailBgView;
        this.q = view3;
    }
}
