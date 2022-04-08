package com.tplink.iot.databinding;

import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.SeekBarBindingAdapter;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.play.ModeDetectionSettingsViewModel;

/* loaded from: classes2.dex */
public abstract class ActivityModeDetectSettingBinding extends ViewDataBinding {
    @NonNull
    public final CheckBox H3;
    @NonNull
    public final RelativeLayout I3;
    @NonNull
    public final TextView J3;
    @NonNull
    public final TextView K3;
    @NonNull
    public final TextView L3;
    @Bindable
    protected ModeDetectionSettingsViewModel M3;
    @Bindable
    protected View.OnClickListener N3;
    @Bindable
    protected SeekBarBindingAdapter.OnStopTrackingTouch O3;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f6624c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final RelativeLayout f6625d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f6626f;
    @NonNull
    public final LinearLayout p0;
    @NonNull
    public final LinearLayout p1;
    @NonNull
    public final Toolbar p2;
    @NonNull
    public final LinearLayout p3;
    @NonNull
    public final TextView q;
    @NonNull
    public final CameraLoadingView x;
    @NonNull
    public final LinearLayout y;
    @NonNull
    public final LinearLayout z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityModeDetectSettingBinding(Object obj, View view, int i, LinearLayout linearLayout, RelativeLayout relativeLayout, TextView textView, TextView textView2, CameraLoadingView cameraLoadingView, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, Toolbar toolbar, LinearLayout linearLayout6, CheckBox checkBox, RelativeLayout relativeLayout2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.f6624c = linearLayout;
        this.f6625d = relativeLayout;
        this.f6626f = textView;
        this.q = textView2;
        this.x = cameraLoadingView;
        this.y = linearLayout2;
        this.z = linearLayout3;
        this.p0 = linearLayout4;
        this.p1 = linearLayout5;
        this.p2 = toolbar;
        this.p3 = linearLayout6;
        this.H3 = checkBox;
        this.I3 = relativeLayout2;
        this.J3 = textView3;
        this.K3 = textView4;
        this.L3 = textView5;
    }

    public abstract void h(@Nullable View.OnClickListener onClickListener);

    public abstract void i(@Nullable ModeDetectionSettingsViewModel modeDetectionSettingsViewModel);
}
