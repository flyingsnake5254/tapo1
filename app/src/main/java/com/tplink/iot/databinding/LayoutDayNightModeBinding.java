package com.tplink.iot.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.play.MultiLiveVideoViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoPlayViewModel;

/* loaded from: classes2.dex */
public abstract class LayoutDayNightModeBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f7229c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f7230d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f7231f;
    @NonNull
    public final TextView q;
    @Bindable
    protected VideoPlayViewModel x;
    @Bindable
    protected g y;
    @Bindable
    protected MultiLiveVideoViewModel z;

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutDayNightModeBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f7229c = linearLayout;
        this.f7230d = textView;
        this.f7231f = textView2;
        this.q = textView3;
    }

    public abstract void h(@Nullable g gVar);

    public abstract void i(@Nullable VideoPlayViewModel videoPlayViewModel);

    public abstract void l(@Nullable MultiLiveVideoViewModel multiLiveVideoViewModel);
}
