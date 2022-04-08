package com.tplink.iot.databinding;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

/* loaded from: classes2.dex */
public abstract class DialogMusicRhythmLightStrengthSheetBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final SeekBar f6801c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f6802d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f6803f;
    @NonNull
    public final TextView q;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogMusicRhythmLightStrengthSheetBinding(Object obj, View view, int i, SeekBar seekBar, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f6801c = seekBar;
        this.f6802d = textView;
        this.f6803f = textView2;
        this.q = textView3;
    }
}
