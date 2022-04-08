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
import com.tplink.iot.viewmodel.ipcamera.setting.DiagnoseSettingViewModel;

/* loaded from: classes2.dex */
public abstract class ActivityDiagnoseStatusBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final View f6551c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CheckBox f6552d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final CameraLoadingView f6553f;
    @Bindable
    protected LiveData<Boolean> p0;
    @NonNull
    public final TextView q;
    @NonNull
    public final TextView x;
    @NonNull
    public final TextView y;
    @Bindable
    protected DiagnoseSettingViewModel z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityDiagnoseStatusBinding(Object obj, View view, int i, View view2, CheckBox checkBox, CameraLoadingView cameraLoadingView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f6551c = view2;
        this.f6552d = checkBox;
        this.f6553f = cameraLoadingView;
        this.q = textView;
        this.x = textView2;
        this.y = textView3;
    }

    public abstract void h(@Nullable DiagnoseSettingViewModel diagnoseSettingViewModel);
}
