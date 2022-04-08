package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.TimezoneViewModel;

/* loaded from: classes2.dex */
public abstract class ActivityTimeZoneNewIpcBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CameraLoadingView f6726c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f6727d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f6728f;
    @Bindable
    protected View.OnClickListener p0;
    @NonNull
    public final Button q;
    @NonNull
    public final RecyclerView x;
    @NonNull
    public final Toolbar y;
    @Bindable
    protected TimezoneViewModel z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityTimeZoneNewIpcBinding(Object obj, View view, int i, CameraLoadingView cameraLoadingView, TextView textView, TextView textView2, Button button, RecyclerView recyclerView, Toolbar toolbar) {
        super(obj, view, i);
        this.f6726c = cameraLoadingView;
        this.f6727d = textView;
        this.f6728f = textView2;
        this.q = button;
        this.x = recyclerView;
        this.y = toolbar;
    }

    public abstract void h(@Nullable View.OnClickListener onClickListener);

    public abstract void i(@Nullable TimezoneViewModel timezoneViewModel);
}
