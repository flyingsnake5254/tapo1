package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraInstallPreviewViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.widget.cameralive.VideoSurfaceViewLayout;
import io.reactivex.m0.d;

/* loaded from: classes2.dex */
public abstract class FragmentCameraV2InstallPreviewBinding extends ViewDataBinding {
    @Bindable
    protected d<Integer> H3;
    @Bindable
    protected String I3;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f6894c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f6895d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f6896f;
    @NonNull
    public final VideoSurfaceViewLayout p0;
    @Bindable
    protected CameraInstallPreviewViewModel p1;
    @Bindable
    protected CameraOnBoardingViewModel p2;
    @Bindable
    protected g p3;
    @NonNull
    public final ImageView q;
    @NonNull
    public final Toolbar x;
    @NonNull
    public final TextView y;
    @NonNull
    public final TextView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentCameraV2InstallPreviewBinding(Object obj, View view, int i, TextView textView, TextView textView2, LinearLayout linearLayout, ImageView imageView, Toolbar toolbar, TextView textView3, TextView textView4, VideoSurfaceViewLayout videoSurfaceViewLayout) {
        super(obj, view, i);
        this.f6894c = textView;
        this.f6895d = textView2;
        this.f6896f = linearLayout;
        this.q = imageView;
        this.x = toolbar;
        this.y = textView3;
        this.z = textView4;
        this.p0 = videoSurfaceViewLayout;
    }

    public abstract void h(@Nullable d<Integer> dVar);

    public abstract void i(@Nullable String str);
}
