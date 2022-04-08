package com.tplink.iot.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.UpnpSettingViewModel;
import com.tplink.iot.widget.NoninteractiveCheckBox;

/* loaded from: classes2.dex */
public abstract class ActivityUpnpSettingBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final NoninteractiveCheckBox f6759c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CameraLoadingView f6760d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final View f6761f;
    @NonNull
    public final TextView q;
    @NonNull
    public final TextView x;
    @Bindable
    protected UpnpSettingViewModel y;
    @Bindable
    protected LiveData<Boolean> z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityUpnpSettingBinding(Object obj, View view, int i, NoninteractiveCheckBox noninteractiveCheckBox, CameraLoadingView cameraLoadingView, View view2, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f6759c = noninteractiveCheckBox;
        this.f6760d = cameraLoadingView;
        this.f6761f = view2;
        this.q = textView;
        this.x = textView2;
    }

    public abstract void h(@Nullable UpnpSettingViewModel upnpSettingViewModel);
}
