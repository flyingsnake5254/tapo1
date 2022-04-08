package com.tplink.iot.databinding;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.widget.touchlayout.TouchListenerConstraintLayout;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;

/* loaded from: classes2.dex */
public abstract class DialogVolumeControlBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TouchListenerConstraintLayout f6810c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final SeekBar f6811d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final SeekBar f6812f;
    @NonNull
    public final TextView q;
    @NonNull
    public final TextView x;
    @Bindable
    protected TalkViewModel y;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogVolumeControlBinding(Object obj, View view, int i, TouchListenerConstraintLayout touchListenerConstraintLayout, SeekBar seekBar, SeekBar seekBar2, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f6810c = touchListenerConstraintLayout;
        this.f6811d = seekBar;
        this.f6812f = seekBar2;
        this.q = textView;
        this.x = textView2;
    }

    public abstract void h(@Nullable TalkViewModel talkViewModel);
}
