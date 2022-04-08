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
public abstract class FragmentDevicePasswordCheckBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f6990c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CameraLoadingView f6991d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final MaterialEditText f6992f;
    @Bindable
    protected View.OnClickListener p0;
    @NonNull
    public final Button q;
    @NonNull
    public final Toolbar x;
    @NonNull
    public final TextView y;
    @Bindable
    protected PasswordSettingViewModel z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentDevicePasswordCheckBinding(Object obj, View view, int i, TextView textView, CameraLoadingView cameraLoadingView, MaterialEditText materialEditText, Button button, Toolbar toolbar, TextView textView2) {
        super(obj, view, i);
        this.f6990c = textView;
        this.f6991d = cameraLoadingView;
        this.f6992f = materialEditText;
        this.q = button;
        this.x = toolbar;
        this.y = textView2;
    }

    public abstract void h(@Nullable View.OnClickListener onClickListener);

    public abstract void i(@Nullable PasswordSettingViewModel passwordSettingViewModel);
}
