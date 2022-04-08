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
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.ResetCameraViewModel;

/* loaded from: classes2.dex */
public abstract class FragmentCameraV2ResetBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Button f6930c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f6931d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f6932f;
    @Bindable
    protected g p0;
    @NonNull
    public final TextView q;
    @NonNull
    public final Toolbar x;
    @Bindable
    protected ResetCameraViewModel y;
    @Bindable
    protected CameraOnBoardingViewModel z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentCameraV2ResetBinding(Object obj, View view, int i, Button button, ImageView imageView, LinearLayout linearLayout, TextView textView, Toolbar toolbar) {
        super(obj, view, i);
        this.f6930c = button;
        this.f6931d = imageView;
        this.f6932f = linearLayout;
        this.q = textView;
        this.x = toolbar;
    }
}
