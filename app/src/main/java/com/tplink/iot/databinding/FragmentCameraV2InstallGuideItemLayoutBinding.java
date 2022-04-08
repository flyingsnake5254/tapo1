package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraInstallGuideViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;

/* loaded from: classes2.dex */
public abstract class FragmentCameraV2InstallGuideItemLayoutBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f6885c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f6886d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f6887f;
    @Bindable
    protected g p0;
    @NonNull
    public final LinearLayout q;
    @NonNull
    public final TextView x;
    @Bindable
    protected CameraInstallGuideViewModel y;
    @Bindable
    protected CameraOnBoardingViewModel z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentCameraV2InstallGuideItemLayoutBinding(Object obj, View view, int i, TextView textView, TextView textView2, ImageView imageView, LinearLayout linearLayout, TextView textView3) {
        super(obj, view, i);
        this.f6885c = textView;
        this.f6886d = textView2;
        this.f6887f = imageView;
        this.q = linearLayout;
        this.x = textView3;
    }
}
