package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public abstract class DialogMusicRhythmPowerModeSettingSheetBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f6804c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final SeekBar f6805d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final RecyclerView f6806f;
    @NonNull
    public final TextView q;
    @NonNull
    public final TextView x;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogMusicRhythmPowerModeSettingSheetBinding(Object obj, View view, int i, ImageView imageView, SeekBar seekBar, RecyclerView recyclerView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f6804c = imageView;
        this.f6805d = seekBar;
        this.f6806f = recyclerView;
        this.q = textView;
        this.x = textView2;
    }
}
