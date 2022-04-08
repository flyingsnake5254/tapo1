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
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraBeforeInstallViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;

/* loaded from: classes2.dex */
public abstract class FragmentCameraV2BeforeInstallBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Button f6852c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f6853d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f6854f;
    @Bindable
    protected CameraBeforeInstallViewModel p0;
    @Bindable
    protected CameraOnBoardingViewModel p1;
    @Bindable
    protected g p2;
    @NonNull
    public final ImageView q;
    @NonNull
    public final Toolbar x;
    @NonNull
    public final TextView y;
    @NonNull
    public final TextView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentCameraV2BeforeInstallBinding(Object obj, View view, int i, Button button, ImageView imageView, LinearLayout linearLayout, ImageView imageView2, Toolbar toolbar, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f6852c = button;
        this.f6853d = imageView;
        this.f6854f = linearLayout;
        this.q = imageView2;
        this.x = toolbar;
        this.y = textView;
        this.z = textView2;
    }
}
