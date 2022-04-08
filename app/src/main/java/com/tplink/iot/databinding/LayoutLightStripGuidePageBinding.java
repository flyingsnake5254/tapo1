package com.tplink.iot.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.devices.lightstrip.widget.CircleEffectImageView;
import com.tplink.iot.devices.lightstrip.widget.ColorEffectPlateView;
import com.tplink.iot.devices.lightstrip.widget.ColorPaintingRingView;
import com.tplink.iot.devices.lightstrip.widget.SelectableColorPointView;
import com.tplink.iot.widget.WaveView;

/* loaded from: classes2.dex */
public abstract class LayoutLightStripGuidePageBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f7256c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CircleEffectImageView f7257d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ColorEffectPlateView f7258f;
    @NonNull
    public final TextView p0;
    @NonNull
    public final WaveView p1;
    @NonNull
    public final ColorPaintingRingView q;
    @NonNull
    public final RelativeLayout x;
    @NonNull
    public final RelativeLayout y;
    @NonNull
    public final SelectableColorPointView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutLightStripGuidePageBinding(Object obj, View view, int i, TextView textView, CircleEffectImageView circleEffectImageView, ColorEffectPlateView colorEffectPlateView, ColorPaintingRingView colorPaintingRingView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, SelectableColorPointView selectableColorPointView, TextView textView2, WaveView waveView) {
        super(obj, view, i);
        this.f7256c = textView;
        this.f7257d = circleEffectImageView;
        this.f7258f = colorEffectPlateView;
        this.q = colorPaintingRingView;
        this.x = relativeLayout;
        this.y = relativeLayout2;
        this.z = selectableColorPointView;
        this.p0 = textView2;
        this.p1 = waveView;
    }
}
