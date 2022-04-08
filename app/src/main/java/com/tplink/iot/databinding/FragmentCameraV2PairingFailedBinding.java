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
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.PairingFailedViewModel;
import com.tplink.iot.widget.PointTextView;

/* loaded from: classes2.dex */
public abstract class FragmentCameraV2PairingFailedBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Button f6921c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f6922d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f6923f;
    @NonNull
    public final TextView p0;
    @Bindable
    protected PairingFailedViewModel p1;
    @Bindable
    protected CameraOnBoardingViewModel p2;
    @Bindable
    protected g p3;
    @NonNull
    public final PointTextView q;
    @NonNull
    public final PointTextView x;
    @NonNull
    public final PointTextView y;
    @NonNull
    public final Toolbar z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentCameraV2PairingFailedBinding(Object obj, View view, int i, Button button, ImageView imageView, LinearLayout linearLayout, PointTextView pointTextView, PointTextView pointTextView2, PointTextView pointTextView3, Toolbar toolbar, TextView textView) {
        super(obj, view, i);
        this.f6921c = button;
        this.f6922d = imageView;
        this.f6923f = linearLayout;
        this.q = pointTextView;
        this.x = pointTextView2;
        this.y = pointTextView3;
        this.z = toolbar;
        this.p0 = textView;
    }
}
