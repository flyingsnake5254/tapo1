package com.tplink.iot.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.DeviceDetailInfoViewModel;

/* loaded from: classes2.dex */
public abstract class ActivityDeviceDetailInfoNewIpcBinding extends ViewDataBinding {
    @NonNull
    public final RelativeLayout H3;
    @NonNull
    public final TextView I3;
    @NonNull
    public final ImageView J3;
    @NonNull
    public final RelativeLayout K3;
    @NonNull
    public final TextView L3;
    @NonNull
    public final TextView M3;
    @NonNull
    public final CameraLoadingView N3;
    @NonNull
    public final RelativeLayout O3;
    @NonNull
    public final TextView P3;
    @NonNull
    public final TextView Q3;
    @NonNull
    public final LinearLayout R3;
    @NonNull
    public final TextView S3;
    @NonNull
    public final TextView T3;
    @NonNull
    public final FrameLayout U3;
    @NonNull
    public final Toolbar V3;
    @NonNull
    public final TextView W3;
    @NonNull
    public final RelativeLayout X3;
    @NonNull
    public final TextView Y3;
    @Bindable
    protected DeviceDetailInfoViewModel Z3;
    @Bindable
    protected View.OnClickListener a4;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f6542c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final RelativeLayout f6543d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f6544f;
    @NonNull
    public final TextView p0;
    @NonNull
    public final RelativeLayout p1;
    @NonNull
    public final TextView p2;
    @NonNull
    public final TextView p3;
    @NonNull
    public final ImageView q;
    @NonNull
    public final TextView x;
    @NonNull
    public final TextView y;
    @NonNull
    public final ImageView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityDeviceDetailInfoNewIpcBinding(Object obj, View view, int i, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2, ImageView imageView2, TextView textView3, RelativeLayout relativeLayout3, TextView textView4, TextView textView5, RelativeLayout relativeLayout4, TextView textView6, ImageView imageView3, RelativeLayout relativeLayout5, TextView textView7, TextView textView8, CameraLoadingView cameraLoadingView, RelativeLayout relativeLayout6, TextView textView9, TextView textView10, LinearLayout linearLayout2, TextView textView11, TextView textView12, FrameLayout frameLayout, Toolbar toolbar, TextView textView13, RelativeLayout relativeLayout7, TextView textView14) {
        super(obj, view, i);
        this.f6542c = relativeLayout;
        this.f6543d = relativeLayout2;
        this.f6544f = linearLayout;
        this.q = imageView;
        this.x = textView;
        this.y = textView2;
        this.z = imageView2;
        this.p0 = textView3;
        this.p1 = relativeLayout3;
        this.p2 = textView4;
        this.p3 = textView5;
        this.H3 = relativeLayout4;
        this.I3 = textView6;
        this.J3 = imageView3;
        this.K3 = relativeLayout5;
        this.L3 = textView7;
        this.M3 = textView8;
        this.N3 = cameraLoadingView;
        this.O3 = relativeLayout6;
        this.P3 = textView9;
        this.Q3 = textView10;
        this.R3 = linearLayout2;
        this.S3 = textView11;
        this.T3 = textView12;
        this.U3 = frameLayout;
        this.V3 = toolbar;
        this.W3 = textView13;
        this.X3 = relativeLayout7;
        this.Y3 = textView14;
    }

    public abstract void h(@Nullable View.OnClickListener onClickListener);

    public abstract void i(@Nullable DeviceDetailInfoViewModel deviceDetailInfoViewModel);
}
