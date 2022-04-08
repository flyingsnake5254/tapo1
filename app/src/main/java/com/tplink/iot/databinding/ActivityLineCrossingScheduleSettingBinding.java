package com.tplink.iot.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.tplink.iot.view.ipcamera.setting.RecordCustomSettingView;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.LineCrossingScheduleViewModel;

/* loaded from: classes2.dex */
public abstract class ActivityLineCrossingScheduleSettingBinding extends ViewDataBinding {
    @NonNull
    public final Toolbar H3;
    @NonNull
    public final AppBarLayout I3;
    @Bindable
    protected LineCrossingScheduleViewModel J3;
    @Bindable
    protected View.OnClickListener K3;
    @Bindable
    protected RadioGroup.OnCheckedChangeListener L3;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f6612c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CameraLoadingView f6613d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f6614f;
    @NonNull
    public final LinearLayout p0;
    @NonNull
    public final LinearLayout p1;
    @NonNull
    public final LinearLayout p2;
    @NonNull
    public final AppCompatImageView p3;
    @NonNull
    public final TextView q;
    @NonNull
    public final TextView x;
    @NonNull
    public final TextView y;
    @NonNull
    public final RecordCustomSettingView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityLineCrossingScheduleSettingBinding(Object obj, View view, int i, TextView textView, CameraLoadingView cameraLoadingView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, RecordCustomSettingView recordCustomSettingView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, AppCompatImageView appCompatImageView, Toolbar toolbar, AppBarLayout appBarLayout) {
        super(obj, view, i);
        this.f6612c = textView;
        this.f6613d = cameraLoadingView;
        this.f6614f = textView2;
        this.q = textView3;
        this.x = textView4;
        this.y = textView5;
        this.z = recordCustomSettingView;
        this.p0 = linearLayout;
        this.p1 = linearLayout2;
        this.p2 = linearLayout3;
        this.p3 = appCompatImageView;
        this.H3 = toolbar;
        this.I3 = appBarLayout;
    }

    public abstract void h(@Nullable View.OnClickListener onClickListener);

    public abstract void i(@Nullable LineCrossingScheduleViewModel lineCrossingScheduleViewModel);
}
