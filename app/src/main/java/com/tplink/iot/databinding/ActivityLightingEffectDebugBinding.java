package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.chip.ChipGroup;
import com.tplink.iot.devices.lightstrip.view.effects.LightingEffectDebugViewModel;

/* loaded from: classes2.dex */
public abstract class ActivityLightingEffectDebugBinding extends ViewDataBinding {
    @NonNull
    public final SeekBar H3;
    @NonNull
    public final SeekBar I3;
    @NonNull
    public final SeekBar J3;
    @NonNull
    public final SeekBar K3;
    @NonNull
    public final SeekBar L3;
    @NonNull
    public final SeekBar M3;
    @NonNull
    public final SeekBar N3;
    @NonNull
    public final AppCompatSpinner O3;
    @NonNull
    public final AppCompatSpinner P3;
    @NonNull
    public final AppCompatSpinner Q3;
    @NonNull
    public final TextView R3;
    @Bindable
    protected View.OnClickListener S3;
    @Bindable
    protected LightingEffectDebugViewModel T3;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Button f6605c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final Button f6606d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final Button f6607f;
    @NonNull
    public final RecyclerView p0;
    @NonNull
    public final RecyclerView p1;
    @NonNull
    public final RecyclerView p2;
    @NonNull
    public final RecyclerView p3;
    @NonNull
    public final Button q;
    @NonNull
    public final Button x;
    @NonNull
    public final Button y;
    @NonNull
    public final ChipGroup z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityLightingEffectDebugBinding(Object obj, View view, int i, Button button, Button button2, Button button3, Button button4, Button button5, Button button6, ChipGroup chipGroup, RecyclerView recyclerView, RecyclerView recyclerView2, RecyclerView recyclerView3, RecyclerView recyclerView4, SeekBar seekBar, SeekBar seekBar2, SeekBar seekBar3, SeekBar seekBar4, SeekBar seekBar5, SeekBar seekBar6, SeekBar seekBar7, AppCompatSpinner appCompatSpinner, AppCompatSpinner appCompatSpinner2, AppCompatSpinner appCompatSpinner3, TextView textView) {
        super(obj, view, i);
        this.f6605c = button;
        this.f6606d = button2;
        this.f6607f = button3;
        this.q = button4;
        this.x = button5;
        this.y = button6;
        this.z = chipGroup;
        this.p0 = recyclerView;
        this.p1 = recyclerView2;
        this.p2 = recyclerView3;
        this.p3 = recyclerView4;
        this.H3 = seekBar;
        this.I3 = seekBar2;
        this.J3 = seekBar3;
        this.K3 = seekBar4;
        this.L3 = seekBar5;
        this.M3 = seekBar6;
        this.N3 = seekBar7;
        this.O3 = appCompatSpinner;
        this.P3 = appCompatSpinner2;
        this.Q3 = appCompatSpinner3;
        this.R3 = textView;
    }

    public abstract void h(@Nullable View.OnClickListener onClickListener);

    public abstract void i(@Nullable LightingEffectDebugViewModel lightingEffectDebugViewModel);
}
