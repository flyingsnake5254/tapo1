package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraSdHintViewModel;
import com.tplink.iot.widget.PointTextView;

/* loaded from: classes2.dex */
public abstract class FragmentCameraV2SdHintBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Button f6942c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f6943d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f6944f;
    @Bindable
    protected CameraSdHintViewModel p0;
    @Bindable
    protected CameraOnBoardingViewModel p1;
    @Bindable
    protected g p2;
    @NonNull
    public final PointTextView q;
    @NonNull
    public final PointTextView x;
    @NonNull
    public final PointTextView y;
    @NonNull
    public final Toolbar z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentCameraV2SdHintBinding(Object obj, View view, int i, Button button, ImageView imageView, LinearLayout linearLayout, PointTextView pointTextView, PointTextView pointTextView2, PointTextView pointTextView3, Toolbar toolbar) {
        super(obj, view, i);
        this.f6942c = button;
        this.f6943d = imageView;
        this.f6944f = linearLayout;
        this.q = pointTextView;
        this.x = pointTextView2;
        this.y = pointTextView3;
        this.z = toolbar;
    }
}
