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
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraCompleteViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;

/* loaded from: classes2.dex */
public abstract class FragmentCameraV2CompleteBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Button f6861c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f6862d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f6863f;
    @Bindable
    protected CameraCompleteViewModel p0;
    @Bindable
    protected CameraOnBoardingViewModel p1;
    @Bindable
    protected g p2;
    @NonNull
    public final LinearLayout q;
    @NonNull
    public final Toolbar x;
    @NonNull
    public final TextView y;
    @NonNull
    public final TextView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentCameraV2CompleteBinding(Object obj, View view, int i, Button button, TextView textView, ImageView imageView, LinearLayout linearLayout, Toolbar toolbar, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f6861c = button;
        this.f6862d = textView;
        this.f6863f = imageView;
        this.q = linearLayout;
        this.x = toolbar;
        this.y = textView2;
        this.z = textView3;
    }
}
