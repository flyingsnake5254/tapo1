package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.PasswordSettingViewModel;
import com.tplink.libtpcontrols.materialnormalcompat.edittext.MaterialEditText;

/* loaded from: classes2.dex */
public abstract class FragmentDevicePasswordSettingBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CameraLoadingView f6993c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final MaterialEditText f6994d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final Button f6995f;
    @Bindable
    protected View.OnClickListener p0;
    @NonNull
    public final TextView q;
    @NonNull
    public final Toolbar x;
    @NonNull
    public final MaterialEditText y;
    @Bindable
    protected PasswordSettingViewModel z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentDevicePasswordSettingBinding(Object obj, View view, int i, CameraLoadingView cameraLoadingView, MaterialEditText materialEditText, Button button, TextView textView, Toolbar toolbar, MaterialEditText materialEditText2) {
        super(obj, view, i);
        this.f6993c = cameraLoadingView;
        this.f6994d = materialEditText;
        this.f6995f = button;
        this.q = textView;
        this.x = toolbar;
        this.y = materialEditText2;
    }

    public abstract void h(@Nullable View.OnClickListener onClickListener);

    public abstract void i(@Nullable PasswordSettingViewModel passwordSettingViewModel);
}
