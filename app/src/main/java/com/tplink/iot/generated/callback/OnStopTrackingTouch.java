package com.tplink.iot.generated.callback;

import android.widget.SeekBar;
import androidx.databinding.adapters.SeekBarBindingAdapter;

/* loaded from: classes2.dex */
public final class OnStopTrackingTouch implements SeekBarBindingAdapter.OnStopTrackingTouch {

    /* renamed from: c  reason: collision with root package name */
    final a f7960c;

    /* renamed from: d  reason: collision with root package name */
    final int f7961d;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i, SeekBar seekBar);
    }

    public OnStopTrackingTouch(a aVar, int i) {
        this.f7960c = aVar;
        this.f7961d = i;
    }

    @Override // androidx.databinding.adapters.SeekBarBindingAdapter.OnStopTrackingTouch
    public void onStopTrackingTouch(SeekBar seekBar) {
        this.f7960c.a(this.f7961d, seekBar);
    }
}
