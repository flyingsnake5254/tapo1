package com.tplink.iot.databinding;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.LdcSettingViewModel;

/* loaded from: classes2.dex */
public abstract class ActivityLdcSettingBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final View f6578c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CheckBox f6579d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final CameraLoadingView f6580f;
    @NonNull
    public final TextView q;
    @NonNull
    public final TextView x;
    @Bindable
    protected LdcSettingViewModel y;
    @Bindable
    protected LiveData<Boolean> z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityLdcSettingBinding(Object obj, View view, int i, View view2, CheckBox checkBox, CameraLoadingView cameraLoadingView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f6578c = view2;
        this.f6579d = checkBox;
        this.f6580f = cameraLoadingView;
        this.q = textView;
        this.x = textView2;
    }

    public abstract void h(@Nullable LdcSettingViewModel ldcSettingViewModel);
}
