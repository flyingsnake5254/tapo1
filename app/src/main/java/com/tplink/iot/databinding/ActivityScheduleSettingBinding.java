package com.tplink.iot.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.tplink.iot.view.ipcamera.setting.RecordCustomSettingView;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.RecordPlanViewModel;

/* loaded from: classes2.dex */
public abstract class ActivityScheduleSettingBinding extends ViewDataBinding {
    @NonNull
    public final LinearLayout H3;
    @NonNull
    public final LinearLayout I3;
    @NonNull
    public final AppCompatImageView J3;
    @NonNull
    public final Toolbar K3;
    @NonNull
    public final AppBarLayout L3;
    @Bindable
    protected RecordPlanViewModel M3;
    @Bindable
    protected View.OnClickListener N3;
    @Bindable
    protected RadioGroup.OnCheckedChangeListener O3;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f6666c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final AppCompatRadioButton f6667d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final AppCompatRadioButton f6668f;
    @NonNull
    public final TextView p0;
    @NonNull
    public final TextView p1;
    @NonNull
    public final RecordCustomSettingView p2;
    @NonNull
    public final LinearLayout p3;
    @NonNull
    public final CameraLoadingView q;
    @NonNull
    public final TextView x;
    @NonNull
    public final TextView y;
    @NonNull
    public final TextView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityScheduleSettingBinding(Object obj, View view, int i, TextView textView, AppCompatRadioButton appCompatRadioButton, AppCompatRadioButton appCompatRadioButton2, CameraLoadingView cameraLoadingView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, RecordCustomSettingView recordCustomSettingView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, AppCompatImageView appCompatImageView, Toolbar toolbar, AppBarLayout appBarLayout) {
        super(obj, view, i);
        this.f6666c = textView;
        this.f6667d = appCompatRadioButton;
        this.f6668f = appCompatRadioButton2;
        this.q = cameraLoadingView;
        this.x = textView2;
        this.y = textView3;
        this.z = textView4;
        this.p0 = textView5;
        this.p1 = textView6;
        this.p2 = recordCustomSettingView;
        this.p3 = linearLayout;
        this.H3 = linearLayout2;
        this.I3 = linearLayout3;
        this.J3 = appCompatImageView;
        this.K3 = toolbar;
        this.L3 = appBarLayout;
    }

    public abstract void h(@Nullable RadioGroup.OnCheckedChangeListener onCheckedChangeListener);

    public abstract void i(@Nullable View.OnClickListener onClickListener);

    public abstract void l(@Nullable RecordPlanViewModel recordPlanViewModel);
}
