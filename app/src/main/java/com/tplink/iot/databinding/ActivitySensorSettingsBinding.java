package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.viewmodel.iotsensor.SensorSettingViewModel;
import com.tplink.iot.widget.ItemSettingLayout;

/* loaded from: classes2.dex */
public abstract class ActivitySensorSettingsBinding extends ViewDataBinding {
    @NonNull
    public final ImageView H3;
    @NonNull
    public final ImageView I3;
    @NonNull
    public final ImageView J3;
    @NonNull
    public final ImageView K3;
    @Bindable
    protected View.OnClickListener L3;
    @Bindable
    protected SensorSettingViewModel M3;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Button f6687c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ConstraintLayout f6688d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final RelativeLayout f6689f;
    @NonNull
    public final RelativeLayout p0;
    @NonNull
    public final ItemSettingLayout p1;
    @NonNull
    public final ItemSettingLayout p2;
    @NonNull
    public final LinearLayout p3;
    @NonNull
    public final ItemSettingLayout q;
    @NonNull
    public final TextView x;
    @NonNull
    public final ItemSettingLayout y;
    @NonNull
    public final ItemSettingLayout z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivitySensorSettingsBinding(Object obj, View view, int i, Button button, ConstraintLayout constraintLayout, RelativeLayout relativeLayout, ItemSettingLayout itemSettingLayout, TextView textView, ItemSettingLayout itemSettingLayout2, ItemSettingLayout itemSettingLayout3, RelativeLayout relativeLayout2, ItemSettingLayout itemSettingLayout4, ItemSettingLayout itemSettingLayout5, LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4) {
        super(obj, view, i);
        this.f6687c = button;
        this.f6688d = constraintLayout;
        this.f6689f = relativeLayout;
        this.q = itemSettingLayout;
        this.x = textView;
        this.y = itemSettingLayout2;
        this.z = itemSettingLayout3;
        this.p0 = relativeLayout2;
        this.p1 = itemSettingLayout4;
        this.p2 = itemSettingLayout5;
        this.p3 = linearLayout;
        this.H3 = imageView;
        this.I3 = imageView2;
        this.J3 = imageView3;
        this.K3 = imageView4;
    }

    public abstract void h(@Nullable View.OnClickListener onClickListener);

    public abstract void i(@Nullable SensorSettingViewModel sensorSettingViewModel);
}
