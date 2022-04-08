package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraLocationSetViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;

/* loaded from: classes2.dex */
public abstract class FragmentCameraV2LocationSetBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f6909c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final RelativeLayout f6910d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f6911f;
    @NonNull
    public final Toolbar p0;
    @Bindable
    protected CameraLocationSetViewModel p1;
    @Bindable
    protected CameraOnBoardingViewModel p2;
    @Bindable
    protected g p3;
    @NonNull
    public final RecyclerView q;
    @NonNull
    public final TextView x;
    @NonNull
    public final TextView y;
    @NonNull
    public final Button z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentCameraV2LocationSetBinding(Object obj, View view, int i, ImageView imageView, RelativeLayout relativeLayout, TextView textView, RecyclerView recyclerView, TextView textView2, TextView textView3, Button button, Toolbar toolbar) {
        super(obj, view, i);
        this.f6909c = imageView;
        this.f6910d = relativeLayout;
        this.f6911f = textView;
        this.q = recyclerView;
        this.x = textView2;
        this.y = textView3;
        this.z = button;
        this.p0 = toolbar;
    }
}
