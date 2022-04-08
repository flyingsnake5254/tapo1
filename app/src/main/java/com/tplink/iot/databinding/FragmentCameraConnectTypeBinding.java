package com.tplink.iot.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraConnectTypeViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

/* loaded from: classes2.dex */
public abstract class FragmentCameraConnectTypeBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f6843c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final RelativeLayout f6844d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f6845f;
    @NonNull
    public final LinearLayout p0;
    @Bindable
    protected CameraConnectTypeViewModel p1;
    @Bindable
    protected CameraOnBoardingViewModel p2;
    @Bindable
    protected g p3;
    @NonNull
    public final TPRefreshableButton q;
    @NonNull
    public final TextView x;
    @NonNull
    public final Toolbar y;
    @NonNull
    public final LinearLayout z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentCameraConnectTypeBinding(Object obj, View view, int i, TextView textView, RelativeLayout relativeLayout, LinearLayout linearLayout, TPRefreshableButton tPRefreshableButton, TextView textView2, Toolbar toolbar, LinearLayout linearLayout2, LinearLayout linearLayout3) {
        super(obj, view, i);
        this.f6843c = textView;
        this.f6844d = relativeLayout;
        this.f6845f = linearLayout;
        this.q = tPRefreshableButton;
        this.x = textView2;
        this.y = toolbar;
        this.z = linearLayout2;
        this.p0 = linearLayout3;
    }
}
