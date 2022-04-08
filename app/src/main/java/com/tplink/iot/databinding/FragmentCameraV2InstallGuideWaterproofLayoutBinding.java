package com.tplink.iot.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraInstallGuideViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;

/* loaded from: classes2.dex */
public abstract class FragmentCameraV2InstallGuideWaterproofLayoutBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f6888c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f6889d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f6890f;
    @Bindable
    protected CameraInstallGuideViewModel p0;
    @Bindable
    protected CameraOnBoardingViewModel p1;
    @Bindable
    protected g p2;
    @NonNull
    public final LinearLayout q;
    @NonNull
    public final LinearLayout x;
    @NonNull
    public final LinearLayout y;
    @NonNull
    public final LinearLayout z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentCameraV2InstallGuideWaterproofLayoutBinding(Object obj, View view, int i, TextView textView, TextView textView2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5) {
        super(obj, view, i);
        this.f6888c = textView;
        this.f6889d = textView2;
        this.f6890f = linearLayout;
        this.q = linearLayout2;
        this.x = linearLayout3;
        this.y = linearLayout4;
        this.z = linearLayout5;
    }
}
