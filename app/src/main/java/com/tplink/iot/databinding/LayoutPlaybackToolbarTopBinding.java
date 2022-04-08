package com.tplink.iot.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.play.PlaybackMainViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VodViewModel;

/* loaded from: classes2.dex */
public abstract class LayoutPlaybackToolbarTopBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f7286c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f7287d;
    @Bindable

    /* renamed from: f  reason: collision with root package name */
    protected g f7288f;
    @Bindable
    protected VodViewModel q;
    @Bindable
    protected PlaybackMainViewModel x;

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutPlaybackToolbarTopBinding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f7286c = textView;
        this.f7287d = textView2;
    }

    public abstract void h(@Nullable g gVar);

    public abstract void i(@Nullable PlaybackMainViewModel playbackMainViewModel);

    public abstract void l(@Nullable VodViewModel vodViewModel);
}
