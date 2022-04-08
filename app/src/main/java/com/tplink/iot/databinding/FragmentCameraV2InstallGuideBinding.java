package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraInstallGuideViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;

/* loaded from: classes2.dex */
public abstract class FragmentCameraV2InstallGuideBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f6882c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f6883d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f6884f;
    @Bindable
    protected g p0;
    @NonNull
    public final Toolbar q;
    @NonNull
    public final Button x;
    @Bindable
    protected CameraInstallGuideViewModel y;
    @Bindable
    protected CameraOnBoardingViewModel z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentCameraV2InstallGuideBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, ImageView imageView, Toolbar toolbar, Button button) {
        super(obj, view, i);
        this.f6882c = textView;
        this.f6883d = linearLayout;
        this.f6884f = imageView;
        this.q = toolbar;
        this.x = button;
    }
}
