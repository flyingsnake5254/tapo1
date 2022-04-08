package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.devicecommon.viewmodel.IoTSettingsBaseViewModel;
import com.tplink.iot.widget.ItemSettingLayout;

/* loaded from: classes2.dex */
public abstract class ActivityBaseIotDeviceSettingsBinding extends ViewDataBinding {
    @NonNull
    public final View H3;
    @NonNull
    public final ImageView I3;
    @NonNull
    public final ImageView J3;
    @NonNull
    public final ImageView K3;
    @Bindable
    protected View.OnClickListener L3;
    @Bindable
    protected IoTSettingsBaseViewModel M3;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Button f6509c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final View f6510d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final FrameLayout f6511f;
    @NonNull
    public final TextView p0;
    @NonNull
    public final ItemSettingLayout p1;
    @NonNull
    public final ItemSettingLayout p2;
    @NonNull
    public final LinearLayout p3;
    @NonNull
    public final FrameLayout q;
    @NonNull
    public final ConstraintLayout x;
    @NonNull
    public final RelativeLayout y;
    @NonNull
    public final ItemSettingLayout z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityBaseIotDeviceSettingsBinding(Object obj, View view, int i, Button button, View view2, FrameLayout frameLayout, FrameLayout frameLayout2, ConstraintLayout constraintLayout, RelativeLayout relativeLayout, ItemSettingLayout itemSettingLayout, TextView textView, ItemSettingLayout itemSettingLayout2, ItemSettingLayout itemSettingLayout3, LinearLayout linearLayout, View view3, ImageView imageView, ImageView imageView2, ImageView imageView3) {
        super(obj, view, i);
        this.f6509c = button;
        this.f6510d = view2;
        this.f6511f = frameLayout;
        this.q = frameLayout2;
        this.x = constraintLayout;
        this.y = relativeLayout;
        this.z = itemSettingLayout;
        this.p0 = textView;
        this.p1 = itemSettingLayout2;
        this.p2 = itemSettingLayout3;
        this.p3 = linearLayout;
        this.H3 = view3;
        this.I3 = imageView;
        this.J3 = imageView2;
        this.K3 = imageView3;
    }

    public abstract void h(@Nullable View.OnClickListener onClickListener);

    public abstract void i(@Nullable IoTSettingsBaseViewModel ioTSettingsBaseViewModel);
}
