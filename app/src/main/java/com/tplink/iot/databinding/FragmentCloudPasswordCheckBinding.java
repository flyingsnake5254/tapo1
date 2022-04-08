package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.viewmodel.ipcamera.setting.PasswordSettingViewModel;
import com.tplink.libtpcontrols.materialnormalcompat.edittext.MaterialEditText;

/* loaded from: classes2.dex */
public abstract class FragmentCloudPasswordCheckBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f6969c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final MaterialEditText f6970d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final Button f6971f;
    @NonNull
    public final Toolbar q;
    @NonNull
    public final TextView x;
    @Bindable
    protected PasswordSettingViewModel y;
    @Bindable
    protected View.OnClickListener z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentCloudPasswordCheckBinding(Object obj, View view, int i, TextView textView, MaterialEditText materialEditText, Button button, Toolbar toolbar, TextView textView2) {
        super(obj, view, i);
        this.f6969c = textView;
        this.f6970d = materialEditText;
        this.f6971f = button;
        this.q = toolbar;
        this.x = textView2;
    }

    public abstract void h(@Nullable View.OnClickListener onClickListener);

    public abstract void i(@Nullable PasswordSettingViewModel passwordSettingViewModel);
}
