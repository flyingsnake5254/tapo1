package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.devices.lightstrip.viewmodel.effects.CustomizedEffectsMakeViewModel;
import com.tplink.iot.devices.lightstrip.widget.DiscreteSeekBarTextView;
import com.tplink.iot.devices.lightstrip.widget.multicolorpalette.MultiColorPaletteView;
import com.tplink.iot.widget.BrightnessSeekBar;
import com.tplink.iot.widget.ItemSettingLayout;

/* loaded from: classes2.dex */
public abstract class ActivityCustomizedEffectsMakeBinding extends ViewDataBinding {
    @Bindable
    protected CustomizedEffectsMakeViewModel H3;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final BrightnessSeekBar f6530c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final Button f6531d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final Button f6532f;
    @NonNull
    public final SeekBar p0;
    @NonNull
    public final SeekBar p1;
    @NonNull
    public final TextView p2;
    @Bindable
    protected View.OnClickListener p3;
    @NonNull
    public final DiscreteSeekBarTextView q;
    @NonNull
    public final ItemSettingLayout x;
    @NonNull
    public final MultiColorPaletteView y;
    @NonNull
    public final RecyclerView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityCustomizedEffectsMakeBinding(Object obj, View view, int i, BrightnessSeekBar brightnessSeekBar, Button button, Button button2, DiscreteSeekBarTextView discreteSeekBarTextView, ItemSettingLayout itemSettingLayout, MultiColorPaletteView multiColorPaletteView, RecyclerView recyclerView, SeekBar seekBar, SeekBar seekBar2, TextView textView) {
        super(obj, view, i);
        this.f6530c = brightnessSeekBar;
        this.f6531d = button;
        this.f6532f = button2;
        this.q = discreteSeekBarTextView;
        this.x = itemSettingLayout;
        this.y = multiColorPaletteView;
        this.z = recyclerView;
        this.p0 = seekBar;
        this.p1 = seekBar2;
        this.p2 = textView;
    }

    public abstract void h(@Nullable View.OnClickListener onClickListener);

    public abstract void i(@Nullable CustomizedEffectsMakeViewModel customizedEffectsMakeViewModel);
}
