package com.tplink.iot.databinding;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.SeekBarBindingAdapter;
import androidx.lifecycle.LiveData;
import com.tplink.iot.view.ipcamera.widget.touchlayout.TouchListenerCardView;

/* loaded from: classes2.dex */
public abstract class ViewCloudTerraceControlSensitivityPanelBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TouchListenerCardView f7346c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final SeekBar f7347d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f7348f;
    @NonNull
    public final TextView q;
    @NonNull
    public final TextView x;
    @Bindable
    protected LiveData<Integer> y;
    @Bindable
    protected SeekBarBindingAdapter.OnStopTrackingTouch z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewCloudTerraceControlSensitivityPanelBinding(Object obj, View view, int i, TouchListenerCardView touchListenerCardView, SeekBar seekBar, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f7346c = touchListenerCardView;
        this.f7347d = seekBar;
        this.f7348f = textView;
        this.q = textView2;
        this.x = textView3;
    }

    public abstract void h(@Nullable LiveData<Integer> liveData);

    public abstract void i(@Nullable SeekBarBindingAdapter.OnStopTrackingTouch onStopTrackingTouch);
}
